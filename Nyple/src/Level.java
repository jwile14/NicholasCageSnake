import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Level {
	final private int CELL_WIDTH = 60;

	private BufferedImage myPicture;

	public Level(BufferedImage myPicture) {
			this.myPicture = myPicture;
	}

	public void drawLevel(Graphics2D g2d, LevelComponent levelComponent) {
		for (int a = 0; a < 10; ++a) {
			for (int b = 0; b < 10; ++b) {
				g2d.drawImage(this.myPicture, a * this.CELL_WIDTH, b
						* this.CELL_WIDTH, this.CELL_WIDTH, this.CELL_WIDTH,
						null);
			}
		}
	}
}
