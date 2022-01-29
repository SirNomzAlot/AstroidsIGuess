import enginev2.*;
import ttw.*;

public class Main {
	double time=0;
	boolean passSplash = true;
	Room engineSplash = new Room();
	Room main = new Room();
	LevelGen t = new LevelGen();
	//modify tab structure here
	public Main(){
		Data.tabName="AIG";
	}

	//runs one time, basic startup.
	public void start() {
		ActorB bckgrd = new ActorB();
		bckgrd.addRect(Data.tabSX,Data.tabSY,0,0,new ColorRGB(0,0,0,255));
		engineSplash.addActorB(bckgrd);
		ActorA cat = new ActorA("resources/DEADCATGAMEENGINE.png",Data.tabSX/2,Data.tabSY/2);
		cat.setX(Data.tabSX/4);
		cat.setY(Data.tabSY/4);
		engineSplash.addActor(cat);
		engineSplash.setCurRoom();

		Txt title = new Txt("Asteroids I guess",Data.tabSX/5,Data.tabSY/5);
		title.setColor(new ColorRGB(0,0,0,255));
		Bttn start = new Bttn("Start",Data.tabSX/50,Data.tabSY/2.5,() -> {
			t.reset();
			t.setCurRoom();
		});
		Bttn quit = new Bttn("Quit",Data.tabSX/50,Data.tabSY/2,() -> {
			System.exit(0);
		});
		main.addButton(quit);
		main.addButton(start);
		main.addText(title);
		Data.states.put("main",main);
	}

	//runs until game end, dt is change in time. Data is a game state holder sorta thing
	public void update(double dt) {
		time+=dt;
		//if (time>=1500000000.0&&passSplash) {
		if (true) {
			main.setCurRoom();
			passSplash = false;
		}
		Data.curRoom.update(dt);
	}
}