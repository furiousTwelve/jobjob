package main.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import main.donnees.ConnectionDB;
import main.donnees.EnregistrementDonnee;
import main.metier.Candidat;
import main.metier.Recruteur;
import main.metier.TimerGeneral;
import main.metier.questionReponse;

/**
 * <b>D�finit la fen�tre principale de l'application qui va g�rer l'interaction
 * des diff�rents panneaux </b>
 * 
 * 
 * <ul>
 * <li>Un panneau sera d�clar� pour chaque interface/�tape de l'application ...
 * </li>
 * </ul>
 * 
 * @author Mathieu
 * @author Cyril
 * @author Damien
 * @author Florent
 * @author Audric
 * @author Benjamin
 * @author Lionel 
 * @author Marc

 * @version 1.02
 */

public class FenetrePrincipale extends JFrame implements ActionListener {
	private PanelStatistique paneStatistique;
	private panelConnection panConnection;
	private panelConnection panConnectionRetour;
	private panelAccueil panAccueil;
	private panelFormulaire panFormulaire;
	private panelCandidat panCandidat;
	private panelQuestion panQuestion;
	private panelFin panFin;

	private panelAjouterQuestion panAjouterQuestion;
	private panelModifierQuestion panModifierQuestion;
	private panelSupprimerQuestion panSupprimerQuestion;
	private EnregistrementDonnee ed;
	public int compteurQuestions = 1;
	
	// Pour la couche m�tier
	public questionReponse laQuestionReponse = new questionReponse();
	public questionReponse[] questionsCandidat = new questionReponse[15];
	//private TimerGeneral tp;
	private TimerGeneral TimerS;

	private Candidat leCandidat;

	private Chrono fenChronoGeneral;
	private Chrono fenChronoStress;

	/**
	 * 
	 * @throws HeadlessException
	 *             Si jamais il y a un probl�me d'environnement avec le clavier
	 *             et/ou souris
	 * @throws ParseException
	 * @author Damien
	 */


	// TEST
	private Timer timerGeneral;
	private Timer timerStress;
	private int counterGeneral = 1800;
	private int counterStress = 30;
	private int delay = 1000;
	// FIN TEST
	
	public FenetrePrincipale() 
	{
		// TEST
		ActionListener actionGeneral = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				if(counterGeneral == 0)
				{
					System.out.println("Timer down");
					fenChronoGeneral.dispose();
					
					System.out.println("On g�n�re le tableau de score");
					laQuestionReponse.genererTableauScoreCandidat();
					System.out.println("On lance 'enregistrer score candidat'");
					try {
						ConnectionDB conn = new ConnectionDB();				
						conn.enregistrerScoreCandidat(laQuestionReponse.scoreParReponseCandidat, laQuestionReponse.questionsCandidat, leCandidat); // Petit doute sur le candidat
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	        		getContentPane().removeAll();
	        		setContentPane(panFin);
	        		
	    			panFin.boutonRetour.addActionListener(new ActionListener() {
	    				@Override
	    				public void actionPerformed(ActionEvent e) {
	    					dispose();
	    					FenetrePrincipale f = new FenetrePrincipale();
	    					f.show();
	    				}
	    			});
	        		
	        		validate();
					timerGeneral.stop();
				}
				else
				{
					System.out.println("counter g : " + counterGeneral);
					counterGeneral--;
				}
			}
		};
		
		timerGeneral = new Timer(delay, actionGeneral);
		timerGeneral.setInitialDelay(0);


