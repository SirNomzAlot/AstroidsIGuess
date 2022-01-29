package ttw;


public class Player {
	boolean difficulty;

	ArrayList<Tech> plKnown = new ArrayList<>();
	ArrayList<Tech> enemyKnown = new ArithmeticException<>();
	//nukes
	double nukeEfficiency = 0.95;
	double missileTime = 60;
	double missileTakeDown = 0.25;
	double conventionalEffective = 0.65;
	double portableDetection = 0.70;
	double portableSuccess = 0.95;
	double portableTime = 120;
	double secretTime = 180;
	double secretDetection = 0.5;
	double secretSuccess = 0.95;

	//espionage
	double spyCapture = 0.25;
	double intelChance = 0.1;

	//infastructure
	double encryptionStrength = 0.75;
	double simAccuracy = 0.75;
	double simSpeed = 120;
	double order = 0.95;

	//war
	double infantryEffeciency = 0.8;
	double tankEffeciency = 0.8;
	double navalEffeciency = 0.8;
	double airEffectiency = 0.8;
	//used in harder difficulty
	double nuclearRetMin = 0.1;
	double conventRetMin = 0.25;

	int totalPop = 200000000;
	int maxCityPop = 20000000;
	int minCityPop = 800000;
	int totalCity = 10;
	int totalTown = 100;

	double relation = 0.3;

	Tech curRes;
	double curResTime = 0;

