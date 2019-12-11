package com.briup.smarthome.impl;

import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Client;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.Log;
import com.briup.smarthome.util.ConfigurationAware;
import com.briup.smarthome.util.ConfigurationImpl;
import com.briup.smarthome.util.LogImpl;

public class ClientImpl implements Client,ConfigurationAware {
	
	private String ip;
	private int port;
	private Log log ;
	private Configuration conf;
	
	@Override
	public void init(Properties properties) throws Exception {
		// TODO Auto-generated method stub
		ip = (String) properties.get("ip");
		port=Integer.parseInt((String) properties.get("port"));
	}
	
	@Override
	public void send(Collection<Environment> coll) throws Exception {
		Socket socket = null;
		ObjectOutputStream oos = null;
		log=conf.getLogger();

		try {
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			//System.out.println("开始发送");
			log.info("开始发送");
			oos.writeObject(coll);
			//System.out.println("发送完成");
			log.info("发送完成");
			
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null)
				socket.close();
			if (oos != null)
				oos.close();
		}
	}

	private void sleep() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setConfiguration(Configuration conf) {
		this.conf=conf;
		
	}

	
}
