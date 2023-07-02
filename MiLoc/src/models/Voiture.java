package models;

public class Voiture {
	private String id;
	private String type;
	private String classe;
	private String numEnregistrement;
	private int metrage;
	private int prix;
	private String marque;
	private String immatriculation;
	private int metragePrecis;
	private String etat;
	
	public Voiture(String id, String type, String classe, String numEnregistrement, int metrage, int prix, String marque, String immatriculation, int metragePrecis, String etat) {
		this.id = id;
		this.type = type;
		this.classe = classe;
		this.numEnregistrement = numEnregistrement;
		this.metrage = metrage;
		this.prix = prix;
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.metragePrecis = metragePrecis;
		this.etat = "Disponible";
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumEnregistrement() {
		return numEnregistrement;
	}
	public void setNumEnregistrement(String numEnregistrement) {
		this.numEnregistrement = numEnregistrement;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getMetrage() {
		return metrage;
	}
	public void setMetrage(int metrage) {
		this.metrage = metrage;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public int getMetragePrecis() {
		return metragePrecis;
	}
	public void setMetragePrecis(int metragePrecis) {
		this.metragePrecis = metragePrecis;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
