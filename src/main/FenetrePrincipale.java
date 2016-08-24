/**
 * 
 */
package main;


import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Définit la fenêtre principale de l'application
 * @author david
 *
 */

public class FenetrePrincipale extends JFrame implements ActionListener
{
	private panelAccueil pan1;
	private panelFormulaire pan2;

	/**
	 * @throws HeadlessException
	 */

	public FenetrePrincipale() throws HeadlessException 
	{

		this.setTitle("Job-Job"); 
		this.setSize(600, 400);

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		pan1 = new panelAccueil();       //pan1 ?? manque d'inspiration? 
		pan2 = new panelFormulaire();  //pan2 ?? toujours pas d'inspiration? 
		// est ce qu'à pan9 on commence à faire des jeux de mots? 
		
		this.pan1.item1.addActionListener(this);
		this.pan1.item3.addActionListener(this);
		this.pan1.item4.addActionListener(this);
		
		this.setContentPane(pan1);; // imbrication de notre panel dans notre fenêtre
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}

	/**
	 * @param gc
	 */
	public FenetrePrincipale(GraphicsConfiguration gc) {
		super(gc);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public FenetrePrincipale(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param gc
	 */
	public FenetrePrincipale(String title, GraphicsConfiguration gc) {
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String composant=arg0.getActionCommand();
	//	pan1 = new panelAccueil();
		
		
		if(arg0.getSource() == this.pan1.item1)
		{	
			pan2.item1.addActionListener(this);	
			pan2.item2.addActionListener(this);			
			pan2.item3.addActionListener(this);	
			pan2.item4.addActionListener(this);	
			pan2.boutonSave.addActionListener(this);
			
			this.getContentPane().removeAll();
			this.setContentPane(pan2);
			this.validate();
			
		}
		
		if((arg0.getSource() == this.pan1.item3) || (arg0.getSource() == this.pan2.item3))
		{	
			// a voir, message erreur dans console
			this.dispose();
		
		}
		
		if((arg0.getSource() == this.pan1.item4) || (arg0.getSource() == this.pan2.item4))
		{	
			JOptionPane.showMessageDialog(null, "Cette interface n'est pas développée - en attente de l'équipe Projet");
			/*try {
				Runtime.getRuntime().exec("C:/Users/34011-82-07/git/recrutement/help_job-job.docx");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
			
		
		
		
		if(arg0.getSource() == this.pan2.item1)
		{	
			// Ici mettre l'ouverture du panelQuestion
			
		}
		
		if(arg0.getSource() == this.pan2.item2)
		{	
			
		//Pour la couche métier: mettre votre fonction "ecrire fichier"
		}
		
		if(arg0.getSource() == this.pan2.boutonSave)
		{	
			
			JOptionPane.showMessageDialog(null, "Lancement de l'interface start");
			
		}
		
				
		
	}

	
}
