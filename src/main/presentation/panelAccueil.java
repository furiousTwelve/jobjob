package main.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * le panelAccueil sera le panel chargé par la fenêtre Principal par défaut
 * @author Mathieu
 * @author Audric
 *
 */
public class panelAccueil extends JPanel implements ActionListener{

	//Déclaration des éléments de la barre de Menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuTest = new JMenu("Nouveau test");
	private JMenu menuCandidat = new JMenu("Candidats");
	private JMenu menuQuiz = new JMenu("Quiz");
	private JMenu menuAide = new JMenu("Aide");
	

	protected JMenu itemNouveauTest= new JMenu("Nouveau Test");
	protected JMenuItem itemCandidatExistant = new JMenuItem("Candidat Existant");
	protected JMenuItem itemNouveauCandidat = new JMenuItem("Nouveau Candidat");
	protected JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
	protected JMenuItem itemQuitter = new JMenuItem("Quitter");
	
	protected JMenuItem itemRechercher = new JMenuItem("Recherche");
	protected JMenuItem itemSupprimer = new JMenuItem("Suppression");
	protected JMenuItem itemModifier = new JMenuItem("Modification");
    protected JMenuItem itemStatistique = new JMenuItem("Statistique");
	
	protected JMenuItem itemAide = new JMenuItem("Aide");
	
	protected JMenuItem itemAjoutQuestion = new JMenuItem("Ajouter une question/réponses");
	protected JMenuItem itemModifierQuestion = new JMenuItem("Modifier une question/réponses");
	protected JMenuItem itemSupprimerQuestion = new JMenuItem("Supprimer une question/réponses");
	
	
	
	
	/**
	 * Constructeur du panelAccueil
	 * 	<br>Il a un Border Layout contenant:
	 * 	<br>- au Nord, un Menu
	 * 	<br>- au Centre, un autre panel : panelCentral, suivant un BoxLayout
	 * 
	 */
	public panelAccueil() {
		
		//Constitution de la barre de menu, qui ira au Nord
		menuBar.add(menuTest);
		menuBar.add(menuCandidat);
		menuBar.add(menuQuiz);
		menuBar.add(menuAide);
		
		menuTest.add(itemNouveauTest);
		itemNouveauTest.add(itemCandidatExistant);
		itemNouveauTest.add(itemNouveauCandidat);
		menuTest.add(itemSauvegarder);
		itemSauvegarder.setEnabled(false);
		menuTest.addSeparator();
		menuTest.add(itemQuitter);
		
		
		
		
		// ajouter les ActionListener
		
		itemCandidatExistant.addActionListener(this);
		itemNouveauCandidat.addActionListener(this);
		
		menuCandidat.add(itemRechercher);
		menuCandidat.add(itemSupprimer);
		menuCandidat.add(itemModifier);
		menuCandidat.add(itemStatistique);
		
		itemRechercher.addActionListener(this);
		itemSupprimer.addActionListener(this);
		itemModifier.addActionListener(this);
		itemStatistique.addActionListener(this);
		
		itemSauvegarder.addActionListener(this);
		itemQuitter.addActionListener(this);

		
	
		menuQuiz.add(itemAjoutQuestion);
		menuQuiz.add(itemModifierQuestion);
		menuQuiz.add(itemSupprimerQuestion);
		
		itemAjoutQuestion.addActionListener(this);
		itemModifierQuestion.addActionListener(this);
		itemSupprimerQuestion.addActionListener(this);
		
		//Création du panelCentral
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
		
			//création d'un panel qui sera placé en haut du panelCentral : panelTexte
			JPanel panelTexte = new JPanel(new BorderLayout());
		
				//Notre petit texte
				Font fontAccueil = new Font("Courier", Font.BOLD, 30);
				JLabel texte = new JLabel("Job-Job : Test de recrutement", JLabel.CENTER);
				texte.setFont(fontAccueil);
				
			panelTexte.add(texte, BorderLayout.SOUTH);
			
			//création d'un panel qui sera placé en bas du panelCentral : panelImg
			JPanel panelImg = new JPanel(new BorderLayout(50,50));
			
				//Importe l'image principale de l'écran d'accueil, sous forme de JLabel
				JLabel img = new JLabel(new ImageIcon("jobjob.png"));
				
			panelImg.add(img, BorderLayout.NORTH);
			
			
			//Constitution du panelCentral
			panelCentral.add(panelTexte);
			JLabel labelVide = new JLabel(" "); //Peut mieux faire , mais çà marche
			panelCentral.add(labelVide);
			panelCentral.add(panelImg);
		
		

		
		//Constitution du panel général
		this.setLayout(new BorderLayout());
		this.add(panelCentral, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.NORTH);
		
	}

	public void creerFichier() {
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Affichage de l'aide
		if(arg0.getSource() == this.itemAide)
		{	
			JOptionPane.showMessageDialog(null, "Cette interface n'est pas développée - en attente de l'équipe Projet");
		}
		
		//Quitter l'appli
		if(arg0.getSource() == this.itemQuitter)
		{	
			System.exit(0);
		}
		
	}

	
}
