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
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.donnees.EnregistrementDonnee;
import main.metier.Candidat;
import main.metier.TimerGeneral;
import main.metier.questionReponse;
import main.metier.Recruteur;
/**
 * <b>Définit la fenêtre principale de l'application qui va gérer l'interaction des différents panneaux </b>
 * 
 * 
 * <ul>
 * <li>Un panneau sera déclaré pour chaque interface/étape de l'application ...</li>
 * </ul>
 * 
 * @author Mathieu
 * @author Cyril
 * @author Damien
 * @author Florent
 * @author Audric
 * @author Benjamin
 * @author Lionel 
 * @version 1.02
 */

public class FenetrePrincipale extends JFrame implements ActionListener
{
	
	
 
	private panelConnection panConnection;
	private panelAccueil panAccueil;
	private panelFormulaire panFormulaire;
	private panelCandidat panCandidat;
	private panelQuestion panQuestion;
	private panelFin panFin;
	private panelAjouterQuestion panAjouterQuestion;
	private panelModifierQuestion panModifierQuestion;
	private panelSupprimerQuestion panSupprimerQuestion;
	private EnregistrementDonnee ed;
	

	private int compteurQuestions = 1;
	
	// Pour la couche métier
	public questionReponse laQuestionReponse = new questionReponse();
	public questionReponse[] questionsCandidat = new questionReponse[15];  
	
	private TimerGeneral tp;
	private TimerGeneral TimerS;

