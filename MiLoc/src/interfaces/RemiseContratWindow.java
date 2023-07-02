package interfaces;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import interfaces.LocationPanel;
import models.Contrat;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class RemiseContratWindow extends JFrame {

	private JTextField typeEdit;
	private JTextField classeEdit;
	private JTextField numEnregistrementEdit;
	private JTextField metrageEdit;
	private JTextField prixEdit;
	private JTextField marqueEdit;
	private JTextField immatriculationEdit;
	private JTextField metragePrecisEdit;
	private JTextField garantieEdit;
	private JTextField passeportEdit;
	private JTextField nomEdit;
	private JTextField dateNaissanceEdit;
	private JTextField adresseEdit;
	private JTextField phoneEdit;
	private JTextField lieuNaissanceEdit;
	private JTextField permisEdit;
	private JTextField datePriseEdit;
	private JTextField dureeEdit;
	private JTextField datePermisEdit;
	private JTextField heurePriseEdit;
	private JTextField dateRemiseEdit;
	private JTextField lieuPermisEdit;
	
	private JPanel contentPane;
	
	private Contrat contrat;
	private JTextField idVoitureEdit;
	private JTextField metrageRetourEdit;
	private JTextField dateRetourEdit;
	private JTextField heureRetourEdit;
	private JTextField prixExtraEdit;

	public RemiseContratWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(10, 10, 800, 953);
		
		
		
		JPanel remiseContratPanel = new JPanel();
		remiseContratPanel.setBounds(0, 0, 768, 768);
		remiseContratPanel.setPreferredSize(getSize());
		remiseContratPanel.setLayout(null);
		
		JLabel numLocLabel = new JLabel("عقد كراء رقم : XXXX");
		numLocLabel.setBounds(0, 0, 748, 50);
		remiseContratPanel.add(numLocLabel);
		numLocLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		numLocLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel idVoitureLabel = new JLabel("تعريف السيارة :");
		idVoitureLabel.setBounds(596, 61, 150, 50);
		remiseContratPanel.add(idVoitureLabel);
		idVoitureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idVoitureLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel typeLabel = new JLabel("النوع");
		typeLabel.setBounds(688, 122, 50, 30);
		remiseContratPanel.add(typeLabel);
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel classeLabel = new JLabel("الطراز");
		classeLabel.setBounds(688, 163, 50, 30);
		remiseContratPanel.add(classeLabel);
		classeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		classeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel numEnregistrementLabel = new JLabel("رقم التسجيل");
		numEnregistrementLabel.setBounds(646, 204, 90, 30);
		remiseContratPanel.add(numEnregistrementLabel);
		numEnregistrementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numEnregistrementLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel metrageLabel = new JLabel("مؤشر السير");
		metrageLabel.setBounds(646, 245, 100, 30);
		remiseContratPanel.add(metrageLabel);
		metrageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		metrageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel prixLabel = new JLabel("السعر");
		prixLabel.setBounds(688, 286, 50, 30);
		remiseContratPanel.add(prixLabel);
		prixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prixLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel garantieLabel = new JLabel("مبلغ الضمان");
		garantieLabel.setBounds(458, 286, 85, 30);
		remiseContratPanel.add(garantieLabel);
		garantieLabel.setHorizontalAlignment(SwingConstants.CENTER);
		garantieLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel passeportLabel = new JLabel("جواز السفر");
		passeportLabel.setBounds(230, 286, 75, 30);
		remiseContratPanel.add(passeportLabel);
		passeportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passeportLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel metragePrecisLabel = new JLabel("كلم محدد");
		metragePrecisLabel.setBounds(415, 245, 75, 30);
		remiseContratPanel.add(metragePrecisLabel);
		metragePrecisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		metragePrecisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel marqueLabel = new JLabel("الصنف");
		marqueLabel.setBounds(440, 122, 50, 30);
		remiseContratPanel.add(marqueLabel);
		marqueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marqueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel immatriculationLabel = new JLabel("رقم التسلسلي في الطراز");
		immatriculationLabel.setBounds(330, 163, 160, 30);
		remiseContratPanel.add(immatriculationLabel);
		immatriculationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		immatriculationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		typeEdit = new JTextField();
		typeEdit.setBounds(500, 124, 178, 30);
		remiseContratPanel.add(typeEdit);
		typeEdit.setColumns(10);
		
		classeEdit = new JTextField();
		classeEdit.setColumns(10);
		classeEdit.setBounds(500, 165, 178, 30);
		remiseContratPanel.add(classeEdit);
		
		numEnregistrementEdit = new JTextField();
		numEnregistrementEdit.setColumns(10);
		numEnregistrementEdit.setBounds(458, 206, 178, 30);
		remiseContratPanel.add(numEnregistrementEdit);
		
		metrageEdit = new JTextField();
		metrageEdit.setColumns(10);
		metrageEdit.setBounds(496, 247, 150, 30);
		remiseContratPanel.add(metrageEdit);
		
		prixEdit = new JTextField();
		prixEdit.setColumns(10);
		prixEdit.setBounds(553, 288, 125, 30);
		remiseContratPanel.add(prixEdit);
		
		marqueEdit = new JTextField();
		marqueEdit.setColumns(10);
		marqueEdit.setBounds(252, 124, 178, 30);
		remiseContratPanel.add(marqueEdit);
		
		immatriculationEdit = new JTextField();
		immatriculationEdit.setColumns(10);
		immatriculationEdit.setBounds(142, 165, 178, 30);
		remiseContratPanel.add(immatriculationEdit);
		
		metragePrecisEdit = new JTextField();
		metragePrecisEdit.setColumns(10);
		metragePrecisEdit.setBounds(227, 247, 178, 30);
		remiseContratPanel.add(metragePrecisEdit);
		
		garantieEdit = new JTextField();
		garantieEdit.setColumns(10);
		garantieEdit.setBounds(315, 288, 133, 30);
		remiseContratPanel.add(garantieEdit);
		
		passeportEdit = new JTextField();
		passeportEdit.setColumns(10);
		passeportEdit.setBounds(21, 288, 199, 30);
		remiseContratPanel.add(passeportEdit);
		
		JLabel idClient = new JLabel("المستأجر :");
		idClient.setHorizontalAlignment(SwingConstants.CENTER);
		idClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		idClient.setBounds(638, 339, 110, 50);
		remiseContratPanel.add(idClient);
		
		JLabel nomLabel = new JLabel("اسم المستفيد");
		nomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomLabel.setBounds(633, 400, 105, 30);
		remiseContratPanel.add(nomLabel);
		
		JLabel dateNaissanceLabel = new JLabel("تاريخ الميلاد");
		dateNaissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateNaissanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateNaissanceLabel.setBounds(648, 441, 90, 30);
		remiseContratPanel.add(dateNaissanceLabel);
		
		JLabel adresseLabel = new JLabel("العنوان");
		adresseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adresseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adresseLabel.setBounds(678, 482, 60, 30);
		remiseContratPanel.add(adresseLabel);
		
		JLabel phoneLabel = new JLabel("رقم الهاتف");
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneLabel.setBounds(658, 523, 80, 30);
		remiseContratPanel.add(phoneLabel);
		
		JLabel permisLabel = new JLabel("رخصة السياقة رقم");
		permisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		permisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		permisLabel.setBounds(613, 564, 125, 30);
		remiseContratPanel.add(permisLabel);
		
		JLabel datePriseLabel = new JLabel("التسليم بتاريخ");
		datePriseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		datePriseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePriseLabel.setBounds(638, 605, 100, 30);
		remiseContratPanel.add(datePriseLabel);
		
		JLabel dureeLabel = new JLabel("لمدة");
		dureeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dureeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dureeLabel.setBounds(688, 646, 50, 30);
		remiseContratPanel.add(dureeLabel);
		
		JLabel lieuNaissanceLabel = new JLabel("بـ");
		lieuNaissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lieuNaissanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lieuNaissanceLabel.setBounds(418, 441, 30, 30);
		remiseContratPanel.add(lieuNaissanceLabel);
		
		JLabel dateRemiseLabel = new JLabel("لتعود بتاريخ");
		dateRemiseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateRemiseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateRemiseLabel.setBounds(493, 646, 85, 30);
		remiseContratPanel.add(dateRemiseLabel);
		
		JLabel heurePriseLabel = new JLabel("على الساعة");
		heurePriseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heurePriseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		heurePriseLabel.setBounds(363, 605, 95, 30);
		remiseContratPanel.add(heurePriseLabel);
		
		JLabel datePermisLabel = new JLabel("الصادرة بتاريخ");
		datePermisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		datePermisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePermisLabel.setBounds(363, 564, 95, 30);
		remiseContratPanel.add(datePermisLabel);
		
		JLabel lieuPermisLabel = new JLabel("في");
		lieuPermisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lieuPermisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lieuPermisLabel.setBounds(191, 564, 35, 30);
		remiseContratPanel.add(lieuPermisLabel);
		
		nomEdit = new JTextField();
		nomEdit.setColumns(10);
		nomEdit.setBounds(415, 400, 208, 30);
		remiseContratPanel.add(nomEdit);
		
		dateNaissanceEdit = new JTextField();
		dateNaissanceEdit.setColumns(10);
		dateNaissanceEdit.setBounds(468, 441, 178, 30);
		remiseContratPanel.add(dateNaissanceEdit);
		
		adresseEdit = new JTextField();
		adresseEdit.setColumns(10);
		adresseEdit.setBounds(415, 482, 263, 30);
		remiseContratPanel.add(adresseEdit);
		
		phoneEdit = new JTextField();
		phoneEdit.setColumns(10);
		phoneEdit.setBounds(470, 523, 178, 30);
		remiseContratPanel.add(phoneEdit);
		
		lieuNaissanceEdit = new JTextField();
		lieuNaissanceEdit.setColumns(10);
		lieuNaissanceEdit.setBounds(227, 441, 178, 30);
		remiseContratPanel.add(lieuNaissanceEdit);
		
		permisEdit = new JTextField();
		permisEdit.setColumns(10);
		permisEdit.setBounds(458, 564, 149, 30);
		remiseContratPanel.add(permisEdit);
		
		datePriseEdit = new JTextField();
		datePriseEdit.setColumns(10);
		datePriseEdit.setBounds(458, 605, 178, 30);
		remiseContratPanel.add(datePriseEdit);
		
		dureeEdit = new JTextField();
		dureeEdit.setColumns(10);
		dureeEdit.setBounds(588, 646, 90, 30);
		remiseContratPanel.add(dureeEdit);
		
		datePermisEdit = new JTextField();
		datePermisEdit.setColumns(10);
		datePermisEdit.setBounds(230, 566, 128, 30);
		remiseContratPanel.add(datePermisEdit);
		
		heurePriseEdit = new JTextField();
		heurePriseEdit.setColumns(10);
		heurePriseEdit.setBounds(230, 607, 128, 30);
		remiseContratPanel.add(heurePriseEdit);
		
		dateRemiseEdit = new JTextField();
		dateRemiseEdit.setColumns(10);
		dateRemiseEdit.setBounds(312, 648, 178, 30);
		remiseContratPanel.add(dateRemiseEdit);
		
		lieuPermisEdit = new JTextField();
		lieuPermisEdit.setColumns(10);
		lieuPermisEdit.setBounds(21, 566, 160, 30);
		remiseContratPanel.add(lieuPermisEdit);
		
		JButton btnImprimer = new JButton("IMPRIMER");
		btnImprimer.setBounds(21, 16, 100, 30);
		remiseContratPanel.add(btnImprimer);
		
		JScrollPane scrollPane = new JScrollPane(remiseContratPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		idVoitureEdit = new JTextField();
		idVoitureEdit.setColumns(10);
		idVoitureEdit.setBounds(503, 72, 90, 30);
		remiseContratPanel.add(idVoitureEdit);
		
		JLabel lineLabel = new JLabel("__________________________________________________________________________________________");
		lineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lineLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lineLabel.setBounds(21, 687, 727, 30);
		remiseContratPanel.add(lineLabel);
		
		JLabel metrageRetourLabel = new JLabel("مؤشر السير عند الرجوع");
		metrageRetourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		metrageRetourLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		metrageRetourLabel.setBounds(588, 730, 150, 30);
		remiseContratPanel.add(metrageRetourLabel);
		
		metrageRetourEdit = new JTextField();
		metrageRetourEdit.setColumns(10);
		metrageRetourEdit.setBounds(428, 730, 150, 30);
		remiseContratPanel.add(metrageRetourEdit);
		
		JLabel dateRetourLabel = new JLabel("تاريخ الرجوع");
		dateRetourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateRetourLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateRetourLabel.setBounds(653, 770, 85, 30);
		remiseContratPanel.add(dateRetourLabel);
		
		dateRetourEdit = new JTextField();
		dateRetourEdit.setColumns(10);
		dateRetourEdit.setBounds(468, 770, 178, 30);
		remiseContratPanel.add(dateRetourEdit);
		
		JLabel heureRetourLabel = new JLabel("على الساعة");
		heureRetourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heureRetourLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		heureRetourLabel.setBounds(363, 770, 85, 30);
		remiseContratPanel.add(heureRetourLabel);
		
		heureRetourEdit = new JTextField();
		heureRetourEdit.setColumns(10);
		heureRetourEdit.setBounds(180, 770, 178, 30);
		remiseContratPanel.add(heureRetourEdit);
		
		JLabel prixExtraLabel = new JLabel("سعر الكيلومتر الزائد");
		prixExtraLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prixExtraLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prixExtraLabel.setBounds(252, 730, 125, 30);
		remiseContratPanel.add(prixExtraLabel);
		
		prixExtraEdit = new JTextField();
		prixExtraEdit.setColumns(10);
		prixExtraEdit.setBounds(117, 730, 125, 30);
		remiseContratPanel.add(prixExtraEdit);
		
		JButton btnConfirmer = new JButton("CONFIRMER");
		btnConfirmer.setBounds(353, 830, 100, 30);
		remiseContratPanel.add(btnConfirmer);
		scrollPane.setBounds(10, 10, 768, 768);
		setContentPane(scrollPane);
	}
}
