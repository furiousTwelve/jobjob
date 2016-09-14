/**
 * 
 */
package main.metier;

import java.awt.Color;
//import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * @author khadidja
 *
 */

/*cette méthode marche parfaitement, reste a récupérer les 4 scores correspondants à chaque catégorie  */

public class Statistiques extends JFrame {
	
	public void DessinerBar() {
		
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		dataset.addValue(100, "score", "CULTURE GENERALE");
		dataset.addValue(45, "score", "TECHNIQUE JAVA");
		dataset.addValue(75, "score", "LANGAGE EXOTIQUE");
		dataset.addValue(18, "score", "QUESTION STRESS");
		JFreeChart chart=ChartFactory.createBarChart3D(null, null, null, dataset,PlotOrientation.VERTICAL, false, true, false);
				
		 CategoryPlot p= chart.getCategoryPlot();
		 p.setRangeGridlinePaint(Color.BLACK);
		 ChartFrame frame=new ChartFrame("statistique test", chart);
		 frame.setSize(800,500);
		 frame.setVisible(true);
	}
	
	public void DessinerCam() {
		 DefaultPieDataset data=new DefaultPieDataset();
	     data.setValue("Culture Générale 100%",100);
	     data.setValue("Technique Java 27% ",27.9);
	     data.setValue("Langage exotique 45%",45);
	     data.setValue("Question stress 100%",100);
	
		JFreeChart chart=ChartFactory.createPieChart3D(null, data);
		ChartFrame frame=new ChartFrame("statistique test", chart);
		frame.setSize(600,450);
		frame.setVisible(true);
	}
	
//	public static void main(String[] args) {
//		 Statistiques fenetre =new  Statistiques();
//		 fenetre.DessinerBar();
//		 fenetre.DessinerCam();
//		
//	}

}
	
