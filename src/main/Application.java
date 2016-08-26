
package main;


import java.awt.HeadlessException;
import java.text.ParseException;

import javax.swing.UIManager;

/**
 * 
 * Cette classe gère le main et le lancement de l'interface graphique
 * 
 * @author Khadidja Boudjema
 * @author Benjamin Champetier
 * @author Lionel Chiavo
 * @author Damien El Sabbagh
 * @author Anaïs Gueyte
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
	 * @param args arguments passés en paramères lors du lancement de l'application
	 * @throws ParseException 
	 * @throws HeadlessException 
	 */
	public static void main(String[] args) throws HeadlessException, ParseException 
	{
		
		//String[] info = {"talbi", "lila", "fefeefef@sfr.fr", "0645644884", "22/08/2016"};
		String[] donnee = {"nom : paul" , "prenome jojo" , "mail : affreuxjojo@mail.com" , "tel : 05060311"};
		new Application();
	//	new EnregistrementDonnee().creerFichier("candidat_1Score");
	//    new EnregistrementDonnee().enregistrerCandidat(info);
	//	new EnregistrementDonnee().chercherQuestion( "CG2");
	//	new EnregistrementDonnee().nombreCandidat();
		
		//new EnregistrementDonnee().rechercheCandidat("candidat_7.txt");
		new EnregistrementDonnee().enregistrerScore("candidat_7", 18);                           
		System.out.println("-------------------------------------------------------------");

		new EnregistrementDonnee().enregistrerCandidat(donnee);

	}
}
