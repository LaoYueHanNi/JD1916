package com.briup.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class WorkTest {
	public static void main(String[] args) throws Exception {
		Student stu=new Student();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		String Path="src/com/briup/dom/student.xml";
		Document document=builder.parse(new File(Path));
	}
}
