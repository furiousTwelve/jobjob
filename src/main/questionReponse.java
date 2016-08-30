package main;

import java.util.Random;

/**
 * 
 * @author Alban
 * @version 1.00
 */

public class questionReponse 
{
	/**
	 * Structure utilisée pour générer le tableau contenant les questions auquelles le candidat devra répondre
	 * 
	 * categorieQuestion - La catégorie de la question qui peut être :
	 * 							"CJ" pour Culture Java 
	 * 							"CG" pour Culture Générale Informatique
	 * 							"E" pour Langage Exotique
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
	
	public void genererQuestionsCandidat()
	{
		
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
		int v = 5;
		while(v < 10)
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
				questionsCandidat[v] = question;
				v++;
			}
		}
		
		// VA CHERCHER LA QUESTION STRESS - QUESTION 11
		question = new questionReponse("S");
		question.numeroQuestion = 1;
		questionsCandidat[10] = question;
		
		// GENERE LES QUESTIONS 12 A 14
		int p = 11;
		valeurGeneree = (byte) (r.nextInt(11));
		String[] tableauLangagesExotiques = {"DELPHI", "PERL", "FORTRAN", "ADA", "PASCAL", "SMALLTALK", "TCLTK", "LISP", "VISUALBASIC", "SQUIRREL", "COBOL", "EIFFEL"};
		String langage = tableauLangagesExotiques[valeurGeneree];
		
		
		while(p < 14)
		{
			String cat = "LE" + tableauLangagesExotiques[valeurGeneree];
			question = new questionReponse(cat);
			questionsCandidat[p] = question;
			p++;
		}
		
		// GENERE LA QUESTION 15
		i = 14;
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
		
		affichageTableauGenere(questionsCandidat,15);
	}
	
	public void affichageTableauGenere(questionReponse[] tab, int l)
	{
		for(int i = 0; i < l; i++)
		{
			System.out.println("Numero question:"+tab[i].numeroQuestion);
		}
	}
	
}
