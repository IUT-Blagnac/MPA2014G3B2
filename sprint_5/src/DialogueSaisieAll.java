import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class DialogueSaisieAll extends JDialog {
	
	private boolean bonneFin = false;
	
	public JTextField id;
	public JTextField nom;
	public JTextField titreS;
	public JTextField Lecontenu;
	public JTextField nomGroupeEtu;
	
	public JComboBox<String> titre;
	public JComboBox<String> nomGroupe;
	
	public JComboBox<String> idInter;
	public JComboBox<String> idInter2;
	public JComboBox<String> idInter3;
	
	public JTextField prenom;
	
	public JTextField contenuSujet;

	
	public static void main(String[] args) {
		JFrame accueil = new JFrame("rien");
		/*
		DialogueSaisieAll dia = new DialogueSaisieAll(accueil,"Fenetre Créer Etudiant",1);
		dia.setVisible(true);
		
		DialogueSaisieAll dia2 = new DialogueSaisieAll(accueil,"Fenetre Créer Intervenant",2);
		dia2.setVisible(true);
		
			DialogueSaisieAll dia4 = new DialogueSaisieAll(accueil,"Fenetre Créer Sujet",4);
		dia4.setVisible(true);
		*/
		DialogueSaisieAll dia3 = new DialogueSaisieAll(accueil,"Fenetre Créer Projet",3);
		dia3.nomGroupe.addItem("TROLOLO");
		dia3.setVisible(true);
		
	
		
		
	}
	
	public DialogueSaisieAll(JFrame fenetreMere, String titre, int type) {
		super(fenetreMere, titre, true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocation(400, 400);
		
		switch (type) {
		case 1:
			this.setContentPane(ContenuEtudiant());
			break;
		case 2:
			this.setContentPane(ContenuIntervant());
			break;
		case 3:
			this.setContentPane(ContenuProjet());
			break;
		case 4:
			this.setContentPane(ContenuSujet());
			break;
		default:
			System.out.println("Erreur");
			dispose();
			break;
		}

	}
	
	//*****************************************************RELATIF AU PROJETS****************************************************************////////////
	private JPanel ContenuProjet() {
		setSize(500, 300);
		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());
		
		JPanel contenu = new JPanel();
		
		JPanel vars = new JPanel();

		JPanel Jtitre = new JPanel();
		JPanel JnomGroupe = new JPanel();
		JPanel JnomInter = new JPanel();
		JPanel JnomInter2 = new JPanel();
		JPanel JnomInter3 = new JPanel();
		
	
		
		JPanel boutons = new JPanel();
		
		
		JLabel Titre = new JLabel("Création Projets");
		Titre.setFont(new Font("", 0, 28));
		Titre.setHorizontalAlignment(JLabel.CENTER);
		

		JLabel Ltitre = new JLabel("id du sujet: ");
		JLabel LnomGroupe = new JLabel("nom du groupe : ");
		JLabel LnomInter = new JLabel("intervenant: ");
		JLabel LnomInter2 = new JLabel("Client: ");
		JLabel LnomInter3 = new JLabel("intervenant 3 : ");

		
		titre = new JComboBox<String>();
		nomGroupe = new JComboBox<String>();
		idInter = new JComboBox<String>();
		idInter2 = new JComboBox<String>();
		idInter3 = new JComboBox<String>();
		
		
		
		

		//titre.setPreferredSize(new Dimension(120, 20));
		//nomGroupe.setPreferredSize(new Dimension(120, 20));

		
		
		

		Ltitre.setHorizontalTextPosition(JLabel.LEFT);
		LnomGroupe.setHorizontalTextPosition(JLabel.LEFT);
		LnomInter.setHorizontalTextPosition(JLabel.RIGHT);
		LnomInter2.setHorizontalTextPosition(JLabel.RIGHT);
		LnomInter3.setHorizontalTextPosition(JLabel.RIGHT);





		Jtitre.add(Ltitre);
		Jtitre.add(titre);

		
		JnomGroupe.add(LnomGroupe);
		JnomGroupe.add(nomGroupe);

		JnomInter.add(LnomInter);
		JnomInter.add(idInter);
		
		JnomInter2.add(LnomInter2);
		JnomInter2.add(idInter2);
		
		JnomInter3.add(LnomInter3);
		JnomInter3.add(idInter3);

		vars.setLayout(new GridLayout(2 , 2));
		
		vars.add(Jtitre);
		vars.add(JnomGroupe);
		vars.add(JnomInter);
		vars.add(JnomInter2);
		vars.add(JnomInter3);
		
		contenu.setLayout(new GridLayout(2, 1));
		contenu.add(vars);
		result.add(Titre,BorderLayout.NORTH);
		result.add(contenu,BorderLayout.CENTER);
		
		
		JButton ok = new JButton("OK");
		JButton annule = new JButton("Annuler");
		
		ok.setPreferredSize(annule.getPreferredSize());
		result.add(boutons,BorderLayout.SOUTH);
		boutons.setLayout(new FlowLayout());
		boutons.add(ok);
		boutons.add(annule);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonOkProjets();
			}
		});
		annule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonAnnuler();
			}
		});
		
		
		return result;
	}

	
	
	protected void actionBoutonOkProjets() {
		if(donneesValidesProjets()){
			bonneFin = true;
			dispose();
		}
	}
	private boolean donneesValidesProjets() {

		
			return true;
						
		
	}
	
