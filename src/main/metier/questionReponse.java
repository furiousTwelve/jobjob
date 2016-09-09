package main.metier;

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
	String categorieQuestion;
	public byte numQuestion;
	public byte numQuestionBDD;
	public String libelleQuestion;
	public String libelleReponse1; 
	public String libelleReponse2; 
	public String libelleReponse3; 
	public String libelleReponse4; 
	
	public questionReponse[] questionsCandidat;
	

	
	public questionReponse()
	{
		
	}
	
//	public void genererQuestionsCandidat() throws ClassNotFoundException
//	{		
//		questionsCandidat = new questionReponse[15];
//		byte valeurGeneree;
//		boolean trouve = false;
//		Random r = new Random();
//		questionReponse question;
//		
//		
//		// ====>       ici ecrire une fonction (DONNEES) pourqu'ils retournent le nombre d'éléments d'une catégorie
//		// ====>  exemple int nbreQuestion=demanderNbreQuestion(catégorie);
//		
//		// ligne qui suit POUR TEST - à effacer quand la fonction données sera terminée
//		int nbreQuestion=15;
//		
//		// GENERE LES QUESTIONS 1 A 5
//		int i = 0;
//		while(i < 5)
//		{
//			question = new questionReponse("CG");
//			trouve = false;
//			// ici il y a peut etre 30 questions au lieu de 15
//			valeurGeneree = (byte) (r.nextInt(nbreQuestion-1) + 1);
//			
//			for(int j = 0; j < i; j++)
//			{
//				if(valeurGeneree == questionsCandidat[j].numQuestion)
//				{
//					trouve = true;
//				}
//			}
//			
//			if(trouve == false)
//			{
//				question.numQuestion = valeurGeneree;
//				questionsCandidat[i] = question;
//				i++;
//			}
//		}
//		
//		// GENERE LES QUESTIONS 6 A 10
//		while(i < 10)
//		{
//			question = new questionReponse("CJ");
//			trouve = false;
//			valeurGeneree = (byte) (r.nextInt(nbreQuestion-1) + 1);
//			
//			for(int j = 0; j < i; j++)
//			{
//				if(valeurGeneree == questionsCandidat[j].numQuestion)
//				{
//					
//					trouve = true;
//				}
//			}
//			
//			if(trouve == false)
//			{
//				question.numQuestion = valeurGeneree;
//				questionsCandidat[i] = question;
//				i++;
//			}
//		}
//		
//		// VA CHERCHER LA QUESTION STRESS - QUESTION 11
//		question = new questionReponse("S");
//		question.numQuestion = 1;
//		questionsCandidat[i] = question;
//		i++;
//		
//		// GENERE LES QUESTIONS 12 A 14
//		valeurGeneree = (byte) (r.nextInt(11));
//		String[] tableauLangagesExotiques = {"DELPHI", "PERL", "FORTRAN", "ADA", "PASCAL", "SMALLTALK", "TCLTK", "LISP", "VISUALBASIC", "SQUIRREL", "COBOL", "EIFFEL"};
////		String langage = tableauLangagesExotiques[valeurGeneree];
//		
//		int compteurTemp=1;
//		while(i < 14)
//		{
//			
//			String cat = "LE" + tableauLangagesExotiques[valeurGeneree];
//			question = new questionReponse(cat);
//			questionsCandidat[i] = question;
//			questionsCandidat[i].numQuestion=(byte)compteurTemp;
//			compteurTemp++;
//			i++;
//		}
//		
//		// GENERE LA QUESTION 15	
//		while(i < 15)
//		{
//			question = new questionReponse("CG");
//			trouve = false;
//			valeurGeneree = (byte) (r.nextInt(nbreQuestion-1) + 1);
//			
//			for(int j = 0; j < i; j++)
//			{
//				if(valeurGeneree == questionsCandidat[j].numQuestion)
//				{
//					trouve = true;
//				}
//			}
//			
//			if(trouve == false)
//			{
//				question.numQuestion = valeurGeneree;
//				questionsCandidat[i] = question;
//				i++;
//			}
//		}
//		
//		chercherQuestionRéponse(questionsCandidat,0);				
//		
//		// Fonctions test -- à effacer par la suite
//		affichageTableauGenere(questionsCandidat,15);		
//		
//	}
	
	/**
	 * @author Cyril
	 *  Cette fonction est appelé lorsque le candidat appuie sur "START" sur le "panelCandidat"
	 *  Elle a pour but d'envoyer un tableau de 15 instances de QuestionRéponse à la couche Données pour qu'il puisse la remplir les libéllés des questions et réponses associés
	 * @param questionsCandidat est un tableau de 15 instances de QuestionRéponse
	 * 
	 */

	public void chercherQuestionRéponse(questionReponse[] questionsCandidat)

	{			
		ConnectionDB laConnection = new ConnectionDB();	
	//	ConnectionDB.chercherQuestionEnBase(questionsCandidat);		
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
