package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class panelFormulaire extends JPanel implements ActionListener {

	//Déclaration des éléments de la barre de Menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Aide");
	private JMenuItem item1 = new JMenuItem("Nouveau Test");
	private JMenuItem item2 = new JMenuItem("Sauvegarder");
	private JMenuItem item3 = new JMenuItem("Quitter");
	private JMenuItem item4 = new JMenuItem("Aide");
	
	
//	private JLabel logo = new JLabel(new ImageIcon("logoAFPA.png"));
	
	public panelFormulaire() {
		
		//Constitution de la barre de menu
		menuBar.add(menu1);
		menuBar.add(menu2);
		
		item1.addActionListener(this);
		menu1.add(item1);
		item1.addActionListener(this);
		menu1.add(item2);
		item2.addActionListener(this);
		menu1.addSeparator();
		menu1.add(item3);
		item3.addActionListener(this);
		
		menu2.add(item4);
		item4.addActionListener(this);
		
		//Création du panel central
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(null);
		
			//Création du logo
		ImageIcon logo = new ImageIcon("logoAFPA.png");
		Image img = logo.getImage();
		Image newImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		logo = new ImageIcon(newImg);
		JLabel logoFinal = new JLabel(logo);
		
			//Création du Bouton Sauvegarder
		JButton boutonSave = new JButton("Sauvegarder");
		boutonSave.addActionListener(this);
		
			//Création du Champ de saisie global
				//création du panel qui le contiendra (en GridLayout, 2 colonnes)
		JPanel panelSaisie = new JPanel(new GridLayout(0, 2, 60, 30));
//		Border greyline, greyline2;                                    // A creuser pour faire un petit effet sur le panneau
//		greyline = BorderFactory.createLineBorder(Color.GRAY);
//		greyline2 = BorderFactory.createLoweredBevelBorder();
//		panelSaisie.setBorder(greyline);
				
				//Création du contenu
		JLabel champ1 = new JLabel("Nom");
		JLabel champ2 = new JLabel("Prénom");
		JLabel champ3 = new JLabel("E-mail");
		JLabel champ4 = new JLabel("Téléphone");
		JLabel champ5 = new JLabel("N° identifiant");
		
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
		
		
			//Constitution du panel central
		panelCentral.add(logoFinal);		
		logoFinal.setBounds(30, 30, 40, 40);
		panelCentral.add(boutonSave);
		boutonSave.setBounds(30, 280, 150, 30);
		panelCentral.add(panelSaisie);
		panelSaisie.setBounds(250, 50, 270, 230);
		
		
		//Constitution du panel général
		this.setLayout(new BorderLayout());
		this.add(menuBar, BorderLayout.NORTH);
		this.add(panelCentral, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
