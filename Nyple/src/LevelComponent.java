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
				int spawnTimer = 0;
				boolean spawnFlag = false;
				int spawnX = 0, spawnY = 0;

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
									spawnTimer++;
									((Cage) s).animate();
								}
								if (spawnTimer == 5) {
									spawnFlag = true;
									if (s.getDirection() == 0) {
										spawnX = s.getX()-50;
										spawnY = s.getY();
									} else if (s.getDirection() == 90) {
										spawnX = s.getX();
										spawnY = s.getY()+50;
									} else if (s.getDirection() == 180) {
										spawnX = s.getX()+50;
										spawnY = s.getY();
									} else if (s.getDirection() == 270) {
										spawnX = s.getX();
										spawnY = s.getY()-50;
									}
									spawnTimer = 0;
								}
							} else {
								System.out.println("YOU LOSE!");
							}
						} else if (s.getClass().toString()
								.equals("class Guard")) {


							((Guard) s).increment();
							if (((Guard) s).getAliveTime() == ((Guard) s)
									.getTimer()) {
								s.setIsAlive(false);
							}
						}
					}

					if (spawnFlag) {
						curSprites.add(new Guard(spawnX, spawnY));
						curSprites.get(curSprites.size() - 1).setDirection(
								curSprites.get(0).getDirection());
						spawnFlag = false;
					}

					for (int j = 0; j < curSprites.size(); ++j) {
						if (!curSprites.get(j).isAlive()) {
							curSprites.remove(j);
							j -= 1;
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
