package at.toaster.quiz;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

@SuppressWarnings("serial")
public class PlaySound extends File {
	private AudioClip sound;

	public PlaySound(String filename) {

		super("src/main/resources/" + filename);

		try {
			sound = Applet.newAudioClip(this.toURI().toURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void play() {
		sound.play();
	}
}
