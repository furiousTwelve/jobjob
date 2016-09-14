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
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import main.metier.questionReponse;


// TODO class à revoir complètement. Il n'y a aucune fermeture de base de données qu'il devrait y avoir après CHAQUE requête
// TODO piste à étudier mettre un destructeur (avec un log pour voir quand ça passe) ou mettre à null l'appel à l'instanciation
public class ConnectionDB 
{
	static Statement 	 st;           // TODO : ok enchanté st, sinon tu fais quoi dans la vie? 
	
	//TODO : javadoc à revoir CECI N EST PAS UNE JAVADOC + Il manque les champs @param
	/*
	 * Méthode qui se connecte à la base 	   
	 */
	public static boolean connectionBase(boolean acces,String recruteur,String MDP) throws ClassNotFoundException, SQLException
	{

	/*
	 * Ici je stocke et initialise mes éléments de connection 
	 */
	String		 url 		= "jdbc:mysql://localhost/jobjob_2_0";
	String 	 	 login 		= recruteur;
	String 		 passwd 	= MDP;
	Connection	 cn 		= null;
	st	= null;
	
	/*
	 * Connection au drivers de base de donnée
	 * ici pour le SQL
	 */
	try
	{
		// chargement du driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// recuperation de la connexion	
		cn = (Connection) DriverManager.getConnection(url, login, passwd);
	
		// creation d'un statement pour pouvoir lancer des requêtes
		st = (Statement) cn.createStatement();
		
		// affiche dans la console si la connecion est ok.
		System.out.println("connection dataBase OK");
	}
	
	catch ( SQLException e)
	{
		e.printStackTrace();
		acces=false;
	}finally{}
	
	return(acces);

	
	}
	
	/**
	 * Méthode permettant l'enregistrement du candidat dans la base de donnees
	 * @author florent
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param mail
	 * @throws ClassNotFoundException
	 */
	
	public static void enregistrerNouveauCandidatEnBase(String id,String nom,String prenom, String telephone, String mail) throws ClassNotFoundException
	{
		
		String sql2 = "INSERT INTO personne (nom, prenom) VALUES ('"+nom+"','"+prenom+"');";
		
		try 
		{
			st.executeUpdate(sql2);
			
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO candidat  (idPersonne,idCandidat,telephone,mail, idPersonne_1) VALUES (LAST_INSERT_ID(),'" + id+"','"+telephone+"','"+mail+ "',3);";
		
		try 
		{
			st.executeUpdate(sql);
			
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	//TODO : javadoc à revoir CECI N EST PAS UNE JAVADOC + Il manque le champ @param
	/*
	 * Méthode pour récupérer un candidat dans la base de donnée à partir de son identifiant.
	 * affiche dans la console les champs associés à l'élément id dans la table
	 *    
	 */
	public static void recupererCandidatEnBase(String id) throws ClassNotFoundException
	{
		ResultSet rs=null;
		String id2="";
		String nom="";
		String prenom="";
		String telephone="";
		String mail="";
		
		String sql2 = "SELECT * FROM candidat WHERE idCandidat='"+id+"'; ";
		try {
			rs = (ResultSet) st.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					id2 = rs.getString("identifiant");
					nom = rs.getString("nom");
					prenom= rs.getString("prenom");
					telephone= rs.getString("telephone");
					mail= rs.getString("mail");
					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println(id2);
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(telephone);
				System.out.println(mail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/** Méthode renvoyant un tableau d'objets de type questionReponse
	 * Pour chaque objet seront complétés le libelleQuestion, ainsi que les libellesReponses. Les questions sont choisies de manière aléatoire dans la BDD
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
	 */
	public questionReponse[] chercherQuestionEnBase(questionReponse[] questrep) throws SQLException

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
				
				String request1 = "SELECT textesQuestion, numero, idPropositions FROM questions WHERE idCategorie = " + ordreCategorieQuestions[i] + " AND numero != " + numeroQuestionsInterdites + " ORDER by Rand() LIMIT 1";
				res = (ResultSet) st.executeQuery(request1);
				
				while (res.next()) 
				{
					questrep[i] = new questionReponse();
					questrep[i].libelleQuestion = res.getString(1);					
					
					questrep[i].numQuestionBDD = res.getInt("numero");				
								
					numeroQuestion[i] = res.getInt("numero");					
					numeroQuestionsInterdites += " AND numero  != " + res.getInt("numero");
					
					questrep[i].bonneReponse = res.getInt("idPropositions");						
				}
				
			}
		
			// Seconde requête, insérée dans une boucle contenant autant d'itérations que l'on a eu de questions précédemment
			for (int j = 0; j < numeroQuestion.length; j++) {
				String request2 = "SELECT reponse FROM propositions INNER JOIN comporte ON propositions.idPropositions = comporte.idPropositions WHERE numero = " + numeroQuestion[j];
				res = (ResultSet) st.executeQuery(request2);
	
				res.first();
				questrep[j].libelleReponse1 = res.getString("reponse");
				res.next();
				questrep[j].libelleReponse2 = res.getString("reponse");
				res.next();
				questrep[j].libelleReponse3 = res.getString("reponse");
				res.next();
				questrep[j].libelleReponse4 = res.getString("reponse");
			}
					
		// Notre retour
		return questrep;
	}

	


	//TODO : javadoc inexistante 
	public int nombreCandidat()
	{

		ResultSet res = null;
		int nbCand=0;
		String requete = "SELECT candidat.idPersonne FROM candidat";
		try {
			res = (ResultSet) st.executeQuery(requete);
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
		return nbCand+1;
	}

}




