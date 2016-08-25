package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

import org.omg.IOP.CodecPackage.FormatMismatch;

public class panelFormulaire extends JPanel {

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

	protected JPanel panelSaisie;

	
	public panelFormulaire() throws ParseException {
		
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
		
			
			
//		//Création du panel du milieu, contenant champs de saisie et bouton de sauvegarde : panelCentral
//			JPanel panelCentral = new JPanel(new BorderLayout());
			
			//Création du panel qui ira au centre du panelCentral : panelCentralCentral
			JPanel panelCentralCentre = new JPanel();
			panelCentralCentre.setLayout(new GridLayout(0, 1));
			
				//Il contiendra lui-même 2 panels : le panel des champs de saisie, le panel en-dessous
									
					// Création du panel CentralCentre supérieur, qui contiendra le panelSaisie
//						JPanel panelCentralCentreHaut = new JPanel(new BorderLayout());
						JPanel panelCentralCentreHaut = new JPanel();
						panelCentralCentreHaut.setLayout(new BoxLayout(panelCentralCentreHaut, BoxLayout.PAGE_AXIS));
//						panelCentralCentreHaut.setLayout(new FlowLayout(FlowLayout.CENTER));
						
							//création du panel qui contiendra les champs de saisie :
							panelSaisie = new JPanel(new GridLayout(0, 2, 0, 20));
			
								//Création du contenu
								Font fontChampSaisie = new Font("Courier", Font.BOLD, 20);
								JLabel champ1 = new JLabel("Nom");
								champ1.setFont(fontChampSaisie);
								JLabel champ2 = new JLabel("Prénom");
								champ2.setFont(fontChampSaisie);
								JLabel champ3 = new JLabel("E-mail");
								champ3.setFont(fontChampSaisie);
								JLabel champ4 = new JLabel("Téléphone");
								champ4.setFont(fontChampSaisie);
								JLabel champ5 = new JLabel("N° identifiant");
								champ5.setFont(fontChampSaisie);
								

//								MaskFormatter maskNomPrenom = new MaskFormatter();
//								maskNomPrenom.setValidCharacters("azertyuiopqsdfghjklmwxcvbnàéèêiïôùûAZERTYUIOPMLKJHGFDSQWXCVBN");
					
								JFormattedTextField fieldNom = new JFormattedTextField();
								JFormattedTextField fieldPrenom = new JFormattedTextField();
								
								JFormattedTextField fieldMail = new JFormattedTextField();
								
								MaskFormatter maskTelephone = new MaskFormatter("**.**.**.**.**");
								maskTelephone.setValidCharacters("0123456789");
								JFormattedTextField fieldTelephone = new JFormattedTextField(maskTelephone);
								
								JFormattedTextField fieldId = new JFormattedTextField();
						
								//Assemblage du panel
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
						panelCentralCentreHaut.add(panelSaisie, BorderLayout.CENTER);
						
					//création du panel CentralCentre inférieur, qui contiendra 2 panels
						JPanel panelCentralCentreBas = new JPanel();
						panelCentralCentreBas.setLayout(new BoxLayout(panelCentralCentreBas, BoxLayout.Y_AXIS));
						
							//Un Panel pour les futurs 4 réponses possibles
							JPanel panelReponses = new JPanel(new GridLayout(0, 4));
						
							//Un panel pour un élément centré
							JPanel panelElementBasCentre = new JPanel(new FlowLayout(FlowLayout.CENTER));
							panelElementBasCentre.add(boutonSave);

						panelCentralCentreBas.add(panelReponses);
						panelCentralCentreBas.add(panelElementBasCentre);
					
			
			//Assemblage du panelCentralCentre
			panelCentralCentre.add(panelCentralCentreHaut);
			panelCentralCentre.add(panelCentralCentreBas);
			
//		//Assemblage du panelCentral
//		panelCentral.add(panelCentralCentre, BorderLayout.CENTER);	
				
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
		this.add(panelCentralCentre, BorderLayout.CENTER);
		this.add(panelDroite, BorderLayout.EAST);
	

	}

	/**
	 * C'est une méthode permettant de vérifier la validité sous format mail d'un JLabel.
	 * retourne true si c'est un mail valide qui est entré.
	 * @author mathieu
	 * @param string
	 * @return boolean
	 */
	public boolean checkFormatMail(String string) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+_]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
		Matcher m = p.matcher(string.toUpperCase());
		
		return m.matches();
	}

	
}
