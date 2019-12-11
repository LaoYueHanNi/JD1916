package common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//定义设置输入值的标准
public interface PrepareSetter {
	public void setter(
				PreparedStatement pst)
			  throws SQLException;
}
