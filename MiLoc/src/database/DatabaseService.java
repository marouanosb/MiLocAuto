package database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.*;

public class DatabaseService {
	static Connection connection = null;

    private static void connectDB() throws SQLException, ClassNotFoundException{
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Create a connection to the database
            connection = DriverManager.getConnection("jdbc:sqlite:database/bdd.db");
            

    }

    public static void initialiseDB() throws SQLException, ClassNotFoundException {
    	connectDB();
        String query = "CREATE TABLE IF NOT EXISTS clients("
        					+ "nom TEXT PRIMARY KEY,"
        					+ "dateNaissance TEXT,"
        					+ "adresse TEXT,"
        					+ "phone TEXT,"
        					+ "lieuNaissance TEXT,"
        					+ "permis TEXT,"
        					+ "datePermis TEXT,"
        					+ "lieuPermis TEXT,"
        					+ "passeport TEXT)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.execute();
        query = "CREATE TABLE IF NOT EXISTS voitures("
				+ "id TEXT PRIMARY KEY,"
				+ "type TEXT,"
				+ "classe TEXT,"
				+ "numEnregistrement TEXT,"
				+ "metrage INTEGER,"
				+ "prix INTEGER,"
				+ "marque TEXT,"
				+ "immatriculation TEXT,"
				+ "metragePrecis INTEGER,"
				+ "etat TEXT)";
        ps = connection.prepareStatement(query);
        ps.execute();
        query = "CREATE TABLE IF NOT EXISTS contrats("
				+ "numContrat INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "voiture TEXT,"
				+ "client TEXT,"
				+ "datePrise TEXT,"
				+ "duree INTEGER,"
				+ "heureRemise TEXT,"
				+ "dateRemise TEXT,"
				+ "garantie INTEGER)";
        ps = connection.prepareStatement(query);
        ps.execute();
        connection.close();
    }
    
    public static void insertVoiture(Voiture v) throws ClassNotFoundException, SQLException {
    	connectDB();
    	String query = "INSERT INTO voitures VALUES(?,?,?,?,?,?,?,?,?,?)";
    	PreparedStatement ps  = connection.prepareStatement(query);
    	ps.setString(1, v.getId());
    	ps.setString(2, v.getType());
    	ps.setString(3, v.getClasse());
    	ps.setString(4, v.getNumEnregistrement());
    	ps.setInt(5, v.getMetrage());
    	ps.setInt(6, v.getPrix());
    	ps.setString(7, v.getMarque());
    	ps.setString(8, v.getImmatriculation());
    	ps.setInt(9, v.getMetragePrecis());
    	ps.setString(10, v.getEtat());
    	
    	ps.execute();  	
    	connection.close();
    }
    
    public static void insertClient(Client c) throws ClassNotFoundException, SQLException {
    	connectDB();
    	String query = "INSERT INTO clients VALUES(?,?,?,?,?,?,?,?,?)";
    	PreparedStatement ps  = connection.prepareStatement(query);
    	ps.setString(1, c.getNom());
    	ps.setString(2, c.getDateNaissance());
    	ps.setString(3, c.getAdresse());
    	ps.setString(4, c.getPhone());
    	ps.setString(5, c.getLieuNaissance());
    	ps.setString(6, c.getPermis());
    	ps.setString(7, c.getDatePermis());
    	ps.setString(8, c.getLieuPermis());
    	ps.setString(9, c.getPasseport());
    	
    	ps.execute();  
    	connection.close();
    }
    
    public static void insertContrat(Contrat c) throws ClassNotFoundException, SQLException {
    	connectDB();
    	String query = "INSERT INTO contrats VALUES(?,?,?,?,?,?,?,?)";
    	PreparedStatement ps  = connection.prepareStatement(query);
    	ps.setString(2, c.getVoiture().getId());
    	ps.setString(3, c.getClient().getNom());
    	ps.setString(4, c.getDatePrise());
    	ps.setInt(5, c.getDuree());
    	ps.setString(6, c.getHeurePrise());
    	ps.setString(7, c.getDateRemise());
    	ps.setInt(8, c.getGarantie());
    	
    	ps.execute();  	
    	connection.close();
    }
    
    public static ArrayList<Voiture> getAllVoitures() throws ClassNotFoundException, SQLException{
    	ArrayList<Voiture> voitures = new ArrayList<Voiture>();
    	connectDB();
    	String query = "SELECT * FROM voitures";
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet rs = ps.executeQuery();
    	while (rs.next()) {
    		Voiture v = new Voiture (rs.getString("id"),
    								rs.getString("type"),
    								rs.getString("classe"),
    								rs.getString("numEnregistrement"),
    								rs.getInt("metrage"),
    								rs.getInt("prix"),
    								rs.getString("marque"),
    								rs.getString("immatriculation"),
    								rs.getInt("metragePrecis"),
    								rs.getString("etat"));
    		voitures.add(v);
    	}
    	connection.close();
    	return voitures;
    	
    }
    
