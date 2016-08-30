package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Le panelQuestion est le panel servant � pr�senter les questions au candidat.
 * On y retrouve 4 r�ponses ainsi qu'un timer g�n�ral. Lorsqu'une r�ponse est
 * coch�e, cela passe directement � la suivante
 * 
 * @author Mathieu
 */
public class panelQuestion extends JPanel {

	// D�claration des �l�ments
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuAide = new JMenu("Aide");
	protected JMenu itemNouveauTest = new JMenu("Nouveau Test");
	protected JMenuItem itemCandidatExistant = new JMenuItem("Candidat Existant");
	protected JMenuItem itemNouveauCandidat = new JMenuItem("Nouveau Candidat");
	protected JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
	protected JMenuItem itemQuitter = new JMenuItem("Quitter");
	protected JMenuItem itemAide = new JMenuItem("Aide");
	private JLabel statusBar = new JLabel();
	private JMenuBar menuBar2 = new JMenuBar();
	protected JButton boutonSave = new JButton("Sauvegarder");

	protected JCheckBox reponse1;
	protected JCheckBox reponse2;
	protected JCheckBox reponse3;
	protected JCheckBox reponse4;

	protected JProgressBar barreProgression;

	protected JPanel panelSaisie;
	private JPanel panelLogo;
	private JPanel panelCentre;
	private JPanel panelCentreHaut;
	private JPanel panelCentreBas;
	private JPanel panelReponses;
	private JPanel panelElementBasCentre;
	private JPanel panelDroite;

	private ImageIcon logo;
	private ImageIcon iconeQuestion;
	private Image img;
	private Image newImg;
	private Image imageQuestion;
	private Image newImageQuestion;

	private JLabel logoFinal;
	private JLabel labelQuestionImage;
	
	private questionReponse laQuestionReponse;

/**
 * Constructeur du panelQuestion
 * 	Sch�ma de l'imbrication de ses Layouts:
 * 		C'est un BorderLayout contenant:
 * 			- Nord: Vide
 * 			- Sud: Vide
 * 			- West: Un panel logo (GridLayout avec 3 colonnes, 3 lignes) qui contient notre logo dans la 2nde case du haut
 * 			- East: Un panel "tampon", panelDroite, en GridLayout � 1 seule colonne, contenant un JLabel. On peut d�finir la largeur de ce JLabel afin de g�rer l'�cart du panneau central avec notre bordure notamment
 * 			- Center: Un panel principal, panelCentre, en GridLayout 1 colonne contenant :
 * 						- En haut : un panel panelCentreHaut, en BoxLayout, � l'alignement vertical. Il contient un panneau, panelSaisie
 * 								- panelSaisie : en GridLayout, 2 colonnes, contenant l'ensemble des champs de saisie.
 * 						- En Bas : un panel panelCentreBas, BoxLayout ax� vertical qui contient lui-m�me deux panels:
 * 								- en haut : un panelReponses, en GridLayout, 4 colonnes. Il est vide ici, mais servira pour le panelQuestion entre autres
 * 								- en bas : un panelElementBasCentre, en FlowLayout, centr�, permettant d'accueillir un �l�ment quelconque de mani�re centr�. Ici, le bouton "Save". La barre de progression dans le panelQuestion par exemple 
 * 
 * 
 * @throws ParseException
 */
	public panelQuestion() throws ParseException {
		
		// pour la partie M�tier, v�rifier si CG OK
		laQuestionReponse = new questionReponse("CG"); 
		laQuestionReponse.genererQuestionsCandidat();
		
		//Cr�ation du panel de gauche, contenant le logo : panelLogo
		panelLogo = new JPanel();
		
		panelLogo.setLayout(new GridLayout(0, 3));

		// Cr�ation du logo
		logo = new ImageIcon("logoAFPA.png");
		img = logo.getImage();
		newImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		logo = new ImageIcon(newImg);
		logoFinal = new JLabel(logo);

		// Cr�ation des "cases vides"
		JLabel labelvide = new JLabel("");
		JLabel labelvide2 = new JLabel(" ");
		JLabel labelvide3 = new JLabel(" ");
		JLabel labelvide4 = new JLabel(" ");
		JLabel labelvide5 = new JLabel(" ");
		JLabel labelvide6 = new JLabel(" ");
		JLabel labelvide7 = new JLabel(" ");
		JLabel labelvide8 = new JLabel(" ");

		// Assemblage du panelLogo
		panelLogo.add(labelvide);
		panelLogo.add(logoFinal);
		panelLogo.add(labelvide2);
		panelLogo.add(labelvide3);
		panelLogo.add(labelvide4);
		panelLogo.add(labelvide5);
		panelLogo.add(labelvide6);
		panelLogo.add(labelvide7);
		panelLogo.add(labelvide8);

		// Cr�ation du panel qui ira au centre du panel principal : panelCentre
		panelCentre = new JPanel();
		panelCentre.setLayout(new GridLayout(0, 1));

		// Il contiendra lui-m�me 2 panels : le panel des champs de saisie, le
		// panel en-dessous

		// Cr�ation du panel Central sup�rieur, qui contiendra le panelSaisie
		panelCentreHaut = new JPanel();
		panelCentreHaut.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Cr�ation des JLabels Questions, soit une Image, soit un Texte
		iconeQuestion = new ImageIcon("question.jpg");
		imageQuestion = iconeQuestion.getImage();
		newImageQuestion = imageQuestion.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
		iconeQuestion = new ImageIcon(newImageQuestion);
		labelQuestionImage = new JLabel(iconeQuestion);

		panelCentreHaut.add(labelQuestionImage);

		// cr�ation du panel Central inf�rieur, qui contiendra 2 panels
		panelCentreBas = new JPanel();
		panelCentreBas.setLayout(new BoxLayout(panelCentreBas, BoxLayout.Y_AXIS));

		// Un Panel pour les futurs 4 r�ponses possibles
		panelReponses = new JPanel(new GridLayout(0, 4));

		// Cr�ation des JCheckBox
		reponse1 = new JCheckBox("reponse #1hgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmssssssssssshjhgjgjhgjhgjhgjhgjhgjgjhgjhgjgjgjgjhgjhgjgjgh");
		reponse1.setHorizontalAlignment((int) Container.CENTER_ALIGNMENT);

		reponse2 = new JCheckBox("reponse #2");
		reponse2.setHorizontalAlignment((int) Container.CENTER_ALIGNMENT);
		reponse3 = new JCheckBox("reponse #3");
		reponse3.setHorizontalAlignment((int) Container.CENTER_ALIGNMENT);
		reponse4 = new JCheckBox("reponse #4");
		reponse4.setHorizontalAlignment((int) Container.CENTER_ALIGNMENT);

		// Assemblage du panelReponses
		panelReponses.add(reponse1);
		panelReponses.add(reponse2);
		panelReponses.add(reponse3);
		panelReponses.add(reponse4);

		// Un panel pour un �l�ment centr�
		panelElementBasCentre = new JPanel(new FlowLayout(FlowLayout.CENTER));
		barreProgression = new JProgressBar();
		barreProgression.setValue(33); // pour le fun
		barreProgression.setForeground(Color.ORANGE);
		panelElementBasCentre.add(barreProgression);

		// Assemblage panelCentreBas
		panelCentreBas.add(panelReponses);
		panelCentreBas.add(panelElementBasCentre);

		// Assemblage du panelCentralCentre
		panelCentre.add(panelCentreHaut);
		panelCentre.add(panelCentreBas);

		// Cr�ation d'une zone tampon � droite
		panelDroite = new JPanel();
		panelDroite.setLayout(new GridLayout(0, 1));

		JLabel labelVide9 = new JLabel();		
		labelVide9.setPreferredSize(new Dimension (80,80));

		panelDroite.add(labelVide9);

		// Assemblage G�n�ral du PanelFormulaire
		this.setLayout(new BorderLayout(30, 30));
		this.add(menuBar, BorderLayout.NORTH);
		this.add(panelLogo, BorderLayout.WEST);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelDroite, BorderLayout.EAST);

