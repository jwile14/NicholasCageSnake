import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameKeyListener implements KeyListener{

	private Cage nick;
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_UP){
			nick.move(this.nick.getX(), this.nick.getY()-1);
		}else if (arg0.getKeyCode() == KeyEvent.VK_DOWN){
			nick.move(this.nick.getX(), this.nick.getY()+1);
		}else if (arg0.getKeyCode() == KeyEvent.VK_LEFT){
			nick.move(this.nick.getX()-1, this.nick.getY());
		}else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			nick.move(this.nick.getX()+1, this.nick.getY()-1);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
