package aposto.settings;

public class LevelConfigurator {
	
	private static int actualLevel;
	
	public static void setLevel(int lvl) {
		actualLevel = lvl;
	}
	
	public static int getLevel() {
		return actualLevel;
	}

}
