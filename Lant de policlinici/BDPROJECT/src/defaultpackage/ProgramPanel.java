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

public class ProgramPanel extends JPanel{	
	
	private int[] apar;
	private int color_id;
	
	private Integer delete_i = -1;
	private Integer delete_j = -1;
	private Integer chosen_day = -1;
	
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
	
	public ProgramPanel(JButton deleteButton) {
		this.deleteButton = deleteButton;
		this.setBackground(Constants.Colors.frame_color_inspector);
		this.setPreferredSize(new Dimension(700,550));
		
		apar = new int[14];
		
		matrixPanel = new JPanel();
		matrixPanel.setBackground(Constants.Colors.back_search);
		
		for(int j=0;j<7;j++) {
			matrixValues[0][j].addMouseListener(new ChooseDayListener(j));
		}

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
	
	
	public Integer getDeleteI() {
		return delete_i;
	}
	
	public Integer getDeleteJ() {
		return delete_j;
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
		a.setRemove(new RemoveListener(i,j));
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
	
	
	public class ChooseDayListener implements MouseListener {

		private Integer day;
		
		public ChooseDayListener(Integer day) {
			this.day = day;
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(delete_i!=-1)
				matrixValues[delete_i][delete_j].setBackground(((NodeMatrix)matrixValues[delete_i][delete_j]).getColorInitial());
			if(chosen_day!=-1)
				matrixValues[0][chosen_day].setBackground(Constants.Colors.blue_dark);
			
			delete_i = -1;
			delete_j = -1;
			if(chosen_day!=day)
			{
			chosen_day = day;
			matrixValues[0][day].setBackground(Color.green);
			deleteButton.setText(" Add ");
			deleteButton.setBackground(Constants.Colors.blue_dark);
			}
			else {
				deleteButton.setText(" Nope ");
				deleteButton.setBackground(Constants.Colors.invalid);
				chosen_day = -1;
				matrixValues[0][day].setBackground(Constants.Colors.blue_dark);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public class RemoveListener implements MouseListener {

		private int i;
		private int j;
		
		public RemoveListener(int i,int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(chosen_day!=-1)
				matrixValues[0][chosen_day].setBackground(Constants.Colors.blue_dark);
			chosen_day = -1;
			
			if (((NodeMatrix)matrixValues[i][j]).getColor() == Constants.Colors.delete_color) {
				{
					((NodeMatrix)matrixValues[i][j]).setColor(((NodeMatrix)matrixValues[i][j]).getColorInitial());
					delete_i = -1;
					delete_j = -1;
					deleteButton.setText(" Nope ");
					deleteButton.setBackground(Constants.Colors.invalid);
				}
			} else {
				if(delete_i!=-1)
				{
					System.out.println(delete_i+" -- "+delete_j+" "+((NodeMatrix)matrixValues[delete_i][delete_j]).getColorInitial());
					((NodeMatrix)matrixValues[delete_i][delete_j]).setColor(((NodeMatrix)matrixValues[delete_i][delete_j]).getColorInitial());
				}
				deleteButton.setText(" Update ");
				deleteButton.setBackground(Constants.Colors.blue_dark);
				delete_i = i;
				delete_j = j;
				((NodeMatrix)matrixValues[i][j]).setColor(Constants.Colors.delete_color);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
	
	public Integer getDay() {
		return chosen_day;
	}
}
