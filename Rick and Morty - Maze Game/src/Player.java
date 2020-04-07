import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Clasa Player a aplicatiei Java. Retine pozitia in labirint a player-ului si
 * numarul de castraveti adunati.
 */
public class Player {
	private int tileX;
	private int tileY;
	private int castraveti;
	private Image player;
	private ImageIcon img;

	/**
	 * Creeaza un player care are imaginea img, 0 castraveti adunati si incepe in
	 * labirint de la pozitia (1,1).
	 * 
	 */
	public Player() {
		img = new ImageIcon("rick.jpg");
		player = img.getImage();
		tileX = 1;
		tileY = 1;
		setCastraveti(0);
	}

	/**
	 * Returneaza imaginea player-ului.
	 */
	public Image getPlayer() {
		return player;
	}

	/**
	 * Returneaza pozitia de pe axa Ox a player-ului
	 */
	public int getTileX() {
		return tileX;
	}

	/**
	 * Returneaza pozitia de pe axa Oy a player-ului
	 */
	public int getTileY() {
		return tileY;
	}

	/**
	 * Seteaza pozitia de pe axa Ox a player-ului
	 */
	public void setTileX(int x) {
		tileX = x;
	}

	/**
	 * Seteaza pozitia de pe axa Oy a player-ului
	 */
	public void setTileY(int y) {
		tileY = y;
	}

	/**
	 * Realizeaza mutarea player-ului in functie de parametrii dx si dy.
	 */
	public void move(int dx, int dy) {
		tileX = tileX + dx;
		tileY = tileY + dy;
	}

	/**
	 * Returneaza numarul de castraveti.
	 */
	public int getCastraveti() {
		return castraveti;
	}

	/**
	 * Seteaza numarul de castraveti.
	 */
	public void setCastraveti(int castraveti) {
		this.castraveti = castraveti;
	}
}
