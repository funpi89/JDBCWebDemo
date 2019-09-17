package jdbcdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeesDAO dao = new EmployeesDAO();
		List<String[]> tests = dao.selectAll();
		
		for(String[] test : tests) {
			for(String str : test) {
				System.out.print(str+" ");
				
			}
			System.out.println();
		}
	}

}
