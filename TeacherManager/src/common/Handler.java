package common;

import java.sql.ResultSet;
import java.sql.SQLException;

//���崦�������ı�׼
public interface Handler {
	public void handler(ResultSet  rs)
			throws SQLException;
}
