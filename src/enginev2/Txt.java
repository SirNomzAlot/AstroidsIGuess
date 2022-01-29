package enginev2;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class Txt {
	private Text t;
	public Txt() {
		t = new Text();
	}
	public Txt(String txt) {
		t = new Text(txt);
	}
	public Txt(String txt, double x, double y) {
		t = new Text(x,y,txt);
		t.setFont(new Font(Data.font));
	}
	public Txt(String txt, double x, double y, double font) {
		t = new Text(x,y,txt);
		t.setFont(new Font(font));
	}
	public Txt(String txt, double x, double y, ColorRGB c) {
		this(txt,x,y);
		setColor(c);
	}
	public void setSize(double f) {
		t.setFont(new Font(f));
	}
	public void setLineSpacing(double space) {
		t.setLineSpacing(space);
	}
	public void setStrikethrough(boolean on) {
		t.setStrikethrough(on);
	}
	public void setText(String txt) {
		t.setText(txt);
	}
	public void setUnderline(boolean on) {
		t.setUnderline(on);
	}
	public void setX(double x) {
		t.setX(x);
	}
	public void setY(double y) {
		t.setY(y);
	}
	public Text gett() {
		return t;
	}
	public double getWidth() {
		return t.getBoundsInLocal().getWidth();
	}
	public double getHeight() {
		return t.getBoundsInLocal().getHeight();
	}
	public void setColor(ColorRGB c) {
		t.setFill(c.getColor());
	} 
}