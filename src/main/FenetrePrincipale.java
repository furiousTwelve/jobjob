/**
 * 
 */
package main;


import java.awt.Dimension;
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
	private panelAccueil panAccueil;
	private panelFormulaire panFormulaire;

	/**
	 * @throws HeadlessException
	 */

	public FenetrePrincipale() throws HeadlessException 
	{

		this.setTitle("Job-Job"); 
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(600, 400));
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		
		panAccueil=new panelAccueil();
		panFormulaire = new panelFormulaire();
		
		this.panAccueil.itemNouveauTest.addActionListener(this);
		this.panAccueil.itemQuitter.addActionListener(this);
		this.panAccueil.itemAide.addActionListener(this);
		
		this.setContentPane(panAccueil);; // imbrication de notre panel dans notre fenêtre
		

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
	//	panAccueil = new panelAccueil();
		
		
		if(arg0.getSource() == this.panAccueil.itemNouveauTest)
		{	
			panFormulaire.itemNouveauTest.addActionListener(this);	
			panFormulaire.itemSauvegarder.addActionListener(this);			
			panFormulaire.itemQuitter.addActionListener(this);	
			panFormulaire.itemAide.addActionListener(this);	
			panFormulaire.boutonSave.addActionListener(this);
			
			this.getContentPane().removeAll();
			this.setContentPane(panFormulaire);
			this.validate();
			
		}
		
		if((arg0.getSource() == this.panAccueil.itemQuitter) || (arg0.getSource() == this.panFormulaire.itemQuitter))
		{	
			// a voir, message erreur dans console
			this.dispose();
		
		}
		
		if((arg0.getSource() == this.panAccueil.itemAide) || (arg0.getSource() == this.panFormulaire.itemAide))
		{	
			JOptionPane.showMessageDialog(null, "Cette interface n'est pas développée - en attente de l'équipe Projet");
			/*try {
				Runtime.getRuntime().exec("C:/Users/34011-82-07/git/recrutement/help_job-job.docx");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
			
		
		
		
		if(arg0.getSource() == this.panFormulaire.itemNouveauTest)
		{	
			// Ici mettre l'ouverture du panelQuestion
			
		}
		
		if(arg0.getSource() == this.panFormulaire.itemSauvegarder)
		{	
			
		//Pour la couche métier: mettre votre fonction "ecrire fichier"
		}
		
		if(arg0.getSource() == this.panFormulaire.boutonSave)
		{	
			
			JOptionPane.showMessageDialog(null, "Lancement de l'interface start");
			
		}
		
				
		
	}

	
}
