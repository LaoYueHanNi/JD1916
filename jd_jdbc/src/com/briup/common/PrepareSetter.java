package com.briup.common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//���崫������ֵ�ı�׼
public interface PrepareSetter {
	public void setter(PreparedStatement pst) throws SQLException;
		
	
}
