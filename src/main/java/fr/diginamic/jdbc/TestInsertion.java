package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.naming.ConfigurationException;

public class TestInsertion {

	public static void main(String[] args) {
		ResourceBundle result = ResourceBundle.getBundle("database");
		try {
			Class.forName(result.getString("driver"));
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connexion = DriverManager.getConnection(result.getString("url"), result.getString("user"), result.getString("password"));
			
			//1ère étape statement
			Statement statement = connexion.createStatement();
			
			//2ème étape executer la requète
			statement.executeUpdate("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (4,'La maison de la peinture')");
			statement.close();
			connexion.close();
			connexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

}
