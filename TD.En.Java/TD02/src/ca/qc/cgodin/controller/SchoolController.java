package ca.qc.cgodin.controller;

import java.util.*;

import ca.qc.cgodin.model.Department;
import ca.qc.cgodin.model.SchoolManager;

public class SchoolController {
	private SchoolManager db;
	
	public SchoolController() {
		db = new SchoolManager();
	}
	
	public List<Department> getDepartments(){
		return db.getDepartments();
	}
}
