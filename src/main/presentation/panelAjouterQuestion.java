package main.presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	
		private Font font;
		
		/**
		 * Constructeur du panelAjouterQuestion
		 * 
		 */
		public panelAjouterQuestion() {
			
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
			
			this.add(menuBar, BorderLayout.NORTH);
			
			font = new Font("Arial",Font.ITALIC,17);
			
			JPanel pan = new JPanel();
			pan.setLayout(new FlowLayout());
			
			JPanel jp = new JPanel();
			JLabel titre = new JLabel("Ajouter Question");
			titre.setFont(font);
			jp.add(titre);
			
			JPanel panelLabel = new JPanel();
			panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
			
			
			JLabel jl = new JLabel("Intitulé");
			jl.setFont(font);
			JLabel jl1 = new JLabel("Catégorie");
			jl1.setFont(font);
			JLabel jl2 = new JLabel("Lien Image");
			jl2.setFont(font);
			JLabel jl3 = new JLabel("Proposition 1");
			jl3.setFont(font);
			JLabel jl4 = new JLabel("Proposition 2");
			jl4.setFont(font);
			JLabel jl5 = new JLabel("Proposition 3");
			jl5.setFont(font);
			JLabel jl6 = new JLabel("Proposition 4");
			jl6.setFont(font);
			JLabel jl7 = new JLabel("Réponse Correcte");
			jl7.setFont(font);
			panelLabel.add(jl);
			panelLabel.add(jl1);
			panelLabel.add(jl2);
			panelLabel.add(jl3);
			panelLabel.add(jl4);
			panelLabel.add(jl5);
			panelLabel.add(jl6);
			panelLabel.add(jl7);
			
			pan.add(panelLabel);
			
			JPanel panelText = new JPanel();
			panelText.setLayout(new BoxLayout(panelText, BoxLayout.Y_AXIS));
			
			JTextField jtf = new JTextField ();
			jtf.setColumns(50);
			JComboBox jcb = new JComboBox();
			jcb.addItem("Catégorie");
			JTextField jtf2 = new JTextField ();
			jtf2.setColumns(50);
			JTextField jtf3 = new JTextField ();
			jtf3.setColumns(50);
			JTextField jtf4 = new JTextField ();
			jtf4.setColumns(50);
			JTextField jtf5 = new JTextField ();
			jtf5.setColumns(50);
			JTextField jtf6 = new JTextField ();
			jtf6.setColumns(50);
			JComboBox jcb1 = new JComboBox();
			jcb1.addItem("Proposition 1");
			jcb1.addItem("Proposition 2");
			jcb1.addItem("Proposition 3");
			jcb1.addItem("Proposition 4");
			panelText.add(jtf);
			panelText.add(jcb);
			panelText.add(jtf2);
			panelText.add(jtf3);
			panelText.add(jtf4);
			panelText.add(jtf5);
			panelText.add(jtf6);
			panelText.add(jcb1);
			
			pan.add(panelText);
			
			JPanel panBouton = new JPanel();
			JButton creer = new JButton("Créer");
			panBouton.add(creer);
			
			JPanel panelCentral = new JPanel();
			panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
			panelCentral.add(jp);
			panelCentral.add(pan);
			JLabel espace = new JLabel(" ");
			panelCentral.add(espace);
			panelCentral.add(panBouton);
			
			JPanel panel = new JPanel();
			panel.add(panelCentral);
			
			this.setLayout(new BorderLayout());
			this.add(panel);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
			
	
}
