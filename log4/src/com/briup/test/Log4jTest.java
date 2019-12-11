package com.briup.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
	
	static {
		PropertyConfigurator.configure("src/com/briup/test/log4j.properties");
		//���ļ�·������Ĭ�ϵ�ʱ��,��Ҫ��̬��ʼ�������ļ�
	}
	private static Logger logger = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		//�ֵȼ���¼��Ϣ
		logger.error("���Ǵ�����Ϣ");//���Լ�¼����������Ϣ
		logger.debug("���ǵ�����Ϣ");
		logger.fatal("����������Ϣ");
		logger.info("������ͨ��Ϣ");
		logger.warn("���Ǿ�����Ϣ");
	}
}
