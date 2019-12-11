package fr.diginamic.jdbc.entites;

public class Article   {
	private int id;
	private String ref;
	private String designation;
	private double prix;
	private int idFournisseur;
	
	/**
	 * @param id
	 * @param ref
	 * @param designation
	 * @param prix
	 * @param idFournisseur
	 */
	public Article(int id, String ref, String designation, double prix, int idFournisseur) {
		super();
		this.id = id;
		this.ref = ref;
		this.designation = designation;
		this.prix = prix;
		this.idFournisseur = idFournisseur;
	}
	
	
	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/** Getter
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}
	/** Setter
	 * @param ref the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}
	/** Getter
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/** Setter
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/** Getter
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}
	/** Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	/** Getter
	 * @return the idFournisseur
	 */
	public int getFournisseur() {
		return idFournisseur;
	}
	/** Setter
	 * @param fournisseur the fournisseur to set
	 */
	public void setFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  id + " / " + ref + " / " + designation + " / " + prix
				+ " / " + idFournisseur ;
	}


	

}
