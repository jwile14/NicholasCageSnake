import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class LevelComponent extends JComponent {
	private GameKeyListener gkl;
	private Cage nick;
	private Level curLevel;

	public LevelComponent(Level curLevel) {
		this.curLevel = curLevel;
		this.setFocusable(true);
		this.nick = this.curLevel.getCage();
		this.gkl = new GameKeyListener(this.nick, this);
		this.addKeyListener(gkl);
		this.setFocusable(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		this.curLevel.drawLevel(g2d);
	}

	public void setLevel(Level level) {
		this.curLevel = level;
	}

	public Level getLevel() {
		return this.curLevel;
	}

	public void startComponent() {

		Runnable animatorRunnable = new Runnable() {

			@Override
			public void run() {

				int timer = 0;

				while (true) {
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						throw new RuntimeException("Error sleeping");
					}

					ArrayList<Sprite> curSprites = LevelComponent.this.curLevel
							.getSprites();

					for (Sprite s : curSprites) {
						if (s.getClass().toString().equals("class Cage")) {
							if (s.getX() < 535 && s.getX() > 0
									&& s.getY() < 515 && s.getY() > 0) {
								if (s.getDirection() == 0) {
									s.setX(s.getX() + 3);
								} else if (s.getDirection() == 90) {
									s.setY(s.getY() - 3);
								} else if (s.getDirection() == 180) {
									s.setX(s.getX() - 3);
								} else if (s.getDirection() == 270) {
									s.setY(s.getY() + 3);
								}
								timer++;
								if (timer == 5) {
									timer = 0;
									((Cage) s).animate();
								}
							}
							else {
								System.out.println("YOU LOSE!");
							}
						}
					}

					repaint();
				}
			}

		};

		Thread thread = new Thread(animatorRunnable);
		thread.start();
	}
}
