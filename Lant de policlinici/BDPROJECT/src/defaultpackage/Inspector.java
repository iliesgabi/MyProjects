package defaultpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class Inspector extends ConClass {

	private JPanel leftPanel;
	private JPanel rightPanel;

	private JLabel titleLabel;
	private JPanel titlePanel;

	private JPanel buttonDatePanel;
	private JButton buttonDate;

	private JButton searchButton;
	private JPanel searchButtonPanel;
	private JTextField searchNume;
	private JLabel searchLabelNume;
	private JPanel numeTextPanel;
	private JPanel searchNumePanel;

	/// Admin
	private JButton adminButton;
	private JPanel adminButtonPanel;
	private JButton superadminButton;
	private JPanel superadminButtonPanel;

	/// LogOut
	private JButton logOut;
	private JPanel logOutPanel;

	private JToggleButton typeSearch;
	private JTextField searchPrenume;
	private JLabel searchLabelPrenume;
	private JPanel prenumePanel;

	private JComboBox searchFunctie;
	private JLabel searchLabelFunctie;
	private JPanel functiePanel;

	private JPanel salariuPanel;
	private JButton salariuButton;
	private JComboBox salariuLuna;

	private JPanel updatePanel;
	private JButton deleteButton;
	private JButton updateButton;
	private JTextField startUpdate;
	private JTextField endUpdate;
	private JTextField unitateUpdate;
	private JLabel startUpdateLabel;
	private JLabel endUpdateLabel;
	private JLabel unitateUpdateLabel;

	private ConcediuPanel cp;
	private Inspector f;

	private String CNP;

	public Inspector(String CNP, boolean admin, boolean superadmin) {

		this.CNP = CNP;
		this.f = this;
		this.init();

		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new GridLayout(1, 2));

		leftPanel = new JPanel();
		rightPanel = new JPanel();

		rightPanel.setLayout(new FlowLayout());

		leftPanel.setLayout(new GridLayout(6, 1));

		// TitlePanel -> Inspector
		titleLabel = new JLabel(" Inspector ", SwingConstants.CENTER);
		titlePanel = new JPanel();
		titleLabel.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		titleLabel.setFont(Constants.Fonts.font_title);
		titleLabel.setBackground(Constants.Colors.blue_dark);
		titleLabel.setOpaque(true);
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlePanel.setBackground(Constants.Colors.frame_color_inspector);
		titlePanel.add(titleLabel);
		leftPanel.add(titlePanel);

		// DatePersonale -> Button
		buttonDate = new JButton("  Date personale  ");
		buttonDate.addActionListener(new buttonDateListener());
		buttonDatePanel = new JPanel();
		buttonDate.setFont(Constants.Fonts.font_button);
		buttonDatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonDatePanel.setBackground(Constants.Colors.frame_color_inspector);
		buttonDatePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		buttonDatePanel.add(buttonDate);
		leftPanel.add(buttonDatePanel);
		buttonDate.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		buttonDate.setBackground(Constants.Colors.blue_dark);

		// salariu

		// Search Nume
		searchButton = new JButton(" Search ");
		searchButton.addActionListener(new searchListener());
		searchNume = new JTextField();
		searchNume.setHorizontalAlignment(JTextField.CENTER);
		searchNumePanel = new JPanel();
		searchNumePanel.setLayout(new GridLayout(1, 2));
		searchButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		searchButton.setBackground(Constants.Colors.blue_dark);
		searchButton.setFont(Constants.Fonts.font_button);

		SpringLayout slPanel = new SpringLayout();
		searchButtonPanel = new JPanel();
		searchButtonPanel.setLayout(slPanel);
		searchButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
		slPanel.putConstraint(SpringLayout.NORTH, searchButton, 25, SpringLayout.NORTH, searchButtonPanel);
		slPanel.putConstraint(SpringLayout.WEST, searchButton, 120, SpringLayout.WEST, searchButtonPanel);
		searchButtonPanel.add(searchButton);

		searchNumePanel.add(searchButtonPanel);

		numeTextPanel = new JPanel();
		numeTextPanel.setLayout(slPanel);
		numeTextPanel.add(searchNume);
		numeTextPanel.setBackground(Constants.Colors.frame_color_inspector);
		searchNume.setFont(Constants.Fonts.font_input);
		searchNume.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		searchNume.setBackground(Constants.Colors.back_search);
		searchNume.setPreferredSize(new Dimension(150, 50));
		searchNumePanel.add(numeTextPanel);
		slPanel.putConstraint(SpringLayout.NORTH, searchNume, 40, SpringLayout.NORTH, numeTextPanel);

		searchLabelNume = new JLabel("Nume");
		searchLabelNume.setFont(Constants.Fonts.font_label);
		numeTextPanel.add(searchLabelNume);

		leftPanel.add(searchNumePanel);

		/// search prenume
		prenumePanel = new JPanel();
		prenumePanel.setLayout(slPanel);
		prenumePanel.setBackground(Constants.Colors.frame_color_inspector);
		searchPrenume = new JTextField();
		searchPrenume.setHorizontalAlignment(JTextField.CENTER);
		searchPrenume.setFont(Constants.Fonts.font_input);
		searchPrenume.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		searchPrenume.setBackground(Constants.Colors.back_search);
		searchPrenume.setPreferredSize(new Dimension(150, 50));

		typeSearch = new JRadioButton(" Program ");
		typeSearch.setSize(new Dimension(150, 150));
		typeSearch.addActionListener(new typeListener());
		typeSearch.setFont(Constants.Fonts.font_button);
		typeSearch.setBackground(Constants.Colors.frame_color_inspector);

		searchLabelPrenume = new JLabel("Prenume");
		searchLabelPrenume.setFont(Constants.Fonts.font_label);

		prenumePanel.add(searchPrenume);
		prenumePanel.add(typeSearch);
		prenumePanel.add(searchLabelPrenume);

		slPanel.putConstraint(SpringLayout.NORTH, searchPrenume, 40, SpringLayout.NORTH, prenumePanel);
		slPanel.putConstraint(SpringLayout.WEST, searchPrenume, 345, SpringLayout.WEST, prenumePanel);

		slPanel.putConstraint(SpringLayout.WEST, typeSearch, 145, SpringLayout.WEST, prenumePanel);
		slPanel.putConstraint(SpringLayout.WEST, searchLabelPrenume, 345, SpringLayout.WEST, prenumePanel);

		leftPanel.add(prenumePanel);

		/// search functie
		functiePanel = new JPanel();
		functiePanel.setLayout(slPanel);
		functiePanel.setBackground(Constants.Colors.frame_color_inspector);

		String[] functii = { "Medic", "Asistent", "Inspector", "Expert" };
		searchFunctie = new JComboBox(functii);
		searchFunctie.setFont(Constants.Fonts.font_input);
		searchFunctie.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		searchFunctie.setBackground(Constants.Colors.back_search);
		searchFunctie.setPreferredSize(new Dimension(150, 50));

		searchLabelFunctie = new JLabel("Functie");
		searchLabelFunctie.setFont(Constants.Fonts.font_label);

		functiePanel.add(searchFunctie);
		functiePanel.add(searchLabelFunctie);

		slPanel.putConstraint(SpringLayout.NORTH, searchFunctie, 40, SpringLayout.NORTH, functiePanel);
		slPanel.putConstraint(SpringLayout.WEST, searchFunctie, 345, SpringLayout.WEST, functiePanel);

		slPanel.putConstraint(SpringLayout.WEST, searchLabelFunctie, 345, SpringLayout.WEST, functiePanel);

		leftPanel.add(functiePanel);

		// salariu luna
		String[] luni = { "Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie",
				"Octombrie", "Noiembrie", "Decembrie" };

		salariuPanel = new JPanel();
		salariuButton = new JButton(" Salariu ");
		salariuLuna = new JComboBox(luni);

		salariuButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		salariuButton.setBackground(Constants.Colors.blue_dark);
		salariuButton.setFont(Constants.Fonts.font_button);
		salariuButton.addActionListener(new SalariuButtonListener());

		salariuPanel.setLayout(slPanel);
		salariuPanel.add(salariuButton);
		salariuPanel.add(salariuLuna);
		salariuPanel.setBorder(new EmptyBorder(25, 0, 0, 0));

		slPanel.putConstraint(SpringLayout.WEST, salariuLuna, 345, SpringLayout.WEST, salariuPanel);

		slPanel.putConstraint(SpringLayout.WEST, salariuButton, 115, SpringLayout.WEST, salariuPanel);

		salariuLuna.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		salariuLuna.setFont(Constants.Fonts.font_input);
		salariuPanel.setBackground(Constants.Colors.frame_color_inspector);
		leftPanel.add(salariuPanel);

		/// LogOut
		logOut = new JButton("  Log Out  ");
		logOut.addActionListener(new LogOutListener());
		logOutPanel = new JPanel();
		logOut.setFont(Constants.Fonts.font_button);
		logOutPanel.setLayout(new GridLayout(1, 2));
		logOutPanel.setBackground(Constants.Colors.frame_color_inspector);
		logOutPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
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

		this.add(leftPanel);

		rightPanel.setBackground(Constants.Colors.frame_color_inspector);

		this.add(rightPanel);

		this.validate();
		this.repaint();

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

	private class SalariuButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			rightPanel.removeAll();
			rightPanel.add(logOutPanel);
			String salariu = null;
			String numar_ore = null;
			try {
				ResultSet rs = SqlProcedures.getSalariuAngajat(con, CNP);
				salariu = rs.getString("salariu_neg");
				numar_ore = rs.getString("numar_ore_total");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SalariuPanel sp = new SalariuPanel(salariuLuna.getSelectedItem().toString(), salariu, numar_ore);

			rightPanel.add(sp);

			f.revalidate();
			f.repaint();
		}

	}

	private class typeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (typeSearch.getText() == " Program ") {
				typeSearch.setText(" Concediu ");
			} else {
				typeSearch.setText(" Program ");
			}
		}

	}

	private class searchListener implements ActionListener {

		private String CNP;
		public ProgramPanel p;

		private String Nume;
		private String Prenume;
		private String Functie;

		@Override
		public void actionPerformed(ActionEvent e) {

			this.Nume = searchNume.getText();
			this.Prenume = searchPrenume.getText();
			this.Functie = searchFunctie.getSelectedItem().toString().toLowerCase();

			rightPanel.removeAll();
			rightPanel.add(logOutPanel);

			startUpdate = new JTextField();
			startUpdate.setFont(Constants.Fonts.font_input);
			startUpdate.setHorizontalAlignment(JTextField.CENTER);
			startUpdate.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			startUpdate.setBackground(Constants.Colors.back_search);
			startUpdate.setPreferredSize(new Dimension(120, 40));
			endUpdate = new JTextField();
			endUpdate.setFont(Constants.Fonts.font_input);
			endUpdate.setHorizontalAlignment(JTextField.CENTER);
			endUpdate.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			endUpdate.setBackground(Constants.Colors.back_search);
			endUpdate.setPreferredSize(new Dimension(120, 40));
			unitateUpdate = new JTextField();
			unitateUpdate.setFont(Constants.Fonts.font_input);
			unitateUpdate.setHorizontalAlignment(JTextField.CENTER);
			unitateUpdate.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			unitateUpdate.setBackground(Constants.Colors.back_search);
			unitateUpdate.setPreferredSize(new Dimension(120, 40));
			startUpdateLabel = new JLabel("Begin");
			startUpdateLabel.setFont(Constants.Fonts.font_label);
			endUpdateLabel = new JLabel("End");
			endUpdateLabel.setFont(Constants.Fonts.font_label);
			unitateUpdateLabel = new JLabel("Unit");
			unitateUpdateLabel.setFont(Constants.Fonts.font_label);
			deleteButton = new JButton(" Delete ");
			deleteButton.setFont(Constants.Fonts.font_button);
			deleteButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			deleteButton.setBackground(Constants.Colors.blue_dark);

			updateButton = new JButton(" Nope ");
			updateButton.setFont(Constants.Fonts.font_button);
			updateButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			updateButton.setBackground(Constants.Colors.invalid);

			rightPanel.removeAll();
			rightPanel.add(logOutPanel);

			updatePanel = new JPanel();

			updatePanel.add(deleteButton);
			updatePanel.add(updateButton);
			updatePanel.add(startUpdate);
			updatePanel.add(endUpdate);
			updatePanel.add(unitateUpdate);
			updatePanel.add(startUpdateLabel);
			updatePanel.add(endUpdateLabel);
			updatePanel.add(unitateUpdateLabel);

			SpringLayout updateLPanel = new SpringLayout();
			updatePanel.setPreferredSize(new Dimension(650, 95));

			updateLPanel.putConstraint(SpringLayout.NORTH, deleteButton, 55, SpringLayout.NORTH, updatePanel);
			updateLPanel.putConstraint(SpringLayout.WEST, deleteButton, 10, SpringLayout.WEST, updatePanel);

			updateLPanel.putConstraint(SpringLayout.NORTH, updateButton, 10, SpringLayout.NORTH, updatePanel);
			updateLPanel.putConstraint(SpringLayout.WEST, updateButton, 10, SpringLayout.WEST, updatePanel);

			updateLPanel.putConstraint(SpringLayout.NORTH, startUpdate, 40, SpringLayout.NORTH, updatePanel);
			updateLPanel.putConstraint(SpringLayout.WEST, startUpdate, 180, SpringLayout.WEST, updatePanel);

			updateLPanel.putConstraint(SpringLayout.NORTH, startUpdateLabel, 0, SpringLayout.NORTH, updatePanel);
			updateLPanel.putConstraint(SpringLayout.WEST, startUpdateLabel, 180, SpringLayout.WEST, updatePanel);

			updateLPanel.putConstraint(SpringLayout.NORTH, endUpdate, 40, SpringLayout.NORTH, updatePanel);
			updateLPanel.putConstraint(SpringLayout.WEST, endUpdate, 340, SpringLayout.WEST, updatePanel);

			updateLPanel.putConstraint(SpringLayout.NORTH, endUpdateLabel, 0, SpringLayout.NORTH, updatePanel);
			updateLPanel.putConstraint(SpringLayout.WEST, endUpdateLabel, 340, SpringLayout.WEST, updatePanel);

			updateLPanel.putConstraint(SpringLayout.NORTH, unitateUpdate, 40, SpringLayout.NORTH, updatePanel);
			updateLPanel.putConstraint(SpringLayout.WEST, unitateUpdate, 500, SpringLayout.WEST, updatePanel);

			updateLPanel.putConstraint(SpringLayout.NORTH, unitateUpdateLabel, 0, SpringLayout.NORTH, updatePanel);
			updateLPanel.putConstraint(SpringLayout.WEST, unitateUpdateLabel, 500, SpringLayout.WEST, updatePanel);

			updatePanel.setBackground(Constants.Colors.frame_color_inspector);
			updatePanel.setLayout(updateLPanel);

			rightPanel.add(updatePanel);

			ResultSet rsId;
			try {
				rsId = SqlProcedures.searchId(con, Nume, Prenume, Functie);
				while (rsId.next()) {
					this.CNP = rsId.getString("CNP");
				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			if (typeSearch.isSelected()) {

				startUpdateLabel.setText("Year");
				endUpdateLabel.setText("Month");
				unitateUpdateLabel.setText("Day");
				updateButton.setText(" Add ");
				updateButton.setBackground(Constants.Colors.blue_dark);
				deleteButton.addActionListener(new deleteButtonListenerConcediu());
				updateButton.addActionListener(new updateButtonListenerConcediu());

				ResultSet rs;
				int i1 = 0;
				int j1 = 0;
				try {
					rs = SqlProcedures.searchAngajatConcediu(con, Nume, Prenume, Functie);
					cp = new ConcediuPanel(updateButton);
					while (rs.next()) {
						String date = rs.getString(1);
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cp.addValuesFromMatrix();
				rightPanel.add(cp);

				f.validate();
				f.repaint();
			} else {
				try {
					deleteButton.addActionListener(new deleteButtonListener());
					updateButton.addActionListener(new updateButtonListener());

					ResultSet rs = SqlProcedures.searchAngajatProgram(con, Nume, Prenume, Functie);
					p = new ProgramPanel(updateButton);
					while (rs.next()) {
						int j = Integer.parseInt(rs.getString("zi")) - 1;
						int i = 1;
						while (p.getMatrixValues()[i][j] instanceof NodeMatrix && i < 6) {
							i++;
						}
						p.addPanel(rs.getString("start_p"), rs.getString("end_p"), rs.getString("nume_unitate"),
								Integer.parseInt(rs.getString("id_unit")), i, j);
					}
					p.addValuesFromMatrix();

					rightPanel.add(p);

					f.validate();
					f.repaint();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		private class updateButtonListenerConcediu implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String start_p = startUpdate.getText();
				String end_p = endUpdate.getText();
				String unitate_p = unitateUpdate.getText();

				if (start_p == "" || end_p == "" || unitate_p == "" || Integer.parseInt(start_p) <= 0
						|| Integer.parseInt(end_p) <= 0 || Integer.parseInt(end_p) > 12
						|| Integer.parseInt(unitate_p) <= 0 || Integer.parseInt(unitate_p) > 31) {
					JOptionPane.showMessageDialog(null, "Invalid program");
					return;
				}

				Integer del_i = cp.getDeleteI();
				Integer del_j = cp.getDeleteJ();

				JPanel[][] mp = cp.getMatrixValues();

				// Verificare
				for (int z = 0; z < 6; z++)
					for (int x = 0; x < 7; x++) {
						if (del_i != z && del_j != x && mp[z][x] instanceof NodeMatrixConcediu == true) {
							System.out.println(((NodeMatrixConcediu) mp[z][x]).getStart() + " " + start_p);
							System.out.println(((NodeMatrixConcediu) mp[z][x]).getEnd() + " " + end_p);
							System.out.println(((NodeMatrixConcediu) mp[z][x]).getUnitate() + " " + unitate_p);
							System.out.println();
							if (((NodeMatrixConcediu) mp[z][x]).getStart().compareTo(start_p) == 0
									&& ((NodeMatrixConcediu) mp[z][x]).getEnd().compareTo(end_p) == 0
									&& ((NodeMatrixConcediu) mp[z][x]).getUnitate().compareTo(unitate_p) == 0) {
								JOptionPane.showMessageDialog(null, "Exista deja");
								return;
							}
						}
					}

				if (del_i != -1) { // Update

					try {
						System.out.println(del_i + " " + del_j);
						SqlProcedures.UpdateConcediu(con, ((NodeMatrixConcediu) mp[del_i][del_j]).getStart(),
								((NodeMatrixConcediu) mp[del_i][del_j]).getEnd(),
								((NodeMatrixConcediu) mp[del_i][del_j]).getUnitate(), CNP, start_p, end_p, unitate_p);

						rightPanel.remove(cp);
						ResultSet rs;
						int i1 = 0;
						int j1 = 0;
						try {
							rs = SqlProcedures.searchAngajatConcediu(con, Nume, Prenume, Functie);
							cp = new ConcediuPanel(updateButton);
							while (rs.next()) {

								String date = rs.getString(1);
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
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						cp.addValuesFromMatrix();
						rightPanel.add(cp);

						f.validate();
						f.repaint();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else { // Insert
					try {
						SqlProcedures.InsertConcediu(con, start_p, end_p, unitate_p, CNP);

						rightPanel.remove(cp);
						ResultSet rs;
						int i1 = 0;
						int j1 = 0;
						try {
							rs = SqlProcedures.searchAngajatConcediu(con, searchNume.getText(), searchPrenume.getText(),
									searchFunctie.getSelectedItem().toString().toLowerCase());
							cp = new ConcediuPanel(updateButton);
							while (rs.next()) {

								String date = rs.getString(1);
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
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						cp.addValuesFromMatrix();
						rightPanel.add(cp);

						f.validate();
						f.repaint();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

		private class updateButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				String start_p = startUpdate.getText();
				String end_p = endUpdate.getText();
				if (start_p == "" || end_p == "" || unitateUpdate.getText() == "" || start_p.compareTo(end_p) >= 0) {
					JOptionPane.showMessageDialog(null, "Invalid program");
					return;
				}
				Integer unit = Integer.parseInt(unitateUpdate.getText());

				Integer zi = p.getDeleteJ() + 1;
				Integer del_j = zi - 1;
				Integer del_i = p.getDeleteI();

				JPanel[][] mp = p.getMatrixValues();

				if (p.getDeleteI() != -1) { // Update

					for (int z = 1; z < 6; z++) {
						if (del_i != z && mp[z][del_j] instanceof NodeMatrix == true)
							if (del_i != z && (((NodeMatrix) mp[z][del_j]).getStart().compareTo(start_p) >= 0
									&& ((NodeMatrix) mp[z][del_j]).getStart().compareTo(end_p) <= 0
									|| start_p.compareTo(((NodeMatrix) mp[z][del_j]).getStart()) >= 0
											&& start_p.compareTo(((NodeMatrix) mp[z][del_j]).getEnd()) <= 0)) {

								JOptionPane.showMessageDialog(null, "Suprapunere");
								return;
							}
					}

					try {
						SqlProcedures.UpdateProgramS(con, ((NodeMatrix) mp[del_i][del_j]).getStart(),
								((NodeMatrix) mp[del_i][del_j]).getEnd(), zi, CNP,
								((NodeMatrix) mp[del_i][del_j]).getUnitateId(), start_p, end_p, unit);

						ResultSet rs;
						try {
							rs = SqlProcedures.searchAngajatProgram(con, Nume, Prenume, Functie);
							rightPanel.remove(p);
							p = new ProgramPanel(updateButton);
							while (rs.next()) {
								int j = Integer.parseInt(rs.getString("zi")) - 1;
								int i = 1;
								while (p.getMatrixValues()[i][j] instanceof NodeMatrix && i < 6) {
									i++;
								}
								System.out.println(rs.getString("start_p"));
								p.addPanel(rs.getString("start_p"), rs.getString("end_p"), rs.getString("nume_unitate"),
										Integer.parseInt(rs.getString("id_unit")), i, j);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						p.addValuesFromMatrix();
						rightPanel.add(p);
						f.validate();
						f.repaint();

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else if (p.getDay() != -1) { // Insert

					Integer zi_insert = p.getDay();

					for (int z = 1; z < 6; z++) {
						if (mp[z][zi_insert] instanceof NodeMatrix == true) {
							if (((NodeMatrix) mp[z][zi_insert]).getStart().compareTo(start_p) >= 0
									&& ((NodeMatrix) mp[z][zi_insert]).getStart().compareTo(end_p) <= 0
									|| start_p.compareTo(((NodeMatrix) mp[z][zi_insert]).getStart()) >= 0
											&& start_p.compareTo(((NodeMatrix) mp[z][zi_insert]).getEnd()) <= 0) {
								JOptionPane.showMessageDialog(null, "Suprapunere");
								return;
							}
						}
					}

					try {
						SqlProcedures.InsertProgramS(con, start_p, end_p, zi_insert + 1, CNP, unit);
						ResultSet rs;
						try {
							rs = SqlProcedures.searchAngajatProgram(con, Nume, Prenume, Functie);
							rightPanel.remove(p);
							p = new ProgramPanel(updateButton);
							while (rs.next()) {
								int j = Integer.parseInt(rs.getString("zi")) - 1;
								int i = 1;
								while (p.getMatrixValues()[i][j] instanceof NodeMatrix && i < 6) {
									i++;
								}
								System.out.println(rs.getString("start_p"));
								p.addPanel(rs.getString("start_p"), rs.getString("end_p"), rs.getString("nume_unitate"),
										Integer.parseInt(rs.getString("id_unit")), i, j);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						p.addValuesFromMatrix();
						rightPanel.add(p);
						f.validate();
						f.repaint();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}

			}
		}

		private class deleteButtonListenerConcediu implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i_del = cp.getDeleteI();
				int j_del = cp.getDeleteJ();
				if (i_del != -1) {
					NodeMatrixConcediu nd = (NodeMatrixConcediu) cp.getMatrixValues()[i_del][j_del];

					String start_p = nd.getStart();
					String end_p = nd.getEnd();
					String unit = nd.getUnitate();
					try {
						SqlProcedures.DeleteConcediu(con, start_p + ":" + end_p + ":" + unit, CNP);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					rightPanel.remove(cp);
					ResultSet rs;
					int i1 = 0;
					int j1 = 0;
					try {
						rs = SqlProcedures.searchAngajatConcediu(con, Nume, Prenume, Functie);
						cp = new ConcediuPanel(updateButton);
						while (rs.next()) {

							String date = rs.getString(1);
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
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					cp.addValuesFromMatrix();
					rightPanel.add(cp);

					f.validate();
					f.repaint();

				}
			}

		}

		private class deleteButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i_del = p.getDeleteI();
				int j_del = p.getDeleteJ();
				if (i_del != -1) {
					NodeMatrix nd = (NodeMatrix) p.getMatrixValues()[i_del][j_del];

					String start_p = nd.getStart();
					String end_p = nd.getEnd();
					Integer id_unit = nd.getUnitateId();
					try {
						SqlProcedures.DeleteProgramS(con, j_del + 1, start_p, end_p, id_unit, CNP);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					ResultSet rs;
					try {
						rs = SqlProcedures.searchAngajatProgram(con, Nume, Prenume, Functie);
						rightPanel.remove(p);
						p = new ProgramPanel(updateButton);
						while (rs.next()) {
							int j = Integer.parseInt(rs.getString("zi")) - 1;
							int i = 1;
							while (p.getMatrixValues()[i][j] instanceof NodeMatrix && i < 6) {
								i++;
							}
							System.out.println(rs.getString("start_p"));
							p.addPanel(rs.getString("start_p"), rs.getString("end_p"), rs.getString("nume_unitate"),
									Integer.parseInt(rs.getString("id_unit")), i, j);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					p.addValuesFromMatrix();
					rightPanel.add(p);
					f.validate();
					f.repaint();
				}
			}

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

	public JPanel getLeftPanel() {
		return leftPanel;
	}

	public void setLeftPanel(JPanel leftPanel) {
		this.leftPanel = leftPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public JLabel getTitlePanel() {
		return titleLabel;
	}

	public void setTitle(JLabel title) {
		this.titleLabel = title;
	}

	public JPanel getButtonDatePanel() {
		return buttonDatePanel;
	}

	public void setButtonDatePanel(JPanel buttonDatePanel) {
		this.buttonDatePanel = buttonDatePanel;
	}

}
