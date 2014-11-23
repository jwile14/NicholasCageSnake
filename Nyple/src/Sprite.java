import java.awt.image.BufferedImage;

public class Sprite {
	private int xPosition;
	private int yPosition;
	private int direction;
	private BufferedImage img;
	
	private boolean isAlive;
	
	public Sprite(int xPos, int yPos){
		this.xPosition = xPos;
		this.yPosition = yPos;
		//0 degrees equals right
		this.direction = 0;
		this.isAlive = true;
	}
	
	public void move(int x, int y){
		System.out.println(xPosition);
		System.out.println(yPosition);
		this.xPosition = x;
		this.yPosition = y;
		System.out.println("New: " + xPosition);
		System.out.println("New: " + yPosition);
	}
	
	public boolean canMove(){
		//if(this.xPosition )
		return true;
	}
	
	public boolean isAlive() {
		return this.isAlive;
	}
	
	public void setDirection(int d){
		this.direction = d;
	}
	
	public int getDirection(){
		return this.direction;
	}

	/**
	 * Sets the Sprite alive factor
	 *
	 * @param isAlive
	 */
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * Gets the Sprite's x position
	 *
	 * @return x position
	 */
	public int getX() {
		return this.xPosition;
	}

	/**
	 * Sets the Sprite's x position
	 *
	 * @param x
	 */
	public void setX(int x) {
		this.xPosition = x;
	}

	/**
	 * Gets the Sprite's y position
	 *
	 * @return y position
	 */
	public int getY() {
		return this.yPosition;
	}

	/**
	 * Sets the Sprite's y position
	 *
	 * @param y
	 */
	public void setY(int y) {
		this.yPosition = y;
	}
	
	/**
	 * Getter method for the Sprite's image
	 *
	 * @return image file for the sprite
	 */
	public BufferedImage getImage() {
		return this.img;
	}

	/**
	 * Sets the image of the Sprite
	 *
	 * @param img
	 */
	public void setImage(BufferedImage img) {
		this.img = img;
	}
}
