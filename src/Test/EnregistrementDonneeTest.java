
package Test;


import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;

import main.EnregistrementDonnee;

public class EnregistrementDonneeTest {
	int indice;
	 EnregistrementDonnee mc=new  EnregistrementDonnee();
	@Test
	public void testEntreprise() {
		
		System.out.println(" TEST DE LA METHODE DE CREATION DES FICHIERS ");
		mc.entreprise("fichierTest");
		boolean trouver=false;
		
		String str="fichierTest.txt";
		File dossier = new File("..\\..\\git\\recrutement");
		String[] contenu = dossier.list();
		 System.out.println(Arrays.toString(contenu));
		int i=0;
		while(trouver==false & i<contenu.length){
			if(contenu[i].equals(str)){
				trouver=true;
				indice=i;
			}
			i++;
		}
		assertTrue(trouver==true);
		System.out.println(" ------------------------------------------------");
			System.out.println(" le fichier a été bien créé, se trouve dans la position " + indice);
		    System.out.println(Arrays.toString(contenu));
		    System.out.println(" -------------------------------------------------------------");
		}
	
	@Test
	public void testCandidat() {
	
		String phrase=" ";
	   	EnregistrementDonnee test = new EnregistrementDonnee();
	   	String[] info = {"Nom : talbi","Prenom : lila","Email : fefeefef@sfr.fr","Téléphone : 0645644884","N° identifiant : 12" ,"Date : 22/08/2016/null/"};
	   	test.candidat(info);
			
		String resultatAttendu = " Nom : talbi/Prenom : lila/Email : fefeefef@sfr.fr/Téléphone : 0645644884/N° identifiant : 12/Date : 22/08/2016/null//Date : 250816/null/" ;
			
			/* Le chemin vers le fichier à lire */
			String pathFichier="..\\..\\git\\recrutement\\candidats\\candidat_13.txt";

			BufferedReader fluxEntree=null;
			try {
				/* Création du flux vers le fichier texte */
				fluxEntree = new BufferedReader(new FileReader(pathFichier));

				/* Lecture d'une ligne */
				String ligneLue = fluxEntree.readLine();

				while(ligneLue!=null){
					ligneLue = fluxEntree.readLine();
					char c='/';
					 phrase= phrase+ligneLue + c;
					
				}
				System.out.println(" TEST DE LA METHODE DE RECUPERATION DES DONNES DES  CANDIDATS ");
				System.out.println(" ----------------------------------------------------------------------- ");
				System.out.println(" résultat obtenu est :" +phrase);
				System.out.println(" ------------------------------------------------------------------------");
				System.out.println(" résultat attendu est :" +resultatAttendu);
				System.out.println(" ------------------------------------------------------------------------");
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
			assertEquals(resultatAttendu, phrase);
			System.out.println(" test positif!");
			System.out.println(" ------------------------------------------------");
		}

	@Test
	
	public void testnombreCandidat() {
		System.out.println(" Test de la méthode nombreCandidat");
		System.out.println(" ------------------------------------------------");
		assertTrue(mc.nombreCandidat()==13);
		//System.out.println(" mon identifiant ets bien 5!");
	}

	@Test
	/**
	 * Dans cette méthode, le test doit me renvoie un true! pour vérifier que ma méthode rechercheCandidat fait correctement sa recherche dans le dossier recrutement
	 */
	public void testRechercheCandidat(){
		mc.rechercheCandidat("candidat_2.txt");
	
		boolean existe=false;
		File dossier = new File("C:\\Users\\34011-82-04\\git\\recrutement\\candidats");
		String[] contenu = dossier.list();
		int i=0;
		while(existe==false & i<contenu.length){
			if(contenu[i].equals("candidat_2.txt")){
				existe=true;
			}
			i++;
		}
		assertTrue(existe==true);
		System.out.println(" ------------------------------------------------");
		System.out.println(" TEST RECHERCHER CANDIDAT ");
		System.out.println(" TEST POSITIF ");
		System.out.println(" ------------------------------------------------");
		}
	
	/**
	 * test de la méthode rechercheQuestion
	 */
	@Test
	public void testchercherQuestion() {
	    String resultatObtenu="";
	 	
	 	String resultat[] =mc.chercherQuestion("CG2");
	 	for (int i=0;i<resultat.length; i++){
	 	 resultatObtenu=resultatObtenu+resultat[i]+",";
	 	}
	    String resultatAttendu="JE SUIS QUESTION 2  CULTURE GENERALE,je reponse 1 de la question 2,je reponse 2 de la question 2,je reponse3 de la question 2,je reponse4 de la question 2,";
	    System.out.println("resultat attendu : " +resultatAttendu);
	 	System.out.println("resultat obtenu  : "+ resultatObtenu);
	    assertTrue(resultatObtenu.equals(resultatAttendu));
	 	
	 		
	 			
	} 			
	 			
}

