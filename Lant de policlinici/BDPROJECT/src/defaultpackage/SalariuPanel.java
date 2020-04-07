package defaultpackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SalariuPanel extends JPanel{
	public SalariuPanel(String luna,String sal,String ore) {
		this.setBackground(Constants.Colors.frame_color_inspector);
		this.setPreferredSize(new Dimension(700,650));
	
		this.setLayout(new GridLayout(10,1));
		this.setBorder(new EmptyBorder(190,10,10,10));

		JLabel l1 = new JLabel(luna);
		l1.setFont(Constants.Fonts.font_label);
		JPanel l1_p = new JPanel();
		l1_p.setLayout(new FlowLayout(FlowLayout.CENTER));
		l1_p.setBackground(Constants.Colors.date_pers);
		l1_p.add(l1);
		
		JLabel l2 = new JLabel("Salariu: "+sal);
		l2.setFont(Constants.Fonts.font_label);
		JPanel l2_p = new JPanel();
		l2_p.setLayout(new FlowLayout(FlowLayout.CENTER));
		l2_p.setBackground(Constants.Colors.date_pers);
		l2_p.add(l2);
		
		JLabel l3 = new JLabel("Numar ore: "+ore);
		l3.setFont(Constants.Fonts.font_label);
		JPanel l3_p = new JPanel();
		l3_p.setLayout(new FlowLayout(FlowLayout.CENTER));
		l3_p.setBackground(Constants.Colors.date_pers);
		l3_p.add(l3);
		
		this.add(l1_p);
		this.add(l2_p);
		this.add(l3_p);
	}
	
	public void addPanel(JPanel a) {
		this.add(a);
	}
}
