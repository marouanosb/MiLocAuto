package interfaces;

import javax.swing.JPanel;

import com.toedter.calendar.*;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;

import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LocationPanel extends JPanel {
	public LocalDateTime now = LocalDateTime.now();
	
	
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
	private JTextField adresseEdit;
	private JTextField phoneEdit;
	private JTextField lieuNaissanceEdit;
	private JTextField permisEdit;
	private JTextField dureeEdit;
	public JTextField heurePriseEdit;
	private JTextField lieuPermisEdit;
	JDateChooser datePriseEdit;
	JDateChooser datePermisEdit;
	JDateChooser dateRemiseEdit;
	JDateChooser dateNaissanceEdit;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date dateP = null;
	
	private String type;
	private String classe;
	private String numEnregistrement;
	private String metrage;
	private String prix;
	private String marque;
	private String immatriculation;
	private String metragePrecis;
	private String nom;
	private String dateNaissance;
	private String adresse;
	private String phone;
	private String lieuNaissance;
	private String permis;
	private String datePrise;
	private String duree;
	private String datePermis;
	private String heurePrise;
	private String dateRemise;
	private String lieuPermis;

	/**
	 * Create the panel.
	 */
	public LocationPanel() {
		setLayout(null);
		setBounds(10, 10, 800, 853);
		
		
		JPanel locationPanel = new JPanel();
		locationPanel.setBounds(10, 10, 768, 768);
		locationPanel.setPreferredSize(getSize());
		locationPanel.setLayout(null);
		
		JLabel numLocLabel = new JLabel("عقد كراء رقم : XXXX");
		numLocLabel.setBounds(0, 0, 748, 50);
		locationPanel.add(numLocLabel);
		numLocLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		numLocLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel idVoitureLabel = new JLabel("تعريف السيارة :");
		idVoitureLabel.setBounds(596, 61, 150, 50);
		locationPanel.add(idVoitureLabel);
		idVoitureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idVoitureLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel typeLabel = new JLabel("النوع");
		typeLabel.setBounds(688, 122, 50, 30);
		locationPanel.add(typeLabel);
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel classeLabel = new JLabel("الطراز");
		classeLabel.setBounds(688, 163, 50, 30);
		locationPanel.add(classeLabel);
		classeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		classeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel numEnregistrementLabel = new JLabel("رقم التسجيل");
		numEnregistrementLabel.setBounds(646, 204, 90, 30);
		locationPanel.add(numEnregistrementLabel);
		numEnregistrementLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numEnregistrementLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel metrageLabel = new JLabel("مؤشر السير");
		metrageLabel.setBounds(646, 245, 100, 30);
		locationPanel.add(metrageLabel);
		metrageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		metrageLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel prixLabel = new JLabel("السعر");
		prixLabel.setBounds(688, 286, 50, 30);
		locationPanel.add(prixLabel);
		prixLabel.setHorizontalAlignment(SwingConstants.CENTER);
		prixLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel garantieLabel = new JLabel("مبلغ الضمان");
		garantieLabel.setBounds(458, 286, 85, 30);
		locationPanel.add(garantieLabel);
		garantieLabel.setHorizontalAlignment(SwingConstants.CENTER);
		garantieLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel passeportLabel = new JLabel("جواز السفر");
		passeportLabel.setBounds(230, 286, 75, 30);
		locationPanel.add(passeportLabel);
		passeportLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passeportLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel metragePrecisLabel = new JLabel("كلم محدد");
		metragePrecisLabel.setBounds(415, 245, 75, 30);
		locationPanel.add(metragePrecisLabel);
		metragePrecisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		metragePrecisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel marqueLabel = new JLabel("الصنف");
		marqueLabel.setBounds(440, 122, 50, 30);
		locationPanel.add(marqueLabel);
		marqueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		marqueLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel immatriculationLabel = new JLabel("رقم التسلسلي في الطراز");
		immatriculationLabel.setBounds(330, 163, 160, 30);
		locationPanel.add(immatriculationLabel);
		immatriculationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		immatriculationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		typeEdit = new JTextField();
		typeEdit.setHorizontalAlignment(SwingConstants.CENTER);
		typeEdit.setBounds(500, 124, 178, 30);
		locationPanel.add(typeEdit);
		typeEdit.setColumns(10);
		
		classeEdit = new JTextField();
		classeEdit.setHorizontalAlignment(SwingConstants.CENTER);
		classeEdit.setColumns(10);
		classeEdit.setBounds(500, 165, 178, 30);
		locationPanel.add(classeEdit);
		
		numEnregistrementEdit = new JTextField();
		numEnregistrementEdit.setHorizontalAlignment(SwingConstants.CENTER);
		numEnregistrementEdit.setColumns(10);
		numEnregistrementEdit.setBounds(458, 206, 178, 30);
		locationPanel.add(numEnregistrementEdit);
		
		metrageEdit = new JTextField();
		metrageEdit.setHorizontalAlignment(SwingConstants.CENTER);
		metrageEdit.setColumns(10);
		metrageEdit.setBounds(496, 247, 150, 30);
		locationPanel.add(metrageEdit);
		
		prixEdit = new JTextField();
		prixEdit.setHorizontalAlignment(SwingConstants.CENTER);
		prixEdit.setColumns(10);
		prixEdit.setBounds(553, 288, 125, 30);
		locationPanel.add(prixEdit);
		
		marqueEdit = new JTextField();
		marqueEdit.setHorizontalAlignment(SwingConstants.CENTER);
		marqueEdit.setColumns(10);
		marqueEdit.setBounds(252, 124, 178, 30);
		locationPanel.add(marqueEdit);
		
		immatriculationEdit = new JTextField();
		immatriculationEdit.setHorizontalAlignment(SwingConstants.CENTER);
		immatriculationEdit.setColumns(10);
		immatriculationEdit.setBounds(142, 165, 178, 30);
		locationPanel.add(immatriculationEdit);
		
		metragePrecisEdit = new JTextField();
		metragePrecisEdit.setHorizontalAlignment(SwingConstants.CENTER);
		metragePrecisEdit.setColumns(10);
		metragePrecisEdit.setBounds(227, 247, 178, 30);
		locationPanel.add(metragePrecisEdit);
		
		garantieEdit = new JTextField();
		garantieEdit.setHorizontalAlignment(SwingConstants.CENTER);
		garantieEdit.setColumns(10);
		garantieEdit.setBounds(315, 288, 133, 30);
		locationPanel.add(garantieEdit);
		
		passeportEdit = new JTextField();
		passeportEdit.setHorizontalAlignment(SwingConstants.CENTER);
		passeportEdit.setColumns(10);
		passeportEdit.setBounds(21, 288, 199, 30);
		locationPanel.add(passeportEdit);
		
		JLabel idClient = new JLabel("المستأجر :");
		idClient.setHorizontalAlignment(SwingConstants.CENTER);
		idClient.setFont(new Font("Tahoma", Font.BOLD, 16));
		idClient.setBounds(638, 339, 110, 50);
		locationPanel.add(idClient);
		
		JLabel nomLabel = new JLabel("اسم المستفيد");
		nomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomLabel.setBounds(633, 400, 105, 30);
		locationPanel.add(nomLabel);
		
		JLabel dateNaissanceLabel = new JLabel("تاريخ الميلاد");
		dateNaissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateNaissanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateNaissanceLabel.setBounds(648, 441, 90, 30);
		locationPanel.add(dateNaissanceLabel);
		
		JLabel adresseLabel = new JLabel("العنوان");
		adresseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adresseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adresseLabel.setBounds(678, 482, 60, 30);
		locationPanel.add(adresseLabel);
		
		JLabel phoneLabel = new JLabel("رقم الهاتف");
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneLabel.setBounds(658, 523, 80, 30);
		locationPanel.add(phoneLabel);
		
		JLabel permisLabel = new JLabel("رخصة السياقة رقم");
		permisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		permisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		permisLabel.setBounds(613, 564, 125, 30);
		locationPanel.add(permisLabel);
		
		JLabel datePriseLabel = new JLabel("التسليم بتاريخ");
		datePriseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		datePriseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePriseLabel.setBounds(638, 605, 100, 30);
		locationPanel.add(datePriseLabel);

		
		JLabel dureeLabel = new JLabel("لمدة");
		dureeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dureeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dureeLabel.setBounds(688, 646, 50, 30);
		locationPanel.add(dureeLabel);
		
		JLabel lieuNaissanceLabel = new JLabel("بـ");
		lieuNaissanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lieuNaissanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lieuNaissanceLabel.setBounds(418, 441, 30, 30);
		locationPanel.add(lieuNaissanceLabel);
		
		JLabel dateRemiseLabel = new JLabel("لتعود بتاريخ");
		dateRemiseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateRemiseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateRemiseLabel.setBounds(493, 646, 85, 30);
		locationPanel.add(dateRemiseLabel);
		
		JLabel heurePriseLabel = new JLabel("على الساعة");
		heurePriseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		heurePriseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		heurePriseLabel.setBounds(363, 605, 95, 30);
		locationPanel.add(heurePriseLabel);
		
		JLabel datePermisLabel = new JLabel("الصادرة بتاريخ");
		datePermisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		datePermisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePermisLabel.setBounds(363, 564, 95, 30);
		locationPanel.add(datePermisLabel);
		
		JLabel lieuPermisLabel = new JLabel("في");
		lieuPermisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lieuPermisLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lieuPermisLabel.setBounds(191, 564, 35, 30);
		locationPanel.add(lieuPermisLabel);
		
		nomEdit = new JTextField();
		nomEdit.setHorizontalAlignment(SwingConstants.CENTER);
		nomEdit.setColumns(10);
		nomEdit.setBounds(415, 400, 208, 30);
		locationPanel.add(nomEdit);
		
		adresseEdit = new JTextField();
		adresseEdit.setHorizontalAlignment(SwingConstants.CENTER);
		adresseEdit.setColumns(10);
		adresseEdit.setBounds(415, 482, 263, 30);
		locationPanel.add(adresseEdit);
		
		phoneEdit = new JTextField();
		phoneEdit.setHorizontalAlignment(SwingConstants.CENTER);
		phoneEdit.setColumns(10);
		phoneEdit.setBounds(470, 523, 178, 30);
		locationPanel.add(phoneEdit);
		
		dateNaissanceEdit = new JDateChooser();
		dateNaissanceEdit.setBounds(458, 441, 178, 30);
		dateNaissanceEdit.setDateFormatString("dd/MM/yyyy");
		locationPanel.add(dateNaissanceEdit);
		
		lieuNaissanceEdit = new JTextField();
		lieuNaissanceEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lieuNaissanceEdit.setColumns(10);
		lieuNaissanceEdit.setBounds(227, 441, 178, 30);
		locationPanel.add(lieuNaissanceEdit);
		
		permisEdit = new JTextField();
		permisEdit.setHorizontalAlignment(SwingConstants.CENTER);
		permisEdit.setColumns(10);
		permisEdit.setBounds(458, 564, 149, 30);
		locationPanel.add(permisEdit);
		
		
		datePriseEdit = new JDateChooser();
		datePriseEdit.setBounds(458, 605, 178, 30);
		datePriseEdit.setDateFormatString("dd/MM/yyyy");
		DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String currentDate = dtfDate.format(now);

		try {
			dateP = new SimpleDateFormat("dd/MM/yyyy").parse(currentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datePriseEdit.setDate(dateP);
		locationPanel.add(datePriseEdit);
		
		////////increment days
		// System.out.println(addDays(date,3));
		
		dureeEdit = new JTextField();
		dureeEdit.setHorizontalAlignment(SwingConstants.CENTER);
		dureeEdit.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            	//focus gained
            }

            
            public void focusLost(FocusEvent e) {
            	Date dateTmp = null;
				try {
					dateTmp = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat.format(datePriseEdit.getDate()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	Date dateR = addDays(dateTmp,Integer.parseInt(dureeEdit.getText()));
            	dateRemiseEdit.setDate(dateR);
            	
            }
        });
		dureeEdit.setBounds(588, 646, 90, 30);
		locationPanel.add(dureeEdit);
		
		dateRemiseEdit = new JDateChooser();
		dateRemiseEdit.setBounds(312, 646, 178, 30);
		dateRemiseEdit.setDateFormatString("dd/MM/yyyy");
		locationPanel.add(dateRemiseEdit);
		
		heurePriseEdit = new JTextField();
		heurePriseEdit.setHorizontalAlignment(SwingConstants.CENTER);
		heurePriseEdit.setColumns(10);
		heurePriseEdit.setBounds(230, 607, 128, 30);
		locationPanel.add(heurePriseEdit);
		setHeurePrise();
		
		datePermisEdit = new JDateChooser();
		datePermisEdit.setBounds(230, 564, 128, 30);
		datePermisEdit.setDateFormatString("dd/MM/yyyy");
		locationPanel.add(datePermisEdit);
		
		lieuPermisEdit = new JTextField();
		lieuPermisEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lieuPermisEdit.setColumns(10);
		lieuPermisEdit.setBounds(21, 566, 160, 30);
		locationPanel.add(lieuPermisEdit);
		
		
		
		JButton btnImprimer = new JButton("IMPRIMER");
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkFields()) {
					int choice = JOptionPane.showConfirmDialog(
			                null,
			                "Des champs nécessaires sont vides.",
			                "Empty fields",
			                JOptionPane.DEFAULT_OPTION);
				}
				else {
					try {
						try {
							imprimer();
						} catch (InvalidFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnImprimer.setBounds(21, 16, 100, 30);
		locationPanel.add(btnImprimer);
		
		
		String[] choices = {"S1","S2", "S3"};
		JComboBox idVoitureMenu = new JComboBox(choices);
		idVoitureMenu.setSelectedIndex(-1);
		idVoitureMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//fill with selection info
			}
		});
		idVoitureMenu.setBounds(500, 77, 83, 22);
		locationPanel.add(idVoitureMenu);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane(locationPanel);
		
		JButton btnReset = new JButton("↺");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFields();
			}
		});
		btnReset.setBounds(131, 16, 50, 30);
		btnReset.setFont(new Font("Dialog", Font.PLAIN, 18));
		locationPanel.add(btnReset);
		scrollPane.setBounds(10, 10, 768, 768);
		add(scrollPane);
	
		
	}
	
	
	
	private boolean checkFields() {
		if(typeEdit.getText().equals("") ||
		classeEdit.getText().equals("") ||
		numEnregistrementEdit.getText().equals("") ||
		metrageEdit.getText().equals("") ||
		prixEdit.getText().equals("") ||
		marqueEdit.getText().equals("") ||
		immatriculationEdit.getText().equals("") ||
		metragePrecisEdit.getText().equals("") ||
		nomEdit.getText().equals("") ||
		dateFormat.format(dateNaissanceEdit.getDate()).equals("") ||
		adresseEdit.getText().equals("") ||
		phoneEdit.getText().equals("") ||
		lieuNaissanceEdit.getText().equals("") ||
		permisEdit.getText().equals("") ||
		dateFormat.format(datePriseEdit.getDate()).equals("") ||
		dureeEdit.getText().equals("") ||
		dateFormat.format(datePermisEdit.getDate()).equals("") ||
		heurePriseEdit.getText().equals("") ||
		dateFormat.format(dateRemiseEdit.getDate()).equals("") ||
		lieuPermisEdit.getText().equals("")) {
			return false;
		}
			
		
		return true;
	}
	
	private void imprimer() throws IOException, InvalidFormatException {
		
		XWPFDocument doc = new XWPFDocument(OPCPackage.open("./src/milocsample.docx"));
		for (XWPFParagraph p : doc.getParagraphs()) {
		    List<XWPFRun> runs = p.getRuns();
		    if (runs != null) {
		        for (XWPFRun r : runs) {
		            String text = r.getText(0);
		            if (text != null) {
		            	text = text.replace("typeEdit", typeEdit.getText());
			            text = text.replace("classeEdit", classeEdit.getText());
			            text = text.replace("numEnregistrementEdit", numEnregistrementEdit.getText());
			            text = text.replace("metrageEdit", metrageEdit.getText());
			            text = text.replace("prixEdit", prixEdit.getText());
			            text = text.replace("marqueEdit", marqueEdit.getText());
			            text = text.replace("immatriculationEdit", immatriculationEdit.getText());
			            text = text.replace("metragePrecisEdit", metragePrecisEdit.getText());
			            text = text.replace("garantieEdit", garantieEdit.getText());
			            text = text.replace("passeportEdit", passeportEdit.getText());
			            text = text.replace("nomEdit", nomEdit.getText());
			            text = text.replace("dateNaissanceEdit", dateFormat.format(dateNaissanceEdit.getDate()));
			            text = text.replace("lieuNaissanceEdit", lieuNaissanceEdit.getText());
			            text = text.replace("phoneEdit", phoneEdit.getText());
			            text = text.replace("adresseEdit", adresseEdit.getText());
			            text = text.replace("dureeEdit", dureeEdit.getText());
			            text = text.replace("permisEdit", permisEdit.getText());
			            text = text.replace("datePermisEdit", dateFormat.format(datePermisEdit.getDate()));
			            text = text.replace("datePriseEdit", dateFormat.format(datePriseEdit.getDate()));
			            text = text.replace("heurePriseEdit", heurePriseEdit.getText());
			            text = text.replace("dateRemiseEdit", dateFormat.format(dateRemiseEdit.getDate()));
			            text = text.replace("lieuPermisEdit", lieuPermisEdit.getText());
		                r.setText(text, 0);
		            }
		        }
		    }
		}
		for (XWPFTable tbl : doc.getTables()) {
		   for (XWPFTableRow row : tbl.getRows()) {
		      for (XWPFTableCell cell : row.getTableCells()) {
		         for (XWPFParagraph p : cell.getParagraphs()) {
		            for (XWPFRun r : p.getRuns()) {
		              String text = r.getText(0);
		              if (text != null) {
		            	  text = text.replace("typeEdit", typeEdit.getText());
			              text = text.replace("classeEdit", classeEdit.getText());
			              text = text.replace("numEnregistrementEdit", numEnregistrementEdit.getText());
			              text = text.replace("metrageEdit", metrageEdit.getText());
			              text = text.replace("prixEdit", prixEdit.getText());
			              text = text.replace("marqueEdit", marqueEdit.getText());
			              text = text.replace("immatriculationEdit", immatriculationEdit.getText());
			              text = text.replace("metragePrecisEdit", metragePrecisEdit.getText());
			              text = text.replace("garantieEdit", garantieEdit.getText());
			              text = text.replace("passeportEdit", passeportEdit.getText());
			              text = text.replace("nomEdit", nomEdit.getText());
			              text = text.replace("dateNaissanceEdit", dateFormat.format(dateNaissanceEdit.getDate()));
			              text = text.replace("lieuNaissanceEdit", lieuNaissanceEdit.getText());
			              text = text.replace("phoneEdit", phoneEdit.getText());
			              text = text.replace("adresseEdit", adresseEdit.getText());
			              text = text.replace("dureeEdit", dureeEdit.getText());
			              text = text.replace("permisEdit", permisEdit.getText());
			              text = text.replace("datePermisEdit", dateFormat.format(datePermisEdit.getDate()));
			              text = text.replace("datePriseEdit", dateFormat.format(datePriseEdit.getDate()));
			              text = text.replace("heurePriseEdit", heurePriseEdit.getText());
			              text = text.replace("dateRemiseEdit", dateFormat.format(dateRemiseEdit.getDate()));
			              text = text.replace("lieuPermisEdit", lieuPermisEdit.getText());
			              r.setText(text, 0); 
		              }
		            }
		         }
		      }
		   }
		}
		File outfile = new File("./src/output.docx");
		outfile.getParentFile().mkdirs();
		doc.write(new FileOutputStream(outfile));
		
		String outputPath = System.getProperty("user.dir")+"/src";
		//gotoPATH
		gotoPath(outputPath);
		
		return;
	}
	
	private Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        
        return cal.getTime();
    }
	
	public void setHeurePrise() {
		DateTimeFormatter dtfHour = DateTimeFormatter.ofPattern("HH:mm");
		now = LocalDateTime.now();
		String currentHour = dtfHour.format(now);
		heurePriseEdit.setText(currentHour);
		
		return;
	}
	
	private void resetFields() {
		  typeEdit.setText("");
		  classeEdit.setText("");
		  numEnregistrementEdit.setText("");
		  metrageEdit.setText("");
		  prixEdit.setText("");
		  marqueEdit.setText("");
		  immatriculationEdit.setText("");
		  metragePrecisEdit.setText("");
		  garantieEdit.setText("");
		  passeportEdit.setText("");
		  nomEdit.setText("");
		  adresseEdit.setText("");
		  phoneEdit.setText("");
		  lieuNaissanceEdit.setText("");
		  permisEdit.setText("");
		  dureeEdit.setText("");
		  lieuPermisEdit.setText("");
		  setHeurePrise();
		  datePermisEdit.setCalendar(null);
		  dateRemiseEdit.setCalendar(null);
		  dateNaissanceEdit.setCalendar(null);
		
		return;
	}
	
	//GO TO SPECIFIED PATH
		public void gotoPath(String path) throws IOException {
			File file = new File(path);
			if (!file.exists()) {
				Files.createDirectories(Paths.get(path));
			}
			Desktop.getDesktop().open(file);
			
		}
	
	private void saveContrat() {
		
		
		return;
	}
}
