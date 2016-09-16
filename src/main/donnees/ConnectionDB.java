/**
 * 
 * Cette classe permet la connection à une base de donnée de type SQL.
 * Cette base est sur la machine de Marc à l'ip : 10.111.61.52:3306
 * et la base s'appelle  "jobjobdb".
 *  !!! RESTE A FAIRE !!!
 * 
 * IL FAUT GERER LE PASSAGE DE LOGIN ET PASSWORD DU RECRUTEUR 
 * PAR UNE FENETRE DE LOGIN AU DEMARRAGE DE L APPLI
 * 
 * Dans cette classe il y a une methode qui permet la connection.
 * @author Lionel Chialvo
 * @author Marc Naouache
 * @date	 31/08/2016
 * @version  1.0
 */
package main.donnees;


import com.mysql.jdbc.CallableStatement;

import java.sql.*;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import com.mysql.jdbc.CallableStatement;

import main.metier.Candidat;
import main.metier.questionReponse;



public class ConnectionDB 
{



	private static String url= "jdbc:mysql://sta6101855:3306/jobjob_3_0"; 

	private static String login = "cdi";
	private static String passwd = "cdi";
	private static Connection connection;
	private static Statement statement;

	private String recruteur = "cdi";
	private String MDP = "cdi";
	private  boolean connected = false;

	public String nom;
	public String prenom;
	
	
//	public ConnectionDB () throws ClassNotFoundException, SQLException {
//		
//		connectionBase(recruteur, MDP);
//	}

	/**
	 * Constructeur de la classe
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ConnectionDB () throws ClassNotFoundException, SQLException 
	{
		if (this.connectionBase()) System.out.println("connecté");
	}

	
	/**
	 * Méthode qui se connecte à la base et crèe un premier statement 
	 * @param acces, paramètre qui autorise l'accés
	 * @param recruteur, paramètre qui enregistre le nom du recruteur
	 * @param MDP , paramètre qui enregistre le MDP du recruteur
	 */

	public boolean connectionBase() throws ClassNotFoundException, SQLException
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // chargement du driver
			// recuperation de la connexion
			System.out.println("login : " + login);
			connection = (Connection) DriverManager.getConnection(url, login,  passwd);
		
			// creation d'un statement pour pouvoir lancer des requêtes
			statement = (Statement) connection.createStatement();	
			// affiche dans la console si la connecion est ok.
			System.out.println("connection dataBase OK");



			connected = true;

		}
		
		catch ( SQLException e)
		{
			e.printStackTrace();
			connected = false;
		}finally{}

		// pour test
