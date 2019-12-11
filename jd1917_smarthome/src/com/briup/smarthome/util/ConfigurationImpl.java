package com.briup.smarthome.util;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.Log;
import com.briup.environment.util.WossModuleInit;

import javafx.scene.chart.PieChart.Data;

//配置模块,创建其他模块的对象
public class ConfigurationImpl implements Configuration {

	private Map<String, WossModuleInit> map = new HashMap<String, WossModuleInit>();

	public static void main(String[] args) throws DocumentException {
		new ConfigurationImpl();
	}

	public ConfigurationImpl() throws DocumentException {
		// 解析xml文件
		this("src/com/briup/smarthome/util/config.xml");
	}

	public ConfigurationImpl(String path) {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			Element root = document.getRootElement();
	
			List<Element> list = root.elements();
			for (Element temp : list) {
				String clName = temp.attributeValue("class");
				// 通过反射创建对象
				WossModuleInit obj = (WossModuleInit) Class.forName(clName).newInstance();
				map.put(temp.getName(), obj);
				List<Element> pros = temp.elements();
				Properties pro = new Properties();
				for (Element p : pros) {
					pro.put(p.getName(), p.getText());
				}
				obj.init(pro);
			}
			//将配置模块自身的引用(this)
				//注入给其他模块map集合
			for(WossModuleInit woss:map.values()) {
				if(woss instanceof ConfigurationAware) {
					((ConfigurationAware)woss).setConfiguration(this);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Log getLogger() throws Exception {
		// TODO Auto-generated method stub
		return (Log) map.get("logger");
	}

	@Override
	public Server getServer() throws Exception {
		// TODO Auto-generated method stub
		return (Server) map.get("server");
	}

	@Override
	public Client getClient() throws Exception {
		// TODO Auto-generated method stub
		return (Client) map.get("client");
	}

	@Override
	public DBStore getDbStore() throws Exception {
		// TODO Auto-generated method stub
		return (DBStore) map.get("dbstore");
	}

	@Override
	public Gather getGather() throws Exception {
		// TODO Auto-generated method stub
		return (Gather) map.get("gather");
	}

}
