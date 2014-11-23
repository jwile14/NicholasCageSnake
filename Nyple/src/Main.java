import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

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
		try {
			startMusic();
		} catch (Exception e) {
			throw new RuntimeException("Error starting music");
		}
	}	
	// Starts the music
	private static void startMusic() throws Exception {
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		Clip clip;

		stream = AudioSystem.getAudioInputStream(new File("The_Nic_Cage_Song_Video.wav"));
		format = stream.getFormat();
		info = new DataLine.Info(Clip.class, format);
		clip = (Clip) AudioSystem.getLine(info);
		clip.open(stream);
		FloatControl volumeControl = (FloatControl) clip
				.getControl(FloatControl.Type.MASTER_GAIN);

		volumeControl.setValue(-10.0f); // Reduce volume by 10 decibels.

		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}
}
