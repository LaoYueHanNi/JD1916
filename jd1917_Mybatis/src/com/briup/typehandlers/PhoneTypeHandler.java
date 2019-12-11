package com.briup.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.bean.PhoneNumber;

//自定义的类型处理器
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String index) throws SQLException {
		return new PhoneNumber(rs.getString(index));
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int index) throws SQLException {
		return new PhoneNumber(rs.getString(index));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement arg0, int arg1) throws SQLException {
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement pst, int index, PhoneNumber phone, JdbcType arg3)
			throws SQLException {
		pst.setString(index, phone.toString());
	}

}
