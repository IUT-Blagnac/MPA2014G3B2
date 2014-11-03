

import java.util.ArrayList;

public class Groupe {

	String libelle;
	ArrayList<Etudiant> membres = new ArrayList<>();
	
	/***
	 * Retourne le libell� du groupe
	 * @return String
	 */
	public String getLibelle() {
		return libelle;
	}

	/***
	 * Retourne l'ArrayList d'�tudiant contenant les membres du groupe
	 * @return ArrayList d'Etudiant
	 */
	public ArrayList<Etudiant> getMembres() {
		return membres;
	}
	
	/***
	 * Constructeur de l'objet Groupe
	 * @param libelle Identifiant de l'objet groupe
	 * @param membres Liste des membres du groupe (ArrayList)
	 */
	public Groupe(String libelle, ArrayList<Etudiant> membres) {
		super();
		this.libelle = libelle;
		this.membres = membres;
	}
	
	/***
	 * Retourne un groupe en fonction de son identifiant
	 * @param dbGroupe ArrayList de groupe dans laquelle on cherche le groupe
	 * @param sGroupe identifiant du groupe
	 * @return groupe recherch�
	 */
	public static Groupe getGroupFromId(ArrayList<Groupe> dbGroupe, String sGroupe) {
		
		for(Groupe grp : dbGroupe){
			if(grp.getLibelle().equals(sGroupe)){
				return grp;
			}

		}
		return null;
		
		
		
	}
	
}
