package aposto.game;

import aposto.settings.LevelConfigurator;

public class LevelLoader {

	public static void register(Level lvl) {

		if (lvl.getNum() == LevelConfigurator.getLevel()) {
			lvl.chargeLevel();
		}

	}

}
