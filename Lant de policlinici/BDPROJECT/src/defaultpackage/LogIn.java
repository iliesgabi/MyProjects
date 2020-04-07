package defaultpackage;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LogIn extends ConClass {
	private JLabel err;
	private JTextField username;
	private JTextField password;
	private JButton logInButton;
	private JPanel logInButtonPanel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private boolean superadmin;
	private boolean admin;
	private SpringLayout slPanel;
	private LogIn log;

	public LogIn()  {
		this.superadmin = false;
		this.admin = false;
		this.init();
		this.log = this;
		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		

		slPanel = new SpringLayout();
		leftPanel.setLayout(slPanel);

		username = new JTextField(14);
		username.setFont(Constants.Fonts.font_input);
		username.setHorizontalAlignment(JTextField.CENTER);
		username.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		username.setBackground(Constants.Colors.back_search);
		username.setPreferredSize(new Dimension(120, 40));
		slPanel.putConstraint(SpringLayout.NORTH, username, 130, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, username, 630, SpringLayout.WEST, leftPanel);

		usernameLabel = new JLabel("cnp: ");
		usernameLabel.setFont(Constants.Fonts.font_label);
		slPanel.putConstraint(SpringLayout.NORTH, usernameLabel, 130, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, usernameLabel, 510, SpringLayout.WEST, leftPanel);

		leftPanel.add(username);
		leftPanel.add(usernameLabel);

		password = new JPasswordField(14);
		password.setFont(Constants.Fonts.font_input);
		password.setHorizontalAlignment(JTextField.CENTER);
		password.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		password.setBackground(Constants.Colors.back_search);
		password.setPreferredSize(new Dimension(120, 40));
		slPanel.putConstraint(SpringLayout.NORTH, password, 180, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, password, 630, SpringLayout.WEST, leftPanel);

		passwordLabel = new JLabel("parola: ");
		passwordLabel.setFont(Constants.Fonts.font_label);
		slPanel.putConstraint(SpringLayout.NORTH, passwordLabel, 180, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, passwordLabel, 480, SpringLayout.WEST, leftPanel);

		leftPanel.add(password);
		leftPanel.add(passwordLabel);

		logInButton = new JButton("  Log In  ");
		logInButton.addActionListener(new LogInListener());
		logInButtonPanel = new JPanel();
		logInButton.setFont(Constants.Fonts.font_button);
		logInButtonPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, logInButtonPanel, 300, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, logInButtonPanel, 550, SpringLayout.WEST, leftPanel);
		logInButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
		logInButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		logInButtonPanel.add(logInButton);
		logInButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		logInButton.setBackground(Constants.Colors.blue_dark);

		leftPanel.add(logInButtonPanel);
		leftPanel.setBackground(Constants.Colors.frame_color_inspector);
		leftPanel.setVisible(true);

		this.add(leftPanel);
		this.validate();
		this.repaint();
	}

	private class LogInListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ResultSet rs2;
			try {
				rs2 = SqlProcedures.isAdmin(con, username.getText(), password.getText());
				while (rs2.next()) {
					if (rs2.getString("admin").equals("s")) {
						superadmin = true;
					} else if (rs2.getString("admin").equals("a")) {
						admin = true;
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			boolean ok = false;
			ResultSet rs;
			try {
				rs = SqlProcedures.getFunctie(con, username.getText(), password.getText());
				while (rs.next()) {

					if (rs.getString("functie").equals("asistent medical")) {
						AsistentMedical a = new AsistentMedical(username.getText(), admin, superadmin);
						ok = true;
					} else if (rs.getString("functie").equals("medic")) {
						 Medic a = new Medic(username.getText(), admin, superadmin);
						ok = true;
					} else if (rs.getString("functie").equals("inspector")) {
						 Inspector a = new Inspector(username.getText(), admin, superadmin);
						ok = true;
					} else if (rs.getString("functie").equals("expert")) {
						 Expert a = new Expert(username.getText(), admin, superadmin);
						ok = true;
					} else if (rs.getString("functie").equals("receptioner")) {
						 Receptioner a = new Receptioner(username.getText(), admin, superadmin);
						ok = true;
					}
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		if (ok == false) {
				err = new JLabel("cnp sau parola gresita");
				err.setFont(Constants.Fonts.font_label);
				slPanel.putConstraint(SpringLayout.NORTH, err, 250, SpringLayout.NORTH, leftPanel);
				slPanel.putConstraint(SpringLayout.WEST, err, 450, SpringLayout.WEST, leftPanel);

				leftPanel.add(err);
				log.validate();
				log.repaint();
			}
			
		}

	}
}