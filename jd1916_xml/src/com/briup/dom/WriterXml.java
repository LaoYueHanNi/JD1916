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

//使用dom生成一个xml文件
public class WriterXml {
	public static void main(String[] args) throws Exception{
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		
		Document document=builder.newDocument();
		//创建根节点
		Element root=document.createElement("users");
		for(int i=0;i<3;i++) {
			Element user=document.createElement("user");
			Element name=document.createElement("name");
			Element password=document.createElement("password");
			
			Text nameText=document.createTextNode("briup"+i);
			Text passText=document.createTextNode("123456");
			
			//o创建user的属性节点
			Attr att=document.createAttribute("id");
			att.setNodeValue((1+1)+"");
			
			//追加节点
			root.appendChild(user);
			user.appendChild(name);
			user.appendChild(password);
			name.appendChild(nameText);
			password.appendChild(passText);
			user.setAttributeNode(att);
		}
		//将根节点加到document节点上
		document.appendChild(root);
		
		//将document对象写出到文件中
		//1使用jdk提供的方式
//		TransformerFactory f = TransformerFactory.newInstance();
//		Transformer t = f.newTransformer();
//		Source xmlSource = new DOMSource(document);
//		Result outputTraget = new StreamResult("src/com/briup/dom/test.xml");
//		t.transform(xmlSource, outputTraget);
		
		//2使用第三方提供的方式
//		FileOutputStream out = new FileOutputStream("src/com/briup/dom/a.xml");
//		((org.apache.crimson.tree.XmlDocument)document).write(out);
	}
}
