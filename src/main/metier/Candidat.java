package main.metier;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	 * CONSTRUCTEUR G�n�rique
	 */
	public Candidat(){}
	
	/**
	 * Constructeur prenant en argument un JPanel 
	 * @param p JPanel 
	 */
	public Candidat(JPanel p)
	{
		// RECUPERATION DES CONTROLES DU PANEL DE SAISIE
		Component[] fields = p.getComponents();
		
		// CONSTRUCTION DU CANDIDAT AVEC LES DONNEES SAISIES
		this.nom = ((JTextField) fields[1]).getText();
		this.prenom = ((JTextField) fields[3]).getText();
		this.mail = ((JTextField) fields[5]).getText();
		this.numeroTelephone = ((JTextField) fields[7]).getText();
		this.identifiant = this.definirNumeroCandidat();
	}
	
	
	/**
	 * METHODE QUI CONCATENE LES LABELS ET LES SAISIES DU RECRUTEUR PUIS COMMUNIQUE LES DONNEES FORMATEES A LA COUCHE DONNEE.
	 * @param p : on passe en param�tre le panel contenant les zones saisies par le recruteur
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
		ed.enregistrerCandidat(chaine); // en attente modification par la couche donn�es
	}
	
	//Concat�nation de la date et d'un num�ro � 4 chiffres pour l'identifiant candidat
	public String definirNumeroCandidat()
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