	public enum Tech {
		BETTERNUKE("More Explosive Nukes",
			"Do you suffer from pathetic nukes? Invest in MEN to keep your nukes bangin.\n\nNuke Efficiency 150%\nSecret Nuke Efficiency 150%\nPortable Nuke Efficiency 150%",
			60),
		IMPROVEDSPY("Grey Man Effect",
			"Creation of the Grey Man Group to make sure you spies blend in.\n\nSpy Capture 50%",
			60),
		DEFMISSILE("Missle to Missle Defense",
			"Can you not take opposing MEN, try MMD sollutions to hault the MEN.\n\nMissle TakeDown 200%",
			60),
		ENCRYPTION("Encryption",
			"Send your messages backwards for more security.\n\nMessage Decryption Time 200%",
			60),
		DECRYPTION("Decryption",
			"Using new revolutionary tequniques decryption is now possible.\n\nIntel Likelyness 125%",
			60),
		SATCAM("Satelite Cameras",
			"For when your drones are taken out by drones with nets.\n\nIntel Likelyness 125%",
			60),
		SATNUKE("Nukes in Space",
			"Theres problably a law against that.\n\nMissle Time 25%",
			60),
		BIOWEAPON("Asbestose Bomb",
			"Side effects may include: spontanious fire resistance, mesotheilioma, and or a hairy appearance.\n\nConventional Efficiency 175%\nEnemy Nuclear Retaliation 115%",
			60),
		SATLASER("Satelites With Fricking Laser Beams",
			"Perfect for making popcorn!\n\nConventional Efficiency 150%",
			60),
		FELINESPY("Feline Espionage Device",
			"Isn't this an SCP or something?\n\nIntel Likelyness 150%",
			60),
		JEDIMIND("This is the Tech You are Looking For",
			"It worked on Allan, so why not the enemy?\n\nSpy Capture 75%",
			60),
		CATNUKE("Nuclear Robo-Cats",
			"We tried live cats but they ended up in limbo.\n\nPortable Nuke Detection 50%",
			60),
		FASTMISSILE("Hypersonic Missles",
			"We strapped a hedgehog to a missle and found that the missle went faster.\n\nMissle Time 75%",
			60),
		DRILLNUKE("Subterranian Nukes",
			"People tend to see big flying sticks, they dont see big deep sticks.\n\nSecret Nuke Time 400%\nSecret Nuke Detection 400%",
			60),
		GROUNDRADAR("Ground Radar",
			"For when you cant see big deep sticks.\n\nSecret Nuke Detection 400%",
			60),
		AREAJAMMER("City Wide Jammer",
			"Send out people to apply jam to cats and briefcases.\n\nEnemy Portable Nuke Success 25%",
			60),
		MENTALFORT("Mental Fortitude",
			"Training for Allan to not let random people in.\n\nEnemy Spy Capture 125%",
			60),
		LIDAR("Lidar",
			"It literally lidar, what did you expect?\n\nMissle TakeDown 115%",
			60),
		LRRADAR("Long Range Radar",
			"We strapped a few microwaves to our radar sites, boosted the range.\n\nAir Target Detection 150%",
			60),
		PRETTYLIGHT("Pretty Lights",
			"Make them believe in aliens!\n\nEnemy Order 50%",
			60),
		PNUKESENSE("Portable Nuke Sensors",
			"Specific people who go out and question anything moving, typically with a hard electrified rod.\n\nEnemy Portable Nuke Detection 175%",
			60),
		IMPROVEDSIM("Improved Simulations",
			"Writing in MIPS is very confusing...\n\nSimulation Projection Accuracy 150%",
			60),
		QUANTUMCOMP("Quantum Computers",
			"Were gonna miss having toast at the end of every sim.\n\nSimulation Time 50%",
			60),
		DEPLOYWALLS("Blast Walls",
			"KOWALSKI DEPLOY THE RUBBER ROOM!\n\nEnemy Nuke Efficiency 75%",
			60),
		SATTOSATGUN("Sat to Sat Weaponry",
			"Why do only troops have guns? Sats need guns too!\n\nSatelite Destruction Increases Satelite Faliure.",
			60),
		EMPSAT("EMP Satelite",
			"To shut up nerds at home who complain about \"explosions in space\".\n\nSatelite Faliure Doesn't Increase from Destruction",
			60),
		MAINTFOCUS("Heightened Focus",
			"Using hard drugs a \"heightend\" focus can be obtained.\n\nOrder 175%",
			60),
		GENEVAPROT("Geneva Protocal",
			"Now you can say that thats agains the Geneva Convention.\n\nBio Weapons are Illegal for All",
			60),
		BIGGERGUNS("Bigger Guns",
			"The M1, The M16... NOT GOOD ENOUGH! we need Tankgewehr.\n\nInfatry efficiency 125%",
			60),
		HESHELLS("High Explosive Shells",
			"Full Title: High Explosive Armour Piercing Capped Balistic Capped Anti-Tank Composite Rigid Fin Stabilized Shells.\n\nTank Effeciency 125%",
			60),
		BATTLESHIP("Ship Shenanigans",
			"Weirdness to get past the Washington treaty. In essence pocket battleships.\n\nNaval Effeciency 125%",
			60),
		BEARFORCE("Bear Force One",
			"Hoo Ha! HO HA!\n\nAir Force Efficiency 125%",
			60);

		private final String name;
		private final String des;
		private final double time;

		public String name() {
			return name;
		}
		public String desc() {
			return des;
		}
		public double time() {
			return time;
		}
	}
	public Player(boolean d) {
		difficulty =d;
	}
	public boolean canNuke() {
		if (difficulty&&relation<=nuclearRetMin) {
			return true;
		} else if (difficulty) {
			return false;
		}
		return true;
	}
	public boolean canConvent() {
		if (difficulty&&relation<=conventRetMin) {
			return true;
		} else if (difficulty) {
			return false;
		}
		return true;
	}
	public boolean setCurRes(Tech t) {
		if (curRes==null) {
			curRes=t;
			return true;
		}
		return false;
	}
	public void finishRes() {
		if (curRes!=null&&curResTime>=curRes.time()) {
			plKnown.add(curRes);
			curRes=null;
			curResTime=0;
		}
	}
	public void update(double dt) {
		if (curRes!=null) {
			curResTime+=dt/1000000000.0;
		}
		finishRes();
	}
}