
public class Produit {
	int numProd;
	String nameprod;
	double priceProd;
	
	public Produit() {
		
	}
	public Produit( String nameprod, double priceProd) {
		this.nameprod = nameprod;
		this.priceProd = priceProd;
	}
	public Produit(int numProd, String nameprod, double priceProd) {
		this.numProd = numProd;
		this.nameprod = nameprod;
		this.priceProd = priceProd;
	}
	
	
	public int getNumProd() {
		return numProd;
	}
	public void setNumProd(int numProd) {
		this.numProd = numProd;
	}
	public String getNameprod() {
		return nameprod;
	}
	public void setNameprod(String nameprod) {
		this.nameprod = nameprod;
	}
	public double getPriceProd() {
		return priceProd;
	}
	public void setPriceProd(double priceProd) {
		this.priceProd = priceProd;
	}
	
	
	
	
}
