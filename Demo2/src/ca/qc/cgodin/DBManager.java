package ca.qc.cgodin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	// 1 - etablir une connexion
	String connectionString = "jdbc:mysql://";
	String login = "root";
	String pwd = "password2017";
	Connection con = null;
	
	public DBManager() {
		connectionString += "localhost:3306/test_db?useSSL=false&serverTimezone=UTC";
		try {
			con = DriverManager.getConnection(connectionString, login, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Person> getPeople() {
		List<Person> people = null;
		// 2 - déclarer un statement
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3 - executer une requete Select
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM person");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4 - lecture du resultat obtenu
		try {
			while (res.next()) {
				if (people == null) {
					people = new ArrayList<Person>();
				}
				Person p = new Person();
				p.setId(res.getInt("id"));
				p.setName(res.getString("name"));
				p.setAge(res.getInt("age"));

				people.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return people;
	}
	
	
	public void addPerson(Person p) {
		// 2 - déclarer un statement
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3 - executer une requete Select
		try {
			String req = "INSERT INTO person (id, name, age) values ("+
						 p.getId() + 
						 ",'"+
						 p.getName()+
						 "',"+
						 p.getAge()+
						 ")";
			stmt.executeUpdate(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

