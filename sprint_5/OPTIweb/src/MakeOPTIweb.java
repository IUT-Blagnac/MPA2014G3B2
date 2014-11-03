import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;



public class MakeOPTIweb {
	
	public static void main(String[] args) throws Exception{

		ArrayList<Groupe> dbGroupes = new ArrayList<Groupe>();
		ArrayList<Etudiant> dbEtudiants = LibCSV.importEtuFromCSV(new File("data/etudiants.csv"), dbGroupes);
		ArrayList<Intervenant> dbIntervenants = LibCSV.importIntervenantFromCSV(new File("data/intervenants.csv"));
		ArrayList<Sujet> dbSujets = LibCSV.importSujetFromCSV(new File("data/sujets.csv"));
		ArrayList<Encadrer> dbEncadrer = new ArrayList<Encadrer>();
		ArrayList<Projet> dbProjets = LibCSV.importProjetFromCSV(new File("data/projets.csv"), dbGroupes, dbSujets, dbIntervenants, dbEncadrer);
		
		String strHTML = genererEntete();
		
		strHTML += genererPageAcceuil();
		
		strHTML += genererPageProjets(dbProjets, dbEncadrer);
		
		strHTML += genererPageSujets(dbSujets, dbProjets);
		
		strHTML += genererPageEtudiants(dbEtudiants);
		
		strHTML += genererPageIntervenants(dbIntervenants, dbEncadrer);
		
		strHTML += genererPageCredits();
		
		strHTML += genererFinHTML();
		
		
		PrintWriter fw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OPTIweb.html"),"utf8")));
		
		fw.print(strHTML);
		
		fw.close();
		
	}
	
	
	private static String genererEntete(){
		
		//Ajout de l'entete
		return("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
				"<meta name=\"generator\" content=\"OPTIweb VOPTIweb\" />\n" +
				"<title>0.1 - V0.1</title>\n" +
				"<link rel=\"stylesheet\" href=\"http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css\" />\n" +
				"<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css\" />\n" +
				"<script src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>    <!-- 3 -->\n" +
				"<script src=\"http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js\"></script>\n" +
				"<style type='text/css'>\n" +
				"@media all and (orientation:portrait) { .landscape {display: none;} }\n" +
				"@media all and (orientation:landscape) { .landscape {display: inline;} }\n" +
				"</style>\n" +
				"</head><body>");
		
	}
	
	private static String genererPageAcceuil(){
		
		return("<!-- DEBUT page accueil -->\n" +
				"<div data-role=\"page\" id=\"accueil\" data-title=\"OPTIweb - V0.1\">\n" +
				"<div data-role=\"header\" data-add-back-btn=\"true\">\n" +
				"<h1>P<span class=\"landscape\">rojets </span>tut<span class=\"landscape\">orés</span> 2014-2015<br/>Département INFO<span class=\"landscape\">RMATIQUE</span><br/>IUT de Blagnac</h1>\n" +
				"<a href=\"#credits\" data-theme=\"b\" class=\"ui-btn-right\">Crédits</a>   <!-- 1 -->\n" +
				"</div>\n" +
				"<div data-role=\"content\">\n" +
				"<ul data-role=\"listview\" data-inset=\"true\" id=\"listeSources\">\n" +
				"<li><a href=\"#projets\"><i class=\"fa fa-tasks\"></i> Projets</a></li>   <!-- 1 -->\n" +
				"<li><a href=\"#sujets\"><i class=\"fa fa-copy\"></i> Sujets</a></li>   <!-- 1 -->\n" +
				"<li><a href=\"#etudiants\"><i class=\"fa fa-group\"></i> Etudiants</a></li>   <!-- 1 -->\n" +
				"<li><a href=\"#intervenants\"><i class=\"fa fa-group\"></i> Intervenants</a></li>   <!-- 1 -->\n" +
				"</ul>\n" +
				"</div>\n" +
				"<div data-role=\"footer\">\n" +
				" <h4>OPTIweb V<span class=\"landscape\">ersion </span>0.1 <i class=\"fa fa- fa-2x\"></i></h4>\n" +
				"</div>\n" +
				"</div>\n" +
				"<!-- FIN page accueil -->");
		
	}

