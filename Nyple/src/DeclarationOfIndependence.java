import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DeclarationOfIndependence extends Sprite {

	private boolean flipper = true;
	private int counter = 0;

	public DeclarationOfIndependence(int xPos, int yPos) {
		super(xPos, yPos);
		try {
			this.setImage(ImageIO
					.read(new File("DeclarationOfIndependence.png")));
		} catch (IOException e) {
			throw new RuntimeException("Error reading Guard image");
		}
	}

	public boolean getFlipper() {
		counter++;
		if (this.counter >= 20) {
			this.flipper = !this.flipper;
			counter = 0;
		}
		return this.flipper;
	}

}
