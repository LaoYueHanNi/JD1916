package com.briup.common;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Handler {
	public void handler(ResultSet rs) throws SQLException;
}
