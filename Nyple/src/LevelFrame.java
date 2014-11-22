import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LevelFrame extends JFrame {
	public LevelFrame() {
		this.setSize(1000,1000);
		JPanel mainPanel = new JPanel(new CardLayout());
		
		try {
			BufferedImage myPicture = ImageIO.read(new File("NationalTreasure.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			mainPanel.add(picLabel);
		} catch (Exception e) {
			throw new RuntimeException("Error loading image");
		}
		
		this.add(mainPanel);
		
		this.setResizable(false);
		this.setVisible(true);
	}
}
