package defaultpackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ProgramPanelExpert extends JPanel{	
	
	private int[] apar;
	private int color_id;
	
	private JPanel[][]  matrixValues = {
			{new NodeMatrix("","Luni","",0,Constants.Colors.blue_dark,0,0),new NodeMatrix("","Marti","",0,Constants.Colors.blue_dark,0,0),new NodeMatrix("","Miercuri","",0,Constants.Colors.blue_dark,0,0),new NodeMatrix("","Joi","",0,Constants.Colors.blue_dark,0,0),new NodeMatrix("","Vineri","",0,Constants.Colors.blue_dark,0,0),new NodeMatrix("","Sambata","",0,Constants.Colors.blue_dark,0,0),new NodeMatrix("","Duminica","",0,Constants.Colors.blue_dark,0,0),},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel(),new JPanel()}
	};
	private JLabel titleLabel;
	private JPanel matrixPanel;
	private JButton deleteButton ;
	
	public ProgramPanelExpert() {
		this.deleteButton = deleteButton;
		this.setBackground(Constants.Colors.frame_color_inspector);
		this.setPreferredSize(new Dimension(700,550));
		
		apar = new int[14];
		
		matrixPanel = new JPanel();
		matrixPanel.setBackground(Constants.Colors.back_search);
		

		for(int i=1;i<6;i++)
			for(int j=0;j<7;j++) {
				matrixValues[i][j].setBackground(Constants.Colors.back_search);
		
			}
		
		titleLabel = new JLabel("Program");
		
		titleLabel.setFont(Constants.Fonts.font_label);
		
		
		SpringLayout slPanel = new SpringLayout();

		slPanel.putConstraint(SpringLayout.NORTH, matrixPanel, 60, SpringLayout.NORTH, this);
		slPanel.putConstraint(SpringLayout.WEST, matrixPanel, 10, SpringLayout.WEST, this);
		
		slPanel.putConstraint(SpringLayout.NORTH, titleLabel, 10, SpringLayout.NORTH, this);
		slPanel.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
		
		 matrixPanel.setBorder(new LineBorder(Constants.Colors.not_so_black,3));
		
		this.setLayout(slPanel);
		
		
		matrixPanel.setLayout(new GridLayout(6,7,10,10));
		
		this.add(matrixPanel);
		this.add(titleLabel);
	}
	
	
	public void addPanel(String start_p,String end_p,String unitate_n,Integer unitate_id,int i,int j) {
		int color_chosen = -1;
		Color c = null;
		for(int z=0;z<14;z++)
		{
			if(apar[z]==unitate_id)
			{
				color_chosen = z;
				break;
			}
		}
		
		if(color_chosen==-1)
		{
			apar[color_id] = unitate_id;
			color_chosen = color_id++;
		}
		
		switch(color_chosen) {
		case 0:
			c = Constants.Colors.unitate_1;
			break;
		case 1:
			c = Constants.Colors.unitate_2;
			break;
		case 2:
			c = Constants.Colors.unitate_3;
			break;
		case 3:
			c = Constants.Colors.unitate_4;
			break;
		case 4:
			c = Constants.Colors.unitate_5;
			break;
		case 5:
			c = Constants.Colors.unitate_6;
			break;
		case 6:
			c = Constants.Colors.unitate_7;
			break;
		case 7:
			c = Constants.Colors.unitate_8;
			break;
		case 8:
			c = Constants.Colors.unitate_9;
			break;
		case 9:
			c = Constants.Colors.unitate_10;
			break;
		case 10:
			c = Constants.Colors.unitate_11;
			break;
		case 11:
			c = Constants.Colors.unitate_12;
			break;
		case 12:
			c = Constants.Colors.unitate_13;
			break;
		case 13:
			c = Constants.Colors.unitate_14;
			break;
		default:
			color_id = 1;
			c = Constants.Colors.unitate_1;
			break;
		}
		NodeMatrix a = new NodeMatrix(start_p,end_p,unitate_n,unitate_id,c,i,j);
		matrixValues[i][j] = a;
	}
	
	public void addValuesFromMatrix() {
		matrixPanel.removeAll();
		for(int i=0;i<6;i++)
			for(int j=0;j<7;j++) {
				matrixPanel.add(matrixValues[i][j]);
			}
	}
	
	public JPanel[][] getMatrixValues(){
		return matrixValues;
	}
	
	
}