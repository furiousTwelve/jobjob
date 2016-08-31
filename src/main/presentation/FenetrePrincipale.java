/**
 * 
 */
package main.presentation;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.donnees.EnregistrementDonnee;
import main.metier.Candidat;

/**
 * <b>Définit la fenêtre principale de l'application qui va gérer l'interaction des différents panneaux </b>
 * 
 * 
 * <ul>
 * <li>Un panneau sera déclaré pour chaque interface/étape de l'application ...</li>
 * </ul>
 * 
 * 
 * @author Mathieu
 * @author Cyril
 * @author Damien
 * 
 * @version 1.02
 */

public class FenetrePrincipale extends JFrame implements ActionListener
{
	private panelAccueil panAccueil;
	private panelFormulaire panFormulaire;
	private panelCandidat panCandidat;
	private panelQuestion panQuestion;
	private panelFin panFin;
	private EnregistrementDonnee ed;

	private int compteurQuestions = 0;


	/**
	 * 
	 * @throws HeadlessException Si jamais il y a un problème d'environnement avec le clavier et/ou souris
	 * @throws ParseException 
	 * @author Damien
	 */

	public FenetrePrincipale() throws HeadlessException, ParseException 
	{

		this.setTitle("Job-Job"); 
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(true);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);

		panAccueil = new panelAccueil();
		panFormulaire = new panelFormulaire();
		panCandidat = new panelCandidat();
		panQuestion = new panelQuestion();
		panFin = new panelFin();
		ed = new EnregistrementDonnee();

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

			panFormulaire.panelElementBasCentre.remove(panFormulaire.boutonSave);
			panFormulaire.panelElementBasCentre.add(panFormulaire.boutonSearch);
			panFormulaire.boutonSearch.addActionListener(this);
			
			this.getContentPane().removeAll();
			this.setContentPane(panFormulaire);
			this.validate();
		}


		//Passage du panFormulaire au panCandidat
		/**
		 * Cette partie gère la partie sauvegarde dans le panel panFormulaire
		 * <br>la validité du prenom et du nom est géré dans la classe du panel.
		 * <br>la validité du mail et du téléphone sont géré ici.
		 * <br>Si l'un des deux ou les deux sont faux, on ne peut pas enregistrer. L'utilisateur est averti des erreurs ( champs écrits en rouge).
		 * <br>Si les deux sont valides, on passe au panel panCandidat
		 */
		if(arg0.getSource() == this.panFormulaire.boutonSave || arg0.getSource() == this.panFormulaire.itemSauvegarder)
		{	
			//TODO pour  @cyril : à vérifier
			//panFormulaire.sauvegarderFichier();// voir avec la couche métier ou donnee 
			System.out.println(panFormulaire.fieldTelephone.getText());
			
			if(panFormulaire.checkFormatMail(panFormulaire.fieldMail.getText()) && !panFormulaire.fieldTelephone.getText().substring(13).equals(" "))
			{
				panCandidat.buttonStart.addActionListener(this);
				this.getContentPane().removeAll();
				this.setContentPane(panCandidat);
				this.validate();
				Candidat leCandidat = new Candidat();
				leCandidat.enregistrerNouveauCandidat(panFormulaire);	
			}
			else{
				String str = "Erreur(s) sur le(s) champ(s) : ";
				panFormulaire.fieldMail.setForeground(Color.BLACK);
				panFormulaire.champ3.setForeground(Color.BLACK);
				panFormulaire.fieldTelephone.setForeground(Color.BLACK);
				panFormulaire.champ4.setForeground(Color.BLACK);
				panFormulaire.fieldNom.setEditable(false);
				panFormulaire.fieldPrenom.setEditable(false);
				panFormulaire.fieldMail.setEditable(false);
				panFormulaire.fieldTelephone.setEditable(false);
				if(!panFormulaire.checkFormatMail(panFormulaire.fieldMail.getText())){
					panFormulaire.fieldMail.setEditable(true);
					panFormulaire.fieldMail.setForeground(Color.RED);
					panFormulaire.champ3.setForeground(Color.RED);
					str = str + "\n - E-mail ";
				}
				if(panFormulaire.fieldTelephone.getText().indexOf(" ") >= 0){
					panFormulaire.fieldTelephone.setEditable(true);
					panFormulaire.fieldTelephone.setForeground(Color.RED);
					panFormulaire.champ4.setForeground(Color.RED);
					str = str + "\n - Téléphone ";
				}
				JOptionPane.showMessageDialog(panFormulaire, str, "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		
		if(arg0.getSource() == this.panFormulaire.boutonSearch){
			if(ed.rechercheCandidat(panFormulaire.fieldId.getText())){
				panCandidat.buttonStart.addActionListener(this);

				this.getContentPane().removeAll();
				this.setContentPane(panCandidat);
				this.validate();
			}
			else{
				JOptionPane.showMessageDialog(panFormulaire, "Candidat introuvable", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			}
		}

		//Passage du panCandidat au panQuestion
		if(arg0.getSource() == this.panCandidat.buttonStart)
		{	

			this.getContentPane().removeAll();
			this.setContentPane(panQuestion);
			this.validate();
		}


		//Passage d'une question à une autre ?



		//Passage du panQuestion au panFin
		if(compteurQuestions == 15)
		{	
			this.getContentPane().removeAll();
			this.setContentPane(panFin);
			this.validate();
		}
	
	}


	//		/**
	//		 * Les actions à mener sur notre panel Accueil, chargé initialement
	//		 */
	//		//Quitter l'appli	
	//			if((arg0.getSource() == this.panAccueil.itemQuitter) || (arg0.getSource() == this.panFormulaire.itemQuitter))
	//			{	
	//				// a voir, message erreur dans console
	//				this.dispose();
	//			}
	//		// Affichage de l'aide
	//			if(arg0.getSource() == this.panAccueil.itemAide)
	//			{	
	//				JOptionPane.showMessageDialog(null, "Cette interface n'est pas développée - en attente de l'équipe Projet");
	//			}

	/**
	 * Rechargement d'un formulaire depuis un panel Formulaire
	 */




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