	private static String genererPageProjets(ArrayList<Projet> dbProjet,ArrayList<Encadrer> dbEnc){
		
		String str =("<!-- DEBUT page projets -->\n" +
				"<div data-role=\"page\" id=\"projets\" data-title=\"OPTIweb - V0.1\">\n" +
				"<div data-role=\"header\" data-add-back-btn=\"true\">\n" +
				"<h1>Projets 2014-2015</h1>\n" +
				"</div>\n" +
				"<div data-role=\"content\">\n" +
				"<form class=\"ui-filterable\">\n" +
				"<input id=\"autocomplete-input-projet\" name=\"projet\" data-type=\"search\" placeholder=\"Vous cherchez ?...\">   <!-- 1 -->\n" +
				"</form>\n" +
				"<ol id=\"listeprojets\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-projet\">\n");

		
		
		for(Projet proj : dbProjet){
			
			str+="<li>" +
					"<p>" +
					"<b>["+proj.getSujet().getNom()+"]</b> "+proj.getSujet().getTitre()+"\n" +
					"</p>\n" +
					"<p>\n" +
					"<b>Client :</b> "+Encadrer.getInterFromProjetRole(dbEnc, proj, Role.Client).getNom()+" "+Encadrer.getInterFromProjetRole(dbEnc, proj, Role.Client).getPrenom()+"\n" +
					"</p>" +
					"<p>\n" +
					"<b>Superviseur :</b> "+Encadrer.getInterFromProjetRole(dbEnc, proj, Role.Superviseur).getNom()+" "+Encadrer.getInterFromProjetRole(dbEnc, proj, Role.Superviseur).getPrenom()+"\n" +
					"</p>\n" +
					"<p>\n" +
					"<b>Groupe "+proj.getGroupe().getLibelle()+" :</b>";
			
			for(Etudiant etu : proj.getGroupe().getMembres()){
				str+=" " + etu.getPrenom() + " " + etu.getNom() + " -";
			}
			
			str+="</p>\n" +
			"</li>\n";
			
		}
		
	str+=("</ol>\n" +
			"</div>\n" +
			"<div data-role=\"footer\">\n" +
			"<h4>OPTIweb <span class=\"landscape\">Version </span>0.1 <i class=\"fa fa-tasks fa-2x\"></i></h4>\n" +
			"</div>\n" +
			"</div>\n" +
			"<!-- FIN page projets -->");

	return str;
		
	}
	
	private static String genererPageSujets(ArrayList<Sujet> dbSujet, ArrayList<Projet> dbProjet){

		String str =("<!-- DEBUT page sujets -->\""
			+ "<div data-role=\"page\" id=\"sujets\" data-title=\"OPTIweb - V0.1\">\n"
			+ "<div data-role=\"header\" data-add-back-btn=\"true\">\n"
			+ "<h1>Sujets 2014-2015</h1>\n"
			+ "</div>\n"
			+ "<div data-role=\"content\">\n"
			+ "<form class=\"ui-filterable\">\n"
			+ "<input id=\"autocomplete-input-sujet\" name=\"sujet\" data-type=\"search\" placeholder=\"Vous cherchez ?\">    <!-- 2 -->\n"
			+ "</form>\n"
			+ "<ol id=\"listesujets\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-sujet\" data-divider-theme=\"b\" data-count-theme=\"a\">\n"
			+ "<li data-role=\"list-divider\">    <!-- 3 -->\n"
			+ "Sujet<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe</span>\n"
			+ "</li>");
		
		for(Sujet sjt : dbSujet){
			
			str+=("<li data-find=\"["+sjt.getNom()+"]\">\n"
					+ "<a href=\"#projets\">["+sjt.getNom()+"] <br/>\n"
					+ "<div style=\"white-space:normal;\">\n"
					+ "<span><b>"+sjt.getTitre()+"</b>\n"
					+ "</span><span class=\"ui-li-count\">");
			
			for(Projet pjt : dbProjet){
				if(pjt.getSujet()==sjt){
					str+=pjt.getGroupe().getLibelle()+" ";
				}
			}
			
			str+="</span>\n"
				+ "</div>\n"
				+ "</a>\n"
				+ "</li>";
			
		}
		
		str+="</ol>\n"
			+ "</div>\n"
			+ "<div data-role=\"footer\">\n"
			+ "<h4>OPTIweb <span class=\"landscape\">Version </span>0.1 <i class=\"fa fa-copy fa-2x\"></i></h4>\n"
			+ "</div>\n"
			+ "</div>\n"
			+ "<!-- FIN page sujets -->\"";

		return str;
		
	}
	
