import java.util.ArrayList;




public class Sujet {

	int id;
	String nom;
	String titre;
	public int getId() {
		return id;
	}
	/***
	 * Retourne le nom du projet
	 * @return nom du projet
	 */
	public String getNom() {
		return nom;
	}
	/***
	 * Retourne le titre du projet
	 * @return titre du projet
	 */
	public String getTitre() {
		return titre;
	}

	/***
	 * Constructeur de l'objet Sujet
	 * @param id identifiant du sujet
	 * @param nom nom du sujet
	 * @param titre titre du sujet
	 */
	public Sujet(int id, String nom, String titre) {
		super();
		this.id = id;
		this.nom = nom;
		this.titre = titre;
	}
	
	/***
	 * Permet de recuperer un sujet � partir de son identifiant
	 * @param dbSujets ArrayList de sujet dans laquelle le sujet est cherch�
	 * @param id identifiant du sujet
	 * @return sujet recherch�
	 */
	public static Sujet getSujetFromID(ArrayList<Sujet> dbSujets, int id){
		
		for(Sujet sjt : dbSujets){
			if(sjt.getId()==id){
				return sjt;
			}
		}
		return null;
		
	}
	
}
