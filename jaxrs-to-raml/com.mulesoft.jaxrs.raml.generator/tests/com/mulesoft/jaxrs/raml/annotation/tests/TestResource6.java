package com.mulesoft.jaxrs.raml.annotation.tests;


import java.io.File;
import java.io.IOException;
import java.net.URL;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import com.mulesoft.jaxrs.raml.annotation.model.FileUtil;
import com.mulesoft.jaxrs.raml.jsonschema.JsonUtil;

public class TestResource6 {
	
	
	@Test
	public void testConvertToXml() throws JSONException, IOException{
		URL url = TestResource6.class.getResource("/country-example.json");
		File jsonFile = new File(url.getFile());
		String json1 = FileUtil.fileToString(jsonFile);
		String xml1 = JsonUtil.convertJsonToXML(json1, "country");
		String json2 = JsonUtil.convertToJSON(xml1, true, false);
		String xml2 = JsonUtil.convertJsonToXML(json2, "country");
		Assert.assertEquals(xml1, xml2);
		Assert.assertTrue(JsonUtil.sameAsJson(new JSONObject(json1),new JSONObject(json2)));
		FileUtils.write(new File(jsonFile.getParentFile(),"country-example.xml"), xml2);
	}
}
