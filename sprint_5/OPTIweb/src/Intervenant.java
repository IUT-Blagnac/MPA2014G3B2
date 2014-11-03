import java.util.ArrayList;



public class Intervenant {
	
	int id;
	String nom;
	String prenom;
	
	/***
	 * Retourne l'identifiant de l'intervenant
	 * @return entier : identifiant
	 */
	public int getId() {
		return id;
	}

	/***
	 * Retourne le nom de l'intervenant
	 * @return String
	 */
	public String getNom() {
		return nom;
	}
	
	/***
	 * Retourne le pr�nom de l'intervenant
	 * @return String
	 */
	public String getPrenom() {
		return prenom;
	}

	/***
	 * Constructeur de l'objet Intervenant
	 * @param id identifiant de l'intervenant
	 * @param nom nom de l'intervenant
	 * @param prenom prenom de l'intervenant
	 */
	public Intervenant(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/***
	 * Permet de recuperer un objet Intervenant � partir d'un identifiant
	 * @param dbInter ArrayList d'intervenant dans laquelle on recherche l'intervenant
	 * @param id Identifiant de l'intervenant recherch�
	 * @return intervenant recherch�
	 */
	public static Intervenant getInterFromId(ArrayList<Intervenant> dbInter, int id){
		
		for(Intervenant inter : dbInter){
			if(inter.getId() == id){
				return inter;
			}
		}
		return null;
		
	}
	
}
