/**
 * 
 */
package main;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

		this.setTitle("Job-Job"); 
		this.setSize(600, 400);

		this.setResizable(false);

		this.setLocationRelativeTo(null);
		
		this.setContentPane(new panelFormulaire());; // imbrication de notre panel dans notre fenêtre
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}

	
}
