package jdbcdao;

import java.sql.DriverManager;
import java.sql.Connection;

public class Helper {
	
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/orders?serverTimezone=CTT";
	public static final String USER = "root";
	public static final String PASS = "yonex0922810725";
	
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.setAutoCommit(false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
