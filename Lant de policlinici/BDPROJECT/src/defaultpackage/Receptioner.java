package defaultpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import defaultpackage.Constants.Colors;
import defaultpackage.Medic.AdminListener;
import defaultpackage.Medic.LogOutListener;
import defaultpackage.Medic.SuperadminListener;

public class Receptioner extends ConClass {
	Receptioner a;

	private JButton datePers;
	private JPanel datePersPanel;
	private JButton programare;
	private JPanel programarePanel;

	private JButton inregistrarePacient;
	private JPanel inregistrarePacientPanel;

	DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	Format timeFormat = new SimpleDateFormat("HH:mm:ss");
	JFormattedTextField dataField = new JFormattedTextField(format);
	JFormattedTextField startTimeField = new JFormattedTextField(timeFormat);
	JFormattedTextField endTimeField = new JFormattedTextField(timeFormat);

	// private JTextField dataField;
	private JLabel dataLabel;
	// private JTextField startTimeField;
	private JLabel startTimeLabel;
	// private JTextField endTimeField;
	private JLabel endTimeLabel;
	private JTextField CNPmedicField;
	private JLabel CNPmedicLabel;
	private JLabel CNPPacLabel;
	private JTextField CNPPacField;

	private JPanel dataPanel;
	private JPanel startTimePanel;
	private JPanel endTimePanel;
	private JPanel CNPmedicPanel;

	private JPanel emitereBonPanel;
	private JButton emitereBon;

	private JPanel dp;
	private SpringLayout slPanel;
	private JLabel titleLabel;
	private JPanel titlePanel;
	private String cnp;

	private JLabel serviciiMedicaleLabel;
	private JTextField serviciiMedicaleField;

	private JPanel cnpP;
	private JPanel numeP;
	private JPanel prenumeP;
	private JPanel adresaP;
	private JPanel telefonP;
	private JPanel emailP;
	private JPanel contP;
	private JPanel contractP;
	private JPanel functieP;
	private JPanel dataP;
	private JButton finishButton;

	private JLabel numeLabel;
	private JTextField numeField;
	private JLabel prenumeLabel;
	private JTextField prenumeField;
	private JLabel CNPLabel;
	private JTextField CNPField;

	private JPanel idUnitPanel;
	private JLabel idUnitButton;
	private TextField idUnitField;
	private JButton verificareButton;

	private JPanel[] serviciiPanelArray = new JPanel[20];
	private JButton[] serviciiButtonArray = new JButton[20];
	private JTextField[] serviciiFieldArray = new JTextField[20];
	private Integer[] serviciiIdArray = new Integer[20];
	private Integer nrOfServicies = 0;

	private String ButonApasat;

	private JButton FAILED = new JButton("FAILED");
	private JButton Finish = new JButton("Finish");

	private JButton superadminButton;
	private JPanel superadminButtonPanel;

	private JButton adminButton;
	private JPanel adminButtonPanel;

	private JButton logOut;
	private JPanel logOutPanel;

	public Receptioner(String cnp, boolean admin, boolean superadmin) {
		this.init();
		this.a = this;
		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new GridLayout(1, 2));
		this.cnp = cnp;

		leftPanel = new JPanel();
		slPanel = new SpringLayout();
		leftPanel.setLayout(slPanel);

		rightPanel = new JPanel();
		rightPanel.setLayout(new SpringLayout());

		titleLabel = new JLabel(" Receptioner ", SwingConstants.CENTER);
		titlePanel = new JPanel();
		titleLabel.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		titleLabel.setFont(Constants.Fonts.font_title);
		titleLabel.setBackground(Constants.Colors.blue_dark);
		titleLabel.setOpaque(true);
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlePanel.setBackground(Constants.Colors.frame_color_inspector);
		titlePanel.add(titleLabel);
		leftPanel.add(titlePanel);

