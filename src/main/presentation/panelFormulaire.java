package main.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import main.metier.Candidat;

/**
 * Le panelFormulaire est le panel qui sera chargé par la fenêtre Principale après appui sur le bouton "NouveauTest".
 * Il est destiné à être rempli par le recruteur
 * @author Mathieu
 * @author Florent
<<<<<<< HEAD
 * @author Audric
=======
 * @author Lionel
 * @author Marc
>>>>>>> features/presentation/573
 */
public class panelFormulaire extends JPanel  implements ActionListener
{

	//Déclaration des éléments de la barre de Menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuQuiz = new JMenu("Quiz");
	private JMenu menuAide = new JMenu("Aide");
	protected JMenu itemNouveauTest= new JMenu("Nouveau Test");
	protected JMenuItem itemCandidatExistant = new JMenuItem("Candidat Existant");
	protected JMenuItem itemNouveauCandidat = new JMenuItem("Nouveau Candidat");
	protected JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
	protected JMenuItem itemQuitter = new JMenuItem("Quitter");
	protected JMenuItem itemAjoutQuestion = new JMenuItem("Ajouter une question/réponses");
	protected JMenuItem itemModifierQuestion = new JMenuItem("Modifier une question/réponses");
	protected JMenuItem itemSupprimerQuestion = new JMenuItem("Supprimer une question/réponses");
	protected JMenuItem itemAide = new JMenuItem("Aide");
	private JLabel statusBar = new JLabel();
	private JMenuBar menuBar2 = new JMenuBar();
	protected JButton boutonSave = new JButton("Sauvegarder");
	
	
	protected JFormattedTextField fieldNom = new JFormattedTextField();
	protected JFormattedTextField fieldPrenom = new JFormattedTextField();
	protected JFormattedTextField fieldMail = new JFormattedTextField();
	protected JFormattedTextField fieldTelephone = new JFormattedTextField();
	protected JFormattedTextField fieldId = new JFormattedTextField();

	protected JPanel panelSaisie;
	protected JPanel panelElementBasCentre;
	
