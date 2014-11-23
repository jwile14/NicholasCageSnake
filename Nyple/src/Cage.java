import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Cage extends Sprite {
	private BufferedImage img1, img2;

	public Cage(int xPos, int yPos) {
		super(xPos, yPos);
		try {
			this.setImage(ImageIO.read(new File("nic cage close mouth.png")));
			this.img1 = this.getImage();
			this.img2 = ImageIO.read(new File("nic cage open mouth.png"));
		} catch (IOException e) {
			throw new RuntimeException("No image file for Nobbin");
		}
	}

	public void animate() {
		if (this.getImage().equals(img2))
			this.setImage(img1);
		else
			this.setImage(img2);
	}

}
