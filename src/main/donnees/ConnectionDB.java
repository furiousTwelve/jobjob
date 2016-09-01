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

public class ConnectionDB 

{
	
	static Statement 	 st;
	/*
	 * Méthode qui se connecte à la base 	   
	 */
	public static void connectionBase() throws ClassNotFoundException
	{
	/*
	 * Ici je stocke et initialise mes éléments de connection 
	 */
	String		 url 		= "jdbc:mysql://sta6101855:3306/jobjobdb";
	String 	 	 login 		= "cdi";
	String 		 passwd 	= "cdi";
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
		// creation d'un statement pour pouvoir mancer des requêtes
		st = (Statement) cn.createStatement();
		// affiche dans la console si la connecion est ok.
		System.out.println("connection dataBase OK");
	}
	
	catch ( SQLException e)
	{
		e.printStackTrace();
	}finally{}
	
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
	
}



