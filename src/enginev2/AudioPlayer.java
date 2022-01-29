package enginev2;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayer {
	public static void play(Audio a) {
		MediaPlayer p = new MediaPlayer(a.getMedia());
		p.setOnError(() -> System.out.println("Error : " + p.getError().toString()));
		p.setVolume(Data.volume);
		p.play();
	}
}