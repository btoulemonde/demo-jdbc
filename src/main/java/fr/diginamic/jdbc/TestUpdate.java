package fr.diginamic.jdbc;


import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;

public abstract class TestUpdate {

	public static void main(String[] args) {
		
		FournisseurDaoJdbc update = new FournisseurDaoJdbc();
		update.update("La Maison de la peinture", "La Maison des peintures");
//		Connect.update("UPDATE FOURNISSEUR SET NOM='La Maison des peinture' WHERE ID=4");
	}

}