		// comm a effacer
		
	}
	
//	public void genererQuestionsCandidat()
//	{
//		questionsCandidat = new questionReponse[15];
//		byte valeurGeneree;
//		boolean trouve = false;
//		Random r = new Random();
//		questionReponse question;
//		
//		// GENERE LES QUESTIONS 1 A 5
//		int i = 0;
//		while(i < 5)
//		{
//			question = new questionReponse("CG");
//			trouve = false;
//			valeurGeneree = (byte) (r.nextInt(14) + 1);
//			
//			for(int j = 0; j < i; j++)
//			{
//				if(valeurGeneree == questionsCandidat[j].numeroQuestion)
//				{
//					trouve = true;
//				}
//			}
//			
//			if(trouve == false)
//			{
//				question.numeroQuestion = valeurGeneree;
//				questionsCandidat[i] = question;
//				i++;
//			}
//	}
//		
//		// GENERE LES QUESTIONS 6 A 10
//		int v = 5;
//		while(v < 10)
//		{
//			question = new questionReponse("CJ");
//			trouve = false;
//			valeurGeneree = (byte) (r.nextInt(14) + 1);
//			
//			for(int j = 0; j < i; j++)
//			{
//				if(valeurGeneree == questionsCandidat[j].numeroQuestion)
//				{
//					trouve = true;
//				}
//			}
//			
//			if(trouve == false)
//			{
//				question.numeroQuestion = valeurGeneree;
//				questionsCandidat[v] = question;
//				v++;
//			}
//		}
//		
//		// VA CHERCHER LA QUESTION STRESS - QUESTION 11
//		question = new questionReponse("S");
//		question.numeroQuestion = 1;
//		questionsCandidat[10] = question;
//		
//		// GENERE LES QUESTIONS 12 A 14
//		int p = 11;
//		valeurGeneree = (byte) (r.nextInt(11));
//		String[] tableauLangagesExotiques = {"DELPHI", "PERL", "FORTRAN", "ADA", "PASCAL", "SMALLTALK", "TCLTK", "LISP", "VISUALBASIC", "SQUIRREL", "COBOL", "EIFFEL"};
//		String langage = tableauLangagesExotiques[valeurGeneree];
//		
//		// A FINIR !!!!!!!!!
//		while(p < 14)
//		{
//			String cat = "LE" + tableauLangagesExotiques[valeurGeneree];
//			question = new questionReponse(cat);
//			questionsCandidat[p] = question;
//			p++;
//		}
//		
//	}
//	
//	public void affichageTableauGenere(questionReponse[] tab, int l)
//	{
//		for(int i = 0; i < l; i++)
//		{
//			System.out.println(tab[i].numeroQuestion);
//		}
//	}

}