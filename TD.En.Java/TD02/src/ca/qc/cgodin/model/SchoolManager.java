package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SchoolManager {

	String connectionString = "jdbc:mysql://";
	String login = "root";
	String pwd = "password2017";
	Connection con = null;
	
	public SchoolManager() {
		connectionString += "localhost:3306/test_db?useSSL=false&serverTimezone=UTC";
		try {
			con = DriverManager.getConnection(connectionString, login, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//recuperer la liste des d�partments
	public List<Department> getDepartments(){
		List<Department> departments = null;
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM department");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (res.next()) {
				if (departments == null) {
					departments = new ArrayList<Department>();
				}
				Department d = new Department();
				d.setNumDept(res.getInt("numDept"));
				d.setNameDept(res.getString("nameDept"));
				// trouver la liste d'etudiants de ce departement
				d.setStudents(getStudentsByDept(d));
				departments.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departments;
	}
	
	  //recuperer la liste des etudiants pour un deptartement donn�
		public List<Student> getStudentsByDept(Department dept){
			List<Student> students = null;
			
			Statement stmt = null;
			try {
				stmt = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet res = null;
			try {
				res = stmt.executeQuery("SELECT * FROM student WHERE numDept = " + dept.getNumDept());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				while (res.next()) {
					if (students == null) {
						students = new ArrayList<Student>();
					}
					Student s = new Student();
					s.setNumStud(res.getInt("numStud"));
					s.setNameStud(res.getString("nameStud"));
					s.setNumDept(dept.getNumDept());
					s.setDepartment(dept);
					students.add(s);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return students;
		}
}
