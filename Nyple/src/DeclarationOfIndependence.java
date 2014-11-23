import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class DeclarationOfIndependence extends Sprite {

	public DeclarationOfIndependence(int xPos, int yPos) {
		super(xPos, yPos);
		try {
			this.setImage(ImageIO.read(new File("DeclarationOfIndependence.png")));
		} catch (IOException e) {
			throw new RuntimeException("Error reading Guard image");
		}
	}
	
}
