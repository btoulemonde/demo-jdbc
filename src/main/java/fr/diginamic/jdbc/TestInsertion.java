package fr.diginamic.jdbc;


import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;


public class TestInsertion {

	public static void main(String[] args) {
		Fournisseur fournisseur = new Fournisseur(4, "La Maison de la peinture");
		FournisseurDaoJdbc insertion = new FournisseurDaoJdbc();
		insertion.insert(fournisseur);
//		Connect.insert("INSERT INTO FOURNISSEUR (ID,NOM) VALUES (4,'La maison de la peinture')");
	}

}
