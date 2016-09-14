package main.metier;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Arrays;
import java.util.Calendar;

import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.donnees.ConnectionDB;
import main.donnees.EnregistrementDonnee;

/**
 * Couche METIER
 * @author Alban, Audric
 * @version 1.00
 * 
 * @author Cyril, Benjamin
 * @version 1.01
 * 
 * @author Florent
 * @version 1.02
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
	
	String[] chaine;
	/**
	 * CONSTRUCTEUR
	 */
	public Candidat(){}
	
	public Candidat(JPanel p)
	{
		// RECUPERATION DES CONTROLES DU PANEL DE SAISIE
		// CONSTRUCTION DU CANDIDAT AVEC LES DONNEES SAISIES
		Component[] fields = p.getComponents();
		chaine = new String[5];
		int i = 0;
		for(Component f : fields){
			 if(f instanceof JTextField && i < chaine.length )
				{
					chaine[i] = ((JTextField) f).getText();
					System.out.println(chaine[i]);
					i++;
				}
		}
	}
	
	
	/**
	 * METHODE QUI COMMUNIQUE LES DONNEES FORMATEES A LA COUCHE DONNEE.
	 * @throws ClassNotFoundException 
	 * @throws NumberFormatException 
	 */
	public void enregistrerNouveauCandidat() throws ClassNotFoundException 
	{
		//TODO : la méthode n'appelle pas (plus) la bonne méthode 
		ConnectionDB cdb = new ConnectionDB();
		cdb.enregistrerNouveauCandidatEnBase(chaine[4], chaine[0], chaine[1], chaine[3], chaine[2]);
		
	}
	
	//Concaténation de la date et d'un numéro à 4 chiffres pour l'identifiant candidat
	//TODO : ceci n'est pas une javadoc
	public String definirNumeroCandidat()
	{
		DateFormat format = new SimpleDateFormat("yy_MM_dd");
		String date = format.format(new Date());
		ConnectionDB ed = new ConnectionDB();
		int numero = ed.nombreCandidat();
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
