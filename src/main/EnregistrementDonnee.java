package main;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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
	
	public void rechercheCandidat(String str){
		boolean trouver=false;
		
		File dossier = new File("C:\\Users\\34011-82-04\\git\\recrutement");
		String[] contenu = dossier.list();
		int i=0;
		while(trouver==false & i<contenu.length){
			if(contenu[i].equals(str)){
				trouver=true;
			}
			i++;
		}
	if(trouver==true){
			System.out.println(" fichier existe :");
			String pathFichier="C:\\Users\\34011-82-04\\git\\recrutement\\"+str;


			BufferedReader fluxEntree=null;
			try {
				/* Création du flux vers le fichier texte */
				fluxEntree = new BufferedReader(new FileReader(pathFichier));

				/* Lecture d'une ligne */
				String ligneLue = fluxEntree.readLine();

				while(ligneLue!=null){
					System.out.println(ligneLue);
					ligneLue = fluxEntree.readLine();
				}
			}
			catch(IOException exc){
				exc.printStackTrace();
			}
			finally{
				try{
					if(fluxEntree!=null){
						/* Fermeture du flux vers le fichier */
						fluxEntree.close();
					}
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
	}
	else {
		System.out.println(" Candidat non trouvé!");
	}
  }
}