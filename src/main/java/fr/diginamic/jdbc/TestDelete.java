package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestDelete {

	public static void main(String[] args) throws SQLException {
		ResourceBundle result = ResourceBundle.getBundle("database");
		try {
			Class.forName(result.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(result.getString("url"), result.getString("user"), result.getString("password"));
			
			//1ère étape statement
			Statement statement = connexion.createStatement();
			
			//2ème étape executer la requète
			statement.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=4 ");
			
			statement.close();
			connexion.commit();
			connexion.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			connexion.rollback();
			e.printStackTrace();
			
			}


	}

}
