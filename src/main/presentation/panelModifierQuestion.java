/**
 * Ce panel à pour but de pouvoir modifier les questions/reponses
 */
package main.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Benjamin
 *
 */
public class panelModifierQuestion extends JPanel {
	
	private JPanel monpanel;
	private JComboBox combo, combo2;
	private JLabel categorie = new JLabel("La Catégorie");
	private JLabel question = new JLabel("Les Questions");
	
	public panelModifierQuestion()
	{			
		//On définit le layout à utiliser pour avoir 5 parties
		monpanel = new JPanel();
		this.setLayout(new BorderLayout());
		//Panel du haut
		this.add(categorie, BorderLayout.NORTH);

		//On va ajouter la checkbox catégorie
		String[]tab = {"Culture Java", "Culture Informatique", "Nouvelle catégorie", "Nouvelle catégorie"};
		combo = new JComboBox(tab);
		this.combo.setPreferredSize(new Dimension(150, 20));
		this.add(combo, BorderLayout.NORTH);
		
		JPanel top = new JPanel();
	    top.add(categorie);
	    top.add(combo);
	    this.add(top, BorderLayout.NORTH);

	    //2ème checkbox selection de la question
	    String[] tab2 = {"Question 1", "Question 2", "Nouvelle question 3", "Nouvelle question 4"};
		combo2 = new JComboBox(tab2);
		combo2.setPreferredSize(new Dimension(150, 20));
		this.add(combo2, BorderLayout.CENTER);
		
		JPanel middle = new JPanel();
	    middle.add(question);
	    middle.add(combo2);
	    this.add(middle, BorderLayout.CENTER);
	    
	    //Affichage de l'image en rapport avec notre question pour modification
//	    JLabel imageQuestion = new JLabel();
//	    Icon image = new ImageIcon("chemin de l'image");
//	    monpanel.add((Component) image);
	    
	}	
}