	protected JLabel champNom;
	protected JLabel champPrenom;
	protected JLabel champ3;
	protected JLabel champ4;
	
	
	/**
	 * Constructeur du panelFormulaire
	 * 	<br>Schéma de l'imbrication de ses Layouts:
	 * 	<br>	C'est un BorderLayout contenant:
	 * 	<br> 		- Nord: Un barre de Menu menuBar
	 * 	<br>		- Sud: Vide
	 * 	<br>		- West: Un panel logo (GridLayout avec 3 colonnes, 3 lignes) qui contient notre logo dans la 2nde case du haut
	 * 	<br>		- East: Un panel "tampon", panelDroite, en GridLayout à 1 seule colonne, contenant un JLabel. On peut définir la largeur de ce JLabel afin de gérer l'écart du panneau central avec notre bordure notamment
	 * 	<br>		- Center: Un panel principal, panelCentre, en GridLayout 1 colonne contenant :
	 * 	<br>					- En haut : un panel panelCentreHaut, en BoxLayout, à l'alignement vertical. Il contient un panneau, panelSaisie
	 * 	<br>							  - panelSaisie : en GridLayout, 2 colonnes, contenant l'ensemble des champs de saisie.
	 * 	<br>					- En Bas : un panel panelCentreBas, BoxLayout axé vertical qui contient lui-même deux panels:
	 * 	<br>							 - en haut : un panelReponses, en GridLayout, 4 colonnes. Il est vide ici, mais servira pour le panelQuestion entre autres
	 * 	<br>							 - en bas : un panelElementBasCentre, en FlowLayout, centré, permettant d'accueillir un élément quelconque de manière centré. Ici, le bouton "Save". La barre de progression dans le panelQuestion par exemple 
	 * 
	 * 
	 * @throws ParseException
	 */
	public panelFormulaire() {
		
		
		//Ajout de Listener sur tous les boutons nécessaires
		//itemNouveauTest.addActionListener(this);			
		
		
		
		

		itemQuitter.addActionListener(this);	
		itemAide.addActionListener(this);	
		itemAjoutQuestion.addActionListener(this);
		itemModifierQuestion.addActionListener(this);
		itemSupprimerQuestion.addActionListener(this);
		
		//Constitution de la barre de menu : menuBar
		menuBar.add(menuFichier);
		menuBar.add(menuQuiz);
		menuBar.add(menuAide);
		
		menuFichier.add(itemNouveauTest);
		itemNouveauTest.add(itemCandidatExistant);
		itemNouveauTest.add(itemNouveauCandidat);
		menuFichier.add(itemSauvegarder);
		itemSauvegarder.setEnabled(false);
		menuFichier.addSeparator();
		menuFichier.add(itemQuitter);
		
		menuQuiz.add(itemAjoutQuestion);
		menuQuiz.add(itemModifierQuestion);
		menuQuiz.add(itemSupprimerQuestion);
		
		menuAide.add(itemAide);
		
		itemCandidatExistant.addActionListener(this);
		itemNouveauCandidat.addActionListener(this);
		
//		//Création du panel de gauche, contenant le logo : panelLogo
//		JPanel panelLogo = new JPanel();
//		panelLogo.setLayout(new GridLayout(0, 3));
//		
			//Création du logo
			ImageIcon logo = new ImageIcon("Logo_Afpa.png");
			Image img = logo.getImage();
			Image newImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			logo = new ImageIcon(newImg);
			JLabel logoFinal = new JLabel(logo);
//			
//			//TODO : faire une jolie boucle pour renplacer cette déclaration longue et brutale
//			//Création des "cases vides"
//			JLabel labelvide = new JLabel("");
//			JLabel labelvide2 = new JLabel(" ");
//			JLabel labelvide3 = new JLabel(" ");
//			JLabel labelvide4 = new JLabel(" ");
//			JLabel labelvide5 = new JLabel(" ");
//			JLabel labelvide6 = new JLabel(" ");
//			JLabel labelvide7 = new JLabel(" ");
//			JLabel labelvide8 = new JLabel(" ");
//	
//			//TODO : faire une boucle ( à voir avec celle d'au dessus)
//			//Assemblage du panelLogo
//			panelLogo.add(labelvide);
//			panelLogo.add(logoFinal);
//			panelLogo.add(labelvide2);
//			panelLogo.add(labelvide3);
//			panelLogo.add(labelvide4);
//			panelLogo.add(labelvide5);
//			panelLogo.add(labelvide6);
//			panelLogo.add(labelvide7);
//			panelLogo.add(labelvide8);
//		
//
//			
//		//Création du panel qui ira au centre du panel principal : panelCentre
//			JPanel panelCentre = new JPanel();
//			panelCentre.setLayout(new GridLayout(0, 1));
//			
//				//Il contiendra lui-même 2 panels : le panel des champs de saisie, le panel en-dessous
//									
//					// Création du panel Central supérieur, qui contiendra le panelSaisie
//						JPanel panelCentreHaut = new JPanel();
//						panelCentreHaut.setLayout(new BoxLayout(panelCentreHaut, BoxLayout.PAGE_AXIS));
//						
//							//création du panel qui contiendra les champs de saisie :
//							panelSaisie = new JPanel(new GridLayout(0, 2, 0, 20));
//			
//								//Création du contenu
								Font fontChampSaisie = new Font("Courier", Font.BOLD, 20);


								JLabel champNom = new JLabel("Nom");
								champNom.setFont(fontChampSaisie);
								JLabel champPrenom = new JLabel("Prénom");
								champPrenom.setFont(fontChampSaisie);

								champ3 = new JLabel("E-mail");
								champ3.setFont(fontChampSaisie);
								champ4 = new JLabel("Téléphone");
								champ4.setFont(fontChampSaisie);
								JLabel champid = new JLabel("N° identifiant");
								champid.setFont(fontChampSaisie);
//								
//
								//Un FormattedTextField permet de mettre une contrainte à ce qui est entré dans le TextField, à l'aide d'un Mask dont on définit la structure

								MaskFormatter maskNomPrenom;
								try {
									maskNomPrenom = new MaskFormatter("**************************************************");
									maskNomPrenom.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ éèêëùûüçïî-öôâäà");
									fieldNom = new JFormattedTextField(maskNomPrenom);
									fieldPrenom = new JFormattedTextField(maskNomPrenom);
									fieldNom.setPreferredSize(new Dimension(200,20));
									fieldPrenom.setPreferredSize(new Dimension(200,20));
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								
								
								
								MaskFormatter maskTelephone;
								try {
									maskTelephone = new MaskFormatter("***************");
									maskTelephone.setValidCharacters("+()0123456789 ");
									fieldTelephone = new JFormattedTextField(maskTelephone);
									fieldId = new JFormattedTextField();
								} catch (ParseException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								

//						
//								//Assemblage du panelSaisie
//								panelSaisie.add(champ1);
//								panelSaisie.add(fieldNom);
//								panelSaisie.add(champ2);
//								panelSaisie.add(fieldPrenom);
//								panelSaisie.add(champ3);
//								panelSaisie.add(fieldMail);
//								panelSaisie.add(champ4);
//								panelSaisie.add(fieldTelephone);
//								panelSaisie.add(champ5);
//								panelSaisie.add(fieldId);
//								
//								
//						panelSaisie.setMaximumSize(new Dimension(400, 200));			
//						panelCentreHaut.add(panelSaisie, BorderLayout.CENTER);
//						
//					//création du panel CentralCentre inférieur, qui contiendra 2 panels
//						JPanel panelCentreBas = new JPanel();
//						panelCentreBas.setLayout(new BoxLayout(panelCentreBas, BoxLayout.Y_AXIS));
//						
//							//Un Panel pour les futurs 4 réponses possibles
//							JPanel panelReponses = new JPanel(new GridLayout(0, 4));
//						
//							//Un panel pour un élément centré
//							panelElementBasCentre = new JPanel(new FlowLayout(FlowLayout.CENTER));
//							panelElementBasCentre.add(boutonSave);
//
//						panelCentreBas.add(panelReponses);
//						panelCentreBas.add(panelElementBasCentre);
//					
//			
//			//Assemblage du panelCentralCentre
//			panelCentre.add(panelCentreHaut);
//			panelCentre.add(panelCentreBas);
//				
//		//Création d'une zone tampon à droite
//		JPanel panelDroite = new JPanel();
//		panelDroite.setLayout(new GridLayout(0, 1));
//		
//		JLabel labelVide9 = new JLabel();
//		Dimension dim = new Dimension(80, 80);
//		labelVide9.setPreferredSize(dim);
//		
//		panelDroite.add(labelVide9);
//		
//
//	
//		//Assemblage Général du PanelFormulaire
//		this.setLayout(new BorderLayout(30,30));
//		this.add(menuBar, BorderLayout.NORTH);
//		this.add(panelLogo, BorderLayout.WEST);
//		this.add(panelCentre, BorderLayout.CENTER);
//		this.add(panelDroite, BorderLayout.EAST);
	
		
		//tentative de mettre en place le panel formulaire grâce à un gridbaglayout
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gb);
		fieldMail.setPreferredSize(fieldNom.getPreferredSize());
		fieldTelephone.setPreferredSize(fieldNom.getPreferredSize());
		fieldId.setPreferredSize(fieldNom.getPreferredSize());
		
		
		
		//Placement de la barre de menu en haut à gauche
		gbc.weightx=0;
		gbc.weighty=0;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(menuBar, gbc);
	
		
		//Placement du label nom, ainsi que son champ de texte
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth= 1;
		gbc.gridheight= 1;
		gbc.weightx=1;
		gbc.weighty=0;
		gbc.fill = GridBagConstraints.NONE;

		//  ============================================> La ligne suivante fait planter le programme - voir Cyril
		gbc.anchor = gbc.CENTER;

	//	gbc.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc.insets = new Insets(10, 15, 0, 0);
		this.add(champNom,gbc);
		
		gbc.gridx =2;
		gbc.gridy =2;
		gbc.gridwidth =GridBagConstraints.NONE;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.RELATIVE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril
	//	gbc.anchor = GridBagConstraints.BASELINE_LEADING;

		this.add(fieldNom,gbc);
		
		
		//placement du Label prénom ainsi que son champ de texte 
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth= 1;
		gbc.gridheight= 1;
		gbc.weightx=0;
		gbc.weighty=0;
		gbc.fill = GridBagConstraints.NONE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril

	//	gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10, 15, 0, 0);
		this.add(champPrenom,gbc);
		
		gbc.gridx =2;
		gbc.gridy =3;
		gbc.gridwidth =GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.RELATIVE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril

	//	gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		this.add(fieldPrenom,gbc);
		
		//placement du Label Mail ainsi que son champ de texte 
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth= 1;
		gbc.gridheight= 1;
		gbc.weightx=0;
		gbc.weighty=0;
		gbc.fill = GridBagConstraints.NONE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril
//		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;

		gbc.insets = new Insets(10, 15, 0, 0);
		this.add(champ3,gbc);
		
		gbc.gridx =2;
		gbc.gridy =4;
		gbc.gridwidth =GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.RELATIVE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril

	//	gbc.anchor = GridBagConstraints.BASELINE_LEADING;	
		this.add(fieldMail,gbc);
		
		
		//placement du Label Télephone ainsi que son champ de texte 
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth= 1;
		gbc.gridheight= 1;
		gbc.weightx=0;
		gbc.weighty=0;
		gbc.fill = GridBagConstraints.NONE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril
//		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;

		gbc.insets = new Insets(10, 15, 0, 0);
		this.add(champ4,gbc);
		
		gbc.gridx =2;
		gbc.gridy =5;
		gbc.gridwidth =GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.RELATIVE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril
//		gbc.anchor = GridBagConstraints.BASELINE_LEADING;

		this.add(fieldTelephone,gbc);
		
		
		//placement du Label ID ainsi que son champ de texte 
		gbc.gridx = 1;
		gbc.gridy =6;
		gbc.gridwidth= 1;
		gbc.gridheight= 1;
		gbc.weightx=0;
		gbc.weighty=0;
		gbc.fill = GridBagConstraints.NONE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril
	//	gbc.anchor = GridBagConstraints.BASELINE_TRAILING;

		gbc.insets = new Insets(10, 15, 0, 0);
		this.add(champid,gbc);
	
		gbc.gridx =2;
		gbc.gridy =6;
		gbc.gridwidth =GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.RELATIVE;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril
//		gbc.anchor = GridBagConstraints.BASELINE_LEADING;

		this.add(fieldId,gbc);
		
		//Placement du bouton sauvegarder
		gbc.gridx=2;
		gbc.gridy=7;
		gbc.weightx=0;
		gbc.weighty=1;
		
		gbc.gridwidth=1;
		gbc.gridheight=1;

	//  ============================================> La ligne suivante fait planter le programme - voir Cyril

	//	gbc.anchor=GridBagConstraints.BASELINE_LEADING;
		this.add(boutonSave,gbc);
		
		//placement du logo
		gbc.gridx=2;
		gbc.gridy=1;
		gbc.weightx=0;
		gbc.weighty=0;
	//  ============================================> La ligne suivante fait planter le programme - voir Cyril
		//gbc.anchor=GridBagConstraints.ABOVE_BASELINE;
		this.add(logoFinal,gbc);
		

	}

	
	/**
	 * C'est une méthode permettant de vérifier la validité sous format mail d'un JLabel.
	 * <br>retourne true si c'est un mail valide qui est entré.
	 * @author mathieu
	 * @param string String
	 * @return boolean
	 */
	public boolean checkFormatMail(String string) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+_]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
		Matcher m = p.matcher(string.toUpperCase());
		
