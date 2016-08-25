package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
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

	
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
		
		//Importe l'image principale de l'écran d'accueil, sous forme de JLabel
		JLabel img = new JLabel(new ImageIcon("jobjob.png"));
		JPanel panelImg = new JPanel(new BorderLayout(50,50));
		panelImg.add(img, BorderLayout.NORTH);
		//Notre petit texte
		Font fontAccueil = new Font("Courier", Font.BOLD, 30);
		JLabel texte = new JLabel("Job-Job : Test de recrutement", JLabel.CENTER);
		texte.setFont(fontAccueil);
		JPanel panelTexte = new JPanel(new BorderLayout());
		panelTexte.add(texte, BorderLayout.SOUTH);
		
		panelCentral.add(panelTexte);
		JLabel labelVide = new JLabel(" "); //Peut mieux faire , mais çà marche
		panelCentral.add(labelVide);
		panelCentral.add(panelImg);
		
		

		//Constitution du panel général

		this.setLayout(new BorderLayout());
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.NORTH);
		
	}

	public void creerFichier() {
		
	}

	
}
