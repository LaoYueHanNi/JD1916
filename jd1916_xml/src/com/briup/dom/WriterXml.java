package com.briup.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

//ʹ��dom����һ��xml�ļ�
public class WriterXml {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		Document document=builder.newDocument();
		//�������ڵ�
		Element root=document.createElement("users");
		for(int i=0;i<3;i++) {
			Element user=document.createElement("user");
			Element name=document.createElement("name");
			Element password=document.createElement("password");
			
			Text nameText=document.createTextNode("briup"+i);
			Text passText=document.createTextNode("123456");
			
			//o����user�����Խڵ�
			Attr att=document.createAttribute("id");
			att.setNodeValue((1+1)+"");
			
			//׷�ӽڵ�
			root.appendChild(user);
			user.appendChild(name);
			user.appendChild(password);
			name.appendChild(nameText);
			password.appendChild(passText);
			user.setAttributeNode(att);
		}
		//�����ڵ�ӵ�document�ڵ���
		document.appendChild(root);
		
		//��document����д�����ļ���
		//1ʹ��jdk�ṩ�ķ�ʽ
//		TransformerFactory f = TransformerFactory.newInstance();
//		Transformer t = f.newTransformer();
//		Source xmlSource = new DOMSource(document);
//		Result outputTraget = new StreamResult("src/com/briup/dom/test.xml");
//		t.transform(xmlSource, outputTraget);
		
		//2ʹ�õ������ṩ�ķ�ʽ
//		FileOutputStream out = new FileOutputStream("src/com/briup/dom/a.xml");
//		((org.apache.crimson.tree.XmlDocument)document).write(out);
	}
}
