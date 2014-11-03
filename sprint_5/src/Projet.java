import java.io.IOException;
import java.util.ArrayList;


public class Projet {
	
	private String nomG;
	private String idSujet;
	private String idInter1;
	private String RoleInter1;
	private String idInter2;
	private String RoleInter2;
	private String idInter3;
	private String RoleInter3;
	
	
	public Projet(){
		this.nomG = "";
		this.idSujet = "";
		this.idInter1 = "";
		this.RoleInter1 = "";
		this.idInter2 = "";
		this.RoleInter2 = "";
		this.idInter3 = "";
		this.RoleInter3 = "";
	}
	
	public Projet(String pGr, String pSujet, String pInter1, String pRole1){
		this.nomG = pGr;
		this.idSujet = pSujet;
		this.idInter1 = pInter1;
		this.RoleInter1 = pRole1;
		this.idInter2 = "";
		this.RoleInter2 = "";
		this.idInter3 = "";
		this.RoleInter3 = "";
	}
	
	public Projet(String pGr, String pSujet, String pInter1, String pRole1, String pInter2, String pRole2){
		this.nomG = pGr;
		this.idSujet = pSujet;
		this.idInter1 = pInter1;
		this.RoleInter1 = pRole1;
		this.idInter2 = pInter2;
		this.RoleInter2 = pRole2;
		this.idInter3 = "";
		this.RoleInter3 = "";
	}
	
	public Projet(String pGr, String pSujet, String pInter1, String pRole1, 
			String pInter2, String pRole2, String pInter3, String pRole3){
		this.nomG = pGr;
		this.idSujet = pSujet;
		this.idInter1 = pInter1;
		this.RoleInter1 = pRole1;
		this.idInter2 = pInter2;
		this.RoleInter2 = pRole2;
		this.idInter3 = pInter3;
		this.RoleInter3 = pRole3;
	}
	
	// GETTERS & SETTERS
	public String getSujet(){return this.idSujet;}
	public String getNomG(){return this.nomG;}
	public String getInterv1() {return this.idInter1;}
	public String getRoleInter1() {return RoleInter1;}
	public String getInterv2() {return this.idInter2;}
	public String getRoleInter2() {return RoleInter2;}
	public String getInterv3() {return this.idInter3;}
	public String getRoleInter3() {return RoleInter3;}
	
	public void setSujet(String pSujet){this.idSujet = pSujet;}
	public void setGroup(String pGr){this.nomG = pGr;}
	public void setInter1(String pInter){this.idInter1 =pInter; }
	public void setRoleInter1(String roleInter) {RoleInter1 = roleInter;}
	public void setInter2(String pInter){this.idInter2 =pInter; }
	public void setRoleInter2(String roleInter) {RoleInter2 = roleInter;}
	public void setInter3(String pInter){this.idInter3 =pInter; }
	public void setRoleInter3(String roleInter) {RoleInter3 = roleInter;}
	

	

	public String toString(){
		return ("Projet : \n"+this.idSujet+"\nGroupe affilié : "+this.nomG+"\n"
				+RoleInter1+" : "+	idInter1+"\n"
				+RoleInter2+" : "+	idInter2+"\n"
				+RoleInter3+" : "+	idInter3);
	}
	
	public static ArrayList<Projet> lire(String fich){
		ArrayList<String[]> lecteur;
		ArrayList<Projet> retourPro = new ArrayList<>();
		try {
			if(fich.equals("")) {
				lecteur = Lib.Lire("projets2014_2015.csv");
			} else {
				lecteur = Lib.Lire(fich+".csv");
			}
			
			for(int i = 0; i < lecteur.size(); i ++){
				switch (lecteur.get(i).length) {
				case 4:
					retourPro.add(new Projet(lecteur.get(i)[0], lecteur.get(i)[1], 
							lecteur.get(i)[2], lecteur.get(i)[3]));
					break;
				case 6:
					retourPro.add(new Projet(lecteur.get(i)[0], lecteur.get(i)[1], 
							lecteur.get(i)[2], lecteur.get(i)[3], 
							lecteur.get(i)[4], lecteur.get(i)[5]));
					break;
				case 8:
					retourPro.add(new Projet(lecteur.get(i)[0], lecteur.get(i)[1], 
							lecteur.get(i)[2], lecteur.get(i)[3], 
							lecteur.get(i)[4], lecteur.get(i)[5], 
							lecteur.get(i)[6], lecteur.get(i)[7]));
					
					break;

				default:
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retourPro; 
	}
	public static void Ecrire(ArrayList<Projet> listProj, String fich){
		ArrayList<String[]> stylo = new ArrayList<>();
		for(int i = 0; i < listProj.size(); i ++){
			String[] tab = {listProj.get(i).getNomG(), listProj.get(i).getSujet(),
					listProj.get(i).getInterv1(), listProj.get(i).getRoleInter1(),
					listProj.get(i).getInterv2(), listProj.get(i).getRoleInter2(),
					listProj.get(i).getInterv3(), listProj.get(i).getRoleInter3()};
			stylo.add(tab);
		}
		try {
			if(fich.equals("")){
				Lib.Ecrire(stylo, "projets2014_2015.csv");
			} else {
				Lib.Ecrire(stylo, fich+".csv");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
