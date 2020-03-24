package aposto.render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import aposto.settings.MainSettings;

import static org.lwjgl.opengl.GL11.*;

public class DisplayManager {

	public static void create(int width, int height, String title) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.setResizable(false);
			Display.create();

			glEnable(GL_DEPTH_TEST);
			glEnable(GL_CULL_FACE);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static String getTitle() {
		return Display.getTitle();
	}
	
	public static void setResizable(boolean why) {
		Display.setResizable(why);
	}

	public static void setTitle(String title) {
		Display.setTitle(title);
	}
	
	public static void setTitleWithSaver(String title) {
		Display.setTitle(title);
		MainSettings.setLastTitle(title);
		System.out.println("[ApostoLog] LastTitle Save : " + MainSettings.getLastTitle());
	}

	public static void update() {
		Display.update();
	}

	public static void clearBuffers() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}

	public static boolean isClosed() {
		return Display.isCloseRequested();
	}

	public static void dispose() {
		Display.destroy();
	}

	public static int getWidth() {
		return Display.getWidth();
	}

	public static int getHeight() {
		return Display.getHeight();
	}

	public static boolean wasResized() {
		return Display.wasResized();
	}

}