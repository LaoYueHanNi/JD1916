package com.briup.smarthome.impl;

import java.sql.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.environment.bean.Environment;
import com.briup.environment.client.Gather;
import com.briup.environment.server.DBStore;
import com.briup.environment.util.Configuration;
import com.briup.environment.util.Log;
import com.briup.smarthome.util.ConfigurationAware;
import com.briup.smarthome.util.LogImpl;

public class DbStoreImpl implements DBStore,ConfigurationAware {
	
	private String driver;
	private String url;
	private String user;
	private String pwd;
	private int batchCount;
	private Configuration conf;
	
	private Log log;
	@Override
	public void init(Properties properties) throws Exception {
		driver = (String) properties.get("driver");
		url = (String) properties.get("url");
		user = (String) properties.get("username");
		pwd = (String) properties.get("password");
		batchCount = Integer.parseInt((String)properties.get("batch-size"));
		System.out.println(driver+" "+url+" "+user+" "+pwd+" "+batchCount);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void saveDb(Collection<Environment> coll) throws Exception {
		log=conf.getLogger();
		//Class.forName(driver);
		Class.forName(driver);
		//Connection conn = DriverManager.getConnection(url, user, pwd);
		Connection conn =
				DriverManager.getConnection(
			url,
				user,pwd);
		PreparedStatement pst = null;
		List<Environment> list = (List<Environment>) coll;
		int day = 0;
		int mday =0;
		int j =0;
		Calendar c = Calendar.getInstance();

		try {
			System.out.println(list.size());
			for (int i = 0; i < coll.size(); i++) {
				c.setTime(list.get(i).getGather_date());
				day = c.get(Calendar.DAY_OF_MONTH);
				if(mday!=day) {
					if(pst!=null) {
						pst.executeBatch();
						log.info(day+"号有"+j+"条数据");
						j=0;
						pst.close();
					}
					String sql = "insert into t_detail_" + day + " values(?,?,?,?,?,?,?,?,?)";
					pst = conn.prepareStatement(sql);
					mday=day;
				}

				pst.setString(1, list.get(i).getName());
				pst.setString(2, list.get(i).getSrcId());
				pst.setString(3, list.get(i).getDstId());
				pst.setString(4, list.get(i).getSersorAddress());
				pst.setInt(5, list.get(i).getCount());
				pst.setString(6, list.get(i).getCmd());
				pst.setInt(7, list.get(i).getStatus());
				pst.setFloat(8, list.get(i).getData());
				pst.setTimestamp(9, list.get(i).getGather_date());
				
				pst.addBatch();
				j++;
				if(i%batchCount==0) {
					pst.executeBatch();
				}
//				pst.executeUpdate();
//				pst.close();
			}
			pst.executeBatch();
			pst.close();
//			System.out.println(day+" "+j);
			log.info(day+"号有"+j+"条数据");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setConfiguration(Configuration conf) {
		// TODO Auto-generated method stub
		this.conf=conf;
	}

}
