
package main.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * D�finit un panel qui sera imbriqu� dans la fen�tre principale
 * @deprecated
 * @author david
 *
 */
public class Panneau extends JPanel 
{
	/**
	 * peinture d'un composant
	 */
	public void paintComponent(Graphics g) 
	{
		int x1 = this.getWidth()/4;
		int y1 = this.getHeight()/4;
		//g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
		g.drawOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
		g.drawRect(10, 10, 30, 50);
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString("Job Job! ", 10, 20);
		
	}

}
