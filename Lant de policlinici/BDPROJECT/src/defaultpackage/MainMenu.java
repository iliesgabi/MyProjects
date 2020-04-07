package defaultpackage;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



public class MainMenu extends ConClass {
	private JButton logInButton;
	private JPanel logInButtonPanel;

	Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\catal\\Desktop\\hospital1.jpg");
	
	public MainMenu() {
		this.init();

		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		this.setContentPane(new JPanel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(img, 0, 0, this);
			}
		});
		pack();
		
		//leftPanel = new JPanel();
		//leftPanel.setOpaque(true);
		//SpringLayout slPanel = new SpringLayout();
		//leftPanel.setLayout(slPanel);
		logInButton = new JButton("  Log In  ");

		SpringLayout slPanel1 = new SpringLayout();
		//leftPanel.setLayout(slPanel1);
		logInButtonPanel = new JPanel();
		logInButton.setFont(Constants.Fonts.font_button);
		logInButtonPanel.setLayout(new GridLayout(1, 2));
		slPanel1.putConstraint(SpringLayout.NORTH, logInButtonPanel, 150, SpringLayout.NORTH, this);
		slPanel1.putConstraint(SpringLayout.WEST, logInButtonPanel, 550, SpringLayout.WEST, this);
		//logInButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
		logInButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		logInButtonPanel.add(logInButton);
		logInButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		//logInButton.setBackground(Constants.Colors.blue_dark);

		//leftPanel.add(logInButtonPanel);
		//leftPanel.setBackground(Constants.Colors.frame_color_inspector);
		//leftPanel.setVisible(true);
		//this.add(leftPanel);
		this.add(logInButtonPanel);
		this.validate();
		this.repaint();
	}



}
