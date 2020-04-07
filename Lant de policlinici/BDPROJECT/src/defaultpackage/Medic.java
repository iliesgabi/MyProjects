package defaultpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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

public class Medic extends ConClass {
	private Medic a;

	private JButton datePers;
	private JPanel datePersPanel;
	private JButton istoricPacient;
	private JPanel istoricPacientPanel;
	private JPanel pacientFieldPanel;
	private JTextField istoricPacientField;
	private JLabel istoricPacientLabel;
	private JButton viewProfit;
	private JPanel viewProfitPanel;
	private JButton logOut;
	private JPanel logOutPanel;
	private JPanel programariPanel;
	private JButton programariButton;

	private JPanel dp;
	private SpringLayout slPanel;
	private JLabel titleLabel;
	private JPanel titlePanel;
	private String cnp;
	private Integer id_istoric;

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
	private JPanel RaportPanel;

	private JPanel idIstoricP;
	private JPanel istP;
	private JPanel valBinP;
	private JPanel cnpAsistentP;
	private JPanel cnpMedicP;
	private JPanel cnpPacientP;
	private JPanel simptomeP;
	private JPanel diagnosticP;
	private JPanel recomandariP;
	private JPanel validP;
	private JPanel profitP;

	private JButton completareRaport;
	private JPanel completareRaportPanel;

	private JTextField numeMedicField;
	private JLabel numeMedicLabel;
	private JTextField prenumeMedicField;
	private JLabel prenumeMedicLabel;
	private JTextField numePacientField;
	private JLabel numePacientLabel;
	private JTextField prenumePacientField;
	private JLabel prenumePacientLabel;
	private JTextField CnpPacientField;
	private JLabel CnpPacientLabel;
	private JTextField dataField;
	private JLabel dataLabel;
	private JTextField istoricField;
	private JLabel istoricLabel;
	private JTextField simptomeField;
	private JLabel simptomeLabel;
	private JTextField diagnosticField;
	private JLabel diagnosticLabel;
	private JTextField recomandariField;
	private JLabel recomandariLabel;
	private JButton finalizareRaport;
	
	private JPanel [] startTimeArray=new JPanel[20];
	private JPanel [] endTimeArray=new JPanel[20];
	private JPanel [] progP=new JPanel[20];

	private JLabel startTimeL=new JLabel(" Start-time ");
	private JLabel endTimeL=new JLabel(" End-time ");
	private JLabel cnpPacientL = new JLabel ("CNP-pacient");
	
	private JButton superadminButton;
	private JPanel superadminButtonPanel;

	private JButton adminButton;
	private JPanel adminButtonPanel;
	
	private JPanel panelMare;
	private JPanel[] buceagaPanel=new JPanel[20];
	

	public Medic(String cnp,boolean admin,boolean superadmin) {
		this.init();
		this.a = this;
		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new GridLayout(1, 2));
		this.cnp = cnp;

	
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		rightPanel.setLayout(new SpringLayout());
		slPanel = new SpringLayout();
		leftPanel.setLayout(slPanel);

		titleLabel = new JLabel(" Medic ", SwingConstants.CENTER);
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
		slPanel.putConstraint(SpringLayout.WEST, logOutPanel, 200, SpringLayout.WEST, leftPanel);
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
			slPanel.putConstraint(SpringLayout.NORTH, superadminButtonPanel, 100, SpringLayout.NORTH, leftPanel);
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
			slPanel.putConstraint(SpringLayout.NORTH, adminButtonPanel, 100, SpringLayout.NORTH, leftPanel);
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
		slPanel.putConstraint(SpringLayout.NORTH, datePersPanel, 150, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, datePersPanel, 50, SpringLayout.WEST, leftPanel);
		datePersPanel.setBackground(Constants.Colors.frame_color_inspector);
		datePersPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		datePersPanel.add(datePers);
		datePers.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		datePers.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(datePersPanel);

