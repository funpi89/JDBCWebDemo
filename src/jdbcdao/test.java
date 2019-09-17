package jdbcdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class test {
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/orders?serverTimezone=UTC";
	public static final String USER = "root";
	public static final String PASS = "yonex0922810725";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String lastname = "haha";
		String firstname = "papa";
		String birthdate = "1992/09/21";
		
		birthdate = birthdate.replace("/", "-");
		Date date = Date.valueOf(birthdate);
		
		EmployeesDAO dao = new EmployeesDAO();
		dao.insert(lastname, firstname, date);
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql = "select * from employees";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("employeeid");
				String last_name = rs.getString("lastname");
				System.out.println(id+","+last_name);
			}
					
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
		}
	  }
		
		
		
	}

}
