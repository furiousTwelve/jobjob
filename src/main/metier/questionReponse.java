package main.metier;

import java.sql.SQLException;
import java.util.Random;

import main.donnees.ConnectionDB;
import main.donnees.EnregistrementDonnee;

/**
 * Structure utilisée pour générer le tableau contenant les questions auquelles le candidat devra répondre
 * 
 * categorieQuestion - La catégorie de la question qui peut être :
 * 							"CJ" pour Culture Java 
 * 							"CG" pour Culture Générale Informatique
 * 							"LE" pour Langage Exotique
 * 							"S" pour Stress
 * 					
 * numeroQuestion - Le numéro que la question a dans le panel de questions
 * 
 * reponseCorrecte - La réponse correcte à la question
 * 
 * reponseCandidat - La réponse du candidat
 * 
 * timerAuMomentDeLaReponse - On récupère le timer au moment où le candidat répond à la question	
 * 	
 * @author Alban
 * @author Cyril
 * @author Benjamin
 * @version 1.00
 * 
 * 
 */

public class questionReponse 
{
	public byte categorieQuestion;
//	public byte numQuestion;
	public int  numQuestionBDD;
	public String libelleQuestion;
	public String libelleReponse1; 
	public String libelleReponse2; 
	public String libelleReponse3; 
	public String libelleReponse4; 
	public String bonneReponse;
	public byte reponseCandidat;
	
	public questionReponse[] questionsCandidat;
	
	public String[] tableauReponsesChoisiesParCandidat = new String[15];
	public int[] scoreParReponseCandidat = new int[15];
	
	
	public questionReponse()
	{
		//Remplissage d'un tableauReponsesChoisiesParCandidat par défaut:
		//@Author Mathieu
		for (int i = 0; i < 15; i++) {
			tableauReponsesChoisiesParCandidat[i] = "";
		}
	}


	/**
	 * @author Cyril
	 *  Cette fonction est appelé lorsque le candidat appuie sur "START" sur le "panelCandidat"
	 *  Elle a pour but d'envoyer un tableau de 15 instances de QuestionRéponse à la couche Données pour qu'il puisse la remplir les libéllés des questions et réponses associés
	 * @param questionsCandidat est un tableau de 15 instances de QuestionRéponse
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */


	public questionReponse[] chercherQuestionRéponse(questionReponse[] questionsCandidat) throws SQLException, ClassNotFoundException

	{		
		ConnectionDB laConnection = new ConnectionDB();	
		questionsCandidat = laConnection.chercherQuestionEnBase(questionsCandidat);		
		return questionsCandidat;
	}
	
	
	//recupération de la réponse du candidat
	/**
	 * Méthode remplissant dans notre objet QuestionReponse le tableauReponsesChoisiesParCandidat.
	 * Elle est appelée à chaque validation d'une réponse par le candidat
	 * @Mathieu
	 * @param byte reponse
	 * @param int compteur
	 * @param String reponseChoisie
	 */
	public void recupereReponse(byte reponse,int compteur, String reponseChoisie)
	{
		System.out.println("Question : "+compteur);
		System.out.println("Reponse : "+reponse);
		System.out.println("Texte Reponse : " + reponseChoisie);
		
		tableauReponsesChoisiesParCandidat[compteur-1] = reponseChoisie;
	}
	
	/**
	 * Méthode qui va remplir le tableau scoreParReponseCandidat. 
	 * C'est un tableau de 15 int qui, pour chaque réponse affectera 0 ou 1 point au candidat.
	 * 0 point si mauvaise réponse, 1 point si bonne réponse.
	 * 
	 * On peut facilement faire entrer en jeu le barème de notre Qcm, inséré dans la BDD, en utilisant les fonctions .obtenirScore* (une fois qu'elles seront implémentées
	 * 
	 * @author 34011-82-06 Mathieu
	 * @return void
	 */
	public void genererTableauScoreCandidat() {

//		GestionDonnees gestion = new GestionDonnees();
		
		for (int i = 0; i < 15; i++) {
			if(tableauReponsesChoisiesParCandidat[i].equals(questionsCandidat[i].bonneReponse)) {
//				scoreParReponseCandidat[i] = gestion.obtenirScoreBonneReponse();
				scoreParReponseCandidat[i] = 1;
			}
			if(tableauReponsesChoisiesParCandidat[i].equals(questionsCandidat[i].bonneReponse) == false) {
//				scoreParReponseCandidat[i] = gestion.obtenirScoreMauvaiseReponse();
				scoreParReponseCandidat[i] = 0;
			}
		}
		
		System.out.println("Tableau des scores du candidat :");
		for (int i = 0; i < 15; i++) {
			System.out.print(scoreParReponseCandidat[i] + ", ");
		}
	}
	
	
	
	//recuperation du temps lors de la réponse du candidat
	public void recupereTimerCandidat(int Timer){
		
		
	}
}
