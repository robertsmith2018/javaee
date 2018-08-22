package ca.qc.cgodin.model;

public class Student {
	private int numStud;
	private String nameStud;
	private int numDept;
	
	/*********Propriété de navigation**********/
	private Department department;
	/******************************************/
	
	public Student() {
	}
	public Student(String nameStud, int numDept) {
		this.nameStud = nameStud;
		this.numDept = numDept;
	}
	public Student(int numStud, String nameStud, int numDept) {
		this.numStud = numStud;
		this.nameStud = nameStud;
		this.numDept = numDept;
	}
	public int getNumStud() {
		return numStud;
	}
	public void setNumStud(int numStud) {
		this.numStud = numStud;
	}
	public String getNameStud() {
		return nameStud;
	}
	public void setNameStud(String nameStud) {
		this.nameStud = nameStud;
	}
	public int getNumDept() {
		return numDept;
	}
	public void setNumDept(int numDept) {
		this.numDept = numDept;
	}
	@Override
	public String toString() {
		return "Student [numStud=" + numStud + ", nameStud=" + nameStud + ", numDept=" + numDept + "]";
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
