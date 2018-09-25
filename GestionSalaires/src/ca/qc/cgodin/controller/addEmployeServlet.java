package ca.qc.cgodin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.qc.cgodin.model.Employee;
import ca.qc.cgodin.model.EmployeeManager;

/**
 * Servlet implementation class addEmployeServlet
 */
@WebServlet("/addEmployeeServlet")
public class addEmployeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmployeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddEmployee.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empName = request.getParameter("empName");
		double empSalary = Double.parseDouble(request.getParameter("empSalary"));
		String empDepartment = request.getParameter("empDepartment");
			
		Employee employee = new Employee(empName, empSalary, empDepartment);
		try {
			//connexion à la base et ajout d'un nouvel etudiant
			EmployeeManager manager = new EmployeeManager();
			manager.addNewEmployee(employee);
			
			//retour ver la servlet principale Ex3Servlet
			RequestDispatcher rd = request.getRequestDispatcher("/mainServlet");
			rd.forward(request, response);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
