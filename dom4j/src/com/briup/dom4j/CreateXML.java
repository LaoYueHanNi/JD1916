package com.briup.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;





//使用dom4j写一个xml文件
public class CreateXML {
	public static void main(String[] args) throws IOException {
		Document document = DocumentHelper.createDocument();
		//添加根节点
		Element root=document.addElement("users");
		for(int i=0;i<3;i++) {
			//给Users添加user节点
			Element userEt=root.addElement("User");
			Element nameEt = userEt.addElement("name");
			Element pwdEt = userEt.addElement("pwd");
			
			nameEt.setText("briup"+i);
			pwdEt.setText("123");
			
			userEt.addAttribute("id", i+"");
		}
		//将Document对象写出到xml文件
		XMLWriter writer = new XMLWriter(new FileWriter("xiha.xml"));
		writer.write(document);
		writer.close();
	}

}
