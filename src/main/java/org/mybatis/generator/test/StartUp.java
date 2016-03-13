package org.mybatis.generator.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


public class StartUp {
	public static void main(String[] args) throws Exception {
		/*List<String> warnings = new ArrayList<String>();
    	File configFile = new File(StartUp.class.getResource("/generatorConfig.xml").toURI());
    	ConfigurationParser cp = new ConfigurationParser(warnings);
    	Configuration config = cp.parseConfiguration(configFile);
    	DefaultShellCallback shellCallback = new DefaultShellCallback(true);
    	MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
    	myBatisGenerator.generate(null);
    	System.out.println(warnings);*/
		
		//读取指定PDM
		File file = new File(StartUp.class.getResource("/1.pdm").toURI());
		//FileReader fileReader = new FileReader(file);
		Document document = new SAXBuilder().build(file);
		Element root = document.getRootElement();
		Namespace na = root.getNamespace("a");
		Namespace nc = root.getNamespace("c");
		Namespace no = root.getNamespace("o");
		
		Element dbName = document.getRootElement().getChild("RootObject",no)
				.getChild("Children",nc)
				.getChild("Model",no)
				.getChild("Name",na);
		String DBName = dbName.getText();
		System.out.println("1");
	}
}