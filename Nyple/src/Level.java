import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level {
	final private int CELL_WIDTH = 60;
	private ArrayList<Sprite> sprites;
	
	
	private BufferedImage myPicture;

	public Level(BufferedImage myPicture) {
			this.myPicture = myPicture;
			this.sprites = new ArrayList<Sprite>();
			
			setup();
	}

	public void drawLevel(Graphics2D g2d, LevelComponent levelComponent) {
		for (int a = 0; a < 10; ++a) {
			for (int b = 0; b < 10; ++b) {
				g2d.drawImage(this.myPicture, a * this.CELL_WIDTH, b
						* this.CELL_WIDTH, this.CELL_WIDTH, this.CELL_WIDTH,
						null);
			}
		}
		
		for(Sprite s : this.sprites) {
			System.out.println("SWAG");
			g2d.drawImage(s.getImage(), s.getX() * this.CELL_WIDTH/2, s.getY()
					* this.CELL_WIDTH/2, this.CELL_WIDTH/2, this.CELL_WIDTH/2,
					null);
		}
	}
	
	public ArrayList<Sprite> getSprites() {
		return this.sprites;
	}
	
	private void setup() {
		this.sprites.add(new Cage(5,5));
	}
}
