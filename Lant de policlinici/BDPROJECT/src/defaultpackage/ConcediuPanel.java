package defaultpackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

public class ConcediuPanel extends JPanel {

	private JPanel matrixPanel;
	private JLabel titleLabel;

	private Integer delete_i;
	private Integer delete_j;
	
	private JPanel[][] matrixValues = {
			{ new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel() },
			{ new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel() },
			{ new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel() },
			{ new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel() },
			{ new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel() },
			{ new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel() } };
	
	private JButton deleteButton;
	public ConcediuPanel(JButton deleteButton) {
		this.delete_i = -1;
		this.delete_j = -1;
		this.deleteButton = deleteButton;
		this.setBackground(Constants.Colors.frame_color_inspector);
		this.setPreferredSize(new Dimension(700, 550));

		
		matrixPanel = new JPanel();
		matrixPanel.setPreferredSize(new Dimension(600, 450));
		matrixPanel.setBackground(Constants.Colors.back_search);
		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 7; j++) {
				matrixValues[i][j].setBackground(Constants.Colors.back_search);
			}

		titleLabel = new JLabel("Concediu");

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
	
	public void addPanel(String year,String month,String day,int i,int j) {
		
		NodeMatrixConcediu a = new NodeMatrixConcediu(year,month,day,new Color(Math.min(Integer.parseInt(year)%100*20,250),Math.min(Integer.parseInt(month)*20,250),Math.min(Integer.parseInt(day)*10,250)),i,j);
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
	
	public class RemoveListener implements MouseListener {

		private int i;
		private int j;
		
		public RemoveListener(int i,int j) {
			this.i = i;
			this.j = j;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if (((NodeMatrixConcediu)matrixValues[i][j]).getColor() == Constants.Colors.delete_color) {
				{
					((NodeMatrixConcediu)matrixValues[i][j]).setColor(((NodeMatrixConcediu)matrixValues[i][j]).getColorInitial());
					delete_i = -1;
					delete_j = -1;
					deleteButton.setText(" Add ");
				}
			} else {
				if(delete_i!=-1)
				{
					((NodeMatrixConcediu)matrixValues[delete_i][delete_j]).setColor(((NodeMatrixConcediu)matrixValues[delete_i][delete_j]).getColorInitial());
				}
				deleteButton.setText(" Update ");
				deleteButton.setBackground(Constants.Colors.blue_dark);
				delete_i = i;
				delete_j = j;
				
				System.out.println("del este "+delete_i+" "+delete_j);
				((NodeMatrixConcediu)matrixValues[i][j]).setColor(Constants.Colors.delete_color);
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
	
	public Integer getDeleteI() {
		return delete_i;
	}
	
	public Integer getDeleteJ() {
		return delete_j;
	}
}
