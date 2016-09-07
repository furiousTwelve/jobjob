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
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.CategoryPlot;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.DefaultCategoryDataset;
//import org.jfree.data.general.DefaultPieDataset;

/**
 * @author khadidja
 *
 */



/*Pour exécuter cette méthode, vous devez télécharger la bibliotheque JFREECHART (aller sur le site Jfreechart/download/ décompressez le/aller sur eclips/window/
 *preference/user librairies/ouvrez lz fichier décompressé jfreechart/lib/selectionner le tous/apply/ok!
 *la fenetre rechercher candidats, n'est pas encore faite par la couche présentation, cette méthode va etre appelée une fois que le recruteur choisisse un candidat pour analyser ses résultats.
 *on peut procéder comme suit : une fois que le recruteur choisisse n candidat, une fenetre s'ouvre avec les coordonnées de ce dernier, ses scores pour les 4 catégories/ on peut ajouter un boutton
 *afficher/dessiner graphe, une fois que le recruteur clique, on appelle la methode DessinerGraphe*/


public class DessinerGraphe extends JFrame {
	
	private void DessinerBar() {
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
	
	private void DessinerCam() {
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
	
	public static void main(String[] args) {
		 DessinerGraphe fenetre =new  DessinerGraphe();
		 fenetre.DessinerBar();
		 fenetre.DessinerCam();
		
	}

}
	
