package defaultpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

import defaultpackage.Constants.Colors;

public class ProgramPanelMedic extends JPanel{	
	
	private int[] apar;
	private int color_id;
	
	private JPanel[][]  matrixValues = {
			{new NodeMatrixMedic("","StartTime","",0,0,0),new NodeMatrixMedic("","EndTime","",0,0,0),new NodeMatrixMedic("","CNP-Pacient","",0,0,0),new NodeMatrixMedic("","idUnitate","",0,0,0)},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			{new JPanel(),new JPanel(),new JPanel(),new JPanel()},
			
			
	};
	private JLabel titleLabel;
	private JPanel matrixPanel;
	private JButton deleteButton ;
	
	public ProgramPanelMedic() {
		this.deleteButton = deleteButton;
		this.setBackground(Constants.Colors.frame_color_inspector);
		this.setPreferredSize(new Dimension(700,550));
		
		apar = new int[14];
		
		matrixPanel = new JPanel();
		matrixPanel.setBackground(Colors.not_so_black);
		

		for(int i=0;i<7;i++)
			for(int j=0;j<4;j++) {
				matrixValues[i][j].setBackground(Constants.Colors.back_search);
		
			}
		
		titleLabel = new JLabel("Programari   zi   curenta");
		
		titleLabel.setFont(Constants.Fonts.font_label);
		
		
		SpringLayout slPanel = new SpringLayout();

		slPanel.putConstraint(SpringLayout.NORTH, matrixPanel, 60, SpringLayout.NORTH, this);
		slPanel.putConstraint(SpringLayout.WEST, matrixPanel, 10, SpringLayout.WEST, this);
		
		slPanel.putConstraint(SpringLayout.NORTH, titleLabel, 10, SpringLayout.NORTH, this);
		slPanel.putConstraint(SpringLayout.WEST, titleLabel, 20, SpringLayout.WEST, this);
		
		 matrixPanel.setBorder(new LineBorder(Constants.Colors.not_so_black,3));
		
		this.setLayout(slPanel);
		
		
		matrixPanel.setLayout(new GridLayout(7,4,4,4));
		
		this.add(matrixPanel);
		this.add(titleLabel);
	}
	
	
	public void addPanel(String startT,String endT,String cnpP,Integer idUnit,int i,int j) {
		
		NodeMatrixMedic a = new NodeMatrixMedic(startT,endT,cnpP,idUnit,i,j);
		matrixValues[i][j] = a;
	}
	
	public void addValuesFromMatrix() {
		matrixPanel.removeAll();
		for(int i=0;i<7;i++)
			for(int j=0;j<4;j++) {
				matrixPanel.add(matrixValues[i][j]);
			}
	}
	
	public JPanel[][] getMatrixValues(){
		return matrixValues;
	}
}