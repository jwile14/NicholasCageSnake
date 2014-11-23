import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class LevelComponent extends JComponent {
	private Cage nick;
	private int points = 0;
	private boolean gameState = true;
	private Level curLevel;

	public LevelComponent(Level curLevel) {
		this.curLevel = curLevel;
		this.nick = this.curLevel.getCage();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		if (this.gameState) {
			this.curLevel.drawLevel(g2d);
		} else {
			this.curLevel.endLevel(g2d);

		}
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
				int spawnTimer = 0;
				boolean spawnFlag = false;
				int spawnX = 0, spawnY = 0;
				int lifeLength = 0;

				ArrayList<Sprite> curSprites = LevelComponent.this.curLevel
						.getSprites();

				curSprites.add(new DeclarationOfIndependence((int) (Math
						.random() * 540.0), (int) (Math.random() * 540.0)));
				System.out.println(curSprites.get(1).getX() + " "
						+ curSprites.get(1).getY());

				while (true) {
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						throw new RuntimeException("Error sleeping");
					}

					for (Sprite s : curSprites) {
						if (s.getClass().toString().equals("class Guard")) {
							// Guard logic
							((Guard) s).increment();
							if (((Guard) s).getAliveTime() >= ((Guard) s)
									.getTimer()) {
								s.setIsAlive(false);
							}
						} else if (s.getClass().toString().equals("class Cage")) {
							// Nic Cage logic
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
									spawnTimer++;
									((Cage) s).animate();
								}
								if (spawnTimer == 5) {
									spawnFlag = true;
									if (s.getDirection() == 0) {
										spawnX = s.getX();
										spawnY = s.getY();
									} else if (s.getDirection() == 90) {
										spawnX = s.getX();
										spawnY = s.getY();
									} else if (s.getDirection() == 180) {
										spawnX = s.getX();
										spawnY = s.getY();
									} else if (s.getDirection() == 270) {
										spawnX = s.getX();
										spawnY = s.getY();
									}
									spawnTimer = 0;
								}
							} else {
								gameState = false;
							}
						} else if (s.getClass().toString()
								.equals("class DeclarationOfIndependence")) {
							// Declaration of Independence Spawning
							if (Math.abs(curSprites.get(0).getX() - s.getX()) < 60
									&& Math.abs(curSprites.get(0).getY()
											- s.getY()) < 60) {
								s.setX((int) (Math.random() * 540.0));
								s.setY((int) (Math.random() * 540.0));

								LevelComponent.this.incrementPoints();
								lifeLength += 25;
							}
						}
					}

					// Spawns Guards
					if (spawnFlag) {
						if (lifeLength > 0) {
							curSprites.add(new Guard(spawnX, spawnY));
							curSprites.get(curSprites.size() - 1).setDirection(
									curSprites.get(0).getDirection());
							((Guard) curSprites.get(curSprites.size() - 1))
									.setAliveTime(lifeLength);
							spawnFlag = false;
						}
					}

					// Removes dead sprites
					for (int j = 0; j < curSprites.size(); ++j) {
						if (!curSprites.get(j).isAlive()) {
							curSprites.remove(j);
							j -= 1;
						}
					}

					// Cage collision with Guards logic
					for (int a = 3; a < curSprites.size() - 2; ++a) {
						if (Math.abs(curSprites.get(a).getX()
								- curSprites.get(0).getX()) < 40
								&& Math.abs(curSprites.get(a).getY()
										- curSprites.get(0).getY()) < 45)
							LevelComponent.this.gameState = false;
					}

					repaint();
				}

			}
		};

		Thread thread = new Thread(animatorRunnable);
		thread.start();
	}

	public int getPoints() {
		return this.points;
	}

	public void incrementPoints() {
		this.points += 100;
	}

	public boolean getGameState() {
		return this.gameState;
	}
}
