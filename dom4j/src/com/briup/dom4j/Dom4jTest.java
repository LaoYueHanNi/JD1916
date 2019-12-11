package com.briup.dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//测试Dom4j解析xml文件
public class Dom4jTest {
	public static void main(String[] args) throws DocumentException {
		//1)创建SAXReader对象
		SAXReader saxreader=new SAXReader();
		//2)解析XML文件,转化为Document对象
		Document document = saxreader.read(new File("src/com/briup/dom4j/courses.xml"));
		//3)获取根元素
		Element root = document.getRootElement();
		//获取元素节点的名字
		System.out.println(root.getName());
		//获取元素节点下的子元素
		Element e1 = root.element("courses");
		//获取元素节点的下所有子元素
		List<Element> list = root.elements("course");
		System.out.println(list.size());
		
		int sum=0;
		for(Element temp:list) {
			Element timeEt=temp.element("time");
			
			String str=timeEt.getText();
			sum+=Integer.parseInt(str);
		}
		System.out.println(sum);
		
	}
}
