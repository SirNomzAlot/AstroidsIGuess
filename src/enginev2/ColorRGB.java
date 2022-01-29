package enginev2;

import javafx.scene.paint.Color;

public class ColorRGB {
	Color c;
	public ColorRGB(double r, double g, double b, double o) {
		c = new Color(r/255,g/255,b/255,o/255);
	}
	public ColorRGB(double r, double g, double b) {
		this(r,g,b,255);
	}
	public Color getColor() {
		return c;
	}
}