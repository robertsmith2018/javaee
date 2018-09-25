package ca.qc.cgodin.view;

import java.util.List;

import ca.qc.cgodin.controller.ProductController;
import ca.qc.cgodin.controller.SchoolController;
import ca.qc.cgodin.model.*;

public class TD02 {

	public static void main(String[] args) {
		/*
		ProductController controller  = new  ProductController();
		List<Product> prods = controller.getProducts();
	
		for(Product p : prods) {
			System.out.println(p);
		}
		*/
		//ajout d'un nouveau produit
		//Product product = new Product("Sumsung S8", 500.00);
		//controller.addProduct(product);
		
		//mise a jour d'un produit
		//Product product = new Product(4, "Sumsung S8 Black", 450.00);
		//controller.updateProduct(product);
		
		//suppression d'un produit
		//controller.deleteProduct(4);
		
		// Test pour Exercice 2
		SchoolController controller = new SchoolController();
		List<Department>  departments = controller.getDepartments();
		//affichage
		for(Department d : departments) {
			System.out.println(d);
			System.out.println(d.getNameDept()+ ": Liste d'etudiants");
			for(Student s : d.getStudents()) {
				System.out.println(s);
			}
			System.out.println();
		}
	}

}
