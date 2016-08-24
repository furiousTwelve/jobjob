package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Aide");
	protected JMenuItem item1 = new JMenuItem("Nouveau Test");
	private JMenuItem item2 = new JMenuItem("Sauvegarder");
	protected JMenuItem item3 = new JMenuItem("Quitter");
	protected JMenuItem item4 = new JMenuItem("Aide");
	private JLabel statusBar = new JLabel();
	private JMenuBar menuBar2 = new JMenuBar();
	
	public panelAccueil() {
		
		//Constitution de la barre de menu
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		menu1.add(item1);
		menu1.add(item2);
		item2.setEnabled(false);
		menu1.addSeparator();
		menu1.add(item3);
	
		
		menu2.add(item4);


		
		//Un sous-panel qui contiendra le texte et l'image principale
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
	
		
			//Importe l'image principale de l'écran d'accueil, sous forme de JLabel
		JLabel img = new JLabel(new ImageIcon("jobjob.png"));
			//Notre petit texte
		JLabel texte = new JLabel("Job-Job : Test de recrutement");

		Dimension tailleTexte = new Dimension(4000, 60); //Affectation d'une grande largeur pour qu'il soit tjs centré

		texte.setPreferredSize(tailleTexte);
		texte.setHorizontalAlignment(JLabel.CENTER);
			//Construction du panel qui ira au centre
		panel1.add(texte, BorderLayout.NORTH);
		panel1.add(img, BorderLayout.CENTER);
	


		//Remplissage du panel global avec le panel central et la barre de menu

		//Constitution du panel général

		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.NORTH);
		
	}

	public void creerFichier() {
		
	}

	
}
