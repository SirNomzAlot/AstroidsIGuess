package ttw;

import enginev2.Data;
import enginev2.ActorA;

public class Health extends ActorA {
	int health = 3;
	public Health() {
		super("resources/HealthFull.png");
		setX(Data.tabSX-getImage().getWidth());
		setY(Data.tabSY-getImage().getHeight());
		Data.states.put("health",this);
	}
	public void imageSwap() {
		if (health==3) {
			imageSet("resources/HealthFull.png");
		} else if (health==2) {
			imageSet("resources/Health2.png");
		} else if (health==1) {
			imageSet("resources/Health1.png");
		} else {
			imageSet("resources/HealthNone.png");
		}
	}
	public void setStatic() {
		imageSet("resources/healthStatic.png");
	}
	public int getHealth() {
		return health;
	}
	public void sub() {
		health--;
		imageSwap();
	}
	public void add() {
		health++;
		imageSwap();
	}
}