		logOut = new JButton("  Log Out  ");
		logOut.addActionListener(new LogOutListener());
		logOutPanel = new JPanel();
		logOut.setFont(Constants.Fonts.font_button);
		logOutPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, logOutPanel, 0, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, logOutPanel, 280, SpringLayout.WEST, leftPanel);
		logOutPanel.setBackground(Constants.Colors.frame_color_inspector);
		logOutPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		logOutPanel.add(logOut);
		logOut.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		logOut.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(logOutPanel);

		if (superadmin == true) {
			superadminButton = new JButton("  superadmin  ");
			superadminButton.addActionListener(new SuperadminListener());
			superadminButtonPanel = new JPanel();
			superadminButton.setFont(Constants.Fonts.font_button);
			superadminButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, superadminButtonPanel, 130, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, superadminButtonPanel, 200, SpringLayout.WEST, leftPanel);
			superadminButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			superadminButtonPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			superadminButtonPanel.add(superadminButton);
			superadminButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			superadminButton.setBackground(Constants.Colors.blue_dark);

			leftPanel.add(superadminButtonPanel);
		}

		if (admin == true) {
			adminButton = new JButton(" admin  ");
			adminButton.addActionListener(new AdminListener());
			adminButtonPanel = new JPanel();
			adminButton.setFont(Constants.Fonts.font_button);
			adminButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, adminButtonPanel, 130, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, adminButtonPanel, 200, SpringLayout.WEST, leftPanel);
			adminButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			adminButtonPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			adminButtonPanel.add(adminButton);
			adminButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			adminButton.setBackground(Constants.Colors.blue_dark);

			leftPanel.add(adminButtonPanel);
		}

		datePers = new JButton("  vizualizeaza date personale  ");
		datePers.addActionListener(new VisualDatePersListener());
		datePersPanel = new JPanel();
		datePers.setFont(Constants.Fonts.font_button);
		datePersPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, datePersPanel, 200, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, datePersPanel, 50, SpringLayout.WEST, leftPanel);
		datePersPanel.setBackground(Constants.Colors.frame_color_inspector);
		datePersPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		datePersPanel.add(datePers);
		datePers.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		datePers.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(datePersPanel);

		programare = new JButton("Creeare Programare ");
		programare.addActionListener(new VisualProgramareListener());
		programarePanel = new JPanel();
		programare.setFont(Constants.Fonts.font_button);
		programarePanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, programarePanel, 300, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, programarePanel, 50, SpringLayout.WEST, leftPanel);
		programarePanel.setBackground(Constants.Colors.frame_color_inspector);
		programarePanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		programarePanel.add(programare);
		programare.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		programare.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(programarePanel);

		idUnitButton = new JLabel("Unitate:");
		idUnitPanel = new JPanel();
		idUnitButton.setFont(Constants.Fonts.font_button);
		idUnitPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, idUnitPanel, 400, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, idUnitPanel, 50, SpringLayout.WEST, leftPanel);
		idUnitPanel.setBackground(Constants.Colors.frame_color_inspector);
		idUnitPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		idUnitPanel.add(idUnitButton);
		idUnitButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		idUnitButton.setBackground(Constants.Colors.blue_dark);

		idUnitField = new TextField();
		idUnitField.setFont(Constants.Fonts.font_input);
		idUnitPanel.add(idUnitField);
		leftPanel.add(idUnitPanel);

		inregistrarePacient = new JButton("Inregistrare Pacient");
		inregistrarePacient.addActionListener(new RegisterPacient());
		inregistrarePacientPanel = new JPanel();
		inregistrarePacient.setFont(Constants.Fonts.font_button);
		inregistrarePacientPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, inregistrarePacientPanel, 500, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, inregistrarePacientPanel, 50, SpringLayout.WEST, leftPanel);
		inregistrarePacientPanel.setBackground(Constants.Colors.frame_color_inspector);
		inregistrarePacientPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		inregistrarePacientPanel.add(inregistrarePacient);
		inregistrarePacient.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		inregistrarePacient.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(inregistrarePacientPanel);

		leftPanel.setBackground(Constants.Colors.frame_color_inspector);
		leftPanel.setVisible(true);

		rightPanel.setBackground(Constants.Colors.frame_color_inspector);
		this.add(leftPanel);
		this.add(rightPanel);
		this.validate();
		this.repaint();

	}

	private class VisualDatePersListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10, 1, 10, 10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));
			rightPanel.removeAll();
			ResultSet rs;

			try {
				rs = SqlProcedures.getDatePersonale((Connection) con, (String) cnp);
				while (rs.next()) {

					cnpP = new JPanel();
					cnpP.setLayout(new FlowLayout());
					JLabel l = new JLabel("CNP: " + rs.getString("CNP"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					cnpP.add(l);
					cnpP.setBackground(Constants.Colors.date_pers);
					cnpP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(cnpP);

					numeP = new JPanel();
					numeP.setLayout(new FlowLayout());
					l = new JLabel("Nume: " + rs.getString("nume"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					numeP.add(l);
					numeP.setBackground(Constants.Colors.date_pers);
					numeP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(numeP);

					prenumeP = new JPanel();
					prenumeP.setLayout(new FlowLayout());
					l = new JLabel("Prenume: " + rs.getString("prenume"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					prenumeP.add(l);
					prenumeP.setBackground(Constants.Colors.date_pers);
					prenumeP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(prenumeP);

					adresaP = new JPanel();
					adresaP.setLayout(new FlowLayout());
					l = new JLabel("Adresa: " + rs.getString("adresa"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					adresaP.add(l);
					adresaP.setBackground(Constants.Colors.date_pers);
					adresaP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(adresaP);

					telefonP = new JPanel();
					telefonP.setLayout(new FlowLayout());
					l = new JLabel("Telefon: " + rs.getString("telefon"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					telefonP.add(l);
					telefonP.setBackground(Constants.Colors.date_pers);
					telefonP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(telefonP);

					emailP = new JPanel();
					emailP.setLayout(new FlowLayout());
					l = new JLabel("email: " + rs.getString("email"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					emailP.add(l);
					emailP.setBackground(Constants.Colors.date_pers);
					emailP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(emailP);

					contP = new JPanel();
					contP.setLayout(new FlowLayout());
					l = new JLabel("Cont IBAN: " + rs.getString("cont_IBAN"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					contP.add(l);
					contP.setBackground(Constants.Colors.date_pers);
					contP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(contP);

					contractP = new JPanel();
					contractP.setLayout(new FlowLayout());
					l = new JLabel("Nr. Contract: " + rs.getString("nr_contract"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					contractP.add(l);
					contractP.setBackground(Constants.Colors.date_pers);
					contractP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(contractP);

					functieP = new JPanel();
					functieP.setLayout(new FlowLayout());
					l = new JLabel("Functie: " + rs.getString("functie"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					functieP.add(l);
					functieP.setBackground(Constants.Colors.date_pers);
					functieP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(functieP);

					dataP = new JPanel();
					dataP.setLayout(new FlowLayout());
					l = new JLabel("Data angajarii: " + rs.getDate("data_angajarii"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					dataP.add(l);
					dataP.setBackground(Constants.Colors.date_pers);
					dataP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(dataP);

				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			slPanel.putConstraint(SpringLayout.NORTH, dp, 50, SpringLayout.NORTH, rightPanel);
			slPanel.putConstraint(SpringLayout.WEST, dp, 650, SpringLayout.WEST, rightPanel);
			rightPanel.add(dp);
			a.validate();
			a.repaint();
		}

	}

	private class VisualProgramareListener implements ActionListener {
		private String idUnit;

		public void actionPerformed(ActionEvent e) {
			rightPanel.removeAll();

			idUnit = idUnitField.getText();

			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10, 1, 10, 10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));
			JScrollPane scrollPane = new JScrollPane(dp);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBackground(Constants.Colors.frame_color_inspector);
			scrollPane.setPreferredSize(new Dimension(700, 550));

			dataLabel = new JLabel("Data :");
			dataLabel.setFont(Constants.Fonts.font_label);
			dp.add(dataLabel);
			dataField = new JFormattedTextField();
			dataField.setFont(Constants.Fonts.font_input);
			dataField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(dataField);

			startTimeLabel = new JLabel("Start-Time :");
			startTimeLabel.setFont(Constants.Fonts.font_label);
			dp.add(startTimeLabel);
			startTimeField = new JFormattedTextField();
			startTimeField.setFont(Constants.Fonts.font_input);
			startTimeField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(startTimeField);

			CNPPacLabel = new JLabel("CNP_pacient :");
			CNPPacLabel.setFont(Constants.Fonts.font_label);
			dp.add(CNPPacLabel);
			CNPPacField = new JTextField();
			CNPPacField.setFont(Constants.Fonts.font_input);
			CNPPacField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(CNPPacField);

			Integer[] idServ = new Integer[20];
			nrOfServicies = 0;
			Integer id = Integer.parseInt(idUnit);
			ResultSet rs;
			try {
				rs = SqlProcedures.getServiciiUnitate((Connection) con, id);
				while (rs.next()) {

					JPanel butoane = new JPanel();
					butoane.setLayout(new GridLayout(1, 2));
					butoane.setBackground(Constants.Colors.frame_color_inspector);
					// butoane.setPreferredSize(new Dimension(700, 550));
					butoane.setBorder(new EmptyBorder(5, 5, 5, 5));

					serviciiButtonArray[nrOfServicies] = new JButton(rs.getString("nume"));
					serviciiButtonArray[nrOfServicies].setPreferredSize(new Dimension(50, 20));
					serviciiButtonArray[nrOfServicies].addActionListener(new ServiciiListener());
					serviciiButtonArray[nrOfServicies].setAlignmentX(CENTER_ALIGNMENT);
					serviciiButtonArray[nrOfServicies].setFont(Constants.Fonts.font_button);
					butoane.add(serviciiButtonArray[nrOfServicies]);

					serviciiIdArray[nrOfServicies] = Integer.parseInt(rs.getString("id_serv"));

					serviciiFieldArray[nrOfServicies] = new JTextField();
					serviciiFieldArray[nrOfServicies].setFont(Constants.Fonts.font_input);
					serviciiFieldArray[nrOfServicies].setEditable(false);
					serviciiFieldArray[nrOfServicies].setAlignmentX(CENTER_ALIGNMENT);
					serviciiFieldArray[nrOfServicies].setAlignmentY(CENTER_ALIGNMENT);
					butoane.add(serviciiFieldArray[nrOfServicies]);

					dp.add(butoane);
					nrOfServicies++;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			verificareButton = new JButton("Programeaza+Bon");
			verificareButton.addActionListener(new VisualFinishBonListener());
			verificareButton.setFont(Constants.Fonts.font_button);
			verificareButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			verificareButton.setBackground(Constants.Colors.blue_dark);
			dp.add(verificareButton);

			slPanel.putConstraint(SpringLayout.NORTH, dp, 50, SpringLayout.NORTH, rightPanel);
			slPanel.putConstraint(SpringLayout.WEST, dp, 650, SpringLayout.WEST, rightPanel);
			rightPanel.removeAll();
			rightPanel.add(scrollPane);

			a.validate();
			a.repaint();

		}

	}

	private class ServiciiListener implements ActionListener {

		private String s;

		public void actionPerformed(ActionEvent e) {
			JButton clicked = (JButton) e.getSource();
			int i = 0;
			for (i = 0; i < 20; i++)
				if (clicked.getText().contentEquals(serviciiButtonArray[i].getText()))
					break;

			this.s = serviciiFieldArray[i].getText();
			if (s.length() > 0)
				serviciiFieldArray[i].setText("");
			else
				serviciiFieldArray[i].setText("X");
		}
	}

	private class VisualFinishBonListener implements ActionListener {

		private String data;
		private String startTime;
		private String endTime = startTime;
		Integer cat;
		Integer rest;
		private String CNP;
		private String CNP_medic;

		private JPanel dataP;
		private JPanel startTimeP;
		private JPanel endTimeP;
		private JPanel serviciuNumeP;
		private JPanel serviciucostP;
		private JPanel serviciuP;

		public void actionPerformed(ActionEvent e) {

			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10, 1, 10, 10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));
			JScrollPane scrollPane = new JScrollPane(dp);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBackground(Constants.Colors.frame_color_inspector);
			scrollPane.setPreferredSize(new Dimension(700, 550));

			// rightPanel.removeAll();
			Integer[] idServ = new Integer[20];
			Integer Nr = 0;
			
			data=dataField.getText();
			System.out.println("Datafieldeste:"+data);
			
			
			
				
			
	
				
			for (int i = 0; i < nrOfServicies; i++) {
				String s = serviciiFieldArray[i].getText();
				if (s.length() != 0) {
					idServ[Nr] = serviciiIdArray[i];
					Nr++;
				}
			}
			String drs = null;
			startTime=startTimeField.getText();
			endTime=startTime;
			Integer durata=0;
			for (int i = 0; i < nrOfServicies; i++) {
				String s = serviciiFieldArray[i].getText();
				if (s.length() != 0) {
					ResultSet rs;
					try {
						rs = SqlProcedures.getServicii(con, serviciiButtonArray[i].getText());
						while (rs.next()) {
							Integer time = Integer.parseInt(rs.getString("durata"));
							durata+=time;
							Integer minute = Integer.parseInt("" + endTime.charAt(3) + endTime.charAt(4));
							minute = time + minute;
							rest = minute % 60;
							cat = minute / 60;
							if (cat < 1) {
								endTime = "" + endTime.charAt(0) + endTime.charAt(1) + endTime.charAt(2)
										+ minute.toString();
							} else {
								Integer ora = Integer.parseInt("" + endTime.charAt(0) + endTime.charAt(1));
								ora = ora + 1;
								endTime = "" + ora.toString() + ":" + rest.toString();
							}

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			try {
				drs = SqlProcedures.spec_serv(con, idServ, Nr,data,startTime,endTime);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (drs == null) {
				dataP = new JPanel();
				dataP.setLayout(new GridLayout());
				JLabel l= new JLabel("Failed");
				l.setAlignmentX(CENTER_ALIGNMENT);
				l.setFont(Constants.Fonts.font_button);
				dataP.add(l);
				dataP.setBackground(Constants.Colors.date_pers);
				dataP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
				dp.add(dataP);
			}
			
			else
			{

			this.data = dataField.getText();
			this.startTime = startTimeField.getText();
			this.endTime = startTime;
			this.CNP = CNPPacField.getText();

			dataP = new JPanel();
			JLabel l = new JLabel("Bon Fiscal:");
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_label);
			dataP.add(l);
			dp.add(dataP);

			dataP = new JPanel();
			dataP.setLayout(new GridLayout(1, 2));
			l = new JLabel("Data:");
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			dataP.add(l);
			dataP.setBackground(Constants.Colors.date_pers);
			dataP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			l = new JLabel(data);
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			dataP.add(l);
			dp.add(dataP);
			
			dataP = new JPanel();
			dataP.setLayout(new GridLayout(1, 2));
			l = new JLabel("CNP_Medic:");
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			dataP.add(l);
			dataP.setBackground(Constants.Colors.date_pers);
			dataP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			l = new JLabel(drs);
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			dataP.add(l);
			dp.add(dataP);

			startTimeP = new JPanel();
			startTimeP.setLayout(new GridLayout(1, 2));
			l = new JLabel("startTime:");
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			startTimeP.add(l);
			startTimeP.setBackground(Constants.Colors.date_pers);
			startTimeP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			l = new JLabel(startTime);
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			startTimeP.add(l);
			dp.add(startTimeP);
             durata=0;
			for (int i = 0; i < nrOfServicies; i++) {
				String s = serviciiFieldArray[i].getText();
				if (s.length() != 0) {
					ResultSet rs;
					try {
						rs = SqlProcedures.getServicii(con, serviciiButtonArray[i].getText());
						while (rs.next()) {
							Integer time = Integer.parseInt(rs.getString("durata"));
							durata+=time;
							Integer minute = Integer.parseInt("" + endTime.charAt(3) + endTime.charAt(4));
							minute = time + minute;
							rest = minute % 60;
							cat = minute / 60;
							if (cat < 1) {
								endTime = "" + endTime.charAt(0) + endTime.charAt(1) + endTime.charAt(2)
										+ minute.toString();
							} else {
								Integer ora = Integer.parseInt("" + endTime.charAt(0) + endTime.charAt(1));
								ora = ora + 1;
								endTime = "" + ora.toString() + ":" + rest.toString();
							}

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}

			}

			endTimeP = new JPanel();
			endTimeP.setLayout(new GridLayout(1, 2));
			l = new JLabel("endTime:");
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			endTimeP.add(l);
			endTimeP.setBackground(Constants.Colors.date_pers);
			endTimeP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			l = new JLabel(endTime);
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			endTimeP.add(l);
			dp.add(endTimeP);

			Integer PretTotal = 0;

			for (int i = 0; i < nrOfServicies; i++) {
				String s = serviciiFieldArray[i].getText();
				if (s.length() != 0) {
					ResultSet rs;

					try {
						rs = SqlProcedures.getServicii(con, serviciiButtonArray[i].getText());
						while (rs.next()) {

							String nume = rs.getString("nume");
							String pret = rs.getString("pret");
							String durataS = rs.getString("durata");
							PretTotal += Integer.parseInt(pret);

							endTimeP = new JPanel();
							endTimeP.setLayout(new GridLayout(1, 3));
							l = new JLabel(nume);
							l.setAlignmentX(CENTER_ALIGNMENT);
							l.setFont(Constants.Fonts.font_button);
							endTimeP.add(l);
							endTimeP.setBackground(Constants.Colors.date_pers);
							endTimeP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
							endTimeP.add(l);
							l = new JLabel("Pret:"+pret);
							l.setAlignmentX(CENTER_ALIGNMENT);
							l.setFont(Constants.Fonts.font_button);
							endTimeP.add(l);
							l = new JLabel("Durata:"+durataS);
							l.setAlignmentX(CENTER_ALIGNMENT);
							l.setFont(Constants.Fonts.font_button);
							endTimeP.add(l);
							dp.add(endTimeP);

						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				

			}
			endTimeP = new JPanel();
			endTimeP.setLayout(new GridLayout(1, 2));
			l = new JLabel("PRET TOTAL : ");
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			endTimeP.add(l);
			endTimeP.setBackground(Constants.Colors.date_pers);
			endTimeP.setBorder(new LineBorder(Constants.Colors.blue_dark, 3));
			l = new JLabel(PretTotal.toString());
			l.setAlignmentX(CENTER_ALIGNMENT);
			l.setFont(Constants.Fonts.font_button);
			endTimeP.add(l);
			dp.add(endTimeP);
			
			try {
				//System.out.println("DATA ESTE : "+data);
				//drs este CNP-UL medicului care executa programarea
				String id=idUnitField.getText();
				SqlProcedures.insertProgramare(con, drs,CNP,data, startTime, endTime, durata,id); 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
			


			slPanel.putConstraint(SpringLayout.NORTH, dp, 50, SpringLayout.NORTH, rightPanel);
			slPanel.putConstraint(SpringLayout.WEST, dp, 650, SpringLayout.WEST, rightPanel);
			rightPanel.removeAll();
			rightPanel.add(dp);

			a.validate();
			a.repaint();

		}

	}

	private class RegisterPacient implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			rightPanel.removeAll();
			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10, 1, 10, 10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));

			numeLabel = new JLabel("Nume :");
			numeLabel.setFont(Constants.Fonts.font_label);
			dp.add(numeLabel);
			numeField = new JTextField();
			numeField.setFont(Constants.Fonts.font_input);
			numeField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(numeField);

			prenumeLabel = new JLabel("Prenume :");
			prenumeLabel.setFont(Constants.Fonts.font_label);
			dp.add(prenumeLabel);
			prenumeField = new JTextField();
			prenumeField.setFont(Constants.Fonts.font_input);
			prenumeField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(prenumeField);

			CNPLabel = new JLabel("CNP_Pacient :");
			CNPLabel.setFont(Constants.Fonts.font_label);
			dp.add(CNPLabel);
			CNPField = new JTextField();
			CNPField.setFont(Constants.Fonts.font_input);
			CNPField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(CNPField);

			finishButton = new JButton(" Finsih ");
			finishButton.setFont(Constants.Fonts.font_button);
			finishButton.setBackground(Constants.Colors.blue_dark);
			finishButton.addActionListener(new VisualFinishInregistrareListener());
			dp.add(finishButton);

			slPanel.putConstraint(SpringLayout.NORTH, dp, 50, SpringLayout.NORTH, rightPanel);
			slPanel.putConstraint(SpringLayout.WEST, dp, 650, SpringLayout.WEST, rightPanel);
			rightPanel.removeAll();
			rightPanel.add(dp);
			a.validate();
			a.repaint();
		}

	}

	private class VisualFinishInregistrareListener implements ActionListener {

		private String nume;
		private String prenume;
		private String CNP;

		public void actionPerformed(ActionEvent e) {
			this.nume = numeField.getText();
			this.prenume = prenumeField.getText();
			this.CNP = CNPField.getText();

			try {
				SqlProcedures.InsertPacient(con,CNP,nume,prenume);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			numeField.setText("");
			prenumeField.setText("");
			CNPField.setText("");
		}
	}

	private class AdminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Admin a = new Admin(cnp);
		}

	}

	private class SuperadminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Superadmin a = new Superadmin(cnp);
		}

	}

	private class LogOutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			LogIn log = new LogIn();

		}

	}

}
