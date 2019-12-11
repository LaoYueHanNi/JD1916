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
		// ��ȡDom�������Ĺ�������
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// �ӹ��������л�ȡDOM����������
		DocumentBuilder builder = factory.newDocumentBuilder();

		String Path = "src/com/briup/basic/courses.xml";
		Document document = builder.parse(new File(Path));

		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		
		NodeList list = document.getElementsByTagName("time");
		// ��������,ȡ��ÿһ��Time��Ԫ�ؽڵ�
		int sum=0;
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			Node text=node.getFirstChild();
			String str=text.getNodeValue();
			System.out.println(str);
			sum+=Integer.parseInt(str);
		}
		System.out.println("�ܿ�ʱΪ:"+sum);
	}
}