		ActionListener actionStress = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				if(counterStress == 0)
				{
					System.out.println("Timer down");
					fenChronoStress.dispose();
					fenChronoGeneral.setVisible(true);							
		       		timerStress.stop();
				}
				else
				{
					System.out.println("counter s : " + counterStress);
					counterStress--;
				}
			}
		};
		timerStress = new Timer(delay, actionStress);
		timerStress.setInitialDelay(0);
		// FIN TEST
		
		
		// test graphe khadidja
		// dg.DessinerBar();
		// dg.DessinerCam();
		laQuestionReponse = new questionReponse(); // Couche METIER
		questionsCandidat = new questionReponse[15]; // Couche METIER

		leCandidat = new Candidat();

		
		this.setTitle("Job-Job");
		// this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(false);
		this.setMinimumSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		panConnection = new panelConnection();
		paneStatistique = new PanelStatistique();
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

	/**
	 * Fonction qui r�cup�re tous les ActionListener de tous les panneaux,
	 * issues des diff�rents fichiers
	 * 
	 * @param arg0
	 *            Ce param�tre va permettre d'ouvrir un panneau selon les
	 *            condition ci-dessous
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override

	public void actionPerformed(ActionEvent arg0)
	{
		/**
		 * On va avoir par la suite tout les encha�nements entre les diff�rents
		 * panel � charger dans notre fen�tre
		 */

		// Passage du panConnection au panAccueil, si id et mdp valides
		if (arg0.getSource() == this.panConnection.boutonConnection) {
			// Couche METIER
			boolean acces = false;
			String recruteur = panConnection.recruteur.getText();
			String motDePasse = panConnection.mdp.getText();

			Recruteur leRecruteur = new Recruteur(recruteur, motDePasse);
			try {
				acces = leRecruteur.verifierAcces(recruteur, motDePasse);
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(panFormulaire,
						"Erreur interne au programme -- Defaut de la connexion au serveur SQL", "Erreur programme",
						JOptionPane.ERROR_MESSAGE);
			}

			if (acces == true) {
				panAccueil = new panelAccueil();
				this.panAccueil.itemCandidatExistant.addActionListener(this);
				this.panAccueil.itemNouveauCandidat.addActionListener(this);
				this.panAccueil.itemNouveauTest.addActionListener(this);
				this.panAccueil.itemAjoutQuestion.addActionListener(this);
				this.panAccueil.itemModifierQuestion.addActionListener(this);
				this.panAccueil.itemSupprimerQuestion.addActionListener(this);
				this.panAccueil.itemStatistique.addActionListener(this);

				this.panAccueil.itemQuitter.addActionListener(panAccueil);
				this.panAccueil.itemAide.addActionListener(panAccueil);
				this.getContentPane().removeAll();
				this.setContentPane(panAccueil);
				this.validate();

			} else {
				JOptionPane.showMessageDialog(panConnection, "Votre identifiant et/ou mot de passe est incorrect",
						"Acc�s non autoris�", JOptionPane.ERROR_MESSAGE);
			}

		}
		// fermer l'application depuis panel connection
		if (arg0.getSource() == panConnection.boutonQuitter) {
			System.exit(0);
		}

		/**
		 * @author Lionel
		 * @author autres personnes precedentes. Description : ci dessous on
		 *         g�re le formulaire en fonction de l'item du menu s�lectionn�
		 *         Passage du panAccueil au PanFormulaire
		 * 
		 */

		// Passage du panAccueil au PanFormulaire

		// Premi�re possibilit�, c'est un nouveau candidat, le champ N�
		// identifiant sera gris�

		if (arg0.getSource() == panAccueil.itemNouveauCandidat) {

			//Candidat cd = new Candidat();
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
			// on fait appraitre le num�ro du nouveau candidat

			try {
				panFormulaire.fieldId.setText(leCandidat.definirNumeroCandidat());

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (arg0.getSource() == panAccueil.itemAjoutQuestion) {

			this.panAjouterQuestion.itemCandidatExistant.addActionListener(this);
			this.panAjouterQuestion.itemNouveauCandidat.addActionListener(this);
			this.panAjouterQuestion.itemNouveauTest.addActionListener(this);

			this.panAjouterQuestion.itemAjoutQuestion.addActionListener(this);
			this.panAjouterQuestion.itemModifierQuestion.addActionListener(this);
			this.panAjouterQuestion.itemSupprimerQuestion.addActionListener(this);
			this.panAjouterQuestion.itemStatistique.addActionListener(this);

			this.panAjouterQuestion.itemQuitter.addActionListener(panAccueil);
			this.panAjouterQuestion.itemAide.addActionListener(panAccueil);
			this.panAjouterQuestion.itemAjoutQuestion.addActionListener(this);
			this.panAjouterQuestion.itemModifierQuestion.addActionListener(this);
			this.panAjouterQuestion.itemSupprimerQuestion.addActionListener(this);

			this.getContentPane().removeAll();

			this.setContentPane(paneStatistique);
			this.validate();

		}

		if (arg0.getSource() == panFormulaire.itemNouveauCandidat) {
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

		// Seconde possibilit�, c'est un candidat existant, seul le champ N�
		// identifiant sera accessible

		if (arg0.getSource() == panFormulaire.itemCandidatExistant) {
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

		if (arg0.getSource() == panAccueil.itemCandidatExistant) {
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
		 * @author Audric
		 * @detail : Implementation du bouton rechercher <br>
		 *         ici on v�rifie si le bouton s'apelle "Rechercher" <br>
		 *         si oui, execute le contenu
		 */

		if (arg0.getActionCommand().equals("Rechercher")) {
			ConnectionDB laConnection = null;
			try {
				laConnection = new ConnectionDB();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (laConnection.recupererCandidatEnBase(panFormulaire.fieldId.getText())) {

					int option = JOptionPane.showConfirmDialog(null,
							"Le candidat est-il " + laConnection.prenom + " " + laConnection.nom + "?",
							"Confirmation !", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.NO_OPTION) {
						panFormulaire = new panelFormulaire();

						panFormulaire.fieldNom.setEditable(false);
						panFormulaire.fieldPrenom.setEditable(false);
						panFormulaire.fieldMail.setEditable(false);
						panFormulaire.fieldTelephone.setEditable(false);
						panFormulaire.fieldId.setEditable(true);

						panFormulaire.fieldNom.setText(null);
						panFormulaire.fieldPrenom.setText(null);
						panFormulaire.fieldMail.setText(null);
						panFormulaire.fieldTelephone.setText(null);
						panFormulaire.fieldId.setText(null);

						panFormulaire.boutonSave.setText("Rechercher");

						panFormulaire.boutonSave.addActionListener(this);

						this.getContentPane().removeAll();
						this.setContentPane(panFormulaire);
						this.validate();

					} else {
						panCandidat.buttonStart.addActionListener(this);

						this.getContentPane().removeAll();
						this.setContentPane(panCandidat);
						this.validate();
					}
				}
			} catch (ClassNotFoundException | HeadlessException | SQLException e) {
				e.printStackTrace();

			}
		}

		/** Passage du panFormulaire au panCandidat
		/*
		 * Cette partie g�re la partie sauvegarde dans le panel panFormulaire
		 * <br> la validit� du prenom et du nom est g�r� ici via une m�thode de
		 * panFormulaire. <br> la validit� du mail et du t�l�phone sont g�r�
		 * ici. <br> Si l'un des deux ou les deux sont faux, on ne peut pas
		 * enregistrer. L'utilisateur est averti des erreurs ( champs �crits en
		 * rouge). <br> Si les deux sont valides, on passe au panel panCandidat
		 */

	

		else if(arg0.getSource() == this.panFormulaire.boutonSave || arg0.getSource() == this.panFormulaire.itemSauvegarder)
		{	
			
			leCandidat.setNom(this.panFormulaire.fieldNom.getText());  
			leCandidat.setPrenom(this.panFormulaire.fieldPrenom.getText());
			leCandidat.setMail(this.panFormulaire.fieldMail.getText());
			leCandidat.setNumeroTelephone(this.panFormulaire.fieldTelephone.getText());
			leCandidat.setIdentifiant(this.panFormulaire.fieldId.getText());

			
			try {
				leCandidat.enregistrerNouveauCandidat();
			} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			if (panFormulaire.checkFormatMail(panFormulaire.fieldMail.getText())
				&& panFormulaire.checkNom(panFormulaire.fieldNom.getText())
				&& panFormulaire.checkPrenom(panFormulaire.fieldPrenom.getText())) 
			{



				/**
				 * @author Ana�sGueyte
				 * 
				 * @date 14/09/2016
				 * 
				 * @version jobjob_2_0 (en accord avec la BDD)
				 * 
				 * >> Ici on doit passer l'affichage en plein ecran
				 * 
				 * this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				 *
				 */
				panCandidat.buttonStart.addActionListener(this);
				this.getContentPane().removeAll();
				this.setContentPane(panCandidat);
				this.setExtendedState(JFrame.MAXIMIZED_BOTH); // @Ana�sGueyte -
																// Affiche la
																// fenetre en
																// FULL SCREEN
																// pendant
																// toutes les
																// questions

				this.validate();

			} else {
				String str = "Erreur(s) sur le(s) champ(s) : ";
				panFormulaire.fieldNom.setForeground(Color.BLACK);

				panFormulaire.fieldPrenom.setForeground(Color.BLACK);

				panFormulaire.fieldMail.setForeground(Color.BLACK);
				panFormulaire.champ3.setForeground(Color.BLACK);
				panFormulaire.fieldTelephone.setForeground(Color.BLACK);
				panFormulaire.champ4.setForeground(Color.BLACK);
				if (!panFormulaire.checkNom(panFormulaire.fieldNom.getText())) {
					panFormulaire.fieldNom.setForeground(Color.RED);

					str = str + "\n - Nom ";
				}
				if (!panFormulaire.checkPrenom(panFormulaire.fieldPrenom.getText())) {
					panFormulaire.fieldPrenom.setForeground(Color.RED);

					str = str + "\n - Prenom ";
				}
				if (!panFormulaire.checkFormatMail(panFormulaire.fieldMail.getText())) {
					panFormulaire.fieldMail.setForeground(Color.RED);
					panFormulaire.champ3.setForeground(Color.RED);
					str = str + "\n - E-mail ";
				}

				JOptionPane.showMessageDialog(panFormulaire, str, "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
			}
		}

		// Passage du panCandidat au panQuestion
		if (arg0.getSource() == this.panCandidat.buttonStart) {
			panQuestion = new panelQuestion();

			// Couche m�ier: appel de la fonction ChercherQuestionR�ponse, qui
			// elle m�me va appeler une fonction de la coche donn�e pour
			// remplir le tableau de questions

			System.out.println("Passage panCandidat --> panQuestion");

			try 
			{
				laQuestionReponse.questionsCandidat = laQuestionReponse.chercherQuestionR�ponse(laQuestionReponse.questionsCandidat);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}

			// D�marrage du timer g�n�ral
			//tp.start();
			timerGeneral.start();
			
			// LANCEMENT DU VISUEL CHRONO
			fenChronoGeneral = new Chrono(0);

			this.getContentPane().removeAll();
			// Couche METIER ==> Affichage de la premi�re question
			panQuestion.labelQuestion.setText(laQuestionReponse.questionsCandidat[0].libelleQuestion);
			panQuestion.reponse1.setText(laQuestionReponse.questionsCandidat[0].libelleReponse1);
			panQuestion.reponse2.setText(laQuestionReponse.questionsCandidat[0].libelleReponse2);
			panQuestion.reponse3.setText(laQuestionReponse.questionsCandidat[0].libelleReponse3);
			panQuestion.reponse4.setText(laQuestionReponse.questionsCandidat[0].libelleReponse4);
//			ImageIcon icone = new laQuestionReponse.imageQuestion(laQuestionReponse.blob));
			JLabel labelimage;
			try {
//				labelimage = new JLabel(laQuestionReponse.imageQuestion(laQuestionReponse.questionsCandidat[0].blob));
				panQuestion.iconeEntreprise.setIcon(laQuestionReponse.imageQuestion(laQuestionReponse.questionsCandidat[0].blob));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			panQuestion.remove(panQuestion.iconeEntreprise);
 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.setContentPane(panQuestion);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			panQuestion.boutonValider.addActionListener(this);
			this.validate();
		}


/**
 * @author cyril
 * Fonction qui va permettre de faire l'affichage des diff�rentes questions et r�ponses, lorsque le candidat valide
 * 
 * un compteur permet de g�rer plusieurs �tats et/ou d�clencheurs (comme le timmer g�nral et le timer Stress)
 */
		if (arg0.getSource() == this.panQuestion.boutonValider) 
		{

			// COUCHE METIER
			byte tempReponse = 0;
			String texteReponseChoisie = "";
			boolean reponseChoisie = false;

			if (panQuestion.reponse1.isSelected()) {
				tempReponse = 1;
				reponseChoisie = true;
				texteReponseChoisie = panQuestion.reponse1.getText();
			}
			if (panQuestion.reponse2.isSelected()) {
				tempReponse = 2;
				reponseChoisie = true;
				texteReponseChoisie = panQuestion.reponse2.getText();
			}
			if (panQuestion.reponse3.isSelected()) {
				tempReponse = 3;
				reponseChoisie = true;
				texteReponseChoisie = panQuestion.reponse3.getText();
			}
			if (panQuestion.reponse4.isSelected()) {
				tempReponse = 4;
				reponseChoisie = true;
				texteReponseChoisie = panQuestion.reponse4.getText();
			}

			
			if (reponseChoisie == true)
			{
				laQuestionReponse.recupereReponse(tempReponse, compteurQuestions, texteReponseChoisie);

				compteurQuestions++;

				panQuestion.reponse1.setSelected(false);
				panQuestion.reponse2.setSelected(false);
				panQuestion.reponse3.setSelected(false);
				panQuestion.reponse4.setSelected(false);				

				if(compteurQuestions < 16)
				{
					panQuestion.labelQuestion.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleQuestion);
					panQuestion.reponse1.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleReponse1);
					panQuestion.reponse2.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleReponse2);
					panQuestion.reponse3.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleReponse3);
					panQuestion.reponse4.setText(laQuestionReponse.questionsCandidat[compteurQuestions-1].libelleReponse4);
					
					JLabel labelimage;
					try {
//						labelimage = new JLabel(laQuestionReponse.imageQuestion(laQuestionReponse.questionsCandidat[compteurQuestions-1].blob));
						panQuestion.iconeEntreprise.setIcon(laQuestionReponse.imageQuestion(laQuestionReponse.questionsCandidat[compteurQuestions-1].blob));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(panQuestion, "Vous n'avez pas choisi de r�ponse", "Choix non valid�", JOptionPane.ERROR_MESSAGE);

			}
			
			//Lancement du timer stress
			//panQuestion.labelTimer.setText("");
			if(compteurQuestions == 11)
			{
				if (counterGeneral <= 30)
				{
					counterStress = counterGeneral;
					TimerS = new TimerGeneral(counterStress,this,panQuestion,laQuestionReponse, fenChronoGeneral, fenChronoStress);
				}
				else
				{
					counterStress = 30;
					TimerS = new TimerGeneral(counterStress,this,panQuestion,laQuestionReponse, fenChronoGeneral, fenChronoStress);
				}
				
				//Lancer le TimerStress
				TimerS.start2();
				timerStress.start();
				// Gestion de l'affichage du chrono
				fenChronoGeneral.setVisible(false);			
				fenChronoStress = new Chrono(1);
				//fenChronoStress.horloge();
			}
		}

				
		//Arr�t � la question 12
		if(compteurQuestions == 12)
		{
			int temps = counterStress - TimerS.secondPassed;
			System.out.println("le temps stress = " + temps);
			
			// Gestion de l'affichage du chrono
			fenChronoStress.setVisible(false);
			fenChronoGeneral.setVisible(true);
			timerStress.stop();
			TimerS.tache2.cancel();

		}

		// Passage du panQuestion au panFin

		/**
		 * @author Ana�sGueyte
		 * @date 15/09/2016
		 * @version jobjob_2_0 (en accord avec la BDD)
		 * 
		 *          >> J'ai rajout� deux lignes de code pour remettre la fenetre en petit et au centre de l'ecran � la fin du test
		 * 
		 */

		if (compteurQuestions == 16) 
		{

			System.out.println("On g�n�re le tableau de score");
			laQuestionReponse.genererTableauScoreCandidat();
			System.out.println("On lance 'enregistrer score candidat'");
			
			try {
				ConnectionDB conn = new ConnectionDB();				
				conn.enregistrerScoreCandidat(laQuestionReponse.scoreParReponseCandidat, laQuestionReponse.questionsCandidat, leCandidat); // Petit doute sur le candidat
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			fenChronoGeneral.dispose();
			timerGeneral.stop();

			panFin = new panelFin();
			// Couche metier Timer
			// arr�ter le timer apr�s la 15�me question
			//tp.tache.cancel();
			//System.out.println(tp.secondPassed);

			this.getContentPane().removeAll();
			this.setContentPane(panFin);
			this.setSize(800, 600); // La ligne de code qui remet la fenetre en
									// petit.
			this.setLocationRelativeTo(null); // La ligne qui remet la fenetre
												// au centre de l'ecran
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.validate();
			
			// PASSAGE DE PANEL FIN - CONNECTION RECRUTEUR A L ACCUEIL /
			panFin.boutonRetour.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					FenetrePrincipale f = new FenetrePrincipale();
					f.show();
				}
			});
		}

		// Passage du panFormulaire ou panAccueil aux panels ajout modif et
		// supprimer question

		if (arg0.getSource() == this.panFormulaire.itemAjoutQuestion
				|| arg0.getSource() == this.panAccueil.itemAjoutQuestion)

		{
			panAjouterQuestion = new panelAjouterQuestion();

			this.panAjouterQuestion.itemAjoutQuestion.addActionListener(this);
			this.panAjouterQuestion.itemModifierQuestion.addActionListener(this);
			this.panAjouterQuestion.itemSupprimerQuestion.addActionListener(this);
			this.panAjouterQuestion.itemNouveauCandidat.addActionListener(this);
			this.panAjouterQuestion.itemCandidatExistant.addActionListener(this);

			// A verifier
			this.panAccueil.itemAjoutQuestion.addActionListener(this);
			this.panAccueil.itemModifierQuestion.addActionListener(this);
			this.panAccueil.itemSupprimerQuestion.addActionListener(this);
			this.panAccueil.itemNouveauCandidat.addActionListener(this);
			this.panAccueil.itemCandidatExistant.addActionListener(this);

			System.out.println("ici");
			this.getContentPane().removeAll();
			this.setContentPane(panAjouterQuestion);
			this.validate();
		}
		if (arg0.getSource() == this.panFormulaire.itemModifierQuestion
				|| arg0.getSource() == this.panAccueil.itemModifierQuestion) {
			panModifierQuestion = new panelModifierQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panModifierQuestion);
			this.validate();
		}
		if (arg0.getSource() == this.panFormulaire.itemSupprimerQuestion
				|| arg0.getSource() == this.panAccueil.itemSupprimerQuestion) {
			panSupprimerQuestion = new panelSupprimerQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panSupprimerQuestion);
			this.validate();
		}

		// Passage du panAjouterQuestion aux autres panels
		if (arg0.getSource() == this.panAccueil.itemRechercher)

		{
			RechercherCandidat rechercher = new RechercherCandidat();
			this.getContentPane().removeAll();
			this.setContentPane(rechercher);
			this.validate();
		}

		if (arg0.getSource() == this.panAccueil.itemAjoutQuestion) {
			panAjouterQuestion = new panelAjouterQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panAjouterQuestion);
			this.validate();
		}

		if (arg0.getSource() == this.panAccueil.itemModifierQuestion) {
			panModifierQuestion = new panelModifierQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panModifierQuestion);
			this.validate();
		}

		if (arg0.getSource() == this.panAccueil.itemStatistique)

		{
			paneStatistique = new PanelStatistique();
			this.getContentPane().removeAll();
			this.setContentPane(paneStatistique);
			this.validate();
		}
		if (arg0.getSource() == this.panAccueil.itemSupprimerQuestion) {
			panSupprimerQuestion = new panelSupprimerQuestion();
			this.getContentPane().removeAll();
			this.setContentPane(panSupprimerQuestion);
			this.validate();
		}

	}

	// /**
	// * Les actions � mener sur notre panel Accueil, charg� initialement
	// */
	// //Quitter l'appli
	// if((arg0.getSource() == this.panAccueil.itemQuitter) || (arg0.getSource()
	// == this.panFormulaire.itemQuitter))
	// {
	// // a voir, message erreur dans console
	// this.dispose();
	// }
	// // Affichage de l'aide
	// if(arg0.getSource() == this.panAccueil.itemAide)
	// {
	// JOptionPane.showMessageDialog(null, "Cette interface n'est pas d�velopp�e
	// - en attente de l'�quipe Projet");
	// }

	/**
	 * Rechargement d'un formulaire depuis un panel Formulaire
	 */

	// =============================================== Fonctions cr��es
	// initialement par David, non utilis�es pour l'instant, mais elles sont
	// peut-�tre poas l� pour rien
	// =====================================================
	/**
	 * Constructeur non utilis� sous la version 1.00 � 1.xx
	 * 
	 * @deprecated Depuis v1.00, remplac� par FenetrePrincipale() throws
	 *             HeadlessException
	 */
	public FenetrePrincipale(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	

	

	/**
	 * Constructeur non utilis� sous la version 1.00 � 1.xx
	 * 
	 * @deprecated Depuis v1.00, remplac� par FenetrePrincipale() throws
	 *             HeadlessException
	 */
	public FenetrePrincipale(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur non utilis� sous la version 1.00 � 1.xx
	 * 
	 * @deprecated Depuis v1.00, remplac� par FenetrePrincipale() throws
	 *             HeadlessException
	 */
	public FenetrePrincipale(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
}
