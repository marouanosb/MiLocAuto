package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import database.DatabaseService;
import models.Voiture;

public class AjouterVoitureWindow extends JFrame {

	private JPanel contentPane;
	private JTextField typeEdit;
	private JTextField classeEdit;
	private JTextField numEnregistrementEdit;
	private JTextField metrageEdit;
	private JTextField prixEdit;
	private JTextField marqueEdit;
	private JTextField immatriculationEdit;
	private JTextField metragePrecisEdit;
	private JTextField idVoitureEdit;

	
	public AjouterVoitureWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 768, 400);
		
		getContentPane().setLayout(null);
		
		JPanel ajouterVoiturePanel = new JPanel();
		ajouterVoiturePanel.setBounds(10, 10, 768, 400);
		ajouterVoiturePanel.setLayout(null);
		
		JLabel idVoitureLabel = new JLabel("تعريف السيارة :");
		idVoitureLabel.setBounds(596, 61, 150, 50);
		ajouterVoiturePanel.add(idVoitureLabel);
		idVoitureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idVoitureLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel typeLabel = new JLabel("النوع");
		typeLabel.setBounds(688, 122, 50, 30);
		ajouterVoiturePanel.add(typeLabel);
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel classeLabel = new JLabel("الطراز");
		classeLabel.setBounds(688, 163, 50, 30);
		ajouterVoiturePanel.add(classeLabel);
		classeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		classeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel numEnregistrementLabel = new JLabel("رقم التسجيل");
		numEnregistrementLabel.setBounds(646, 204, 90, 30);
		ajouterVoiturePanel.add(numEnregistrementLabel);
		numEnregistrementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numEnregistrementLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel metrageLabel = new JLabel("مؤشر السير");
		metrageLabel.setBounds(646, 245, 100, 30);
		ajouterVoiturePanel.add(metrageLabel);
		metrageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		metrageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel prixLabel = new JLabel("السعر");
		prixLabel.setBounds(688, 286, 50, 30);
		ajouterVoiturePanel.add(prixLabel);
		prixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prixLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel metragePrecisLabel = new JLabel("كلم محدد");
		metragePrecisLabel.setBounds(415, 245, 75, 30);
		ajouterVoiturePanel.add(metragePrecisLabel);
		metragePrecisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		metragePrecisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel marqueLabel = new JLabel("الصنف");
		marqueLabel.setBounds(440, 122, 50, 30);
		ajouterVoiturePanel.add(marqueLabel);
		marqueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marqueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel immatriculationLabel = new JLabel("رقم التسلسلي في الطراز");
		immatriculationLabel.setBounds(330, 163, 160, 30);
		ajouterVoiturePanel.add(immatriculationLabel);
		immatriculationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		immatriculationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		typeEdit = new JTextField();
		typeEdit.setBounds(500, 124, 178, 30);
		ajouterVoiturePanel.add(typeEdit);
		typeEdit.setColumns(10);
		
		classeEdit = new JTextField();
		classeEdit.setColumns(10);
		classeEdit.setBounds(500, 165, 178, 30);
		ajouterVoiturePanel.add(classeEdit);
		
		numEnregistrementEdit = new JTextField();
		numEnregistrementEdit.setColumns(10);
		numEnregistrementEdit.setBounds(458, 206, 178, 30);
		ajouterVoiturePanel.add(numEnregistrementEdit);
		
		metrageEdit = new JTextField();
		metrageEdit.setColumns(10);
		metrageEdit.setBounds(496, 247, 150, 30);
		ajouterVoiturePanel.add(metrageEdit);
		
		prixEdit = new JTextField();
		prixEdit.setColumns(10);
		prixEdit.setBounds(553, 288, 125, 30);
		ajouterVoiturePanel.add(prixEdit);
		
		marqueEdit = new JTextField();
		marqueEdit.setColumns(10);
		marqueEdit.setBounds(252, 124, 178, 30);
		ajouterVoiturePanel.add(marqueEdit);
		
		immatriculationEdit = new JTextField();
		immatriculationEdit.setColumns(10);
		immatriculationEdit.setBounds(142, 165, 178, 30);
		ajouterVoiturePanel.add(immatriculationEdit);
		
		metragePrecisEdit = new JTextField();
		metragePrecisEdit.setColumns(10);
		metragePrecisEdit.setBounds(227, 247, 178, 30);
		ajouterVoiturePanel.add(metragePrecisEdit);
		
		idVoitureEdit = new JTextField();
		idVoitureEdit.setColumns(10);
		idVoitureEdit.setBounds(500, 71, 90, 30);
		ajouterVoiturePanel.add(idVoitureEdit);
		
		JButton btnConfirmer = new JButton("CONFIRMER");
		btnConfirmer.setBounds(21, 16, 100, 30);
		ajouterVoiturePanel.add(btnConfirmer);
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voiture v = new Voiture(idVoitureEdit.getText(),
										typeEdit.getText(),
										classeEdit.getText(),
										numEnregistrementEdit.getText(),
										Integer.parseInt(metrageEdit.getText()),
										Integer.parseInt(prixEdit.getText()),
										marqueEdit.getText(),
										immatriculationEdit.getText(),
										Integer.parseInt(metragePrecisEdit.getText()),
										"Disponible");
				try {
					DatabaseService.insertVoiture(v);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ajouterVoiturePanel);
	}
}
