package com.briup.smarthome.util;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.environment.util.Log;

public class LogImpl implements Log{

	private static Logger logger=Logger.getLogger("log4j.properties");
	
	@Override
	public void init(Properties properties) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(String message) {
		// TODO Auto-generated method stub
		logger.debug(message);
	}

	@Override
	public void info(String message) {
		// TODO Auto-generated method stub
		logger.info(message);
	}

	@Override
	public void warn(String message) {
		// TODO Auto-generated method stub
		logger.warn(message);
	}

	@Override
	public void error(String message) {
		// TODO Auto-generated method stub
		logger.error(message);
	}

	@Override
	public void fatal(String message) {
		// TODO Auto-generated method stub
		logger.fatal(message);
	}

}