	/**
	 * 
	 * @throws HeadlessException Si jamais il y a un problème d'environnement avec le clavier et/ou souris
	 * @throws ParseException 
	 * @author Damien
	 */
	public FenetrePrincipale() 
	{
		// test graphe khadidja
	//	dg.DessinerBar();
	//	dg.DessinerCam();
		
		laQuestionReponse= new questionReponse(); // Couche METIER
	    questionsCandidat = new questionReponse[15]; // Couche METIER
	    
		
		this.setTitle("Job-Job"); 
//		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		

		panConnection = new panelConnection();

		panFormulaire = new panelFormulaire();
		panCandidat = new panelCandidat();
		panQuestion = new panelQuestion();
		panFin = new panelFin();
		panAjouterQuestion = new panelAjouterQuestion();
		panModifierQuestion = new panelModifierQuestion();
		panSupprimerQuestion = new panelSupprimerQuestion();

		ed = new EnregistrementDonnee();

		panConnection.boutonConnection.addActionListener(this);
		panConnection.boutonQuitter.addActionListener(this);
	

		this.setContentPane(panConnection); 

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

		/**
		 * On va avoir par la suite tout les enchaînements entre les différents panel à charger dans notre fenêtre
		 */
		
		//Passage du panConnection au panAccueil, si id et mdp valides
		if(arg0.getSource() == this.panConnection.boutonConnection){
			
			//Couche METIER
			boolean acces=false;
			String recruteur=panConnection.recruteur.getText();
			String motDePasse=panConnection.mdp.getText();
			
			Recruteur leRecruteur = new Recruteur(recruteur,motDePasse);
			try 
			{
				acces=leRecruteur.verifierAcces(recruteur,motDePasse);
			} catch (ClassNotFoundException | SQLException e) {
				
				JOptionPane.showMessageDialog(panFormulaire, "Erreur interne au programme -- Defaut de la connexion au serveur SQL", "Erreur programme", JOptionPane.ERROR_MESSAGE);
			}
			
			if(acces==true)
			{
				
				panAccueil = new panelAccueil();
			
				this.panAccueil.itemCandidatExistant.addActionListener(this);
				this.panAccueil.itemNouveauCandidat.addActionListener(this);
				this.panAccueil.itemNouveauTest.addActionListener(this);

				this.panAccueil.itemAjoutQuestion.addActionListener(this);
				this.panAccueil.itemModifierQuestion.addActionListener(this);
				this.panAccueil.itemSupprimerQuestion.addActionListener(this);
				

				this.panAccueil.itemQuitter.addActionListener(panAccueil);
				this.panAccueil.itemAide.addActionListener(panAccueil);


				this.getContentPane().removeAll();
				this.setContentPane(panAccueil);

				this.validate();
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(panConnection, "Votre identifiant et/ou mot de passe est incorrect", "Accès non autorisé", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		// fermer l'application depuis panel connection
		if(arg0.getSource() == panConnection.boutonQuitter  )
		{	
			System.exit(0);	
		}

		/**
		 * @author Lionel
		 * @author autres personnes precedentes.
		 * Description : ci dessous on gère le formulaire en fonction de l'item du menu sélectionné
		 * Passage du panAccueil au PanFormulaire
		 * 
		 */			
		
		// Passage du panAccueil au PanFormulaire

		//Première possibilité, c'est un nouveau candidat, le champ N° identifiant sera grisé

		//if(arg0.getSource() == panAccueil.itemNouveauCandidat || arg0.getSource() == panFormulaire.itemNouveauCandidat)
		if(arg0.getSource() == panAccueil.itemNouveauCandidat )
		{	

			Candidat cd = new Candidat();
			
			panFormulaire.fieldNom.setEditable(true);
			panFormulaire.fieldPrenom.setEditable(true);
			panFormulaire.fieldMail.setEditable(true);
			panFormulaire.fieldTelephone.setEditable(true);
			panFormulaire.fieldId.setEditable(false);

			panFormulaire.itemSauvegarder.setEnabled(true);

			panFormulaire.itemSauvegarder.addActionListener(this);	
			panFormulaire.boutonSave.addActionListener(this);
	

			this.panFormulaire.itemAjoutQuestion.addActionListener(this);
			this.panFormulaire.itemModifierQuestion.addActionListener(this);
			this.panFormulaire.itemSupprimerQuestion.addActionListener(this);
			
			this.getContentPane().removeAll();

			this.setContentPane(panFormulaire);
			this.validate();

			
			//on fait appraitre le numéro du nouveau candidat
			panFormulaire.fieldId.setText(cd.definirNumeroCandidat());
			

		}
			
			

		if(arg0.getSource() == panFormulaire.itemNouveauCandidat)
		{			
			panFormulaire.fieldNom.setEditable(true);
			panFormulaire.fieldPrenom.setEditable(true);
			panFormulaire.fieldMail.setEditable(true);
			panFormulaire.fieldTelephone.setEditable(true);
			panFormulaire.fieldId.setEditable(false);

			panFormulaire.itemSauvegarder.setEnabled(true);


			panFormulaire.itemSauvegarder.addActionListener(this);	
			panFormulaire.boutonSave.addActionListener(this);
			
			this.panFormulaire.itemAjoutQuestion.addActionListener(this);
			this.panFormulaire.itemModifierQuestion.addActionListener(this);
			this.panFormulaire.itemSupprimerQuestion.addActionListener(this);

			this.getContentPane().removeAll();
			this.setContentPane(panFormulaire);
			this.validate();
			
			
			
		}	

			
		
			
		//Seconde possibilité, c'est un candidat existant, seul le champ N° identifiant sera accessible
		
		if(arg0.getSource() == panFormulaire.itemCandidatExistant)
		{	
			panFormulaire.fieldNom.setEditable(false);
			panFormulaire.fieldPrenom.setEditable(false);
			panFormulaire.fieldMail.setEditable(false);
			panFormulaire.fieldTelephone.setEditable(false);
			panFormulaire.fieldId.setEditable(true);

			panFormulaire.itemAjoutQuestion.addActionListener(this);
			panFormulaire.itemModifierQuestion.addActionListener(this);
			panFormulaire.itemSupprimerQuestion.addActionListener(this);	

			panFormulaire.boutonSave.addActionListener(this);
			
			this.getContentPane().removeAll();
			this.setContentPane(panFormulaire);
			this.validate();
				
		}
			
		if(arg0.getSource() == panAccueil.itemCandidatExistant)
		{
			
			panFormulaire.fieldNom.setEditable(false);
			panFormulaire.fieldPrenom.setEditable(false);
			panFormulaire.fieldMail.setEditable(false);
			panFormulaire.fieldTelephone.setEditable(false);
			panFormulaire.fieldId.setEditable(true);
			
			panFormulaire.itemAjoutQuestion.addActionListener(this);
			panFormulaire.itemModifierQuestion.addActionListener(this);
			panFormulaire.itemSupprimerQuestion.addActionListener(this);	
			
			panFormulaire.boutonSave.setText("Rechercher");
			panFormulaire.boutonSave.addActionListener(this);
			
			this.getContentPane().removeAll();
			this.setContentPane(panFormulaire);
			this.validate();
			
			
			
			
		}
			
		/**
		 * @author Florent
		 * @detail : Implementation du bouton rechercher
		 * <br>ici on vérifie si le bouton s'apelle "Rechercher"
		 * <br>si oui, execute le contenu 
		 */
		
		if(arg0.getActionCommand().equals("Rechercher")){
			if(ed.rechercheCandidat(panFormulaire.fieldId.getText())){
				panCandidat.buttonStart.addActionListener(this);
				
				this.getContentPane().removeAll();
				this.setContentPane(panCandidat);
				this.validate();
			}
			
		}

		//Passage du panFormulaire au panCandidat
		/**
		 * Cette partie gère la partie sauvegarde dans le panel panFormulaire
		 * <br>la validité du prenom et du nom est géré ici via une méthode de panFormulaire.
		 * <br>la validité du mail et du téléphone sont géré ici.
		 * <br>Si l'un des deux ou les deux sont faux, on ne peut pas enregistrer. L'utilisateur est averti des erreurs ( champs écrits en rouge).
		 * <br>Si les deux sont valides, on passe au panel panCandidat
		 */
		if(arg0.getSource() == this.panFormulaire.boutonSave || arg0.getSource() == this.panFormulaire.itemSauvegarder)
		{	

			System.out.println(panFormulaire.fieldTelephone.getText());

			if(panFormulaire.checkFormatMail(panFormulaire.fieldMail.getText()) 

					&& panFormulaire.checkNom(panFormulaire.fieldNom.getText()) && panFormulaire.checkPrenom(panFormulaire.fieldPrenom.getText()))
			{
				Candidat leCandidat = new Candidat(panFormulaire);
				try {
					leCandidat.enregistrerNouveauCandidat();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				panCandidat.buttonStart.addActionListener(this);
				this.getContentPane().removeAll();
				this.setContentPane(panCandidat);
				this.validate();
					
			}
			else{
				String str = "Erreur(s) sur le(s) champ(s) : ";
				panFormulaire.fieldNom.setForeground(Color.BLACK);

				panFormulaire.champNom.setForeground(Color.BLACK);
				panFormulaire.fieldPrenom.setForeground(Color.BLACK);
				panFormulaire.champPrenom.setForeground(Color.BLACK);

				panFormulaire.fieldMail.setForeground(Color.BLACK);
				panFormulaire.champ3.setForeground(Color.BLACK);
				panFormulaire.fieldTelephone.setForeground(Color.BLACK);
				panFormulaire.champ4.setForeground(Color.BLACK);
				
				if(!panFormulaire.checkNom(panFormulaire.fieldNom.getText())){
					panFormulaire.fieldNom.setForeground(Color.RED);
					panFormulaire.champNom.setForeground(Color.RED);
					str = str + "\n - Nom ";
				}
				if(!panFormulaire.checkPrenom(panFormulaire.fieldPrenom.getText())){
					panFormulaire.fieldPrenom.setForeground(Color.RED);
					panFormulaire.champPrenom.setForeground(Color.RED);
					str = str + "\n - Prenom ";
				}
				if(!panFormulaire.checkFormatMail(panFormulaire.fieldMail.getText())){
					panFormulaire.fieldMail.setForeground(Color.RED);
					panFormulaire.champ3.setForeground(Color.RED);
					str = str + "\n - E-mail ";
				}

				
				JOptionPane.showMessageDialog(panFormulaire, str, "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		//Passage du panCandidat au panQuestion
		if(arg0.getSource() == this.panCandidat.buttonStart)
		{	
			panQuestion= new panelQuestion();
			
			// Couche méier: appel de la fonction ChercherQuestionRéponse, qui elle m^meme va appeler une fonction de la coche donnée pour remplir le tableau de questions
			
			try {
				System.out.println("Passage panCandidat --> panQuestion");
				laQuestionReponse.questionsCandidat = laQuestionReponse.chercherQuestionRéponse(laQuestionReponse.questionsCandidat);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			tp = new TimerGeneral(10);
			tp.start();

			this.getContentPane().removeAll();
			
			// Couche METIER ==>  Affichage de la première question
			panQuestion.labelQuestion.setText(laQuestionReponse.questionsCandidat[0].libelleQuestion);
			panQuestion.reponse1.setText(laQuestionReponse.questionsCandidat[0].libelleReponse1);
			panQuestion.reponse2.setText(laQuestionReponse.questionsCandidat[0].libelleReponse2);
			panQuestion.reponse3.setText(laQuestionReponse.questionsCandidat[0].libelleReponse3);
			panQuestion.reponse4.setText(laQuestionReponse.questionsCandidat[0].libelleReponse4);
			
			this.setContentPane(panQuestion);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			panQuestion.boutonValider.addActionListener(this);
			this.validate();
		}


		//Passage d'une question à une autre 
		if(arg0.getSource() == this.panQuestion.boutonValider && compteurQuestions < 16)
		{
			// COUCHE METIER
			byte tempReponse=0;
			boolean reponseChoisie=false;
			
			
			if(panQuestion.reponse1.isSelected())
			{
				tempReponse=1;
				reponseChoisie=true;
			}
			if(panQuestion.reponse2.isSelected())
			{
				tempReponse=2;
				reponseChoisie=true;
			}
			if(panQuestion.reponse3.isSelected())
			{
				tempReponse=3;
				reponseChoisie=true;
			}
			if(panQuestion.reponse4.isSelected())
			{
				tempReponse=4;
				reponseChoisie=true;
			}			

			
			if(reponseChoisie==true)
			{
				laQuestionReponse.recupereReponse(tempReponse,compteurQuestions);			
			
				compteurQuestions++;
				
				panQuestion.reponse1.setSelected(false);
				panQuestion.reponse2.setSelected(false);
				panQuestion.reponse3.setSelected(false);
				panQuestion.reponse4.setSelected(false);				

				panQuestion.labelQuestion.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleQuestion);
				panQuestion.reponse1.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleReponse1);
				panQuestion.reponse2.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleReponse2);
				panQuestion.reponse3.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleReponse3);
				panQuestion.reponse4.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleReponse4);
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(panQuestion, "Vous n'avez pas choisi de réponse", "Choix non validé", JOptionPane.ERROR_MESSAGE);
			}
			
			
			panQuestion.labelTimer.setText("");
			if(compteurQuestions == 11)
			{
				panQuestion.labelTimer.setText("Timer");
			}
			
			
		
		}
		
				
		//Arrêt à la question 12
		if(compteurQuestions == 12){
			TimerS = new TimerGeneral(120);
			//Lancer le TimerStress
			TimerS.start();
			TimerS.tache.cancel();
		}
		
		//Passage du panQuestion au panFin

		if(compteurQuestions == 16)
		{
			panFin = new panelFin();
			//Couche metier Timer
			//arrêter le timer après la 15ème question
			tp.tache.cancel();
			System.out.println(tp.secondPassed);
			
			this.getContentPane().removeAll();
			this.setContentPane(panFin);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			panFin.boutonConnection.addActionListener(this);
			this.validate();	
		}
		
		
		
		

		if(arg0.getSource() == this.panFin.boutonConnection )
		{
			
			//Message d'erreur uniquement si erreurs sur les identifiants
			
			//JOptionPane.showMessageDialog(panFin, "Connection impossible", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			
			panAccueil = new panelAccueil();
			
			this.panAccueil.itemCandidatExistant.addActionListener(this);
			this.panAccueil.itemNouveauCandidat.addActionListener(this);
			this.panAccueil.itemNouveauTest.addActionListener(this);
//			this.panAccueil.itemQuitter.addActionListener(panAccueil);
//			this.panAccueil.itemAide.addActionListener(panAccueil);
			
			this.getContentPane().removeAll();
			this.setContentPane(panAccueil);
			this.validate();
		}
		

		
		//Passage du panFormulaire ou panAccueil aux panels ajout modif et supprimer question
		
		if(arg0.getSource() == this.panFormulaire.itemAjoutQuestion || arg0.getSource() == this.panAccueil.itemAjoutQuestion)

		{
			panAjouterQuestion = new panelAjouterQuestion();
			
			this.panAjouterQuestion.itemAjoutQuestion.addActionListener(this);
			this.panAjouterQuestion.itemModifierQuestion.addActionListener(this);
			this.panAjouterQuestion.itemSupprimerQuestion.addActionListener(this);
			this.panAjouterQuestion.itemNouveauCandidat.addActionListener(this);
			this.panAjouterQuestion.itemCandidatExistant.addActionListener(this);
			System.out.println("ici");
			this.getContentPane().removeAll();
			this.setContentPane(panAjouterQuestion);
			this.validate();
		}
		if(arg0.getSource() == this.panFormulaire.itemModifierQuestion || arg0.getSource() == this.panAccueil.itemModifierQuestion)
		{
			panModifierQuestion = new panelModifierQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panModifierQuestion);
			this.validate();
		}
		if(arg0.getSource() == this.panFormulaire.itemSupprimerQuestion || arg0.getSource() == this.panAccueil.itemSupprimerQuestion)
		{
			panSupprimerQuestion = new panelSupprimerQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panSupprimerQuestion);
			this.validate();
		}
		
		
		//Passage du panAjouterQuestion aux autres panels
		
		if(arg0.getSource() == this.panAjouterQuestion.itemAjoutQuestion)

		{
			panAjouterQuestion = new panelAjouterQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panAjouterQuestion);
			this.validate();
		}
		if(arg0.getSource() == this.panAjouterQuestion.itemModifierQuestion)

		{	
			panModifierQuestion = new panelModifierQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panModifierQuestion);
			this.validate();
		}
		if(arg0.getSource() == this.panAjouterQuestion.itemSupprimerQuestion)
		{
			panSupprimerQuestion = new panelSupprimerQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panSupprimerQuestion);
			this.validate();
		}
		if(arg0.getSource() == this.panAjouterQuestion.itemNouveauCandidat)
		{	
			panFormulaire = new panelFormulaire();
			
			panFormulaire.fieldNom.setEditable(true);
			panFormulaire.fieldPrenom.setEditable(true);
			panFormulaire.fieldMail.setEditable(true);
			panFormulaire.fieldTelephone.setEditable(true);
			panFormulaire.fieldId.setEditable(false);

			panFormulaire.itemSauvegarder.setEnabled(true);

			panFormulaire.itemSauvegarder.addActionListener(this);	
			panFormulaire.boutonSave.addActionListener(this);
	
			
			this.panFormulaire.itemAjoutQuestion.addActionListener(this);
			this.panFormulaire.itemModifierQuestion.addActionListener(this);
			this.panFormulaire.itemSupprimerQuestion.addActionListener(this);
			
			this.getContentPane().removeAll();
			this.setContentPane(panFormulaire);
			this.validate();
		}
		if(arg0.getSource() == this.panAjouterQuestion.itemCandidatExistant)
		{	
			panFormulaire = new panelFormulaire();
			
			panFormulaire.fieldNom.setEditable(false);
			panFormulaire.fieldPrenom.setEditable(false);
			panFormulaire.fieldMail.setEditable(false);
			panFormulaire.fieldTelephone.setEditable(false);
			panFormulaire.fieldId.setEditable(true);
			
			
			this.panFormulaire.itemAjoutQuestion.addActionListener(this);
			this.panFormulaire.itemModifierQuestion.addActionListener(this);
			this.panFormulaire.itemSupprimerQuestion.addActionListener(this);
			
			this.getContentPane().removeAll();
			this.setContentPane(panFormulaire);
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
