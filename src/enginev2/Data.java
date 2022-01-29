package enginev2;

import javafx.stage.Stage;
import java.util.HashMap;

public class Data {
	public static final boolean GAMEEND = true;
	public static final boolean GAMEON = false;
	public static final boolean FULLSCREEN = true;
	public static final boolean WINDOWED = false;
	public static final String PRIMARYMB = "P";
	public static final String SECONDARYMB = "S";
	public static final String MIDDLEMB = "M";
	public static String tabName = "";
	public static double tabSX = 500;
	public static double tabSY = 500;
	public static boolean resizable = false;
	public static boolean fullscreen = WINDOWED;
	public static boolean gameState = GAMEON;
	public static double font = tabSY/25;
	public static Stage window;
	public static Room curRoom;
	public static String keyPressed = "";
	public static HashMap<String,Boolean> keyPressedSmooth = new HashMap<>();
	public static boolean mousePressed = false;
	public static boolean mouseMoved = false;
	public static double mouseX = 0;
	public static double mouseY = 0;
	public static double volume = 1;
	public static boolean leftArrow = false;
	public static boolean rightArrow = false;
	public static boolean upArrow = false;
	public static boolean downArrow = false;
	public static String mouseButton = null;
	public static HashMap<String, Object> states = new HashMap<>();
	public Data() {
	}
}