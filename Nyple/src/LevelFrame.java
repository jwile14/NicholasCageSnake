import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LevelFrame extends JFrame {
	private Level level;
	
	public LevelFrame() {
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Nicolas Cage - Snake");
		
		JPanel mainPanel = new JPanel(new CardLayout());
		
		try {
			BufferedImage myPicture = ImageIO.read(new File("TileFloor.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			//mainPanel.add(picLabel);
		} catch (Exception e) {
			throw new RuntimeException("Error loading image");
		}
		
		LevelComponent levelComponent = new LevelComponent(this.level);
		
		this.add(levelComponent);
		
		this.setResizable(false);
		this.setVisible(true);
	}
}
