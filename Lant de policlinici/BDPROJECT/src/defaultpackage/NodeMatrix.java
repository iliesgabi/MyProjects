package defaultpackage;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class NodeMatrix extends JPanel {
	private String start_p;
	private String end_p;
	private String unitate;
	private Integer unitate_id;
	private Color c;
	private Color c2;
	private Integer i;
	private Integer j;

	public NodeMatrix(String start_p, String end_p, String unitate_n,Integer unitate_id, Color c,Integer i,Integer j) {

		this.unitate_id = unitate_id;
		this.i = i;
		this.j = j;
		this.c = c;
		this.c2 = c;
		this.start_p = start_p;
		this.end_p = end_p;
		this.unitate = unitate;

		this.setBackground(c);

		this.setLayout(new GridLayout(3, 1));

		JLabel start = new JLabel(start_p);
		JLabel end = new JLabel(end_p);
		JLabel unitate = new JLabel(unitate_n);

		start.setAlignmentX(CENTER_ALIGNMENT);
		end.setAlignmentX(CENTER_ALIGNMENT);
		unitate.setAlignmentX(CENTER_ALIGNMENT);

		this.setBorder(new EmptyBorder(0, 10, 0, 10));

		if (end.getText() == "Luni" || end.getText() == "Marti" || end.getText() == "Miercuri" || end.getText() == "Joi"
				|| end.getText() == "Vineri" || end.getText() == "Sambata" || end.getText() == "Duminica") {
			end.setFont(Constants.Fonts.font_node_zile);
		} else {

			start.setFont(Constants.Fonts.font_node);
			end.setFont(Constants.Fonts.font_node);
			unitate.setFont(Constants.Fonts.font_node);
		}
		this.add(start);
		this.add(end);
		this.add(unitate);

	}

	public void setRemove(MouseListener a) {
		for(Component c:this.getComponents()) {
			c.addMouseListener(a);
		}
	}
	
	public Integer getUnitateId() {
		return unitate_id;
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
