package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

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
			ResultSet curseur = statement.executeQuery("SELECT * FROM FOURNISSEUR");
			
			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
			while (curseur.next()){
				int id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				Fournisseur fourn = new Fournisseur(id, nom);
				fournisseurs.add(fourn);
				System.out.println(id+" / "+nom);
				}
			curseur.close();
			statement.close();
			connexion.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			}


	}

}