//////////////////////*********************************RELATIF AUX SUJETS********************************************************************
	private JPanel ContenuSujet() {
		setSize(390, 300);
		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());
		
		JPanel contenu = new JPanel();
		
		JPanel vars = new JPanel();

		JPanel Jtitre = new JPanel();
		JPanel JContenu = new JPanel();
	
		
		JPanel boutons = new JPanel();
		
		
		JLabel Titre = new JLabel("Création Sujet");
		Titre.setFont(new Font("", 0, 28));
		Titre.setHorizontalAlignment(JLabel.CENTER);
		

		JLabel Ltitre = new JLabel("Titre : ");
		JLabel LContenu = new JLabel("Contenu : ");

		

		titreS = new JTextField();
		Lecontenu = new JTextField();

		
		

		titreS.setPreferredSize(new Dimension(120, 20));
		Lecontenu.setPreferredSize(new Dimension(220, 20));

		
		vars.setLayout(new GridLayout(2, 4));
		

		Ltitre.setHorizontalTextPosition(JLabel.LEFT);
		LContenu.setHorizontalTextPosition(JLabel.RIGHT);



		Jtitre.setLayout(new FlowLayout());
		JContenu.setLayout(new FlowLayout());
		


		Jtitre.add(Ltitre);
		Jtitre.add(titreS);

		
		JContenu.add(LContenu);
		JContenu.add(Lecontenu);
		
		

		vars.add(Jtitre);
		vars.add(JContenu);
	
		
		contenu.setLayout(new GridLayout(2, 1));
		contenu.add(vars);
		result.add(Titre,BorderLayout.NORTH);
		result.add(contenu,BorderLayout.CENTER);
		
		
		JButton ok = new JButton("OK");
		JButton annule = new JButton("Annuler");
		
		ok.setPreferredSize(annule.getPreferredSize());
		result.add(boutons,BorderLayout.SOUTH);
		boutons.setLayout(new FlowLayout());
		boutons.add(ok);
		boutons.add(annule);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonOkSujets();
			}
		});
		annule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonAnnuler();
			}
		});
		
		
		return result;
	}

	
	
	protected void actionBoutonOkSujets() {
		if(donneesValidesSujets()){
			bonneFin = true;
			dispose();
		}
	}
	private boolean donneesValidesSujets() {

		if (titreS.getText() != "" && Lecontenu.getText() != "" && titreS.getText().length() > 2 && Lecontenu.getText().length() > 2 ) 
		{
			return true;
						
		} else {
				infoInvalide("le titre ou le nom du contenu n'est pas correct");
				return false;
		}
	}
	
