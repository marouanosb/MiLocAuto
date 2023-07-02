package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ClientsPanel extends JPanel {

	private JTable clientsTable;
	private JTextField searchEdit;
	private Integer selectedRow = null;
		
	public ClientsPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 768, 768);
		add(panel);
		panel.setLayout(null);

		String data[][]={ {"Amit","670000","101"},    
                {"Jai","780000","102"},    
                {"Sachin","700000","103"}};      
		String columns[]= {"NOM","TELEPHONE","PERMIS",};
		clientsTable = new JTable(data,columns);
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
		        System.out.println((String) clientsTable.getValueAt(selectedRow,0));
		    }
		});
		clientsTable.setDefaultEditor(Object.class, null);
        
		
		searchEdit = new JTextField();
		searchEdit.setText("Recherche...");
		searchEdit.setToolTipText("Recherche...");
		searchEdit.setBounds(10, 25, 748, 30);
		panel.add(searchEdit);
		searchEdit.setColumns(10);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterClientWindow().setVisible(true);
			}
		});
		btnAjouter.setBounds(20, 586, 100, 30);
		panel.add(btnAjouter);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedRow != null) {
					new AjouterClientWindow().setVisible(true);
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
					
				}
				else System.out.println("Selectionnez d'abord.");
				
			}
		});
		btnSupprimer.setBounds(240, 586, 100, 30);
		panel.add(btnSupprimer);
		
	}

}
