package com.briup.parsers;

import javax.xml.parsers.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
public class FirstSAX {
	public static void main(String[] args) throws Exception {
		//1获取SAX解析器的工厂对象
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2从工厂对象里获取SAX解析器
		SAXParser parser=factory.newSAXParser();
		//3使用SAX解析器来解析xml文件
		File file=new File("src/com/briup/basic/courses.xml");
		DefaultHandler dh=new MyHand();
		parser.parse(file, dh);
	}
}
//提供DefaultHandler的子类
	class MyHand extends DefaultHandler{
		//开始解析调用一次 
		@Override
		public void startDocument() throws SAXException {
			System.out.println("<?xml version='1.0' encoding='GBK' ?>");
		}
		//解析结束调用一次
		@Override
		public void endDocument() throws SAXException {
			System.out.println();
		}
		//遇到开始标签的时候调用该方法,调用n次
		//Attributes 属性集
		//uri:命名空间的地址    localName:带有前缀的标签名,如果没有命名空间返回空字串    qName:不带前缀的标签名,常用
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			for(int i=0;i<attributes.getLength();i++) {
				String name=attributes.getQName(i);//属性名
				String value=attributes.getValue(i);//属性值
				System.out.println(" "+name+"='"+value+"' ");
			}
			System.out.println("<"+qName+">");
		}
		//遇到结束标签的时候调用该方法
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("</"+qName+">");
		}
		//遇到字符内容的时候调用该方法,char[]放读到的字符,从start开始,读到length个字符
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			new String(ch,start,length);
		}
		@Override
		public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub
			super.ignorableWhitespace(ch, start, length);
		}
		
	}

