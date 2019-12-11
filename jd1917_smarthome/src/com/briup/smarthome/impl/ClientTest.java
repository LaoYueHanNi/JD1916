package com.briup.smarthome.impl;

import java.util.ArrayList;
import java.util.Collection;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Client;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.server.Server;
import com.briup.environment.util.Configuration;
import com.briup.smarthome.util.ConfigurationImpl;

public class ClientTest {
	public static void main(String[] args) throws Exception {
		
		Configuration conf=new ConfigurationImpl();
		Client c = conf.getClient();
		Gather g = conf.getGather();
		Collection<Environment> coll = g.gather();
		c.send(coll);
		
		
//		Gather g = new GatherImpl();
//		Client client = new ClientImpl();
//		Collection<Environment> coll = null;
//
//		coll = g.gather();
//		client.send(coll);

	}
}
