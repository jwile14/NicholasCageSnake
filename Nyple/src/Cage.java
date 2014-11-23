import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Cage extends Sprite{

	public Cage(int xPos, int yPos) {
		super(xPos, yPos);
		try {
			this.setImage(ImageIO.read(new File("nic cage close mouth.jpg")));
		} catch (IOException e) {
			throw new RuntimeException("No image file for Nobbin");
		}
	}

}
