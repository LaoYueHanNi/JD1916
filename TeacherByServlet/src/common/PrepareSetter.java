package common;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//������������ֵ�ı�׼
public interface PrepareSetter {
	public void setter(
				PreparedStatement pst)
			  throws SQLException;
}
