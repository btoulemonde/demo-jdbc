package fr.diginamic.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.diginamic.jdbc.utils.Connect;
import fr.diginamic.jdbc.entites.Article;

public class ArticleDaoJdbc implements ArticleDao {

	@Override
	public List<Article> extraire() {
		List<Article> liste = new ArrayList<>();
		ResultSet curseur = Connect.select("SELECT * FROM ARTICLE");
		
		try {
			while (curseur.next()) {
				int id = curseur.getInt("ID");
				String ref = curseur.getString("REF");
				String designation = curseur.getString("DESIGNATION");
				int prix = curseur.getInt("PRIX");
				int idFournisseur = curseur.getInt("ID_FOU");
				
				Article art = new Article(id, ref, designation, prix, idFournisseur);
				liste.add(art);
				System.out.println(art);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public void insert(Article article) {
		Connect.insert("INSERT INTO ARTICLE (ID, REF, DESIGNATION,PRIX, ID_FOU) VALUES (" + article.getId() + ",' " + article.getRef() + "','" + article.getDesignation() + "'," + article.getPrix()
				+ ",'" + article.getFournisseur() + "')");

	}

	@Override
	public int update(String designation, String nouveauPrix) {
		Connect.update("UPDATE ARTICLE SET PRIX ="+ nouveauPrix + "WHERE DESIGNATION LIKE '%" + designation + "%'");
		return 0;
	}

	@Override
	public boolean delete(Article article) {
		Connect.delete("DELETE FROM ARICLE WHERE ID=" + article.getId());
		return false;
	}

	public void moyenne(){
		ResultSet curseur = Connect.select("SELECT AVG(PRIX) FROM ARTICLE ");
				System.out.println(curseur);
	}
	public boolean deleteDes() {
		Connect.delete("DELETE FROM ARICLE WHERE DESIGNATION lIKE '%PEINTURE%'");
		return false;
	}
	
}