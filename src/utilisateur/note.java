package utilisateur;

public class note {
	private String titre; 
	private String contenu; 
	public note(String titre, String contenu) {
		super();
		this.titre = titre;
		this.contenu = contenu;
	}
	public note() {
		super();
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
}
