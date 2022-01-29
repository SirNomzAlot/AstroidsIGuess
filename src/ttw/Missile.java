package ttw;

import enginev2.ActorA;
import enginev2.Data;
import enginev2.AudioPlayer;
import enginev2.Audio;
import java.lang.Math;

public class Missile extends ActorA {
	double vx = 0;
	double vy = 0;
	double fx = 0;
	double fy = 0;
	double dx = 0;
	double dy = 0;
	double force = 10;
	double damageDel = 3;
	double damageDelCount = 0;
	boolean hasDamage = false;
	double fireDelayTimer = 0;
	Audio ps = new Audio("resources/ps.wav");
	Audio sh = new Audio("resources/sh.wav");
	Audio sp = new Audio("resources/sp.wav");
	Audio bang = new Audio("resources/bam.wav");
	Audio klang = new Audio("resources/klang.wav");
	Audio lowhealth = new Audio("resources/didit.wav");
	boolean hasStartedAccel = false;
	boolean audioPauser = false;
	double healthTimer = 0;
	public Missile() {
		super("resources/SpaceShipFlameOut.png");
		setX(Data.tabSX/2-getImage().getWidth()/2);
		setY(Data.tabSY/2-getImage().getHeight()/2);
		rotate(90);
	}
	public void calForce() {
		if (Data.keyPressedSmooth.get("w")!=null) {
			fx = -Math.toDegrees(Math.sin(Math.toRadians(-getRotation())))*force;
			fy = -Math.toDegrees(Math.cos(Math.toRadians(-getRotation())))*force;
		} else {
			fy = 0;
			fx = 0;
		}
	}
	public double totalV() {
		if (Math.sin(90-getRotation())==0) {
			return vy;
		}
		return 1/Math.sin(90-getRotation()*vx);
	}
	@Override
	public void update(double dt) {
		calForce();
		vx+=fx*dt/1000000000.0;
		vy+=fy*dt/1000000000.0;
		vx+=dx*dt/1000000000.0;
		vy+=dy*dt/1000000000.0;
		if (Data.keyPressedSmooth.get("w")!=null) {
			imageSet("resources/SpaceShipFlame.png");
			if (!hasStartedAccel) {
				AudioPlayer.play(ps);
			} else {
				if (audioPauser) {
					AudioPlayer.play(sh);
					audioPauser=false;
				}
				audioPauser=true;
			}
			hasStartedAccel=true;
		} else {
			imageSet("resources/SpaceShipFlameOut.png");
		}
		if (Data.keyPressedSmooth.get("a")!=null) {
			rotate(-160*dt/1000000000.0);
		} else if (Data.keyPressedSmooth.get("d")!=null) {
			rotate(160*dt/1000000000.0);
		}
		fireDelayTimer-=dt/1000000000.0;
		if (Data.keyPressedSmooth.get(" ")!=null&&fireDelayTimer<=0) {
			getRoom().addActor(new Bullet(getRotation(),getX()+getWidth()/2,getY()+getHeight()/2));
			fireDelayTimer=0.25;
			top();
			AudioPlayer.play(bang);
		}
		//dy = (0.015*vy*vy)/2;
		//dx = (0.015*vx*vx)/2;
		if (vx>0) {
			dx=-Math.abs(dx);
		}
		if (vy>0) {
			dy=-Math.abs(dy);
		}
		Data.states.put("mx",vx);
		Data.states.put("my",vy);
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
		if (hasDamage) {
			damageDelCount+=dt/1000000000.0;
		}
		if (((Health)Data.states.get("health")).getHealth()==1) {
			if (healthTimer<=0) {
				AudioPlayer.play(lowhealth);
				healthTimer=1;
			} else  {
				healthTimer-=dt/1000000000.0;
			}
		}
		if (damageDelCount>=damageDel) {
			hasDamage=false;
			damageDelCount=0;
			((Health)Data.states.get("health")).imageSwap();
		}
		Meteor met = getOneIntersectingObject(Meteor.class);
		if(met!= null) {
			if (!hasDamage) {
				met.remove();
				hasDamage=true;
				((Health)Data.states.get("health")).sub();
				((Health)Data.states.get("health")).setStatic();
				AudioPlayer.play(klang);
			}
		}
		Laser las = getOneIntersectingObject(Laser.class);
		if(las!= null) {
			if (!hasDamage) {
				las.remove();
				hasDamage=true;
				((Health)Data.states.get("health")).sub();
				((Health)Data.states.get("health")).setStatic();
				AudioPlayer.play(klang);
			}
		}
		Data.states.put("mx",getX()+getWidth()/2);
		Data.states.put("my",getY()+getHeight()/2);
	}
}