//		recupererStatistiques();

		return connected;

	}
	

	
	/**
	 * Fonction de déconnexion de la base fermant le statement et la connexion en cours 
	 * @throws SQLException
	 */
	public void Deconnexion() throws SQLException
	{
		statement.close();
		connection.close();
	}
	
	/**
	 * Méthode permettant l'enregistrement du candidat dans la base de donnees
	 * Elle retourne un int, correspondant à l'idPersonne du nouveau candidat enregistré
	 * @author florent
	 * @author David
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param mail
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 * @throws NumberFormatException
	 * @return int  id insertion du dernier candidat
	 */
	public int enregistrerNouveauCandidatEnBase(String id,String nom,String prenom, String telephone, String mail) throws ClassNotFoundException, SQLException
	{
		int numero = -1; // permettra de voir si une insertion s'est bien passé pour candidat
		int lastID = -1; // récupérera le dernier id de l'insertion candidat 
		
		//1ère requête pour l'ajout d'une personne (table mère de candidat)
		String sql2 = "INSERT INTO personne (nom, prenom) VALUES ('"+nom+"','"+prenom+"');";		
		try 
		{
			statement.executeUpdate(sql2);
		} catch (SQLException e) 

		{
			e.printStackTrace();
		}
		
		//2ème requête (table fille) pour l'insertion d'un candidat
		String sql = "INSERT INTO candidat  (idPersonne,idCandidat,telephone,mail, idPersonne_Recruteur) VALUES (LAST_INSERT_ID(),'" + id+"','"+telephone+"','"+mail+ "',3);";
		try 
		{
			numero = statement.executeUpdate(sql);
			if (numero == 1)
			{
				System.out.println("numero vaut 1");
				// requête pour récupérer l'id de la dernière insertion de candidat
				ResultSet rs = (ResultSet) statement.executeQuery("SELECT LAST_INSERT_ID()");
				if (rs.next()) lastID = rs.getInt(1);
				rs.close();
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}


		int answer = 0;
		
		
		// Partie dévouée au test Unitaire, renvoyant l'idPersonne du candidat qui vient d'être créé dans la base
		ResultSet generatedKeys = (ResultSet) statement.getGeneratedKeys(); 
		while(generatedKeys.next()) {
			answer = Integer.parseInt(generatedKeys.getString(1));
		}
		Deconnexion();
		return lastID;
	}
	
	/**
	 * Méthode pour récupérer un candidat dans la base de donnée à partir de son identifiant.
	 * Récupère les champs associés à l'élément id dans la table
	 * @author Audric
	 * @param id   
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */

	
	
	
	public boolean recupererCandidatEnBase(String id) throws ClassNotFoundException, SQLException

	{
		ResultSet rs=null;

		String id2="";
	    nom="";
		prenom="";
		String telephone="";
		String mail="";
		Boolean existe = false;

		String sql2 = "SELECT * FROM candidat WHERE idCandidat='"+id+"'; ";
		try {
			rs = (ResultSet) statement.executeQuery(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {

				try {
					id2 = rs.getString("idCandidat");
					nom = rs.getString("nom");
					prenom= rs.getString("prenom");
					telephone= rs.getString("telephone");
					mail= rs.getString("mail");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		if (!id2.equals("")){
			existe=true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Le candidat n'existe pas");
		}
		
		Deconnexion();
		return existe;
		
	}
	
	
	/**
	 * Méthode qui remplira un tableau de 15 objets de type questionReponse.
	 * 		- Une première REQUETE SQL ira chercher de manière aléatoire le texte d'une question, ainsi que son numero.
	 * 		  puis on remplira les objets questionReponse, ainsi qu'un tableau stockant les numero de nos questions, avec.
	 * 		- Une seconde requête ira chercher l'ensemble des réponses/propositions correspondants à un numero de question donnée.
	 * 
	 * Deux requêtes SQL vont être utilisées :
	 * 		-	Une première (request1) ira chercher de manière aléatoire le texte d'une question, ainsi que son numero.
	 * 			Lors de la lecture de cette requête, seront remplit le libelleQuestion de l'objet, ainsi que 2 tableaux contenant le numero de la question. Un premier tableau servira à trouver les réponses à cette question ultérieurement, un second servira à ne pas avoir de doublons dans le choix des questions.
	 * 		-	Une seconde requête (request2) remplira pour chaque objet les 4 libellesReponses.
	 * 
	 * Des erreurs peuvent apparaître en l'état. Si la base de données n'a pas suffisamment de questions d'une certaine catégorie pour répondre à l'ensemble de la "demande".		
	 * 
	 * @author Mathieu
	 * @param questionReponse[15]
	 * @return questionReponse[15]
	 * @throws ClassNotFoundException 
	 */
	public questionReponse[] chercherQuestionEnBase(questionReponse[] questrep) throws SQLException, ClassNotFoundException
	{
		// Déclaration de mes différentes variables :
		int numeroQuestion[] = new int[15]; // Tableau qui stockera les numero de question déjà tirés
		questrep = new questionReponse[15];
		int ordreCategorieQuestions[] = {1,1,1,1,1,3,3,3,3,3,2,4,4,4,1}; // Le type de nos 15 questions dans notre QCM, par ordre d'apparition
		String numeroQuestionsInterdites = "0"; // variable qui permettra d'exclure des numeros de question de notre requête de recherche aléatoire de questions		
		ResultSet res = null;
		
		
		// Boucles et requêtes permettant de remplir le tableau questionReponse[] fournit en paramètre	
		
			// Première requête, insérée dans une boucle de 15 itérations
			for (int i = 0; i < ordreCategorieQuestions.length; i++) {
				
				String request1 = "SELECT textesQuestion, numero, idPropositions, imagesQuestion FROM questions WHERE idCategorie = " + ordreCategorieQuestions[i] + " AND numero != " + numeroQuestionsInterdites + " ORDER by Rand() LIMIT 1";
				res = (ResultSet) statement.executeQuery(request1);
				
				while (res.next()) 
				{
					questrep[i] = new questionReponse();
					questrep[i].libelleQuestion = res.getString(1);					
					
					questrep[i].numQuestionBDD = res.getInt("numero");
					questrep[i].blob = (com.mysql.jdbc.Blob) res.getBlob("imagesQuestion");
								
					numeroQuestion[i] = res.getInt("numero");					
					numeroQuestionsInterdites += " AND numero  != " + res.getInt("numero");					
				}
				
			}
		
			// Seconde requête, insérée dans une boucle contenant autant d'itérations que l'on a eu de questions précédemment
			for (int j = 0; j < numeroQuestion.length; j++) {
				String request2 = "SELECT reponse FROM propositions INNER JOIN comporte ON propositions.idPropositions = comporte.idPropositions WHERE numero = " + numeroQuestion[j];
				res = (ResultSet) statement.executeQuery(request2);
	
				res.first();
				questrep[j].libelleReponse1 = res.getString("reponse");
				res.next();
				questrep[j].libelleReponse2 = res.getString("reponse");
				res.next();
				questrep[j].libelleReponse3 = res.getString("reponse");
				res.next();
				questrep[j].libelleReponse4 = res.getString("reponse");
			}
			
			// Troisième requête, récupération du texte de la bonne réponse :
			for (int i = 0; i < ordreCategorieQuestions.length; i++) {
				
				String request3 = "SELECT reponse FROM questions INNER JOIN propositions ON questions.idPropositions = propositions.idPropositions WHERE questions.numero = " + questrep[i].numQuestionBDD;
				res = (ResultSet) statement.executeQuery(request3);
				
				while (res.next()) 
				{			
					questrep[i].bonneReponse = res.getString(1);						
				}
				
			}
			
					
		Deconnexion();
		// Notre retour
		return questrep;
	}

	


	//TODO : javadoc inexistante 
	public int nombreCandidat() throws SQLException, ClassNotFoundException
	{
		ResultSet res = null;
		int nbCand=0;
		String requete = "SELECT candidat.idPersonne FROM candidat";
		try {
			res = (ResultSet) statement.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("impossible d effectuer la requete");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (res.next()) {
				try {
				nbCand = res.getInt("idPersonne");
			} catch (SQLException e) {
				System.out.println("fauxe");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Deconnexion();
		return nbCand+1;
	}
	
	/**
	 * @author florent
	 * Remplissage de la table lienqcmquestions avec le numero de la question, le score associé et l'idQcm correspondant
	 * @param score int[]
	 * @param questrep questionReponse[]
	 * @param cd Candidat
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void enregistrerScoreCandidat(int[] score, questionReponse[] questrep, Candidat cd) throws SQLException, ClassNotFoundException
	{		
		String id = cd.identifiant;
		String sql = "INSERT INTO qcm (bareme, dateEvaluation, idPersonne) VALUES ('0%0%1', DATE(NOW()), (SELECT idPersonne FROM candidat WHERE idCandidat ='"+id+"'));";
		int a = statement.executeUpdate(sql);
		
		String sqlladtid = "SELECT LAST_INSERT_ID();";
		ResultSet res = statement.executeQuery(sqlladtid);
		String lastidQcm = null;
		while(res.next()){
			lastidQcm = res.getString(1);
		}
		
		for (int i = 0; i < questrep.length; i++) {
			String sql2 = "INSERT INTO lienqcmquestions (score, idQcm, numero) VALUES ("+score[i]+","+lastidQcm+", "+questrep[i].numQuestionBDD+");";
			int b = statement.executeUpdate(sql2);
		}
		Deconnexion();
	}
	/**
	 * @author cyril
	 * appel de la procédure stockée resultatCandidat qui a pour but de recolter les donnees des candidats pour établir des statistiques
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void recupererStatistiques() throws ClassNotFoundException, SQLException {
		
		CallableStatement cs = null;
		ResultSet resultat = null;

		try {
			cs = (CallableStatement) connection.prepareCall("{call resultatsCandidat()}");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			if (cs.execute()) 
			{
				resultat =  (ResultSet) cs.getResultSet();
				while(resultat.next())
				{
					System.out.println("Nom du candidat:"+resultat.getString("nomCandidat"));
					System.out.println("Date de l'evaluation:"+resultat.getString("dateEvaluation"));
					System.out.println("Notes Technique: "+resultat.getString("Technique"));
					System.out.println("Notes Adaptabilité: "+resultat.getString("Adaptabilite"));
					System.out.println("Notes Culture: "+resultat.getString("Culture"));
					System.out.println("Notes Stress: "+resultat.getString("Stress"));
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}




