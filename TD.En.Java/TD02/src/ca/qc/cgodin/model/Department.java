package ca.qc.cgodin.model;

import java.util.*;

public class Department {
	private int numDept;
	private String nameDept;
	
	/*********Propriété de navigation**********/
	private List<Student> students;
	/******************************************/
	
	public Department() {	
	}
	public Department(String nameDept) {
		this.nameDept = nameDept;
	}
	public Department(int numDept, String nameDept) {
		this.numDept = numDept;
		this.nameDept = nameDept;
	}
	public int getNumDept() {
		return numDept;
	}
	public void setNumDept(int numDept) {
		this.numDept = numDept;
	}
	public String getNameDept() {
		return nameDept;
	}
	public void setNameDept(String nameDept) {
		this.nameDept = nameDept;
	}
	@Override
	public String toString() {
		return "Department [numDept=" + numDept + ", nameDept=" + nameDept + "]";
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
