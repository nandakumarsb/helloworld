package com.memorynotfound.mail;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.InputSource;

import freemarker.ext.dom.NodeModel;

public class TemplateManagerTest {

	public static void main(String[] args) throws Exception {
			TemplateManager templateManager = new TemplateManager();

	        String xmlString = new String(Files.readAllBytes(Paths.get("src/main/resources/example.xml")));
	        NodeModel xmlNodeModel = NodeModel.parse(new InputSource(new StringReader(xmlString)));

	        Map<String, Object> data = new HashMap<>();
	        data.put("xml", xmlNodeModel);

	        String json = templateManager.processTemplate("xml2json", data);

	        System.out.println(json);
	}

}
