import java.util.ArrayList;



public class Encadrer {
	
	Intervenant intervenant;
	Projet projet;
	Role role;
	
	/***
	 * Retourne l'intervenant associ�
	 * @return Objet Intervenant associ�
	 */
	public Intervenant getIntervenant() {
		return intervenant;
	}

	/***
	 * Permet de recuperer le projet associ�
	 * @return Objet Projet associ�
	 */
	public Projet getProjet() {
		return projet;
	}

	/***
	 * Permet de recuperer le role associ� � l'intervenant
	 * @return Valeur du role
	 */
	public Role getRole() {
		return role;
	}
	
	
	/**
	 * Constructeur d'un objet Encadrer.
	 * @param intervenant Objet Intervenant representant l'intervenant encadrant le projet.
	 * @param projet Objet Projet representant le projet �tant encadr�.
	 * @param role Valeur de l'�numeration Role, repr�sente le r�le de l'intervenant affect�.
	 */
	public Encadrer(Intervenant intervenant, Projet projet, Role role) {
		super();
		this.intervenant = intervenant;
		this.projet = projet;
		this.role = role;
	}
	
	/***
	 * Permet de recuperer un objet Intervenant � partir du projet et du r�le de celui-ci.
	 * @param dbEnc ArrayList d'objet Encadrer dans laquelle on cherche l'intervenant.
	 * @param projet Projet, crit�re de recherche
	 * @param role Role, crit�re de recherche
	 * @return intervenant recherch�
	 */
	public static Intervenant getInterFromProjetRole(ArrayList<Encadrer> dbEnc, Projet projet, Role role){
		
		for(Encadrer encadrer : dbEnc){
			
			if(encadrer.getProjet()==projet && encadrer.getRole()==role){
				return encadrer.getIntervenant();
			}
			
		}
		return null;
		
	}

}
