package ca.qc.cgodin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
	String connectionString = "jdbc:mysql://";
	String login = "root";
	String pwd = "password2017";
	Connection con = null;
	
	public ProductManager() {
		connectionString += "localhost:3306/test_db?useSSL=false&serverTimezone=UTC";
		try {
			con = DriverManager.getConnection(connectionString, login, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Product> getProducts(){
		List<Product> products = null;
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet res = null;
		try {
			res = stmt.executeQuery("SELECT * FROM product");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while (res.next()) {
				if (products == null) {
					products = new ArrayList<Product>();
				}
				Product p = new Product();
				p.setNumProd(res.getInt("numProd"));
				p.setNameProd(res.getString("nameProd"));
				p.setPriceProd(res.getDouble("priceProd"));

				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}
	
	public int addProduct(String name, double price) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String request = "INSERT INTO product (nameProd, priceProd) VALUES"+
						"('"+ name + "'," + price + ")";
		
		int affectedRows = 0;
		try {
			affectedRows =  stmt.executeUpdate(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	public int deleteProduct(int id) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String request = "DELETE FROM product  WHERE numProd = "+ id;
		
		int affectedRows = 0;
		try {
			affectedRows =  stmt.executeUpdate(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRows;
	}
	
	public int updateProduct(int id, String name, double price) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String request = "UPDATE product SET nameProd='"+name+"',  priceProd="
						 + price + " WHERE numProd="+ id;
		
		int affectedRows = 0;
		try {
			affectedRows =  stmt.executeUpdate(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return affectedRows;
	}
}
