/**
 * 
 */
package main;


import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * <b>Définit la fenêtre principale de l'application qui va gérer l'interaction des différents panneaux </b>
 * 
 * 
 * <ul>
 * <li>Un panneau sera déclaré pour chaque interface/étape de l'application ...</li>
 * </ul>
 * 
 * 
 * @author Mathieu et Cyril
 * @version 1.02
 */

public class FenetrePrincipale extends JFrame implements ActionListener
{
	private panelAccueil panAccueil;
	private panelFormulaire panFormulaire;
	private panelCandidat panCandidat;
	private panelQuestion panQuestion;
	private panelFin panFin;

	
	/**
	 * 
	 * @throws HeadlessException Si jamais il y a un problème d'environnement avec le clavier et/ou souris
	 * @throws ParseException 
	 */

	public FenetrePrincipale() throws HeadlessException, ParseException 
	{

		this.setTitle("Job-Job"); 
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(true);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		
		panAccueil=new panelAccueil();
		panFormulaire = new panelFormulaire();
		panCandidat = new panelCandidat();
		panQuestion = new panelQuestion();
		panFin = new panelFin();

		this.panAccueil.itemCandidatExistant.addActionListener(this);
		this.panAccueil.itemNouveauCandidat.addActionListener(this);
		this.panAccueil.itemNouveauTest.addActionListener(this);
		this.panAccueil.itemQuitter.addActionListener(this);
		this.panAccueil.itemAide.addActionListener(this);
		
		this.setContentPane(panAccueil); // imbrication de notre panel dans notre fenêtre

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}


	
	/** Fonction qui récupère tous les ActionListener de tous les panneaux, issues des différents fichiers
	 * @param arg0
	 * 		Ce paramètre va permettre d'ouvrir un panneau selon les condition ci-dessous
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String composant=arg0.getActionCommand();
	//	panAccueil = new panelAccueil();
		
		/**
		 * On va avoir par la suite tout les enchaînements entre les différents panel à charger dans notre fenêtre
		 */
		// Passage du panAccueil au PanFormulaire
			//Première possibilité, c'est un nouveau candidat, le champ N° identifiant sera grisé
			if(arg0.getSource() == this.panAccueil.itemNouveauCandidat)
			{	
				panFormulaire.fieldId.setEditable(false);
				
				panFormulaire.itemSauvegarder.setEnabled(true);

				panFormulaire.itemSauvegarder.addActionListener(this);	
				panFormulaire.boutonSave.addActionListener(this);
				
				this.getContentPane().removeAll();
				this.setContentPane(panFormulaire);
				this.validate();
			}
			//Seconde possibilité, c'est un candidat existant, seul le champ N° identifiant sera accessible
			if(arg0.getSource() == this.panAccueil.itemCandidatExistant)
			{	
				panFormulaire.fieldNom.setEditable(false);
				panFormulaire.fieldPrenom.setEditable(false);
				panFormulaire.fieldMail.setEditable(false);
				panFormulaire.fieldTelephone.setEditable(false);
				
				panFormulaire.itemSauvegarder.setEnabled(true);

				panFormulaire.itemSauvegarder.addActionListener(this);	
				panFormulaire.boutonSave.addActionListener(this);
				
				this.getContentPane().removeAll();
				this.setContentPane(panFormulaire);
				this.validate();
			}
		
			
		//Passage du panFormulaire au panCandidat
			if(arg0.getSource() == this.panFormulaire.boutonSave || arg0.getSource() == this.panFormulaire.itemSauvegarder)
			{	

				this.getContentPane().removeAll();
				this.setContentPane(panCandidat);
				this.validate();
			}
		
			
			
			
//		if((arg0.getSource() == this.panAccueil.itemQuitter) || (arg0.getSource() == this.panFormulaire.itemQuitter))
//		{	
//			// a voir, message erreur dans console
//			this.dispose();
//		
//		}
//
//		
//		if(arg0.getSource() == this.panFormulaire.itemNouveauTest)
//		{	
//			// Ici mettre l'ouverture du panelQuestion
//		}
//		
//		if(arg0.getSource() == this.panFormulaire.itemSauvegarder)
//		{		
//			this.dispose();
//			this.setUndecorated(true);
//			this.setTitle("Job-Job"); 
//			this.setExtendedState(this.MAXIMIZED_BOTH);
//			//this.setMinimumSize(new Dimension(600, 400));
//			this.setResizable(false);
//			this.setLocationRelativeTo(null);
//			this.setContentPane(panCandidat);
//			this.setVisible(true);	
//			
//			Candidat c = new Candidat(this.panFormulaire.panelSaisie);
//			c.enregistrerNouveauCandidat(this.panFormulaire.panelSaisie);
//		}
//		
//		if(arg0.getSource() == this.panFormulaire.boutonSave)
//		{	
//			this.dispose();
//			this.setUndecorated(true);
//			this.setTitle("Job-Job"); 
//			this.setExtendedState(this.MAXIMIZED_BOTH);
//			//this.setMinimumSize(new Dimension(600, 400));
//			this.setResizable(false);
//			this.setLocationRelativeTo(null);
//			this.setContentPane(panCandidat);
//			this.setVisible(true);	
//			
//			Candidat c = new Candidat(this.panFormulaire.panelSaisie);
//			c.enregistrerNouveauCandidat(this.panFormulaire.panelSaisie);
//		}
	}

	
	
//=============================================== Fonctions créées initialement par David, non utilisées pour l'instant, mais elles sont peut-être poas là pour rien	=====================================================
	/**
     * Constructeur non utilisé sous la version 1.00 à 1.xx
     * @deprecated Depuis v1.00, remplacé par FenetrePrincipale() throws HeadlessException 
     */
	public FenetrePrincipale(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	/**
     * Constructeur non utilisé sous la version 1.00 à 1.xx
     * @deprecated Depuis v1.00, remplacé par FenetrePrincipale() throws HeadlessException 
     */
	public FenetrePrincipale(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
     * Constructeur non utilisé sous la version 1.00 à 1.xx
     * @deprecated Depuis v1.00, remplacé par FenetrePrincipale() throws HeadlessException 
     */
	public FenetrePrincipale(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
}
