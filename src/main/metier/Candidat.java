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

import main.donnees.EnregistrementDonnee;

/**
 * Couche METIER
 * @author Alban, Audric
 * @version 1.00
 * 
 * @author Cyril, Benjamin
 * @khadidja, Damien, Florent
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
	 * CONSTRUCTEUR Générique
	 */
	public Candidat(){}
	
	/**
	 * Constructeur prenant en argument un JPanel 
	 * @param p JPanel 
	 */
	public Candidat(JPanel p)
	{
		// RECUPERATION DES CONTROLES DU PANEL DE SAISIE
		// CONSTRUCTION DU CANDIDAT AVEC LES DONNEES SAISIES
		Component[] fields = p.getComponents();
		chaine = new String[5];
		int i = 0;
		for(Component f : fields){
			 if(f instanceof JTextField && i < chaine.length-1 )
				{
					chaine[i] = ((JTextField) f).getText();
					System.out.println(chaine[i]);
					i++;
				}
		}

		chaine[chaine.length-1] = this.definirNumeroCandidat();
	}
	
	
	/**
	 * METHODE QUI COMMUNIQUE LES DONNEES FORMATEES A LA COUCHE DONNEE.
	 */
	public void enregistrerNouveauCandidat()
	{

		// COMMUNIQUE AVEC LA COUCHE DONNEES POUR L'ENREGISTREMENT SUR LE FICHIER
		EnregistrementDonnee ed = new EnregistrementDonnee();
		ed.enregistrerCandidat(chaine); 
		
	}
	
	//Concaténation de la date et d'un numéro à 4 chiffres pour l'identifiant candidat
	public String definirNumeroCandidat()
	{
		DateFormat format = new SimpleDateFormat("yy_MM_dd");
		String date = format.format(new Date());
		EnregistrementDonnee ed = new EnregistrementDonnee();
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
