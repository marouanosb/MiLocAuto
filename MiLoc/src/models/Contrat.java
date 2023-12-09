package models;

public class Contrat {
	private int numContrat;
	private Voiture voiture;
	private Client client;
	
	private String datePrise;
	private int duree;
	private String heurePrise;
	private String dateRemise;
	
	private int garantie;

	
	public Contrat(Voiture voiture, Client client, String datePrise, int duree, String heurePrise, String dateRemise, int garantie) {
		this.voiture = voiture;
		this.client = client;
		
		this.setDatePrise(datePrise);
		this.setDuree(duree);
		this.setHeurePrise(heurePrise);
		this.setDateRemise(dateRemise);
		this.setGarantie(garantie);
	}
	
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(int numContrat) {
		this.numContrat = numContrat;
	}

	public String getDatePrise() {
		return datePrise;
	}

	public void setDatePrise(String datePrise) {
		this.datePrise = datePrise;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getHeurePrise() {
		return heurePrise;
	}

	public void setHeurePrise(String heurePrise) {
		this.heurePrise = heurePrise;
	}

	public String getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(String dateRemise) {
		this.dateRemise = dateRemise;
	}

	public int getGarantie() {
		return garantie;
	}

	public void setGarantie(int garantie) {
		this.garantie = garantie;
	}
	 

}
