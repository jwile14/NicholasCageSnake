import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		JFrame frame = new JFrame();
		
		frame.setTitle("Nyple - 2.0");	
		frame.setSize(new Dimension(600,600));
		
		//Comment hi and bye
		System.out.println("Justin".length());
		int a = 0;
		char character = 54;
		String j = "Blah";
		String q = "Whoo";
		
		if(j.charAt(0) == q.charAt(0));
		
		if(j.substring(0,1).equals(q.substring(0,1)));
		
		//JPanel panel = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public static int compute(String stg) {
		return stg.length();
	}
}
