package fr.diginamic.jdbc;


import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDelete {

	public static void main(String[] args){
		Fournisseur fournisseur = new Fournisseur(5, null);
		FournisseurDaoJdbc delete = new FournisseurDaoJdbc();
				delete.delete(fournisseur);
		
//		Connect.delete("DELETE FROM FOURNISSEUR WHERE ID=5 ");
	}

}
