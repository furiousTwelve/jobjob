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
	public int bonneReponse;
	public byte reponseCandidat;
	
	public questionReponse[] questionsCandidat;
	

	
	public questionReponse()
	{
		
	}



	/**
	 * @author Cyril
	 *  Cette fonction est appelé lorsque le candidat appuie sur "START" sur le "panelCandidat"
	 *  Elle a pour but d'envoyer un tableau de 15 instances de QuestionRéponse à la couche Données pour qu'il puisse la remplir les libéllés des questions et réponses associés
	 * @param questionsCandidat est un tableau de 15 instances de QuestionRéponse
	 * @throws SQLException 
	 * 
	 */


	public questionReponse[] chercherQuestionRéponse(questionReponse[] questionsCandidat) throws SQLException

	{		
		ConnectionDB laConnection = new ConnectionDB();	
		questionsCandidat = laConnection.chercherQuestionEnBase(questionsCandidat);		
		return questionsCandidat;
	}
	
	
	//recupération de la réponse du candidat
	public void recupereReponse(byte reponse,int compteur)
	{
		System.out.println("Question : "+compteur);
		System.out.println("Reponse : "+reponse);
		
		
//		EnregistrementDonnee ed = new EnregistrementDonnee();
//		ed.enregistrerReponse(reponse,compteur); // enregistrement de la reponse donneepar l'utilisateur correspondant à la question n° compteur
		
		// comparer réponse avec réponse correcte
		
		// envoyer résultat à la DONNEE avec comme paramétre: index_table de la question,numero question, et réponse correcte ou pas.

	}
	
	
	
	//recuperation du temps lors de la réponse du candidat
	public void recupereTimerCandidat(int Timer){
		
		
	}
}
