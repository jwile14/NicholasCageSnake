import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class LevelFrame extends JFrame {
	private Level level;
	private JPanel titleScreen;
	private JButton startButton;
	private JPanel mainPanel;
	private JPanel titlePanel;
	private CardLayout cl;
	private LevelComponent lc;
	private BufferedImage myPicture;
	private Cage nick;

	public LevelFrame() {
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Nicolas Cage - Snake");
		this.mainPanel = new JPanel(new CardLayout());

		myPicture = null;

		try {
			this.myPicture = ImageIO.read(new File("TileFloor.jpg"));
			
		} catch (Exception e) {
			throw new RuntimeException("Error loading title screen");
		}

		this.level = new Level(this.myPicture);
		this.nick = this.level.getCage();

		mainPanel.getInputMap().put(
				KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");
		Action right = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("right");
				if(!(nick.getDirection() == 180)){
					nick.setDirection(0);
				}
			}

		};
		mainPanel.getActionMap().put("right", right);

		mainPanel.getInputMap().put(
				KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
		Action left = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("left");
				if (!(nick.getDirection() == 0)) {
					nick.setDirection(180);
				}
			}

		};
		mainPanel.getActionMap().put("left", left);

		mainPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
				"up");
		Action up = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("up");
				if (!(nick.getDirection() == 270)) {
					nick.setDirection(90);
				}
			}

		};
		mainPanel.getActionMap().put("up", up);

		mainPanel.getInputMap().put(
				KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
		Action down = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("down");
				if (!(nick.getDirection() == 90)) {
					nick.setDirection(270);
				}
			}

		};
		mainPanel.getActionMap().put("down", down);

		this.startButton = new JButton("Start Game");

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		// **************************************************************************************************

		this.titlePanel = new JPanel();
		this.titleScreen = new JPanel();

		this.titlePanel.add(this.startButton, BorderLayout.SOUTH);
		this.titlePanel.add(this.titleScreen, BorderLayout.CENTER);

		this.cl = (CardLayout) this.mainPanel.getLayout();

		this.lc = new LevelComponent(this.level);

		this.mainPanel.add(this.lc, "levelComponent");
		this.mainPanel.add(this.titlePanel, "titlePanel");
		this.cl.show(this.mainPanel, "titlePanel");

		this.add(mainPanel);

		this.setResizable(false);
		this.setVisible(true);
	}

	public void startGame() {
		this.cl.show(this.mainPanel, "levelComponent");
		this.lc.startComponent();
	}
}
