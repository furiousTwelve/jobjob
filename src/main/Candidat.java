package main;

import java.awt.Component;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Candidat 
{
	/**
	 * ATTRIBUTS DE CANDIDAT
	 */
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String numeroTelephone;
	protected String identifiant;
	
	/**
	 * CONSTRUCTEUR
	 * @param n : nom du candidat
	 * @param p : prénom du candidat
	 * @param m : adresse mail du candidat
	 * @param num : numéro de téléphone du candidat
	 * @param ident : identifiant du candidat
	 */
	public Candidat(JPanel p)
	{
		// RECUPERATION DES CONTROLES DU PANEL DE SAISI
		Component[] fields = p.getComponents();
		
		// CONSTRUCTION DU CANDIDAT AVEC LES DONNEES SAISIES
		this.nom = ((JTextField) fields[1]).getText();
		this.prenom = ((JTextField) fields[3]).getText();
		this.mail = ((JTextField) fields[5]).getText();
		this.numeroTelephone = ((JTextField) fields[7]).getText();
		this.identifiant = ((JTextField) fields[9]).getText();
	}
	
	
	/**
	 * METHODE QUI CONCATENE LES LABELS ET LES SAISIES DU RECRUTEUR PUIS COMMUNIQUE LES DONNEES FORMATEES A LA COUCHE DONNEE.
	 * @param p : on passe en paramètre le panel contenant les zones saisient par le recruteur
	 */
	public void enregistrerNouveauCandidat(JPanel p)
	{
		String[] chaine = new String[p.getComponents().length];
		int i = 0;
		Component[] fields = p.getComponents();
		
		for(Component f : fields)
		{
			if(f instanceof JLabel)
			{
				chaine[i] = ((JLabel) f).getText() + ": ";
			}
			else if(f instanceof JTextField)
			{
				chaine[i] = chaine[i] + ((JTextField) f).getText();
				System.out.println(chaine[i]);
				i++;
			}
		}
		
		// COMMUNIQUE AVEC LA COUCHE DONNEES POUR L'ENREGISTREMENT SUR LE FICHIER
		EnregistrementDonnee ed = new EnregistrementDonnee();
		//ed.enregistrementCandidat(chaine); // en attente modification par la couche données
	}
	
}
