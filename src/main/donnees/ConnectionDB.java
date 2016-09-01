/*
 * @auteur 	: Lionel Chialvo
 * @AUTEUR  / Marc Naouache
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
	
	public static void recupererCandidatEnBase() throws ClassNotFoundException
	{
		
		
	}
	
}



