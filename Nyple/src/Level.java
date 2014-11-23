import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Level {
	final private int CELL_WIDTH = 60;
	
	private BufferedImage myPicture;
	
	public Level() {
		try {
			this.myPicture = ImageIO.read(new File("TileFloor.jpg"));
		} catch (IOException e) {
			throw new RuntimeException("Error reading in picture");
		}
	}
	
	public void drawLevel(Graphics2D g2d, LevelComponent levelComponent) {
		for(int a = 0; a < 10; ++a) {
			for(int b = 0; b < 10; ++b) {
				System.out.println("PRINTING");
				g2d.drawImage(this.myPicture, a * this.CELL_WIDTH,
						(b * this.CELL_WIDTH) + this.CELL_WIDTH,
						this.CELL_WIDTH, this.CELL_WIDTH, null);
			}
		}
	}
}
