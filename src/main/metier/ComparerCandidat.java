package main.metier;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
	
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 * 
 * @author khadidja
 *
 */
// cette méthode marche parfaitement, sauf qu'elle affiche le graphe de  4 candidats maximum, alors que le client veut obligatoirement afficher 10 candidats!
//reste a récupérer les données de la base de données et les intégrer dans la méthode :)

	public class ComparerCandidat extends JFrame { 
		public JPanel chartPanel ;
		    public ComparerCandidat() {
		        super("comparer les résultats de deux candidats");
		 System.out.println("comparer...");
		 
		 		chartPanel= createChartPanel();
		        this.add(chartPanel, BorderLayout.CENTER);
		        setSize(800, 200);
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setLocationRelativeTo(null);
		     //   this.setVisible(TRE);
		    }
		 
		  public  JPanel createChartPanel() {
		    	    String titre = "Comparaison des résultats";
		    	    String titre_x = "Catégories";
		    	    String titre_y = "Score";
		  
		    	    XYDataset dataset = createDataset();
		    	    JFreeChart chart = ChartFactory.createXYLineChart(titre, titre_x, titre_y, dataset);
		    	    return new ChartPanel(chart);
		    	}
		  
		    protected XYDataset createDataset() {
		    	XYSeriesCollection dataset = new XYSeriesCollection();
		        XYSeries candidat1 = new XYSeries("Candidat1");
		        XYSeries candidat2 = new XYSeries("Candidat2");
		        XYSeries candidat3 = new XYSeries("Candidat3");
		        XYSeries candidat4 = new XYSeries("Candidat4");
		      //  XYSeries candidat5 = new XYSeries("Candidat2");
		        
		        
		   // candidat(categorie, score)
		        candidat1.add(1, 9.0);
		        candidat1.add(2, 4.5);
		        candidat1.add(3,3.5);
		        candidat1.add(4, 10);
		       
		        candidat2.add(1.0, 1.0);
		        candidat2.add(2, 2.4);
		        candidat2.add(3, 1.2);
		        candidat2.add(4, 2.8);
		        
		        candidat3.add(1, 3.0);
		        candidat3.add(2, 7);
		        candidat3.add(3, 8.2);
		        candidat3.add(4, 1.8);
		       
		        candidat4.add(1, 6.3);
		        candidat4.add(2, 9.8);
		        candidat4.add(3, 3.2);
		        candidat4.add(4, 1.5);
		        
		        
		       // candidat5.add(8, 7.5);
		        
		        dataset.addSeries(candidat1);
		        dataset.addSeries(candidat2);
		        dataset.addSeries(candidat3);
		        dataset.addSeries(candidat4);
		      //  dataset.addSeries(candidat5);
		        return dataset;
		    }
		   
	// pour le test
/*	public static void main(String[] args) {
		  SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new ComparerCandidat().setVisible(true);
	            }
	        });
	    }*/
	}
