package org.raml.jaxrs.codegen.model;

import com.mulesoft.jaxrs.raml.annotation.model.*;
import com.mulesoft.jaxrs.raml.annotation.model.reflection.ReflectionType;
import com.mulesoft.jaxrs.raml.annotation.model.reflection.RuntimeResourceVisitor;
import com.mulesoft.jaxrs.raml.jaxb.JAXBRegistry;
import com.mulesoft.jaxrs.raml.jaxb.JAXBType;
import com.mulesoft.jaxrs.raml.jaxb.SchemaModelBuilder;
import com.mulesoft.jaxrs.raml.jaxb.XMLModelSerializer;
import com.mulesoft.jaxrs.raml.jsonschema.JsonModelSerializer;
import com.mulesoft.jaxrs.raml.jsonschema.JsonSchemaModelSerializer;
import com.mulesoft.jaxrs.raml.jsonschema.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.raml.model.ActionType;
import org.raml.model.Resource;
import org.raml.schema.model.ISchemaType;

import javax.xml.bind.JAXBContext;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>MavenResourceVisitor class.</p>
 *
 * @author kor
 * @version $Id: $Id
 */
public class MavenResourceVisitor extends RuntimeResourceVisitor {

	

	/**
	 * <p>Constructor for MavenResourceVisitor.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @param classLoader a {@link java.lang.ClassLoader} object.
	 * @param config a {@link com.mulesoft.jaxrs.raml.annotation.model.IRamlConfig} object.
	 */
	public MavenResourceVisitor(File outputFile, ClassLoader classLoader,IRamlConfig config) {
		super(outputFile, classLoader,config);
	}

	protected IMethodModel[] extractMethods(ITypeModel t) {
		return new MavenClassHierarchyVisitor(t).getTargetMethods();
	}


	/** {@inheritDoc} */
	@Override
	protected boolean generateXMLSchema(ITypeModel t, StructureType st) {
		try {
			String name = t.getFullyQualifiedName();
			if(name.equals("void")||name.equals("java.lang.Void")){
				return false;
			}
			Class<?> element = null;
			if (t instanceof ReflectionType) {
				element = ((ReflectionType) t).getElement();
			} else if (t.getFullyQualifiedName() != null && classLoader != null) {
				element = classLoader.loadClass(t.getFullyQualifiedName());
			}
			if(element==null){
				return false;
			}
			generateExampleSchema(t, st, element);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	private void generateExampleSchema(ITypeModel t, StructureType st, Class<?> element) {
		JAXBRegistry rs = new JAXBRegistry();
		JAXBType jaxbModel = rs.getJAXBModel(t);
		ISchemaType schemaModel = new SchemaModelBuilder(rs,config).buildSchemaModel(jaxbModel,st);

		if(st == null || st == StructureType.COMMON) {
			try {
				String name = firstLetterToLowerCase(element.getSimpleName());
				JAXBContext jaxbContext = JAXBContext.newInstance(element);
				CustomSchemaOutputResolver sor = new CustomSchemaOutputResolver(name);
				jaxbContext.generateSchema(sor);
				File file = sor.getFile();
				if(file != null){
					String schemaName = getSchemaName(element.getSimpleName(), XML,  StructureType.COMMON);
					spec.getCoreRaml().addGlobalSchema(schemaName, FileUtil.fileToString(file), false, true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		try{
			String jsonSchema = new JsonSchemaModelSerializer().serialize(schemaModel);
			spec.getCoreRaml().addGlobalSchema(getSchemaName(t.getName(),JSON,st), jsonSchema, true, true);
			writeString(jsonSchema, constructFileLocation(t.getName(), SCHEMA, JSON, st));
		} catch(Exception e){
			e.printStackTrace();
		}

		String jsonExample = new JsonModelSerializer().serialize(schemaModel);
		String xmlExample = new XMLModelSerializer().serialize(schemaModel);
		try {
			String[] contents = getExampleContent(element,t.getName(), t.getDocumentation());
			if(StringUtils.isNotEmpty(contents[0])) {
				jsonExample = contents[0];
			}
			writeString(jsonExample, constructFileLocation(t.getName(), EXAMPLE, JSON, st));

			if(StringUtils.isNotEmpty(contents[1])) {
				xmlExample = contents[1];
			}
			writeString(xmlExample, constructFileLocation(t.getName(), EXAMPLE, XML, st));
		} catch(Exception e){
			writeString(jsonExample, constructFileLocation(t.getName(), EXAMPLE, JSON, st));
			writeString(xmlExample, constructFileLocation(t.getName(), EXAMPLE, XML, st));
		}
	}



	protected String[] getExampleContent(Class<?> clazz,String root, String documentation) throws JSONException,ClassNotFoundException {
		if(StringUtils.isNotBlank(documentation)) {
			Iterator<String> it = Arrays.asList(documentation.split("\n")).iterator();
			Pattern start = Pattern.compile("[ \t]?@example[ \t]+");
			while(it.hasNext()) {
				String line = it.next();
				if(StringUtils.isNotBlank(line)) {
					Matcher startMatcher = start.matcher(line);
					String content = "";
					if(line.endsWith("@example")) {
						content = readExampleContent(it, clazz, "").trim();
					}
					if(startMatcher.find()) {
						content = readExampleContent(it, clazz, line.substring(startMatcher.end()).trim()).trim();
					}
					if(StringUtils.isNotEmpty(content)) {
						if (content.startsWith("<")) {
							return new String[]{ JsonUtil.convertToJSON(content, true, false), content};
						} else if (content.startsWith("{") || content.startsWith("[")) {
							return new String[]{JsonUtil.formatJSON(content), JsonUtil.convertJsonToXML(content, root)};
						}
					}
				}
			}
		}
		return new String[]{"",""};
	}

	protected String readExampleContent(Iterator<String> it, Class<?> clazz, String line){
		Pattern end = Pattern.compile("[ \t]?@[a-zA-Z]+[ \t]+");
		String exampleCode = "";
		boolean exampleContent = false;
		while(it.hasNext()) {
			Matcher endMatcher = end.matcher(line);
			if(endMatcher.find()) {
				return exampleCode;
			}
			if (isExamplePath(line)) {
				if (line.startsWith("classpath:")) {
					line = clazz.getResource(line.replace("classpath:", "")).getFile();
				} else if (line.startsWith("file:")) {
					line = line.replace("file:", "");
				}
				File file = new File(line);
				if (file.exists() && file.isFile()) {
					return FileUtil.fileToString(file).trim();
				}
				break;
			} else if (exampleContent || isExampleContent(line)) {
				exampleCode = exampleCode + line +"\n";
				exampleContent = true;
			}
			line = it.next().replaceFirst("(\\s*)\\*(\\s*)","").trim();
		}
		return exampleCode;
	}

	/**
	 * <p>createResourceVisitor.</p>
	 *
	 * @return a {@link com.mulesoft.jaxrs.raml.annotation.model.ResourceVisitor} object.
	 */
	protected ResourceVisitor createResourceVisitor() {
		return new MavenResourceVisitor(outputFile, classLoader,config);
	}


}
