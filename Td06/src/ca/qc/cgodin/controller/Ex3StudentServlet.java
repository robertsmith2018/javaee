package ca.qc.cgodin.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.qc.cgodin.model.SchoolManager;
import ca.qc.cgodin.model.Student;

/**
 * Servlet implementation class Ex3StudentServlet
 */
@WebServlet("/Ex3StudentServlet")
public class Ex3StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int deptID = Integer.parseInt(request.getParameter("deptID"));
			
			try {
				SchoolManager manager = new SchoolManager();
				List<Student> students = manager.getStudentsByDept(deptID);
				
				//Deleguer l'affichage à une JSP
				request.setAttribute("liste_students", students);
				RequestDispatcher rd = request.getRequestDispatcher("ListStudents.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
