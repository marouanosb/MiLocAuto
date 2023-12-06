package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.DatabaseService;
import models.Client;
import models.Voiture;

public class ClientsPanel extends JPanel {

	private JTable clientsTable;
	private JTextField searchEdit;
	private Integer selectedRow = null;
	private ArrayList<Client> clients;
		
	public ClientsPanel() throws ClassNotFoundException, SQLException {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 768, 768);
		add(panel);
		panel.setLayout(null);
   
		String columns[]= {"NOM","TELEPHONE","PERMIS"};
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		dtm.setColumnIdentifiers(columns);
		clientsTable = new JTable();
		clientsTable.setModel(dtm);
		clientsTable.setBounds(10, 75, 748, 500);
		JScrollPane scrollPane= new JScrollPane(clientsTable);    
		scrollPane.setLocation(10, 75);
		scrollPane.setSize(748, 500);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		clientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        selectedRow = clientsTable.rowAtPoint(evt.getPoint());
		        
		    }
		});
		clientsTable.setDefaultEditor(Object.class, null);
		
		getAllClients();
		showTable(clients);
        
		
		searchEdit = new JTextField();
		searchEdit.setText("Recherche...");
		searchEdit.setToolTipText("Recherche...");
		searchEdit.setBounds(10, 25, 748, 30);
		panel.add(searchEdit);
		searchEdit.setColumns(10);
		
		ClientsPanel cpanel = this;
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AjouterClientWindow(null, cpanel).setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAjouter.setBounds(20, 586, 100, 30);
		panel.add(btnAjouter);
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedRow != null) {
					String selectedNom = (String) clientsTable.getValueAt(selectedRow,0);
					try {
						new AjouterClientWindow(selectedNom, cpanel).setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else System.out.println("Selectionnez d'abord.");
				
			}
		});
		btnModifier.setBounds(130, 586, 100, 30);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedRow != null) {
					String selectedNom = (String) clientsTable.getValueAt(selectedRow,0);
					try {
						DatabaseService.deleteClient(selectedNom);
						getAllClients();
						selectedRow = null;
						showTable(clients);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else System.out.println("Selectionnez d'abord.");
				
			}
		});
		btnSupprimer.setBounds(240, 586, 100, 30);
		panel.add(btnSupprimer);
		
		
		
	}
	
	void showTable(ArrayList<Client> clients){
		resetTable(clientsTable);
		for (Client c : clients) {
			String[] row = {c.getNom(),
					c.getPhone(),
					c.getPermis()};
			((DefaultTableModel) clientsTable.getModel()).addRow(row);
		}
	}
	
	private void resetTable(JTable table) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
	}
	
	public ArrayList<Client> getAllClients() throws ClassNotFoundException, SQLException {
		clients = DatabaseService.getAllClients();
		
		return clients;
	}

}
