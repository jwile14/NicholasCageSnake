import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LevelFrame extends JFrame {
	private Level level;

	public LevelFrame() {


		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Nicolas Cage - Snake");

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("TileFloor.jpg"));
		} catch (Exception e) {
			throw new RuntimeException("Error loading image");
		}
		
		level = new Level(myPicture);

		LevelComponent levelComponent = new LevelComponent(this.level);

		this.add(levelComponent);

		this.setResizable(false);
		this.setVisible(true);
	}
}
