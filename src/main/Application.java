
package main;


import java.awt.HeadlessException;
import java.text.ParseException;

import main.donnees.ConnectionDB;
import main.metier.questionReponse;
import main.presentation.FenetrePrincipale;

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
		
				
				new Application();
						

	}
}
