import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
import enginev2.*;
import engine.*;

public class Launcher extends Application {
	private AnimationTimer a;
	long time = -0;
	boolean isFirst = false;
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		double lastTime=0;
		Data.window = stage;
		try {
			Class.forName("Main");
			Main m = new Main();
			stage.setTitle(Data.tabName);
			stage.setResizable(Data.resizable);
			stage.setFullScreen(Data.fullscreen);
			stage.sizeToScene();
			a = new AnimationTimer() {
				@Override
				public void handle(long now) {
					if (!isFirst) {
						time = now;
						isFirst=true;
					}
					m.update((double)(now-time));
					Data.mousePressed=false;
					Data.mouseMoved=false;
					Data.keyPressed="";
					time=now;
				}
			};
			m.start();
			a.start();
			stage.show();
		} catch(ClassNotFoundException e) {
			ActorB bckgrd = new ActorB();
			ActorA cat=new ActorA();
			Room noMainSplash = new Room();
			bckgrd.addRect(Data.tabSX,Data.tabSY,0,0,new ColorRGB(140,140,140,255));
			noMainSplash.addActorB(bckgrd);
			cat = new ActorA("resources/DEADCATNOFILE.png",Data.tabSX/2,Data.tabSY/2);
			cat.setX(Data.tabSX/4);
			cat.setY(Data.tabSY/4);
			noMainSplash.addActor(cat);
			noMainSplash.setCurRoom();
			stage.show();
		}
	}
}