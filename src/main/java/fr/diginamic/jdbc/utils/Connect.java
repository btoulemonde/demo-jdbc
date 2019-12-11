package fr.diginamic.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Connect {

	private static ResourceBundle bundle = ResourceBundle.getBundle("database");
	private static String driver = bundle.getString("driver");
	private static String url = bundle.getString("url");
	private static String user = bundle.getString("user");
	private static String password = bundle.getString("password");

	public static boolean driver() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}
	public static Connection getConnection(){
		if (driver() != true){
			driver();
		}
		Connection conn =null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void insert(String sql) {
		
		Connection connexion = null;
		Statement statement = null;
		try {
			connexion = getConnection();

			statement = connexion.createStatement();

			statement.executeUpdate(sql);

		} catch (SQLException e) {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e1) {
				System.out.println("echec du rollback");
			}
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				connexion.commit();
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {

				System.out.println("echec de la fermeture des ressources");
			}

		}
	}

	public static void update(String sql) {

		Connection connexion = null;
		Statement statement = null;
		try {
			connexion = getConnection();

			statement = connexion.createStatement();

			statement.executeUpdate(sql);

		} catch (SQLException e) {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e1) {
				System.out.println("echec du rollback");
			}
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				connexion.commit();
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {

				System.out.println("echec de la fermeture des ressources");
			}

		}
	}

	public static void delete(String sql) {
		Connection connexion = null;
		Statement statement = null;
		try {
			connexion = getConnection();

			statement = connexion.createStatement();

			statement.executeUpdate(sql);

		} catch (SQLException e) {
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e1) {
				System.out.println("echec du rollback");
			}
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				connexion.commit();
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {

				System.out.println("echec de la fermeture des ressources");
			}

		}
	}

	public static ResultSet select(String sql) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet curseur = null;
		try {
			connexion = getConnection();
			statement = connexion.createStatement();
			curseur = statement.executeQuery(sql);

//			liste = new ArrayList<>();
//			while (curseur.next()) {
//				int id = curseur.getInt("ID");
//				String nom = curseur.getString("NOM");
//				Fournisseur fourn = new Fournisseur(id, nom);
//				liste.add(fourn);
//				System.out.println(id + " / " + nom);
//			}
		} catch (SQLException e) {
			
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connexion != null) {
					connexion.close();
				}
			} catch (SQLException e) {

				System.out.println("echec de la fermeture des ressources");
			}

		}
		return curseur;
	}

}
