package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
	String connectionString = "jdbc:mysql://";
	String login = "root";
	String pwd = "password2017";
	Connection con = null;
	
	public EmployeeManager() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		connectionString += "localhost:3306/dbemployee";
		try {
			/*********************************************/
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			/*********************************************/
			con = DriverManager.getConnection(connectionString, login, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//End of the Constructor
	////
	public List<Employee> getEmployees(){
		List<Employee> employees = null;
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM employee");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (res.next()) {
				if (employees == null) {
					employees = new ArrayList<Employee>();
				}
				Employee emp = new Employee();
				emp.setId(res.getInt("id"));
				emp.setName(res.getString("name"));
				emp.setSalary(res.getDouble("salary"));
				emp.setDepartment(res.getString("Department"));
				
				employees.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	public List<Employee> getEmployeesByDept(String dept){
		List<Employee> employees = null;
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM employee WHERE department = '" + dept + "'" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (res.next()) {
				if (employees == null) {
					employees = new ArrayList<Employee>();
				}
				Employee emp = new Employee();
				emp.setId(res.getInt("id"));
				emp.setName(res.getString("name"));
				emp.setSalary(res.getDouble("salary"));
				emp.setDepartment(res.getString("department"));

				employees.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	public void addNewEmployee(Employee employee) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet res = null;
		try {
			String query = "INSERT INTO employee (name, salary, department) VALUES ('";
			query += employee.getName()+ "',";
			query += employee.getSalary()+ ",'";
			query += employee.getDepartment() + "')";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int updateSalaries(double percent) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String request = "UPDATE employee SET salary= salary * " + (1+ percent/100) ;
		
		int affectedRows = 0;
		try {
			affectedRows =  stmt.executeUpdate(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	
	
	
	

} // End of Class EmployeeManager
