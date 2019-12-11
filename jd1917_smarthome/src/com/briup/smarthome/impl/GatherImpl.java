package com.briup.smarthome.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Gather;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.Log;
import com.briup.smarthome.util.ConfigurationAware;
import com.briup.smarthome.util.LogImpl;

public class GatherImpl implements Gather,ConfigurationAware {

	private Log log;
	private String path;
	private Configuration conf;
	@Override
	public void init(Properties properties) throws Exception {
		path = (String) properties.get("src-file");
	}

	@Override
	
	public Collection<Environment> gather() throws Exception {
		// long start=System.currentTimeMillis();
		log=conf.getLogger();
		String s = null;
		File f = new File(path);
		List<Environment> listEnvir = new ArrayList<Environment>();
		BufferedReader br = new BufferedReader(new FileReader(f));
		//System.out.println("开始采集数据");
		log.info("开始采集数据");
		while ((s = br.readLine()) != null) {
			String name = null;
			float data = 0;
			float data2 = 0;
			String[] str = s.split("\\|");

			if (str[3].contentEquals("16")) {
				data = (((float) Integer.parseInt(str[6].substring(0, 4), 16) * (float) 0.00268127) - (float) 46.85);
				data2 = ((float) Integer.parseInt(str[6].substring(4, 8), 16) * (float) 0.00190735) - (float) 6;
				Environment e1 = new Environment("温度", str[0], str[1], str[2], str[3], Integer.valueOf(str[4]), str[5],
						Integer.valueOf(str[7]), data, new Timestamp(Long.parseLong(str[8])));
				Environment e2 = new Environment("湿度", str[0], str[1], str[2], str[3], Integer.valueOf(str[4]), str[5],
						Integer.valueOf(str[7]), data2, new Timestamp(Long.parseLong(str[8])));

				listEnvir.add(e1);
				listEnvir.add(e2);
			} else {
				if (str[3].contentEquals("256"))
					name = "光照强度";
				if (str[3].contentEquals("1280"))
					name = "二氧化碳";
				data = (float) Integer.parseInt(str[6].substring(0, 4), 16);
				Environment e = new Environment(name, str[0], str[1], str[2], str[3], Integer.valueOf(str[4]), str[5],
						Integer.valueOf(str[7]), data, new Timestamp(Long.parseLong(str[8])));

				listEnvir.add(e);
			}
		}
		//System.out.println("采集到了"+listEnvir.size()+"条数据");
		log.info("采集到了"+listEnvir.size()+"条数据");
		return listEnvir;
	}

	@Override
	public void setConfiguration(Configuration conf) {
		// TODO Auto-generated method stub
		this.conf=conf;
	}
}
