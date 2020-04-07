package defaultpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Expert extends ConClass {
	private String CNP;
	private JFrame f;

	/// left panel
	private JPanel leftPanel;
	private JPanel rightPanel;

	/// title
	private JLabel titleLabel;
	private JPanel titlePanel;

	// unit
	private JButton unitButton;
	private JPanel unitPanel;
	private JLabel idLabel;
	private JTextField unitText;

	// angajat
	private JPanel angajatPanel;
	private JPanel leftAngajatPanel;
	private JPanel rightAngajatPanel;
	private JButton angajatButton;
	private JComboBox specBox;
	private JTextField cnpText;
	private JLabel cnpLabel;
	private JComboBox chooseBox;

	// date personale
	private JPanel datePanel;
	private JButton dateButton;

	// salariu personal
	private JPanel salariuPanel;
	private JButton salariuButton;

	// program panel
	private JPanel programPanel;
	private JButton programButton;
	private JButton concediuButton;

	// Colors
	private Color seasonsColor[][] = { { new Color(125, 192, 209), new Color(78, 164, 186), new Color(41, 144, 171) },
			{ new Color(103, 194, 89), new Color(84, 166, 71), new Color(60, 133, 49) },
			{ new Color(237, 235, 130), new Color(242, 245, 91), new Color(236, 240, 67) },
			{ new Color(217, 157, 93), new Color(194, 134, 70), new Color(201, 127, 48) } };
	
	/// Admin
	private JButton adminButton;
	private JPanel adminButtonPanel;
	private JButton superadminButton;
	private JPanel superadminButtonPanel;
	
	/// LogOut
	private JButton logOut;
	private JPanel logOutPanel;
	
	public Expert(String CNP,boolean admin,boolean superadmin) {
		this.CNP = CNP;
		this.f = this;

		init();

		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new GridLayout(1, 2));

		leftPanel = new JPanel();
		rightPanel = new JPanel();

		leftPanel.setLayout(new GridLayout(6, 1));
		leftPanel.setBackground(Color.blue);
		
		/// TitleLabel
		titleLabel = new JLabel(" Expert ", SwingConstants.CENTER);
		titlePanel = new JPanel();
		titleLabel.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		titleLabel.setFont(Constants.Fonts.font_title);
		titleLabel.setBackground(Constants.Colors.blue_dark);
		titleLabel.setOpaque(true);
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlePanel.setBackground(Constants.Colors.frame_color_inspector);
		titlePanel.add(titleLabel);
		leftPanel.add(titlePanel);

		/// unit
		unitPanel = new JPanel();
		unitButton = new JButton(" Unitate ");
		unitText = new JTextField();
		idLabel = new JLabel(" ID ");

		unitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		unitButton = new JButton("  Unitate  ");
		unitButton.addActionListener(new buttonUnitListener());
		unitButton.setFont(Constants.Fonts.font_button);
		unitButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		unitButton.setBackground(Constants.Colors.blue_dark);

		idLabel.setFont(Constants.Fonts.font_label);
		idLabel.setBorder(new EmptyBorder(0, 50, 0, 0));
		;

		unitText.setHorizontalAlignment(JTextField.CENTER);
		unitText.setFont(Constants.Fonts.font_input);
		unitText.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		unitText.setBackground(Constants.Colors.back_search);
		unitText.setPreferredSize(new Dimension(150, 50));

		unitPanel.setBackground(Constants.Colors.frame_color_inspector);
		unitPanel.add(unitButton);
		unitPanel.add(idLabel);
		unitPanel.add(unitText);

		leftPanel.add(unitPanel);

		/// angajat
		String[] specStrings = { "Specialitate", "Unitate" };
		angajatPanel = new JPanel();
		chooseBox = new JComboBox();
		leftAngajatPanel = new JPanel();
		rightAngajatPanel = new JPanel();
		angajatButton = new JButton(" Angajat ");
		specBox = new JComboBox(specStrings);
		cnpText = new JTextField();
		cnpLabel = new JLabel("CNP");

		cnpText.setHorizontalAlignment(JTextField.CENTER);
		cnpText.setFont(Constants.Fonts.font_input);
		cnpText.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		cnpText.setBackground(Constants.Colors.back_search);
		cnpText.setPreferredSize(new Dimension(150, 50));
		cnpText.getDocument().addDocumentListener(new ChangeTextListener());

		angajatButton.addActionListener(new buttonAngajatListener());
		angajatButton.setFont(Constants.Fonts.font_button);
		angajatButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		angajatButton.setBackground(Constants.Colors.blue_dark);

		specBox.setFont(Constants.Fonts.font_input);
		specBox.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		specBox.setBackground(Constants.Colors.back_search);
		specBox.setPreferredSize(new Dimension(200, 50));
		specBox.addActionListener(new ChangeSpecListener());

		specBox.setVisible(false);

		angajatPanel.setLayout(new GridLayout(1, 2));
		leftAngajatPanel.setLayout(new GridLayout(2, 1));
		rightAngajatPanel.setLayout(new GridLayout(2, 1));

		JPanel angajatButtonPanel = new JPanel();
		angajatButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
		angajatButtonPanel.add(angajatButton);
		leftAngajatPanel.add(angajatButtonPanel);

		JPanel specBoxPanel = new JPanel();
		specBoxPanel.setBackground(Constants.Colors.frame_color_inspector);
		specBoxPanel.add(specBox);
		leftAngajatPanel.add(specBoxPanel);

		cnpLabel.setFont(Constants.Fonts.font_label);
		cnpLabel.setBorder(new EmptyBorder(0, 0, 0, 20));

		rightAngajatPanel.setBackground(Constants.Colors.frame_color_inspector);

		JPanel cnpPanel = new JPanel();
		cnpPanel.add(cnpLabel);
		cnpPanel.add(cnpText);
		cnpPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		JPanel chooseBoxPanel = new JPanel();
		chooseBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		chooseBoxPanel.add(chooseBox);

		chooseBox.setVisible(false);

		chooseBoxPanel.setBackground(Constants.Colors.frame_color_inspector);
		cnpPanel.setBackground(Constants.Colors.frame_color_inspector);

		rightAngajatPanel.add(cnpPanel);
		rightAngajatPanel.add(chooseBoxPanel);

		angajatPanel.add(leftAngajatPanel);
		angajatPanel.add(rightAngajatPanel);
		leftPanel.add(angajatPanel);

		/// date personale
		dateButton = new JButton(" Date personale ");
		datePanel = new JPanel();

		dateButton.addActionListener(new buttonDateListener());
		dateButton.setFont(Constants.Fonts.font_button);
		dateButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		dateButton.setBackground(Constants.Colors.blue_dark);

		datePanel.setBackground(Constants.Colors.frame_color_inspector);
		datePanel.setBorder(new EmptyBorder(50, 0, 0, 0));

		datePanel.add(dateButton);
		leftPanel.add(datePanel);

		/// LogOut
		logOut = new JButton("  Log Out  ");
		logOut.addActionListener(new LogOutListener());
		logOutPanel = new JPanel();
		logOut.setFont(Constants.Fonts.font_button);
		logOutPanel.setLayout(new GridLayout(1, 2));
		logOutPanel.setBackground(Constants.Colors.frame_color_inspector);
		logOutPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		logOutPanel.add(logOut);
		logOut.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		logOut.setBackground(Constants.Colors.blue_dark);

		rightPanel.add(logOutPanel);
		
		/// Admin
		if (superadmin == true) {
			superadminButton = new JButton("  superadmin  ");
			superadminButton.addActionListener(new SuperadminListener());
			superadminButtonPanel = new JPanel();
			superadminButton.setFont(Constants.Fonts.font_button);
			superadminButtonPanel.setLayout(new GridLayout(1, 2));
			superadminButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			superadminButtonPanel.setBorder(new EmptyBorder(0, 50, 0, 0));
			superadminButtonPanel.add(superadminButton);
			superadminButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			superadminButton.setBackground(Constants.Colors.blue_dark);

			titlePanel.add(superadminButtonPanel);
		}

		if (admin == true) {
			adminButton = new JButton(" admin  ");
			adminButton.addActionListener(new AdminListener());
			adminButtonPanel = new JPanel();
			adminButton.setFont(Constants.Fonts.font_button);
			adminButtonPanel.setLayout(new GridLayout(1, 2));
			adminButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			adminButtonPanel.setBorder(new EmptyBorder(0, 50, 0, 0));
			adminButtonPanel.add(adminButton);
			adminButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			adminButton.setBackground(Constants.Colors.blue_dark);

			titlePanel.add(adminButtonPanel);
		}
		
		/// salariu personal
		salariuButton = new JButton(" Salariu personal ");
		salariuPanel = new JPanel();

		salariuButton.addActionListener(new buttonSalariuListener());
		salariuButton.setFont(Constants.Fonts.font_button);
		salariuButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		salariuButton.setBackground(Constants.Colors.blue_dark);

		salariuPanel.setBackground(Constants.Colors.frame_color_inspector);

		salariuPanel.add(salariuButton);
		leftPanel.add(salariuPanel);

		/// program panel

		programPanel = new JPanel();
		programButton = new JButton(" Program ");
		concediuButton = new JButton(" Concediu ");

		JPanel programButtonPanel = new JPanel();
		programButtonPanel.add(programButton);

		programButton.addActionListener(new buttonProgramListener());
		programButton.setFont(Constants.Fonts.font_button);
		programButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		programButton.setBackground(Constants.Colors.blue_dark);
		programButtonPanel.setBorder(new EmptyBorder(0, 0, 0, 30));
		programButtonPanel.setBackground(Constants.Colors.frame_color_inspector);

		JPanel concediuButtonPanel = new JPanel();
		concediuButtonPanel.add(concediuButton);
		concediuButtonPanel.setBorder(new EmptyBorder(0, 30, 0, 0));
		concediuButtonPanel.setBackground(Constants.Colors.frame_color_inspector);

		concediuButton.addActionListener(new buttonConcediuListener());
		concediuButton.setFont(Constants.Fonts.font_button);
		concediuButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		concediuButton.setBackground(Constants.Colors.blue_dark);

		programPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		programPanel.setBackground(Constants.Colors.frame_color_inspector);
		programPanel.add(programButtonPanel);
		programPanel.add(concediuButtonPanel);

		leftPanel.add(programPanel);

		rightPanel.setBackground(Constants.Colors.frame_color_inspector);
		this.add(leftPanel);
		this.add(rightPanel);

		this.validate();
		this.repaint();
	}

	private class ChangeSpecListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			warn();
		}

	}

	private void warn() {
		String cnp_ang = cnpText.getText();
		specBox.setVisible(true);
		if (specBox.getSelectedItem().toString() == "Unitate") {
			try {
				chooseBox.removeAllItems();
				chooseBox.setVisible(false);
				ResultSet rs = SqlProcedures.getAllUnitateCNP(con, cnp_ang);
				while (rs.next()) {
					chooseBox.setVisible(true);
					chooseBox.addItem(SqlProcedures.getNumeUnitate(con,rs.getString(1)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				chooseBox.removeAllItems();
				chooseBox.setVisible(false);
				ResultSet rs = SqlProcedures.getAllSpecialitateCNP(con, cnp_ang);
				while (rs.next()) {
					chooseBox.setVisible(true);
					chooseBox.addItem(SqlProcedures.getNumeSpecialitate(con,rs.getString(1)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		f.validate();
		f.repaint();
	}

	private class ChangeTextListener implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent e) {
			warn();

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			warn();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			warn();
		}

	}

	public String getLuna(int i) {
		switch (i) {
		case 0:
			return "Ianuarie";
		case 1:
			return "Februarie";
		case 2:
			return "Martie";
		case 3:
			return "Aprilie";
		case 4:
			return "Mai";
		case 5:
			return "Iunie";
		case 6:
			return "Iulie";
		case 7:
			return "August";
		case 8:
			return "Septembrie";
		case 9:
			return "Octombire";
		case 10:
			return "Noiembrie";
		default:
			return "Decembrie";
		}
	}

	private class buttonAngajatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			rightPanel.removeAll();
			rightPanel.add(logOutPanel);

			String cnp_ang = cnpText.getText();
			if(chooseBox.getSelectedItem()==null) {
				rightPanel.removeAll();
				f.repaint();
				f.revalidate();
				return;
			}
			String unit_ang = chooseBox.getSelectedItem().toString();
			
			String sal = null;
			
			try {
				sal = SqlProcedures.getSalariuAngajat(con, cnp_ang).getString("salariu_neg");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			String numeAngajat = " Eroare ";
			ExpertSalariuPanel ep = null;

			try {
				numeAngajat = SqlProcedures.getName(con, cnp_ang);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			if (specBox.getSelectedItem().toString() == "Unitate") {
				ep = new ExpertSalariuPanel(" Salariu Per Unitate -> " + numeAngajat);

				int i = 0;
				int j = 1;

				boolean none = true;

				try {
					ResultSet rs = SqlProcedures.getSalariuPerUnitate(con, cnp_ang, SqlProcedures.getIdUnitate(con, unit_ang));
					while (rs.next()) {
						System.out.println(sal);
						none = false;
						ep.addPanel(new SalariuExpertNode(rs.getString(1), getLuna(i * 3 + j - 1), seasonsColor[i][j]),
								i, j++);

						if (j > 2) {
							j = 0;
							i = (i + 1) % 4;
						}

					}
					if (none) {
						ep.addPanel(new SalariuExpertNode(sal, getLuna(i * 3 + j - 1), seasonsColor[i][j]), i, j++);
					}
					while (i != 0 || j != 1) {
						ep.addPanel(new SalariuExpertNode(sal, getLuna(i * 3 + j - 1), seasonsColor[i][j]), i, j++);

						if (j > 2) {
							j = 0;
							i = (i + 1) % 4;
						}

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			} else {
				ep = new ExpertSalariuPanel(" Salariu per Specializare -> " + numeAngajat);

				int i = 0;
				int j = 1;

				boolean none = true;
				try {
					ResultSet rs = SqlProcedures.getSalariuPerSpecializare(con, cnp_ang, SqlProcedures.getIdSpecialitate(con,unit_ang));
					while (rs.next()) {

						none = false;
						ep.addPanel(new SalariuExpertNode(rs.getString(1), getLuna(i * 3 + j - 1), seasonsColor[i][j]),
								i, j++);

						if (j > 2) {
							j = 0;
							i = (i + 1) % 4;
						}
					}

					if (none) {
						ep.addPanel(new SalariuExpertNode(sal, getLuna(i * 3 + j - 1), seasonsColor[i][j]), i, j++);
					}
					while (i != 0 || j != 1) {
						ep.addPanel(new SalariuExpertNode(sal, getLuna(i * 3 + j - 1), seasonsColor[i][j]), i, j++);

						if (j > 2) {
							j = 0;
							i = (i + 1) % 4;
						}

					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			ep.addAllValues();

			rightPanel.add(ep);
			f.validate();
			f.repaint();
		}

	}

	private class buttonProgramListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			rightPanel.removeAll();
			rightPanel.add(logOutPanel);

			try {
				ResultSet rs = SqlProcedures.getProgramAngajat(con, CNP);
				ProgramPanelExpert ep = new ProgramPanelExpert();
				while (rs.next()) {
					int j = Integer.parseInt(rs.getString("zi")) - 1;
					int i = 1;
					while (ep.getMatrixValues()[i][j] instanceof NodeMatrix && i < 6) {
						i++;
					}
					ep.addPanel(rs.getString("start_p"), rs.getString("end_p"), rs.getString("nume_unitate"),
							Integer.parseInt(rs.getString("id_unit")), i, j);
				}
				ep.addValuesFromMatrix();

				rightPanel.add(ep);

				f.validate();
				f.repaint();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private class AdminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Admin a = new Admin(CNP);
		}

	}

	private class LogOutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
	          LogIn log = new LogIn();

		}

	}
	
	private class SuperadminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Superadmin a = new Superadmin(CNP);
		}

	}
	
	private class buttonConcediuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			rightPanel.removeAll();
			rightPanel.add(logOutPanel);
			ResultSet rs;
			int i1 = 0;
			int j1 = 0;
			try {
				rs = SqlProcedures.getConcediuAngajat(con, CNP);
				ConcediuPanelExpert cp = new ConcediuPanelExpert();
				while (rs.next()) {
					String date = rs.getString(3);
					String year = date.substring(0, 4);
					String month = date.substring(5, 7);
					String day = date.substring(8, 10);

					cp.addPanel(year, month, day, i1, j1);
					j1++;
					if (j1 > 6) {
						j1 = 0;
						i1++;
					}

				}
				cp.addValuesFromMatrix();
				rightPanel.add(cp);

				f.validate();
				f.repaint();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	private class buttonSalariuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String numeAngajat = "Eroare";

			rightPanel.removeAll();
			rightPanel.add(logOutPanel);

			try {
				numeAngajat = SqlProcedures.getName(con, CNP);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			ExpertSalariuPanel ep = new ExpertSalariuPanel(" Salariu -> " + numeAngajat);

			int i = 0;
			int j = 1;

			try {
				ResultSet rs = SqlProcedures.getSalariuAngajat(con, CNP);

				for (int z = 0; z < 12; z++) {
					ep.addPanel(new SalariuExpertNode(rs.getString(1), getLuna(i * 3 + j - 1), seasonsColor[i][j]), i,
							j++);

					if (j > 2) {
						j = 0;
						i = (i + 1) % 4;
					}

				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			ep.addAllValues();
			rightPanel.add(ep);

			f.validate();
			f.repaint();
		}
	}

	private class buttonDateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			rightPanel.removeAll();
			rightPanel.add(logOutPanel);
			DatePersonalePanel dp = new DatePersonalePanel();

			ResultSet rs;
			try {
				rs = SqlProcedures.getDatePersonale(con, CNP);
				while (rs.next()) {
					dp.addPanel(new DatePanel("CNP: " + rs.getString("CNP")));
					dp.addPanel(new DatePanel("Nume: " + rs.getString("nume")));
					dp.addPanel(new DatePanel("Prenume: " + rs.getString("prenume")));
					dp.addPanel(new DatePanel("Adresa: " + rs.getString("adresa")));
					dp.addPanel(new DatePanel("Telefon: " + rs.getString("telefon")));
					dp.addPanel(new DatePanel("email: " + rs.getString("email")));
					dp.addPanel(new DatePanel("Cont IBAN: " + rs.getString("cont_IBAN")));
					dp.addPanel(new DatePanel("Nr. Contract: " + rs.getString("nr_contract")));
					dp.addPanel(new DatePanel("Functie: " + rs.getString("functie")));
					dp.addPanel(new DatePanel("Data angajarii: " + rs.getDate("data_angajarii")));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			rightPanel.add(dp);

			f.validate();
			f.repaint();
		}

	}

	private class buttonUnitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			rightPanel.removeAll();
			rightPanel.add(logOutPanel);

			String unit = unitText.getText();

			if(SqlProcedures.getUnitateNume(con, unit)==null) {
				rightPanel.removeAll();
				f.validate();
				f.repaint();
				return;
			}
			
			String nume = " Eroare ";
			ExpertSalariuPanel ep = null;

			try {
				nume = SqlProcedures.getNameUnitate(con, unit);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			ep = new ExpertSalariuPanel(" Profit -> " + nume);
			
			int i = 0;
			int j = 1;

			boolean none = true;

			String pr = null;
			
			try {
				pr = "-"+SqlProcedures.getProfitUnitateFara(con, unit);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {

				ResultSet rs = SqlProcedures.getProfitUnitate(con, unit);
				while (rs.next()) {
					none = false;
					ep.addPanel(new SalariuExpertNode(rs.getString(2), getLuna(i * 3 + j - 1), seasonsColor[i][j]), i,
							j++);

					if (j > 2) {
						j = 0;
						i = (i + 1) % 4;
					}

				}
				if (none) {
					ep.addPanel(new SalariuExpertNode(pr, getLuna(i * 3 + j - 1), seasonsColor[i][j]), i, j++);
				}
				while (i != 0 || j != 1) {
					ep.addPanel(new SalariuExpertNode(pr, getLuna(i * 3 + j - 1), seasonsColor[i][j]), i, j++);
					if (j > 2) {
						j = 0;
						i = (i + 1) % 4;
					}

				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			rightPanel.add(ep);
			ep.addAllValues();
			f.validate();
			f.repaint();
		}
	}
}