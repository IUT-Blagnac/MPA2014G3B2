//import junit.textui.TestRunner;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import java.io.*;
import java.util.ArrayList;


public class LibTest extends TestCase {
	static String programmeATester = "Lib.java" ;
	Process executionProgrammeATester ;

	String finDeLigne = System.getProperty("line.separator") ; 
	
	public static void main(String[] args) {
	    if ( args.length > 0 ) { programmeATester = args[0] ; }
	    System.out.println("Tests du programme : " + programmeATester);
	    junit.textui.TestRunner.run(new TestSuite(LibTest.class)); 
	  }

	  protected void setUp() throws IOException {  
		//executionProgrammeATester = Runtime.getRuntime().exec("\"c:\\Program Files\\Java\\jre7\\bin\\java.exe\" -cp U:\\E\\MPA\\projet\\workspace\\G0A1\\bin "+programmeATester); 
		//executionProgrammeATester = Runtime.getRuntime().exec("java.exe -cp U:\\E\\MPA\\projet\\workspace\\G0A1\\bin "+programmeATester); 
		executionProgrammeATester = Runtime.getRuntime().exec("java.exe -cp .;bin "+programmeATester); 
	  }
	
	  public void test_lecture() throws IOException {
		  ArrayList<String []> texte = new ArrayList<>();
		  String[] tabTest1 = {"test1", "test2", "test3"};
		  texte.add(tabTest1);
		  
		  File projet = new File("../data/test.csv");
		  PrintStream printCsv;
		  try{
			  printCsv = new PrintStream(projet);
			  for(int i = 0; i < texte.size(); i++){
				  
				  for(int j = 0; j < texte.get(i).length; j++){
					  if(texte.get(i).length == (j+1)){
						  printCsv.print(texte.get(i)[j]);
					  } else {
						  printCsv.print(texte.get(i)[j]+";");
					  }
				  }
			    	
				  printCsv.print("\n");
				  
			  }
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
		  
		  assertEquals(texte.get(0)[0], Lib.Lire("../data/test.csv").get(0)[0]);
		  assertEquals(texte.get(0)[1], Lib.Lire("../data/test.csv").get(0)[1]);
		  assertEquals(texte.get(0)[2], Lib.Lire("../data/test.csv").get(0)[2]);
		  
	  }
	  
	  public void test_ecriture()throws IOException {
		  ArrayList<String []> texte = new ArrayList<>();
		  String[] tabTest1 = {"test1", "test2", "test3"};
		  texte.add(tabTest1);
		  
		  Lib.Ecrire(texte, "test2.csv");
		  
		  assertEquals(texte.get(0)[0], Lib.Lire("../data/test.csv").get(0)[0]);
		  assertEquals(texte.get(0)[1], Lib.Lire("../data/test.csv").get(0)[1]);
		  assertEquals(texte.get(0)[2], Lib.Lire("../data/test.csv").get(0)[2]);
	  }
}
