
import java.sql.*;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) throws SQLException {

	//********* etablir une connexion
	//****definir variables de connection
		
		String protocole = "jdbc:mysql://";
		String ip="localhost";
		String port="3306";
		String nomBase="test_db?useSSL=false&serverTimezone=UTC";
		String connectionString = protocole + ip + ":" +port + "/" +nomBase;
		String nomUser="root";
		String pwd="password2017";
		
		//*****etablir la connection
		DBManager connection = new DBManager(ip,port,nomBase,nomUser,pwd);

		//This is how to insert a record to database
		
		/*String newValue="insert into person (id,name,age) values ('4','Nanda','18')";
		int nbRows = connection.UpdateQuery(newValue);*/
		
		ArrayList<Person> listPerson= new ArrayList<Person>();
		
		ResultSet res = connection.SelectQuery("select * from person");
		
			while(res.next()) {
				
				listPerson.add(new Person(res.getInt("id"),res.getString("name"),res.getInt("age")));
			}
		
		
		for(Person person: listPerson) {
			System.out.println(person.id+ " " +person.name + " "+ person.age);
			System.out.println(person);
		}
		
	}

}
