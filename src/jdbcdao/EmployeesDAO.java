package jdbcdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class EmployeesDAO {
	
	public void insert(String lastname, String firstname, Date birthDate) {
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		String sql = "insert into employees(lastname,firstname,birthdate) values(?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, lastname);
			stmt.setString(2, firstname);
			stmt.setDate(3, birthDate);
			stmt.execute();
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			helper.closeConn(conn);
		}
	}
	
	public void update(String employeeid, String lastname, String firstname, Date birthDate) {
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
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//helper.closeConn(conn);
			}
		}
		
		if(firstname == "") {
			String sqllastname = "select firstname from employees where employeeid = ?";
			
			try {
				PreparedStatement stmt = conn.prepareStatement(sqllastname);
				stmt.setString(1, employeeid);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					firstname = rs.getString("firstname");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//helper.closeConn(conn);
			}
		}
		
		if(birthDate == null) {
			String sqllastname = "select birthDate from employees where employeeid = ?";
			
			try {
				PreparedStatement stmt = conn.prepareStatement(sqllastname);
				stmt.setString(1, employeeid);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					birthDate = rs.getDate("birthDate");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//helper.closeConn(conn);
			}
		}
		
		
		
		String sql = "update employees set lastname = ? , firstname = ? , birthDate = ?"
				+ "where employeeid = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, lastname);
			stmt.setString(2, firstname);
			stmt.setDate(3, birthDate);
			stmt.setString(4, employeeid);
			stmt.execute();
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			helper.closeConn(conn);
		}
	}
	
	public void remove(String lastname, String firstname) {
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		String sql = "delete from employees where lastname = ? and firstname = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, lastname);
			stmt.setString(2, firstname);
			stmt.execute();
			conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			helper.closeConn(conn);
		}
	}
	
	public List<String[]> query(String id) {
		List<String[]> ret = new ArrayList<String[]>();
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		String sql = "select employeeid,lastname,firstname,birthdate from employees where EmployeeID = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String[] emp = new String[4];
				emp[0] = rs.getString("employeeid");
				emp[1] = rs.getString("lastname");
				emp[2] = rs.getString("firstname");
				
				Date date = rs.getDate("birthdate");
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				String datestr = df.format(date);
				emp[3] = datestr;
				
				ret.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			helper.closeConn(conn);
		}
		return ret;
	}
	
	public List<String[]> selectAll(){
		List<String[]> ret = new ArrayList<String[]>();
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		String sql = "select employeeid,lastname,firstname,birthdate from employees";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String[] emp = new String[4];
				emp[0] = rs.getString("employeeid");
				emp[1] = rs.getString("lastname");
				emp[2] = rs.getString("firstname");
				
				Date date = rs.getDate("birthdate");
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				String datestr = df.format(date);
				emp[3] = datestr;
				
				ret.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			helper.closeConn(conn);
		}
		return ret;
	}

}