///************************/*******************************RELATIF AUX INTERVENANTS****************************************************//////////////////////////////
	private JPanel ContenuIntervant() {
		setSize(390, 300);
		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());
		
		JPanel contenu = new JPanel();
		
		JPanel vars = new JPanel();

		JPanel Jid = new JPanel();
		JPanel Jnom = new JPanel();
		JPanel Jprenom = new JPanel();
		JPanel boutons = new JPanel();
		
		
		JLabel Titre = new JLabel("Création Intervenant");
		Titre.setFont(new Font("", 0, 28));
		Titre.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel Lid = new JLabel("ID : ");
		JLabel Lnom = new JLabel("Nom : ");
		JLabel Lprenom = new JLabel("Prenom : ");

		
		id = new JTextField();
		nom = new JTextField();
		prenom = new JTextField();
		
		
		id.setPreferredSize(new Dimension(90, 20));
		nom.setPreferredSize(new Dimension(120, 20));
		prenom.setPreferredSize(new Dimension(120, 20));

		
		vars.setLayout(new GridLayout(2, 4));
		
		Lid.setHorizontalTextPosition(JLabel.LEFT);
		Lnom.setHorizontalTextPosition(JLabel.LEFT);
		Lprenom.setHorizontalTextPosition(JLabel.RIGHT);


		Jid.setLayout(new FlowLayout());
		Jnom.setLayout(new FlowLayout());
		Jprenom.setLayout(new FlowLayout());
		
		
		Jnom.add(Lnom);
		Jnom.add(nom);
		Jid.add(Lid);
		Jid.add(id);
		
		Jprenom.add(Lprenom);
		Jprenom.add(prenom);
		
		
		vars.add(Jid);
		vars.add(Jnom);
		vars.add(Jprenom);
	
		
		contenu.setLayout(new GridLayout(2, 1));
		contenu.add(vars);
		result.add(Titre,BorderLayout.NORTH);
		result.add(contenu,BorderLayout.CENTER);
		
		
		JButton ok = new JButton("OK");
		JButton annule = new JButton("Annuler");
		
		ok.setPreferredSize(annule.getPreferredSize());
		result.add(boutons,BorderLayout.SOUTH);
		boutons.setLayout(new FlowLayout());
		boutons.add(ok);
		boutons.add(annule);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonOkIntervenants();
			}
		});
		annule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonAnnuler();
			}
		});
		
		
		return result;
	}
	
	
	protected void actionBoutonOkIntervenants() {
		if(donneesValidesIntervenants()){
			bonneFin = true;
			dispose();
		}
	}
	
	private boolean donneesValidesIntervenants() {

		if (nom.getText() != "" && prenom.getText() != ""&& id.getText() != "" && nom.getText().length() > 2 && prenom.getText().length() > 2 && id.getText().length() > 2) 
		{
			return true;
						
		} else {
				infoInvalide("pas de nom, de prenom, d'identifiant correcte ou le prenom , le nom et l'id est inferieur a 3 carracteres");
				return false;
		}
	}
	
	//////////////////*********************************************RELATIF AUX ETUDIANTS******************************************//////////////////////////////

	private JPanel ContenuEtudiant() {
		setSize(390, 300);
		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());
		
		
		JPanel contenu = new JPanel();
		
		JPanel vars = new JPanel();

		JPanel Jid = new JPanel();
		JPanel Jnom = new JPanel();
		JPanel Jprenom = new JPanel();
		JPanel Jgroupe = new JPanel();
		
		JPanel boutons = new JPanel();
		
		
		JLabel Titre = new JLabel("Création étudiant");
		Titre.setFont(new Font("", 0, 28));
		Titre.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel Lid = new JLabel("ID : ");
		JLabel Lnom = new JLabel("Nom : ");
		JLabel Lprenom = new JLabel("Prenom : ");
		JLabel Lgroupe = new JLabel("Groupe : ");
		
		id = new JTextField();
		nom = new JTextField();
		prenom = new JTextField();
		nomGroupeEtu = new JTextField();
		
		
		id.setPreferredSize(new Dimension(90, 20));
		nom.setPreferredSize(new Dimension(120, 20));
		prenom.setPreferredSize(new Dimension(120, 20));
		nomGroupeEtu.setPreferredSize(new Dimension(90, 20));
		
		vars.setLayout(new GridLayout(3, 4));
		
		Lid.setHorizontalTextPosition(JLabel.LEFT);
		Lnom.setHorizontalTextPosition(JLabel.LEFT);
		Lprenom.setHorizontalTextPosition(JLabel.RIGHT);

		Jid.setLayout(new FlowLayout());
		Jnom.setLayout(new FlowLayout());
		Jprenom.setLayout(new FlowLayout());
		Jgroupe.setLayout(new FlowLayout());

		Jnom.add(Lnom);
		Jnom.add(nom);
		Jid.add(Lid);
		Jid.add(id);
		
		Jprenom.add(Lprenom);
		Jprenom.add(prenom);
		
		Jgroupe.add(new JLabel("          "));
		Jgroupe.add(Lgroupe);
		Jgroupe.add(nomGroupeEtu);
		
		vars.add(Jid);
		vars.add(Jnom);
		vars.add(Jprenom);
		vars.add(Jgroupe);
		
		contenu.add(vars);
		result.add(Titre,BorderLayout.NORTH);
		result.add(contenu,BorderLayout.CENTER);
		
		
		JButton ok = new JButton("OK");
		JButton annule = new JButton("Annuler");
		
		ok.setPreferredSize(annule.getPreferredSize());
		result.add(boutons,BorderLayout.SOUTH);
		boutons.setLayout(new FlowLayout());
		boutons.add(ok);
		boutons.add(annule);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonOkEtudiants();
			}
		});
		annule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonAnnuler();
			}
		});
		
		
		return result;
	}



	protected void actionBoutonOkEtudiants() {
		if(donneesValidesEtudiants()){
			bonneFin = true;
			dispose();
		}
	}
	
	
	
	
	private boolean donneesValidesEtudiants() {

		if (nom.getText() != "" && prenom.getText() != ""
				&&  id.getText() != "") {
			if (nom.getText().length() > 2
					&& prenom.getText().length() > 2
					&&  id.getText().length() == 3) {
							for (int y = 0; y < 3; y++) {
								if (!Character.isDigit(id.getText().charAt(y))) {
									infoInvalide("id non-numérique");
									return false;
								}
							}
						return true;
					
			}
		}
		infoInvalide("pas de nom, de prenom ou d'idantifiant correte");
		return false;
	}
	
	/////////////////////////////////////////*************************RELATIF A TOUT LE MONDE*******************************************////////////////////////////////
	protected void actionBoutonAnnuler() {
		dispose();
	}
	
	public boolean getBonneFin() {
		return bonneFin;
	}
	
	private void infoInvalide(String message) {
		JOptionPane
				.showMessageDialog(
						this,
						"Ces données sont invalides : "
								+ message
								+ "\nIl faut : un identifiant de trois chiffres,\n"
								+ "un prenom et un nom d'au moins 3 lettre.\n",
						"Données invalides", JOptionPane.WARNING_MESSAGE);
	}



	public void tableauInter(ArrayList<Intervenant> intervenants) {
		for (int i = 0; i < intervenants.size(); i++) {
			idInter.addItem(intervenants.get(i).getIdInter());
		}
	}

	public void tableauInter2(ArrayList<Intervenant> intervenants) {
		for (int i = 0; i < intervenants.size(); i++) {
			idInter2.addItem(intervenants.get(i).getIdInter());
		}
	}

	public void tableauInter3(ArrayList<Intervenant> intervenants) {
		for (int i = 0; i < intervenants.size(); i++) {
			idInter3.addItem(intervenants.get(i).getIdInter());
		}
	}
	
	public void tableauNomSujet(ArrayList<Sujet> sujets) {
			for (int i=0; i<sujets.size();i++){
				titre.addItem(sujets.get(i).getTitre());
			}	
	}
	
	public void tableauNomGroupe(HashMap<String, ArrayList<String>> groupes) {
		for (String hoho : groupes.keySet()) {
			nomGroupe.addItem(hoho);
		}
}
	
}
