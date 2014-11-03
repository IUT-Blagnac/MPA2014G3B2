

public class Etudiant {
	
	private int id;
	private String nom;
	private String prenom;
	private Groupe groupe;
	
	/***
	 * Retourne l'identifiant de l'�tudiant
	 * @return entier : identifiant
	 */
	public int getId(){
		return id;
	}
	
	/***
	 * Retourne le nom de l'�tudiant
	 * @return String
	 */
	public String getNom() {
		return nom;
	}
	/***
	 * Retourne le prenom de l'�tudiant
	 * @return String
	 */
	public String getPrenom() {
		return prenom;
	}
	/***
	 * Retourne le groupe de l'�tudiant
	 * @return Objet Groupe
	 */
	public Groupe getGroupe() {
		return groupe;
	}
	
	/***
	 * Constructeur de l'objet Etudiant
	 * @param id identifiant de l'etudiant
	 * @param nom nom de l'�tudiant
	 * @param prenom prenom de l'�tudiant
	 */
	public Etudiant(int id,String nom, String prenom){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = null;
	}
	
	/***
	 * Constructeur de l'objet Etudiant (mais affect� � un groupe)
	 * @param id identifiant de l'etudiant
	 * @param nom nom de l'�tudiant
	 * @param prenom prenom de l'�tudiant
	 * @param groupe groupe de l'�tudiant
	 */
	public Etudiant(int id,String nom, String prenom, Groupe groupe) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
	}

}
