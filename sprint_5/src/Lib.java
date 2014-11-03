import java.io.*; 
import java.util.*;

public class Lib {
	
	public static void Ecrire(ArrayList<String []> texte, String file) throws IOException{
		File projet = new File("../data/"+file);
		String newLine = System.getProperty("line.separator");
		PrintStream printCsv;
	    try{
	    	printCsv = new PrintStream(projet);
		    for(int i = 0; i < texte.size(); i++){
		    	
		    	for(int j = 0; j < texte.get(i).length; j++){
		    		if(texte.get(i).length == (j+1)){
		    			printCsv.print(texte.get(i)[j].replaceAll("\n", "%gnagna%"));
		    		} else {
		    			printCsv.print(texte.get(i)[j].replaceAll("\n", "%gnagna%")+";");
		    		}
		    	}
		    	
		    	printCsv.print(newLine);
		    	
		    }
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    
	}
	
	public static ArrayList<String []> Lire(String file) throws IOException{
		String ligne = "";
		
		ArrayList<String []> result = new ArrayList<>();
		
		BufferedReader ficTexte;
		try {
			ficTexte = new BufferedReader(new FileReader(new File("../data/"+file)));
			String tab[];
			do {
				ligne = ficTexte.readLine();
				if (ligne != null) {
					ligne = ligne.replaceAll("%gnagna%", "\n");
					tab = ligne.split(";");
					result.add(tab);
				}
			} while (ligne != null);
			ficTexte.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		return result;
	}
}
