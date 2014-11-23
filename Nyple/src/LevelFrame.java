
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LevelFrame extends JFrame {
	private Level level;
	private JPanel titleScreen;
	private JButton startButton;
	private JPanel mainPanel;
	private JPanel titlePanel;
	private CardLayout cl;
	private LevelComponent lc;
	
	public LevelFrame() {
		this.titleScreen = new JPanel();
		this.startButton = new JButton("Start Game");
		this.mainPanel = new JPanel(new CardLayout());
		this.cl = (CardLayout) this.mainPanel.getLayout();
		this.titlePanel = new JPanel();
		
		this.titlePanel.add(titleScreen, BorderLayout.CENTER);
		this.titlePanel.add(startButton, BorderLayout.SOUTH);
		
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
		
		this.lc = new LevelComponent(this.level);
		
		this.mainPanel.add(lc, "levelComponent");
		this.mainPanel.add(this.titlePanel, "titlePanel");
		this.cl.show(this.mainPanel, "titlePanel");
		
		this.add(this.mainPanel, BorderLayout.CENTER);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				startGame();
			}
		});

		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void startGame(){
		this.lc.startComponent();
		this.cl.show(this.mainPanel, "levelComponent");
	}
}
