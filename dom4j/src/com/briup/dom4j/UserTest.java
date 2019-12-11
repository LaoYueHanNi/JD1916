package com.briup.dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class UserTest {
	public static void main(String[] args) throws DocumentException {
		// 1)创建SAXReader对象
		SAXReader saxreader = new SAXReader();
		// 2)解析XML文件,转化为Document对象
		Document document = saxreader.read(new File("src/com/briup/dom4j/courses.xml"));
		// 3)获取根元素
		Element root = document.getRootElement();
		
		List<Element> list = root.elements("");

	}
}
