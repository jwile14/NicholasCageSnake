import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Guard extends Sprite{
	
	private int spawnTimer = 0;
	private int aliveTime = 0;
	private boolean justSpawned = true;
	private int spawnWait = 0;
	private BufferedImage[] images;
	
	public Guard(int xPos, int yPos){	
		super(xPos, yPos);
		
		this.images = new BufferedImage[3];
		
		
		try {
			this.images[0] = ImageIO.read(new File("Guard1.png"));
			this.images[1] = ImageIO.read(new File("Guard2.png"));
			this.images[2] = ImageIO.read(new File("Guard3.png"));
			this.setImage(this.images[(int)(Math.random()*2.99)]);
		} catch (IOException e) {
			throw new RuntimeException("Error reading Guard image");
		}
	}
	
	public int getTimer() {
		return this.spawnTimer;
	}
	
	public int getAliveTime() {
		return this.aliveTime;
	}
	
	public void increment() {
		this.aliveTime++;
	}
	
	public void setAliveTime(int newTime) {
		this.spawnTimer = newTime;
	}
	
	public boolean getSpawnStatus() {
		return this.justSpawned;
	}
	
	public void incrementSpawnWait() {
		spawnWait++;
		if(spawnWait >= 10) {
			this.justSpawned = false;
		}
	}
}
