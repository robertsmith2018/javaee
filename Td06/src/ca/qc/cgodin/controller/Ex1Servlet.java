package ca.qc.cgodin.controller;

import java.io.IOException;
import java.text.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex1Servlet
 */
@WebServlet("/Ex1Servlet")
public class Ex1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("form1.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//on recupere la la date de naissance
		String birthday = request.getParameter("birthday");
		
		//on calcule l'age
		try {
			//on convertit une string en Date
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = formatter.parse(birthday);
			//annee courante - annee de naissance
			int age = getAge(date);
			request.setAttribute("age", age);
			//on delegue l'affichage à une JSP
			RequestDispatcher rd = request.getRequestDispatcher("Ex1Affichage.jsp");
			rd.forward(request, response);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public int getAge(Date dateOfBirth) {
	    Calendar today = Calendar.getInstance();
	    Calendar birthDate = Calendar.getInstance();
	    birthDate.setTime(dateOfBirth);
	    if (birthDate.after(today)) {
	        throw new IllegalArgumentException("You don't exist yet");
	    }
	    int todayYear = today.get(Calendar.YEAR);
	    int birthDateYear = birthDate.get(Calendar.YEAR);
	    int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
	    int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
	    int todayMonth = today.get(Calendar.MONTH);
	    int birthDateMonth = birthDate.get(Calendar.MONTH);
	    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
	    int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
	    int age = todayYear - birthDateYear;

	    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
	    if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)){
	        age--;
	    
	    // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
	    } else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)){
	        age--;
	    }
	    return age;
	}

}
