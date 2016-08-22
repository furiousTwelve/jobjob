/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Définit la fenêtre principale de l'application
 * @author david
 *
 */
public class FenetrePrincipale extends JFrame 
{

	/**
	 * @throws HeadlessException
	 */
	public FenetrePrincipale() throws HeadlessException 
	{
		this.setTitle("Recrutement"); 
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		
		
		this.setContentPane(new panelAccueil()); // imbrication de notre panel dans notre fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}

	/**
	 * @param gc
	 */
	public FenetrePrincipale(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public FenetrePrincipale(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param gc
	 */
	public FenetrePrincipale(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}

}
