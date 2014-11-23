import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Guard extends Sprite{
	
	private int spawnTimer = 100;
	private int aliveTime = 0;
	
	public Guard(int xPos, int yPos){
		super(xPos, yPos);
		try {
			this.setImage(ImageIO.read(new File("niccage1close.png")));
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
		this.aliveTime = newTime;
	}
}
