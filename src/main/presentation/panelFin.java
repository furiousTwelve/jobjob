
/**
 * Ce panneau à pour but d'indiquer à l'utilisateur que le teste est bien fini.
 * Il faut penser que dans une futur il y aura une version avec une interface pour le recruteur afin qu'il puisse à la volée selectionner les resultats des candidats.
 */
package main.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creation du panel de fin de l'application
 * @author 34011-82-12
 * @version 1.0
 *
 */

public class panelFin extends JPanel {
	
	private JLabel textFin, nomEntreprise, iconeEntreprise, id, motDePasse;
	private ImageIcon logo;
	private Font font, font2;
	private JTextField recruteur, mdp;
	
//panel Principal
	public panelFin()
	{
		this.setLayout(new BorderLayout());		
//Label du text
		textFin = new JLabel("<html>Fin du test <br> <pre> Merci</pre></html>", JLabel.CENTER);
		font = new Font("Arial",Font.BOLD,32);
		textFin.setFont(font);		
		this.add(textFin, BorderLayout.CENTER);

	
//2ème panel pour le logo
		JPanel panelEntreprise = new JPanel();
		panelEntreprise.setLayout(new BoxLayout(panelEntreprise, BoxLayout.PAGE_AXIS));
				
//Affichage du logo
		iconeEntreprise = new JLabel(new ImageIcon("JobJob.png"));
		panelEntreprise.add(iconeEntreprise);
		this.add(panelEntreprise, BorderLayout.SOUTH);
		iconeEntreprise.setAlignmentX(Component.CENTER_ALIGNMENT);
				
//Affichage du nom de notre bboîte
		nomEntreprise = new JLabel("Job-Job");
		panelEntreprise.add(nomEntreprise);
		font2 = new Font("Arial",Font.ITALIC,40);
		nomEntreprise.setFont(font2);
		nomEntreprise.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		
		JPanel panelRecruteur = new JPanel();
		panelRecruteur.setLayout(new BoxLayout(panelRecruteur, BoxLayout.PAGE_AXIS));
		
		JPanel panelID = new JPanel();
		
		id = new JLabel("ID");
		
		panelID.add(id);

		recruteur = new JTextField();
		recruteur.setColumns(10);		
		panelID.add(recruteur);
		panelRecruteur.add(panelID);
		
		JPanel panelMdp = new JPanel();
		
		motDePasse = new JLabel("Mot de passe");
		panelMdp.add(motDePasse);
		
		mdp = new JTextField();		
		mdp.setColumns(10);
		panelMdp.add(mdp);
		
		panelRecruteur.add(panelMdp);

//3ème panel pour le recruteur prévue pour la v2	
		JPanel p3 = new JPanel(new GridLayout(0,3));
		p3.add(panelRecruteur);
		p3.add(panelEntreprise);
		this.add(p3, BorderLayout.SOUTH);

	



	}
}
