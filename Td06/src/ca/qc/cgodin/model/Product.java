package ca.qc.cgodin.model;

public class Product {
	private int numProd;
	private String nameProd;
	private double priceProd;
	
	public Product() {
		
	}

	public Product(String nameProd, double priceProd) {
		this.nameProd = nameProd;
		this.priceProd = priceProd;
	}
	
	public Product(int numProd, String nameProd, double priceProd) {
		this.numProd = numProd;
		this.nameProd = nameProd;
		this.priceProd = priceProd;
	}

	public int getNumProd() {
		return numProd;
	}

	public void setNumProd(int numProd) {
		this.numProd = numProd;
	}

	public String getNameProd() {
		return nameProd;
	}

	public void setNameProd(String nameProd) {
		this.nameProd = nameProd;
	}

	public double getPriceProd() {
		return priceProd;
	}

	public void setPriceProd(double priceProd) {
		this.priceProd = priceProd;
	}

	@Override
	public String toString() {
		return "Product [numProd=" + numProd + ", nameProd=" + nameProd + ", priceProd=" + priceProd + "]";
	}
	
	
}
