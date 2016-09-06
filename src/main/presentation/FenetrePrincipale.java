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
 * 
 * @author Mathieu
 * @author Cyril
 * @author Damien
 * @author Florent
 * @author Audric
 * 
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
	private questionReponse laQuestionReponse;
	public questionReponse[] questionsCandidat;
	/**
	 * 
	 * @throws HeadlessException Si jamais il y a un problème d'environnement avec le clavier et/ou souris
	 * @throws ParseException 
	 * @author Damien
	 */

	public FenetrePrincipale() throws HeadlessException, ParseException 
	{
		
	    questionsCandidat = new questionReponse[15]; // Couche METIER
	    laQuestionReponse= new questionReponse(); // Couche METIER
		
		this.setTitle("Job-Job"); 
//		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(true);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);

		panConnection = new panelConnection();
		
		panFormulaire = new panelFormulaire();
		panCandidat = new panelCandidat();
		panQuestion = new panelQuestion();
		panFin = new panelFin();
		ed = new EnregistrementDonnee();

		this.panConnection.boutonConnection.addActionListener(this);
		
		//this.setContentPane(panCandidat); // imbrication de notre panel dans notre fenêtre
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
			System.out.println("acces: "+acces);
			if(acces==true)
			{
				panAccueil = new panelAccueil();
			
				this.panAccueil.itemCandidatExistant.addActionListener(this);
				this.panAccueil.itemNouveauCandidat.addActionListener(this);
				this.panAccueil.itemNouveauTest.addActionListener(this);
				this.panAccueil.itemQuitter.addActionListener(panAccueil);
				this.panAccueil.itemAide.addActionListener(panAccueil);
			
				this.getContentPane().removeAll();
				this.setContentPane(panAccueil);
				this.validate();
			}
			else
			{
				JOptionPane.showMessageDialog(panFormulaire, "Votre identifiant et/ou mot de passe est incorrect", "Accès non autorisé", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		// Passage du panAccueil au PanFormulaire
		//Première possibilité, c'est un nouveau candidat, le champ N° identifiant sera grisé
		if(arg0.getSource() == this.panAccueil.itemNouveauCandidat)
		{	
						
			panFormulaire.fieldNom.setEditable(true);
			panFormulaire.fieldPrenom.setEditable(true);
			panFormulaire.fieldMail.setEditable(true);
			panFormulaire.fieldTelephone.setEditable(true);
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
			panFormulaire.fieldId.setEditable(true);

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
		 * <br>la validité du prenom et du nom est géré ici via une méthode de panFormulaire.
		 * <br>la validité du mail et du téléphone sont géré ici.
		 * <br>Si l'un des deux ou les deux sont faux, on ne peut pas enregistrer. L'utilisateur est averti des erreurs ( champs écrits en rouge).
		 * <br>Si les deux sont valides, on passe au panel panCandidat
		 */
		if(arg0.getSource() == this.panFormulaire.boutonSave || arg0.getSource() == this.panFormulaire.itemSauvegarder)
		{	
			//TODO pour  @cyril : à vérifier
			//panFormulaire.sauvegarderFichier();// voir avec la couche métier ou donnee 
			System.out.println(panFormulaire.fieldTelephone.getText());
			
			if(panFormulaire.checkFormatMail(panFormulaire.fieldMail.getText()) && panFormulaire.fieldTelephone.getText().indexOf(" ") < 0 
					&& panFormulaire.checkNom(panFormulaire.fieldNom.getText()) && panFormulaire.checkPrenom(panFormulaire.fieldPrenom.getText()))
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
				if(panFormulaire.fieldTelephone.getText().indexOf(" ") >= 0){
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
			laQuestionReponse.genererQuestionsCandidat();

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
		if(arg0.getSource() == this.panQuestion.boutonValider && compteurQuestions < 16){
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
				
				
				laQuestionReponse.chercherQuestionRéponse(questionsCandidat, compteurQuestions-1);
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
			if(compteurQuestions == 11){
				
				panQuestion.labelTimer.setText("Timer");
				
			}
			
		
		//Passage du panQuestion au panFin

		if(compteurQuestions == 16)
		{
			
			//Couche metier Timer
//			TimerGeneral tp = new TimerGeneral();
//			tp.stop();
//			return;

			this.getContentPane().removeAll();
			this.setContentPane(panFin);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			panFin.boutonConnection.addActionListener(this);
			this.validate();
			
		}
		}
		if(arg0.getSource() == this.panFin.boutonConnection ){
			
			//Message d'erreur uniquement si erreurs sur les identifiants
			
			//JOptionPane.showMessageDialog(panFin, "Connection impossible", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			
			panAccueil = new panelAccueil();
			
			this.panAccueil.itemCandidatExistant.addActionListener(this);
			this.panAccueil.itemNouveauCandidat.addActionListener(this);
			this.panAccueil.itemNouveauTest.addActionListener(this);
			this.panAccueil.itemQuitter.addActionListener(panAccueil);
			this.panAccueil.itemAide.addActionListener(panAccueil);
			
			this.getContentPane().removeAll();
			this.setContentPane(panAccueil);
			this.validate();
		}
		
		
		//Passage du panFormulaire aux panels ajout modif et supprimer question
		
		panAjouterQuestion = new panelAjouterQuestion();
		panModifierQuestion = new panelModifierQuestion();
		panSupprimerQuestion = new panelSupprimerQuestion();
		
		if(arg0.getSource() == this.panFormulaire.itemAjoutQuestion)
		{
			this.getContentPane().removeAll();
			this.setContentPane(panAjouterQuestion);
			this.validate();
		}
		if(arg0.getSource() == this.panFormulaire.itemModifierQuestion)
		{
			this.getContentPane().removeAll();
			this.setContentPane(panModifierQuestion);
			this.validate();
		}
		if(arg0.getSource() == this.panFormulaire.itemSupprimerQuestion)
		{
			this.getContentPane().removeAll();
			this.setContentPane(panSupprimerQuestion);
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
