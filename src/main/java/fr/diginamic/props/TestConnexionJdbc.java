package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.mariadb.jdbc.Driver;

public class TestConnexionJdbc {

	public static void main(String[] args) {

//		 try {
//		 DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
//		 } catch (SQLException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
//		
//		 try {
//		 Connection maConnection=DriverManager.getConnection("jdbc:mariadb://localhost:3306/compta","root",null);
//		 maConnection.close();
//		 } catch (SQLException e) {
//		 // TODO Auto-generated catch block
//		 e.printStackTrace();
//		 }
		 
		 
		ResourceBundle result = ResourceBundle.getBundle("database");
		try {
			Class.forName(result.getString("driver"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connnexion = DriverManager.getConnection(result.getString("url"), result.getString("user"), result.getString("password"));
			connnexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
