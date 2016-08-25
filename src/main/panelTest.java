package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class panelTest extends JPanel {

	//Déclaration des éléments de la barre de Menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenu menuAide = new JMenu("Aide");
	protected JMenu itemNouveauTest= new JMenu("Nouveau Test");
	protected JMenuItem itemCandidatExistant = new JMenuItem("Candidat Existant");
	protected JMenuItem itemNouveauCandidat = new JMenuItem("Nouveau Candidat");
	protected JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
	protected JMenuItem itemQuitter = new JMenuItem("Quitter");
	protected JMenuItem itemAide = new JMenuItem("Aide");
	private JLabel statusBar = new JLabel();
	private JMenuBar menuBar2 = new JMenuBar();
	protected JButton boutonSave = new JButton("Sauvegarder");
	protected JButton boutonSave2 = new JButton("Sauvegarder");
	
//	private JLabel logo = new JLabel(new ImageIcon("logoAFPA.png"));
	
	public panelTest() {
		
		 //installer le gestionnaire
		 GridBagLayout g=new GridBagLayout();
		 setLayout(g);
		 //créer un objet de type GridBagConstraints
		 GridBagConstraints c=new GridBagConstraints();
		 //on utilise tout l'espace d'une cellule
		 c.fill=GridBagConstraints.BOTH;
		 c.weightx=1.0;
		 Button peche=new Button("Pêche");
		 add(peche); 
		 g.setConstraints(peche,c);
		 Button poire=new Button("Poire");
		 add(poire); 
		 g.setConstraints(poire, c);
		 //on va terminer la ligne avec ce composant
		 c.gridwidth=GridBagConstraints.REMAINDER; 
		 Button pomme=new Button("Pomme");
		 add(pomme); 
		 g.setConstraints(pomme,c);
		 //réinitialisation
		 c.weightx=0.0; 
		 c.weighty=1.0;
		 c.gridwidth=1;
		 c.gridheight=2; //sur 2 lignes
		 Button prune=new Button("Prune");
		 add(prune); 
		 g.setConstraints(prune,c);
		 //nouvelle réinitialisation
		 c.weighty=0.0; 
		 c.gridwidth=GridBagConstraints.RELATIVE;
		 c.gridheight=1;
		 Button fraise=new Button("Fraise");
		 add(fraise); 
		 g.setConstraints(fraise,c);
		 //on termine la ligne
		 c.gridwidth=GridBagConstraints.REMAINDER;
		 Button cerise=new Button("Cerise");
		 add(cerise); 
		 g.setConstraints(cerise,c);
		 Button ananas=new Button("Ananas");
		 add(ananas); 
		 g.setConstraints(ananas,c);
	}
}
