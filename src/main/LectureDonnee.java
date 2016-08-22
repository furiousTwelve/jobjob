package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Damien El Sabbagh
 * @author Khadidja Boudjema
 * @version 0.1
 *
 */

public class LectureDonnee 
{	
/**
 * Méthode permettant de lire un fichier texte
 * @param identifiant
 */
	public void lireCandidat(int identifiant)
	{
		try 
		{
			File f = new File ("candidat_"+identifiant+".txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			try {
				String line = br.readLine();
				
				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}
				br.close();
				fr.close();
				
			} catch (IOException e) {
				System.out.println("Erreur lors de la lecture: "+e.getMessage());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichier non trouvé");
		}
	}

}
