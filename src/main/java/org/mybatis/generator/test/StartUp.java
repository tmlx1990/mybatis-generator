package org.mybatis.generator.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
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
		
		List tablelist = XPath.selectNodes(root, "//o:Table[@Id]");
		for (Iterator iterator = tablelist.iterator();iterator.hasNext();) {
			Element tablenode = (Element) iterator.next();
			System.out.println(tablenode.getChild("Code",na).getText());
			System.out.println(tablenode.getChild("Name",na).getText());
			Element columns = tablenode.getChild("Columns", nc);
		
			List aList = columns.getChildren();
			System.out.println("*************");
			for (int i = 0; i < aList.size(); i++) {
				Element aElement = (Element) aList.get(i);
				System.out.println(aElement.getChild("Name",na).getText());
			}
			System.out.println("*************");
			
			
			System.out.println(columns.getChild("Column"));
			System.out.println("1");
		}
		System.out.println(DBName);
		
	}
}