		istoricPacient = new JButton("  Vizualizare Istoric Pacient  ");
		istoricPacient.addActionListener(new VisualIstoricPacientListener());
		istoricPacientPanel = new JPanel();
		istoricPacient.setFont(Constants.Fonts.font_button);
		istoricPacientPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, istoricPacientPanel, 220, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, istoricPacientPanel, 50, SpringLayout.WEST, leftPanel);
		istoricPacientPanel.setBackground(Constants.Colors.frame_color_inspector);
		istoricPacientPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		istoricPacientPanel.add(istoricPacient);
		istoricPacient.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		istoricPacient.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(istoricPacientPanel);

		istoricPacientField = new JTextField(10);
		istoricPacientField.setFont(Constants.Fonts.font_input);
		istoricPacientField.setHorizontalAlignment(JTextField.CENTER);
		pacientFieldPanel = new JPanel();
		istoricPacientLabel = new JLabel("CNP pacient:");
		istoricPacientLabel.setFont(Constants.Fonts.font_button);
		pacientFieldPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, pacientFieldPanel, 330, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, pacientFieldPanel, 80, SpringLayout.WEST, leftPanel);
		pacientFieldPanel.setBackground(Constants.Colors.frame_color_inspector);
		pacientFieldPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		pacientFieldPanel.add(istoricPacientLabel);
		pacientFieldPanel.add(istoricPacientField);
		pacientFieldPanel.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		pacientFieldPanel.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(pacientFieldPanel);

		programariButton = new JButton(" Programari ");
		programariButton.addActionListener(new VisualProgramariListener());
		programariPanel = new JPanel();
		programariButton.setFont(Constants.Fonts.font_button);
		programariPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, programariPanel, 360, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, programariPanel, 50, SpringLayout.WEST, leftPanel);
		programariPanel.setBackground(Constants.Colors.frame_color_inspector);
		programariPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		programariPanel.add(programariButton);
		programariButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		programariButton.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(programariPanel);
		
		viewProfit = new JButton("  Vizualizare Profit Medic  ");
		viewProfit.addActionListener(new VisualProfitListener());
		viewProfitPanel = new JPanel();
		viewProfit.setFont(Constants.Fonts.font_button);
		viewProfitPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, viewProfitPanel, 430, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, viewProfitPanel, 50, SpringLayout.WEST, leftPanel);
		viewProfitPanel.setBackground(Constants.Colors.frame_color_inspector);
		viewProfitPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		viewProfitPanel.add(viewProfit);
		viewProfit.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		viewProfit.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(viewProfitPanel);

		completareRaport = new JButton("Completare Raport ");
		completareRaport.addActionListener(new VisualRaportListener());
		completareRaportPanel = new JPanel();
		completareRaport.setFont(Constants.Fonts.font_button);
		completareRaportPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, completareRaportPanel,500, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, completareRaportPanel, 50, SpringLayout.WEST, leftPanel);
		completareRaportPanel.setBackground(Constants.Colors.frame_color_inspector);
		completareRaportPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		completareRaportPanel.add(completareRaport);
		completareRaport.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		completareRaport.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(completareRaportPanel);

		

	
		
		leftPanel.setBackground(Constants.Colors.frame_color_inspector);
		leftPanel.setVisible(true);
		
		
		rightPanel.setBackground(Constants.Colors.frame_color_inspector);
		this.add(leftPanel);
		this.add(rightPanel);
		this.validate();
		this.repaint();
	}

	private void clean() {
		leftPanel.remove(dp);
	}

	private class VisualDatePersListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10, 1, 10, 10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));

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
			rightPanel.removeAll();
			rightPanel.add(dp);
			a.validate();
			a.repaint();
		}

	}

	private class VisualProgramariListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10, 1, 10, 10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));
			
			rightPanel.removeAll();
			
			ProgramPanelMedic mp = new ProgramPanelMedic();
			int i = 1;
			int j=0;
			while (mp.getMatrixValues()[i][j] instanceof NodeMatrixMedic && i < 6) {
				i++;
			}
			
			ResultSet rs;
			try {
				rs = SqlProcedures.getProgramari((Connection) con, (String) cnp);
				while (rs.next()) {
					if(i<8) {
                    String cnp=rs.getString("CNP_medic");
					mp.addPanel("",rs.getString("start_p"),"",0, i,0);
					mp.addPanel("",rs.getString("end_p"),"", 0,i,1);
					mp.addPanel("","     "+cnp,"",0, i,2);
					mp.addPanel("","     "+rs.getString("id_unit"),"",0, i,3);
					System.out.println("Este a +"+i+" a programare pentru medicul cu CNP-ul : "+cnp);
					}
					i++;
				}
				mp.addValuesFromMatrix();
				dp.add(mp);
				
					

				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			rightPanel.add(mp);

			a.validate();
			a.repaint();
		}

	}
	
	private class VisualIstoricPacientListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JPanel panelMare = new JPanel();
			panelMare.setBackground(Constants.Colors.frame_color_inspector);
			panelMare.setLayout(new GridLayout(0,1,40,40));
			panelMare.setBorder(new EmptyBorder(70, 10, 10, 10));
			
		
			String s = istoricPacientField.getText();
			ResultSet rs;
			rightPanel.removeAll();
			
			 int i=0;
			try {
				rs = SqlProcedures.getIstoricPacient(con, s);
				while (rs.next()) {

				buceagaPanel[i] = new JPanel();
				buceagaPanel[i].setBackground(Constants.Colors.blue_dark);
				buceagaPanel[i].setBorder(new EmptyBorder (10,10,10,10));
				buceagaPanel[i].setLayout(new GridLayout(3,2,10,10));
				
					
					idIstoricP = new JPanel();
					idIstoricP.setPreferredSize(new Dimension(100,50));
					idIstoricP.setLayout(new GridLayout(2,1,1,1));
					JLabel l = new JLabel("id_istoric: ");
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					idIstoricP.add(l);
					l = new JLabel(rs.getString("id_istoric"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					idIstoricP.add(l);
					idIstoricP.setBackground(Constants.Colors.date_pers);
					idIstoricP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					buceagaPanel[i].add(idIstoricP);


					cnpMedicP = new JPanel();
					cnpMedicP.setPreferredSize(new Dimension(100,50));
					cnpMedicP.setLayout(new GridLayout(2,1,1,1));
					l = new JLabel("CNP_med: ");
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					cnpMedicP.add(l);
					l = new JLabel(rs.getString("cnp_medic"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					cnpMedicP.add(l);
					cnpMedicP.setBackground(Constants.Colors.date_pers);
					cnpMedicP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					buceagaPanel[i].add(cnpMedicP);

					cnpPacientP = new JPanel();
					cnpPacientP.setPreferredSize(new Dimension(100,50));
					cnpPacientP.setLayout(new GridLayout(2,1,1,1));
					l = new JLabel("CNP_pacient: ");
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					cnpPacientP.add(l);
					l = new JLabel(rs.getString("cnp_pacient"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					cnpPacientP.add(l);
					cnpPacientP.setBackground(Constants.Colors.date_pers);
					cnpPacientP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					buceagaPanel[i].add(cnpPacientP);


					simptomeP = new JPanel();
					simptomeP.setPreferredSize(new Dimension(100,50));
					simptomeP.setLayout(new GridLayout(2,1,1,1));
					l = new JLabel("simptome: ");
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					simptomeP.add(l);
					l = new JLabel(rs.getString("simptome"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					simptomeP.add(l);
					simptomeP.setBackground(Constants.Colors.date_pers);
					simptomeP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					buceagaPanel[i].add(simptomeP);

					diagnosticP = new JPanel();
					diagnosticP.setPreferredSize(new Dimension(100,50));
					diagnosticP.setLayout(new GridLayout(2,1,1,1));
					l = new JLabel("diagnostic: ");
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					diagnosticP.add(l);
					l = new JLabel(rs.getString("diagnostic"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					diagnosticP.add(l);
					diagnosticP.setBackground(Constants.Colors.date_pers);
					diagnosticP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					buceagaPanel[i].add(diagnosticP);

					recomandariP = new JPanel();
					recomandariP.setPreferredSize(new Dimension(100,50));
					recomandariP.setLayout(new GridLayout(2,1,1,1));
					l = new JLabel("recomandari: ");
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					recomandariP.add(l);
					l = new JLabel(rs.getString("recomandari"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					recomandariP.add(l);
					recomandariP.setBackground(Constants.Colors.date_pers);
					recomandariP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					buceagaPanel[i].add(recomandariP);
			
					
					panelMare.add(buceagaPanel[i]);
					i++;

				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			if(i>2) { JScrollPane scrollPane = new JScrollPane(panelMare);
		        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setPreferredSize(new Dimension(650,550));
                rightPanel.removeAll();
    			rightPanel.add(scrollPane);
			}
			
		else{	
		if (i>1)panelMare.setPreferredSize(new Dimension(650,550));
		else panelMare.setPreferredSize(new Dimension(650,275));
			rightPanel.removeAll();
			rightPanel.add(panelMare);
		}
			a.validate();
			a.repaint();
		}

	}

	private class VisualProfitListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10, 1, 10, 10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));

			ResultSet rs;
			try {
				rs = SqlProcedures.getProfitMedic((Connection) con, cnp);
				while (rs.next()) {

					profitP = new JPanel();
					profitP.setLayout(new FlowLayout());
					JLabel l = new JLabel("Profit personal: " + rs.getString("profit"));
					l.setAlignmentX(CENTER_ALIGNMENT);
					l.setFont(Constants.Fonts.font_button);
					profitP.add(l);
					profitP.setBackground(Constants.Colors.date_pers);
					profitP.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
					dp.add(profitP);

				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			slPanel.putConstraint(SpringLayout.NORTH, dp, 50, SpringLayout.NORTH, rightPanel);
			slPanel.putConstraint(SpringLayout.WEST, dp, 650, SpringLayout.WEST, rightPanel);
			rightPanel.removeAll();
			rightPanel.add(dp);
			a.validate();
			a.repaint();
		}
	}

	private class VisualRaportListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			dp = new JPanel();
			dp.setBackground(Constants.Colors.frame_color_inspector);
			dp.setPreferredSize(new Dimension(700, 550));
			dp.setLayout(new GridLayout(10,1,10,10));
			dp.setBorder(new EmptyBorder(70, 10, 10, 10));

		

			numeMedicLabel = new JLabel("Nume Medic :");
			numeMedicLabel.setFont(Constants.Fonts.font_label);
			dp.add(numeMedicLabel);
			numeMedicField = new JTextField();
			numeMedicField.setFont(Constants.Fonts.font_input);
			numeMedicField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(numeMedicField);

			prenumeMedicLabel = new JLabel("Prenume Medic :");
			prenumeMedicLabel.setFont(Constants.Fonts.font_label);
			dp.add(prenumeMedicLabel);
			prenumeMedicField = new JTextField();
			prenumeMedicField.setFont(Constants.Fonts.font_input);
			prenumeMedicField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(prenumeMedicField);

			numePacientLabel = new JLabel("Nume Pacient :");
			numePacientLabel.setFont(Constants.Fonts.font_label);
			dp.add(numePacientLabel);
			numePacientField = new JTextField();
			numePacientField.setFont(Constants.Fonts.font_input);
			numePacientField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(numePacientField);

			prenumePacientLabel = new JLabel("Prenume Pacient :");
			prenumePacientLabel.setFont(Constants.Fonts.font_label);
			dp.add(prenumePacientLabel);
			prenumePacientField = new JTextField();
			prenumePacientField.setFont(Constants.Fonts.font_input);
			prenumePacientField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(prenumePacientField);

			CnpPacientLabel = new JLabel("Cnp pacient :");
			CnpPacientLabel.setFont(Constants.Fonts.font_label);
			dp.add(CnpPacientLabel);
			CnpPacientField = new JTextField();
			CnpPacientField.setFont(Constants.Fonts.font_input);
			CnpPacientField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(CnpPacientField);

			istoricLabel = new JLabel("Istoric :");
			istoricLabel.setFont(Constants.Fonts.font_label);
			dp.add(istoricLabel);
			istoricField = new JTextField();
			istoricField.setFont(Constants.Fonts.font_input);
			istoricField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(istoricField);

			simptomeLabel = new JLabel("simptome :");
			simptomeLabel.setFont(Constants.Fonts.font_label);
			dp.add(simptomeLabel);
			simptomeField = new JTextField();
			simptomeField.setFont(Constants.Fonts.font_input);
			simptomeField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(simptomeField);

			diagnosticLabel = new JLabel("Diagnostic :");
			diagnosticLabel.setFont(Constants.Fonts.font_label);
			dp.add(diagnosticLabel);
			diagnosticField = new JTextField();
			diagnosticField.setFont(Constants.Fonts.font_input);
			diagnosticField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(diagnosticField);

			recomandariLabel = new JLabel("Recomandari :");
			recomandariLabel.setFont(Constants.Fonts.font_label);
			dp.add(recomandariLabel);
			recomandariField = new JTextField();
			recomandariField.setFont(Constants.Fonts.font_input);
			recomandariField.setHorizontalAlignment(JTextField.CENTER);
			dp.add(recomandariField);

			finalizareRaport = new JButton("Finalizare");
			finalizareRaport.setFont(Constants.Fonts.font_button);
			finalizareRaport.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
			finalizareRaport.setBackground(Constants.Colors.blue_dark);
			finalizareRaport.addActionListener(new VisualCompletareListener());
			dp.add(finalizareRaport);

			slPanel.putConstraint(SpringLayout.NORTH, dp, 50, SpringLayout.NORTH, rightPanel);
			slPanel.putConstraint(SpringLayout.WEST, dp, 650, SpringLayout.WEST, rightPanel);
			rightPanel.removeAll();
			rightPanel.add(dp);
		
			a.validate();
			a.repaint();
		}
	}

	private class VisualCompletareListener implements ActionListener {

		private String numeMedic;
		private String prenumeMedic;
		private String numePacient;
		private String prenumePacient;
		private String CNP_pacient;
		private String istoric;
		private String simptome;
		private String diagnostic;
		private String recomandari;

		public void actionPerformed(ActionEvent e) {
			System.out.println(numeMedicField.getText());
			System.out.println(CnpPacientField.getText());
			
			numeMedic = numeMedicField.getText();
			prenumeMedic = prenumeMedicField.getText();
			numePacient = numePacientField.getText();
			prenumePacient = prenumePacientField.getText();
			CNP_pacient = CnpPacientField.getText();
			istoric = istoricField.getText();
			simptome = simptomeField.getText();
			diagnostic = diagnosticField.getText();
			recomandari = recomandariField.getText();


			try {
				
				SqlProcedures.InsertIstoricPacient(con, cnp, CNP_pacient,simptome,diagnostic, recomandari);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				
				numeMedicField.setText("");
				prenumeMedicField.setText("");
				numePacientField.setText("");
				prenumePacientField.setText("");
				CnpPacientField.setText("");
				istoricField.setText("");
				simptomeField.setText("");
				diagnosticField.setText("");
				recomandariField.setText("");

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
