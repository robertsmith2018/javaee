import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	String protocole = "jdbc:mysql://";
	String ip;
	String port;
	String nomBase;
	String connectionString ;
	String nomUser="root";
	String pwd;
	
	Connection con;
	
	public DBManager(String ip,String port,String nomBase,String nomUser,String pwd) {
		this.ip=ip;
		this.port=port;
		this.nomBase=nomBase;
		this.pwd=pwd;
		this.connectionString = this.protocole + this.ip+":"+this.port + "/"+this.nomBase;
		
	}
	
	public ResultSet SelectQuery(String requete) {
		ResultSet res = null;
		try {
		con= DriverManager.getConnection(this.connectionString, this.nomUser, this.pwd);
		Statement stm=con.createStatement();
		res = stm.executeQuery(requete);
		
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return res;
	}
	
	public int UpdateQuery(String requete) {
		int res = 0;
		try {
		con= DriverManager.getConnection(this.connectionString, this.nomUser, this.pwd);
		Statement stm=con.createStatement();
		res = stm.executeUpdate(requete);
		
		
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
		return res;
	}
}
