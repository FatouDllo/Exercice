package Criminel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utilisateur.user;
import utilisateur.*; 

public class connexion {
	private String url ="jdbc:mysql://localhost/java_crime ?useUnicode=true &useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC"  ;
	private String utilisateur = "root";
    private String motDePasse = "";
    static final String InsertionSQL="INSERT INTO criminels "+ " (nom, prenom, age, crime, anneeEmprisonnement)"
    		+ " VALUES "+ " (?, ?, ?, ?, ?);";

    static final String DeleteSQL= "DELETE FROM criminels where id= ?"; 
    
    protected Connection getConnection () {
		Connection connection =null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//FORNAME methode on renseigne le lieu de la base de donnée 
			
			connection = DriverManager.getConnection(url, utilisateur , motDePasse);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("La connexion a échouée");
			
		}
		return connection; 
	}
    
    public boolean ajouter(user user) { 
		try(
				Connection connection =getConnection();
				PreparedStatement ps=connection.prepareStatement(InsertionSQL))
		{
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getAge());
			ps.setString(4, user.getCrime());
			ps.setString(5, user.getAnneeEmprisonnement());
			
			return ps.executeUpdate()>0;	
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	} 
    
    public List<user> listerUsers(){
		List<user> listUsers=new ArrayList<user>();
		
		try(
				Connection connection=getConnection(); 	
				PreparedStatement ps=connection.prepareStatement("select * from criminels")) // Requête prépare 
		// PreparedStatement acces à la base de manière sécurisée . 
		{
				ResultSet rep=ps.executeQuery(); // requête exécutée 
				while(rep.next()) {
					// Creation d'un utilisateur 
					user user=new user();
					user.setId(rep.getInt("id"));
					user.setNom(rep.getString("nom"));
					user.setPrenom(rep.getString("prenom"));
					user.setAge(rep.getString("age"));
					user.setCrime(rep.getString("crime"));
					user.setAnneeEmprisonnement(rep.getString("anneeEmprisonnement"));
					// Ajout dans la liste d'utilisateur 
					listUsers.add(user);
				}	
			
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return listUsers;
			
	}
    
    public user rechercherById(int id){
		user user=new user();
		try(
				Connection connection=getConnection();
				PreparedStatement ps=connection.prepareStatement("select * from criminels where id=?"))
		{
			ps.setInt(1, id);
			ResultSet rep=ps.executeQuery();
			while(rep.next()) {
				//
				user.setId(rep.getInt("id"));
				user.setNom(rep.getString("nom"));
				user.setPrenom(rep.getString("prenom"));
				user.setAge(rep.getString("age"));
				user.setCrime(rep.getString("crime"));
				user.setAnneeEmprisonnement(rep.getString("anneeEmprisonnement"));
				
				
			}
			
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return user;	
	}
    
    public boolean supprimerByID(int id) {
		
	    try(
	    		Connection connection=getConnection();
	    		PreparedStatement ps = connection.prepareStatement(DeleteSQL))
	    {
		    ps.setInt(1, id);
		    return ps.executeUpdate()>0;

	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return false;
	    }
	
}
    public boolean modifierById (user user) {
		int valID=user.getId();
		String valNom= user.getNom();
		String valPrenom= user.getPrenom();
		String valAge= user.getAge();
		String valCrime= user.getCrime();
		String valAnnee= user.getAnneeEmprisonnement();
		
		String UpdateSQL= "Update criminels set Nom='"+valNom+"',Prenom='"+valPrenom+"',Age='"+valAge+"',Crime='"+valCrime+"'"
				+ ",AnneeEmprisonnement='"+valAnnee+"' where id='"+valID+"' ";
		
		try(Connection connection=getConnection();
				PreparedStatement ps =connection.prepareStatement(UpdateSQL)){
					//ps.setInt(1, id); 
					return ps.executeUpdate()>0;
		} catch (Exception e) {
	    	e.printStackTrace();
	    	return false;	
		}
	}
}
