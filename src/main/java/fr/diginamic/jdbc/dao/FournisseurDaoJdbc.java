package fr.diginamic.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.diginamic.jdbc.entites.Fournisseur;
import fr.diginamic.jdbc.utils.Connect;

public class FournisseurDaoJdbc implements FournisseurDao {

	@Override
	public List<Fournisseur> extraire() {
		List<Fournisseur> liste = new ArrayList<>();
		ResultSet curseur = Connect.select("SELECT * FROM FOURNISSEUR");
	
		try {
			while (curseur.next()) {
				int id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");
				Fournisseur fourn = new Fournisseur(id, nom);
				liste.add(fourn);
				System.out.println(fourn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		Connect.cud("INSERT INTO FOURNISSEUR (ID,NOM) VALUES( "+fournisseur.getId() +  ",'"+fournisseur.getNom()+"')");

	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		int nb = Connect.cud("UPDATE FOURNISSEUR SET NOM='" +nouveauNom + "' WHERE NOM='"+ancienNom + "'");
		return nb;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		Connect.cud("DELETE FROM FOURNISSEUR WHERE ID="+fournisseur.getId() );
		return true;
	}

}
