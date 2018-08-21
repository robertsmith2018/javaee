package ca.qc.cgodin;

import java.sql.*;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {
		DBManager dbManager =  new DBManager();
		List<Person> people = dbManager.getPeople();
		System.out.println("Data before");
		for(Person p : people) {
			System.out.println(p);
		}
		
/*		Person person = new Person(4, "Rabih", 65);
		
		dbManager.addPerson(person);*/
		
		people = dbManager.getPeople();
		System.out.println("Data After");
		for(Person p : people) {
			System.out.println(p);
		}
	}

}
