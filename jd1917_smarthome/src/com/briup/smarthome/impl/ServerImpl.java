package com.briup.smarthome.impl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

import com.briup.environment.bean.Environment;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.Log;
import com.briup.smarthome.util.ConfigurationAware;
import com.briup.smarthome.util.LogImpl;

public class ServerImpl implements Server,ConfigurationAware {
	
	//private static Logger logger=Logger.getLogger(ServerImpl.class);
	private Configuration conf;
	private Log log ;
	private int port;
	private DBStore db;
	
	@Override
	public void init(Properties properties) throws Exception {
		// TODO Auto-generated method stub
		port=Integer.parseInt((String) properties.get("port"));
	}

	@Override
	public Collection<Environment> reciver() throws Exception {
		
		log=conf.getLogger();
		ServerSocket ss = null;
		Socket socket = null;
		ObjectInputStream ois = null;
		Collection<Environment> coll = null;
		///DBStore db = new DbStoreImpl();
		db = conf.getDbStore();

		try {
			ss = new ServerSocket(port);
			//System.out.println("���������Ѿ�����");
			log.info("��������������");
			while (true) {
				socket = ss.accept();
				ois = new ObjectInputStream(socket.getInputStream());
				coll = (Collection<Environment>) ois.readObject();
				//System.out.println("���ݽ��ܳɹ�");
				log.info("���ݽ��ܳɹ�");
				//System.out.println("��ʼ�������");
				log.info("��ʼ�������");
				db.saveDb(coll);
				//System.out.println("���ݿ�������");
				log.info("���ݿ�������");
			}
		} catch (Exception e) {
			log.error("���ݿ�����ʧ��");
			e.printStackTrace();
		} finally {
			if (ois != null)
				ois.close();
			if (socket != null)
				socket.close();
			if (ss != null)
				ss.close();
		}
	
		return coll;
	}

	@Override
	public void shutdown() {

	}

	@Override
	public void setConfiguration(Configuration conf) {
		// TODO Auto-generated method stub
		this.conf=conf;
	}
}
