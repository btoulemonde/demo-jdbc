package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestSelect {

	public static void main(String[] args) {
		FournisseurDaoJdbc select = new FournisseurDaoJdbc();
		select.extraire();
		
//		List<Fournisseur> fournisseur=null;
//		Connect.select("SELECT * FROM FOURNISSEUR", fournisseur);

	}

}
