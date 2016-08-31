
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
		textFin = new JLabel("Fin du test \n Merci", JLabel.CENTER);
		font = new Font("Arial",Font.BOLD,32);
		textFin.setFont(font);		
		this.add(textFin, BorderLayout.CENTER);

	
//2ème panel pour le logo
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.PAGE_AXIS));
				
//Affichage du logo
		iconeEntreprise = new JLabel(new ImageIcon("JobJob.png"));
		p2.add(iconeEntreprise);
		this.add(p2, BorderLayout.SOUTH);
		iconeEntreprise.setAlignmentX(Component.CENTER_ALIGNMENT);
				
//Affichage du nom de notre bboîte
		nomEntreprise = new JLabel("Job-Job");
		p2.add(nomEntreprise);
		font2 = new Font("Arial",Font.ITALIC,40);
		nomEntreprise.setFont(font2);
		nomEntreprise.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		
		JPanel p4 = new JPanel();
		id = new JLabel("ID");
		
		p4.add(id);

		recruteur = new JTextField();
		recruteur.setColumns(10);		
		p4.add(recruteur);
		motDePasse = new JLabel("Mot de passe");
		p4.add(motDePasse);
		
		mdp = new JTextField();		
		mdp.setColumns(10);
		p4.add(mdp);
		
/*		
//3ème panel pour le recruteur prévue pour la v2	
		JPanel p3 = new JPanel(new GridLayout(0,3));
		p3.add(p4);
		p3.add(p2);
		this.add(p3, BorderLayout.SOUTH);

	


*/
	}
}
