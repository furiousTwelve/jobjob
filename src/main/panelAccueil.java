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

public class panelAccueil extends JPanel implements ActionListener{

	//Déclaration des éléments de la barre de Menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Aide");
	private JMenuItem item1 = new JMenuItem("Nouveau Test");
	private JMenuItem item2 = new JMenuItem("Sauvegarder");
	private JMenuItem item3 = new JMenuItem("Quitter");
	private JMenuItem item4 = new JMenuItem("Aide");
	
	public panelAccueil() {
		
		//Constitution de la barre de menu
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		item1.addActionListener(this);
		menu1.add(item1);
		menu1.add(item2);
		item2.setEnabled(false);
		menu1.addSeparator();
		menu1.add(item3);
		
		menu2.add(item4);
		
		//Un sous-panel qui contiendra le texte et l'image principale
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
	
		
			//Importe l'image principale de l'écran d'accueil, sous forme de JLabel
		JLabel img = new JLabel(new ImageIcon("C:/Users/34011-82-06/git/recrutement/jobjob.png"));
			//Notre petit texte
		JLabel texte = new JLabel("Job-Job : Test de recrutement");
		texte.setHorizontalAlignment(JLabel.CENTER);
		
		panel1.add(texte, BorderLayout.NORTH);
		panel1.add(img, BorderLayout.CENTER);

		
		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.NORTH);
		
	}

	public void creerFichier() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action enclenchée depuis le panel");
	}
}
