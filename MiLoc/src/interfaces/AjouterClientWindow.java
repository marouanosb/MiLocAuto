package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import database.DatabaseService;
import models.Client;
import models.Voiture;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterClientWindow extends JFrame {

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private JPanel contentPane;
	private JTextField nomEdit;
	private JDateChooser dateNaissanceEdit;
	private JTextField adresseEdit;
	private JTextField phoneEdit;
	private JTextField lieuNaissanceEdit;
	private JTextField permisEdit;
	private JDateChooser datePermisEdit;
	private JTextField lieuPermisEdit;

	
	public AjouterClientWindow(String nom, ClientsPanel cpanel) throws ClassNotFoundException, SQLException, ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 400);
		
		getContentPane().setLayout(null);
		
		JPanel ajouterClientPanel = new JPanel();
		ajouterClientPanel.setBounds(10, 10, 768, 400);
		ajouterClientPanel.setLayout(null);
		
		JLabel nomLabel = new JLabel("اسم الزيون");
		nomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomLabel.setBounds(648, 58, 90, 30);
		ajouterClientPanel.add(nomLabel);
		
		JLabel dateNaissanceLabel = new JLabel("تاريخ الميلاد");
		dateNaissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateNaissanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateNaissanceLabel.setBounds(648, 101, 90, 30);
		ajouterClientPanel.add(dateNaissanceLabel);
		
		JLabel lieuNaissanceLabel = new JLabel("بـ");
		lieuNaissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lieuNaissanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lieuNaissanceLabel.setBounds(418, 101, 30, 30);
		ajouterClientPanel.add(lieuNaissanceLabel);
		
		JLabel adresseLabel = new JLabel("العنوان");
		adresseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adresseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adresseLabel.setBounds(678, 142, 60, 30);
		ajouterClientPanel.add(adresseLabel);
		
		JLabel phoneLabel = new JLabel("رقم الهاتف");
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneLabel.setBounds(658, 183, 80, 30);
		ajouterClientPanel.add(phoneLabel);
		
		JLabel permisLabel = new JLabel("رخصة السياقة رقم");
		permisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		permisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		permisLabel.setBounds(613, 226, 125, 30);
		ajouterClientPanel.add(permisLabel);
		
		JLabel datePermisLabel = new JLabel("الصادرة بتاريخ");
		datePermisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		datePermisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePermisLabel.setBounds(363, 226, 95, 30);
		ajouterClientPanel.add(datePermisLabel);
		
		JLabel lieuPermisLabel = new JLabel("في");
		lieuPermisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lieuPermisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lieuPermisLabel.setBounds(191, 226, 35, 30);
		ajouterClientPanel.add(lieuPermisLabel);
		
		nomEdit = new JTextField();
		nomEdit.setColumns(10);
		nomEdit.setBounds(430, 60, 208, 30);
		ajouterClientPanel.add(nomEdit);
		
		dateNaissanceEdit = new JDateChooser();
		dateNaissanceEdit.setDateFormatString("dd/MM/yyyy");
		dateNaissanceEdit.setBounds(468, 101, 178, 30);
		ajouterClientPanel.add(dateNaissanceEdit);
		
		adresseEdit = new JTextField();
		adresseEdit.setColumns(10);
		adresseEdit.setBounds(415, 142, 263, 30);
		ajouterClientPanel.add(adresseEdit);
		
		phoneEdit = new JTextField();
		phoneEdit.setColumns(10);
		phoneEdit.setBounds(470, 183, 178, 30);
		ajouterClientPanel.add(phoneEdit);
		
		lieuNaissanceEdit = new JTextField();
		lieuNaissanceEdit.setColumns(10);
		lieuNaissanceEdit.setBounds(227, 101, 178, 30);
		ajouterClientPanel.add(lieuNaissanceEdit);
		
		permisEdit = new JTextField();
		permisEdit.setColumns(10);
		permisEdit.setBounds(458, 226, 149, 30);
		ajouterClientPanel.add(permisEdit);
		
		datePermisEdit = new JDateChooser();
		datePermisEdit.setDateFormatString("dd/MM/yyyy");
		datePermisEdit.setBounds(230, 226, 128, 30);
		ajouterClientPanel.add(datePermisEdit);
		
		lieuPermisEdit = new JTextField();
		lieuPermisEdit.setColumns(10);
		lieuPermisEdit.setBounds(21, 226, 160, 30);
		ajouterClientPanel.add(lieuPermisEdit);
		
		
		JButton btnConfirmer = new JButton("CONFIRMER");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkFields()) {
					int choice = JOptionPane.showConfirmDialog(
			                null,
			                "Des champs nécessaires sont vides.",
			                "Empty fields",
			                JOptionPane.DEFAULT_OPTION);
				}else {
					Client c  = new Client(nomEdit.getText(),
							dateFormat.format(dateNaissanceEdit.getDate()),
							adresseEdit.getText(),
							phoneEdit.getText(),
							lieuNaissanceEdit.getText(),
							permisEdit.getText(),
							dateFormat.format(datePermisEdit.getDate()),
							lieuPermisEdit.getText(),
							"");
					try {
						if(nom == null) DatabaseService.insertClient(c);
						else DatabaseService.updateClient(nom,c);
							
						cpanel.showTable(cpanel.getAllClients());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnConfirmer.setBounds(21, 16, 100, 30);
		ajouterClientPanel.add(btnConfirmer);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ajouterClientPanel);
		
		
		//Fill data
		if(nom != null) {
			showClient(getClient(nom));
		}
}
	
	private Client getClient(String nom) throws ClassNotFoundException, SQLException {
		Client c = DatabaseService.getClient(nom);
		
		return c;
	}
	
	private void showClient(Client c) throws ParseException {
		Date dateNaissance = null, datePermis = null;
		try {
			dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(c.getDateNaissance());
			datePermis =  new SimpleDateFormat("dd/MM/yyyy").parse(c.getDatePermis());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nomEdit.setText(c.getNom());
		dateNaissanceEdit.setDate(dateNaissance);
		lieuNaissanceEdit.setText(c.getLieuNaissance());
		phoneEdit.setText(c.getPhone());
		permisEdit.setText(c.getPermis());
		datePermisEdit.setDate(datePermis);
		lieuPermisEdit.setText(c.getLieuPermis());
		adresseEdit.setText(c.getAdresse());
		
	}
	
	private boolean checkFields() {
		if(
			nomEdit.getText().equals("") ||
			dateFormat.format(dateNaissanceEdit.getDate()).equals("") ||
			adresseEdit.getText().equals("") ||
			phoneEdit.getText().equals("") ||
			lieuNaissanceEdit.getText().equals("") ||
			permisEdit.getText().equals("") ||
			dateFormat.format(datePermisEdit.getDate()).equals("") ||
			lieuPermisEdit.getText().equals("") 
		) return false;
	
		return true;
	}
	
}

