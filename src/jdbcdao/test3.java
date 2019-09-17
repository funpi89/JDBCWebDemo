package jdbcdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


public class test3 {

	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/orders?serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASS = "yonex0922810725";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lastname = "";
		String employeeid = "24";
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		
		if(lastname == "") {
			String sqllastname = "select lastname from employees where employeeid = ?";
			
			try {
				PreparedStatement stmt = conn.prepareStatement(sqllastname);
				stmt.setString(1, employeeid);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					lastname = rs.getString("lastname");
				}
				System.out.println(lastname);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				helper.closeConn(conn);
			}
		}

	}

}
