package main.metier;

import java.sql.SQLException;

import main.donnees.ConnectionDB;

public class Recruteur {
	
	public String identifiant;
	public String motDePasse;
	
	

	public Recruteur(String identifiant, String motDePasse) {
		
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}
	
	public boolean verifierAcces(String recruteur, String MDP) throws ClassNotFoundException, SQLException
	{
		boolean demandeAcces=true;
		boolean retourAcces=true;
		
		ConnectionDB laConnection = new ConnectionDB();
		
		retourAcces=laConnection.connectionBase(demandeAcces,recruteur,MDP);
		return (retourAcces);
		
	}

}
