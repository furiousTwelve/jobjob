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
	String		 url 		= "jdbc:mysql://sta6101855:3306/jobjobdb";
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
		System.out.println("cn :"+cn);
		cn = (Connection) DriverManager.getConnection(url, login, passwd);
	//	System.out.println("cn :"+cn);
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
	 * Méthode pour récupérer les réponses liées à la question passée en paramètres
	 * 
	 */
	public static void chercherQestionEnBase(questionReponse questrep) throws ClassNotFoundException
	{
		ResultSet	res				=null;
		String		Rep1 			= "";
		String		Rep2			= "";
		String		Rep3			= "";
		String		Rep4			= "";
		String		question		= "";
		byte		numq			=0;
		
		/*
		 * je recupère le numero de question de mon objet questrep
		 * je le stocke dans une variable numq
		 * 
		 */
		 numq 		= questrep.numQuestion;
		
		/*
		 * je met dans une chaine de caractères nommée sql3 la requête SQL
		 * en prenant soin de mettre mon paramètre numq.
		 * 
		 */
		String sql3 = "SELECT * FROM reponse WHERE idReponse ='"+numq+"'; ";
		String sql4 = "SELECT * FROM question WHERE numero ='"+numq+"'; ";
		/*
		 * la methode executeQuery me permet de lancer la requete 
		 * avec la chaine qui la contient sql3
		 */
		try {
			
			res = (ResultSet) st.executeQuery(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("impossible d effectuer la requete");
			e.printStackTrace();
			
		}
		/*
		 * Puis pour l'instant je stocke les éléments contenus 
		 * dans chaque cellule correspondant aux 4 propositions de réponses
		 * 
		 */
		try {
			try {
				while (res.next()) {
					try{
					Rep1		= res.getString("reponse1");
					Rep2		= res.getString("reponse2");
					Rep3		= res.getString("reponse3");
					Rep4		= res.getString("reponse4");
					
					
		} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
		}

		/*
		 *remplit les 4 propositions de reponses dans l'objet de type questionReponse
		 */
		
		
		questrep.libelleReponse1=Rep1;
		questrep.libelleReponse2=Rep2;
		questrep.libelleReponse3=Rep3;
		questrep.libelleReponse4=Rep4;
		
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}finally{}
		try {

			res = (ResultSet) st.executeQuery(sql4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("impossible d effectuer la requete");
			e.printStackTrace();

		}
		try {
			try {
				while (res.next()) {
					try {

						question = res.getString("qtexte");

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					/*
					 * J'affiche le contenu dans la console pour vérifier que
					 * les 4 propositions correspondent bien
					 */


					questrep.libelleQuestion = question;

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} finally {
		}
	}

	
}



