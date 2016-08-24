package main;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;

public class EnregistrementDonneeTest {
	int indice;
	 EnregistrementDonnee mc=new  EnregistrementDonnee();
	@Test
	public void testEntreprise() {
		
		System.out.println(" TEST DE LA METHODE DE CREATION DES FICHIERS ");
		
		boolean trouver=false;
		String str="entreprise.txt";
		
		File dossier = new File("C:\\Users\\34011-82-04\\git\\recrutement");
		String[] contenu = dossier.list();
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
			String nom = "talbi";
			String prenom = "lila";
			String mail = "fefeefef@sfr.fr";
			String telephone = "0645644884";
			String date = "22/08/2016";
			String resultatAttendu = " Nom : talbi/Prenom : lila/Email : fefeefef@sfr.fr/Téléphone : 0645644884/Date de naissance : 22/08/2016/null/" ;
			
			/* Le chemin vers le fichier à lire */
			String pathFichier="C:\\Users\\34011-82-04\\git\\recrutement\\candidat_1.txt";

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
	
	public void testGetidentifiant() {
		System.out.println(" Test de la méthode GetIdentifiant");
		System.out.println(" ------------------------------------------------");
		assertTrue(mc.getidentifiant()==1);
		System.out.println(" mon identifiant ets bien 1");
	}

	@Test
	/**
	 * Dans cette méthode, le test doit me renvoie un true! pour vérifier que ma méthode rechercheCandidat fait correctement sa recherche dans le dossier recrutement
	 */
	public void testRechercheCandidat(){
		boolean existe=false;
		File dossier = new File("C:\\Users\\34011-82-04\\git\\recrutement");
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
	
}
