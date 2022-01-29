package ttw;

import enginev2.*;
import java.lang.Math;

public class LevelGen extends Room {
	Txt time;
	double t;
	Txt score;
	int lev;
	int numScore =0;
	int displayScore;
	Health h = new Health();
	double ufoChance = 0;
	HSBoard board = new HSBoard();
	Audio dodoido = new Audio("resources/dodoido.wav");
	public LevelGen() {
		reset();
	}
	public void reset() {
		clear();
		System.gc();  
		numScore=0;
		lev=1;
		t=0;
		ufoChance=0;
		displayScore=0;
		time = new Txt("Time: "+t+"s",0,Data.tabSY);
		time.setColor(new ColorRGB(255,255,255));
		score = new Txt("Score: "+displayScore);
		score.setY(score.getHeight());
		score.setX(Data.tabSX/2-score.getWidth()/2);
		score.setColor(new ColorRGB(255,255,255));
		ActorB back = new ActorB();
		back.addRect(Data.tabSX,Data.tabSY,0,0,new ColorRGB(0,0,0));
		addActorB(back);
		addText(time);
		addText(score);
		addActor(new Missile());
		double x = 0;
		double y = 0;
		for (int i=0;i<=lev*5;i++) {
			if (Math.random()>0.5) {
				x = Math.random()*(Data.tabSX-Data.tabSX/4*3)+Data.tabSX/4*3;
			} else {
				x = Math.random()*Data.tabSX/4;
			}
			if (Math.random()>0.5) {
				y = Math.random()*(Data.tabSY-Data.tabSY/4*3)+Data.tabSY/4*3;
			} else {
				y = Math.random()*Data.tabSY/4;
			}
			addActor(new Meteor(true,x,y));
		}
		h = new Health();
		addActor(h);
		addButton(new Bttn("Main Menu",0,0,() -> {
			((Room)Data.states.get("main")).setCurRoom();
		}));
	}
	public void levelUp() {
		clear();
		System.gc();
		lev++;
		h.add();
		time = new Txt("Time: "+t+"s",0,Data.tabSY);
		time.setColor(new ColorRGB(255,255,255));
		score = new Txt("Score: "+numScore);
		score.setY(score.getHeight());
		score.setX(Data.tabSX/2-score.getWidth()/2);
		score.setColor(new ColorRGB(255,255,255));
		ActorB back = new ActorB();
		back.addRect(Data.tabSX,Data.tabSY,0,0,new ColorRGB(0,0,0));
		addActorB(back);
		addText(time);
		addText(score);
		addActor(new Missile());
		double x = 0;
		double y = 0;
		for (int i=0;i<=lev*7;i++) {
			if (Math.random()>0.5) {
				x = Math.random()*(Data.tabSX-Data.tabSX/3*2)+Data.tabSX/3*2;
			} else {
				x = Math.random()*Data.tabSX/3;
			}
			if (Math.random()>0.5) {
				y = Math.random()*(Data.tabSY-Data.tabSY/3*2)+Data.tabSY/3*2;
			} else {
				y = Math.random()*Data.tabSY/3;
			}
			addActor(new Meteor(true,x,y));
		}
		addActor(h);
		addButton(new Bttn("Main Menu",0,0,() -> {
			((Room)Data.states.get("main")).setCurRoom();
		}));
	}
	public void addScore() {
		numScore+=10;
	}
	@Override
	public void update(double dt) {
		super.update(dt);
		t+=dt/1000000000.0;
		ufoChance=dt/100000000000.0;
		if (ufoChance>=Math.random()) {
			addActor(new Ufo());
			AudioPlayer.play(dodoido);
		}
		displayScore=(int)(numScore*numScore/t);
		time.setText("Time: "+Math.round(t)+"s");
		score.setText("Score: "+displayScore);
		score.setX(Data.tabSX/2-score.getWidth()/2);
		if (getActors(Meteor.class).size()==0) {
			levelUp();
		}
		if (h.getHealth()==0) {
			board.add(displayScore);
			board.setCurRoom();
		}
	}
}