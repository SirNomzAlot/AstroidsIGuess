package ttw;

import enginev2.ActorA;
import enginev2.Audio;
import enginev2.AudioPlayer;
import java.lang.Math;

public class Laser extends ActorA {
	double vx;
	double vy;
	double totalSpeed = 12;
	double lifeSpan = 4;
	public Laser(double rotation, double x, double y) {
		super("resources/laser.png");
		setX(x-getImage().getWidth()/2);
		setY(y);
		rotate(rotation);
		vx = -Math.toDegrees(Math.sin(Math.toRadians(-getRotation())))*totalSpeed;
		vy = -Math.toDegrees(Math.cos(Math.toRadians(-getRotation())))*totalSpeed;
	}
	@Override
	public void update(double dt) {
		move(vx*dt/1000000000.0,vy*dt/1000000000.0);
		lifeSpan-=dt/1000000000.0;
		if (lifeSpan<=0) {
			remove();
		}
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