package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * TODO : 
 * renommer panel1 avec un nom explicit
 * mettre à jour la javadoc
 * améliorer l'indentation du code (ex startTimer et suivant trop à gauche 
 * effacer chaque tâche de cette TODOlist une fois que c'est réalisé
 */

/**
 * 
 * 
 * @author Cyril, Audric
 * @version v1.00
 * 
 */

public class panelCandidat extends JPanel  {
	
	protected JPanel panel1;
	protected JPanel panel2;

	protected JLabel iconeEntreprise;
	protected ImageIcon logo;
	protected JButton buttonStart;
	// code a optimisé
	protected JLabel labelnull1 = new JLabel(" ");
	protected JLabel labelnull2 = new JLabel(" ");
	protected JLabel labelnull3 = new JLabel(" ");
	protected JLabel labelnull4 = new JLabel(" ");
	protected JLabel labelnull5 = new JLabel(" ");
	protected JLabel labelnull6 = new JLabel(" ");
	protected JLabel labelnull7 = new JLabel(" ");
	protected JLabel labelnull8 = new JLabel(" ");
	
	protected JLabel labelnull10 = new JLabel(" ");
	protected JLabel labelnull11 = new JLabel(" ");
	protected JLabel labelnull13 = new JLabel(" ");
	protected JLabel labelnull14 = new JLabel(" ");
	protected JLabel labelnull15 = new JLabel(" ");
	protected JLabel labelnull16 = new JLabel(" ");
	protected JLabel labelnull17 = new JLabel(" ");
	protected JLabel labelnull18 = new JLabel(" ");
	
	public panelCandidat() 
	{		
		panel1= new JPanel();
		panel2= new JPanel();
		
		
		buttonStart = new JButton("start", new ImageIcon("play_button.png"));
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 12);
	    Font newFont = myFont.deriveFont(50F);

	    buttonStart.setFont(newFont);
		
		iconeEntreprise = new JLabel(new ImageIcon("logoAFPA.png"));	
		
		this.setLayout(new BorderLayout());
		panel1.setLayout(new GridLayout(0,3));
		
		// code a optimisé
		panel1.add(labelnull1);
		panel1.add(iconeEntreprise);
		panel1.add(labelnull2);
		panel1.add(labelnull3);
		panel1.add(labelnull4);
		panel1.add(labelnull5);
		panel1.add(labelnull6);
		panel1.add(labelnull7);
		panel1.add(labelnull8);
		
		panel2.setLayout(new GridLayout(0,3));
		panel2.add(labelnull10);
		panel2.add(labelnull11);
		panel2.add(labelnull13);
		panel2.add(labelnull14);
		panel2.add(buttonStart);
		panel2.add(labelnull15);
		panel2.add(labelnull16);
		panel2.add(labelnull17);
		panel2.add(labelnull18);
		
		
		this.add(panel2, BorderLayout.CENTER);
		this.add(panel1, BorderLayout.WEST);
	
				
	}

public void startTimer(){
	TimerGeneral tp = new TimerGeneral();
	tp.start();
}
	
public void randomQuestionsJava(){
	
}

public void randomQuestionsCultureG(){
	
}

public void randomQuestionsCodeExo(){
	
}

}
