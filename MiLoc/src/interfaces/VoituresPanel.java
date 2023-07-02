package interfaces;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VoituresPanel extends JPanel {
	
	private JTable voituresTable;
	private JTextField searchEdit;
	private Integer selectedRow = null;
		
	public VoituresPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 768, 768);
		add(panel);
		panel.setLayout(null);

		String data[][]={ {"S1","RENAULT","AAAAA","XXXX","loué"},    
                {"S2","RENAULT","BBBBBB","YYYY","loué"},    
                {"S3","RENAULT","CCCCC","ZZZZ","loué"}};   
		String columns[]= {"IDENTIFIANT","TYPE","MARQUE","CLASSE","ETAT"};
		voituresTable = new JTable(data,columns);
		voituresTable.setBounds(10, 75, 748, 500);
		JScrollPane scrollPane= new JScrollPane(voituresTable);    
		scrollPane.setLocation(10, 75);
		scrollPane.setSize(748, 500);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		voituresTable.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        selectedRow = voituresTable.rowAtPoint(evt.getPoint());
		        System.out.println((String) voituresTable.getValueAt(selectedRow,0));
		    }
		});
		voituresTable.setDefaultEditor(Object.class, null);
        
		
		searchEdit = new JTextField();
		searchEdit.setText("Recherche...");
		searchEdit.setToolTipText("Recherche...");
		searchEdit.setBounds(10, 25, 748, 30);
		panel.add(searchEdit);
		searchEdit.setColumns(10);
		
		JButton btnAjouter = new JButton("AJOUTER");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AjouterVoitureWindow().setVisible(true);
			}
		});
		btnAjouter.setBounds(20, 586, 100, 30);
		panel.add(btnAjouter);
		
		JButton btnModifier = new JButton("MODIFIER");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedRow != null) {
					new AjouterVoitureWindow().setVisible(true);
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
