package org.raml.jaxrs.codegen.model;

import com.mulesoft.jaxrs.raml.annotation.model.ClassHierarchyVisitor;
import com.mulesoft.jaxrs.raml.annotation.model.IMethodModel;
import com.mulesoft.jaxrs.raml.annotation.model.IParameterModel;
import com.mulesoft.jaxrs.raml.annotation.model.ITypeModel;
import com.mulesoft.jaxrs.raml.annotation.model.reflection.ReflectionType;
import org.apache.commons.lang.StringUtils;

import java.util.LinkedHashMap;

public class MavenClassHierarchyVisitor extends ClassHierarchyVisitor {
    LinkedHashMap<String,IMethodModel> map = new LinkedHashMap<String,IMethodModel>();
    @Override
    protected boolean checkMethod(IMethodModel method) {
        String key = getKey(method);
        if(!map.containsKey(key)){
            map.put(key, processMethod(method));
        }
        return false;
    }

    private IMethodModel processMethod(IMethodModel method){
        String actualClassName = method.getType().getFullyQualifiedName();
        String returnClassName = method.getReturnedType().getFullyQualifiedName();
        if(!StringUtils.equals(actualClassName,returnClassName)) {
            if(method instanceof MethodModel) {
                MethodModel methodModel = ((MethodModel) method);
                if(methodModel.getJavaType().isArray()) {
                    TypeModel returnedType = (TypeModel)methodModel.getReturnedType();
                    ReflectionType reflectionType = new ReflectionType(methodModel.getJavaType().getComponentType());
                    returnedType.setJavaClass(methodModel.getJavaType().getComponentType());
                    returnedType.setCollection(true);
                    returnedType.setName("array-" + reflectionType.getName());
//                    String name = "array-"+reflectionType.getName();
//                    new PropertyModelImpl(name, reflectionType, false, false, StructureType.COLLECTION,null, Arrays.asList(returnedType.getAnnotations()));
                    methodModel.setReturnedType(returnedType);
                }

            }
        }
        return method;
    }

    private String getKey(IMethodModel method) {
        StringBuilder bld = new StringBuilder(method.getName());
        for(IParameterModel param : method.getParameters()){
            bld.append(";").append(param.getParameterType());
        }
        return bld.toString();
    }
    @Override
    protected boolean visitInterfaces() {
        return false;
    }

    public IMethodModel[] getTargetMethods(){
        return map.values().toArray(new IMethodModel[map.size()]);
    }

    public MavenClassHierarchyVisitor(ITypeModel t){
        visit(t,null);
    }
}
