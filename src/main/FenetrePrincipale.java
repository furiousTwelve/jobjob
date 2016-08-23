/**
 * 
 */
package main;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Définit la fenêtre principale de l'application
 * @author audric
 *
 */
public class FenetrePrincipale extends JFrame implements ActionListener
{
	
	JLabel jl1 = new JLabel("Nom");
	JLabel jl2 = new JLabel("Prénom");
	JTextField nom = new JTextField();
	JTextField prenom = new JTextField();
	JButton valider = new JButton("Valider");
	
	/**
	 * @throws HeadlessException
	 */
	public FenetrePrincipale() throws HeadlessException 
	{
		this.setTitle("Recrutement"); 
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		
		//Exemple de formulaire
		
		JPanel pan = new JPanel();
		
		pan.setLayout(null);
		
		jl1.setBounds(20, 20, 100, 30);
		
		jl2.setBounds(20, 50, 100, 30);
		
		nom.setBounds(120, 20, 200, 30);
		
		prenom.setBounds(120, 50, 200, 30);
		
		valider.setBounds(100, 100, 80, 30);
		
		valider.addActionListener(this);
		
		pan.add(jl1);
		pan.add(nom);
		pan.add(jl2);
		pan.add(prenom);
		pan.add(valider);
		
		this.setContentPane(pan); // imbrication de notre panel dans notre fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==valider){
			System.out.println("Validation");
			String recupNom = nom.getText();
			String recupPrenom = prenom.getText();
		}
	}
	
}
