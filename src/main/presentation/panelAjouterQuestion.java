package main.presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
			
			JPanel jp = new JPanel();
			jp.setLayout(new BorderLayout());
			JPanel jp2 = new JPanel();
			JPanel jp3 = new JPanel();
			
			BoxLayout bl = new BoxLayout(jp2, BoxLayout.PAGE_AXIS);
			BoxLayout bl1 = new BoxLayout(jp3, BoxLayout.PAGE_AXIS);
			
			JPanel jp4 = new JPanel();
			JComboBox jcb1 = new JComboBox();
			jp4.add(jcb1);
			
			JLabel jl = new JLabel("Intitulé");
			JLabel jl2 = new JLabel("Lien Image");
			JLabel jl3 = new JLabel("Proposition 1");
			JLabel jl4 = new JLabel("Proposition 2");
			JLabel jl5 = new JLabel("Proposition 3");
			JLabel jl6 = new JLabel("Proposition 4");
			JLabel jl7 = new JLabel("Réponse Correcte");
			
			Dimension minSize = new Dimension(5, 50);
			Dimension prefSize = new Dimension(5, 50);
			Dimension maxSize = new Dimension(Short.MAX_VALUE, 50);
			jp2.add(new Box.Filler(minSize, prefSize, maxSize));
			jp2.add(jl);
			jp2.add(new Box.Filler(minSize, prefSize, maxSize));
			jp2.add(jl2);
			jp2.add(new Box.Filler(minSize, prefSize, maxSize));
			jp2.add(jl3);
			jp2.add(new Box.Filler(minSize, prefSize, maxSize));
			jp2.add(jl4);
			jp2.add(new Box.Filler(minSize, prefSize, maxSize));
			jp2.add(jl5);
			jp2.add(new Box.Filler(minSize, prefSize, maxSize));
			jp2.add(jl6);
			jp2.add(new Box.Filler(minSize, prefSize, maxSize));
			jp2.add(jl7);
			
			JTextField jtf = new JTextField ();
			JTextField jtf2 = new JTextField ();
			JTextField jtf3 = new JTextField ();
			JTextField jtf4 = new JTextField ();
			JTextField jtf5 = new JTextField ();
			JTextField jtf6 = new JTextField ();
			JComboBox jcb = new JComboBox();
			jp3.add(jtf);
			jp3.add(jtf2);
			jp3.add(jtf3);
			jp3.add(jtf4);
			jp3.add(jtf5);
			jp3.add(jtf6);
			jp3.add(jcb);
			
			jp2.setLayout(bl);
			jp3.setLayout(bl1);
			
			jp.add(jp4);
			jp.add(jp2, BorderLayout.WEST);
			jp.add(jp3);
			
			this.setLayout(new BorderLayout());
			this.add(jp);
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
