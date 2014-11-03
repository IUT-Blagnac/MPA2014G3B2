import java.io.IOException;
import java.util.ArrayList;


public class Sujet {
	
	private String titre, contenu;
	
	public Sujet(){
		this(null,null);
	}
	
	public Sujet(String pTitre, String pContenu){
		this.titre = pTitre;
		this.contenu = pContenu;
	}

	// GETTERS & SETTERS
	public String getContenu(){return contenu;}
	public String getTitre(){return titre;}
	public void setTitre(String pTitre){this.titre = pTitre;}
	public void setContenu(String pContenu){this.contenu = pContenu;}
	
	public String toString(){
		return ("Sujet : "+this.titre+"\n"+this.contenu);
	}
	
	
	public static ArrayList<Sujet> lire(String fich){
		ArrayList<String[]> lecteur;
		ArrayList<Sujet> retourSuj = new ArrayList<>();
		try {
			if(fich.equals("")) {
				lecteur = Lib.Lire("sujets2014_2015.csv");
			} else {
				lecteur = Lib.Lire(fich+".csv");
			}
			
			for(int i = 0; i < lecteur.size(); i ++){
				retourSuj.add(new Sujet(lecteur.get(i)[0], lecteur.get(i)[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retourSuj;
	}
	public static void Ecrire(ArrayList<Sujet> listSuj, String fich){
		ArrayList<String[]> stylo = new ArrayList<>();
		for(int i = 0; i < listSuj.size(); i ++){
			String[] tab = {listSuj.get(i).getTitre(), listSuj.get(i).getContenu()};
			stylo.add(tab);
		}
		try {
			if(fich.equals("")){
				Lib.Ecrire(stylo, "sujets2014_2015.csv");
			} else {
				Lib.Ecrire(stylo, fich+".csv");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
