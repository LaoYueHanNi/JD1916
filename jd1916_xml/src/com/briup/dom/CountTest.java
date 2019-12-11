package com.briup.dom;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CountTest {
	public static void main(String[] args) throws Exception {
		// 获取Dom解析器的工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 从工厂对象中获取DOM解析器对象
		DocumentBuilder builder = factory.newDocumentBuilder();

		String Path = "src/com/briup/basic/courses.xml";
		Document document = builder.parse(new File(Path));

		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		
		NodeList list = document.getElementsByTagName("time");
		// 遍历集合,取出每一个Time的元素节点
		int sum=0;
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			Node text=node.getFirstChild();
			String str=text.getNodeValue();
			System.out.println(str);
			sum+=Integer.parseInt(str);
		}
		System.out.println("总课时为:"+sum);
	}
}
