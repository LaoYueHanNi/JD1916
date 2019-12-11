package com.briup.parsers;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CountTest {
	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		String Path = "src/com/briup/basic/courses.xml";
		parser.parse(new File(Path), new DefaultHandler() {
			int sum=0;
			boolean isFlag=false;
			@Override
			public void startDocument() throws SAXException {
				
			}

			@Override
			public void endDocument() throws SAXException {
				System.out.println("×Ü¿ÎÊ±Îª"+sum);
			}

			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes)
					throws SAXException {
				if("time".equals(qName)) {
					isFlag=true;
				}
				System.out.println(); 
			}

			@Override
			public void endElement(String uri, String localName, String qName) throws SAXException {
			}

			@Override
			public void characters(char[] ch, int start, int length) throws SAXException {
				if(isFlag) {
					String str=new String(ch,start,length);
					sum+=Integer.parseInt(str);
					isFlag=false;
				}
			}
			
		});
	}
}
