package main.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * R�vision du panelQuestion d� au changement pr�vu par Khadidja
 * @author Florent
 * @author Marc
 *
 */
public class panelQuestion extends JPanel {
	
	private JPanel panelNord;
	public JPanel panelCentre;
	
	private JPanel panelQuestions;
	private JPanel panelTimer;
	private JPanel panelReponse;
	public JPanel panelImage;
	private JPanel panelValider;
	
	protected JLabel labelQuestion;
	protected JRadioButton reponse1;
	protected JRadioButton reponse2;
	protected JRadioButton reponse3;
	protected JRadioButton reponse4;
	protected JButton boutonValider;
	
	private Font font;
	protected JLabel iconeEntreprise;
	private Font font2;

	
	public panelQuestion() {

		// POUR LA COUCHE METIER -- NE PAS TOUCHER ces 2 lignes en commentaires (cyril) - mettre la fonction  
		//laQuestionReponse = new questionReponse(""); 
		//laQuestionReponse.genererQuestionsCandidat();
		// Appel de cette fonction  chercherQuestionR�ponse(numQuestion) � chaque fois que le candidat valide un r�ponse.
		
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout(200, 200));
		
		
		/**
		 * @author Ana�sGueyte
		 * @date 14/09/2016
		 * @version jobjob_2_0 (en accord avec la BDD)
		 * 
		 */
		
		font = new Font("Arial",Font.BOLD,28);
		font2 = new Font("Arial",Font.BOLD,14);
		
		panelNord = new JPanel();
		panelNord.setLayout(new BorderLayout());
		 
		panelQuestions = new JPanel();	
		
		labelQuestion = new JLabel("Combien de pattes a un mouton � cinq pattes?");//� remplir en lisant fichier ou bdd contenant les questions.
		
		labelQuestion.setFont(font);
		panelQuestions.add(labelQuestion);
		
		
		panelNord.add(panelQuestions, BorderLayout.WEST);
		
		//labelTimer = new JLabel(c);//Si pas question stress, label vide. Sinon voir ce qu'il faut mettre.
		//labelTimer.setFont(font);
		
		this.add(panelNord, BorderLayout.NORTH);
		
		panelCentre = new JPanel();
		panelCentre.setLayout(new BorderLayout());
		
		panelReponse = new JPanel();
		panelReponse.setLayout(new BoxLayout(panelReponse, BoxLayout.PAGE_AXIS));
		
		//A remplir en lisant fichier ou bdd
		reponse1 = new JRadioButton("<html>1jpfjpsfpzsf<br>pokfpskfpskfpskfspfkskfmskfmsfkskfskfmskfmskm</html>",false);
		reponse1.setFont(font);
		reponse2 = new JRadioButton("2",false);
		reponse2.setFont(font);
		reponse3 = new JRadioButton("3",false);
		reponse3.setFont(font);
		reponse4 = new JRadioButton("5",false);
		reponse4.setFont(font);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(reponse1);
		bg.add(reponse2);
		bg.add(reponse3);
		bg.add(reponse4);
		
		
		panelValider = new JPanel();
		panelValider.setLayout(null);
		boutonValider = new JButton("Valider");
		boutonValider.setFont(font2);
		boutonValider.setPreferredSize(new Dimension(100, 40));
		boutonValider.setBounds(200,250,100,40);
		panelCentre.add(boutonValider);
		
		panelReponse.add(reponse1);
		panelReponse.add(reponse2);
		panelReponse.add(reponse3);
		panelReponse.add(reponse4);
		panelReponse.add(panelValider);
		
		panelCentre.add(panelReponse, BorderLayout.WEST);
		
		panelImage = new JPanel();
		panelImage.setLayout(new BorderLayout());
		iconeEntreprise = new JLabel(new ImageIcon("JobJob.png"));//a changer
		panelImage.add(iconeEntreprise);
//		this.add(panelImage, BorderLayout.SOUTH);
		iconeEntreprise.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panelCentre.add(panelImage);

		this.add(panelCentre);
		
//		panelValider = new JPanel();
//		panelValider.setLayout(null);
//		panelValider.add(boutonValider);
//		boutonValider.setBounds(200,200,200,200);
//		
//		this.add(panelValider);
		
		
		
		
	}


	public JRadioButton getReponse1() {
		return reponse1;
	}


	public JRadioButton getReponse2() {
		return reponse2;
	}


	public JRadioButton getReponse3() {
		return reponse3;
	}


	public JRadioButton getReponse4() {
		return reponse4;
	}


	public JLabel getLabelQuestion() {
		return labelQuestion;
	}

	

}
