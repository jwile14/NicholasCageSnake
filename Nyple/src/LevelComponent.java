import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;


@SuppressWarnings("serial")
public class LevelComponent extends JComponent{
	
	private Level curLevel;
	
	public LevelComponent(Level curLevel) {
		this.curLevel = curLevel;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		this.curLevel.drawLevel(g2d, this);
	}
	
	public void setLevel(Level level) {
		this.curLevel = level;
	}
	
	public Level getLevel() {
		return this.curLevel;
	}
	
	/*public void startComponent() {
		Runnable animatorRunnable = new Runnable() {

			@Override
			public void run() {

				while (true) {
					try {
						Thread.sleep(450);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (!isPaused) {
						ArrayList<Sprite> curSprites = LevelComponent.this.curLevel.getSprites();
						
						

						}
						repaint();
					}
				}
			}
		};*/

}
