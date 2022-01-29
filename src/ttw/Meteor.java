package ttw;

import enginev2.ActorA;
import java.lang.Math;

public class Meteor extends ActorA {
	boolean big;
	double rot;
	double vx;
	double vy;
	public Meteor(boolean b,double x, double y) {
		big = b;
		if (big) {
			imageSet("resources/Meteor.png");
		} else {
			imageSet("resources/MeteorSmall.png");
		}
		setX(x);
		setY(y);
		rot = Math.random()*70;
		if (Math.random()>0.5) {
			rot*=-1;
		}
		vx = Math.random()*70;
		vy = Math.random()*70;
		if (Math.random()>0.5) {
			vx*=-1;
		}
		if (Math.random()>0.5) {
			vy*=-1;
		}
	}
	public Meteor(boolean b, double x, double y, double vx, double vy) {
		big = b;
		if (big) {
			imageSet("resources/Meteor.png");
		} else {
			imageSet("resources/MeteorSmall.png");
		}
		setX(x);
		setY(y);
		this.vx = vx*1.5;
		this.vy = vy*1.5;
		rot = Math.random()*90;
		if (Math.random()>0.5) {
			rot*=-1;
		}
	}
	public void split() {
		if (big) {
			getRoom().addActor(new Meteor(false,getX(),getY(),vy,vx));
			getRoom().addActor(new Meteor(false,getX(),getY(),-vy,-vx));
		}
		((LevelGen)getRoom()).addScore();
		remove();
	}
	@Override
	public void update(double dt) {
		rotate(rot*dt/1000000000.0);
		move(vx*dt/1000000000.0,vy*dt/1000000000.0);
		if (getX()<-getImage().getWidth()) {
			setX(500);
		} else if (getX()>500) {
			setX(-getImage().getWidth());
		}
		if (getY()>500) {
			setY(-getImage().getHeight());
		} else if (getY()<-getImage().getHeight()) {
			setY(500);
		}
	}
}