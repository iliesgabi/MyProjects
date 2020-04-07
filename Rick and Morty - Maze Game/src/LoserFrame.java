import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Aceasta este clasa LoserFrame a aplicatiei Java.Prin intermediul acestei
 * clase se aduce la cunostiinta jucatorului ca a facut o greseala in joc care
 * l-a facut sa piarda.
 */
public class LoserFrame {
	/**
	 * Creaaza un nou frame care are scopul de a anunta jucatorul ca a pierdut.
	 */
	public LoserFrame() {
		JFrame jf = new JFrame("YOU LOST");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(new Dimension(500, 600));
		jf.setLocation(300, 300);

		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(new JLabel("AI PIERDUT! MORTY VA RAMANE SINGUR"));
		content.add(Box.createRigidArea(new Dimension(1000, 5)));
		content.add(new JLabel(new ImageIcon("morty.jpg")));
		content.setBackground(Color.white);

		jf.add(content);
		jf.setVisible(true);
	}
}
