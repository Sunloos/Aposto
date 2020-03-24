package aposto;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import aposto.math.Vector3f;
import aposto.render.Camera;
import aposto.render.DisplayManager;
import aposto.session.Player;
import aposto.settings.MainSettings;
import aposto.settings.OtherSettings;
import games.InGame;

public class Main {

	private static boolean running = false;

	private static Player player;

	public static Camera cam;

	public Main() {
		DisplayManager.create(720, 480, "Aposto");
		cam = new Camera(new Vector3f(0, 0, 0));
		cam.setPerspectiveProjection(70.0f, 0.1f, 1000.0f);
	}

	public void start() {

		System.out.println("[ApostoLog] Start 3D App...");
		InGame.start();

		if(MainSettings.getPlayerName() != null || MainSettings.getPlayerName() != "") {
			player = new Player(MainSettings.getPlayerName(), "apostoSession" + System.currentTimeMillis());
		} else {
			int random = (int) Math.floor(1 + (Math.random() * 9999));
		    player = new Player("Player" + random, "apostoSession" + System.currentTimeMillis());
		}
		
		
		MainSettings.firstRunning(true);
		MainSettings.setFpsRegulator(true);
		running = true;
		loop();

	}

	public void stop() {
		System.out.println("[ApostoLog] Stop 3D App...");
		running = false;
	}

	public void exit() {
		System.out.println("[ApostoLog] Exit Process");
		DisplayManager.dispose();
		System.exit(0);
	}

	public void loop() {

		long lastTickTime = System.nanoTime();
		long lastRenderTime = System.nanoTime();

		double tickTime = 1000000000.0 / 60.0;
		double renderTime = 1000000000.0 / MainSettings.getFrameCap();

		int ticks = 0;
		int frames = 0;

		long timer = System.currentTimeMillis();

		while (running) {
			if (DisplayManager.isClosed()) {
				System.out.println("[ApostoLog] Window Closed");
				stop();
			}

			boolean rendered = false;

			if (System.nanoTime() - lastTickTime > tickTime) {
				update();
				InGame.whileTicks();
				ticks++;
				lastTickTime += tickTime;
			} else if (System.nanoTime() - lastRenderTime > renderTime) {
				render();
				DisplayManager.update();
				InGame.whileRenders();
				frames++;
				rendered = true;
				lastRenderTime += renderTime;
			}

			if (System.currentTimeMillis() - timer > 1000) {
				OtherSettings.setNewAction(true);
				timer += 1000;
				if (MainSettings.isFpsStatsInTitle() == true) {
					String title;
					OtherSettings.setNewLogAction1(true);
					OtherSettings.setNewLogAction2(true);
					if (MainSettings.isFpsStatsInLog() == true && OtherSettings.isNewLogAction1() == true
							&& OtherSettings.isNewLogAction2() == true) {
						title = MainSettings.getLastTitle() + " ";
						OtherSettings.setNewLogAction1(true);
						OtherSettings.setNewLogAction2(true);
					} else if (OtherSettings.isNewLogAction1() == false && OtherSettings.isNewLogAction2() == false) {
						title = "Aposto 3D Motor" + " ";
					} else {
						OtherSettings.setNewLogAction1(true);
						title = DisplayManager.getTitle();
					}
					DisplayManager.setTitle(title + ticks + " ticks, " + frames + " fps (" + player.getName() + ", "
							+ player.getID() + ")");
				}
				if (MainSettings.isFpsStatsInLog() == true && MainSettings.getLogStatus() == true) {
					System.out.println("[ApostoLog] " + ticks + " ticks, " + frames + " fps ");
				}
				ticks = 0;
				frames = 0;
			}

			if (MainSettings.activeFpsRegulator() == true && rendered && (frames >= MainSettings.getFrameCap())) {
				try {
					Thread.sleep((int) (1000.0 / (MainSettings.getFrameCap() + frames)));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (MainSettings.isFirstRunning()) {
				System.out.println("[ApostoLog] Succesfuly Start !");
				InGame.postStart();
				MainSettings.firstRunning(false);
			}

		}
		exit();
	}

	public void update() {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Mouse.setGrabbed(false);
			if (OtherSettings.isNewAction()) {
				OtherSettings.setNewAction(false);
				System.out.println("[ApostoLog] Exit Camera Control");
			}
		}
		if (Mouse.isButtonDown(0)) {
			if (OtherSettings.isNewAction()) {
				OtherSettings.setNewAction(false);
				System.out.println("[ApostoLog] Enter Camera Control");
			}
			Mouse.setGrabbed(true);
		}
		if (!Mouse.isGrabbed())
			return;
		cam.input();
	}

	public void render() {
		if (DisplayManager.wasResized()) {
			GL11.glViewport(0, 0, DisplayManager.getWidth(), DisplayManager.getHeight());
		}
		DisplayManager.clearBuffers();
		cam.getPerspectiveProjection();
		cam.update();

		InGame.Levels();
	}

	public static void main(String[] args) {
		Main main = new Main();
		InGame.preStart();
		main.start();
	}

}
