package common;

import java.sql.ResultSet;
import java.sql.SQLException;

//定义处理结果集的标准
public interface Handler {
	public void handler(ResultSet  rs)
			throws SQLException;
}
