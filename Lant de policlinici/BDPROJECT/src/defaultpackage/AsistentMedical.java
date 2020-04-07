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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AsistentMedical extends ConClass {
	private AsistentMedical a;

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
	private JButton datePers;
	private JPanel datePersPanel;
	private JButton parafareRaport;
	private JPanel parafareRaportPanel;
	private JButton raportAnalize;
	private JPanel raportAnalizePanel;
	private JButton logOut;
	private JPanel logOutPanel;

	private JPanel dp;
	private SpringLayout slPanel;
	private JLabel titleLabel;
	private JPanel titlePanel;
	private String cnp;

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

	private JButton editareDatePersBtn;
	private JPanel editareDatePersBtnPanel;
	private JButton concediu;
	private JPanel concediuPanel;
	private JButton program;
	private JPanel programPanel;
	private JButton salariuButton;
	private JPanel salariuPanel;

	private JButton modifyLogin;
	private JPanel modifyLoginPanel;

	private JButton modifyDatePers;
	private JPanel modifyDatePersPanel;

	private JButton modifyAngajat;
	private JPanel modifyAngajatPanel;

	private JButton addButton;
	private JPanel addButtonPanel;

	private JTextField idRap;
	private JLabel idRapLabel;
	private JLabel eroareLabel;
	private JLabel succesLabel;

	private JButton parafeazaRaport;
	private JPanel parafeazaRaportPanel;

	private AsistentSalariuPanel ep;
	private ConcediuPanelAsistent cp;
	private ProgramPanelExpert pe;

	private JTextField cnpPacient;
	private JLabel cnpPacientLabel;
	private JTextField rezultat;
	private JLabel rezultatLabel;


	private Color seasonsColor[][] = { { new Color(125, 192, 209), new Color(78, 164, 186), new Color(41, 144, 171) },
			{ new Color(103, 194, 89), new Color(84, 166, 71), new Color(60, 133, 49) },
			{ new Color(237, 235, 130), new Color(242, 245, 91), new Color(236, 240, 67) },
			{ new Color(217, 157, 93), new Color(194, 134, 70), new Color(201, 127, 48) } };

	private JButton superadminButton;
	private JPanel superadminButtonPanel;

	private JButton adminButton;
	private JPanel adminButtonPanel;

	public AsistentMedical(String cnp, boolean admin, boolean superadmin) {
		this.init();
		this.a = this;
		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.cnp = cnp;

		leftPanel = new JPanel();

		slPanel = new SpringLayout();
		leftPanel.setLayout(slPanel);

		titleLabel = new JLabel("Asistent Medical", SwingConstants.CENTER);
		titlePanel = new JPanel();
		titleLabel.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		titleLabel.setFont(Constants.Fonts.font_title);
		titleLabel.setBackground(Constants.Colors.blue_dark);
		titleLabel.setOpaque(true);
		titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		titlePanel.setBackground(Constants.Colors.frame_color_inspector);
		titlePanel.add(titleLabel);
		leftPanel.add(titlePanel);

		raportAnalize = new JButton("  raport analize  ");
		raportAnalize.addActionListener(new RaportAnalizeListener());
		raportAnalizePanel = new JPanel();
		raportAnalize.setFont(Constants.Fonts.font_button);
		raportAnalizePanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, raportAnalizePanel, 80, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, raportAnalizePanel, 50, SpringLayout.WEST, leftPanel);
		raportAnalizePanel.setBackground(Constants.Colors.frame_color_inspector);
		raportAnalizePanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		raportAnalizePanel.add(raportAnalize);
		raportAnalize.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		raportAnalize.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(raportAnalizePanel);

		parafareRaport = new JButton("  parafare raport  ");
		parafareRaport.addActionListener(new ParafareRaportListener());
		parafareRaportPanel = new JPanel();
		parafareRaport.setFont(Constants.Fonts.font_button);
		parafareRaportPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, parafareRaportPanel, 150, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, parafareRaportPanel, 50, SpringLayout.WEST, leftPanel);
		parafareRaportPanel.setBackground(Constants.Colors.frame_color_inspector);
		parafareRaportPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		parafareRaportPanel.add(parafareRaport);
		parafareRaport.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		parafareRaport.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(parafareRaportPanel);

		editareDatePersBtn = new JButton("  editeaza date personale  ");
		editareDatePersBtn.addActionListener(new ModifyUserListener());
		editareDatePersBtnPanel = new JPanel();
		editareDatePersBtn.setFont(Constants.Fonts.font_button);
		editareDatePersBtnPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, editareDatePersBtnPanel, 220, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, editareDatePersBtnPanel, 50, SpringLayout.WEST, leftPanel);
		editareDatePersBtnPanel.setBackground(Constants.Colors.frame_color_inspector);
		editareDatePersBtnPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		editareDatePersBtnPanel.add(editareDatePersBtn);
		editareDatePersBtn.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		editareDatePersBtn.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(editareDatePersBtnPanel);

		datePers = new JButton("  vizualizeaza date personale  ");
		datePers.addActionListener(new VisualDatePersListener());
		datePersPanel = new JPanel();
		datePers.setFont(Constants.Fonts.font_button);
		datePersPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, datePersPanel, 290, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, datePersPanel, 50, SpringLayout.WEST, leftPanel);
		datePersPanel.setBackground(Constants.Colors.frame_color_inspector);
		datePersPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		datePersPanel.add(datePers);
		datePers.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		datePers.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(datePersPanel);

		salariuButton = new JButton("  salariu personal  ");
		salariuPanel = new JPanel();
		salariuButton.addActionListener(new buttonSalariuListener());
		salariuButton.setFont(Constants.Fonts.font_button);
		salariuPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, salariuPanel, 360, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, salariuPanel, 50, SpringLayout.WEST, leftPanel);
		salariuPanel.setBackground(Constants.Colors.frame_color_inspector);
		salariuPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		salariuPanel.add(salariuButton);
		salariuButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		salariuButton.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(salariuPanel);

		program = new JButton("  program  ");
		programPanel = new JPanel();
		program.addActionListener(new buttonProgramListener());
		program.setFont(Constants.Fonts.font_button);
		programPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, programPanel, 430, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, programPanel, 50, SpringLayout.WEST, leftPanel);
		programPanel.setBackground(Constants.Colors.frame_color_inspector);
		programPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		programPanel.add(program);
		program.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		program.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(programPanel);

		concediu = new JButton("  concediu  ");
		concediuPanel = new JPanel();
		concediu.addActionListener(new buttonConcediuListener());
		concediu.setFont(Constants.Fonts.font_button);
		concediuPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, concediuPanel, 500, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, concediuPanel, 50, SpringLayout.WEST, leftPanel);
		concediuPanel.setBackground(Constants.Colors.frame_color_inspector);
		concediuPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		concediuPanel.add(concediu);
		concediu.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		concediu.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(concediuPanel);

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

		if (superadmin == true) {
			superadminButton = new JButton("  superadmin  ");
			superadminButton.addActionListener(new SuperadminListener());
			superadminButtonPanel = new JPanel();
			superadminButton.setFont(Constants.Fonts.font_button);
			superadminButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, superadminButtonPanel, 600, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, superadminButtonPanel, 1130, SpringLayout.WEST, leftPanel);
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
			slPanel.putConstraint(SpringLayout.NORTH, adminButtonPanel, 600, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, adminButtonPanel, 1170, SpringLayout.WEST, leftPanel);
			adminButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
			adminButtonPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			adminButtonPanel.add(adminButton);
			adminButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			adminButton.setBackground(Constants.Colors.blue_dark);

			leftPanel.add(adminButtonPanel);
		}

		leftPanel.setBackground(Constants.Colors.frame_color_inspector);
		leftPanel.setVisible(true);
		this.add(leftPanel);
		this.validate();
		this.repaint();
	}

	private void clean() {
		if (dp != null)
			leftPanel.remove(dp);
		if (ep != null)
			leftPanel.remove(ep);
		if (cp != null)
			leftPanel.remove(cp);
		if (pe != null)
			leftPanel.remove(pe);
		if (modifyLogin != null) {
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

		if (eroareLabel != null)
			leftPanel.remove(eroareLabel);
		if (succesLabel != null)
			leftPanel.remove(succesLabel);
		if (parafeazaRaport != null) {
			leftPanel.remove(parafeazaRaportPanel);
			leftPanel.remove(idRapLabel);
			leftPanel.remove(idRap);
		}
		if (cnpPacient != null) {
			leftPanel.remove(cnpPacient);
			leftPanel.remove(cnpPacientLabel);
			leftPanel.remove(rezultat);
			leftPanel.remove(rezultatLabel);
			leftPanel.remove(addButtonPanel);
		}

	}

	private class VisualDatePersListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();
			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10, 1, 10, 10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));

			ResultSet rs;
			try {
				rs = SqlProcedures.getDatePersonale(con, cnp);
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

			slPanel.putConstraint(SpringLayout.NORTH, dp, 50, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, dp, 650, SpringLayout.WEST, leftPanel);
			leftPanel.add(dp);
			a.validate();
			a.repaint();
		}

	}

	private class ParafareRaportListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			clean();
			idRap = new JTextField(14);
			idRap.setFont(Constants.Fonts.font_input);
			idRap.setHorizontalAlignment(JTextField.CENTER);
			idRap.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			idRap.setBackground(Constants.Colors.back_search);
			idRap.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, idRap, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, idRap, 1000, SpringLayout.WEST, leftPanel);

			idRapLabel = new JLabel("numar raport: ");
			idRapLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, idRapLabel, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, idRapLabel, 750, SpringLayout.WEST, leftPanel);

			leftPanel.add(idRap);
			leftPanel.add(idRapLabel);

			parafeazaRaport = new JButton("  parafeaza raport  ");
			parafeazaRaport.addActionListener(new ParafeazaListener());
			parafeazaRaportPanel = new JPanel();
			parafeazaRaport.setFont(Constants.Fonts.font_button);
			parafeazaRaportPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, parafeazaRaportPanel, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, parafeazaRaportPanel, 750, SpringLayout.WEST, leftPanel);
			parafeazaRaportPanel.setBackground(Constants.Colors.frame_color_inspector);
			parafeazaRaportPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
			parafeazaRaportPanel.add(parafeazaRaport);
			parafeazaRaport.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			parafeazaRaport.setBackground(Constants.Colors.blue_dark);

			leftPanel.add(parafeazaRaportPanel);

			a.validate();
			a.repaint();
		}

	}

	private class ParafeazaListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (succesLabel != null) {
				leftPanel.remove(succesLabel);
			}
			if (eroareLabel != null) {
				leftPanel.remove(eroareLabel);
			}
			ResultSet rs;
			try {
				rs = SqlProcedures.isParafat(con, Integer.parseInt(idRap.getText()));
				while (rs.next()) {
					if (rs.getString("val_bin").equals("1")) {
						if (succesLabel != null)
							leftPanel.remove(succesLabel);

						eroareLabel = new JLabel("acest raport e deja parafat ");
						eroareLabel.setFont(Constants.Fonts.font_label);
						slPanel.putConstraint(SpringLayout.NORTH, eroareLabel, 300, SpringLayout.NORTH, leftPanel);
						slPanel.putConstraint(SpringLayout.WEST, eroareLabel, 730, SpringLayout.WEST, leftPanel);
						leftPanel.add(eroareLabel);
					} else {
						if (eroareLabel != null)
							leftPanel.remove(eroareLabel);
						try {
							SqlProcedures.parafareRaport(con, Integer.parseInt(idRap.getText()), cnp);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						succesLabel = new JLabel("parafare realizata cu succes ");
						succesLabel.setFont(Constants.Fonts.font_label);
						slPanel.putConstraint(SpringLayout.NORTH, succesLabel, 300, SpringLayout.NORTH, leftPanel);
						slPanel.putConstraint(SpringLayout.WEST, succesLabel, 730, SpringLayout.WEST, leftPanel);
						leftPanel.add(succesLabel);
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			a.validate();
			a.repaint();
		}

	}

	private class RaportAnalizeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			clean();

			cnpPacient = new JTextField(14);
			cnpPacient.setFont(Constants.Fonts.font_input);
			cnpPacient.setHorizontalAlignment(JTextField.CENTER);
			cnpPacient.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			cnpPacient.setBackground(Constants.Colors.back_search);
			cnpPacient.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, cnpPacient, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnpPacient, 1000, SpringLayout.WEST, leftPanel);

			cnpPacientLabel = new JLabel("cnp pacient: ");
			cnpPacientLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, cnpPacientLabel, 160, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, cnpPacientLabel, 750, SpringLayout.WEST, leftPanel);

			leftPanel.add(cnpPacient);
			leftPanel.add(cnpPacientLabel);

			rezultat = new JTextField(14);
			rezultat.setFont(Constants.Fonts.font_input);
			rezultat.setHorizontalAlignment(JTextField.CENTER);
			rezultat.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			rezultat.setBackground(Constants.Colors.back_search);
			rezultat.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, rezultat, 260, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, rezultat, 1000, SpringLayout.WEST, leftPanel);

			rezultatLabel = new JLabel("rezultat: ");
			rezultatLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, rezultatLabel, 260, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, rezultatLabel, 807, SpringLayout.WEST, leftPanel);

			leftPanel.add(rezultat);
			leftPanel.add(rezultatLabel);

			addButton = new JButton("  adauga  ");
			addButton.addActionListener(new AdaugaRaport());
			addButtonPanel = new JPanel();
			addButton.setFont(Constants.Fonts.font_button);
			addButtonPanel.setLayout(new GridLayout(1, 2));
			slPanel.putConstraint(SpringLayout.NORTH, addButtonPanel, 340, SpringLayout.NORTH, leftPanel);
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

	private class AdaugaRaport implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ResultSet rs;
			if (eroareLabel != null) {
				leftPanel.remove(eroareLabel);
			}
			if (succesLabel != null) {
				leftPanel.remove(succesLabel);
			}
			boolean ok2 = false;
			boolean ok = false;
			try {
				rs = SqlProcedures.estePacient(con, cnpPacient.getText());
				while (rs.next()) {
					ResultSet rs2;
					rs2 = SqlProcedures.idIstoric(con, cnpPacient.getText());
					while (rs2.next() && ok2 == false) {
						try {
							SqlProcedures.creareRaport(con, Integer.parseInt(rs2.getString("id_istoric")),Integer.parseInt(rezultat.getText()));
							ok = true;
						} catch (NumberFormatException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						succesLabel = new JLabel("raport analize adaugat cu succes ");
						succesLabel.setFont(Constants.Fonts.font_label);
						slPanel.putConstraint(SpringLayout.NORTH, succesLabel, 300, SpringLayout.NORTH, leftPanel);
						slPanel.putConstraint(SpringLayout.WEST, succesLabel, 730, SpringLayout.WEST, leftPanel);
						leftPanel.add(succesLabel);
						ok2 = true;
					}
				}
				if (ok == false) {
					eroareLabel = new JLabel("acest pacient nu exista ");
					eroareLabel.setFont(Constants.Fonts.font_label);
					slPanel.putConstraint(SpringLayout.NORTH, eroareLabel, 300, SpringLayout.NORTH, leftPanel);
					slPanel.putConstraint(SpringLayout.WEST, eroareLabel, 730, SpringLayout.WEST, leftPanel);
					leftPanel.add(eroareLabel);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// clean();
			a.validate();
			a.repaint();
		}

	}
	private class buttonSalariuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();
			String numeAngajat = "Eroare";

			try {
				numeAngajat = SqlProcedures.getName(con, cnp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			ep = new AsistentSalariuPanel(" Salariu -> " + numeAngajat);

			int i = 0;
			int j = 1;

			try {
				ResultSet rs = SqlProcedures.getSalariuAngajat(con, cnp);

				for (int z = 0; z < 12; z++) {
					ep.addPanel(new SalariuAsistentNode(rs.getString(1), getLuna(i * 3 + j - 1), seasonsColor[i][j]), i,
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
			slPanel.putConstraint(SpringLayout.NORTH, ep, 50, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, ep, 600, SpringLayout.WEST, leftPanel);
			leftPanel.add(ep);

			a.validate();
			a.repaint();
		}
	}

	private class buttonProgramListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			clean();
			try {
				ResultSet rs = SqlProcedures.getProgramAngajat(con, cnp);
				pe = new ProgramPanelExpert();
				while (rs.next()) {
					int j = Integer.parseInt(rs.getString("zi")) - 1;
					int i = 1;
					while (pe.getMatrixValues()[i][j] instanceof NodeMatrix && i < 6) {
						i++;
					}
					pe.addPanel(rs.getString("start_p"), rs.getString("end_p"), rs.getString("nume_unitate"),
							Integer.parseInt(rs.getString("id_unit")), i, j);
				}
				pe.addValuesFromMatrix();
				slPanel.putConstraint(SpringLayout.NORTH, pe, 50, SpringLayout.NORTH, leftPanel);
				slPanel.putConstraint(SpringLayout.WEST, pe, 600, SpringLayout.WEST, leftPanel);
				leftPanel.add(pe);

				a.validate();
				a.repaint();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private class buttonConcediuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clean();
			ResultSet rs;
			int i1 = 0;
			int j1 = 0;
			try {
				rs = SqlProcedures.getConcediuAngajat(con, cnp);
				cp = new ConcediuPanelAsistent();
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
				slPanel.putConstraint(SpringLayout.NORTH, cp, 50, SpringLayout.NORTH, leftPanel);
				slPanel.putConstraint(SpringLayout.WEST, cp, 600, SpringLayout.WEST, leftPanel);
				leftPanel.add(cp);

				a.validate();
				a.repaint();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			slPanel.putConstraint(SpringLayout.NORTH, mcnp, 100, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcnp, 1060, SpringLayout.WEST, leftPanel);

			mcnpLabel = new JLabel("cnp: ");
			mcnpLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mcnpLabel, 100, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mcnpLabel, 980, SpringLayout.WEST, leftPanel);

			leftPanel.add(mcnp);
			leftPanel.add(mcnpLabel);

			msalariuNeg = new JTextField(14);
			msalariuNeg.setFont(Constants.Fonts.font_input);
			msalariuNeg.setHorizontalAlignment(JTextField.CENTER);
			msalariuNeg.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			msalariuNeg.setBackground(Constants.Colors.back_search);
			msalariuNeg.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, msalariuNeg, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, msalariuNeg, 1060, SpringLayout.WEST, leftPanel);

			msalariuNegLabel = new JLabel("salariu: ");
			msalariuNegLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, msalariuNegLabel, 200, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, msalariuNegLabel, 910, SpringLayout.WEST, leftPanel);

			leftPanel.add(msalariuNeg);
			leftPanel.add(msalariuNegLabel);

			mnumarOreTotal = new JTextField(14);
			mnumarOreTotal.setFont(Constants.Fonts.font_input);
			mnumarOreTotal.setHorizontalAlignment(JTextField.CENTER);
			mnumarOreTotal.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mnumarOreTotal.setBackground(Constants.Colors.back_search);
			mnumarOreTotal.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mnumarOreTotal, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mnumarOreTotal, 1060, SpringLayout.WEST, leftPanel);

			mnumarOreTotalLabel = new JLabel("nr de ore de munca totale: ");
			mnumarOreTotalLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mnumarOreTotalLabel, 300, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mnumarOreTotalLabel, 588, SpringLayout.WEST, leftPanel);

			leftPanel.add(mnumarOreTotal);
			leftPanel.add(mnumarOreTotalLabel);

			mtipOrar = new JTextField(14);
			mtipOrar.setFont(Constants.Fonts.font_input);
			mtipOrar.setHorizontalAlignment(JTextField.CENTER);
			mtipOrar.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			mtipOrar.setBackground(Constants.Colors.back_search);
			mtipOrar.setPreferredSize(new Dimension(120, 40));
			slPanel.putConstraint(SpringLayout.NORTH, mtipOrar, 400, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mtipOrar, 1060, SpringLayout.WEST, leftPanel);

			mtipOrarLabel = new JLabel("tip orar: ");
			mtipOrarLabel.setFont(Constants.Fonts.font_label);
			slPanel.putConstraint(SpringLayout.NORTH, mtipOrarLabel, 400, SpringLayout.NORTH, leftPanel);
			slPanel.putConstraint(SpringLayout.WEST, mtipOrarLabel, 890, SpringLayout.WEST, leftPanel);

			leftPanel.add(mtipOrar);
			leftPanel.add(mtipOrarLabel);

			addButton = new JButton("  modifica  ");
			addButton.addActionListener(new ModifyAngajatPeBuneListener());
			addButtonPanel = new JPanel();
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

	public class AdminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Admin a = new Admin(cnp);
		}

	}

	public class SuperadminListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Superadmin a = new Superadmin(cnp);
		}

	}

	public class LogOutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			LogIn log = new LogIn();

		}

	}

}