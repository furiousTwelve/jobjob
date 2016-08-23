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
	
	int identifiant=1;
	
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
	
	public void candidat(String nom,String prenom,String mail,String telephone,String date){
		

		File f = new File ("candidat_"+getidentifiant()+".txt");
		
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("Identifiant :" +getidentifiant());
			fw.write("\r\n");
			fw.write("Nom : "+nom);
			fw.write("\r\n");
			fw.write("Prenom : "+prenom);
			fw.write("\r\n");
			fw.write("Email : "+mail);
			fw.write("\r\n");
			fw.write("Téléphone : "+telephone);
			fw.write("\r\n");
			fw.write("Date de naissance : "+date);
			fw.close();
			identifiant=identifiant+1;
			//System.out.println(identifiant);
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
	
	public int getidentifiant(){
		return identifiant;
		
		
	}
	
	

}
