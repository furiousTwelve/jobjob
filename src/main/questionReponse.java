package main;

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
	
	byte categorieQuestion;
	byte numeroQuestion;
	boolean reponseCorrecteOuIncorrecte;
	int timerAuMomentDeLaReponse; // En secondes pour le moment
	
	
	
}
