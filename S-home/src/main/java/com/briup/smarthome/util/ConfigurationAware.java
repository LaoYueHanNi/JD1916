package com.briup.smarthome.util;

import com.briup.environment.util.Configuration;

//提供将配置模块的对象注入给其他模块
public interface ConfigurationAware {
	public void setConfiguration(Configuration conf);
}
