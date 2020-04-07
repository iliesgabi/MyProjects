package defaultpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ExpertSalariuPanel extends JPanel {

	private JLabel titleLabel;
	private JPanel[][] matrixValues ;

	private JPanel matrixPanel;

	public ExpertSalariuPanel(String title) {

		matrixValues = new JPanel[4][3];
		
		for(int i=0;i<4;i++)
			for(int j=0;j<3;j++) {
				matrixValues[i][j] = new JPanel();
				matrixValues[i][j].setBackground(Constants.Colors.back_search);
			}
		titleLabel = new JLabel(title);
		titleLabel.setFont(Constants.Fonts.font_label);

		matrixPanel = new JPanel();
		matrixPanel.setLayout(new GridLayout(4, 3,20,20));

		this.setBackground(Constants.Colors.frame_color_inspector);
		this.setPreferredSize(new Dimension(700, 600));

		SpringLayout slPanel = new SpringLayout();

		slPanel.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
		slPanel.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);

		slPanel.putConstraint(SpringLayout.NORTH, matrixPanel, 70, SpringLayout.NORTH, this);
		slPanel.putConstraint(SpringLayout.WEST, matrixPanel, 30, SpringLayout.WEST, this);

		this.setLayout(slPanel);
		this.setBackground(Constants.Colors.frame_color_inspector);
		
		
		matrixPanel.setBackground(Constants.Colors.back_search);
		matrixPanel.setBorder(new LineBorder(Color.black,3));
		
		this.add(titleLabel);
		this.add(matrixPanel);

		this.validate();
		this.repaint();
	}

	public void addPanel(JPanel a, int i, int j) {
		matrixValues[i][j] = a;
	}

	public void addAllValues() {
		matrixPanel.removeAll();
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 3; j++)
				matrixPanel.add(matrixValues[i][j]);

		this.validate();
		this.repaint();
	}
}
