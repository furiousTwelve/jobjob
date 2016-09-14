package Test;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import main.donnees.ConnectionDB;

public class CandidatTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException 
	 */
	public void testenregistrerNouveauCandidat() throws ClassNotFoundException, SQLException 
	{ 
		// Création de données
		String nom = "NOMTEST";
		String prenom = "PrénomTest";
		String mail = "NOMTESTPrenomTest@yahoo.fr";
		String telephone = "0123456789";
		String idCandidat = "0001";
		
		String nomTest = "";
		String prenomTest = "";
		String mailTest = "";
		String telephoneTest = "";
		String idCandidatTest = "";
		
		int lastIdCandidat = 1;
		
		// Exécution de la méthode testée
		ConnectionDB cdb = new ConnectionDB();
		lastIdCandidat = cdb.enregistrerNouveauCandidatEnBase("0001", "NOMTEST", "PrénomTest", "0123456789", "NOMTESTPrenomTest@yahoo.fr");
		
		// Connexion à ma BDD
		String		 url 		= "jdbc:mysql://localhost/jobjob_2_0";
		String 	 	 login 		= "root";
		String 		 passwd 	= "";
		Connection	 cn 		= null;
		Statement st	= null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = (Connection) DriverManager.getConnection(url, login, passwd);
			st = (Statement) cn.createStatement();
			System.out.println("connection dataBase OK");
		}
		catch ( SQLException e)
		{
			e.printStackTrace();
		}
		
		// Comparaisons :
		String requeteTestNom = "SELECT telephone, mail, idCandidat FROM candidat WHERE idPersonne = " + lastIdCandidat;
		System.out.println(lastIdCandidat);
		ResultSet rs = (ResultSet) st.executeQuery(requeteTestNom);
		while(rs.next()) {
			telephoneTest = rs.getString("telephone");
			mailTest = rs.getString("mail");
			idCandidatTest = rs.getString("idCandidat");
		}
		
		System.out.println("Résultat souhaité au testCandidat #1 : " + telephone + " " + mail + " " + idCandidat);
		System.out.println("Résultat obtenu au testCandidat #1 : " + telephoneTest + " " + mailTest + " " + idCandidatTest);
		assertTrue(telephone.equals(telephoneTest) && mail.equals(mailTest) && idCandidat.equals(idCandidatTest));
		
		
	}

	public void testDefinirNumeroCandidat()
	{
		
	}

}
