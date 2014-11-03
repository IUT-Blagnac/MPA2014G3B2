import java.io.IOException;
import java.util.*;


public class Etudiant {
	private String nom, prenom, ide;
	private String groupe;
	
	public Etudiant(){
		this("000","inconnu","inconnu","inconnu");
	}
	
	public Etudiant(String pIde, String pNom, String pPrenom, String pGroupe){
		this.ide = pIde;
		this.nom = pNom;
		this.prenom = pPrenom;
		this.groupe = pGroupe;
	}
	
	// SETTERS
	public void setIde(String pIde){this.ide = pIde;}
	public void setNom(String pNom){this.nom = pNom;}
	public void setPrenom(String pPrenom){this.prenom = pPrenom;}
	public void setGroupe(String pGroupe){this.groupe = pGroupe;}
	
	// GETTERS
	public String getIde(){return (this.ide);}
	public String getNom(){return (this.nom);}
	public String getPrenom(){return (this.prenom);}
	public String getGroupe(){return (this.groupe);}
	
	public String toString(){
		return ("ETUDIANT "+this.ide+"\nNom : "+this.nom+"\nPrénom : "+this.prenom+"\nGroupe : "+this.groupe+"\n");
	}
	
	public static ArrayList<Etudiant> lire(String fich)/* throws Exception*/{
		ArrayList<String[]> lecteur;
		ArrayList<Etudiant> retourEtu = new ArrayList<>();
		try {
			if(fich.equals("")) {
				lecteur = Lib.Lire("etudiants2014_2015.csv");
			} else {
				lecteur = Lib.Lire(fich+".csv");
			}
			
			for(int i = 0; i < lecteur.size(); i ++){
				retourEtu.add(new Etudiant(lecteur.get(i)[0], lecteur.get(i)[1], lecteur.get(i)[2], lecteur.get(i)[3]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retourEtu; 
	}
	
	public static void Ecrire(ArrayList<Etudiant> listEtu, String fich){
		ArrayList<String[]> stylo = new ArrayList<>();
		for(int i = 0; i < listEtu.size(); i ++){
			String[] tab = {listEtu.get(i).getIde(), listEtu.get(i).getNom(), listEtu.get(i).getPrenom(), listEtu.get(i).getGroupe() };
			stylo.add(tab);
		}
		try {
			if(fich.equals("")){
				Lib.Ecrire(stylo, "etudiants2014_2015.csv");
			} else {
				Lib.Ecrire(stylo, fich+".csv");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
