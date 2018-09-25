package ca.qc.cgodin.controller;

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
 * Servlet implementation class Ex3AddStudentServlet
 */
@WebServlet("/Ex3AddStudentServlet")
public class Ex3AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex3AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//on delegue à une JSP l'affichage d'un formulaire d'ajout d'un etudiant
		RequestDispatcher rd =  request.getRequestDispatcher("AddStudent.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperer les donnees soumises par le formulaire
		String studentName = request.getParameter("studentName");
		int deptID = Integer.parseInt(request.getParameter("deptID"));
		
		Student student = new Student(studentName, deptID);
		try {
			//connexion à la base et ajout d'un nouvel etudiant
			SchoolManager manager = new SchoolManager();
			manager.addNewStudent(student);
			
			//retour ver la servlet principale Ex3Servlet
			RequestDispatcher rd = request.getRequestDispatcher("Ex3Servlet");
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
