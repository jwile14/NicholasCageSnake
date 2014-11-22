import java.awt.Dimension;

import javax.swing.JFrame;


/**
 * Main class
 *
 * @author wilejd.
 *         Created Nov 22, 2014.
 */
public class Main {
	/**
	 * Main method.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		LevelFrame frame = new LevelFrame();
		
		frame.setTitle("Nyple - 2.0");	
		frame.setSize(new Dimension(600,600));
		

		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}
