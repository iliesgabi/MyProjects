import java.awt.Image;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;

/**
 * Clasa Map a plicatiei Java. Ea are rolul de a citi labirintul dintr-un fisier
 * text si de a tine imaginile necesare desenarii labirintului.
 */
public class Map {

	private Scanner scanner;
	private String map[] = new String[22];
	private Image grass;
	private Image finish;
	private Image wall;
	private Image castravete;
	private Image monstru1;
	private Image monstru2;
	private Image monstru3;
	private Image monstru4;
	private Image fire;
	private Image portalDreapta;
	private Image portalStanga;
	private Image gun;
	private Image negru;

	/**
	 * Instantiaza toate imaginile necesare desenarii labirintului si se ocupa cu
	 * deschiderea fisierului din care urmeaza sa se citeasca forma labirintului, cu
	 * citirea propriu zisa a labirintului si stocarea sa intr-un vector de
	 * string-uri si inchiderea fisierului din care s-a citit.
	 */
	public Map() {
		ImageIcon img = new ImageIcon("wall4.jpg");
		negru = img.getImage();
		img = new ImageIcon("wall.jpg");
		grass = img.getImage();
		img = new ImageIcon("wall3x.jpg");
		wall = img.getImage();
		img = new ImageIcon("finish.jpg");
		finish = img.getImage();
		img = new ImageIcon("castravete.jpg");
		castravete = img.getImage();
		img = new ImageIcon("monster1.jpg");
		monstru1 = img.getImage();
		img = new ImageIcon("monster2.jpg");
		monstru2 = img.getImage();
		img = new ImageIcon("monster3.jpg");
		monstru3 = img.getImage();
		img = new ImageIcon("monster4.jpg");
		monstru4 = img.getImage();
		img = new ImageIcon("kill.jpg");
		fire = img.getImage();
		img = new ImageIcon("portald.jpg");
		portalDreapta = img.getImage();
		img = new ImageIcon("portals.jpg");
		portalStanga = img.getImage();
		img = new ImageIcon("gun.jpg");
		gun = img.getImage();

		openFile();
		readFile();
		closeFile();
	}

	/**
	 * Schimba un caracter de la pozitia (x,y) din labirintul map cu caracterul c.
	 */
	public void setMap(char c, int x, int y) {
		char[] chars = map[y].toCharArray();
		chars[x] = c;
		map[y] = String.valueOf(chars);
	}

	/**
	 * Returneaza un String(de lungime 1) care se afla la pozitia (x,y) in labirint.
	 * 
	 */
	public String getMap(int x, int y) {
		String index = map[y].substring(x, x + 1);
		return index;
	}

	/**
	 * Inchide fisierul din care s-a citit labirintul.
	 */
	private void closeFile() {
		scanner.close();
	}

	/**
	 * Citeste labirintul dintr-un fisier text sub forma de mai multe String-uri si
	 * le pune intr-un vector de String-uri.
	 */
	private void readFile() {
		while (scanner.hasNext()) {
			for (int i = 0; i < 20; i++) {
				map[i] = scanner.next();
			}
		}
	}

	/**
	 * Deschide fiserul din care se va citi labirintul.
	 */
	private void openFile() {
		try {
			scanner = new Scanner(new File("map.txt"));
		} catch (Exception e) {
			System.out.println("error loading map");
		}
	}

	/**
	 * Returneaza imaginea corespunzatoare zonei prin care player-ul poate umbla
	 * prin labirint.
	 */
	public Image getGrass() {
		return grass;
	}

	/**
	 * Returneaza imaginea corespunzatoare castravetilor pe care player-ul ii poate
	 * strange din labirint.
	 */
	public Image getCastravete() {
		return castravete;
	}

	/**
	 * Returneaza imaginea corespunzatoare zonei prin care player-ul nu poate umbla
	 * prin labirint.
	 */
	public Image getWall() {
		return wall;
	}

	/**
	 * Returneaza imaginea corespunzatoare locului de terminare a jocului.
	 */
	public Image getFinish() {
		return finish;
	}

	/**
	 * Returneaza imaginea corespunzatoare unui monstru care omoara player-ul.
	 */
	public Image getMonstru1() {
		return monstru1;
	}

	/**
	 * Returneaza imaginea corespunzatoare unui monstru care omoara player-ul.
	 */
	public Image getMonstru2() {
		return monstru2;
	}

	/**
	 * Returneaza imaginea corespunzatoare unui monstru care omoara player-ul.
	 */
	public Image getMonstru3() {
		return monstru3;
	}

	/**
	 * Returneaza imaginea corespunzatoare unui monstru care omoara player-ul.
	 */
	public Image getMonstru4() {
		return monstru4;
	}

	/**
	 * Returneaza imaginea corespunzatoare unui "foc" care omoara player-ul.
	 */
	public Image getFire() {
		return fire;
	}

	/**
	 * Returneaza imaginea corespunzatoare unui portal orientat spre partea dreapta
	 * prin care player-ul poate trece.
	 */
	public Image getPortalDreapta() {
		return portalDreapta;
	}

	/**
	 * Returneaza imaginea corespunzatoare unui portal orientat spre partea stanga
	 * prin care player-ul poate trece.
	 */
	public Image getPortalStanga() {
		return portalStanga;
	}

	/**
	 * Returneaza imaginea corespunzatoare armei care ajuta player-ul sa omoare un
	 * monstru si astfel sa termine jocul.
	 */
	public Image getGun() {
		return gun;
	}

	/**
	 * Returneaza imaginea corespunzatoare portiunii din labirint pe care jucatorul
	 * nu o poate vedea la un moment dat.
	 */
	public Image getNegru() {
		return negru;
	}

}
