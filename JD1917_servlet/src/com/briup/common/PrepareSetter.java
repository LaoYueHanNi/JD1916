package com.briup.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//定义传入输入值的标准
public interface PrepareSetter {
	public void setter(PreparedStatement pst) throws SQLException;
		
	
}
