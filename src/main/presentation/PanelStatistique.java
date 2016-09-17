package main.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.metier.ComparerCandidat;
import main.metier.Statistiques;

/**
 * 
 * @author khadidja
 *
 */
public class PanelStatistique extends JPanel {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuTest = new JMenu("Nouveau test");
	private JMenu menuCandidat = new JMenu("Candidats");
	private JMenu menuQuiz = new JMenu("Quiz");
	private JMenu menuAide = new JMenu("Aide");

	protected JMenu itemNouveauTest = new JMenu("Nouveau Test");
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

	protected JButton graphe = new JButton(" Afficher graphe");
	protected JRadioButton trie_score = new JRadioButton("Trie par score");
	protected JPanel panel = new JPanel();
	protected JLabel titre = new JLabel("Résultats des 10 derniers candidats");
	protected JRadioButton trie_date = new JRadioButton("Trie par date");
	protected BorderLayout b = new BorderLayout();
	protected JPanel panel_centre = new JPanel();
	protected JPanel panelG = new JPanel();
	protected JTable table = new JTable();
	JOptionPane jop1;

	public PanelStatistique() {
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

		menuCandidat.add(itemRechercher);
		menuCandidat.add(itemSupprimer);
		menuCandidat.add(itemModifier);
		menuCandidat.add(itemStatistique);

		menuQuiz.add(itemAjoutQuestion);
		menuQuiz.add(itemModifierQuestion);
		menuQuiz.add(itemSupprimerQuestion);

		menuAide.add(itemAide);

		Statistiques st = new Statistiques();
		ComparerCandidat cc = new ComparerCandidat();

		// panel général
		panelG.setLayout(b);
		panelG.setBackground(Color.WHITE);

		// panel d'entete
		panel.add(titre);
		panel.add(trie_score);
		panel.add(trie_date);
		panelG.add(menuBar, BorderLayout.NORTH);
		panelG.add(panel, BorderLayout.NORTH);

		// Jtable qui va récupérer le résultat de la requete SELECT * FROM
		// candiat.....

		Object[] colonne = { " Nom du candidat", "Prénom du candidat", "Date de test", " Score adaptabilité",
				"Score culture générale", "Score Stress", "Score Technique" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colonne);
		table.setModel(model);
		// table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		Font font = new Font("Times New roman", 1, 14);
		table.setFont(font);
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 900, 400);
		// pane.setBackground(Color.WHITE);
		panel_centre.add(pane);

		panelG.add(panel_centre, BorderLayout.CENTER);

		JPanel panel_bas = new JPanel();
		JButton graphe = new JButton("Afficher Graphe");
		Object[] row = new Object[7];
		graphe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				row[0] = " Nom candidat";
				row[1] = " prenom du candidat";
				row[2] = " date de test";
				row[3] = " 4";
				row[4] = " 3";
				row[5] = " 1 ";
				row[6] = " 7";

				model.addRow(row);
				// st.DessinerBar();
				boolean selected = false;
				while (selected == false) {
					int i = table.getSelectedRow();
					if (i < 0) {
						// Boîte du message préventif
						jop1 = new JOptionPane();
						jop1.showMessageDialog(null, "Merci de choisissez un candidat dans la liste", "Attention",
								JOptionPane.WARNING_MESSAGE);

					} else {
						st.DessinerCam();
						new ComparerCandidat();

					}
					selected = true;
				}
			}
		});

		panel_bas.add(graphe);
		// cette méthode supprime un candidat de la liste, reste a ajpouter la
		// requete de suppression, a voir avec la couche données
		JButton supprimer = new JButton("Supprimer Candidat");
		supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = table.getSelectedRow();
				if (i >= 0) {

					model.removeRow(i);
				} else {
					jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "Merci de choisir le candidat à supprimer!", "Attention",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		panel_bas.add(supprimer);
		// comparer candidats
		JButton comparer_candidat = new JButton("Comparer les résultats");
		panel_bas.add(comparer_candidat);
		comparer_candidat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jop1 = new JOptionPane();
				jop1.showMessageDialog(null, "Merci de choisir deux candidats dans la liste!", "Attention",
						JOptionPane.WARNING_MESSAGE);
				new ComparerCandidat();
			}
		});

		panelG.add(panel_bas, BorderLayout.SOUTH);
		this.add(panelG);

		JButton acceuil = new JButton("Acceuil");
		acceuil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jop1 = new JOptionPane();
				jop1.showMessageDialog(null,
						"ce boutton  nous emmene au panneau d'acceuil, MAIS IL FAUT FERMER LE FENETRE ACTUELLE!",
						"Attention", JOptionPane.WARNING_MESSAGE);
				panelAccueil pane=new panelAccueil();
				FenetrePrincipale f = new FenetrePrincipale();
				f.getContentPane().removeAll();
				f.setContentPane(pane);
				f.validate();
				
				
				f.show();

			}

		});
		panel_bas.add(acceuil);
	}
}
