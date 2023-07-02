package interfaces;

import java.awt.Graphics;

import javax.swing.JScrollPane;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import interfaces.RemiseContratWindow;

public class RemisePanel extends JPanel {
	private JTable contratTable;
	private JTextField searchEdit;
	private int selectedRow;
	/**
	 * Create the panel.
	 */
	
	
	public RemisePanel(){
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 768, 768);
		add(panel);
		panel.setLayout(null);

		String data[][]={ {"101","Amit","670000"},    
                {"102","Jai","780000"},    
                {"101","Sachin","700000"}};   
		String columns[]= {"CONTRAT N°","ِCLIENT","VOITURE"};
		contratTable = new JTable(data,columns);
		contratTable.setBounds(10, 75, 748, 500);
		JScrollPane scrollPane= new JScrollPane(contratTable);    
		scrollPane.setLocation(10, 75);
		scrollPane.setSize(748, 500);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		contratTable.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        selectedRow = contratTable.rowAtPoint(evt.getPoint());
		        System.out.println((String) contratTable.getValueAt(selectedRow,0));
		        new RemiseContratWindow().setVisible(true);
		    }
		});
		contratTable.setDefaultEditor(Object.class, null);
        
		
		searchEdit = new JTextField();
		searchEdit.setText("Recherche...");
		searchEdit.setToolTipText("Recherche...");
		searchEdit.setBounds(10, 25, 748, 30);
		panel.add(searchEdit);
		searchEdit.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(20, 586, 100, 30);
		panel.add(btnNewButton);
		
	}
}


