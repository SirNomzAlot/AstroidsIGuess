package ttw;

import java.io.Serializable;
import enginev2.*;
import java.util.ArrayList;

public class HSBoard extends Room implements Serializable {
	ArrayList<String> names = new ArrayList<>();
	ArrayList<Integer> scores = new ArrayList<>();
	Txt toshow;
	boolean allowUpdate = false;
	String currName = "";
	int currNameLength = 0;
	public HSBoard() {
		update();
	}
	public void sort(int start,int end) {
		int pivot = end;
		for (int i=start;i<pivot;i++) {
			if (scores.get(pivot).compareTo(scores.get(i))>0) {
				Integer hold = scores.get(i);
				Integer hold2 = scores.get(pivot);
				scores.set(i,scores.get(pivot-1));
				scores.set(pivot-1,hold2);
				scores.set(pivot,hold);

				String hold3 = names.get(i);
				String hold4 = names.get(pivot);
				names.set(i,names.get(pivot-1));
				names.set(pivot-1,hold4);
				names.set(pivot,hold3);

				pivot--;
				i--;
			}
		}
		if (end-start>3) {
			if (pivot==0) {
				sort(start+1,end);

			} else {
				sort(start,pivot-1);
				sort(pivot+1,end);
			}
		}
	}
	public void add(int score) {
		clear();
		scores.add(score);
		ActorB back = new ActorB();
		back.addRect(Data.tabSX,Data.tabSY,0,0,new ColorRGB(0,0,0));
		addActorB(back);
		Txt scr = new Txt("Score: "+score);
		scr.setY(scr.getHeight());
		scr.setX(Data.tabSX/2-scr.getWidth()/2);
		scr.setColor(new ColorRGB(255,255,255));
		addText(scr);
		toshow = new Txt("Name: _");
		currName="";
		currNameLength=0;
		toshow.setSize(25);
		toshow.setY(Data.tabSY/2-toshow.getHeight()/2);
		toshow.setX(Data.tabSX/2-toshow.getWidth()/2);
		toshow.setColor(new ColorRGB(255,255,255));
		addText(toshow);
		allowUpdate=true;
	}
	public void update() {
		ActorB back = new ActorB();
		back.addRect(Data.tabSX,Data.tabSY,0,0,new ColorRGB(0,0,0));
		addActorB(back);
		Txt title = new Txt("Scores");
		title.setY(title.getHeight());
		title.setX(Data.tabSX/2-title.getWidth());
		title.setSize(20);
		title.setColor(new ColorRGB(255,255,255));
		addText(title);
		if (names.size()==15) {
			names.remove(15);
			scores.remove(15);
		}
		addButton(new Bttn("Main Menu",0,0,() -> {
			((Room)Data.states.get("main")).setCurRoom();
		}));
		Txt example = new Txt();
		double yoffset = title.getHeight()*2;
		for (int i=0;i<names.size();i++) {
			example.setText((i+1)+" - "+scores.get(i)+" - "+names.get(i));
			addText(new Txt((i+1)+" - "+scores.get(i)+" - "+names.get(i),Data.tabSX/2-example.getWidth(),yoffset+example.getHeight(),new ColorRGB(255,255,255)));
			yoffset+=example.getHeight()*2;
		}
	}
	@Override
	public void update(double dt) {
		if (allowUpdate) {
			if (Data.keyPressed.equals("\n")) {
				allowUpdate=false;
				names.add(currName);
				sort(0,scores.size()-1);
				update();
			} else if (Data.keyPressed.equals("\b")&&currNameLength>0) {
				//System.out.print("current name"+currName);
				currName=currName.substring(0,currNameLength-1);
				currNameLength--;
			} else if (!Data.keyPressed.equals("")) {
				currName=currName+Data.keyPressed;
				currNameLength++;
			}
			toshow.setText("name: "+currName+"_");
			toshow.setY(Data.tabSY/2-toshow.getHeight()/2);
			toshow.setX(Data.tabSX/2-toshow.getWidth()/2);
		}
	}
}