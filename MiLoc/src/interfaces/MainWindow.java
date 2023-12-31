package interfaces;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import interfaces.LocationPanel;
import interfaces.ReservationPanel;
import interfaces.RemisePanel;
import java.awt.Font;

import database.DatabaseCreation;
import database.DatabaseService;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//init database
					DatabaseCreation.createDB();
					
					
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MainWindow() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(0, 0, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		final JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled( false );
		splitPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(splitPane);
		
		JPanel buttonsPanel = new JPanel();
		splitPane.setLeftComponent(buttonsPanel);
		buttonsPanel.setPreferredSize(new Dimension(150, 768));
		
	
		JButton btnLocation = new JButton("LOCATION");
		btnLocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLocation.setLocation(0, 11);
		btnLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocationPanel locationPanel;
				try {
					locationPanel = new LocationPanel();
					locationPanel.setHeurePrise();
					splitPane.setRightComponent(locationPanel);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonsPanel.setLayout(null);
		btnLocation.setSize(150,50);
		buttonsPanel.add(btnLocation);
		
		final ReservationPanel reservationPanel = new ReservationPanel();
		
		JButton btnReservation = new JButton("RESERVATION");
		btnReservation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReservation.setLocation(0, 66);
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(reservationPanel);
			}
		});
		btnReservation.setSize(150,50);
		buttonsPanel.add(btnReservation);
		
		JButton btnRemise = new JButton("REMISE");
		btnRemise.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemise.setLocation(0, 121);
		btnRemise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemisePanel remisePanel;
				try {
					remisePanel = new RemisePanel();
					splitPane.setRightComponent(remisePanel);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRemise.setSize(150,50);
		buttonsPanel.add(btnRemise);
		
		
		
		JButton btnVoitures = new JButton("VOITURES");
		btnVoitures.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoitures.setBounds(0, 176, 150, 50);
		btnVoitures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoituresPanel voituresPanel;
				try {
					voituresPanel = new VoituresPanel();
					splitPane.setRightComponent(voituresPanel);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		buttonsPanel.add(btnVoitures);
		
		final AlertesPanel alertesPanel = new AlertesPanel();
		
		JButton btnAlertes = new JButton("ALERTES");
		btnAlertes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlertes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				splitPane.setRightComponent(alertesPanel);
			}
		});
		btnAlertes.setBounds(0, 286, 150, 50);
		buttonsPanel.add(btnAlertes);
		
		JButton btnClients = new JButton("CLIENTS");
		btnClients.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClients.setBounds(0, 231, 150, 50);
		btnClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientsPanel clientsPanel;
				try {
					clientsPanel = new ClientsPanel();
					splitPane.setRightComponent(clientsPanel);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonsPanel.add(btnClients);
		
		splitPane.setDividerSize(5);
		splitPane.setEnabled(false);	//disable the function of resizing divider
		
		JPanel changingPanel = new JPanel();
		splitPane.setRightComponent(changingPanel);
		changingPanel.setLayout(null);
		
	}
}
