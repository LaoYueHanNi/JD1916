package com.briup.smarthome.impl;

import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.util.ConfigurationImpl;

public class ServerTest {
	public static void main(String[] args) throws Exception {
		
		Configuration conf=new ConfigurationImpl();
		Server s=conf.getServer();
		DBStore db =conf.getDbStore();
		//DBStore db =conf.getDbStore();
		s.reciver();
//		Server server = new ServerImpl();
//		DBStore dbs = new DbStoreImpl();
//		server.reciver();
		
	}
}
