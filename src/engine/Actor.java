package engine;

import javafx.scene.image.ImageView;
import java.util.List;
import java.util.ArrayList;
import java.lang.Class;
import javafx.scene.image.Image;
import java.io.FileInputStream;

public abstract class Actor extends ImageView {
	public Actor() {
	}
	public Actor(Image i) {
		super(i);
	}
	public abstract void act(long now);
	public double getHeight() {
		return getImage().getHeight();
	}
	public double getWidth() {
		return getImage().getWidth();
	}
	public World getWorld() {
		return (World)getParent();
	}
	public void move(double dx, double dy) {
		setX(getX()+dx);
		setY(getY()+dy);
	}
	public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
		for (A a : getWorld().getObjects(cls)) {
			if (a!=this&&intersects(a.getX(),a.getY(),a.getWidth(),a.getHeight())) {
				return a;
			}
		}
		return null;
	}
	public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls) {
		ArrayList<A> hold = new ArrayList<>();
		for (A a : getWorld().getObjects(cls)) {
			if (a!=this&&intersects(a.getX(),a.getY(),a.getWidth(),a.getHeight())) {
				hold.add((A)a);
			}
		}
		return hold;
	}
}