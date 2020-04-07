package defaultpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DatePanel extends JPanel{
	public DatePanel(String txt) {
		this.setLayout(new FlowLayout());
		JLabel l = new JLabel(txt);
		l.setAlignmentX(CENTER_ALIGNMENT);
		l.setFont(Constants.Fonts.font_button);
		this.add(l);
		this.setBackground(Constants.Colors.date_pers);
		this.setBorder(new LineBorder(Constants.Colors.not_so_black,3));
	}
}
