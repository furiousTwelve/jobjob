package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.IIOException;
/**
 * 
 * @author Damien El Sabbagh
 * @author Khadidja Boudjema
 * @version 0.1
 *
 */

public class EnregistrementDonnee{

/**
 * Méthode pour l'enregistrement du nom de l'entreprise dans un fichier .txt
 * @param nom
 */
	
	public void entreprise(){
		
		File f = new File ("entreprise.txt");
		
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("JobJob recrutement");
			fw.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
/**
 * Methode pour l'enregistrement d'un candidat dans un fichier .txt
 * @param nom
 * @param prenom
 * @param mail
 * @param telephone
 * @param identifiant
 */
	public void candidat(String nom,String prenom,String mail,String telephone,int identifiant,String date){
		
		File f = new File ("candidat_"+identifiant+".txt");
		
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("Nom : "+nom);
			fw.write("\r\n");
			fw.write("Prenom : "+prenom);
			fw.write("\r\n");
			fw.write("Email : "+mail);
			fw.write("\r\n");
			fw.write("Téléphone : "+telephone);
			fw.write("\r\n");
			fw.write("Identifiant : "+identifiant);
			fw.write("\r\n");
			fw.write("Date : "+date);
			fw.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	

}
