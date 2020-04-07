package defaultpackage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class SalariuExpertNode extends JPanel{
	public SalariuExpertNode(String salariuS,String lunaS,Color color) {
		this.setLayout(new GridLayout(2,1,10,10));
		this.setBackground(color);
		this.setPreferredSize(new Dimension(200,100));
		
		this.setBorder(new LineBorder(Constants.Colors.not_so_black,3));
		
		
		JLabel luna = new JLabel(lunaS);
		JLabel salariu = new JLabel(salariuS);
		
		JPanel lunaP = new JPanel();
		lunaP.setLayout(new FlowLayout(FlowLayout.CENTER));
		lunaP.add(luna);
		
		JPanel salariuP = new JPanel();
		salariuP.setLayout(new FlowLayout(FlowLayout.CENTER));
		salariuP.add(salariu);
		
		luna.setAlignmentX(CENTER_ALIGNMENT);
		salariu.setAlignmentX(CENTER_ALIGNMENT);
		
		lunaP.setBackground(color);
		salariuP.setBackground(color);
		
		luna.setFont(Constants.Fonts.font_label);
		salariu.setFont(Constants.Fonts.font_label);
		
		this.add(lunaP);
		this.add(salariuP);
		
	}
}