	private static String genererPageEtudiants(ArrayList<Etudiant> dbEtu){
		
		String str =  "		<!-- DEBUT page etudiants -->\n"
			+ "<div data-role=\"page\" id=\"etudiants\" data-title=\"OPTIweb - V0.1\">\n"
			+ "<div data-role=\"header\" data-add-back-btn=\"true\">    <!-- 1 -->\n"
			+ "<h1>Etudiants 2014-2015</h1>\n"
			+ "</div>\n"
			+ "<div data-role=\"content\">\n"
			+ "<form class=\"ui-filterable\">\n"
			+ "<input id=\"autocomplete-input-etudiant\" name=\"etudiant\" data-type=\"search\" placeholder=\"Etudiant ou Groupe X\">    <!-- 2 -->\n"
			+ "</form>\n"
			+ "<ol id=\"listeetudiants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-etudiant\" data-divider-theme=\"b\">\n"
			+ "<li data-role=\"list-divider\">\n"
			+ "Etudiant<span class=\"ui-li-count\" title=\"Groupe\" style=\"right: 40px !important;\">Groupe</span>\n"
			+ "</li>\n";
		
		for(Etudiant etu : dbEtu){
			
			str+="<li data-find=\""+etu.getPrenom() + " " + etu.getNom()+"\">\n"
				+ "<a href=\"#projets\">"+etu.getNom()+" "+etu.getPrenom()+"<span class=\"ui-li-count\" title=\"Groupe\">Groupe "+etu.getGroupe().getLibelle()+"</span>\n"
				+ "</a>\n"
				+ "</li>\n";
			
		}

		str+="</ol>\n"
			+ "</div>\n"
			+ "<div data-role=\"footer\">\n"
			+ "<h4>OPTIweb <span class=\"landscape\">Version </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4>\n"
			+ "</div>\n"
			+ "</div>\n"
			+ "<!-- FIN page etudiants -->\n";
		
		return str;
		
	}
	
	private static String genererPageIntervenants(ArrayList<Intervenant> dbInter, ArrayList<Encadrer> dbEnc){
		
		String str = "<!-- DEBUT page intervenants -->\n"
			+ "<div data-role=\"page\" id=\"intervenants\" data-title=\"OPTIweb - V0.1\">\n"
			+ "<div data-role=\"header\" data-add-back-btn=\"true\">\n"
			+ "<h1>Intervenants 2014-2015</h1>\n"
			+ "</div>\n"
			+ "<div data-role=\"content\">"
			+ "<form class=\"ui-filterable\">\n"
			+ "<input id=\"autocomplete-input-intervenant\" name=\"intervenant\" data-type=\"search\" placeholder=\"Intervenant\">    <!-- 2 -->\n"
			+ "</form>\n"
			+ "<ul id=\"listeintervenants\" data-role=\"listview\" data-inset=\"true\" data-filter=\"true\" data-filter-reveal=\"false\" data-input=\"#autocomplete-input-intervenant\" data-divider-theme=\"b\">\n"
			+ "<li data-role=\"list-divider\">    <!-- 3 -->\n"
			+ "Intervenant<span class=\"ui-li-count\" style=\"right: 110px !important;\" title=\"Client\">Client</span><span class=\"ui-li-count\" title=\"Superviseur\">Superviseur</span>\n"
			+ "</li>";

		
		for(Intervenant inter : dbInter){
			
			str+="<li data-find=\""+inter.getNom()+" "+inter.getPrenom()+"\">\n"
			+ "<a href=\"#projets\">"
			+ inter.getNom()+" "+inter.getPrenom();
			
			int client = 0;
			int superviseur = 0;
			
			for(Encadrer enc : dbEnc){
				if(enc.getIntervenant()==inter){
					if(enc.role==Role.Client){
						client++;
					}
					if(enc.role==Role.Superviseur){
						superviseur++;
					}
				}
			}
			
			str+="<span class=\"ui-li-count\" style=\"right: 120px !important;\" title=\"Client\">"+client+"</span>\n"
			+ "<span class=\"ui-li-count\" title=\"Superviseur\">"+superviseur+"</span>\n"
			+ "</a>\n"
			+ "</li>\n";
			
		}
		
		str += "</ul>\n"
		+ "</div>\n"
		+ "<div data-role=\"footer\">\n"
		+ "<h4>OPTIweb <span class=\"landscape\">Version </span>0.1 <i class=\"fa fa-group fa-2x\"></i></h4>\n"
		+ "</div>\n"
		+ "</div>\n"
		+ "<!-- FIN page intervenants -->";
		
		return str;
		
	}
	
