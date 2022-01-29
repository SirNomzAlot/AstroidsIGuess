import java.util.HashMap;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Thread;
import java.util.Map;

public class Demo {
	// thresholds for peace and war
	int tension = 50;
	// your and ai funding in million
	int aiFund = 9;
	int Fund = 9;
	// percentage of funds for mil and sci with remainder going into economy
	double aiMilFund = 3;
	double milFund = 3;
	double aiSciFund = 3;
	double sciFund = 3;
	// false = easy, true = normal cough hard cough, null = ABSOLUE RANDOMNESS
	Boolean difficulty = false
	//tech tree sorta thing not quite sure how to do it.
	String defGrid = "defGrid";
	String impNukes = "ImNukes";
	String socialManip = "SocialManip";
	HashMap<String,Integer> aiSci = new HashMap<>().put(defGrid,0).put(impNukes,0).put(socialManip,0);
	HashMap<String,Integer> sci = new HashMap<>().put(defGrid,0).put(impNukes,0).put(socialManip,0);
	//stats
	int aiPopulus = 1500000;
	int Populus = 1500000;
	int aieconomicHealth = 95;
	int economicHealth = 95;
	//likelyness to nuke
	int relation = 25;

	String aiCurrRes;
	String currRes;

	boolean aiNice = true;
	boolean hasPromptPrinted = false;
	boolean isAiResarch = false;
	public static void main(String[] args) {
		if (!isAiResarch) {
			researchAi();
		} else if (Math.random()>0.95) {
			researchAi();
		}
		if (Math.random()>0.5) {
			aiMoves();
		}
	}
	public void research(String in) {
		for (Map.Entry<String,Boolean> entry : aiSci.entrySet()) {
			if (entry.getKey().equals(in)) {
				if (entry.getValue()==100) {
					System.out.println("Thats already researched");
				} else {
					currRes=entry.getKey();
				}
			}
		}
	}
	public void researchAi() {
		for (Map.Entry<String,Boolean> entry : aiSci.entrySet()) {
			if (!entry.getValue()==100) {
				aiCurrRes=entry.getKey();
			}
		}
	}
	public void aiMoves() {
		if (difficulty==null) {
			if (Math.random()>0.5) {
				aiNice=false;
				printRandPrompt();
			} else {
				aiNice=true;
				printRandPrompt();
			}
		} else if (difficulty) {
			if (Math.random()>0.6) {
				aiNice=false;
				printRandPrompt();
			} else {
				aiNice=true;
				printRandPrompt();
			}
		} else {
			if (Math.random()>0.8) {
				aiNice=false;
				printRandPrompt();
			} else {
				aiNice=true;
				printRandPrompt();
			}
		}
	}
	public void printRandPrompt() {
		if (Math.random()>0.5) {
			if (Math.random()>0.5) {
				System.out.print("1");
			} else {
				System.out.print("A few");
			}
			System.out.print(" plane(s) enemy planes have been detected in our airspace, was it a mistake or not?");
		} else {
			System.out.print("There is intel of enemy missles being moved to a remote island, shall we question them or not?");
		}
	}
}