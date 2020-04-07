package defaultpackage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Superadmin extends ConClass {
	private Superadmin a;
	
	private JButton modifyUserBtn;
	private JPanel modifyUserBtnPanel;
	private JButton deleteUserBtn;
	private JPanel deleteUserBtnPanel;
	
	private JButton addAdminButton;
	private JPanel addAdminButtonPanel;
	private JButton deleteAdminButton;
	private JPanel deleteAdminButtonPanel;

	private JTextField username;
	private JTextField password;
	private JTextField cnp;

	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel cnpLabel;

	private JButton addButton;
	private JPanel addButtonPanel;
	private SpringLayout slPanel;

	private JLabel titleLabel;
	private JPanel titlePanel;

	private JButton addUserBtn;
	private JButton addPoliclinicaBtn;
	private JPanel addUserBtnPanel;
	private JPanel addPoliclinicaBtnPanel;

	private JTextField nume;
	private JLabel numeLabel;

	private JTextField prenume;
	private JLabel prenumeLabel;

	private JTextField adresa;
	private JLabel adresaLabel;

	private JTextField telefon;
	private JLabel telefonLabel;

	private JTextField email;
	private JLabel emailLabel;

	private JTextField cont_IBAN;
	private JLabel cont_IBANLabel;

	private JTextField nr_contract;
	private JLabel nr_contractLabel;

	private JTextField an;
	private JLabel anLabel;

	private JTextField zi;
	private JLabel ziLabel;

	private JTextField luna;
	private JLabel lunaLabel;

	private JLabel data_angajariiLabel;

	private JTextField functie;
	private JLabel functieLabel;

	private JTextField salariuNeg;
	private JLabel salariuNegLabel;

	private JTextField numarOreTotal;
	private JLabel numarOreTotalLabel;

	private JTextField tipOrar;
	private JLabel tipOrarLabel;

	private JLabel musernameLabel;
	private JLabel mpasswordLabel;
	private JLabel mcnpLabel;

	private JTextField musername;
	private JTextField mpassword;
	private JTextField mcnp;

	private JTextField mnume;
	private JLabel mnumeLabel;

	private JTextField mprenume;
	private JLabel mprenumeLabel;

	private JTextField madresa;
	private JLabel madresaLabel;

	private JTextField mtelefon;
	private JLabel mtelefonLabel;

	private JTextField memail;
	private JLabel memailLabel;

	private JTextField mcont_IBAN;
	private JLabel mcont_IBANLabel;

	private JTextField mnr_contract;
	private JLabel mnr_contractLabel;

	private JTextField man;
	private JLabel manLabel;

	private JTextField mzi;
	private JLabel mziLabel;

	private JTextField mluna;
	private JLabel mlunaLabel;

	private JLabel mdata_angajariiLabel;

	private JTextField mfunctie;
	private JLabel mfunctieLabel;

	private JTextField msalariuNeg;
	private JLabel msalariuNegLabel;

	private JTextField mnumarOreTotal;
	private JLabel mnumarOreTotalLabel;

	private JTextField mtipOrar;
	private JLabel mtipOrarLabel;

	private JTextField tip;
	private JLabel tipLabel;

	private JTextField grad;
	private JLabel gradLabel;

	private JTextField gradMedic;
	private JTextField codParafa;
	private JTextField titluStiintific;
	private JTextField postDidactic;
	private JTextField procentServicii;

	private JLabel gradMedicLabel;
	private JLabel codParafaLabel;
	private JLabel titluStiintificLabel;
	private JLabel postDidacticLabel;
	private JLabel procentServiciiLabel;

	private JButton addProgram;
	private JPanel addProgramPanel;

	private JTextField id;
	private JLabel idLabel;

	private JTextField denumire;
	private JLabel denumireLabel;

	private JTextField adresaPoliclinica;
	private JLabel adresaPoliclinicaLabel;

	private JTextField ziP;
	private JLabel ziPLabel;
	private JTextField lunaP;
	private JLabel lunaPLabel;
	private JTextField anP;
	private JLabel anPLabel;

	private JTextField start_p;
	private JLabel start_pLabel;

	private JTextField end_p;
	private JLabel end_pLabel;

	private JButton modifyLogin;
	private JPanel modifyLoginPanel;

	private JButton modifyDatePers;
	private JPanel modifyDatePersPanel;

	private JButton modifyAngajat;
	private JPanel modifyAngajatPanel;
	
	private JButton logOut;
	private JPanel logOutPanel;
	
	private JButton backButton;
	private JPanel backButtonPanel;
	
	private JLabel errorMessage;
	
	private String cnpPeBune;
	
	public Superadmin(String cnp) {
		this.cnpPeBune=cnp;
		this.init();
		this.a = this;
		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		leftPanel = new JPanel();

		slPanel = new SpringLayout();
		leftPanel.setLayout(slPanel);

		titleLabel = new JLabel(" Superadmin ", SwingConstants.CENTER);
		titlePanel = new JPanel();
		titleLabel.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		titleLabel.setFont(Constants.Fonts.font_title);
		titleLabel.setBackground(Constants.Colors.blue_dark);
		titleLabel.setOpaque(true);
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlePanel.setBackground(Constants.Colors.frame_color_inspector);
		titlePanel.add(titleLabel);
		leftPanel.add(titlePanel);

		addPoliclinicaBtn = new JButton("  adauga policlinica  ");
		addPoliclinicaBtn.addActionListener(new AddPoliListener());
		addPoliclinicaBtnPanel = new JPanel();
		addPoliclinicaBtn.setFont(Constants.Fonts.font_button);
		addPoliclinicaBtnPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, addPoliclinicaBtnPanel, 80, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, addPoliclinicaBtnPanel, 50, SpringLayout.WEST, leftPanel);
		addPoliclinicaBtnPanel.setBackground(Constants.Colors.frame_color_inspector);
		addPoliclinicaBtnPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		addPoliclinicaBtnPanel.add(addPoliclinicaBtn);
		addPoliclinicaBtn.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		addPoliclinicaBtn.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(addPoliclinicaBtnPanel);

		addUserBtn = new JButton("  adauga utilizator  ");
		addUserBtn.addActionListener(new AddUserListener());
		addUserBtnPanel = new JPanel();
		addUserBtn.setFont(Constants.Fonts.font_button);
		addUserBtnPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, addUserBtnPanel, 170, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, addUserBtnPanel, 50, SpringLayout.WEST, leftPanel);
		addUserBtnPanel.setBackground(Constants.Colors.frame_color_inspector);
		addUserBtnPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		addUserBtnPanel.add(addUserBtn);
		addUserBtn.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		addUserBtn.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(addUserBtnPanel);
		
		modifyUserBtn = new JButton("  modifica date utilizator  ");
		modifyUserBtn.addActionListener(new ModifyUserListener());
		modifyUserBtnPanel = new JPanel();
		modifyUserBtn.setFont(Constants.Fonts.font_button);
		modifyUserBtnPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, modifyUserBtnPanel, 260, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, modifyUserBtnPanel, 50, SpringLayout.WEST, leftPanel);
		modifyUserBtnPanel.setBackground(Constants.Colors.frame_color_inspector);
		modifyUserBtnPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		modifyUserBtnPanel.add(modifyUserBtn);
		modifyUserBtn.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		modifyUserBtn.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(modifyUserBtnPanel);
		
		deleteUserBtn = new JButton("  sterge utilizator  ");
		deleteUserBtn.addActionListener(new PreDeleteUserListener());
		deleteUserBtnPanel = new JPanel();
		deleteUserBtn.setFont(Constants.Fonts.font_button);
		deleteUserBtnPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, deleteUserBtnPanel, 350, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST,deleteUserBtnPanel, 50, SpringLayout.WEST, leftPanel);
		deleteUserBtnPanel.setBackground(Constants.Colors.frame_color_inspector);
		deleteUserBtnPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		deleteUserBtnPanel.add(deleteUserBtn);
		deleteUserBtn.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		deleteUserBtn.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(deleteUserBtnPanel);

		addAdminButton = new JButton("  adauga admin  ");
		addAdminButton.addActionListener(new AddAdminListener());
		addAdminButtonPanel = new JPanel();
		addAdminButton.setFont(Constants.Fonts.font_button);
		addAdminButtonPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, addAdminButtonPanel, 440, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, addAdminButtonPanel, 50, SpringLayout.WEST, leftPanel);
		addAdminButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
		addAdminButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		addAdminButtonPanel.add(addAdminButton);
		addAdminButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		addAdminButton.setBackground(Constants.Colors.blue_dark);
		leftPanel.add(addAdminButtonPanel);
		
		deleteAdminButton = new JButton("  sterge admin  ");
		deleteAdminButton.addActionListener(new PreDeleteAdminListener());
		deleteAdminButtonPanel = new JPanel();
		deleteAdminButton.setFont(Constants.Fonts.font_button);
		deleteAdminButtonPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, deleteAdminButtonPanel, 530, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, deleteAdminButtonPanel, 50, SpringLayout.WEST, leftPanel);
		deleteAdminButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
		deleteAdminButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		deleteAdminButtonPanel.add(deleteAdminButton);
		deleteAdminButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		deleteAdminButton.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(deleteAdminButtonPanel);

		logOut = new JButton("  Log Out  ");
		logOut.addActionListener(new LogOutListener());
		logOutPanel = new JPanel();
		logOut.setFont(Constants.Fonts.font_button);
		logOutPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, logOutPanel, 0, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, logOutPanel, 1150, SpringLayout.WEST, leftPanel);
		logOutPanel.setBackground(Constants.Colors.frame_color_inspector);
		logOutPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		logOutPanel.add(logOut);
		logOut.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		logOut.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(logOutPanel);
		
		backButton = new JButton("  back  ");
		backButton.addActionListener(new BackListener());
		backButtonPanel = new JPanel();
		backButton.setFont(Constants.Fonts.font_button);
		backButtonPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, backButtonPanel, 550, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, backButtonPanel, 1170, SpringLayout.WEST, leftPanel);
		backButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
		backButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		backButtonPanel.add(backButton);
		backButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		backButton.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(backButtonPanel);
		
		leftPanel.setBackground(Constants.Colors.frame_color_inspector);
		leftPanel.setVisible(true);
		this.add(leftPanel);
		this.validate();
		this.repaint();

	}

	private class AddAdminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (cnp != null) {
				leftPanel.remove(cnp);
				leftPanel.remove(cnpLabel);
				leftPanel.remove(username);
				leftPanel.remove(usernameLabel);
				leftPanel.remove(password);
				leftPanel.remove(passwordLabel);
				leftPanel.remove(addButtonPanel);
			}

			clean(); 
			username = new JTextField(14);
			username.setFont(Constants.Fonts.font_input);
			username.setHorizontalAlignment(JTextField.CENTER);
			username.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			username.setBackground(Constants.Colors.back_search);
			username.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, username, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, username, 980, SpringLayout.WEST, leftPanel);

			usernameLabel = new JLabel("username: ");
			usernameLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, usernameLabel, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, usernameLabel, 810, SpringLayout.WEST, leftPanel);

			leftPanel.add(username);
			leftPanel.add(usernameLabel);

			cnp = new JTextField(14);
			cnp.setFont(Constants.Fonts.font_input);
			cnp.setHorizontalAlignment(JTextField.CENTER);
			cnp.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			cnp.setBackground(Constants.Colors.back_search);
			cnp.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, cnp, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnp, 980, SpringLayout.WEST, leftPanel);

			cnpLabel = new JLabel("cnp: ");
			cnpLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, cnpLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnpLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(cnp);
			leftPanel.add(cnpLabel);

			password = new JTextField(14);
			password.setFont(Constants.Fonts.font_input);
			password.setHorizontalAlignment(JTextField.CENTER);
			password.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			password.setBackground(Constants.Colors.back_search);
			password.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, password, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, password, 980, SpringLayout.WEST, leftPanel);

			passwordLabel = new JLabel("parola: ");
			passwordLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, passwordLabel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, passwordLabel, 848, SpringLayout.WEST, leftPanel);

			leftPanel.add(password);
			leftPanel.add(passwordLabel);

			addButton = new JButton("  adauga  ");
			addButton.addActionListener(new AddListener());

			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 370, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 850, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);

			leftPanel.add(addButtonPanel);
			
			a.validate();
			a.repaint();
		}
	}

	private class PreDeleteAdminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (cnp != null) {
				leftPanel.remove(cnp);
				leftPanel.remove(cnpLabel);
				leftPanel.remove(username);
				leftPanel.remove(usernameLabel);
				leftPanel.remove(password);
				leftPanel.remove(passwordLabel);
				leftPanel.remove(addButtonPanel);
			}

			clean();
			username = new JTextField(14);
			username.setFont(Constants.Fonts.font_input);
			username.setHorizontalAlignment(JTextField.CENTER);
			username.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			username.setBackground(Constants.Colors.back_search);
			username.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, username, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, username, 980, SpringLayout.WEST, leftPanel);

			usernameLabel = new JLabel("username: ");
			usernameLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, usernameLabel, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, usernameLabel, 810, SpringLayout.WEST, leftPanel);

			leftPanel.add(username);
			leftPanel.add(usernameLabel);

			cnp = new JTextField(14);
			cnp.setFont(Constants.Fonts.font_input);
			cnp.setHorizontalAlignment(JTextField.CENTER);
			cnp.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			cnp.setBackground(Constants.Colors.back_search);
			cnp.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, cnp, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnp, 980, SpringLayout.WEST, leftPanel);

			cnpLabel = new JLabel("cnp: ");
			cnpLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, cnpLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnpLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(cnp);
			leftPanel.add(cnpLabel);

			password = new JTextField(14);
			password.setFont(Constants.Fonts.font_input);
			password.setHorizontalAlignment(JTextField.CENTER);
			password.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			password.setBackground(Constants.Colors.back_search);
			password.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, password, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, password, 980, SpringLayout.WEST, leftPanel);

			passwordLabel = new JLabel("parola: ");
			passwordLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, passwordLabel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, passwordLabel, 848, SpringLayout.WEST, leftPanel);

			leftPanel.add(password);
			leftPanel.add(passwordLabel);

			addButton = new JButton("  sterge  ");
			addButton.addActionListener(new DeleteAdminListener());

			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 370, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 850, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);

			leftPanel.add(addButtonPanel);
			a.validate();
			a.repaint();
		}
	}

	private class DeleteAdminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			clean();
			try {
				SqlProcedures.deleteAdmin(con, cnp.getText(), username.getText(), password.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
				
				
				errorMessage = new JLabel("date incorecte ");
				errorMessage.setFont(Constants.Fonts.font_label);
				slPanel.putConstraint(SpringLayout.NORTH, errorMessage, 200, SpringLayout.NORTH, leftPanel);
				slPanel.putConstraint(SpringLayout.WEST, errorMessage, 720, SpringLayout.WEST, leftPanel);
				leftPanel.add(errorMessage);
				
			}

			leftPanel.remove(cnp);
			leftPanel.remove(cnpLabel);
			leftPanel.remove(username);
			leftPanel.remove(usernameLabel);
			leftPanel.remove(password);
			leftPanel.remove(passwordLabel);
			leftPanel.remove(addButtonPanel);
			a.validate();
			a.repaint();
		}
	}

	
	private class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				SqlProcedures.addAdmin(con, cnp.getText(), username.getText(), password.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			leftPanel.remove(cnp);
			leftPanel.remove(cnpLabel);
			leftPanel.remove(username);
			leftPanel.remove(usernameLabel);
			leftPanel.remove(password);
			leftPanel.remove(passwordLabel);
			leftPanel.remove(addButtonPanel);
			a.validate();
			a.repaint();
		}
	}
	
	
	
	private void clean() {
		if (cnp != null) {
			leftPanel.remove(cnp);
			leftPanel.remove(cnpLabel);
			leftPanel.remove(username);
			leftPanel.remove(usernameLabel);
			leftPanel.remove(password);
			leftPanel.remove(passwordLabel);
			leftPanel.remove(addButtonPanel);
			if (nume != null) {
				leftPanel.remove(nume);
				leftPanel.remove(numeLabel);
				leftPanel.remove(prenume);
				leftPanel.remove(prenumeLabel);
				leftPanel.remove(telefon);
				leftPanel.remove(telefonLabel);
				leftPanel.remove(adresa);
				leftPanel.remove(adresaLabel);
				leftPanel.remove(email);
				leftPanel.remove(emailLabel);
				leftPanel.remove(cont_IBAN);
				leftPanel.remove(cont_IBANLabel);
				leftPanel.remove(nr_contract);
				leftPanel.remove(nr_contractLabel);
				leftPanel.remove(an);
				leftPanel.remove(anLabel);
				leftPanel.remove(zi);
				leftPanel.remove(ziLabel);
				leftPanel.remove(luna);
				leftPanel.remove(lunaLabel);
				leftPanel.remove(data_angajariiLabel);
				leftPanel.remove(functie);
				leftPanel.remove(functieLabel);
				leftPanel.remove(addButtonPanel);

				if (salariuNeg != null) {
					leftPanel.remove(salariuNeg);
					leftPanel.remove(salariuNegLabel);
					leftPanel.remove(numarOreTotal);
					leftPanel.remove(numarOreTotalLabel);
					leftPanel.remove(tipOrar);
					leftPanel.remove(tipOrarLabel);

					if (tip != null) {
						leftPanel.remove(tip);
						leftPanel.remove(tipLabel);
						leftPanel.remove(grad);
						leftPanel.remove(gradLabel);
					}

					if (gradMedic != null) {
						leftPanel.remove(gradMedic);
						leftPanel.remove(gradMedicLabel);
						leftPanel.remove(codParafa);
						leftPanel.remove(codParafaLabel);
						leftPanel.remove(titluStiintific);
						leftPanel.remove(titluStiintificLabel);
						leftPanel.remove(postDidactic);
						leftPanel.remove(postDidacticLabel);
						leftPanel.remove(procentServicii);
						leftPanel.remove(procentServiciiLabel);
					}
				}
			}
		}
		
		if (denumire != null) {
			leftPanel.remove(addProgramPanel);
			leftPanel.remove(id);
			leftPanel.remove(idLabel);
			leftPanel.remove(denumire);
			leftPanel.remove(denumireLabel);
			leftPanel.remove(adresaPoliclinica);
			leftPanel.remove(adresaPoliclinicaLabel);
			leftPanel.remove(addButtonPanel);
		}

		if (id != null) {
			leftPanel.remove(id);
			leftPanel.remove(idLabel);
			leftPanel.remove(denumire);
			leftPanel.remove(denumireLabel);
			leftPanel.remove(adresaPoliclinica);
			leftPanel.remove(adresaPoliclinicaLabel);
			leftPanel.remove(addButtonPanel);
		}
		if (modifyLoginPanel != null) {
			leftPanel.remove(modifyAngajatPanel);
			leftPanel.remove(modifyDatePersPanel);
			leftPanel.remove(modifyLoginPanel);
		}

		if (musername != null) {
			leftPanel.remove(mcnp);
			leftPanel.remove(mcnpLabel);
			leftPanel.remove(musername);
			leftPanel.remove(musernameLabel);
			leftPanel.remove(mpassword);
			leftPanel.remove(mpasswordLabel);
			leftPanel.remove(addButtonPanel);
		}
		if (mnume != null) {
			leftPanel.remove(mcnp);
			leftPanel.remove(mcnpLabel);
			leftPanel.remove(mnume);
			leftPanel.remove(mnumeLabel);
			leftPanel.remove(mprenume);
			leftPanel.remove(mprenumeLabel);
			leftPanel.remove(mtelefon);
			leftPanel.remove(mtelefonLabel);
			leftPanel.remove(madresa);
			leftPanel.remove(madresaLabel);
			leftPanel.remove(memail);
			leftPanel.remove(memailLabel);
			leftPanel.remove(mcont_IBAN);
			leftPanel.remove(mcont_IBANLabel);
			leftPanel.remove(mnr_contract);
			leftPanel.remove(mnr_contractLabel);
			leftPanel.remove(man);
			leftPanel.remove(manLabel);
			leftPanel.remove(mzi);
			leftPanel.remove(mziLabel);
			leftPanel.remove(mluna);
			leftPanel.remove(mlunaLabel);
			leftPanel.remove(mdata_angajariiLabel);
			leftPanel.remove(mfunctie);
			leftPanel.remove(mfunctieLabel);
			leftPanel.remove(addButtonPanel);
		}

		if (msalariuNeg != null) {
			leftPanel.remove(msalariuNeg);
			leftPanel.remove(msalariuNegLabel);
			leftPanel.remove(mnumarOreTotal);
			leftPanel.remove(mnumarOreTotalLabel);
			leftPanel.remove(mtipOrar);
			leftPanel.remove(mtipOrarLabel);
			leftPanel.remove(addButtonPanel);
		}
		
		if (ziP != null) {
			leftPanel.remove(ziP);
			leftPanel.remove(ziPLabel);
			leftPanel.remove(lunaPLabel);
			leftPanel.remove(lunaP);
			leftPanel.remove(anP);
			leftPanel.remove(anPLabel);
			leftPanel.remove(start_p);
			leftPanel.remove(start_pLabel);
			leftPanel.remove(end_p);
			leftPanel.remove(end_pLabel);
			leftPanel.remove(id);
			leftPanel.remove(idLabel);
			leftPanel.remove(addButtonPanel);
			leftPanel.remove(data_angajariiLabel);
		}
	}

	private class AddUserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			clean();
			username = new JTextField(14);
			username.setFont(Constants.Fonts.font_input);
			username.setHorizontalAlignment(JTextField.CENTER);
			username.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			username.setBackground(Constants.Colors.back_search);
			username.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, username, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, username, 980, SpringLayout.WEST, leftPanel);

			usernameLabel = new JLabel("username: ");
			usernameLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, usernameLabel, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, usernameLabel, 810, SpringLayout.WEST, leftPanel);

			leftPanel.add(username);
			leftPanel.add(usernameLabel);

			cnp = new JTextField(14);
			cnp.setFont(Constants.Fonts.font_input);
			cnp.setHorizontalAlignment(JTextField.CENTER);
			cnp.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			cnp.setBackground(Constants.Colors.back_search);
			cnp.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, cnp, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnp, 980, SpringLayout.WEST, leftPanel);

			cnpLabel = new JLabel("cnp: ");
			cnpLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, cnpLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnpLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(cnp);
			leftPanel.add(cnpLabel);

			password = new JTextField(14);
			password.setFont(Constants.Fonts.font_input);
			password.setHorizontalAlignment(JTextField.CENTER);
			password.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			password.setBackground(Constants.Colors.back_search);
			password.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, password, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, password, 980, SpringLayout.WEST, leftPanel);

			passwordLabel = new JLabel("parola: ");
			passwordLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, passwordLabel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, passwordLabel, 848, SpringLayout.WEST, leftPanel);

			leftPanel.add(password);
			leftPanel.add(passwordLabel);

			addButton = new JButton("  adauga  ");
			addButton.addActionListener(new AddDatePersonaleListener());
			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 370, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 850, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}
	}

	private class AddDatePersonaleListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				SqlProcedures.addCommonUserLogin(con, cnp.getText(), username.getText(), password.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			clean();

			nume = new JTextField(14);
			nume.setFont(Constants.Fonts.font_input);
			nume.setHorizontalAlignment(JTextField.CENTER);
			nume.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			nume.setBackground(Constants.Colors.back_search);
			nume.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, nume, 20, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, nume, 980, SpringLayout.WEST, leftPanel);

			numeLabel = new JLabel("nume: ");
			numeLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, numeLabel, 20, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, numeLabel, 880, SpringLayout.WEST, leftPanel);

			leftPanel.add(nume);
			leftPanel.add(numeLabel);

			prenume = new JTextField(14);
			prenume.setFont(Constants.Fonts.font_input);
			prenume.setHorizontalAlignment(JTextField.CENTER);
			prenume.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			prenume.setBackground(Constants.Colors.back_search);
			prenume.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, prenume, 80, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, prenume, 980, SpringLayout.WEST, leftPanel);

			prenumeLabel = new JLabel("prenume: ");
			prenumeLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, prenumeLabel, 80, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, prenumeLabel, 825, SpringLayout.WEST, leftPanel);

			leftPanel.add(prenume);
			leftPanel.add(prenumeLabel);

			adresa = new JTextField(14);
			adresa.setFont(Constants.Fonts.font_input);
			adresa.setHorizontalAlignment(JTextField.CENTER);
			adresa.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			adresa.setBackground(Constants.Colors.back_search);
			adresa.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, adresa, 140, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, adresa, 980, SpringLayout.WEST, leftPanel);

			adresaLabel = new JLabel("adresa: ");
			adresaLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, adresaLabel, 140, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, adresaLabel, 843, SpringLayout.WEST, leftPanel);

			leftPanel.add(adresa);
			leftPanel.add(adresaLabel);

			telefon = new JTextField(14);
			telefon.setFont(Constants.Fonts.font_input);
			telefon.setHorizontalAlignment(JTextField.CENTER);
			telefon.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			telefon.setBackground(Constants.Colors.back_search);
			telefon.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, telefon, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, telefon, 980, SpringLayout.WEST, leftPanel);

			telefonLabel = new JLabel("telefon: ");
			telefonLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, telefonLabel, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, telefonLabel, 825, SpringLayout.WEST, leftPanel);

			leftPanel.add(telefon);
			leftPanel.add(telefonLabel);

			email = new JTextField(14);
			email.setFont(Constants.Fonts.font_input);
			email.setHorizontalAlignment(JTextField.CENTER);
			email.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			email.setBackground(Constants.Colors.back_search);
			email.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, email, 260, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, email, 980, SpringLayout.WEST, leftPanel);

			emailLabel = new JLabel("email: ");
			emailLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, emailLabel, 260, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, emailLabel, 860, SpringLayout.WEST, leftPanel);

			leftPanel.add(email);
			leftPanel.add(emailLabel);

			cont_IBAN = new JTextField(14);
			cont_IBAN.setFont(Constants.Fonts.font_input);
			cont_IBAN.setHorizontalAlignment(JTextField.CENTER);
			cont_IBAN.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			cont_IBAN.setBackground(Constants.Colors.back_search);
			cont_IBAN.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, cont_IBAN, 320, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cont_IBAN, 980, SpringLayout.WEST, leftPanel);

			cont_IBANLabel = new JLabel("cont IBAN: ");
			cont_IBANLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, cont_IBANLabel, 320, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cont_IBANLabel, 788, SpringLayout.WEST, leftPanel);

			leftPanel.add(cont_IBAN);
			leftPanel.add(cont_IBANLabel);

			nr_contract = new JTextField(14);
			nr_contract.setFont(Constants.Fonts.font_input);
			nr_contract.setHorizontalAlignment(JTextField.CENTER);
			nr_contract.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			nr_contract.setBackground(Constants.Colors.back_search);
			nr_contract.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, nr_contract, 380, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, nr_contract, 980, SpringLayout.WEST, leftPanel);

			nr_contractLabel = new JLabel("nr contract: ");
			nr_contractLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, nr_contractLabel, 380, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, nr_contractLabel, 750, SpringLayout.WEST, leftPanel);

			leftPanel.add(nr_contract);
			leftPanel.add(nr_contractLabel);

			data_angajariiLabel = new JLabel("data angajarii: ");
			data_angajariiLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, data_angajariiLabel, 440, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, data_angajariiLabel, 600, SpringLayout.WEST, leftPanel);

			an = new JTextField(4);
			an.setFont(Constants.Fonts.font_input);
			an.setHorizontalAlignment(JTextField.CENTER);
			an.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			an.setBackground(Constants.Colors.back_search);
			an.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, an, 440, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, an, 980, SpringLayout.WEST, leftPanel);

			anLabel = new JLabel("anul: ");
			anLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, anLabel, 440, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, anLabel, 880, SpringLayout.WEST, leftPanel);

			leftPanel.add(data_angajariiLabel);
			leftPanel.add(an);
			leftPanel.add(anLabel);

			luna = new JTextField(2);
			luna.setFont(Constants.Fonts.font_input);
			luna.setHorizontalAlignment(JTextField.CENTER);
			luna.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			luna.setBackground(Constants.Colors.back_search);
			luna.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, luna, 440, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, luna, 1140, SpringLayout.WEST, leftPanel);

			lunaLabel = new JLabel("luna: ");
			lunaLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, lunaLabel, 440, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, lunaLabel, 1050, SpringLayout.WEST, leftPanel);

			leftPanel.add(luna);
			leftPanel.add(lunaLabel);

			zi = new JTextField(2);
			zi.setFont(Constants.Fonts.font_input);
			zi.setHorizontalAlignment(JTextField.CENTER);
			zi.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			zi.setBackground(Constants.Colors.back_search);
			zi.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, zi, 440, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, zi, 1280, SpringLayout.WEST, leftPanel);

			ziLabel = new JLabel("ziua: ");
			ziLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, ziLabel, 440, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, ziLabel, 1180, SpringLayout.WEST, leftPanel);

			leftPanel.add(zi);
			leftPanel.add(ziLabel);

			functie = new JTextField(14);
			functie.setFont(Constants.Fonts.font_input);
			functie.setHorizontalAlignment(JTextField.CENTER);
			functie.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			functie.setBackground(Constants.Colors.back_search);
			functie.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, functie, 500, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, functie, 980, SpringLayout.WEST, leftPanel);

			functieLabel = new JLabel("functie: ");
			functieLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, functieLabel, 500, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, functieLabel, 822, SpringLayout.WEST, leftPanel);

			leftPanel.add(functie);
			leftPanel.add(functieLabel);

			addButton = new JButton("  adauga  ");
			addButton.addActionListener(new AddAngajatListener());
			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 540, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 900, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}

	}

	private class AddAngajatListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				SqlProcedures.addCommonUserDatePers(con, cnp.getText(), nume.getText(), prenume.getText(),
						adresa.getText(), telefon.getText(), email.getText(), cont_IBAN.getText(),
						nr_contract.getText(), an.getText(), luna.getText(), zi.getText(), functie.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			clean();

			salariuNeg = new JTextField(14);
			salariuNeg.setFont(Constants.Fonts.font_input);
			salariuNeg.setHorizontalAlignment(JTextField.CENTER);
			salariuNeg.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			salariuNeg.setBackground(Constants.Colors.back_search);
			salariuNeg.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, salariuNeg, 150, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, salariuNeg, 1050, SpringLayout.WEST, leftPanel);

			salariuNegLabel = new JLabel("salariu: ");
			salariuNegLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, salariuNegLabel, 150, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, salariuNegLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(salariuNeg);
			leftPanel.add(salariuNegLabel);

			numarOreTotal = new JTextField(14);
			numarOreTotal.setFont(Constants.Fonts.font_input);
			numarOreTotal.setHorizontalAlignment(JTextField.CENTER);
			numarOreTotal.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			numarOreTotal.setBackground(Constants.Colors.back_search);
			numarOreTotal.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, numarOreTotal, 250, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, numarOreTotal, 1050, SpringLayout.WEST, leftPanel);

			numarOreTotalLabel = new JLabel("numar ore: ");
			numarOreTotalLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, numarOreTotalLabel, 250, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, numarOreTotalLabel, 870, SpringLayout.WEST, leftPanel);

			leftPanel.add(numarOreTotal);
			leftPanel.add(numarOreTotalLabel);

			tipOrar = new JTextField(14);
			tipOrar.setFont(Constants.Fonts.font_input);
			tipOrar.setHorizontalAlignment(JTextField.CENTER);
			tipOrar.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			tipOrar.setBackground(Constants.Colors.back_search);
			tipOrar.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, tipOrar, 350, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, tipOrar, 1050, SpringLayout.WEST, leftPanel);

			tipOrarLabel = new JLabel("tip orar: ");
			tipOrarLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, tipOrarLabel, 350, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, tipOrarLabel, 880, SpringLayout.WEST, leftPanel);

			leftPanel.add(tipOrar);
			leftPanel.add(tipOrarLabel);

			addButton = new JButton("  adauga  ");
			if (functie.getText().equals("medic"))
				addButton.addActionListener(new AddMedicListener());
			else if (functie.getText().equals("asistent medical"))
				addButton.addActionListener(new AddAsistentListener());
			else
				addButton.addActionListener(new DoarAddListener());
			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 450, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 900, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}
	}

	private class AddMedicListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();

			gradMedic = new JTextField(14);
			gradMedic.setFont(Constants.Fonts.font_input);
			gradMedic.setHorizontalAlignment(JTextField.CENTER);
			gradMedic.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			gradMedic.setBackground(Constants.Colors.back_search);
			gradMedic.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, gradMedic, 50, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, gradMedic, 950, SpringLayout.WEST, leftPanel);

			gradMedicLabel = new JLabel("grad: ");
			gradMedicLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, gradMedicLabel, 50, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, gradMedicLabel, 850, SpringLayout.WEST, leftPanel);

			leftPanel.add(gradMedic);
			leftPanel.add(gradMedicLabel);

			codParafa = new JTextField(14);
			codParafa.setFont(Constants.Fonts.font_input);
			codParafa.setHorizontalAlignment(JTextField.CENTER);
			codParafa.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			codParafa.setBackground(Constants.Colors.back_search);
			codParafa.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, codParafa, 150, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, codParafa, 950, SpringLayout.WEST, leftPanel);

			codParafaLabel = new JLabel("cod parafa: ");
			codParafaLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, codParafaLabel, 150, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, codParafaLabel, 740, SpringLayout.WEST, leftPanel);

			leftPanel.add(codParafa);
			leftPanel.add(codParafaLabel);

			titluStiintific = new JTextField(14);
			titluStiintific.setFont(Constants.Fonts.font_input);
			titluStiintific.setHorizontalAlignment(JTextField.CENTER);
			titluStiintific.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			titluStiintific.setBackground(Constants.Colors.back_search);
			titluStiintific.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, titluStiintific, 250, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, titluStiintific, 950, SpringLayout.WEST, leftPanel);

			titluStiintificLabel = new JLabel("titlu stiintific: ");
			titluStiintificLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, titluStiintificLabel, 250, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, titluStiintificLabel, 630, SpringLayout.WEST, leftPanel);

			leftPanel.add(titluStiintific);
			leftPanel.add(titluStiintificLabel);

			postDidactic = new JTextField(14);
			postDidactic.setFont(Constants.Fonts.font_input);
			postDidactic.setHorizontalAlignment(JTextField.CENTER);
			postDidactic.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			postDidactic.setBackground(Constants.Colors.back_search);
			postDidactic.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, postDidactic, 350, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, postDidactic, 950, SpringLayout.WEST, leftPanel);

			postDidacticLabel = new JLabel("post didactic: ");
			postDidacticLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, postDidacticLabel, 350, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, postDidacticLabel, 680, SpringLayout.WEST, leftPanel);

			leftPanel.add(postDidactic);
			leftPanel.add(postDidacticLabel);

			procentServicii = new JTextField(14);
			procentServicii.setFont(Constants.Fonts.font_input);
			procentServicii.setHorizontalAlignment(JTextField.CENTER);
			procentServicii.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			procentServicii.setBackground(Constants.Colors.back_search);
			procentServicii.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, procentServicii, 450, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, procentServicii, 950, SpringLayout.WEST, leftPanel);

			procentServiciiLabel = new JLabel("procent servicii: ");
			procentServiciiLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, procentServiciiLabel, 450, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, procentServiciiLabel, 630, SpringLayout.WEST, leftPanel);

			leftPanel.add(procentServicii);
			leftPanel.add(procentServiciiLabel);

			addButton = new JButton("  adauga  ");
			addButtonPanel = new JPanel();
			addButton.addActionListener(new AddMedicPeBuneListener());
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 500, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 900, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}
	}

	private class AddAsistentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();

			tip = new JTextField(14);
			tip.setFont(Constants.Fonts.font_input);
			tip.setHorizontalAlignment(JTextField.CENTER);
			tip.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			tip.setBackground(Constants.Colors.back_search);
			tip.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, tip, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, tip, 1000, SpringLayout.WEST, leftPanel);

			tipLabel = new JLabel("tip: ");
			tipLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, tipLabel, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, tipLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(tip);
			leftPanel.add(tipLabel);

			grad = new JTextField(14);
			grad.setFont(Constants.Fonts.font_input);
			grad.setHorizontalAlignment(JTextField.CENTER);
			grad.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			grad.setBackground(Constants.Colors.back_search);
			grad.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, grad, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, grad, 1000, SpringLayout.WEST, leftPanel);

			gradLabel = new JLabel("grad: ");
			gradLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, gradLabel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, gradLabel, 880, SpringLayout.WEST, leftPanel);

			leftPanel.add(grad);
			leftPanel.add(gradLabel);

			addButton = new JButton("  adauga  ");
			addButtonPanel = new JPanel();
			addButton.addActionListener(new AddAsistentPeBuneListener());
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 400, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 900, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}
	}

	private class DoarAddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SqlProcedures.addAngajat(con, cnp.getText(), Integer.parseInt(salariuNeg.getText()),
						Integer.parseInt(numarOreTotal.getText()), Integer.parseInt(tipOrar.getText()));
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			clean();

			a.validate();
			a.repaint();
		}
	}

	private class AddAsistentPeBuneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SqlProcedures.addAngajat(con, cnp.getText(), Integer.parseInt(salariuNeg.getText()),
						Integer.parseInt(numarOreTotal.getText()), Integer.parseInt(tipOrar.getText()));
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			try {
				SqlProcedures.addAsistent(con, cnp.getText(), tip.getText(), grad.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			clean();
			a.validate();
			a.repaint();
		}
	}

	private class AddMedicPeBuneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SqlProcedures.addAngajat(con, cnp.getText(), Integer.parseInt(salariuNeg.getText()),
						Integer.parseInt(numarOreTotal.getText()), Integer.parseInt(tipOrar.getText()));
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}

			try {
				SqlProcedures.addMedic(con, cnp.getText(), gradMedic.getText(), codParafa.getText(),
						titluStiintific.getText(), postDidactic.getText(), Integer.parseInt(procentServicii.getText()));
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}

			clean();

			a.validate();
			a.repaint();
		}
	}

	private class PreDeleteUserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			clean();

			username = new JTextField(14);
			username.setFont(Constants.Fonts.font_input);
			username.setHorizontalAlignment(JTextField.CENTER);
			username.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			username.setBackground(Constants.Colors.back_search);
			username.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, username, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, username, 980, SpringLayout.WEST, leftPanel);

			usernameLabel = new JLabel("username: ");
			usernameLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, usernameLabel, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, usernameLabel, 810, SpringLayout.WEST, leftPanel);

			leftPanel.add(username);
			leftPanel.add(usernameLabel);

			cnp = new JTextField(14);
			cnp.setFont(Constants.Fonts.font_input);
			cnp.setHorizontalAlignment(JTextField.CENTER);
			cnp.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			cnp.setBackground(Constants.Colors.back_search);
			cnp.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, cnp, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnp, 980, SpringLayout.WEST, leftPanel);

			cnpLabel = new JLabel("cnp: ");
			cnpLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, cnpLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnpLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(cnp);
			leftPanel.add(cnpLabel);

			password = new JTextField(14);
			password.setFont(Constants.Fonts.font_input);
			password.setHorizontalAlignment(JTextField.CENTER);
			password.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			password.setBackground(Constants.Colors.back_search);
			password.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, password, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, password, 980, SpringLayout.WEST, leftPanel);

			passwordLabel = new JLabel("parola: ");
			passwordLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, passwordLabel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, passwordLabel, 848, SpringLayout.WEST, leftPanel);

			leftPanel.add(password);
			leftPanel.add(passwordLabel);

			addButton = new JButton("  sterge  ");
			addButton.addActionListener(new DeleteUserListener());

			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 370, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 850, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);

			leftPanel.add(addButtonPanel);
			a.validate();
			a.repaint();
		}
	}

	private class DeleteUserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				SqlProcedures.deleteUser(con, cnp.getText(), username.getText(), password.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			clean();
			a.validate();
			a.repaint();
		}
	}

	private class ModifyUserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();
			modifyLogin = new JButton("  modifica cont login  ");
			modifyLogin.addActionListener(new ModifyLoginListener());
			modifyLoginPanel = new JPanel();
			modifyLogin.setFont(Constants.Fonts.font_button);
			modifyLoginPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, modifyLoginPanel, 100, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, modifyLoginPanel, 850, SpringLayout.WEST, leftPanel);
			modifyLoginPanel.setBackground(Constants.Colors.frame_color_inspector);
			modifyLoginPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			modifyLoginPanel.add(modifyLogin);
			modifyLogin.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			modifyLogin.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(modifyLoginPanel);

			modifyDatePers = new JButton("  modifica date personale  ");
			modifyDatePers.addActionListener(new ModifyDatePersonaleListener());
			modifyDatePersPanel = new JPanel();
			modifyDatePers.setFont(Constants.Fonts.font_button);
			modifyDatePersPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, modifyDatePersPanel, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, modifyDatePersPanel, 850, SpringLayout.WEST, leftPanel);
			modifyDatePersPanel.setBackground(Constants.Colors.frame_color_inspector);
			modifyDatePersPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			modifyDatePersPanel.add(modifyDatePers);
			modifyDatePers.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			modifyDatePers.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(modifyDatePersPanel);

			modifyAngajat = new JButton("  modifica date angajat  ");
			modifyAngajat.addActionListener(new ModifyAngajatListener());
			modifyAngajatPanel = new JPanel();
			modifyAngajat.setFont(Constants.Fonts.font_button);
			modifyAngajatPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, modifyAngajatPanel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, modifyAngajatPanel, 850, SpringLayout.WEST, leftPanel);
			modifyAngajatPanel.setBackground(Constants.Colors.frame_color_inspector);
			modifyAngajatPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			modifyAngajatPanel.add(modifyAngajat);
			modifyAngajat.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			modifyAngajat.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(modifyAngajatPanel);

			a.validate();
			a.repaint();
		}
	}

	private class ModifyLoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			leftPanel.remove(modifyLoginPanel);
			leftPanel.remove(modifyDatePersPanel);
			leftPanel.remove(modifyAngajatPanel);
			clean();

			musername = new JTextField(14);
			musername.setFont(Constants.Fonts.font_input);
			musername.setHorizontalAlignment(JTextField.CENTER);
			musername.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			musername.setBackground(Constants.Colors.back_search);
			musername.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, musername, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, musername, 980, SpringLayout.WEST, leftPanel);

			musernameLabel = new JLabel("username: ");
			musernameLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, musernameLabel, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, musernameLabel, 810, SpringLayout.WEST, leftPanel);

			leftPanel.add(musername);
			leftPanel.add(musernameLabel);

			mcnp = new JTextField(14);
			mcnp.setFont(Constants.Fonts.font_input);
			mcnp.setHorizontalAlignment(JTextField.CENTER);
			mcnp.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mcnp.setBackground(Constants.Colors.back_search);
			mcnp.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mcnp, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcnp, 980, SpringLayout.WEST, leftPanel);

			mcnpLabel = new JLabel("cnp: ");
			mcnpLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mcnpLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcnpLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(mcnp);
			leftPanel.add(mcnpLabel);

			mpassword = new JTextField(14);
			mpassword.setFont(Constants.Fonts.font_input);
			mpassword.setHorizontalAlignment(JTextField.CENTER);
			mpassword.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mpassword.setBackground(Constants.Colors.back_search);
			mpassword.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mpassword, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mpassword, 980, SpringLayout.WEST, leftPanel);

			mpasswordLabel = new JLabel("parola: ");
			mpasswordLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mpasswordLabel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mpasswordLabel, 848, SpringLayout.WEST, leftPanel);

			leftPanel.add(mpassword);
			leftPanel.add(mpasswordLabel);

			addButton = new JButton("  modifica  ");
			addButton.addActionListener(new ModifyLoginPeBuneListener());
			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 370, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 850, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();

		}

	}

	private class ModifyDatePersonaleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();

			mnume = new JTextField(14);
			mnume.setFont(Constants.Fonts.font_input);
			mnume.setHorizontalAlignment(JTextField.CENTER);
			mnume.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mnume.setBackground(Constants.Colors.back_search);
			mnume.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mnume, 10, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mnume, 980, SpringLayout.WEST, leftPanel);

			mnumeLabel = new JLabel("nume: ");
			mnumeLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mnumeLabel, 10, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mnumeLabel, 880, SpringLayout.WEST, leftPanel);

			leftPanel.add(mnume);
			leftPanel.add(mnumeLabel);

			mprenume = new JTextField(14);
			mprenume.setFont(Constants.Fonts.font_input);
			mprenume.setHorizontalAlignment(JTextField.CENTER);
			mprenume.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mprenume.setBackground(Constants.Colors.back_search);
			mprenume.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mprenume, 70, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mprenume, 980, SpringLayout.WEST, leftPanel);

			mprenumeLabel = new JLabel("prenume: ");
			mprenumeLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mprenumeLabel, 70, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mprenumeLabel, 825, SpringLayout.WEST, leftPanel);

			leftPanel.add(mprenume);
			leftPanel.add(mprenumeLabel);

			madresa = new JTextField(14);
			madresa.setFont(Constants.Fonts.font_input);
			madresa.setHorizontalAlignment(JTextField.CENTER);
			madresa.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			madresa.setBackground(Constants.Colors.back_search);
			madresa.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, madresa, 130, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, madresa, 980, SpringLayout.WEST, leftPanel);

			madresaLabel = new JLabel("adresa: ");
			madresaLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, madresaLabel, 130, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, madresaLabel, 843, SpringLayout.WEST, leftPanel);

			leftPanel.add(madresa);
			leftPanel.add(madresaLabel);

			mtelefon = new JTextField(14);
			mtelefon.setFont(Constants.Fonts.font_input);
			mtelefon.setHorizontalAlignment(JTextField.CENTER);
			mtelefon.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mtelefon.setBackground(Constants.Colors.back_search);
			mtelefon.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mtelefon, 190, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mtelefon, 980, SpringLayout.WEST, leftPanel);

			mtelefonLabel = new JLabel("telefon: ");
			mtelefonLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mtelefonLabel, 190, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mtelefonLabel, 825, SpringLayout.WEST, leftPanel);

			leftPanel.add(mtelefon);
			leftPanel.add(mtelefonLabel);

			memail = new JTextField(14);
			memail.setFont(Constants.Fonts.font_input);
			memail.setHorizontalAlignment(JTextField.CENTER);
			memail.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			memail.setBackground(Constants.Colors.back_search);
			memail.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, memail, 250, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, memail, 980, SpringLayout.WEST, leftPanel);

			memailLabel = new JLabel("email: ");
			memailLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, memailLabel, 250, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, memailLabel, 860, SpringLayout.WEST, leftPanel);

			leftPanel.add(memail);
			leftPanel.add(memailLabel);

			mcont_IBAN = new JTextField(14);
			mcont_IBAN.setFont(Constants.Fonts.font_input);
			mcont_IBAN.setHorizontalAlignment(JTextField.CENTER);
			mcont_IBAN.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mcont_IBAN.setBackground(Constants.Colors.back_search);
			mcont_IBAN.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mcont_IBAN, 310, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcont_IBAN, 980, SpringLayout.WEST, leftPanel);

			mcont_IBANLabel = new JLabel("cont IBAN: ");
			mcont_IBANLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mcont_IBANLabel, 310, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcont_IBANLabel, 788, SpringLayout.WEST, leftPanel);

			leftPanel.add(mcont_IBAN);
			leftPanel.add(mcont_IBANLabel);

			mnr_contract = new JTextField(14);
			mnr_contract.setFont(Constants.Fonts.font_input);
			mnr_contract.setHorizontalAlignment(JTextField.CENTER);
			mnr_contract.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mnr_contract.setBackground(Constants.Colors.back_search);
			mnr_contract.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mnr_contract, 370, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mnr_contract, 980, SpringLayout.WEST, leftPanel);

			mnr_contractLabel = new JLabel("nr contract: ");
			mnr_contractLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mnr_contractLabel, 370, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mnr_contractLabel, 750, SpringLayout.WEST, leftPanel);

			leftPanel.add(mnr_contract);
			leftPanel.add(mnr_contractLabel);

			mdata_angajariiLabel = new JLabel("data angajarii: ");
			mdata_angajariiLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mdata_angajariiLabel, 430, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mdata_angajariiLabel, 600, SpringLayout.WEST, leftPanel);

			man = new JTextField(4);
			man.setFont(Constants.Fonts.font_input);
			man.setHorizontalAlignment(JTextField.CENTER);
			man.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			man.setBackground(Constants.Colors.back_search);
			man.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, man, 430, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, man, 980, SpringLayout.WEST, leftPanel);

			manLabel = new JLabel("anul: ");
			manLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, manLabel, 430, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, manLabel, 880, SpringLayout.WEST, leftPanel);

			leftPanel.add(mdata_angajariiLabel);
			leftPanel.add(man);
			leftPanel.add(manLabel);

			mluna = new JTextField(2);
			mluna.setFont(Constants.Fonts.font_input);
			mluna.setHorizontalAlignment(JTextField.CENTER);
			mluna.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mluna.setBackground(Constants.Colors.back_search);
			mluna.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mluna, 430, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mluna, 1140, SpringLayout.WEST, leftPanel);

			mlunaLabel = new JLabel("luna: ");
			mlunaLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mlunaLabel, 430, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mlunaLabel, 1050, SpringLayout.WEST, leftPanel);

			leftPanel.add(mluna);
			leftPanel.add(mlunaLabel);

			mzi = new JTextField(2);
			mzi.setFont(Constants.Fonts.font_input);
			mzi.setHorizontalAlignment(JTextField.CENTER);
			mzi.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mzi.setBackground(Constants.Colors.back_search);
			mzi.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mzi, 430, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mzi, 1280, SpringLayout.WEST, leftPanel);

			mziLabel = new JLabel("ziua: ");
			mziLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mziLabel, 430, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mziLabel, 1180, SpringLayout.WEST, leftPanel);

			leftPanel.add(mzi);
			leftPanel.add(mziLabel);

			mfunctie = new JTextField(14);
			mfunctie.setFont(Constants.Fonts.font_input);
			mfunctie.setHorizontalAlignment(JTextField.CENTER);
			mfunctie.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mfunctie.setBackground(Constants.Colors.back_search);
			mfunctie.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mfunctie, 490, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mfunctie, 980, SpringLayout.WEST, leftPanel);

			mfunctieLabel = new JLabel("functie: ");
			mfunctieLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mfunctieLabel, 490, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mfunctieLabel, 822, SpringLayout.WEST, leftPanel);

			leftPanel.add(mfunctie);
			leftPanel.add(mfunctieLabel);

			mcnp = new JTextField(14);
			mcnp.setFont(Constants.Fonts.font_input);
			mcnp.setHorizontalAlignment(JTextField.CENTER);
			mcnp.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mcnp.setBackground(Constants.Colors.back_search);
			mcnp.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mcnp, 540, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcnp, 980, SpringLayout.WEST, leftPanel);

			mcnpLabel = new JLabel("cnp: ");
			mcnpLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mcnpLabel, 540, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcnpLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(mcnp);
			leftPanel.add(mcnpLabel);

			addButton = new JButton("  modifica  ");
			addButton.addActionListener(new ModifyDatePersPeBuneListener());
			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 560, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 900, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}

	}

	private class ModifyAngajatListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();

			mcnp = new JTextField(14);
			mcnp.setFont(Constants.Fonts.font_input);
			mcnp.setHorizontalAlignment(JTextField.CENTER);
			mcnp.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mcnp.setBackground(Constants.Colors.back_search);
			mcnp.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mcnp, 50, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcnp, 1050, SpringLayout.WEST, leftPanel);

			mcnpLabel = new JLabel("cnp: ");
			mcnpLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mcnpLabel, 50, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcnpLabel, 970, SpringLayout.WEST, leftPanel);

			leftPanel.add(mcnp);
			leftPanel.add(mcnpLabel);

			msalariuNeg = new JTextField(14);
			msalariuNeg.setFont(Constants.Fonts.font_input);
			msalariuNeg.setHorizontalAlignment(JTextField.CENTER);
			msalariuNeg.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			msalariuNeg.setBackground(Constants.Colors.back_search);
			msalariuNeg.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, msalariuNeg, 150, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, msalariuNeg, 1050, SpringLayout.WEST, leftPanel);

			msalariuNegLabel = new JLabel("salariu: ");
			msalariuNegLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, msalariuNegLabel, 150, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, msalariuNegLabel, 900, SpringLayout.WEST, leftPanel);

			leftPanel.add(msalariuNeg);
			leftPanel.add(msalariuNegLabel);

			mnumarOreTotal = new JTextField(14);
			mnumarOreTotal.setFont(Constants.Fonts.font_input);
			mnumarOreTotal.setHorizontalAlignment(JTextField.CENTER);
			mnumarOreTotal.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mnumarOreTotal.setBackground(Constants.Colors.back_search);
			mnumarOreTotal.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mnumarOreTotal, 250, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mnumarOreTotal, 1050, SpringLayout.WEST, leftPanel);

			mnumarOreTotalLabel = new JLabel("numar de ore de munca totale: ");
			mnumarOreTotalLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mnumarOreTotalLabel, 250, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mnumarOreTotalLabel, 520, SpringLayout.WEST, leftPanel);

			leftPanel.add(mnumarOreTotal);
			leftPanel.add(mnumarOreTotalLabel);

			mtipOrar = new JTextField(14);
			mtipOrar.setFont(Constants.Fonts.font_input);
			mtipOrar.setHorizontalAlignment(JTextField.CENTER);
			mtipOrar.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mtipOrar.setBackground(Constants.Colors.back_search);
			mtipOrar.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mtipOrar, 350, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mtipOrar, 1050, SpringLayout.WEST, leftPanel);

			mtipOrarLabel = new JLabel("tip orar: ");
			mtipOrarLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mtipOrarLabel, 350, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mtipOrarLabel, 880, SpringLayout.WEST, leftPanel);

			leftPanel.add(mtipOrar);
			leftPanel.add(mtipOrarLabel);

			addButton = new JButton("  modifica  ");
			addButton.addActionListener(new ModifyAngajatPeBuneListener());
			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 450, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 900, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}

	}

	private class ModifyLoginPeBuneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SqlProcedures.modifyUserLogin(con, mcnp.getText(), musername.getText(), mpassword.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clean();
			a.validate();
			a.repaint();
		}

	}

	private class ModifyDatePersPeBuneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SqlProcedures.modifyUserDatePers(con, mcnp.getText(), mnume.getText(), mprenume.getText(),
						madresa.getText(), mtelefon.getText(), memail.getText(), mcont_IBAN.getText(),
						mnr_contract.getText(), man.getText(), mluna.getText(), mzi.getText(), mfunctie.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			clean();
			a.validate();
			a.repaint();
		}

	}

	private class ModifyAngajatPeBuneListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SqlProcedures.modifyAngajat(con, mcnp.getText(), Integer.parseInt(msalariuNeg.getText()),
						Integer.parseInt(mnumarOreTotal.getText()), Integer.parseInt(mtipOrar.getText()));
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			clean();
			a.validate();
			a.repaint();
		}

	}

	private class AddPoliListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();
			addProgram = new JButton("  adauga program ");
			addProgram.addActionListener(new AddProgramPoliclinicaListener());
			addProgramPanel = new JPanel();
			addProgram.setFont(Constants.Fonts.font_button);
			addProgramPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addProgramPanel, 10, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addProgramPanel, 850, SpringLayout.WEST, leftPanel);
			addProgramPanel.setBackground(Constants.Colors.frame_color_inspector);
			addProgramPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addProgramPanel.add(addProgram);
			addProgram.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addProgram.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addProgramPanel);

			id = new JTextField(14);
			id.setFont(Constants.Fonts.font_input);
			id.setHorizontalAlignment(JTextField.CENTER);
			id.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			id.setBackground(Constants.Colors.back_search);
			id.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, id, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, id, 1000, SpringLayout.WEST, leftPanel);

			idLabel = new JLabel("id policlinica: ");
			idLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, idLabel, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, idLabel, 720, SpringLayout.WEST, leftPanel);

			leftPanel.add(id);
			leftPanel.add(idLabel);

			denumire = new JTextField(14);
			denumire.setFont(Constants.Fonts.font_input);
			denumire.setHorizontalAlignment(JTextField.CENTER);
			denumire.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			denumire.setBackground(Constants.Colors.back_search);
			denumire.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, denumire, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, denumire, 1000, SpringLayout.WEST, leftPanel);

			denumireLabel = new JLabel("denumire policlinica: ");
			denumireLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, denumireLabel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, denumireLabel, 610, SpringLayout.WEST, leftPanel);

			leftPanel.add(denumire);
			leftPanel.add(denumireLabel);

			adresaPoliclinica = new JTextField(14);
			adresaPoliclinica.setFont(Constants.Fonts.font_input);
			adresaPoliclinica.setHorizontalAlignment(JTextField.CENTER);
			adresaPoliclinica.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			adresaPoliclinica.setBackground(Constants.Colors.back_search);
			adresaPoliclinica.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, adresaPoliclinica, 400, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, adresaPoliclinica, 1000, SpringLayout.WEST, leftPanel);

			adresaPoliclinicaLabel = new JLabel("adresa policlinica: ");
			adresaPoliclinicaLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, adresaPoliclinicaLabel, 400, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, adresaPoliclinicaLabel, 650, SpringLayout.WEST, leftPanel);

			leftPanel.add(adresaPoliclinica);
			leftPanel.add(adresaPoliclinicaLabel);

			addButton = new JButton("  adauga  ");
			addButtonPanel = new JPanel();
			addButton.addActionListener(new AddPoliclinicaPeBuneListener());
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 480, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 900, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}
	}

	private class AddProgramPoliclinicaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();

			id = new JTextField(14);
			id.setFont(Constants.Fonts.font_input);
			id.setHorizontalAlignment(JTextField.CENTER);
			id.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			id.setBackground(Constants.Colors.back_search);
			id.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, id, 150, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, id, 980, SpringLayout.WEST, leftPanel);

			idLabel = new JLabel("id policlinica: ");
			idLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, idLabel, 150, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, idLabel, 700, SpringLayout.WEST, leftPanel);

			leftPanel.add(id);
			leftPanel.add(idLabel);

			data_angajariiLabel = new JLabel("data: ");
			data_angajariiLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, data_angajariiLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, data_angajariiLabel, 750, SpringLayout.WEST, leftPanel);
			leftPanel.add(data_angajariiLabel);
			
			anP = new JTextField(4);
			anP.setFont(Constants.Fonts.font_input);
			anP.setHorizontalAlignment(JTextField.CENTER);
			anP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			anP.setBackground(Constants.Colors.back_search);
			anP.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, anP, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, anP, 980, SpringLayout.WEST, leftPanel);

			anPLabel = new JLabel("anul: ");
			anPLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, anPLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, anPLabel, 880, SpringLayout.WEST, leftPanel);

			leftPanel.add(anP);
			leftPanel.add(anPLabel);

			lunaP = new JTextField(2);
			lunaP.setFont(Constants.Fonts.font_input);
			lunaP.setHorizontalAlignment(JTextField.CENTER);
			lunaP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			lunaP.setBackground(Constants.Colors.back_search);
			lunaP.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, lunaP, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, lunaP, 1140, SpringLayout.WEST, leftPanel);

			lunaPLabel = new JLabel("luna: ");
			lunaPLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, lunaPLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, lunaPLabel, 1050, SpringLayout.WEST, leftPanel);

			leftPanel.add(lunaP);
			leftPanel.add(lunaPLabel);

			ziP = new JTextField(2);
			ziP.setFont(Constants.Fonts.font_input);
			ziP.setHorizontalAlignment(JTextField.CENTER);
			ziP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			ziP.setBackground(Constants.Colors.back_search);
			ziP.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, ziP, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, ziP, 1280, SpringLayout.WEST, leftPanel);

			ziPLabel = new JLabel("ziua: ");
			ziPLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, ziPLabel, 230, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, ziPLabel, 1180, SpringLayout.WEST, leftPanel);

			leftPanel.add(ziP);
			leftPanel.add(ziPLabel);

			start_p = new JTextField(14);
			start_p.setFont(Constants.Fonts.font_input);
			start_p.setHorizontalAlignment(JTextField.CENTER);
			start_p.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			start_p.setBackground(Constants.Colors.back_search);
			start_p.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, start_p, 310, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, start_p, 980, SpringLayout.WEST, leftPanel);

			start_pLabel = new JLabel("ora inceput: ");
			start_pLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, start_pLabel, 310, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, start_pLabel, 755, SpringLayout.WEST, leftPanel);

			leftPanel.add(start_p);
			leftPanel.add(start_pLabel);

			end_p = new JTextField(14);
			end_p.setFont(Constants.Fonts.font_input);
			end_p.setHorizontalAlignment(JTextField.CENTER);
			end_p.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			end_p.setBackground(Constants.Colors.back_search);
			end_p.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, end_p, 390, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, end_p, 980, SpringLayout.WEST, leftPanel);

			end_pLabel = new JLabel("ora sfarsit: ");
			end_pLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, end_pLabel, 390, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, end_pLabel, 755, SpringLayout.WEST, leftPanel);

			leftPanel.add(end_p);
			leftPanel.add(end_pLabel);

			addButton = new JButton("  adauga program  ");
			addButtonPanel = new JPanel();
			addButton.addActionListener(new ProgramListener());
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 450, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, addButtonPanel, 900, SpringLayout.WEST, leftPanel);
			addButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			addButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			addButtonPanel.add(addButton);
			addButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			addButton.setBackground(Constants.Colors.blue_dark);
			
			leftPanel.add(addButtonPanel);

			a.validate();
			a.repaint();
		}

	}

	private class ProgramListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				SqlProcedures.creareProgramUnitate(con, Integer.parseInt(id.getText()), anP.getText(), lunaP.getText(), ziP.getText(), start_p.getText(), end_p.getText());
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
			}
			clean();
			a.validate();
			a.repaint();
		}
		
	}
	
	
	private class AddPoliclinicaPeBuneListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				if (errorMessage!=null)
					leftPanel.remove(errorMessage);
				SqlProcedures.addPoliclinica(con, Integer.parseInt(id.getText()), denumire.getText(),
						adresaPoliclinica.getText());
				clean();
			} catch (NumberFormatException | SQLException e1) {
				e1.printStackTrace();
				
				errorMessage = new JLabel("date incorecte ");
				errorMessage.setFont(Constants.Fonts.font_label);
				slPanel.putConstraint(SpringLayout.NORTH, errorMessage, 140, SpringLayout.NORTH, leftPanel);
				slPanel.putConstraint(SpringLayout.WEST, errorMessage, 800, SpringLayout.WEST, leftPanel);
				leftPanel.add(errorMessage);
			}
	
			a.validate();
			a.repaint();
		}
	}
	
	private class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ResultSet rs;
			try {
				rs = SqlProcedures.getFunctieBack(con, cnpPeBune);
				while (rs.next()) {
					if (rs.getString("functie").equals("asistent medical")) {
						AsistentMedical a = new AsistentMedical(cnpPeBune, false, true);
					} else if (rs.getString("functie").equals("medic")) {
						 Medic a = new Medic(cnpPeBune, false, true);
					} else if (rs.getString("functie").equals("inspector")) {
						 Inspector a = new Inspector(cnpPeBune, false, true);
					} else if (rs.getString("functie").equals("expert")) {
						 Expert a = new Expert(cnpPeBune, false, true);
					} else if (rs.getString("functie").equals("receptioner")) {
						 Receptioner a = new Receptioner(cnpPeBune, false, true);
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}
	
	private class LogOutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			LogIn log= new LogIn();	
		}	
	}
}