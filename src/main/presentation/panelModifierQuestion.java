package main.presentation;

import java.awt.Component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Benjamin
 *
 */
public class panelModifierQuestion extends JPanel {
	
	
	private JPanel panelgeneral,top, middle, bottom;
	private JComboBox combo, combo2, combo3;
	private JLabel categorie = new JLabel("La Catégorie");
	private JLabel question = new JLabel("Les Questions");
	private JLabel imageQuestion;
	private JButton validerModif, supprimer ;
	
	public panelModifierQuestion()
	{	
		
		
		//On définit le layout à utiliser pour avoir 9 parties
		panelgeneral = new JPanel();
		this.setLayout(new GridLayout(3,3));
//1		
		//Label vide
		this.add(new JLabel());

//2		
		//On va ajouter la 1ere comboBox  catégorie
		top = new JPanel();
		JLabel categorie = new JLabel("La Catégorie");
		String[]tab = {"Culture Java", "Culture Informatique", "Nouvelle catégorie", "Nouvelle catégorie"};
		combo = new JComboBox(tab);
		top.add(categorie);
		top.add(combo);
		
		//Textebox
		JTextField modifCategorie = new JTextField(20);
		top.add(modifCategorie );
		this.add(top);
		
//3 et 4		
		this.add(new JLabel());
		this.add(new JLabel());
//5		
		//2ème ComboBox la selection de la question
		middle = new JPanel();
		JLabel question = new JLabel("Les Questions");
	    String[] tab2 = {"Question 1", "Question 2", "Question 3", "Question 4"};
	    combo2 = new JComboBox(tab2);
	    middle.add(question);
	    middle.add(combo2);
	    
	    //Textebox
	    JTextField modifQuestion = new JTextField(20);
	    middle.add(modifQuestion );
	    
	    //Les réponses
	    JLabel reponses = new JLabel("Les Réponses");
	    String[] tab3 = {"Reponses 1", "Reponses 2", "Reponses 3", "Reponses 4"};
	    combo3 = new JComboBox(tab3);
	    middle.add(reponses);
	    middle.add(combo3);
	    
	    //Textebox
	    JTextField modifReponse = new JTextField(20);
	    middle.add(modifReponse);
	    
		this.add(middle);
		
//6 et 7
		this.add(new JLabel());
		this.add(new JLabel());
////8		
	    //Bouton Valider en bas du panel
	    bottom = new JPanel();
	    validerModif = new JButton("Valider");
	    bottom.add(validerModif);
	    
	    supprimer = new JButton("Supprimer");
	    bottom.add(supprimer);
	    this.add(bottom);
	    
//9		
	    this.add(new JLabel()); 
	    
	}	
}