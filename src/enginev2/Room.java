package enginev2;

import engine.Actor;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.KeyCode;
import java.util.Collection;

public class Room {
	Pane pane = new Pane();
	Scene scene = new Scene(pane,Data.tabSX,Data.tabSY);
	public Room() {
		pane.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Data.mouseMoved=true;
				Data.mouseX=event.getX();
				Data.mouseY=event.getY();
			}
		});
		pane.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Data.mousePressed=true;
				Data.mouseX=event.getX();
				Data.mouseY=event.getY();
				if (event.getButton()==MouseButton.PRIMARY) {
					Data.mouseButton=Data.PRIMARYMB;
				} else if (event.getButton()==MouseButton.SECONDARY) {
					Data.mouseButton=Data.SECONDARYMB;
				} else {
					Data.mouseButton=Data.MIDDLEMB;
				}
			}
		});
		pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				Data.keyPressed = event.getText();
				Data.keyPressedSmooth.put(event.getText(),true);
				KeyCode f = event.getCode();
				if (f==KeyCode.ENTER) {
					Data.keyPressed="\n";
				} else if (f==KeyCode.BACK_SPACE) {
					Data.keyPressed="\b";
				} else if (f==KeyCode.LEFT) {
					Data.leftArrow=true;
				} else if (f==KeyCode.RIGHT) {
					Data.rightArrow=true;
				} else if (f==KeyCode.UP) {
					Data.upArrow=true;
				} else if (f==KeyCode.DOWN) {
					Data.downArrow=true;
				}
			}
		});
		pane.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				KeyCode f = event.getCode();
				if (f==KeyCode.LEFT) {
					Data.leftArrow=false;
				} else if (f==KeyCode.RIGHT) {
					Data.rightArrow=false;
				} else if (f==KeyCode.UP) {
					Data.upArrow=false;
				} else if (f==KeyCode.DOWN) {
					Data.downArrow=false;
				} else {
					Data.keyPressedSmooth.put(event.getText(),null);
				}
			}
		});
	}
	public void addActor(Actor a) {
		pane.getChildren().add(a);
		if (a instanceof ActorA) {
			((ActorA)a).setRoom(this);
		}
	}
	public void addActorB(ActorB b) {
		for (Shape s : b.getParts()) {
			pane.getChildren().add(s);
		}
	}
	public void removeActor(Actor a) {
		pane.getChildren().remove(a);
	}
	public void removeActorB(ActorB b) {
		for (Shape s : b.getParts()) {
			pane.getChildren().remove(s);
		}

	}
	public void addText(Txt t) {
		pane.getChildren().add(t.gett());
	}
	public void setCurRoom() {
		Data.window.setScene(scene);
		Data.curRoom=this;
		pane.requestFocus();
	}
	public void addButton(Bttn b) {
		pane.getChildren().add(b.getButton());
	}
	public <A extends Actor> java.util.List<A> getActors(java.lang.Class<A> cls) {
		ArrayList<A> hold = new ArrayList<>();
		for (Node a : pane.getChildren()) {
			if (cls.isInstance(a)) {
				hold.add((A)a);
			}
		}
		return hold;
	}
	public void update(double dt) {
		for (int i=0;i<pane.getChildren().toArray().length;i++) {
			if (pane.getChildren().get(i) instanceof Actor) {
				((Actor)pane.getChildren().get(i)).act((long)dt);
			} //else if (n instanceof ActorB) {
				//((ActorB)n).update(dt);
			//}
		}
	}
	public void clear() {
		pane.getChildren().clear();
	}
	Collection<Node> getCollection() {
		return pane.getChildren();
	}
}