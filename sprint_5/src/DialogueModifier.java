import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DialogueModifier extends JDialog {
	private boolean bonneFin = false;

	public JTextField id;
	public JTextField nom;
	public JTextField titreS;
	// public JTextField titre;
	public JTextArea Lecontenu;
	public JTextField nomGroupeEtu;

	public JComboBox titre;
	public JComboBox nomGroupe;
	// public JComboBox nomInter;

	public JTextField prenom;

	public JTextField contenuSujet;

	public JComboBox<String> idInter;

	public JComboBox<String> idInter2;

	public JComboBox<String> idInter3;

	public static void main(String[] args) {
		JFrame accueil = new JFrame("rien");
		ArrayList<Etudiant> prout = new ArrayList<Etudiant>();
		prout.add(new Etudiant("123", "prout", "lepauvre", "lessoustache"));
		prout.add(new Etudiant("123", "sdfs", "lepauvsdfre", "lessoustache"));
		prout.add(new Etudiant("123", "prosdfsdfut", "lepasdfsfuvre",
				"lesssdfsfoustache"));
		prout.add(new Etudiant("123", "prosdfsfskuyhujkut", "lsdfsfsepauvre",
				"sdfsfsdfs"));

		ArrayList<Intervenant> tableInter = new ArrayList<Intervenant>();
		tableInter.add(new Intervenant("123", "blabla", "bloblo"));

		ArrayList<Sujet> tableSujet = new ArrayList<Sujet>();
		tableSujet.add(new Sujet("123", "blabla"));

		ArrayList<Projet> tableProjet = new ArrayList<Projet>();
		tableProjet.add(new Projet("123", "lala", "lol", "prtot", "rzer",
				"xwdfs", "dsfdf", "ljlksfd"));

		/*
		 * DialogueModifier dia = new
		 * DialogueModifier(accueil,"Fenetre Modifier Etudiant",1,prout);
		 * dia.setVisible(true);
		 * 
		 * 
		 * DialogueModifier dia2 = new
		 * DialogueModifier(accueil,"Fenetre Modifier Intervenant",2,
		 * tableInter); dia2.setVisible(true);
		 * 
		 * DialogueModifier dia3 = new
		 * DialogueModifier(accueil,"Fenetre Modifier Sujet",4,tableSujet);
		 * dia3.setVisible(true);
		 */

		DialogueModifier dia4 = new DialogueModifier(accueil,
				"Fenetre Modifier Sujet", 3, tableProjet);
		dia4.setVisible(true);

	}

	public DialogueModifier(JFrame fenetreMere, String titre, int type,
			Object guyAmodif) {
		super(fenetreMere, titre, true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocation(400, 400);
		setSize(390, 300);
		switch (type) {
		case 1:
			this.setContentPane(ModifierEtudiant(guyAmodif));
			break;
		case 2:
			this.setContentPane(ModifierIntervenant(guyAmodif));
			break;
		case 3:
			this.setContentPane(ModifierSujet(guyAmodif));
			break;
		case 4:
			this.setContentPane(ModifierProjet(guyAmodif));
			break;
		default:
			System.out.println("Erreur");
			dispose();
			break;
		}

	}

	// ////////////////*********************************************RELATIF AUX
	// ETUDIANTS******************************************//////////////////////////////

	private JPanel ModifierEtudiant(Object guyAmodif) {
		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());

		JPanel contenu = new JPanel();
		JPanel vars = new JPanel();
		JPanel Jid = new JPanel();
		JPanel Jnom = new JPanel();
		JPanel Jprenom = new JPanel();
		JPanel JnomGroupeEtu = new JPanel();
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

		id.setEditable(false);

		id.setPreferredSize(new Dimension(90, 20));
		nom.setPreferredSize(new Dimension(120, 20));
		prenom.setPreferredSize(new Dimension(120, 20));
		nomGroupeEtu.setPreferredSize(new Dimension(120, 20));

		vars.setLayout(new GridLayout(2, 4));

		Lid.setHorizontalTextPosition(JLabel.LEFT);
		Lnom.setHorizontalTextPosition(JLabel.LEFT);
		Lprenom.setHorizontalTextPosition(JLabel.RIGHT);

		Jid.setLayout(new FlowLayout());
		Jnom.setLayout(new FlowLayout());
		Jprenom.setLayout(new FlowLayout());
		JnomGroupeEtu.setLayout(new FlowLayout());

		Jnom.add(Lnom);
		Jnom.add(nom);
		Jid.add(Lid);
		Jid.add(id);

		Jprenom.add(Lprenom);
		Jprenom.add(prenom);

		JnomGroupeEtu.add(Lgroupe);
		JnomGroupeEtu.add(nomGroupeEtu);

		vars.add(Jid);
		vars.add(Jnom);
		vars.add(Jprenom);
		vars.add(JnomGroupeEtu);

		contenu.setLayout(new GridLayout(2, 1));
		contenu.add(vars);
		// result.add(Titre,BorderLayout.NORTH);
		result.add(contenu, BorderLayout.CENTER);

		JButton enrengistrer = new JButton("Enregistrer");
		JButton sortir = new JButton("Sortir");

		result.add(boutons, BorderLayout.SOUTH);
		boutons.setLayout(new FlowLayout());
		boutons.add(enrengistrer);
		boutons.add(sortir);

		/* **************SETTEXT ******** */

		id.setText(((Etudiant) guyAmodif).getIde());
		nom.setText(((Etudiant) guyAmodif).getGroupe());
		prenom.setText(((Etudiant) guyAmodif).getPrenom());
		nomGroupeEtu.setText(((Etudiant) guyAmodif).getGroupe());

		enrengistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonEnrengistrerEtu();
			}
		});
		sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonSortir();
			}
		});

		return result;
	}

	protected void actionBoutonEnrengistrerEtu() {
		if (donneesValidesEtudiants()) {
			bonneFin = true;
			dispose();
		}
	}

	private boolean donneesValidesEtudiants() {

		if (nom.getText() != "" && prenom.getText() != "" && id.getText() != "") {
			if (nom.getText().length() > 2 && prenom.getText().length() > 2
					&& id.getText().length() > 2) {

				return true;
			}

		}
		infoInvalide("pas de nom, de prenom, d'idantifiant ou d'adresse correcte");
		return false;
	}

	// *****************************************************RELATIF AU
	// PROJETS****************************************************************////////////
	private JPanel ModifierProjet(Object guyAmodif) {
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

		// titre.setPreferredSize(new Dimension(120, 20));
		// nomGroupe.setPreferredSize(new Dimension(120, 20));

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

		vars.setLayout(new GridLayout(2, 2));

		vars.add(Jtitre);
		vars.add(JnomGroupe);
		vars.add(JnomInter);
		vars.add(JnomInter2);
		vars.add(JnomInter3);

		contenu.setLayout(new GridLayout(2, 1));
		contenu.add(vars);
		result.add(Titre, BorderLayout.NORTH);
		result.add(contenu, BorderLayout.CENTER);

		JButton enregistrer = new JButton("Enregistrer");
		JButton annule = new JButton("Annuler");

		enregistrer.setPreferredSize(annule.getPreferredSize());
		result.add(boutons, BorderLayout.SOUTH);
		boutons.setLayout(new FlowLayout());
		boutons.add(enregistrer);
		boutons.add(annule);

		/* **************SETTEXT ******** */
		titre.setSelectedItem(((Projet)guyAmodif).getSujet());
		nomGroupe.setSelectedItem(((Projet)guyAmodif).getNomG());
		idInter.setSelectedItem(((Projet)guyAmodif).getInterv1());
		idInter2.setSelectedItem(((Projet)guyAmodif).getInterv2());
		idInter3.setSelectedItem(((Projet)guyAmodif).getInterv3());

		enregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonEnrengistrerProjet();
			}
		});
		annule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonAnnuler();
			}
		});

		return result;
	}

	protected void actionBoutonAnnuler() {
		dispose();
	}

	protected void actionBoutonOkProjets() {
		if (donneesValidesProjets()) {
			bonneFin = true;
			dispose();
		}
	}

	private boolean donneesValidesProjets() {

		return true;

	}

	protected void actionBoutonEnrengistrerProjet() {
		if (donneesValidesProjets()) {
			bonneFin = true;
			dispose();
		}
	}

	// ////////////////////*********************************RELATIF AUX
	// SUJETS********************************************************************
	private JPanel ModifierSujet(Object guyAmodif) {
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
		Lecontenu = new JTextArea();

		titreS.setPreferredSize(new Dimension(120, 20));
		Lecontenu.setPreferredSize(new Dimension(260, 60));

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
		result.add(contenu, BorderLayout.CENTER);

		JButton enrengistrer = new JButton("Enregistrer");
		JButton sortir = new JButton("Sortir");

		result.add(boutons, BorderLayout.SOUTH);
		boutons.setLayout(new FlowLayout());
		boutons.add(enrengistrer);
		boutons.add(sortir);

		/* **************SETTEXT ******** */

		titreS.setText(((Sujet) guyAmodif).getTitre());
		Lecontenu.setText(((Sujet) guyAmodif).getContenu());

		/* ********************* */

		enrengistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonEnrengistrerSujet();
			}
		});
		sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonSortir();
			}
		});

		return result;
	}

	protected void actionBoutonEnrengistrerSujet() {
		if (donneesValidesEtudiants()) {
			bonneFin = true;
			dispose();
		}
	}

	private boolean donneesValidesSujets() {

		if (titreS.getText() != "" && Lecontenu.getText() != ""
				&& titreS.getText().length() > 2
				&& Lecontenu.getText().length() > 2) {
			return true;

		} else {
			infoInvalide("le titre ou le nom du contenu n'est pas correct");
			return false;
		}
	}

	// /************************/*******************************RELATIF AUX
	// INTERVENANTS****************************************************//////////////////////////////
	private JPanel ModifierIntervenant(Object guyAmodif) {

		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());

		JPanel contenu = new JPanel();

		JPanel vars = new JPanel();

		JPanel Jid = new JPanel();
		JPanel Jnom = new JPanel();
		JPanel Jprenom = new JPanel();

		JPanel JPadr = new JPanel();
		JPanel boutons = new JPanel();

		JLabel Titre = new JLabel("Modifier Intervenant");
		Titre.setFont(new Font("", 0, 28));
		Titre.setHorizontalAlignment(JLabel.CENTER);

		JLabel Lid = new JLabel("ID : ");
		JLabel Lnom = new JLabel("Nom : ");
		JLabel Lprenom = new JLabel("Prenom : ");

		id = new JTextField();
		nom = new JTextField();
		prenom = new JTextField();

		id.setEditable(false);

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

		/*
		 * Jid. Jnom. Jprenom. Jage.
		 */

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
		contenu.add(JPadr);
		result.add(contenu, BorderLayout.CENTER);

		JButton enrengistrer = new JButton("Enregistrer");
		JButton sortir = new JButton("Sortir");

		result.add(boutons, BorderLayout.SOUTH);
		boutons.setLayout(new FlowLayout());
		boutons.add(enrengistrer);
		boutons.add(sortir);

		/* **************SETTEXT ******** */

		id.setText(((Intervenant) guyAmodif).getIdInter());
		nom.setText(((Intervenant) guyAmodif).getNomInter());
		prenom.setText(((Intervenant) guyAmodif).getPrenomInter());

		enrengistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonEnrengistrerInter();
			}
		});
		sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonSortir();
			}
		});

		return result;
	}

	protected void actionBoutonEnrengistrerInter() {
		if (donneesValidesEtudiants()) {
			bonneFin = true;
			dispose();
		}
	}

	private boolean donneesValidesIntervenants() {

		if (nom.getText() != "" && prenom.getText() != "" && id.getText() != ""
				&& nom.getText().length() > 2 && prenom.getText().length() > 2
				&& id.getText().length() > 2) {
			return true;

		} else {
			infoInvalide("pas de nom, de prenom, d'identifiant correcte ou le prenom , le nom et l'id est inferieur a 3 carracteres");
			return false;
		}
	}

	// ///////////////////////////////////////*************************RELATIF A
	// TOUT LE
	// MONDE*******************************************////////////////////////////////
	protected void actionBoutonSortir() {
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
								+ "\nIl faut : un idantifiant, un prenom et un nom d'au moins 3 lettre.\n"
								+ "De plus, l'adresse doit avoir un code postal sur le debut de la derniere ligne.",
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
		for (int i = 0; i < sujets.size(); i++) {
			titre.addItem(sujets.get(i).getTitre());
		}
	}

	public void tableauNomGroupe(HashMap<String, ArrayList<String>> groupes) {
		for (String hoho : groupes.keySet()) {
			nomGroupe.addItem(hoho);
		}

	}

}
