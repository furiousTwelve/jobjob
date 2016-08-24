package main;

import static org.junit.Assert.*;

import org.junit.Test;



public class EnregistrementDonneeTest {
	 EnregistrementDonnee mc=new  EnregistrementDonnee();
	//@Test
	/*public void testEntreprise() {
		mc.entreprise();	
		  if()
		   System.out.print("trouvé ");
	       else System.out.print("non trouvé");
	}*/
	
	
	
	
	//@Test
	/*public void testCandidat() {
	
		EnregistrementDonnee classATester = new EnregistrementDonnee();
			String nom = "BOUDJEMA ";
			String prenom = "khadidja";
			String mail = "boudjema.k@gmail.com ";
			String telephone = "010203 ";
			String date = "14/06/2015 ";
			
		    
			String resultatAttendu = "Nom : BOUDJEMA / prenom: khadidja/ mail:boudjema.k@gmail.com/ tel: 010203/ date de naissance :14/06/2015" ;
			assertEquals(resultatAttendu, mc.candidat("BOUDJEMA", "khadidja", "boudjema.k@gmail.com", "010203 ", "4/06/2015 "));
			
		}*/

	
	




	@Test
	public void testGetidentifiant() {
		assertTrue(mc.getidentifiant()==1);
	}

}
