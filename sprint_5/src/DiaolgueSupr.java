import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DiaolgueSupr extends JDialog {

	private boolean bonneFin = false;

	public JComboBox<String> ids;

	public DiaolgueSupr(JFrame fenetreMere, String titre, int type) {
		super(fenetreMere, titre, true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocation(400, 400);
		setSize(390, 300);
		this.setContentPane(Contenu(type));

	}
	
	public static void main(String[] args) {
		JFrame rien = new JFrame("rien");

		DiaolgueSupr test = new DiaolgueSupr(rien,"ET C'est le TEST",1);
		
		test.setVisible(true);
		
		System.exit(0);
	}

	private JPanel Contenu(int type) {
		JPanel result = new JPanel();
		result.setLayout(new BorderLayout());

		JPanel JPid = new JPanel();
		
		ids = new JComboBox<String>();

		JPanel boutons = new JPanel();

		JLabel Titre = new JLabel("supr");
		switch (type) {
		case 1:
			Titre.setText("Suppression Etudiant");
			break;
		case 2:
			Titre.setText("Suppression Intervenant");
			break;
		case 3:
			Titre.setText("Suppression Sujet");
			break;
		case 4:
			Titre.setText("Suppression Projet");
			break;
		}
		Titre.setFont(new Font("", 0, 28));
		Titre.setHorizontalAlignment(JLabel.CENTER);

		JLabel Lid = new JLabel("Id : ");

		JPid.add(Lid);
		JPid.add(ids);

		result.add(Titre, BorderLayout.NORTH);
		result.add(JPid, BorderLayout.CENTER);
		result.add(boutons, BorderLayout.SOUTH);

		JButton ok = new JButton("OK");
		JButton annule = new JButton("Annuler");

		ok.setPreferredSize(annule.getPreferredSize());
		boutons.setLayout(new FlowLayout());
		boutons.add(ok);
		boutons.add(annule);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionBoutonOk();
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

	protected void actionBoutonOk() {
		bonneFin = true;
		dispose();
	}
	
	public boolean getBonneFin() {
		return bonneFin;
	}
	
	public void tableauIds(ArrayList<String> lesStrings) {
		for (int i=0; i<lesStrings.size();i++){
			ids.addItem(lesStrings.get(i));
		}
	}

}
