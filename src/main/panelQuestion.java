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
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * Le panelQuestion est le panel servant à présenter les questions au candidat. On y retrouve 4 réponses ainsi qu'un timer général.
 * <br>Lorsqu'une réponse est cochée, cela passe directement à la suivante
 * @author Mathieu
 */
public class panelQuestion extends JPanel {

	//Déclaration des éléments de la barre de Menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuAide = new JMenu("Aide");
	protected JMenu itemNouveauTest= new JMenu("Nouveau Test");
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

/**
 * Constructeur du panelQuestion
 * 	<br>Schéma de l'imbrication de ses Layouts:
 * 	<br>	C'est un BorderLayout contenant:
 * 	<pre>		- Nord: Vide</pre>
 * 	<pre>		- Sud: Vide</pre>
 * @throws ParseException
 */
	public panelQuestion() throws ParseException {
		
		
		//Création du panel de gauche, contenant le logo : panelLogo
		JPanel panelLogo = new JPanel();
		panelLogo.setLayout(new GridLayout(0, 3));
		
			//Création du logo
			ImageIcon logo = new ImageIcon("logoAFPA.png");
			Image img = logo.getImage();
			Image newImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			logo = new ImageIcon(newImg);
			JLabel logoFinal = new JLabel(logo);
			
			//Création des "cases vides"
			JLabel labelvide = new JLabel("");
			JLabel labelvide2 = new JLabel(" ");
			JLabel labelvide3 = new JLabel(" ");
			JLabel labelvide4 = new JLabel(" ");
			JLabel labelvide5 = new JLabel(" ");
			JLabel labelvide6 = new JLabel(" ");
			JLabel labelvide7 = new JLabel(" ");
			JLabel labelvide8 = new JLabel(" ");
	
			//Assemblage du panelLogo
			panelLogo.add(labelvide);
			panelLogo.add(logoFinal);
			panelLogo.add(labelvide2);
			panelLogo.add(labelvide3);
			panelLogo.add(labelvide4);
			panelLogo.add(labelvide5);
			panelLogo.add(labelvide6);
			panelLogo.add(labelvide7);
			panelLogo.add(labelvide8);
		

			
		//Création du panel qui ira au centre du panel principal : panelCentre
			JPanel panelCentre = new JPanel();
			panelCentre.setLayout(new GridLayout(0, 1));
			
				//Il contiendra lui-même 2 panels : le panel des champs de saisie, le panel en-dessous
									
					// Création du panel Central supérieur, qui contiendra le panelSaisie
						JPanel panelCentreHaut = new JPanel();
						panelCentreHaut.setLayout(new FlowLayout(FlowLayout.CENTER));
						
						//Création des JLabels Questions, soit une Image, soit un Texte
						ImageIcon iconeQuestion = new ImageIcon("question.jpg");
						Image imageQuestion = iconeQuestion.getImage();
						Image newImageQuestion = imageQuestion.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
						iconeQuestion = new ImageIcon(newImageQuestion);
						JLabel labelQuestionImage = new JLabel(iconeQuestion);

										
						panelCentreHaut.add(labelQuestionImage);
						
					//création du panel Central inférieur, qui contiendra 2 panels
						JPanel panelCentreBas = new JPanel();
						panelCentreBas.setLayout(new BoxLayout(panelCentreBas, BoxLayout.Y_AXIS));
						
							//Un Panel pour les futurs 4 réponses possibles
							JPanel panelReponses = new JPanel(new GridLayout(0, 4));
							
								//Création des JCheckBox
								reponse1 = new JCheckBox("reponse #1hgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmssssssssssshjhgjgjhgjhgjhgjhgjhgjgjhgjhgjgjgjgjhgjhgjgjgh");
								reponse1.setHorizontalAlignment((int) Container.CENTER_ALIGNMENT);
								reponse2 = new JCheckBox("reponse #2");
								reponse2.setHorizontalAlignment((int) Container.CENTER_ALIGNMENT);
								reponse3 = new JCheckBox("reponse #3");
								reponse3.setHorizontalAlignment((int) Container.CENTER_ALIGNMENT);
								reponse4 = new JCheckBox("reponse #4");
								reponse4.setHorizontalAlignment((int) Container.CENTER_ALIGNMENT);
								
								
								//Assemblage du panelReponses
								panelReponses.add(reponse1);
								panelReponses.add(reponse2);
								panelReponses.add(reponse3);
								panelReponses.add(reponse4);
						
							//Un panel pour un élément centré
							JPanel panelElementBasCentre = new JPanel(new FlowLayout(FlowLayout.CENTER));
							barreProgression = new JProgressBar();
							barreProgression.setValue(33); //pour le fun
							barreProgression.setForeground(Color.ORANGE);
							panelElementBasCentre.add(barreProgression);
							
							//Assemblage panelCentreBas
							panelCentreBas.add(panelReponses);
							panelCentreBas.add(panelElementBasCentre);
					
			
			//Assemblage du panelCentralCentre
			panelCentre.add(panelCentreHaut);
			panelCentre.add(panelCentreBas);
				
		//Création d'une zone tampon à droite
		JPanel panelDroite = new JPanel();
		panelDroite.setLayout(new GridLayout(0, 1));
		
		JLabel labelVide9 = new JLabel();
		Dimension dim = new Dimension(80, 80);
		labelVide9.setPreferredSize(dim);
		
		panelDroite.add(labelVide9);
		

	
		//Assemblage Général du PanelFormulaire
		this.setLayout(new BorderLayout(30,30));
		this.add(menuBar, BorderLayout.NORTH);
		this.add(panelLogo, BorderLayout.WEST);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelDroite, BorderLayout.EAST);
	

	}



	
}
