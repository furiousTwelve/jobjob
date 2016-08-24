package main;

import java.awt.BorderLayout;

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
	
	protected JPanel panel1=panel1 = new JPanel();
	
	protected JLabel iconeEntreprise;
	private ImageIcon logo;

	public panelCandidat() 
	{
		
		
		
		iconeEntreprise = new JLabel(new ImageIcon("logoAFPA.png"));	
		panel1.setLayout(new BorderLayout());
		
	
		
		panel1.add(iconeEntreprise,BorderLayout.EAST);	
		this.add(panel1);
		
	}
	


}
