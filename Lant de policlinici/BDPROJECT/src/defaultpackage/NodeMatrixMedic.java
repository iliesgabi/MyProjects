package defaultpackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import defaultpackage.Constants.Colors;

public class NodeMatrixMedic extends JPanel {
	private String start_p;
	private String end_p;
    private String CNP_pacient;
	private Integer i;
	private Integer j;
	private Integer idUnit;

	public NodeMatrixMedic(String start_p, String end_p, String CNP_pacient,Integer idUnit ,Integer i,Integer j) {

		this.setBackground(Constants.Colors.frame_color_inspector);
		this.i = i;
		this.j = j;
        this.CNP_pacient=CNP_pacient;
		this.start_p = start_p;
		this.end_p = end_p;
        this.idUnit=idUnit;
        
		this.setBackground(Constants.Colors.blue_dark);

		this.setLayout(new GridLayout(4, 1));

		JLabel start = new JLabel(start_p);
		JLabel end = new JLabel(end_p);
		JLabel CNP= new JLabel(CNP_pacient);
		JLabel idUnitate = new JLabel(""+idUnit);
		
		start.setAlignmentX(CENTER_ALIGNMENT);
		end.setAlignmentX(CENTER_ALIGNMENT);
		CNP.setAlignmentX(CENTER_ALIGNMENT);
        idUnitate.setAlignmentX(CENTER_ALIGNMENT);
        
		this.setBorder(new EmptyBorder(0, 10, 0, 10));

		

			start.setFont(Constants.Fonts.font_node);
			end.setFont(Constants.Fonts.font_node);
			CNP.setFont(Constants.Fonts.font_node);
			idUnitate.setFont(Constants.Fonts.font_node);
		
		this.add(start);
		this.add(end);
		this.add(CNP);
		this.add(idUnitate);

	}

	public void setRemove(MouseListener a) {
		for(Component c:this.getComponents()) {
			c.addMouseListener(a);
		}
	}
	
	public String getCNP() {
		return CNP_pacient;
	}
	
	public String getStart() {
		return start_p;
	}
	
	public String getEnd() {
		return end_p;
	}
	public Integer getidUnit()
	{
		return idUnit;
	}

}
