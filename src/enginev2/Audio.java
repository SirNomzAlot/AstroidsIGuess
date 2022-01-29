package enginev2;

import javafx.scene.media.Media;
import java.net.URISyntaxException;

public class Audio {
	Media m;
	public Audio(String s) {
		try {
			m = new Media(this.getClass().getClassLoader().getResource(s).toURI().toString());
		} catch(URISyntaxException e) {
			System.out.println("You dungoofed man");
		}
	}
	Media getMedia() {
		return m;
	}
}