package ttw;


public abstract class Tech {
	public boolean hasAiRes = false;
	public boolean hasPlRes = false;
	String description;
	double resTime;
	Act ai;
	Act pl;
	public Tech(String des, double time, Action a,Action p) {
		description=des;
		resTime=time;
		ai=a;
		pl=p
	}
	public void aiRes() {
		hasAiRes=true;
		aiAqu();
	}
	public void plRes() {
		hasPlRes=true;
		plAqu();
	}
	public void aiAqu() {
		ai.act();
	}
	public void plAqu() {
		pl.act();
	}
}