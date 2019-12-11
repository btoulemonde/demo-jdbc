package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.utils.Connect;

public class FournisseurDaoJdbc implements FournisseurDao {

	@Override
	public List<Fournisseur> extraire() {
		List<Fournisseur> fournisseur = null;
		Connect.select("SELECT * FROM FOURNISSEUR", fournisseur);

		return fournisseur;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		Connect.insert("INSERT INTO FOURNISSEUR (ID,NOM) VALUES " + fournisseur.toString() );

	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		Connect.update("UPDATE FOURNISSEUR SET NOM='" +nouveauNom + "' WHERE NOM='"+ancienNom + "'");
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		Connect.delete("DELETE FROM FOURNISSEUR WHERE ID="+fournisseur.getId());
		return false;
	}

}
