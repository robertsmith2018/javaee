package ca.qc.cgodin.controller;

import java.util.List;

import ca.qc.cgodin.model.ProductManager;
import ca.qc.cgodin.model.Product;

public class ProductController {
	private ProductManager dbManager;
	
	public ProductController() {
		dbManager = new ProductManager();
	}

	public List<Product> getProducts(){
		return dbManager.getProducts();
	}
	
	public int addProduct(Product p) {
		return dbManager.addProduct(p.getNameProd(), p.getPriceProd());
	}
	
	public int deleteProduct (int id) {
		return dbManager.deleteProduct(id);
	}
	
	
	public int updateProduct(Product p) {
		return dbManager.updateProduct(p.getNumProd(), p.getNameProd(), p.getPriceProd());
	}
}
