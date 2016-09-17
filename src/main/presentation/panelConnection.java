package main.presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class panelConnection extends JPanel {
	
	private JLabel id;
	private JLabel motDePasse;
	protected JTextField recruteur;
	protected JTextField mdp;
	protected JButton boutonConnection;
	protected JButton boutonQuitter;
	private JLabel labelVide1;
	private JLabel labelVide2;
	private JLabel labelVide3;
	private JLabel logoConnection;
	private JLabel labelVide5;
	private JLabel labelVide6;
	private JLabel labelVide7;
	private JLabel labelVide8;
	private Font font;
	private JLabel labelVide4;

	public panelConnection(){
		this.setLayout(new GridLayout(4,4));
		
		font = new Font("Arial",Font.BOLD,15);
		
		JPanel panelRecruteur = new JPanel();
		panelRecruteur.setLayout(new FlowLayout());
		
		JPanel panelLabel = new JPanel();
		panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
		
		id = new JLabel("Identifiant :");
		id.setFont(font);
		panelLabel.add(id);

		motDePasse = new JLabel("Mot de passe :");
		motDePasse.setFont(font);
		panelLabel.add(motDePasse);
		
		panelRecruteur.add(panelLabel);
		
		JPanel panelConnection = new JPanel();
		panelConnection.setLayout(new BoxLayout(panelConnection, BoxLayout.Y_AXIS));
		
		recruteur = new JTextField();
		recruteur.setColumns(10);		
		panelConnection.add(recruteur);
		
		mdp = new JPasswordField();		
		mdp.setColumns(10);
		panelConnection.add(mdp);		
		
		panelRecruteur.add(panelConnection);
		
		boutonConnection = new JButton("Se connecter");
		boutonQuitter = new JButton("Quitter");
//		panelRecruteur.add(boutonConnection);//à repositionner
		JPanel panelboutonConnection = new JPanel();
		panelboutonConnection.add(boutonConnection);
		
		JPanel panelboutonQuitter = new JPanel();
		panelboutonQuitter.add(boutonQuitter);
		
		logoConnection = new JLabel(new ImageIcon("Logo_Afpa.png"));
		JPanel panelLogo = new JPanel();
		panelLogo.setLayout(new FlowLayout());
		panelLogo.add(logoConnection);
		
		
		labelVide1 = new JLabel(" ");
		labelVide2 = new JLabel(" ");
		labelVide3 = new JLabel(" ");
		labelVide4 = new JLabel(" ");
		labelVide5 = new JLabel(" ");
		labelVide6 = new JLabel(" ");
		labelVide7 = new JLabel(" ");
		labelVide8 = new JLabel(" ");
		
	
		this.add(labelVide1);
		this.add(labelVide2);
		this.add(labelVide3);
		this.add(labelVide4);
		this.add(panelRecruteur);
		this.add(labelVide5);
		this.add(labelVide6);
		this.add(panelboutonConnection);
		this.add(panelboutonQuitter);
		this.add(panelLogo, BorderLayout.CENTER);  //@AnaisGueyte - Ajout du logo 
		
		
		
	}
		
}
