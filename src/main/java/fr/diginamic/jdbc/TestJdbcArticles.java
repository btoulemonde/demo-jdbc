package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.ArticleDaoJdbc;
import fr.diginamic.jdbc.dao.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestJdbcArticles {

	public static void main(String[] args) {
		// insertion de nouveaux articles
		ArticleDaoJdbc insertionArt = new ArticleDaoJdbc();
		FournisseurDaoJdbc insertionFourn = new FournisseurDaoJdbc();
    	Fournisseur fournisseur = new Fournisseur(4, "La Maison de la peinture");
		insertionFourn.insert(fournisseur);
		
		Article article1 = new Article(11, "G01", "Peinture blanche 1L", 12.5, fournisseur.getId());
		insertionArt.insert(article1);
		
		Article article2 = new Article(12, "G02", "Peinture rouge mate 1L", 15.5, fournisseur.getId());
		insertionArt.insert(article2);
		
		Article article3 = new Article(13, "G03", "Peinture noire laquée 1L", 17.8, fournisseur.getId());
		insertionArt.insert(article3);
		
		Article article4 = new Article(14, "G04", "Peinture bleue mate 1L", 15.5, fournisseur.getId());
		insertionArt.insert(article4);
		
		//diminuer le prix de toutes les peintures mates de 25%
		ArticleDaoJdbc update = new ArticleDaoJdbc();
		update.update("MATE", "PRIX*0.75");
		
		//afficjer la liste de tous les articles
		ArticleDaoJdbc afficher = new ArticleDaoJdbc();
		afficher.extraire();
		
		//moyenne des prix
		ArticleDaoJdbc moyenne = new ArticleDaoJdbc();
		moyenne.moyenne();
		
		
		//supp des articles peinture
		ArticleDaoJdbc supp =new ArticleDaoJdbc();
		supp.deleteDes("PEINTURE");
		
		//supp fournissuer peinture
		FournisseurDaoJdbc delete = new FournisseurDaoJdbc();
		delete.delete(fournisseur);
		
		

	}

}
