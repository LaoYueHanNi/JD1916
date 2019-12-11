package com.briup.dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//����Dom4j����xml�ļ�
public class Dom4jTest {
	public static void main(String[] args) throws DocumentException {
		//1)����SAXReader����
		SAXReader saxreader=new SAXReader();
		//2)����XML�ļ�,ת��ΪDocument����
		Document document = saxreader.read(new File("src/com/briup/dom4j/courses.xml"));
		//3)��ȡ��Ԫ��
		Element root = document.getRootElement();
		//��ȡԪ�ؽڵ������
		System.out.println(root.getName());
		//��ȡԪ�ؽڵ��µ���Ԫ��
		Element e1 = root.element("courses");
		//��ȡԪ�ؽڵ����������Ԫ��
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
