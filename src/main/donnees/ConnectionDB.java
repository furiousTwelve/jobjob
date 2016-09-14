/*
 * @auteur 	: Lionel Chialvo
 * @auteur  / Marc Naouache
 * @date	: 31/08/2016
 * @version : 1.0
 * 
 * 
 * Description : 
 * Cette classe permet la connection à une base de donnée de type SQL.
 * Cette base est sur la machine de Marc à l'ip : 10.111.61.52:3306
 * et la base s'appelle  "jobjobdb".
 * 
 * Dans cette classe il y a une methode qui permet la connection.
 * 
 * 
 * 
 * !!! RESTE A FAIRE !!!
 * 
 * IL FAUT GERER LE PASSAGE DE LOGIN ET PASSWORD DU RECRUTEUR 
 * PAR UNE FENETRE DE LOGIN AU DEMARRAGE DE L APPLI
 * 
 */

package main.donnees;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import main.metier.questionReponse;

public class ConnectionDB 

{
	
	static Statement 	 st;
	/*
	 * Méthode qui se connecte à la base 	   
	 */
	public static boolean connectionBase(boolean acces,String recruteur,String MDP) throws ClassNotFoundException, SQLException
	{
	/*
	 * Ici je stocke et initialise mes éléments de connection 
	 */
	String		 url 		= "jdbc:mysql://sta6101855:3306/jobjob_2_0";
//	String		 url 		= "jdbc:mysql://localhost/jobjob_2_0";
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
	
	/*
	 * Méthode pour ajouter un nouveau candidat dans l abase de donnée.
	 * 
	 *    
	 */
	public static void enregistrerNouveauCandidatEnBase(int id,String nom,String prenom, String telephone, String mail) throws ClassNotFoundException
	{
		
		String sql = "INSERT INTO candidat  (identifiant,nom,prenom,telephone,mail) VALUES ('" + id+"','"+nom+"','"+prenom+"','"+telephone+"','"+mail+ "');";
		
		try {
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * Méthode pour récupérer un candidat dans la base de donnée à partir de son identifiant.
	 * affiche dans la console les champs associés à l'élément id dans la table
	 *    
	 */
	public static void recupererCandidatEnBase(int id) throws ClassNotFoundException
	{
		ResultSet rs=null;
		int id2=0;
		String nom="";
		String prenom="";
		String telephone="";
		String mail="";
		
		String sql2 = "SELECT * FROM candidat WHERE identifiant='"+id+"'; ";
		try {
			rs = (ResultSet) st.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					id2 = rs.getInt("identifiant");
					nom = rs.getString("nom");
					prenom= rs.getString("prenom");
					telephone= rs.getString("telephone");
					mail= rs.getString("mail");
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(id2);
				System.out.println(nom);
				System.out.println(prenom);
				System.out.println(telephone);
				System.out.println(mail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/*
	 * Méthode qui remplira un tableau de 15 objets de type questionReponse.
	 * 		- Une première REQUETE SQL ira chercher de manière aléatoire le texte d'une question, ainsi que son numero.
	 * 		  puis on remplira les objets questionReponse, ainsi qu'un tableau stockant les numero de nos questions, avec.
	 * 		- Une seconde requête ira chercher l'ensemble des réponses/propositions correspondants à un numero de question donnée.
	 * 
	 * 		Des erreurs peuvent apparaître en l'état. Si la base de données n'a pas suffisamment de questions d'une certaine catégorie pour répondre à l'ensemble de la "demande".		
	 * @author Mathieu
	 * 
	 */
	public questionReponse[] chercherQuestionEnBase(questionReponse[] questrep) throws SQLException
	{
		int numeroQuestion[] = new int[15]; // Tableau qui stockera les numero de question déjà tirés
		questrep = new questionReponse[15];
		int ordreCategorieQuestions[] = {1,1,1,1,1,3,3,3,3,3,2,4,4,4,1}; // Le type de nos 15 questions dans notre QCM, par ordre d'apparition
		String numeroQuestionsInterdites = "0"; // variable qui permettra d'exclure des numeros de question de notre requête de recherche aléatoire de questions
		
		
		// Mes requêtes ici :			
		ResultSet res = null;
		
		for (int i = 0; i < ordreCategorieQuestions.length; i++) {
			String request1 = "SELECT textesQuestion, numero FROM questions WHERE idCategorie = " + ordreCategorieQuestions[i] + " AND numero != " + numeroQuestionsInterdites + " ORDER by Rand() LIMIT 1";
			res = (ResultSet) st.executeQuery(request1);
			while (res.next()) {
				questrep[i] = new questionReponse();
				questrep[i].libelleQuestion = res.getString(1);
				numeroQuestion[i] = res.getInt("numero");
				numeroQuestionsInterdites += " AND numero  != " + res.getInt("numero");
				//System.out.println(numeroQuestionsInterdites);
			}
		}
		
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
		
		return questrep;
		
//		for (int i = 0; i < ordreCategorieQuestions.length; i++) {
//			System.out.println(questrep[i].libelleQuestion);
//		}
	}
			
}





