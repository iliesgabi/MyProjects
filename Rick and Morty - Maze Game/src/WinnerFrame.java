import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Aceasta este clasa WinnerFrame a aplicatitei Java. Aceasta clasa are rolul
 * de a anunta jucatorul ca a ajuns la Morty, si deci, a castigat.
 */
public class WinnerFrame extends JPanel {
	/**
	 * Creeaza un nou frame care are scopul de a opri jocul deoarece jucatorul a
	 * ajuns la final.
	 * 
	 * @param player-jucatorul in sine care a castigat, pentru a se putea afisa
	 *                         numarul de castraveti adunati.
	 */
	public WinnerFrame(Player player) {

		JFrame jf = new JFrame("WINNER");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(new Dimension(500, 600));
		jf.setLocation(300, 300);

		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(new JLabel(" AI CASTIGAT! RICK L-A GASIT PE MORTY"));
		content.add(Box.createRigidArea(new Dimension(1000, 5)));
		content.add(new JLabel("ai adunat " + player.getCastraveti() + "/30 castraveti"));
		content.add(new JLabel(new ImageIcon("win.png")));
		content.setBackground(Color.white);
		jf.add(content);
		jf.setVisible(true);
	}

}
