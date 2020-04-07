import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Clasa Maze a aplicatiei Java. Face posibila pornirea jocului.
 *
 */
public class MazeController {
	/**
	 * Creeaza un frame nou, cu titlul "Rick and Morty" si adauga in acest frame un
	 * labirint care are un player si o harta prestabilita.
	 */
	public MazeController() {
		JFrame jf = new JFrame("Rick and Morty");
		Player player = new Player();
		Map map = new Map();
		jf.add(new MazeFrame(player, map));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(new Dimension(1008, 947));
		jf.setVisible(true);
	}
}
