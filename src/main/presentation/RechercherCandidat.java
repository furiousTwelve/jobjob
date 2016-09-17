package main.presentation;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RechercherCandidat extends JPanel implements ActionListener {
	protected JPanel panelG;
	protected JPanel panel;
	protected JTextField textField;
	protected JPanel panelResult;
	protected BorderLayout b;
	protected JTable table = new JTable();

	public RechercherCandidat() {

		// panelG.setLayout(b);
		panel = new JPanel();
		// panel.setBounds(100, 100, 450, 300);
		panel.setLayout(null);

		JComboBox liste = new JComboBox();
		liste.addItem(" Nom du candidat");
		liste.addItem(" Date de test");
		liste.addItem(" Numero de téléphone");
		liste.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

			}
		});
		liste.setBounds(277, 52, 130, 20);
		panel.add(liste);

		JLabel choix = new JLabel("Choisissez un critère de recherche");
		choix.setBounds(36, 54, 229, 16);
		panel.add(choix);

		JLabel info = new JLabel("Entrer l'information");
		info.setBounds(114, 105, 151, 16);
		panel.add(info);

		textField = new JTextField();
		textField.setBounds(277, 102, 130, 22);
		panel.add(textField);
		textField.setColumns(10);

		Button valider = new Button("Valider");
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == valider) {

				}
			}

		});
		valider.setBounds(301, 159, 79, 24);
		panel.add(valider);
		// panelResult.setLayout(b);
		Object[] colonne = { " Nom du candidat", "Prénom du candidat", "Numero de télephone", "Date de test",
				"Score/15" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(colonne);
		table.setModel(model);
		// table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		Font font = new Font("Times New roman", 1, 14);
		table.setFont(font);
		table.setRowHeight(30);

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 0, 880, 200);
		pane.setBackground(Color.WHITE);
		panelResult.add(pane, BorderLayout.CENTER);
		panelG.add(panel);
		panel.add(panelResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