	private static String genererPageCredits(){
		
		String str = "<!-- DEBUT page credits -->\n"
		+ "<div data-role=\"page\" id=\"credits\" data-title=\"OPTIweb - V0.1 - Crédits\">\n"
		+ "<div data-role=\"header\" data-add-back-btn=\"true\">    <!-- 1 -->\n"
		+ "<h1>Crédits</h1>\n"
		+ "</div>\n"
		+ "<div data-role=\"content\">\n"
		+ "<p>Cette application a été réalisée dans le cadre du module M3301/MPA du DUT Informatique à l'IUT de Blagnac.</p>\n"
		+ "<ul data-role=\"listview\" data-inset=\"true\" id=\"contacts\" data-theme=\"a\" data-divider-theme=\"b\">\n"
		+ "<li data-role=\"list-divider\">Product Owner</li>\n"
		+ "<li>André PÉNINOU</li>\n"
		+ "<li>Université Toulouse 2 - IUT de Blagnac\n"
		+ "<br/>Département INFORMATIQUE</li>\n"
		+ "</ul>\n"
		+ "<ul data-role=\"listview\" data-inset=\"true\" id=\"listecredits\" data-theme=\"a\" data-divider-theme=\"b\">\n"
		+ "<li data-role=\"list-divider\">Membres de l'équipe enseignante</li>\n"
		+ "<li>Jean-Michel BRUEL</li><li>Jean-Michel INGLEBERT</li><li>André PÉNINOU</li><li>Olivier ROQUES</li>\n"
		+ "</ul>\n"
		+ "<ul data-role=\"listview\" data-inset=\"true\" id=\"listepowered\" data-theme=\"a\" data-divider-theme=\"b\">\n"
		+ "<li data-role=\"list-divider\">Propulsé par</li>\n"
		+ "<li><a href=\"http://jquerymobile.com/\" target=\"autrePage\">http://jquerymobile.com/</a></li>\n"
		+ "<li><a href=\"http://fortawesome.github.io/Font-Awesome/\" target=\"autrePage\">http://fortawesome.github.io/Font-Awesome/</a></li>\n"
		+ "</ul>\n"
		+ "</div>\n"
		+ "<div data-role=\"footer\">\n"
		+ "<h4>OPTIweb <span class=\"landscape\">Version </span>0.1 <i class=\"fa fa- fa-2x\"></i></h4>\n"
		+ "</div>\n"
		+ "</div>\n"
		+ "<!-- FIN page credits -->\n";
		
		return str;
		
	}
	
	private static String genererFinHTML(){
		//Ajout de la fin de la page HTML
		return("<script>\n" +
				"$( 'li[data-find]' ).on( 'click',function(event){\n" +
				"$(\"#autocomplete-input-projet\").val($(this).attr('data-find')).trigger('change');\n" +
				"});\n" +
				"</script>\n" +
				"</body>\n" +
				"</html>");
	}

}
