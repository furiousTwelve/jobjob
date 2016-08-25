package main;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelFormulaire extends JPanel {

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
	protected JButton boutonSave = new JButton("Sauvegarder");
	
	protected JPanel panelSaisie;
	
//	private JLabel logo = new JLabel(new ImageIcon("logoAFPA.png"));
	
	public panelFormulaire() {
		
		//Constitution de la barre de menu : menuBar
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
		
		
		
		//Création du panel contenant le logo : panelLogo
		JPanel panelLogo = new JPanel();
		panelLogo.setLayout(new GridLayout(0, 3));
		
			//Création du logo
		ImageIcon logo = new ImageIcon("logoAFPA.png");
		Image img = logo.getImage();
		Image newImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		logo = new ImageIcon(newImg);
		JLabel logoFinal = new JLabel(logo);
		
		JLabel labelvide = new JLabel("");
		JLabel labelvide2 = new JLabel(" ");
		JLabel labelvide3 = new JLabel(" ");
		JLabel labelvide4 = new JLabel(" ");
		JLabel labelvide5 = new JLabel(" ");
		JLabel labelvide6 = new JLabel(" ");
		JLabel labelvide7 = new JLabel(" ");
		JLabel labelvide8 = new JLabel(" ");

			//Assemblage du panelLogo
		panelLogo.add(labelvide);
		panelLogo.add(logoFinal);
		panelLogo.add(labelvide2);
		panelLogo.add(labelvide3);
		panelLogo.add(labelvide4);
		panelLogo.add(labelvide5);
		panelLogo.add(labelvide6);
		panelLogo.add(labelvide7);
		panelLogo.add(labelvide8);
		
		
		
		//Création du Champ de saisie
			//création du panel qui le contiendra (en GridLayout, 2 colonnes)
		panelSaisie = new JPanel(new GridLayout(0, 2, 30, 30));


			//Création du contenu
		Font fontSaisie = new Font("Courier", Font.BOLD, 20);
		JLabel champ1 = new JLabel("Nom");
		champ1.setFont(fontSaisie);
		JLabel champ2 = new JLabel("Prénom");
		champ2.setFont(fontSaisie);
		JLabel champ3 = new JLabel("E-mail");
		champ3.setFont(fontSaisie);
		JLabel champ4 = new JLabel("Téléphone");
		champ4.setFont(fontSaisie);
		JLabel champ5 = new JLabel("N° identifiant");
		champ5.setFont(fontSaisie);
		
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField field3 = new JTextField();
		JTextField field4 = new JTextField();
		JTextField field5 = new JTextField();

			//Assemblage du panel
		panelSaisie.add(champ1);
		panelSaisie.add(field1);
		panelSaisie.add(champ2);
		panelSaisie.add(field2);
		panelSaisie.add(champ3);
		panelSaisie.add(field3);
		panelSaisie.add(champ4);
		panelSaisie.add(field4);
		panelSaisie.add(champ5);
		panelSaisie.add(field5);
		
		//Création du panelCentralHaut
		JPanel panelCentralHaut = new JPanel();
		panelCentralHaut.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCentralHaut.add(panelSaisie);

		
		// Création du panelCentral
		JPanel panelCentral = new JPanel();
//		panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
		
		panelCentral.add(panelCentralHaut);
		JLabel test = new JLabel(" ");
		panelCentral.add(test);
		panelCentral.add(boutonSave);
		
		
		
		//Création d'une zone tampon à droite
		JPanel panelDroite = new JPanel();
		panelDroite.setLayout(new GridLayout(0, 1));
		
		JLabel labelVide9 = new JLabel();
		Dimension dim = new Dimension(80, 80);
		labelVide9.setPreferredSize(dim);
		
		panelDroite.add(labelVide9);
		
		
		
		// Création de la zone Sud, contenant le bouton Sauvegarder
		JPanel panelSud = new JPanel();
		panelSud.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel labelVide11 = new JLabel(" ");
		panelSud.add(labelVide11, BorderLayout.CENTER);
	
	
		this.setLayout(new BorderLayout(30, 30));
		this.add(menuBar, BorderLayout.NORTH);
		this.add(panelLogo, BorderLayout.WEST);
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(panelDroite, BorderLayout.EAST);
		this.add(panelSud, BorderLayout.SOUTH);
		

	}


	
}
