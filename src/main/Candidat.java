package main;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Alban, Audric
 * @version 1.00
 */

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
	public Candidat(){}
	
	public Candidat(JPanel p)
	{
		// RECUPERATION DES CONTROLES DU PANEL DE SAISI
		Component[] fields = p.getComponents();
		
		// CONSTRUCTION DU CANDIDAT AVEC LES DONNEES SAISIES
		this.nom = ((JTextField) fields[1]).getText();
		this.prenom = ((JTextField) fields[3]).getText();
		this.mail = ((JTextField) fields[5]).getText();
		this.numeroTelephone = ((JTextField) fields[7]).getText();
		this.identifiant = this.numeroCandidat();
	}
	
	
	/**
	 * METHODE QUI CONCATENE LES LABELS ET LES SAISIES DU RECRUTEUR PUIS COMMUNIQUE LES DONNEES FORMATEES A LA COUCHE DONNEE.
	 * @param p : on passe en paramètre le panel contenant les zones saisient par le recruteur
	 */
	public void enregistrerNouveauCandidat(JPanel p)
	{
		String[] chaine = new String[p.getComponents().length/2];
		int i = 0;
		Component[] fields = p.getComponents();
		
		for(Component f : fields)
		{
			if(f instanceof JLabel)
			{
				chaine[i] = ((JLabel) f).getText() + " : ";
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
		ed.candidat(chaine); // en attente modification par la couche données
	}
	
	//Concaténation de la date et d'un numéro à 4 chiffres pour l'identifiant candidat
	public String numeroCandidat()
	{
		DateFormat format = new SimpleDateFormat("yy_MM_dd");
		String date = format.format(new Date());
		EnregistrementDonnee ed = new EnregistrementDonnee();
		int numero = ed.nombreCandidat()+1;
		String numeroconcat = Integer.toString(numero);
		if (numero<10){
			numeroconcat="000"+numeroconcat;
		}
		else if (numero<100){
			numeroconcat="00"+numeroconcat;
		}
		else if (numero<1000) {
			numeroconcat="0"+numeroconcat;
		}
		
		return date + "_"+numeroconcat;
	}
	
}
