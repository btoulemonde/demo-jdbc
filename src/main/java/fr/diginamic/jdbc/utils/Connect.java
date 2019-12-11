package fr.diginamic.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class Connect {

	private static ResourceBundle bundle = ResourceBundle.getBundle("database");
	private static String driver = bundle.getString("driver");
	private static String url = bundle.getString("url");
	private static String user = bundle.getString("user");
	private static String password = bundle.getString("password");

	public static void driver() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void insert(String sql) {
		driver();
		Connection connexion = null;
		Statement statement = null;
		try {
			connexion = DriverManager.getConnection(url, user, password);

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

		driver();

		Connection connexion = null;
		Statement statement = null;

		try {
			connexion = DriverManager.getConnection(url, user, password);

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
		driver();
		Connection connexion = null;
		Statement statement = null;

		try {
			connexion = DriverManager.getConnection(url, user, password);

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

	public static <E> void select(String sql, List<E> liste) {
		driver();
		Connection connexion = null;
		Statement statement = null;
		try {
			connexion = DriverManager.getConnection(url, user, password);

			statement = connexion.createStatement();
			ResultSet curseur = statement.executeQuery(sql);

			List<Fournisseur> fournisseurs = new ArrayList<>();
			while (curseur.next()) {
				int id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				Fournisseur fourn = new Fournisseur(id, nom);
				fournisseurs.add(fourn);
				System.out.println(id + " / " + nom);
			}
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
	}

}
