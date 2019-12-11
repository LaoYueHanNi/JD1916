package com.briup.parsers;

import javax.xml.parsers.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
public class FirstSAX {
	public static void main(String[] args) throws Exception {
		//1��ȡSAX�������Ĺ�������
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2�ӹ����������ȡSAX������
		SAXParser parser=factory.newSAXParser();
		//3ʹ��SAX������������xml�ļ�
		File file=new File("src/com/briup/basic/courses.xml");
		DefaultHandler dh=new MyHand();
		parser.parse(file, dh);
	}
}
//�ṩDefaultHandler������
	class MyHand extends DefaultHandler{
		//��ʼ��������һ�� 
		@Override
		public void startDocument() throws SAXException {
			System.out.println("<?xml version='1.0' encoding='GBK' ?>");
		}
		//������������һ��
		@Override
		public void endDocument() throws SAXException {
			System.out.println();
		}
		//������ʼ��ǩ��ʱ����ø÷���,����n��
		//Attributes ���Լ�
		//uri:�����ռ�ĵ�ַ    localName:����ǰ׺�ı�ǩ��,���û�������ռ䷵�ؿ��ִ�    qName:����ǰ׺�ı�ǩ��,����
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			for(int i=0;i<attributes.getLength();i++) {
				String name=attributes.getQName(i);//������
				String value=attributes.getValue(i);//����ֵ
				System.out.println(" "+name+"='"+value+"' ");
			}
			System.out.println("<"+qName+">");
		}
		//����������ǩ��ʱ����ø÷���
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("</"+qName+">");
		}
		//�����ַ����ݵ�ʱ����ø÷���,char[]�Ŷ������ַ�,��start��ʼ,����length���ַ�
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

