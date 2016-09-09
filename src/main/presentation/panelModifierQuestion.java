package main.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Benjamin
 *
 */
public class panelModifierQuestion extends JPanel {
	
	private JPanel panelgeneral,top, middle, bottom;
	private JComboBox combo, combo2;
	private JLabel categorie = new JLabel("La Catégorie");
	private JLabel question = new JLabel("Les Questions");
	private JLabel imageQuestion;
	private JButton validerModif;
	
	public panelModifierQuestion()
	{			
		//On définit le layout à utiliser pour avoir 5 parties
		panelgeneral = new JPanel();
		this.setLayout(new BorderLayout());
		//Panel du haut
		this.add(categorie, BorderLayout.NORTH);

		//On va ajouter la checkbox catégorie
		String[]tab = {"Culture Java", "Culture Informatique", "Nouvelle catégorie", "Nouvelle catégorie"};
		combo = new JComboBox(tab);
		this.combo.setPreferredSize(new Dimension(150, 20));
		this.add(combo, BorderLayout.NORTH);
		
		top = new JPanel();
	    top.add(categorie);
	    top.add(combo);
	    this.add(top, BorderLayout.NORTH);

	    //2ème checkbox selection de la question
	    String[] tab2 = {"Question 1", "Question 2", "Nouvelle question 3", "Nouvelle question 4"};
		combo2 = new JComboBox(tab2);
		combo2.setPreferredSize(new Dimension(150, 20));
		this.add(combo2, BorderLayout.CENTER);
		
		middle = new JPanel();
	    middle.add(question);
	    middle.add(combo2);
	    this.add(middle, BorderLayout.CENTER);
	    
	    //Affichage de l'image en rapport avec notre question pour modification
//	    imageQuestion = new JLabel(new ImageIcon ("JobJob.png")); //Ne fonctionne pas !
//	    imageQuestion.add(imageQuestion);
//	    this.add(imageQuestion, BorderLayout.CENTER);
//	    imageQuestion.setAlignmentX(Component.CENTER_ALIGNMENT);
//	     
	    //Bouton Valider en bas du panel
	    bottom = new JPanel();
	    validerModif = new JButton("Valider");
	    bottom.add(validerModif);
	    this.add(validerModif, BorderLayout.SOUTH); 
	    validerModif.setPreferredSize(new Dimension(150, 20));
	    
	    bottom.setLayout(new BoxLayout(bottom, BoxLayout.PAGE_AXIS));
	    //Changer police et taille
//	    setFont(new Font("Arial",Font.BOLD,28));
//	    validerModif.setFont(getFont());  
	    
	}	
}