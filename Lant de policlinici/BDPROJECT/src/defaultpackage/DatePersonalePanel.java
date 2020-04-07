package defaultpackage;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DatePersonalePanel extends JPanel {
	public DatePersonalePanel() {
		this.setBackground(Constants.Colors.frame_color_inspector);
		this.setPreferredSize(new Dimension(700,550));
		
		this.setLayout(new GridLayout(10,1,10,10));
		this.setBorder(new EmptyBorder(70,10,10,10));

	}

	public void addPanel(JPanel a) {
		this.add(a);
	}
}
