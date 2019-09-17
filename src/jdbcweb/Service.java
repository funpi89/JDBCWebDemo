package jdbcweb;

import java.sql.Date;
import java.util.List;

import jdbcdao.EmployeesDAO;

public class Service {
	
	public void addEmp(String lastname, String firstname, String birthdate) {
		birthdate = birthdate.replace("/", "-");
		Date date = Date.valueOf(birthdate);
		
		EmployeesDAO dao = new EmployeesDAO();
		dao.insert(lastname, firstname, date);
		
	}
	
	public void updateEmp(String employeeid, String lastname, String firstname, String birthdate) {
		Date date;
		if(birthdate == "") {
			date = null;
		}else {
			birthdate = birthdate.replace("/", "-");
			date = Date.valueOf(birthdate);
		}
		
		
		EmployeesDAO dao = new EmployeesDAO();
		dao.update(employeeid, lastname, firstname, date);
		
	}
	
	public void removeEmp(String lastname, String firstname) {
		EmployeesDAO dao = new EmployeesDAO();
		dao.remove(lastname, firstname);
		
	}
	
	public List<String[]> getEmp(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.query(id);
	}
	
	public List<String[]> findAllEmp(){
		
		EmployeesDAO dao = new EmployeesDAO();
		List<String[]> ret = dao.selectAll();
		return ret;
	}

}
