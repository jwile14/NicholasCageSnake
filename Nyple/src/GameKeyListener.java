import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameKeyListener implements KeyListener{

	private Cage nick;
	private LevelComponent lc;
	
	public GameKeyListener(Cage n, LevelComponent lc){
		this.nick = n;
		this.lc = lc;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == KeyEvent.VK_UP){
			nick.setDirection(90);
			
			lc.repaint();
		}else if (arg0.getKeyCode() == KeyEvent.VK_DOWN){
			nick.setDirection(270);
			lc.repaint();
		}else if (arg0.getKeyCode() == KeyEvent.VK_LEFT){
			nick.setDirection(180);
			lc.repaint();
		}else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT){
			nick.setDirection(0);
			lc.repaint();
		}
		System.out.println("Direction: "+this.nick.getDirection());
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
