package ca.qc.cgodin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.qc.cgodin.model.Product;
import ca.qc.cgodin.model.ProductManager;

/**
 * Servlet implementation class Ex2Sservlet
 */
@WebServlet("/Ex2Sservlet")
public class Ex2Sservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2Sservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//on recupere la liste des produits
		ProductManager manager = new ProductManager();
		List<Product> products = manager.getProducts();
		
		//placer la liste trouvee dans la request
		request.setAttribute("listeProduits", products);
		
		//on delegue l'affichage à une JSP
		RequestDispatcher rd = request.getRequestDispatcher("Ex2Affichage.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
