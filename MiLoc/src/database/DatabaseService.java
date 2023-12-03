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
        String createTable = "CREATE TABLE IF NOT EXISTS clients("
        					+ "nom TEXT PRIMARY KEY,"
        					+ "dateNaissance TEXT,"
        					+ "adresse TEXT,"
        					+ "phone TEXT,"
        					+ "lieuNaissance TEXT,"
        					+ "permis TEXT,"
        					+ "datePermis TEXT,"
        					+ "lieuPermis TEXT);"
        					+ "CREATE TABLE IF NOT EXISTS voitures("
        					+ "id TEXT PRIMARY KEY,"
        					+ "type TEXT,"
        					+ "classe TEXT,"
        					+ "numEnregistrement TEXT,"
        					+ "metrage INTEGER,"
        					+ "prix INTEGER,"
        					+ "marque TEXT,"
        					+ "immatriculation TEXT);"
        					+ "metragePrecis INTEGER,"
        					+ "etat TEXT);"
        					+ "CREATE TABLE IF NOT EXISTS contrats("
        					+ "numContrat INTEGER PRIMARY KEY AUTOINCREMENT,"
        					+ "voiture TEXT,"
        					+ "client TEXT,"
        					+ "datePrise TEXT,"
        					+ "duree TEXT,"
        					+ "heureRemise TEXT,"
        					+ "daeRemise TEXT);";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
    }
 

	
	
}
	