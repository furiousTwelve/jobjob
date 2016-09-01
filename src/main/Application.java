
package main;


import java.awt.HeadlessException;
import java.text.ParseException;

import main.donnees.ConnectionDB;
import main.metier.questionReponse;
import main.presentation.FenetrePrincipale;

/**
 * 
 * Cette classe g�re le main et le lancement de l'interface graphique
 * 
 * @author Khadidja Boudjema
 * @author Benjamin Champetier
 * @author Lionel Chiavo
 * @author Damien El Sabbagh
 * @author Ana�s Gueyte
 * @author Audric Lespagnol
 * @author Alban Martinez
 * @author Cyril Mathieu
 * @author Marc Naouache
 * @author Mathieu Peyramard
 * @author Emmanuel Piat
 * @author Florent Valadier
 * @author david di Marcantonio
 * 
 * @version 0.1
 *
 */
public class Application 
{

	/**
	 * Constructeur
	 * @throws ParseException 
	 * @throws HeadlessException 
	 * 
	 */
	public Application() throws HeadlessException, ParseException 
	{
		FenetrePrincipale fenetre = new FenetrePrincipale();
	}

	/**
	 * Main de l'application 
	 * @param args arguments pass�s en param�res lors du lancement de l'application
	 * @throws ParseException 
	 * @throws HeadlessException 
	 */
	public static void main(String[] args) throws HeadlessException, ParseException 
	{
		
		//String[] info = {"talbi", "lila", "fefeefef@sfr.fr", "0645644884", "22/08/2016"};
		String[] donnee = {"nom : paul" , "prenome jojo" , "mail : affreuxjojo@mail.com" , "tel : 05060311"};
		
//		System.out.println("Test METIER");
//		questionReponse test = new questionReponse();
//		test.genererQuestionsCandidat();
//	
		
	//	connection DB
		ConnectionDB cdb = new ConnectionDB();
		try {
			cdb.connectionBase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// test ajout candidat en base
		try {
			cdb.enregistrerNouveauCandidatEnBase(15, "chial", "lionel", "0612458796", "lione@gmail.com");
			System.out.println("Requete ex�cut�e");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		new Application();
	
		

	}
}
