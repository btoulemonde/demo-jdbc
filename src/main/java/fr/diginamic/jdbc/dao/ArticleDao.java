package fr.diginamic.jdbc.dao;

import java.util.List;

import fr.diginamic.jdbc.entites.Article;

public interface ArticleDao {
	List<Article> extraire();
	void insert(Article article);
	int update(String designation, String nouveauPrix);
	boolean delete(Article article);
}
