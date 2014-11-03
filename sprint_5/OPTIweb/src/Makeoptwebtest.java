import java.io.File;


public class Makeoptwebtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File monFichier = new File("OPTIweb.html"); 
		if(monFichier.exists()){
			System.out.println("le fichier OPTIweb.html existe bien");
		}
		else{
			System.out.println("erreur : le fichier OPTIweb.html n'existe pas");
		}

	}

}
