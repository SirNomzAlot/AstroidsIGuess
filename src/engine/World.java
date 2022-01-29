package engine;

import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import java.util.ArrayList;
import javafx.scene.Node;

public abstract class World extends Pane {
	private AnimationTimer animator = new AnimationTimer() {
		@Override
		public void handle(long now) {
			act(now);
			for (Node a : getChildren()) {
				Actor hold = (Actor)a;
				hold.act(now);
			}
		}
	};
	public abstract void act(long now);
	public void add(Actor a) {
		getChildren().add(a);
	}
	public void remove(Actor a) {
		getChildren().remove(a);
	}
	public void start() {
		animator.start();
	}
	public void stop() {
		animator.stop();
	}
	public <A extends Actor> java.util.List<A> getObjects(java.lang.Class<A> cls) {
		ArrayList<A> hold = new ArrayList<>();
		for (Node a : getChildren()) {
			if (cls.isInstance(a)) {
				hold.add((A)a);
			}
		}
		return hold;
	}
}