package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class panelAccueil extends JPanel{

	//Déclaration des éléments de la barre de Menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuAide = new JMenu("Aide");
	protected JMenu itemNouveauTest= new JMenu("Nouveau Test");
	protected JMenuItem itemCandidatExistant = new JMenuItem("Candidat Existant");
	protected JMenuItem itemNouveauCandidat = new JMenuItem("Nouveau Candidat");
	protected JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
	protected JMenuItem itemQuitter = new JMenuItem("Quitter");
	protected JMenuItem itemAide = new JMenuItem("Aide");
	private JLabel statusBar = new JLabel();
	private JMenuBar menuBar2 = new JMenuBar();
	
	public panelAccueil() {
		
		//Constitution de la barre de menu
		menuBar.add(menuFichier);
		menuBar.add(menuAide);
		
		menuFichier.add(itemNouveauTest);
		itemNouveauTest.add(itemCandidatExistant);
		itemNouveauTest.add(itemNouveauCandidat);
		menuFichier.add(itemSauvegarder);
		itemSauvegarder.setEnabled(false);
		menuFichier.addSeparator();
		menuFichier.add(itemQuitter);
		
		menuAide.add(itemAide);

	
		//Un sous-panel qui contiendra le texte et l'image principale
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
	
			//Importe l'image principale de l'écran d'accueil, sous forme de JLabel
		JLabel img = new JLabel(new ImageIcon("jobjob.png"));

			//Notre petit texte
		Font fontAccueil = new Font("Courier", Font.BOLD, 30);
		JLabel texte = new JLabel("Job-Job : Test de recrutement", JLabel.CENTER);
		texte.setFont(fontAccueil);

		Dimension tailleTexte = new Dimension(4000, 60); //Affectation d'une grande largeur pour qu'il soit tjs centré

		texte.setPreferredSize(tailleTexte);
//		texte.setHorizontalAlignment(JLabel.CENTER);
		
			//Construction du panel qui ira au centre
		panel1.add(texte);
		panel1.add(img);	
		

		//Constitution du panel général

		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.NORTH);
		
	}

	public void creerFichier() {
		
	}

	
}
