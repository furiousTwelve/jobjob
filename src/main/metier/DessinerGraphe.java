/**
 * 
 */
package main.metier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
//import javax.swing.JDialog;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author khadidja
 *
 */
public class DessinerGraphe extends JFrame  implements ActionListener{
	protected JFrame frame;
	protected JPanel panel= new JPanel();
	protected JPanel panel2=new JPanel();
	protected JButton dessiner=new JButton("Dessiner graphe");
	
	public DessinerGraphe() {
		init();
	}
	
	private void init() {
		
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setSize(350,450);
		panel.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		//panel.setLayout(null);
		
		dessiner.setBounds(147, 373, 127, 25);
		dessiner.addActionListener(this);
		panel.add(dessiner);
		
		
		panel2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel2.setBounds(12, 13, 408, 331);
		panel.add(panel2);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	    {
		if(e.getSource()==dessiner ){
		
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		dataset.addValue(2, "score", "CG");
		dataset.addValue(5, "score", "TJ");
		dataset.addValue(2, "score", "LE");
		dataset.addValue(2, "score", "QS");
		 JFreeChart chart=ChartFactory.createBarChart(null, null, null, dataset,PlotOrientation.VERTICAL, false, true, false);
		
		 CategoryPlot p= chart.getCategoryPlot();
		 p.setRangeGridlinePaint(Color.BLACK);
		 ChartFrame frame=new ChartFrame("statistique test", chart);
		
		 frame.setVisible(true);
		 frame.setSize(300,250);
	    }
	    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 DessinerGraphe fenetre =new  DessinerGraphe();
		 fenetre.setVisible(true);
	}

	
	
}