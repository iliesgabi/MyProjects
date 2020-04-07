package defaultpackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NodeMatrixConcediu extends JPanel{
	private String start_p;
	private String end_p;
	private String unitate_n;
	private Color c;
	private Color c2;
	private Integer i;
	private Integer j;

	public NodeMatrixConcediu(String start_p, String end_p, String unitate_n, Color c,Integer i,Integer j) {

		this.i = i;
		this.j = j;
		this.c = c;
		this.c2 = c;
		this.start_p = start_p;
		this.end_p = end_p;
		this.unitate_n = unitate_n;

		this.setBackground(c);

		this.setLayout(new GridLayout(3, 1));

		JLabel start = new JLabel("Y:"+start_p);
		JLabel end = new JLabel("M:"+end_p);
		JLabel unitate = new JLabel("D:"+unitate_n);

		start.setAlignmentX(CENTER_ALIGNMENT);
		end.setAlignmentX(CENTER_ALIGNMENT);
		unitate.setAlignmentX(CENTER_ALIGNMENT);

		this.setBorder(new EmptyBorder(0, 10, 0, 10));

			start.setFont(Constants.Fonts.font_node_zile);
			end.setFont(Constants.Fonts.font_node_zile);
			unitate.setFont(Constants.Fonts.font_node_zile);
		
		this.add(start);
		this.add(end);
		this.add(unitate);

	}

	public void setRemove(MouseListener a) {
		for(Component c:this.getComponents()) {
			c.addMouseListener(a);
		}
	}
	
	public String getUnitate() {
		return unitate_n;
	}
	
	public String getStart() {
		return start_p;
	}
	
	public String getEnd() {
		return end_p;
	}
	
	public Color getColor() {
		return c2;
	}

	public Color getColorInitial() {
		return c;
	}

	public void setColor(Color c) {
		this.c2 = c;
		this.setBackground(c);
	}
}