package utilisateur;

public class user {
	private int id;
	 private String nom;
	 private String prenom;
	 private String age;
	 private String crime; 
	 private String anneeEmprisonnement; 
	public user(int id, String nom, String prenom, String age, String crime, String anneeEmprisonnement) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.crime = crime;
		this.anneeEmprisonnement = anneeEmprisonnement; 
	}
	public user() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public  String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}
	public String getAnneeEmprisonnement() {
		return anneeEmprisonnement;
	}
	public void setAnneeEmprisonnement(String anneeEmprisonnement) {
		this.anneeEmprisonnement = anneeEmprisonnement;
	}

}
