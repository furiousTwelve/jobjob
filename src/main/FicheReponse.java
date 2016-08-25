package main;

import java.util.Date;

public class FicheReponse 
{
	/**
	 * ATTRIBUTS DE LA FICHE REPONSE
	 */
	protected String identifiantCandidat;
	protected Date dateHeureDebutSession;
	protected questionReponse[] tableauDesReponses;
	protected int tempsPasse;
	protected int score;
	
	/**
	 * CONSTRUCTEUR DE LA FICHE REPONSE
	 * @param ident : identifiant du candidat
	 * @param session : date de session de passage du candidat
	 */
	public FicheReponse(String ident, Date session)
	{
		this.identifiantCandidat = ident;
		this.dateHeureDebutSession = session;
		tableauDesReponses = new questionReponse[15];
	}
	
}