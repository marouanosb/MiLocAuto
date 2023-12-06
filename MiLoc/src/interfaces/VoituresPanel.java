package interfaces;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.DatabaseService;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import models.*;

public class VoituresPanel extends JPanel {
	
	private JTable voituresTable = new JTable();;
	private JTextField searchEdit;
	private Integer selectedRow = null;
	private ArrayList<Voiture> voitures;
		
	public VoituresPanel() throws ClassNotFoundException, SQLException {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 768, 768);
		add(panel);
		panel.setLayout(null);
 
		String columns[]= {"ID","TYPE","MARQUE","CLASSE","ETAT"};
		DefaultTableModel dtm = new DefaultTableModel(0, 0);
		dtm.setColumnIdentifiers(columns);
		voituresTable.setModel(dtm);
		voituresTable.setBounds(10, 75, 748, 500);
		JScrollPane scrollPane= new JScrollPane(voituresTable);    
		scrollPane.setLocation(10, 75);
		scrollPane.setSize(748, 500);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		getAllVoitures();
		showTable(voitures);
		
		voituresTable.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        selectedRow = voituresTable.rowAtPoint(evt.getPoint());
		    }
		});
		voituresTable.setDefaultEditor(Object.class, null);
        
		
		searchEdit = new JTextField();
		searchEdit.setText("Recherche...");
		searchEdit.setToolTipText("Recherche...");
		searchEdit.setBounds(10, 25, 748, 30);
		panel.add(searchEdit);
		searchEdit.setColumns(10);
		
		VoituresPanel vpanel = this;
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AjouterVoitureWindow(null, vpanel).setVisible(true);
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
					String selectedId = (String) voituresTable.getValueAt(selectedRow,0);
					try {
						new AjouterVoitureWindow(selectedId, vpanel).setVisible(true);
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
					String selectedId = (String) voituresTable.getValueAt(selectedRow,0);
					try {
						DatabaseService.deleteVoiture(selectedId);
						getAllVoitures();
						selectedRow = null;
						showTable(voitures);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnSupprimer.setBounds(240, 586, 100, 30);
		panel.add(btnSupprimer);
	}
	
	void showTable(ArrayList<Voiture> voitures){
		resetTable(voituresTable);
		for (Voiture v : voitures) {
			String[] row = {v.getId(),
					v.getType(),
					v.getMarque(),
					v.getClasse(),
					v.getEtat()};
			((DefaultTableModel) voituresTable.getModel()).addRow(row);
		}
	}
	
	private void resetTable(JTable table) {
		((DefaultTableModel) table.getModel()).setRowCount(0);
	}
	
	public ArrayList<Voiture> getAllVoitures() throws ClassNotFoundException, SQLException {
		voitures = DatabaseService.getAllVoitures();
		
		return voitures;
	}
}
