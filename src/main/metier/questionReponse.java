package main.metier;

import java.util.Random;

/**
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
	
		
		questionsCandidat = new questionReponse[15];
		byte valeurGeneree;
		boolean trouve = false;
		Random r = new Random();
		questionReponse question;
		
		
		// ====>       ici appel de la fonction (DONNEES) pourqu'il me retourne le nombre d'éléments d'une catégorie
		// ====>  exemple int nbreQuestion=demanderNbreQuestion(catégorie);
		
		// ligne qui suit POUR TEST - à effacer quand la fonction données sera terminée
		int nbreQuestion=15;
		
		// GENERE LES QUESTIONS 1 A 5
		int i = 0;
		while(i < 5)
		{
			question = new questionReponse("CG");
			trouve = false;
			// ici il y a peut etre 30 questions au lieu de 15
			valeurGeneree = (byte) (r.nextInt(nbreQuestion-1) + 1);
			
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
			valeurGeneree = (byte) (r.nextInt(nbreQuestion-1) + 1);
			
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
			valeurGeneree = (byte) (r.nextInt(nbreQuestion-1) + 1);
			
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
		
		
		// ici mettre la fonction qui demande à la couche DONNEES les questions générées aléatoirement avec quetion,4 reponse et index_table de la question
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
	
	//recupération de la réponse du candidat
	public void recupereReponse(byte reponse,int compteur)
	{
		
		System.out.println("Reponse :"+reponse);
		
		// comparer réponse avec réponse correcte
		
		// envoyer résultat à la DONNEE avec comme paramétre: index_table de la question,numero question, et réponse correcte ou pas.

	}
	
	
	
	//recuperation du temps lors de la réponse du candidat
	void recupereTimerCandidat(){
		
	}
}
