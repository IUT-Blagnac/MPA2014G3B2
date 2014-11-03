
public class Voeux {
	private String groupe;
	private Sujet sujet;
	private int rgVoeux;

	public Voeux(){
		this.groupe = null;
		this.sujet = null;
		this.rgVoeux = 404;
	}
	
	public Voeux(String pGroupe, Sujet pSujet, int pRgVoeux){
		this.groupe = pGroupe;
		this.sujet = pSujet;
		this.rgVoeux = pRgVoeux;
	}
	
	//Getter
	public String getGroupe() {return groupe;}
	public Sujet getSujet() {return sujet;}
	public int getRgVoeux() {return rgVoeux;}
	
	//Setter
	public void setGroupe(String groupe) {this.groupe = groupe;}
	public void setSujet(Sujet sujet) {this.sujet = sujet;}
	public void setRgVoeux(int rgVoeux) {this.rgVoeux = rgVoeux;}
}