    public static ArrayList<Client> getAllClients() throws ClassNotFoundException, SQLException{
    	ArrayList<Client> clients = new ArrayList<Client>();
    	connectDB();
    	String query = "SELECT * FROM clients ORDER BY nom";
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet rs = ps.executeQuery();
    	while (rs.next()) {
    		Client c = new Client (rs.getString("nom"),
    								rs.getString("dateNaissance"),
    								rs.getString("adresse"),
    								rs.getString("phone"),
    								rs.getString("lieuNaissance"),
    								rs.getString("permis"),
    								rs.getString("datePermis"),
    								rs.getString("lieuPermis"),
    								rs.getString("passeport"));
    		clients.add(c);
    	}
    	connection.close();
    	return clients;
    }
    
    public static ArrayList<Contrat> getAllContrats() throws ClassNotFoundException, SQLException{
    	ArrayList<Contrat> contrats = new ArrayList<Contrat>();
    	connectDB();
    	String query = "SELECT * FROM contrats ORDER BY numContrat DESC";
    	PreparedStatement ps = connection.prepareStatement(query);
    	ResultSet rs = ps.executeQuery();
    	while (rs.next()) {
    		Contrat c = new Contrat (getVoiture(rs.getString("voiture")), 								
    								getClient(rs.getString("client")),
    								rs.getString("datePrise"),
    								rs.getInt("duree"),
    								rs.getString("heureRemise"),
    								rs.getString("dateRemise"),
    								rs.getInt("garantie"));
    		c.setNumContrat(rs.getInt("numContrat"));
    		contrats.add(c);
    	}
    	connection.close();
    	return contrats;
    }
    
    public static Client getClient(String nom) throws ClassNotFoundException, SQLException{
    	connectDB();
    	String query = "SELECT * FROM clients WHERE  nom = ?";
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setString(1, nom);
    	ResultSet rs = ps.executeQuery();
    	Client c = null;
    	if(rs.next()) {
	    	c = new Client (rs.getString("nom"),
					rs.getString("dateNaissance"),
					rs.getString("adresse"),
					rs.getString("phone"),
					rs.getString("lieuNaissance"),
					rs.getString("permis"),
					rs.getString("datePermis"),
					rs.getString("lieuPermis"),
					rs.getString("passeport"));
    	}
    	connection.close();
    	return c;
    }
    
    public static Voiture getVoiture(String id) throws ClassNotFoundException, SQLException{
    	connectDB();
    	String query = "SELECT * FROM voitures WHERE  id = ?";
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setString(1, id);
    	ResultSet rs = ps.executeQuery();
    	rs.next();
    	Voiture v = new Voiture (rs.getString("id"),
				rs.getString("type"),
				rs.getString("classe"),
				rs.getString("numEnregistrement"),
				rs.getInt("metrage"),
				rs.getInt("prix"),
				rs.getString("marque"),
				rs.getString("immatriculation"),
				rs.getInt("metragePrecis"),
				rs.getString("etat"));
    	connection.close();
    	return v;
    }
    
    public static void deleteVoiture(String id) throws ClassNotFoundException, SQLException {
    	connectDB();
    	String query = "DELETE FROM voitures WHERE id = ?";
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setString(1, id);
    	ps.executeUpdate();    	
    	connection.close();
    	System.out.println("Deleted successfully.");
    }
    

	public static void deleteClient(String nom) throws ClassNotFoundException, SQLException {
		connectDB();
    	String query = "DELETE FROM clients WHERE nom = ?";
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setString(1, nom);
    	ps.executeUpdate();    	
    	connection.close();
    	System.out.println("Deleted successfully.");
		
	}

	public static void updateVoiture(String id, Voiture v) throws ClassNotFoundException, SQLException {
		connectDB();
		String query = "UPDATE voitures SET "
				+"id = ?,"
				+ "type = ?,"
				+ "classe = ?,"
				+ "numEnregistrement = ?,"
				+ "metrage = ?,"
				+ "prix = ?,"
				+ "marque = ?,"
				+ "immatriculation = ?,"
				+ "metragePrecis = ?,"
				+ "etat = ? "
				+ "WHERE id = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, v.getId());
		ps.setString(2, v.getType());
		ps.setString(3, v.getClasse());
		ps.setString(4, v.getNumEnregistrement());
		ps.setInt(5, v.getMetrage());
		ps.setInt(6, v.getPrix());
		ps.setString(7, v.getMarque());
		ps.setString(8, v.getImmatriculation());
		ps.setInt(9, v.getMetragePrecis());
		ps.setString(10, v.getEtat());
		ps.setString(11, id);
		
		ps.execute();
		connection.close();
	}

	public static void updateClient(String nom, Client c) throws SQLException, ClassNotFoundException {
		connectDB();
		String query = "UPDATE clients SET "
			    + "nom = ?, "
			    + "dateNaissance = ?, "
			    + "adresse = ?, "
			    + "phone = ?, "
			    + "lieuNaissance = ?, "
			    + "permis = ?, "
			    + "datePermis = ?, "
			    + "lieuPermis = ? "
			    + "WHERE nom = ?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, c.getNom());
		ps.setString(2, c.getDateNaissance());
		ps.setString(3, c.getAdresse());
		ps.setString(4, c.getPhone());
		ps.setString(5, c.getLieuNaissance());
		ps.setString(6, c.getPermis());
		ps.setString(7, c.getDatePermis());
		ps.setString(8, c.getLieuPermis());
		ps.setString(9, nom);
		
		ps.execute();
		connection.close();
		
	}

}
	