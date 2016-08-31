package main.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 * Le panelFormulaire est le panel qui sera chargé par la fenêtre Principale après appui sur le bouton "NouveauTest".
 * Il est destiné à être rempli par le recruteur
 * @author Mathieu
 * @author Florent
 */
public class panelFormulaire extends JPanel implements ActionListener{

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
	protected JButton boutonSearch = new JButton("Rechercher");
	
	protected JFormattedTextField fieldNom = new JFormattedTextField();
	protected JFormattedTextField fieldPrenom = new JFormattedTextField();
	protected JTextField fieldMail = new JTextField();
	protected JFormattedTextField fieldTelephone = new JFormattedTextField();
	protected JFormattedTextField fieldId = new JFormattedTextField();

	protected JPanel panelSaisie;
	protected JPanel panelElementBasCentre;
	
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
	public panelFormulaire() throws ParseException {
		
		//Ajout de Listener sur tous les boutons nécessaires
		itemNouveauTest.addActionListener(this);			
		itemQuitter.addActionListener(this);	
		itemAide.addActionListener(this);	
		
		
		//Constitution de la barre de menu : menuBar
		menuBar.add(menuFichier);
		menuBar.add(menuAide);
		
		menuFichier.add(itemNouveauTest);
		itemNouveauTest.add(itemCandidatExistant);
		itemNouveauTest.add(itemNouveauCandidat);
		menuFichier.add(itemSauvegarder);
		itemSauvegarder.setEnabled(false);
		menuFichier.addSeparator();
		menuFichier.add(itemQuitter);
		
		menuAide.add(itemAide);
		
		
		
		//Création du panel de gauche, contenant le logo : panelLogo
		JPanel panelLogo = new JPanel();
		panelLogo.setLayout(new GridLayout(0, 3));
		
			//Création du logo
			ImageIcon logo = new ImageIcon("logoAFPA.png");
			Image img = logo.getImage();
			Image newImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			logo = new ImageIcon(newImg);
			JLabel logoFinal = new JLabel(logo);
			
			//TODO : faire une jolie boucle pour renplacer cette déclaration longue et brutale
			//Création des "cases vides"
			JLabel labelvide = new JLabel("");
			JLabel labelvide2 = new JLabel(" ");
			JLabel labelvide3 = new JLabel(" ");
			JLabel labelvide4 = new JLabel(" ");
			JLabel labelvide5 = new JLabel(" ");
			JLabel labelvide6 = new JLabel(" ");
			JLabel labelvide7 = new JLabel(" ");
			JLabel labelvide8 = new JLabel(" ");
	
			//TODO : faire une boucle ( à voir avec celle d'au dessus)
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
						panelCentreHaut.setLayout(new BoxLayout(panelCentreHaut, BoxLayout.PAGE_AXIS));
						
							//création du panel qui contiendra les champs de saisie :
							panelSaisie = new JPanel(new GridLayout(0, 2, 0, 20));
			
								//Création du contenu
								Font fontChampSaisie = new Font("Courier", Font.BOLD, 20);
								JLabel champ1 = new JLabel("Nom");
								champ1.setFont(fontChampSaisie);
								JLabel champ2 = new JLabel("Prénom");
								champ2.setFont(fontChampSaisie);
								champ3 = new JLabel("E-mail");
								champ3.setFont(fontChampSaisie);
								champ4 = new JLabel("Téléphone");
								champ4.setFont(fontChampSaisie);
								JLabel champ5 = new JLabel("N° identifiant");
								champ5.setFont(fontChampSaisie);
								

								//Un FormattedTextField permet de mettre une contrainte à ce qui est entré dans le TextField, à l'aide d'un Mask dont on définit la structure
								MaskFormatter maskNomPrenom = new MaskFormatter("**************************************************");
								maskNomPrenom.setValidCharacters("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ éèêëùûüçïî-öôâäà");
								fieldNom = new JFormattedTextField(maskNomPrenom);
								fieldPrenom = new JFormattedTextField(maskNomPrenom);
								
								
								MaskFormatter maskTelephone = new MaskFormatter("**.**.**.**.**");
								maskTelephone.setValidCharacters("0123456789");
								fieldTelephone = new JFormattedTextField(maskTelephone);
								fieldId = new JFormattedTextField();
						
								//Assemblage du panelSaisie
								panelSaisie.add(champ1);
								panelSaisie.add(fieldNom);
								panelSaisie.add(champ2);
								panelSaisie.add(fieldPrenom);
								panelSaisie.add(champ3);
								panelSaisie.add(fieldMail);
								panelSaisie.add(champ4);
								panelSaisie.add(fieldTelephone);
								panelSaisie.add(champ5);
								panelSaisie.add(fieldId);
								
								
						panelSaisie.setMaximumSize(new Dimension(400, 200));			
						panelCentreHaut.add(panelSaisie, BorderLayout.CENTER);
						
					//création du panel CentralCentre inférieur, qui contiendra 2 panels
						JPanel panelCentreBas = new JPanel();
						panelCentreBas.setLayout(new BoxLayout(panelCentreBas, BoxLayout.Y_AXIS));
						
							//Un Panel pour les futurs 4 réponses possibles
							JPanel panelReponses = new JPanel(new GridLayout(0, 4));
						
							//Un panel pour un élément centré
							panelElementBasCentre = new JPanel(new FlowLayout(FlowLayout.CENTER));
							panelElementBasCentre.add(boutonSave);

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
	
	public void sauvegarderFichier(){
		// a voir avec la couche métier ou donnee
		if(checkFormatMail(fieldMail.getText())){
			System.out.println("true");
		}
	}

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
	}

	
}
