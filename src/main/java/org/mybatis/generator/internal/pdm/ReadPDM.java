package org.mybatis.generator.internal.pdm;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.test.StartUp;

public class ReadPDM {
	
	private File file;
	private Document document;
	private Element root;
	private Namespace na;
	private Namespace nc;
	private Namespace no;
	
	private String columnName;
	public ReadPDM(){

		try {
			//file = new File(StartUp.class.getResource("/1.pdm").toURI());
			file = new File("");
			//file = new File("./1.pdm");
			//FileReader fileReader = new FileReader(file);
			document = new SAXBuilder().build(file);
			root = document.getRootElement();
			na = root.getNamespace("a");
			nc = root.getNamespace("c");
			no = root.getNamespace("o");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ReadPDM(Configuration configuration){
		try {
			if (configuration != null && configuration.getPdmUrls() != null){
				file = new File(configuration.getPdmUrls().get(0));
				//file = new File("./1.pdm");
				//FileReader fileReader = new FileReader(file);
				document = new SAXBuilder().build(file);
				root = document.getRootElement();
				na = root.getNamespace("a");
				nc = root.getNamespace("c");
				no = root.getNamespace("o");
			}else {
				System.out.println("没有配置读取PDM参数");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getColumnName(String tableName,String columnCode) throws Exception {
		columnName = null;
		Element dbName = document.getRootElement().getChild("RootObject",no)
				.getChild("Children",nc)
				.getChild("Model",no)
				.getChild("Name",na);
		//String DBName = dbName.getText();
		
		List tablelist = XPath.selectNodes(root, "//o:Table[@Id]");
		for (Iterator iterator = tablelist.iterator();iterator.hasNext();) {
			Element tablenode = (Element) iterator.next();
			//如果code等于需要的表明，则进入下一步
			if (tablenode.getChild("Code",na).getText().equals(tableName)) {
				Element columns = tablenode.getChild("Columns", nc);
				
				List aList = columns.getChildren();
				for (int i = 0; i < aList.size(); i++) {
					Element aElement = (Element) aList.get(i);
					if (aElement.getChild("Code",na).getText().equals(columnCode)) {
						columnName = aElement.getChild("Name",na).getText();
					}
					
					/*System.out.println(((Element)aElement.getChildren().get(1)).getText());
					System.out.println(aElement.getChild("Name",na).getText());*/
				}
				/*System.out.println("*************");
				
				System.out.println(columns.getChild("Column"));*/
			}
		}
		return columnName;
	}
}
