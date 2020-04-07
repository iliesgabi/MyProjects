package defaultpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import defaultpackage.Constants.Colors;

public class MainMenuGabi extends ConClass {
	private JButton logInButton;
	private JPanel logInButtonPanel;

	public MainMenuGabi() {
		this.init();
		leftPanel = new JPanel();
		SpringLayout slPanel = new SpringLayout();
		leftPanel.setLayout(slPanel);
		
		
		JPanel picPanel = new JPanel();
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("C:\\\\Users\\\\catal\\\\Desktop\\\\img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));

		picPanel.setPreferredSize(new Dimension(Constants.Dimensions.frame_width, 300));

		picPanel.setBackground(Colors.frame_color_inspector);
		picPanel.add(picLabel);


		leftPanel.add(picPanel);

		this.setSize(Constants.Dimensions.frame_width, Constants.Dimensions.frame_height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		leftPanel.setBackground(Colors.frame_color_inspector);
		slPanel = new SpringLayout();
		leftPanel.setLayout(slPanel);
		logInButton = new JButton("  Log In  ");
		logInButton.addActionListener(new LogInListener());
		logInButtonPanel = new JPanel();
		logInButton.setFont(Constants.Fonts.font_button);
		logInButtonPanel.setLayout(new GridLayout(1, 2));
		slPanel.putConstraint(SpringLayout.NORTH, logInButtonPanel, 300, SpringLayout.NORTH, leftPanel);
		slPanel.putConstraint(SpringLayout.WEST, logInButtonPanel, 620, SpringLayout.WEST, leftPanel);
		// logInButtonPanel.setBackground(Constants.Colors.frame_color_inspector);
		// logInButtonPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
		logInButtonPanel.add(logInButton);
		logInButton.setBorder(new LineBorder(Constants.Colors.not_so_black, 3));
		logInButton.setBackground(Constants.Colors.blue_dark);
		leftPanel.add(logInButtonPanel);

		// leftPanel.setBackground(Constants.Colors.frame_color_inspector);
		leftPanel.setVisible(true);
		this.add(leftPanel);
		this.validate();
		this.repaint();
	}

	private class LogInListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LogIn log = new LogIn();
		}
	}
}
