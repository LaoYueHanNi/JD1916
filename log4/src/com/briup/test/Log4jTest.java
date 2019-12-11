package com.briup.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
	
	static {
		PropertyConfigurator.configure("src/com/briup/test/log4j.properties");
		//当文件路径不是默认的时候,需要静态初始化配置文件
	}
	private static Logger logger = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		//分等级记录信息
		logger.error("这是错误信息");//可以记录任意对象的信息
		logger.debug("这是调试信息");
		logger.fatal("这是严重信息");
		logger.info("这是普通信息");
		logger.warn("这是警告信息");
	}
}
