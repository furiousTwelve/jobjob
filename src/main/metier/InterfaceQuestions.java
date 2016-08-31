/**
 *Cette interfaceQuestions est aussi traitée par la partie présentation.
 *
*Ici, on précise les variables Score et TempsQ pour enregistrer le score du candidat et le temps de chaque question.
*Les méthodes liées: 
*- calculPoints() des points tout au long du questionnaire
*- calculTemps() enregistrement du temps enregistré pour chaque question

Les résultats de ces données seront utilisées par la couche données afin de les enregistrer dans le fichier final.
 */
package main.metier;

/**
 * @author Audric
 * @author Benjamin
 *
 */
public interface InterfaceQuestions {

	int score = 0;
	int tempsQ = 0;
	
	//Recupération du score du candidat
	public void calculPoints();
	
		static int scoreFinal (){
			
	    return score ;
	}
	
	//Recupération du temps réalisé par le candidat
	public void calculTemps();
	
		static int tempscandidat (){
	    return tempsQ ;
	}
		
}
