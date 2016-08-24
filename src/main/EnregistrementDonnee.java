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

public class EnregistrementDonnee 
{

	int identifiant = 1;
	
	/**
	 * Méthode pour l'enregistrement du nom de l'entreprise dans un fichier .txt
	 * @param nom
	 */
	public void entreprise()
	{
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
 * @param info
 */
	
	public void candidat(String[] info){
		


		File f = new File ("candidat_"+getidentifiant()+".txt");
		
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("Identifiant :" +getidentifiant());
			fw.write("\r\n");

			for (int j = 0; j < info.length; j++) {
				fw.write(info[j]);
				fw.write("\r\n");
			}

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
	
/**
* methode qui cherche le candidat donnée avec son identifiant
* et affiche l'ensemble de ses détails
* @param str
*/
	
	public void rechercheCandidat(String str){
		boolean trouver=false;
		
		File dossier = new File("..\\..\\git\\recrutement");
		String[] contenu = dossier.list();
		int i=0;
		while(trouver == false & i < contenu.length){
			if(contenu[i].equals(str)){
				trouver=true;
			}
			i++;
		}
	if(trouver == true){
			System.out.println("fichier existe :");
			String pathFichier="..\\..\\git\\recrutement\\"+str;


			BufferedReader fluxEntree = null;
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
					if(fluxEntree != null){
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
	
	
	

/**
 * methode chercherQuestion recupère la question rand placer en argument
 * avec les reponses associées à la question.
 * @param rand
 */
	
	public void chercherQuestion( String rand){
		
		File dossier = new File("..\\..\\git\\recrutement\\questionReponse\\");
		String[] contenu = dossier.list();
		String [] questionReponse= new String[5];
		
		int i=0;
		
		String reponse=rand+"R"; 
		
		boolean questionTrouver=false;
		   int j=0;
		   int compteur=4;
		   System.out.println(" Voici les chemins vers les fichiers question et les reponses");
		   while(i<contenu.length & compteur!=0){
			
			     if(contenu[i].equals(rand+".txt")){ 
		      	 questionTrouver=true;
			     String pathFichier="..\\..\\git\\recrutement\\questionReponse\\"+rand+".txt";
			     questionReponse[j]=pathFichier;
			     compteur--;
			     }
			     
			     else if(contenu[i].contains(rand)){
			    	 
			    	 for (int k=1; k<questionReponse.length; k++){
			    		 	String pathFichier="..\\..\\git\\recrutement\\questionReponse\\"+reponse+k+".txt";
						     questionReponse[k]=pathFichier;
						     }
			     }
			     i++;
			    
		   }  
			     for (j=0; j<questionReponse.length; j++){
			     System.out.println( "Path fichier" + j + questionReponse[j] + "\n\t");
			     }
			    
			    BufferedReader fluxEntree=null;
			    
			    for (j=0; j<questionReponse.length; j++){
		 	try {
				//Création du flux vers le fichier texte //
				fluxEntree = new BufferedReader(new FileReader(questionReponse[j]));
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
						// Fermeture du flux vers le fichier //
						fluxEntree.close();
					}
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
			}
	}
			     
			
}
		
}

		
		
		
