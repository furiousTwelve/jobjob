/************************
 * The MIT License (MIT)

Copyright © 2016 Khadidja Boudjema, Benjamin Champetier, Lionel Chiavo, Damien El Sabbagh, Anaïs Gueyte, Audric Lespagnol, Alban Martinez, Cyril Mathieu, Marc Naouache, Mathieu Peyramard, Emmanuel Piat, Florent Valadier, David di Marcantonio
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */
package main;

import javax.swing.UIManager;

/**
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
	 * 
	 */
	public Application() 
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * Main de l'application 
	 * @param args arguments passés en paramères lors du lancement de l'application
	 */
	public static void main(String[] args) 
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); //le Look and feel peut avoir plusieurs types d'apparence
		}
		catch(Exception e) 
		{
			
		}
		new Application();
	}

}
