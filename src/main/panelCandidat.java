package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 
 * @author Cyril
 * @version v1.00
 * 
 */

public class panelCandidat extends JPanel  {
	
	protected JPanel panel1;	
	protected JLabel iconeEntreprise;
	protected ImageIcon logo;

	public panelCandidat() 
	{		
		panel1= new JPanel();
		iconeEntreprise = new JLabel(new ImageIcon("logoAFPA.png"));	
		this.setLayout(new BorderLayout());		
		panel1.setLayout(new BorderLayout());
		
		panel1.add(iconeEntreprise,BorderLayout.NORTH);	
		
		this.add(panel1,BorderLayout.WEST);		
	}
	
	
	

}
