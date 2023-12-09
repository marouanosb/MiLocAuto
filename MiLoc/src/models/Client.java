package models;

public class Client {
	private String nom;
	private String dateNaissance;
	private String adresse;
	private String phone;
	private String lieuNaissance;
	private String permis;
	private String datePermis;
	private String lieuPermis;
	private String passeport;
	
	public Client(String nom, String dateNaissance, String adresse, String phone, String lieuNaissance, String permis, String datePermis, String lieuPermis, String passeport) {
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.phone = phone;
		this.lieuNaissance = lieuNaissance;
		this.permis = permis;
		this.datePermis = datePermis;
		this.lieuPermis = lieuPermis;
		this.setPasseport(passeport);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getPermis() {
		return permis;
	}
	public void setPermis(String permis) {
		this.permis = permis;
	}
	public String getDatePermis() {
		return datePermis;
	}
	public void setDatePermis(String datePermis) {
		this.datePermis = datePermis;
	}
	public String getLieuPermis() {
		return lieuPermis;
	}
	public void setLieuPermis(String lieuPermis) {
		this.lieuPermis = lieuPermis;
	}

	public String getPasseport() {
		return passeport;
	}

	public void setPasseport(String passeport) {
		this.passeport = passeport;
	}

}
