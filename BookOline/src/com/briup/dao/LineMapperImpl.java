package com.briup.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.briup.bean.Line;
import com.briup.common.util.ConnectionFactory;

public class LineMapperImpl implements ILineMapper{

	private Connection conn;
	public LineMapperImpl() {
		conn = new ConnectionFactory().getConnection();
	}
	
	@Override
	public void savaLine(Line line) {
		// TODO Auto-generated method stub
		try {
			Statement statement = conn.createStatement();
			String sql = "insert into bl_line values(tbl_line_seq.nextVal,"+line.getNum()+","
						+line.getOrder().getId()+","+line.getBook().getId()+")";
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteLineByOrderId(long orderId) {
		// TODO Auto-generated method stub
		
	}

}
