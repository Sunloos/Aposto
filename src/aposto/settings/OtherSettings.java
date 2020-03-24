package aposto.settings;

public class OtherSettings {
	
	private static boolean status;
	private static boolean logAction1;
	private static boolean logAction2;
	
	public static void setNewAction(boolean val) {
		status = val;
	}
	
	public static boolean isNewAction() {
		return status;
	}
	
	public static void setNewLogAction1(boolean val) {
		logAction1 = val;
	}
	
	public static boolean isNewLogAction1() {
		return logAction1;
	}
	
	public static void setNewLogAction2(boolean val) {
		logAction2 = val;
	}
	
	public static boolean isNewLogAction2() {
		return logAction2;
	}
	
}
