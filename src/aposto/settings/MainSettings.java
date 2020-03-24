package aposto.settings;

import aposto.Main;
import aposto.render.Camera;

public class MainSettings {

	private static boolean isFpsTitle;
	private static boolean isFpsLog;
	private static boolean logStatus;
	private static boolean firstRunning;
	private static boolean awaitThread;

	private static String lastTitles;
	
	private static float FRAME_CAP;
	
	private static String player_name;
	
	public static void setPlayerName(String value) {
		player_name = value;
	}

	public static String getPlayerName() {
		return player_name;
	}

	public static void setFpsStatsInTitle(boolean status) {
		isFpsTitle = status;
	}
	
	public static void setActiveModifier(boolean status) {
		isFpsLog = status;
	}
	
	public static void setLogStatus(boolean status) {
		logStatus = status;
	}
	
	public static void firstRunning(boolean run) {
		firstRunning = run;
	}
	
	public static void setFpsRegulator(boolean value) {
		awaitThread = value;
	}

	public static boolean isFpsStatsInTitle() {
		return isFpsTitle;
	}
	
	public static boolean isFpsStatsInLog() {
		return isFpsLog;
	}
	
	public static boolean getLogStatus() {
		return logStatus;
	}
	
	public static boolean activeFpsRegulator() {
		return awaitThread;
	}
	
	public static boolean isFirstRunning() {
		return firstRunning;
	}

	public static void setLastTitle(String title) {
		lastTitles = title;
	}

	public static String getLastTitle() {
		return lastTitles;
	}

	public static void setFrameCap(float cap) {
		FRAME_CAP = cap;
	}

	public static float getFrameCap() {
		return FRAME_CAP;
	}
	
	public static Camera getCamera() {
		return Main.cam;
	}

}
