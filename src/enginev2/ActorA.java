package enginev2;

import engine.Actor;
import javafx.scene.image.Image;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ActorA extends Actor {
	Room r;
	public ActorA() {
	}
	public ActorA(String file) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString()));
	}
	public ActorA(String file,double sx,double sy) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString(),sx,sy,false,false));
	}
	void setRoom(Room r) {
		this.r=r;
	}
	public Room getRoom() {
		return r;
	}
	public void imageSet(String file,double sx, double sy) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString(),sx,sy,false,false));
	}
	public void imageSet(String file) {
		setImage(new Image(getClass().getClassLoader().getResource(file).toString()));
	}
	@Override
	public <A extends Actor> A getOneIntersectingObject(Class<A> cls) {
		for (A a : r.getActors(cls)) {
			if (a!=this&&intersects(a.getX(),a.getY(),a.getWidth(),a.getHeight())) {
				return a;
			}
		}
		return null;
	}
	@Override
	public <A extends Actor> List<A> getIntersectingObjects(Class<A> cls) {
		ArrayList<A> hold = new ArrayList<>();
		for (A a : r.getActors(cls)) {
			if (a!=this&&intersects(a.getX(),a.getY(),a.getWidth(),a.getHeight())) {
				hold.add((A)a);
			}
		}
		return hold;
	}
	public void rotate(double a) {
		setRotate(getRotate() +a);
	}
	public double getRotation() {
		return getRotate();
	}
	public void remove() {
		r.removeActor(this);
	}
	//view this as update
	public void act(long now) {
		update((double)now);
	}
	public void update(double dt) {

	}
	public void top() {
		toFront();
	}
}