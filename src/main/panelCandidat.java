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
	private ImageIcon logo;

	public panelCandidat() 
	{
		
		panel1 = new JPanel(null);
		
		iconeEntreprise = new JLabel(new ImageIcon("logoAFPA.png"));		
		panel1.setLayout(new FlowLayout());
		
	
		
		panel1.add(iconeEntreprise);	
		this.add(panel1);
		
	}
	
	
	

}
