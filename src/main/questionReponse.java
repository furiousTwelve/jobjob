package main;

import java.util.Random;

/**
 * 
 * @author Alban
 * @author Cyril
 * @version 1.00
 * 

 * 
 */

public class questionReponse 
{
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
	 */
	
	String categorieQuestion;
	byte numeroQuestion;
	boolean reponseCorrecteOuIncorrecte;
	int timerAuMomentDeLaReponse; // En secondes pour le moment
	private questionReponse[] questionsCandidat;
	
	public questionReponse(String cq)
	{
		this.categorieQuestion = cq;
	}
	
	public questionReponse()
	{
		
	}
	
	public void genererQuestionsCandidat()
	{
		
		// le Random actuelle fonctionne sur 15 questions aléatoires. A modifier lorsqu'il y a aura BDD présentes en faisant une focntion qui questionne la BDD pour
		// lui demander combien de question sont présentes pour ce type recherché
		
		questionsCandidat = new questionReponse[15];
		byte valeurGeneree;
		boolean trouve = false;
		Random r = new Random();
		questionReponse question;
		
		
		
		// GENERE LES QUESTIONS 1 A 5
		int i = 0;
		while(i < 5)
		{
			question = new questionReponse("CG");
			trouve = false;
			// ici il y a peut etre 30 questions au lieu de 15
			valeurGeneree = (byte) (r.nextInt(14) + 1);
			
			for(int j = 0; j < i; j++)
			{
				if(valeurGeneree == questionsCandidat[j].numeroQuestion)
				{
					trouve = true;
				}
			}
			
			if(trouve == false)
			{
				question.numeroQuestion = valeurGeneree;
				questionsCandidat[i] = question;
				i++;
			}
		}
		
		// GENERE LES QUESTIONS 6 A 10
		while(i < 10)
		{
			question = new questionReponse("CJ");
			trouve = false;
			valeurGeneree = (byte) (r.nextInt(14) + 1);
			
			for(int j = 0; j < i; j++)
			{
				if(valeurGeneree == questionsCandidat[j].numeroQuestion)
				{
					trouve = true;
				}
			}
			
			if(trouve == false)
			{
				question.numeroQuestion = valeurGeneree;
				questionsCandidat[i] = question;
				i++;
			}
		}
		
		// VA CHERCHER LA QUESTION STRESS - QUESTION 11
		question = new questionReponse("S");
		question.numeroQuestion = 1;
		questionsCandidat[i] = question;
		i++;
		
		// GENERE LES QUESTIONS 12 A 14
		valeurGeneree = (byte) (r.nextInt(11));
		String[] tableauLangagesExotiques = {"DELPHI", "PERL", "FORTRAN", "ADA", "PASCAL", "SMALLTALK", "TCLTK", "LISP", "VISUALBASIC", "SQUIRREL", "COBOL", "EIFFEL"};
		String langage = tableauLangagesExotiques[valeurGeneree];
		
		int compteurTemp=1;
		while(i < 14)
		{
			
			String cat = "LE" + tableauLangagesExotiques[valeurGeneree];
			question = new questionReponse(cat);
			questionsCandidat[i] = question;
			questionsCandidat[i].numeroQuestion=(byte)compteurTemp;
			compteurTemp++;
			i++;
		}
		
		// GENERE LA QUESTION 15	
		while(i < 15)
		{
			question = new questionReponse("CG");
			trouve = false;
			valeurGeneree = (byte) (r.nextInt(14) + 1);
			
			for(int j = 0; j < i; j++)
			{
				if(valeurGeneree == questionsCandidat[j].numeroQuestion)
				{
					trouve = true;
				}
			}
			
			if(trouve == false)
			{
				question.numeroQuestion = valeurGeneree;
				questionsCandidat[i] = question;
				i++;
			}
		}
		
		// Fonctions test -- à effacer par la suite
		affichageTableauGenere(questionsCandidat,15);		
		chercherQuestionRéponse(0);		
	}
	
	/**
	 *  Cette fonction est appelé à partir de panelQuestion.java
	 * @param numQuestion paramètre initialiser lors de l'appel de la fonction
	 */
	public void chercherQuestionRéponse(int numQuestion)
	{
		numQuestion=0;   // Pour test
		
		String codeQuestion;	
			
		codeQuestion=questionsCandidat[numQuestion].categorieQuestion+questionsCandidat[numQuestion].numeroQuestion;		
		System.out.println("code:" +codeQuestion );
		
		
		// ici mettre la fonction qui demande à la couche données les questions générés aléatoirement
		// exemple: String <structure> = chercherQuestionBDD(codeQuestion);	
	}
	
	//fonction tests sur console
	public void affichageTableauGenere(questionReponse[] tab, int l)
	{
		for(int i = 0; i < l; i++)
		{
			System.out.println("Categorie "+tab[i].categorieQuestion+" n° question:"+tab[i].numeroQuestion);
		
		}
	}
	
}
