package enginev2;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ActorB {
	ArrayList<Shape> parts = new ArrayList<>();
	double xT;
	double yT;
	public ActorB() {
	}
	public ArrayList<Shape> getParts() {
		return parts;
	}
	public void addRect(double sx, double sy, double x, double y, ColorRGB fill) {
		Rectangle rec = new Rectangle(x,y,sx,sy);
		rec.setFill(fill.getColor());
		updateCords(x,y);
		parts.add(rec);
	}
	public void addCric(double r, double x, double y, ColorRGB fill) {
		Circle cic = new Circle(r,x,y,fill.getColor());
		updateCords(x-r,y-r);
		parts.add(cic);
	}
	private void updateCords(double xin, double yin) {
		if (xin<xT) {
			xT=xin;
		}
		if (yin<yT) {
			yT=yin;
		}
	}
	public void move(double mx, double my) {
		for (Shape s : parts) {
			if (s instanceof Rectangle) {
				((Rectangle)s).setX(((Rectangle)s).getX()+mx);
				((Rectangle)s).setY(((Rectangle)s).getY()+my);
			} else if (s instanceof Circle) {
				((Circle)s).setCenterX(((Circle)s).getCenterX()+mx);
				((Circle)s).setCenterY(((Circle)s).getCenterY()+my);
			}
		}
	}
	public void update(double dt) {

	}

}