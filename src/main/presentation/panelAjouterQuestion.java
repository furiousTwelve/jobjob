package main.presentation;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Audric
 * 
 */


public class panelAjouterQuestion extends JPanel implements ActionListener {
	
	//Déclaration des éléments de la barre de Menu
		private JMenuBar menuBar = new JMenuBar();
		private JMenu menuFichier = new JMenu("Fichier");
		private JMenu menuQuiz = new JMenu("Quiz");
		private JMenu menuAide = new JMenu("Aide");
		protected JMenu itemNouveauTest= new JMenu("Nouveau Test");
		protected JMenuItem itemCandidatExistant = new JMenuItem("Candidat Existant");
		protected JMenuItem itemNouveauCandidat = new JMenuItem("Nouveau Candidat");
		protected JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
		protected JMenuItem itemQuitter = new JMenuItem("Quitter");
		protected JMenuItem itemAide = new JMenuItem("Aide");
		protected JMenuItem itemAjoutQuestion = new JMenuItem("Ajouter une question/réponses");
		protected JMenuItem itemModifierQuestion = new JMenuItem("Modifier une question/réponses");
		protected JMenuItem itemSupprimerQuestion = new JMenuItem("Supprimer une question/réponses");
		
		/**
		 * Constructeur du panelAjouterQuestion
		 * 
		 */
		public panelAjouterQuestion() {
			
			//Constitution de la barre de menu, qui ira au Nord
			menuBar.add(menuFichier);
			menuBar.add(menuQuiz);
			menuBar.add(menuAide);
			
			menuFichier.add(itemNouveauTest);
			itemNouveauTest.add(itemCandidatExistant);
			itemNouveauTest.add(itemNouveauCandidat);
			menuFichier.add(itemSauvegarder);
			itemSauvegarder.setEnabled(false);
			menuFichier.addSeparator();
			menuFichier.add(itemQuitter);
			
			menuQuiz.add(itemAjoutQuestion);
			menuQuiz.add(itemModifierQuestion);
			menuQuiz.add(itemSupprimerQuestion);
			
			menuAide.add(itemAide);
					
			this.itemQuitter.addActionListener(this);	
			this.itemAide.addActionListener(this);	
			
			//Création du panelCentral
			JPanel panelCentral = new JPanel();
			panelCentral.setLayout(new BorderLayout());
			
			JPanel panelLabel = new JPanel();
			panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.PAGE_AXIS));
			
			JPanel panelText = new JPanel();
			panelText.setLayout(new BoxLayout(panelText, BoxLayout.PAGE_AXIS));
			
			
			JLabel intitule = new JLabel("Intitulé");
			JLabel lien = new JLabel("Lien Image");
			JLabel propo1 = new JLabel("Proposition 1");
			JLabel propo2 = new JLabel("Proposition 2");
			JLabel propo3 = new JLabel("Proposition 3");
			JLabel propo4 = new JLabel("Proposition 4");
			JLabel reponse = new JLabel("Réponse Correcte");
			
			panelLabel.add(intitule);
			panelLabel.add(lien);
			panelLabel.add(propo1);
			panelLabel.add(propo2);
			panelLabel.add(propo3);
			panelLabel.add(propo4);
			panelLabel.add(reponse);
			
			JTextField intitulebis = new JTextField();
			JTextField lienbis = new JTextField();
			JTextField propo1bis = new JTextField();
			JTextField propo2bis = new JTextField();
			JTextField propo3bis = new JTextField();
			JTextField propo4bis = new JTextField();
			JComboBox reponsebis = new JComboBox();
			
			panelText.add(intitulebis);
			panelText.add(lienbis);
			panelText.add(propo1bis);
			panelText.add(propo2bis);
			panelText.add(propo3bis);
			panelText.add(propo4bis);
			panelText.add(reponsebis);
			
			panelCentral.add(panelLabel, BorderLayout.WEST);
			panelCentral.add(panelText);
			
			//Constitution du panel général
			this.setLayout(new BorderLayout());
			this.add(panelCentral,BorderLayout.CENTER);
			this.add(menuBar, BorderLayout.NORTH);
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
