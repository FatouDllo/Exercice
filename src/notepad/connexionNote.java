package notepad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utilisateur.note;
import utilisateur.user;

public class connexionNote {
	private String url ="jdbc:mysql://localhost/java_note ?useUnicode=true &useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false& serverTimezone=UTC"  ;
	private String utilisateur = "root";
    private String motDePasse = "";
    static final String InsertionSQL="INSERT INTO notepad "+ " (titre, contenu)"
    		+ " VALUES "+ " (?, ?);";

    protected Connection getConnection () {
  		Connection connection =null; 
  		try {
  			Class.forName("com.mysql.cj.jdbc.Driver"); 
  			//FORNAME methode on renseigne le lieu de la base de donn�e 
  			
  			connection = DriverManager.getConnection(url, utilisateur , motDePasse);
  		}catch (Exception e) {
  			e.printStackTrace();
  			System.out.println("La connexion a �chou�e");
  			
  		}
  		return connection; 
  	}
      
      public boolean ajouter(note note) { 
  		try(
  				Connection connection =getConnection();
  				PreparedStatement ps=connection.prepareStatement(InsertionSQL))
  		{
  			ps.setString(1, note.getTitre());
  			ps.setString(2, note.getContenu());
  			
  			return ps.executeUpdate()>0;	
  			
  		}
  		catch(Exception e) {
  			e.printStackTrace();
  			return false;
  		}
  	} 
      
      public List<note> listerNotes(){
  		List<note> listNotes=new ArrayList<note>();
  		
  		try(
  				Connection connection=getConnection(); 	
  				PreparedStatement ps=connection.prepareStatement("select * from notepad")) // Requ�te pr�pare 
  		// PreparedStatement acces � la base de mani�re s�curis�e . 
  		{
  				ResultSet rep=ps.executeQuery(); // requ�te ex�cut�e 
  				while(rep.next()) {
  					// Creation d'un utilisateur 
  					note  note=new note();
  					note.setTitre(rep.getString("titre"));
  					note.setContenu(rep.getString("contenu"));
  					// Ajout dans la liste d'utilisateur 
  					listNotes.add(note);
  				}	
  			
  		}
  		catch(Exception e ) {
  			e.printStackTrace();
  		}
  		return listNotes;
  			
  	}
}
