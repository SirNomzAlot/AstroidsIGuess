package ttw;

import enginev2.*;
import java.lang.Math;

public class Ufo extends ActorA {
	double rot = 160;
	double moveTime = 4;
	double bulletTime = 1;
	double bulletRot = 0;
	int health = 2;
	double vx;
	double vy;
	public Ufo() {
		super("resources/ufo.png");
		setX(Data.tabSX/2);
		setY(Data.tabSY);
		changeMove();
	}
	public void changeMove() {
		vx = Math.random()*100;
		vy = Math.random()*100;
		if (Math.random()>0.5) {
			vx*=-1;
		}
		if (Math.random()>0.5) {
			vy*=-1;
		}
	}
	public void calcTraj() {
		bulletRot=0;
		double tx=((double)Data.states.get("mx"));
		double ty=((double)Data.states.get("my"));
		double basAng = Math.toDegrees(Math.asin((tx-getX()+getWidth()/2)/Math.sqrt(Math.pow(tx-getX()+getWidth()/2,2)+Math.pow(ty-getY()+getHeight()/2,2))));
		if (tx<getX()+getWidth()/2) {
			if (ty<getY()+getWidth()/2) {
				bulletRot=360+basAng;
			} else {
				bulletRot=180-basAng;
			}
		} else {
			if (ty>getY()+getWidth()/2) {
				bulletRot=180-basAng;
			} else {
				bulletRot=basAng;			}
		}	
	}
	public void damage() {
		health--;
		if (health==0) {
			remove();
		}
	}
	@Override
	public void update(double dt) {
		double seconds = dt/1000000000.0;
		rotate(rot*seconds);
		move(vx*seconds,vy*seconds);
		bulletTime-=seconds;
		moveTime-=seconds;
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
		if (bulletTime<=0) {
			bulletTime=1;
			calcTraj();
			getRoom().addActor(new Laser(bulletRot,getX()+getWidth()/2,getY()+getHeight()/2));
			top();
		}
		if (moveTime<=0) {
			moveTime=4;
			changeMove();
		}
	}
}