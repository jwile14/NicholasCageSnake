import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Level {
	final private int CELL_WIDTH = 60;

	private Cage nick;
	private ArrayList<Sprite> sprites;

	private BufferedImage myPicture;

	public Level(BufferedImage myPicture) {
		this.myPicture = myPicture;
		this.sprites = new ArrayList<Sprite>();

		setup();
	}

	public void endLevel(Graphics2D g2d) {
		BufferedImage lostScreen = null;
		try {
			lostScreen = ImageIO.read(new File("sadnic.png"));
		} catch (Exception e) {
			throw new RuntimeException("Error reading in lost screen");
		}

		g2d.drawImage(lostScreen, 0, 0, 600, 600, null);
	}

	public void drawLevel(Graphics2D g2d) {
		for (int a = 0; a < 10; ++a) {
			for (int b = 0; b < 10; ++b) {
				g2d.drawImage(this.myPicture, a * this.CELL_WIDTH, b
						* this.CELL_WIDTH, this.CELL_WIDTH, this.CELL_WIDTH,
						null);
			}
		}

		for (Sprite s : this.sprites) {
			if (s.isAlive()) {
				if (s.getClass().toString().equals("class Guard")
						&& ((Guard) s).getSpawnStatus()) {
					((Guard) s).incrementSpawnWait();
				} else if (s.getClass().toString()
						.equals("class DeclarationOfIndependence")) {
					if (((DeclarationOfIndependence) s).getFlipper())
						g2d.drawImage(s.getImage(), s.getX(), s.getY(),
								this.CELL_WIDTH, this.CELL_WIDTH, null);
					else
						g2d.drawImage(s.getImage(), s.getX() + this.CELL_WIDTH,
								s.getY(), -this.CELL_WIDTH, this.CELL_WIDTH,
								null);

				} else {
					g2d.drawImage(s.getImage(), s.getX(), s.getY(),
							this.CELL_WIDTH, this.CELL_WIDTH, null);
				}
			}
		}
	}

	public ArrayList<Sprite> getSprites() {
		return this.sprites;
	}

	private void setup() {
		this.nick = new Cage(5, 5);
		this.sprites.add(nick);
	}

	public Cage getCage() {
		return this.nick;
	}
}
