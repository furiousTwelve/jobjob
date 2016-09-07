package main.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.metier.TimerGeneral;


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
 * @author damien
 * @version v1.00
 * 
 */

public class panelCandidat extends JPanel  {
	
	protected JPanel content;
	protected JPanel panel2;
	protected JLabel[][] labelnull = new JLabel[15][7];
	protected JLabel iconeEntreprise;
	protected ImageIcon logo;
	protected JButton buttonStart;
	protected JButton test;
	protected JLabel info;
	
	
	/**
	 * constructeur de la classe
	 * @author Damien
	 */
	public panelCandidat() 
	{	
		buttonStart = new JButton("start", new ImageIcon("play_button.png"));
		Font myFont = new Font("Serif", Font.ITALIC | Font.BOLD, 12);
	    Font newFont = myFont.deriveFont(40F);
	    buttonStart.setFont(newFont);
	    iconeEntreprise = new JLabel(new ImageIcon("Logo_Afpa.png"));
	    info = new JLabel("<html> Vous avez 30 min pour répondre aux questions cliquez sur \"start\" pour commencer le test </html> ");
		info.setFont(newFont);
	    
	    //il est beaucoup plus simple de créer la fenêtre à l'aide du gridbaglayout car il me parait plus malléable pour la redimension des boutons
	    //bien qu'il soit complexe à mettre en oeuvre.
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // seul composant de sa colonne, il est donc le dernier.
		gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER; // ou BASELINE_LEADING mais pas WEST.	
		gbc.ipadx=250;
		this.add(info, gbc);
		gbc.gridx =3;
		gbc.gridy =3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		this.add(iconeEntreprise,gbc);
		
		gbc.gridy =4;
		gbc.gridx =0;
	//	gbc.weightx=5;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill=GridBagConstraints.NONE;
		
		this.add(buttonStart, gbc);
		
		buttonStart.setPreferredSize(new Dimension(150,100));		
	}

	public void startTimer(){
		TimerGeneral tp = new TimerGeneral(1800);
		tp.start();
	}
		
	public void randomQuestionsJava(){
		
	}
	
	public void randomQuestionsCultureG(){
		
	}
	
	public void randomQuestionsCodeExo(){
		
	}

}
