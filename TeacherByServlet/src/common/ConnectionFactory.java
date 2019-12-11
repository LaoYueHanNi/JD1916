package common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
//获取Connection对象
public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	//对静态变量初始化
	static {
		Properties p=new Properties();
		try {
			/*p.load(new FileInputStream(
			"src/com/briup/common/db.properties"));*/
			p.load(ConnectionFactory.class
				.getResourceAsStream(
					"db.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		driver=p.getProperty("driver");
		url = p.getProperty("url");
		user = p.getProperty("user");
		password = p.getProperty("password");
	}
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(
				url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"数据库连接失败");
		}
		return conn;
	}
}
