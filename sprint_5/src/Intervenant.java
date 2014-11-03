import java.io.IOException;
import java.util.ArrayList;


public class Intervenant {
	private String idInter, nomInter, prenomInter;

	public Intervenant(){
		this.idInter = "00000";
		this.nomInter = "404";
		this.prenomInter = "404";
	}
	public Intervenant(String idInter, String nomInter, String prenomInter){
		this.idInter = idInter;
		this.nomInter = nomInter;
		this.prenomInter = prenomInter;
	}
	
	//Setters
	public void setIdInter(String idInter) {this.idInter = idInter;}
	public void setNomInter(String nomInter) {this.nomInter = nomInter;}
	public void setPrenomInter(String prenomInter) {this.prenomInter = prenomInter;}
	
	//Getters
	public String getIdInter() {return idInter;}
	public String getPrenomInter() {return prenomInter;}
	public String getNomInter() {return nomInter;}
	
	
	public String toString(){
		return "Intervenant : \nNom : "+nomInter+"\nPrenom : "+prenomInter+"\nID : "+ idInter;
	}
	
	public static ArrayList<Intervenant> lire(String fich){
		ArrayList<String[]> lecteur;
		ArrayList<Intervenant> retourInter = new ArrayList<>();
		try {
			if(fich.equals("")) {
				lecteur = Lib.Lire("intervenants2014_2015.csv");
			} else {
				lecteur = Lib.Lire(fich+".csv");
			}
			
			for(int i = 0; i < lecteur.size(); i ++){
				retourInter.add(new Intervenant(lecteur.get(i)[0], lecteur.get(i)[1], lecteur.get(i)[2]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retourInter; 
	}
	public static void Ecrire(ArrayList<Intervenant> listInter, String fich){
		ArrayList<String[]> stylo = new ArrayList<>();
		for(int i = 0; i < listInter.size(); i ++){
			String[] tab = {listInter.get(i).getIdInter(), listInter.get(i).getNomInter(), listInter.get(i).getPrenomInter()};
			stylo.add(tab);
		}
		try {
			if(fich.equals("")){
				Lib.Ecrire(stylo, "intervenants2014_2015.csv");
			} else {
				Lib.Ecrire(stylo, fich+".csv");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
