
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Clasa MazeFrame a aplicatiei Java. In aceasta clasa se deseneaza efectiv
 * labirintul si se implementeaza metodele necesare miscarii player-ului.
 *
 */
public class MazeFrame extends JPanel implements ActionListener {

	private Timer timer;
	private Map map;
	private Player player;
	private boolean win = false;
	private boolean lose = false;
	private boolean gun = false;

	/**
	 * Instantiaza labirintul, player-ul, clasa KeyController (care se ocupa de tastele apasate
	 * la tastatura) si porneste un timer care are rolul de a rula actionPerformed.
	 */
	public MazeFrame(Player player, Map map) {
		this.map = map;
		this.player=player; 
		addKeyListener(new KeyController());
		setFocusable(true);

		timer = new Timer(25, this);
		timer.start();
	}

	/**
	 * Verifica daca player-ul a ajuns la finish, daca a dat de un monstru sau de
	 * capcane, daca a ajuns la un portal care il duce undeva, daca exista castraveti la
	 * pozitia in care e, si daca exista ii strange sau daca a ajuns la arma, caz in
	 * care o si ia. Dupa toate aceste verificari, se redeseneaza labirintul cu
	 * modificarile necesare, daca acestea exista.
	 */
	public void actionPerformed(ActionEvent e) {
		if (map.getMap(player.getTileX(), player.getTileY()).equals("f") && win == false) {
			win = true;
			new WinnerFrame(player);
		}

		if (this.gun == true) {
			if (map.getMap(player.getTileX(), player.getTileY()).equals("1")
					|| map.getMap(player.getTileX(), player.getTileY()).equals("2")
					|| map.getMap(player.getTileX(), player.getTileY()).equals("3")
					|| map.getMap(player.getTileX(), player.getTileY()).equals("4")) {
				map.setMap('g', player.getTileX(), player.getTileY());
			}
		}

		if (lose == false && this.gun == false)
			if (map.getMap(player.getTileX(), player.getTileY()).equals("1")
					|| map.getMap(player.getTileX(), player.getTileY()).equals("2")
					|| map.getMap(player.getTileX(), player.getTileY()).equals("3")
					|| map.getMap(player.getTileX(), player.getTileY()).equals("4")) {
				lose = true;
				new LoserFrame();
			}

		if (lose == false)
			if (map.getMap(player.getTileX(), player.getTileY()).equals("k")) {
				lose = true;
				new LoserFrame();
			}

		if (map.getMap(player.getTileX(), player.getTileY()).equals("c")) {
			player.setCastraveti(player.getCastraveti() + 1);
			map.setMap('g', player.getTileX(), player.getTileY());
		}

		if (player.getTileX() == 5 && player.getTileY() == 18) {
			player.setTileX(20);
			player.setTileY(16);
		}

		if (player.getTileX() == 3 && player.getTileY() == 7) {
			player.setTileX(11);
			player.setTileY(5);
		}

		if (player.getTileX() == 13 && player.getTileY() == 3) {
			player.setTileX(7);
			player.setTileY(17);
		}

		if (player.getTileX() == 1 && player.getTileY() == 17 && gun == false
				&& map.getMap(player.getTileX(), player.getTileY()).equals("p")) {
			gun = true;
			map.setMap('g', 1, 17);
		}

		repaint();
	}

	/**
	 * Se verifica fiecare caracter din labirint si se deseneaza ca atare. Legenda:
	 * 'f'-finish, 'g'-loc prin care player-ul poate umbla, 'w'- loc prin care
	 * player-ul nu poate umbla, 'c'-castravete, '1'-primul model de monstru, '2'-al
	 * doilea model de monstru, '3'-al treilea model de monstru, '4'-al patrulea
	 * model de monstru, 'k'-capcana, 'd'-portal orientat catre dreapta, 's'-portal
	 * orientat spre stanga, 'p'-arma. Daca ceea ce trebuie desenat nu se afla in
	 * jurul player-ului(2 pozitii stanga,dreapta,sus,jos), nu se tine cont de ceea
	 * ce se afla in labirint si se va desena altceva, care e menit sa nu lase
	 * jucatorul sa vada tot labirintul odata, ci sa vada doar o mica bucata din ce
	 * inconjoara player-ul.
	 */
	public void paint(Graphics g) {
		super.paint(g);
		for (int y = 0; y < 20; y++) {
			for (int x = 0; x < 22; x++) {
				/*if ((player.getTileX() == x + 1 || player.getTileX() == x - 1 || player.getTileX() == x
						|| player.getTileX() == x + 2 || player.getTileX() == x - 2)
						&& (player.getTileY() == y + 1 || player.getTileY() == y - 1 || player.getTileY() == y
								|| player.getTileY() == y - 2 || player.getTileY() == y + 2)) {*/

					if (map.getMap(x, y).equals("f")) {
						g.drawImage(map.getFinish(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("g")) {
						g.drawImage(map.getGrass(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("w")) {
						g.drawImage(map.getWall(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("c")) {
						g.drawImage(map.getCastravete(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("1")) {
						g.drawImage(map.getMonstru1(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("2")) {
						g.drawImage(map.getMonstru2(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("3")) {
						g.drawImage(map.getMonstru3(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("4")) {
						g.drawImage(map.getMonstru4(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("k")) {
						g.drawImage(map.getFire(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("d")) {
						g.drawImage(map.getPortalDreapta(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("s")) {
						g.drawImage(map.getPortalStanga(), x * 45, y * 45, null);
					}
					if (map.getMap(x, y).equals("p")) {
						g.drawImage(map.getGun(), x * 45, y * 45, null);
					}
				/*} /*else
					g.drawImage(map.getNegru(), x * 45, y * 45, null);*/
			}
		}
		g.drawImage(player.getPlayer(), player.getTileX() * 45, player.getTileY() * 45, null);
	}

	/**
	 * Decide daca s-a apasat vreo tasta de la tastatura si ce tasta.
	 */
	private class KeyController extends KeyAdapter {
		/**
		 * Decide ce tasta s-a apasat si muta player-ul conform tastei apasate. (W-sus,
		 * S-jos, A-stanga, D-dreapta).
		 */
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_W) {
				if (map.getMap(player.getTileX(), player.getTileY() - 1).equals("w") == false) {
					player.move(0, -1);
				}

			}
			if (keyCode == KeyEvent.VK_S) {
				if (map.getMap(player.getTileX(), player.getTileY() + 1).equals("w") == false) {
					player.move(0, 1);
				}
			}
			if (keyCode == KeyEvent.VK_A) {
				if (map.getMap(player.getTileX() - 1, player.getTileY()).equals("w") == false) {
					player.move(-1, 0);
				}
			}
			if (keyCode == KeyEvent.VK_D) {
				if (map.getMap(player.getTileX() + 1, player.getTileY()).equals("w") == false) {
					player.move(1, 0);
				}
			}

		}

		public void keyRelased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {

		}
	}

}
