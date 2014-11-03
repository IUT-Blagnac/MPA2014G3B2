import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	// JPanel conteurOnglet = new JPanel();

	private ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
	private ArrayList<Intervenant> intervenants = new ArrayList<Intervenant>();
	private ArrayList<Projet> projets = new ArrayList<Projet>();
	private ArrayList<Sujet> sujets = new ArrayList<Sujet>();

	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

	private TableDefault tabAffEtus = new TableDefault();
	private TableDefault tabAffInter = new TableDefault();
	private TableDefault tabAffSujet = new TableDefault();
	private TableDefault tabAffProjet = new TableDefault();

	private HashMap<String, ArrayList<String>> groupes = new HashMap<String, ArrayList<String>>();

	//private ArrayList<String[]> donnéeCSV = new ArrayList<String[]>();

	public static void main(String[] args) {
		JFrame accueil = new Principal("Accueil");

		accueil.setLocation(500, 100);
		accueil.pack();

		accueil.setVisible(true);
	}

	public Principal(String titre) {
		super(titre);
		this.setLayout(new BorderLayout());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				quitter();
			}
		});

		this.add(barreDeMenus(), BorderLayout.NORTH);

		this.createFictivePeoples();
		affichageAll(1);
	}

	private void createFictivePeoples() {
		etudiants = Etudiant.lire("");
		intervenants = Intervenant.lire("");
		projets = Projet.lire("");
		sujets = Sujet.lire("");

	}

	private JMenuBar barreDeMenus() {
		JMenuBar barre = new JMenuBar();
		JMenu menuE = new JMenu("Etudiants");
		JMenu menuI = new JMenu("Intervenants");
		JMenu menuS = new JMenu("Sujets");
		JMenu menuP = new JMenu("Projets");

		JMenuItem itemQ = new JMenuItem("Quitter");
		barre.add(itemQ);
		itemQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitter();
			}
		});

		barre.add(menuE);
		barre.add(menuI);
		barre.add(menuS);
		barre.add(menuP);

		JMenuItem itemEC = new JMenuItem("Créer");
		menuE.add(itemEC);
		itemEC.addActionListener(new Ecouteur(0, 0));
		JMenuItem itemEM = new JMenuItem("Modifier ");
		menuE.add(itemEM);
		itemEM.addActionListener(new Ecouteur(0, 1));
		JMenuItem itemES = new JMenuItem("Supprimer");
		menuE.add(itemES);
		itemES.addActionListener(new Ecouteur(0, 2));
		JMenuItem itemEsave = new JMenuItem("Sauvegarde");
		menuE.add(itemEsave);
		itemEsave.addActionListener(new Ecouteur(0, 4));
		JMenuItem itemEopen = new JMenuItem("Ouvrir");
		menuE.add(itemEopen);
		itemEopen.addActionListener(new Ecouteur(0, 5));

		JMenuItem itemIC = new JMenuItem("Créer");
		menuI.add(itemIC);
		itemIC.addActionListener(new Ecouteur(1, 0));
		JMenuItem itemIM = new JMenuItem("Modifier ");
		menuI.add(itemIM);
		itemIM.addActionListener(new Ecouteur(1, 1));
		JMenuItem itemIS = new JMenuItem("Supprimer");
		menuI.add(itemIS);
		itemIS.addActionListener(new Ecouteur(1, 2));
		JMenuItem itemIsave = new JMenuItem("Sauvegarde");
		menuI.add(itemIsave);
		itemIsave.addActionListener(new Ecouteur(1, 4));
		JMenuItem itemIopen = new JMenuItem("Ouvrir");
		menuI.add(itemIopen);
		itemIopen.addActionListener(new Ecouteur(1, 5));

		JMenuItem itemSC = new JMenuItem("Créer");
		menuS.add(itemSC);
		itemSC.addActionListener(new Ecouteur(2, 0));
		JMenuItem itemSM = new JMenuItem("Modifier ");
		menuS.add(itemSM);
		itemSM.addActionListener(new Ecouteur(2, 1));
		JMenuItem itemSS = new JMenuItem("Supprimer");
		menuS.add(itemSS);
		itemSS.addActionListener(new Ecouteur(2, 2));
		JMenuItem itemSsave = new JMenuItem("Sauvegarde");
		menuS.add(itemSsave);
		itemSsave.addActionListener(new Ecouteur(2, 4));
		JMenuItem itemSopen = new JMenuItem("Ouvrir");
		menuS.add(itemSopen);
		itemSopen.addActionListener(new Ecouteur(2, 5));

		JMenuItem itemPC = new JMenuItem("Créer");
		menuP.add(itemPC);
		itemPC.addActionListener(new Ecouteur(3, 0));
		JMenuItem itemPM = new JMenuItem("Modifier ");
		menuP.add(itemPM);
		itemPM.addActionListener(new Ecouteur(3, 1));
		JMenuItem itemPS = new JMenuItem("Supprimer");
		menuP.add(itemPS);
		itemPS.addActionListener(new Ecouteur(3, 2));
		JMenuItem itemPsave = new JMenuItem("Sauvegarde");
		menuP.add(itemPsave);
		itemPsave.addActionListener(new Ecouteur(3, 4));
		JMenuItem itemPopen = new JMenuItem("Ouvrir");
		menuP.add(itemPopen);
		itemPopen.addActionListener(new Ecouteur(3, 5));

		JMenuItem itemSav = new JMenuItem("Save");
		barre.add(itemSav);
		itemSav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Save();
			}
		});

		JMenuItem itemC = new JMenuItem("A propos");
		barre.add(itemC);
		itemC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				APropos();
			}
		});

		return barre;
	}

	protected void Save() {
		Etudiant.Ecrire(etudiants, "");
		Intervenant.Ecrire(intervenants, "");
		Projet.Ecrire(projets, "");
		Sujet.Ecrire(sujets, "");
	}

	private String Nomfile(boolean save) {
		String nomfile = "";
		if (save) {
			nomfile = JOptionPane.showInputDialog(this,
					"Donner le nom du ficher", "Sauvegarde",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			nomfile = JOptionPane.showInputDialog(this,
					"Donner le nom du ficher", "Ouverture",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return nomfile;
	}

	class Ecouteur implements ActionListener {
		private int menu;
		private int var;

		Ecouteur(int menu, int var) {
			this.menu = menu;
			this.var = var;
		}

		public void actionPerformed(ActionEvent evt) {
			String nomF = "";
			if (var == 4) {
				nomF = Nomfile(true);
				if (nomF == null) {
					menu = -1;
				}
			}
			if (var == 5) {
				nomF = Nomfile(false);
				if (nomF == null) {
					menu = -1;
				}
			}

			switch (menu) {
			case 0:
				switch (var) {
				case 0:
					creaEtud();
					affichageAll(1);
					break;
				case 1:
					modifEtud();
					affichageAll(1);
					break;
				case 2:
					SuprEtudiant();
					affichageAll(1);
					break;
				case 4:
					saveEtu(nomF);
					break;
				case 5:
					openEtu(nomF);
					affichageAll(1);
					break;
				}
				break;
			case 1:
				switch (var) {
				case 0:
					creaInter();
					affichageAll(2);
					break;
				case 1:
					modifInter();
					affichageAll(2);
					break;
				case 2:
					SuprIntervenant();
					affichageAll(2);
					break;
				case 4:
					saveInter(nomF);
					break;
				case 5:
					openInter(nomF);
					affichageAll(2);
					break;
				}
				break;
			case 2:
				switch (var) {
				case 0:
					creaSujet();
					affichageAll(3);
					break;
				case 1:
					modifSujet();
					affichageAll(3);
					break;
				case 2:
					SuprSujet();
					affichageAll(3);
					break;
				case 4:
					saveSujet(nomF);
					break;
				case 5:
					openSujet(nomF);
					affichageAll(3);
					break;
				}
				break;
			case 3:
				switch (var) {
				case 0:
					creaProjet();
					affichageAll(4);
					break;
				case 1:
					modifProjet();
					affichageAll(4);
					break;
				case 2:
					SuprProjet();
					affichageAll(4);
					break;
				case 4:
					saveProjet(nomF);
					break;
				case 5:
					openProjet(nomF);
					affichageAll(4);
					break;
				}

				break;
			}

		}
	}

	protected void nothing() {
		JOptionPane.showMessageDialog(this, "Fonctionnalités non implémenter",
				"RIEN", JOptionPane.INFORMATION_MESSAGE);
	}

	/************** MODIFICATION ********************/
	private void modifEtud() {
		if (tabbedPane.getSelectedIndex() != 0) {
			tabbedPane.setSelectedIndex(0);
		} else {
			if (tabAffEtus.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,
						"Vous devez selectionez un etudiant",
						"Selection invalide", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (int i = 0; i < etudiants.size(); i++) {
				if (etudiants.get(i).getIde() == tabAffEtus.getValueAt(
						tabAffEtus.getSelectedRow(), 0)) {
					DialogueModifier dia = new DialogueModifier(this,
							"Fenetre Modifier Etudiant", 1, etudiants.get(i));
					dia.setLocationRelativeTo(this);
					dia.setVisible(true);
					if (dia.getBonneFin()) {
						etudiants.remove(i);
						etudiants.add(new Etudiant(dia.id.getText(), dia.nom
								.getText(), dia.prenom.getText(),
								dia.nomGroupeEtu.getText()));
					}
				}
			}
		}
	}

	private void modifInter() {
		if (tabbedPane.getSelectedIndex() != 1) {
			tabbedPane.setSelectedIndex(1);
		} else {
			if (tabAffInter.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,
						"Vous devez selectionez un intervenant",
						"Selection invalide", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (int i = 0; i < intervenants.size(); i++) {
				if (intervenants.get(i).getIdInter() == tabAffInter.getValueAt(
						tabAffInter.getSelectedRow(), 0)) {
					DialogueModifier dia = new DialogueModifier(this,
							"Fenetre Modifier Intervenant", 2,
							intervenants.get(i));
					dia.setLocationRelativeTo(this);
					dia.setVisible(true);
					if (dia.getBonneFin()) {
						intervenants.remove(i);
						intervenants.add(new Intervenant(dia.id.getText(),
								dia.nom.getText(), dia.prenom.getText()));
					}
				}
			}
		}
	}

	private void modifSujet() {
		if (tabbedPane.getSelectedIndex() != 2) {
			tabbedPane.setSelectedIndex(2);
		} else {
			if (tabAffSujet.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,
						"Vous devez selectionez un sujet",
						"Selection invalide", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (int i = 0; i < sujets.size(); i++) {
				if (sujets.get(i).getTitre() == tabAffSujet.getValueAt(
						tabAffSujet.getSelectedRow(), 0)) {
					DialogueModifier dia = new DialogueModifier(this,
							"Fenetre Modifier Sujet", 3, sujets.get(i));
					dia.setLocationRelativeTo(this);
					dia.setVisible(true);
					if (dia.getBonneFin()) {
						sujets.remove(i);
						sujets.add(new Sujet(dia.titreS.getText(),
								dia.contenuSujet.getText()));
					}
				}
			}
		}
	}

	private void modifProjet() {
		if (tabbedPane.getSelectedIndex() != 3) {
			tabbedPane.setSelectedIndex(3);
		} else {
			if (tabAffProjet.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,
						"Vous devez selectionez un projet",
						"Selection invalide", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (int i = 0; i < projets.size(); i++) {
				if (projets.get(i).getNomG() == tabAffProjet.getValueAt(
						tabAffProjet.getSelectedRow(), 0)) {
					DialogueModifier dia = new DialogueModifier(this,
							"Fenetre Modifier Projet", 4, projets.get(i));
					dia.tableauNomSujet(sujets);
					dia.tableauInter(intervenants);
					dia.tableauInter2(intervenants);
					dia.tableauInter3(intervenants);
					dia.tableauNomGroupe(groupes);
					dia.setLocationRelativeTo(this);
					dia.setVisible(true);
					if (dia.getBonneFin()) {
						projets.remove(i);
						projets.add(new Projet(dia.nomGroupe.getSelectedItem()
								+ "", dia.titre.getSelectedItem() + "",
								dia.idInter.getSelectedItem() + "",
								"Suprviseur", dia.idInter2.getSelectedItem()
										+ "", "Cliant", dia.idInter3
										.getSelectedItem() + "", "manager"));
					}
				}
			}
		}
	}

	/************* CREATION *****************/
	private void creaProjet() {
		makeGroupes();
		DialogueSaisieAll dial = new DialogueSaisieAll(this,
				"Fenetre Créer Projet", 3);
		dial.tableauNomSujet(sujets);
		dial.tableauInter(intervenants);
		dial.tableauInter2(intervenants);
		dial.tableauInter3(intervenants);
		dial.tableauNomGroupe(groupes);
		dial.setLocationRelativeTo(this);
		dial.setVisible(true);
		if (dial.getBonneFin()) {

			projets.add(new Projet((String) dial.nomGroupe.getSelectedItem(),
					(String) dial.titre.getSelectedItem(),
					(String) dial.idInter.getSelectedItem(), "",
					(String) dial.idInter2.getSelectedItem(), "",
					(String) dial.idInter3.getSelectedItem(), ""));

		}

	}

	private void creaSujet() {
		DialogueSaisieAll dial = new DialogueSaisieAll(this,
				"Fenetre Créer Sujet", 4);
		dial.setLocationRelativeTo(this);
		dial.setVisible(true);
		if (dial.getBonneFin()) {
			sujets.add(new Sujet(dial.titreS.getText(), dial.Lecontenu
					.getText()));
		}

	}

	private void creaInter() {
		DialogueSaisieAll dial = new DialogueSaisieAll(this,
				"Fenetre Créer Intervenant", 2);
		dial.setLocationRelativeTo(this);
		dial.setVisible(true);
		if (dial.getBonneFin()) {
			intervenants.add(new Intervenant(dial.id.getText(), dial.nom
					.getText(), dial.prenom.getText()));
		}
	}

	private void creaEtud() {
		DialogueSaisieAll dial = new DialogueSaisieAll(this,
				"Fenetre Créer Etudiant", 1);
		dial.setLocationRelativeTo(this);
		dial.setVisible(true);
		if (dial.getBonneFin()) {
			etudiants.add(new Etudiant(dial.id.getText(), dial.nom.getText(),
					dial.prenom.getText(), dial.nomGroupeEtu.getText()));
		}
		makeGroupes();
	}

	private void SuprEtudiant() {
		if (tabbedPane.getSelectedIndex() != 0) {
			tabbedPane.setSelectedIndex(0);
		} else {
			if (tabAffEtus.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,
						"Vous devez selectionez un etudiant",
						"Selection invalide", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (int i = 0; i < etudiants.size(); i++) {
				if (etudiants.get(i).getIde() == tabAffEtus.getValueAt(
						tabAffEtus.getSelectedRow(), 0)) {
					etudiants.remove(i);
				}
			}
		}
	}

	private void SuprIntervenant() {
		if (tabbedPane.getSelectedIndex() != 1) {
			tabbedPane.setSelectedIndex(1);
		} else {
			if (tabAffInter.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,
						"Vous devez selectionez un intervenant",
						"Selection invalide", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (int i = 0; i < intervenants.size(); i++) {
				if (intervenants.get(i).getIdInter() == tabAffInter.getValueAt(
						tabAffInter.getSelectedRow(), 0)) {
					intervenants.remove(i);
				}
			}
		}
	}

	private void SuprSujet() {
		if (tabbedPane.getSelectedIndex() != 2) {
			tabbedPane.setSelectedIndex(2);
		} else {
			if (tabAffSujet.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,
						"Vous devez selectionez un sujet",
						"Selection invalide", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (int i = 0; i < sujets.size(); i++) {
				if (sujets.get(i).getTitre() == tabAffSujet.getValueAt(
						tabAffSujet.getSelectedRow(), 0)) {
					sujets.remove(i);
				}
			}
		}
	}

	private void SuprProjet() {
		if (tabbedPane.getSelectedIndex() != 3) {
			tabbedPane.setSelectedIndex(3);
		} else {
			if (tabAffProjet.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,
						"Vous devez selectionez un projet",
						"Selection invalide", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (int i = 0; i < projets.size(); i++) {
				if (projets.get(i).getNomG() == tabAffProjet.getValueAt(
						tabAffProjet.getSelectedRow(), 0)) {
					projets.remove(i);
				}
			}
		}
	}

	private void openEtu(String nomfile) {
		etudiants = Etudiant.lire(nomfile); // ("data/" + nomfile);
	}

	private void openInter(String nomfile) {
		intervenants = Intervenant.lire(nomfile);
	}

	private void openSujet(String nomfile) {
		sujets = Sujet.lire(nomfile);
	}

	private void openProjet(String nomfile) {
		projets = Projet.lire(nomfile);
	}

	private void saveEtu(String nomfile) {
		Etudiant.Ecrire(etudiants, nomfile);
	}

	private void saveInter(String nomfile) {
		Intervenant.Ecrire(intervenants, nomfile);
	}

	private void saveSujet(String nomfile) {
		Sujet.Ecrire(sujets, nomfile);
	}

	private void saveProjet(String nomfile) {
		Projet.Ecrire(projets, nomfile);
	}

	private void makeGroupes() {
		groupes.clear();
		for (int i = 0; i < etudiants.size(); i++) {
			if (groupes.containsKey(etudiants.get(i).getGroupe())) {
				groupes.get(etudiants.get(i).getGroupe()).add(
						etudiants.get(i).getIde());
			} else {
				ArrayList<String> lenewgroup = new ArrayList<String>();
				lenewgroup.add(etudiants.get(i).getIde());
				groupes.put(etudiants.get(i).getGroupe(), lenewgroup);
			}
		}
	}

	private void affichageAll(int type) {

		JLabel nomOngletEtud = new JLabel("Etudiant");
		nomOngletEtud.setHorizontalTextPosition(JLabel.TRAILING);
		ImageIcon imgEtu = new ImageIcon("../img/etu.png");
		nomOngletEtud.setIcon(imgEtu);

		JLabel nomOngletInterv = new JLabel("Intervenant");
		nomOngletInterv.setHorizontalTextPosition(JLabel.TRAILING);
		ImageIcon imgInter = new ImageIcon("../img/intervenant.png");
		nomOngletInterv.setIcon(imgInter);

		JLabel nomOngletSujet = new JLabel("Sujet");
		nomOngletSujet.setHorizontalTextPosition(JLabel.TRAILING);
		ImageIcon imgSujet = new ImageIcon("../img/sujet.png");
		nomOngletSujet.setIcon(imgSujet);

		JLabel nomOngletProjet = new JLabel("Projet");
		nomOngletProjet.setHorizontalTextPosition(JLabel.TRAILING);
		ImageIcon imgProjet = new ImageIcon("../img/projet.png");
		nomOngletProjet.setIcon(imgProjet);

		tabbedPane.removeAll();

		tabbedPane.addTab("Onglet Etudiant", contenuEtu());
		tabbedPane.setTabComponentAt(0, nomOngletEtud);

		tabbedPane.addTab("Onglet Intervenant", contenuInter());
		tabbedPane.setTabComponentAt(1, nomOngletInterv);

		tabbedPane.addTab("Onglet Sujet", contenuSujet());
		tabbedPane.setTabComponentAt(2, nomOngletSujet);

		tabbedPane.addTab("Onglet Projet", contenuProjet());
		tabbedPane.setTabComponentAt(3, nomOngletProjet);

		tabbedPane.setPreferredSize(new Dimension(800, 800));

		tabbedPane.setSelectedIndex(type - 1);

		this.add(tabbedPane, BorderLayout.WEST);

		this.repaint();
	}

	private JPanel contenuEtu() {
		JPanel affEtus = new JPanel();

		Object[][] data = new Object[66][4];

		for (int i = 0; i < etudiants.size(); i++) {
			data[i][0] = etudiants.get(i).getIde();
			data[i][1] = etudiants.get(i).getNom();
			data[i][2] = etudiants.get(i).getPrenom();
			data[i][3] = etudiants.get(i).getGroupe();
		}

		// Les titres des colonnes
		String title[] = { "ID", "Nom", "Prenom", "Groupe" };
		tabAffEtus = new TableDefault(data, title);
		// Nous ajoutons notre tableau à notre contentPane dans un scroll
		// Sinon les titres des colonnes ne s'afficheront pas !
		// this.getContentPane().add(new JScrollPane(tableau));
		JScrollPane scrollPane = new JScrollPane(tabAffEtus);
		// scrollPane.setPreferredSize(new Dimension(100, 100));
		affEtus.add(scrollPane);
		affEtus.setBackground(Color.cyan); // OU PAS

		return affEtus;
	}

	private JPanel contenuInter() {

		JPanel affInter = new JPanel();

		Object[][] data = new Object[66][3];

		for (int i = 0; i < intervenants.size(); i++) {

			data[i][0] = intervenants.get(i).getIdInter();
			data[i][1] = intervenants.get(i).getNomInter();
			data[i][2] = intervenants.get(i).getPrenomInter();
		}

		// Les titres des colonnes
		String title[] = { "ID", "Nom", "Prenom" };
		tabAffInter = new TableDefault(data, title);
		// Nous ajoutons notre tableau à notre contentPane dans un scroll
		// Sinon les titres des colonnes ne s'afficheront pas !
		// this.getContentPane().add(new JScrollPane(tableau));
		JScrollPane scrollPane = new JScrollPane(tabAffInter);
		// scrollPane.setPreferredSize(new Dimension(100, 100));
		affInter.add(scrollPane);
		affInter.setBackground(Color.cyan);

		return affInter;
	}

	private JPanel contenuSujet() {

		JPanel affSujet = new JPanel();

		Object[][] data = new Object[66][3];

		for (int i = 0; i < sujets.size(); i++) {

			data[i][0] = sujets.get(i).getTitre();
			data[i][1] = sujets.get(i).getContenu();
		}

		// Les titres des colonnes
		String title[] = { "Titre", "Contenu" };
		tabAffSujet = new TableDefault(data, title);
		// Nous ajoutons notre tableau à notre contentPane dans un scroll
		// Sinon les titres des colonnes ne s'afficheront pas !
		// this.getContentPane().add(new JScrollPane(tableau));
		JScrollPane scrollPane = new JScrollPane(tabAffSujet);
		// scrollPane.setPreferredSize(new Dimension(100, 100));
		affSujet.add(scrollPane);
		affSujet.setBackground(Color.cyan);

		return affSujet;
	}

	private JPanel contenuProjet() {
		JPanel scrolled = new JPanel();
		JPanel panel = new JPanel(new BorderLayout());

		// /////////////////////////////
		Object[][] dataf = null;

		String[] columnsf = { "Groupe", "Etudiants", "Sujet", "Intervenants" };

		//JPanel result = new JPanel(new BorderLayout());

		dataf = new Object[projets.size()][4];

		for (int i = 0; i < projets.size(); i++) {

			dataf[i][0] = projets.get(i).getNomG();
			int nbetu = 0;
			for (int j = 0; j < etudiants.size(); j++) {
				if (etudiants.get(j).getGroupe()
						.equals(projets.get(i).getNomG())) {
					nbetu++;
				}
			}
			int line = 0;
			if (nbetu < 3)
				nbetu = 3;
			String[] etus = new String[nbetu]; // a modif
			for (int j = 0; j < etudiants.size(); j++) {

				if (etudiants.get(j).getGroupe()
						.equals(projets.get(i).getNomG())) {
					etus[line] = etudiants.get(j).getIde() + " "
							+ etudiants.get(j).getNom() + " "
							+ etudiants.get(j).getPrenom();
					line++;

				}
			}

			String[] lesujet = { "aa", "aa" };
			for (int j = 0; j < sujets.size(); j++) {
				if (sujets.get(j).getTitre().equals(projets.get(i).getSujet())) {
					lesujet[0] = sujets.get(j).getTitre();
					lesujet[1] = sujets.get(j).getContenu();
				}
			}

			int line2 = 0;

			String[] inters = new String[3];
			for (int j = 0; j < intervenants.size(); j++) {
				if (intervenants.get(j).getIdInter()
						.equals(projets.get(i).getInterv1())) {

					inters[line2] = intervenants.get(j).getNomInter() + " "
							+ intervenants.get(j).getPrenomInter() + " Client";
					line2++;
				}
				if (intervenants.get(j).getIdInter()
						.equals(projets.get(i).getInterv2())) {

					inters[line2] = intervenants.get(j).getNomInter() + " "
							+ intervenants.get(j).getPrenomInter()
							+ " Superviseur";
					line2++;

				}
				if (intervenants.get(j).getIdInter()
						.equals(projets.get(i).getInterv3())) {

					inters[line2] = intervenants.get(j).getNomInter() + " "
							+ intervenants.get(j).getPrenomInter()
							+ " shproutcheuh";
					line2++;

				}
			}

			dataf[i][1] = etus;
			dataf[i][2] = lesujet;
			dataf[i][3] = inters;
		}

		tabAffProjet = new TableDefault(dataf, columnsf);
		tabAffProjet.createModel(tabAffProjet, dataf, columnsf);

		tabAffProjet.setFillsViewportHeight(true);

		panel.add(tabAffProjet.getTableHeader(), BorderLayout.NORTH);
		panel.add(tabAffProjet, BorderLayout.CENTER);
		// //////////////////////////////
		int taille = 700;
				if(etudiants.size() * 20 <= 700)
		taille = etudiants.size() * 20;
		panel.setPreferredSize(new Dimension(600, taille));
		JScrollPane scroll = new JScrollPane(panel);
		scrolled.setLayout(new BorderLayout());
		scrolled.add(scroll, BorderLayout.CENTER);
		return scrolled;
	}

	private void APropos() {
		JOptionPane
				.showMessageDialog(
						this,
						"Université Toulous 2   IUT de Blagnac\nDUT INFO S3 - Module MPA  Projet : \"OPTI\"\nSprint 0               Par :\n"
								+ "Diaz Allan -  Canihac Jean-Brice - Revuz Anselme \n  "
								+ "Bochu  Nicolas - Maillot Sylvain  -  Martin  Edwin",
						"A propos", JOptionPane.INFORMATION_MESSAGE);
	}

	private void quitter() {
		int confirmation = JOptionPane.showConfirmDialog(this,
				"Voulez-vous réellement quitter cette application ?",
				"Quitter ?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (confirmation == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