		return m.matches();
	}
	
	public boolean checkNom(String nom){
		return fieldNom.getText().indexOf(" ") > 0;
	}
	
	public boolean checkPrenom(String prenom){
		return fieldPrenom.getText().indexOf(" ") > 0;
	}
	
	public void sauvegarderFichier(){
		// a voir avec la couche métier ou donnee
		if(checkFormatMail(fieldMail.getText())){
			System.out.println("true");
		}
	}

	
	/**
	 * @author Lionel
	 * @author Florent
	 * Detail : Implementation du passage d'ancien candidat à nouveau
	 * <br> et vice versa.
	 * <br> Implementation des modifications des champs et boutons
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == itemQuitter)
		{
			System.exit(0);
		}
		if(e.getSource() == itemAide)
		{
			JOptionPane.showMessageDialog(null, "Cette interface n'est pas développée - en attente de l'équipe Projet");
		}
		
				
		if(e.getSource() == itemCandidatExistant)
		{
			
			int option = JOptionPane.showConfirmDialog(null,
					"Etes vous sur de vouloir quitter le formulaire ?",
					"Confirmation !",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);
			
			if(option == JOptionPane.OK_OPTION)
			{
				
				this.fieldNom.setEditable(false);
				this.fieldPrenom.setEditable(false);
				this.fieldMail.setEditable(false);
				this.fieldTelephone.setEditable(false);
				this.fieldId.setEditable(true);
	
				this.fieldNom.setText(null);
				this.fieldPrenom.setText(null);
				this.fieldMail.setText(null);
				this.fieldTelephone.setText(null);
				this.fieldId.setText(null);
				
				this.boutonSave.setText("Rechercher");
				
			
			}
		}
		
		
		
		if(e.getSource() == itemNouveauCandidat)
		{
			int option = JOptionPane.showConfirmDialog(null,
					"Etes vous sur de vouloir quitter le formulaire ?",
					"Confirmation !",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE);
			
			if(option == JOptionPane.OK_OPTION)
			{
			Candidat cd = new Candidat();
			
			this.fieldNom.setEditable(true);
			this.fieldPrenom.setEditable(true);
			this.fieldMail.setEditable(true);
			this.fieldTelephone.setEditable(true);
			this.fieldId.setEditable(false);
			
			
			this.fieldNom.setText(null);
			this.fieldPrenom.setText(null);
			this.fieldMail.setText(null);
			this.fieldTelephone.setText(null);
			this.fieldId.setText(null);
			
			this.boutonSave.setText("Sauvegarder");
			
			//on fait appraitre le numéro du nouveau candidat
			try {
				this.fieldId.setText(cd.definirNumeroCandidat());

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			}
		}
	}

	
}
