package aposto.game;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Level {

	private String path;
	private int num;
	private Class<?> levelClass;

	public Level(String path, int id) {
		this.path = path;
		this.num = id;
	}

	@SuppressWarnings("static-access")
	public void chargeLevel() {
		Constructor<?> ob = null;
		try {
			ob = this.levelClass.forName(path).getConstructor();
			try {
				ob.newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				System.out.println("[ApostoLog:Error] Impossible d'ouvrir la classe "+ this.path);
			}
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			System.out.println("[ApostoLog:Error] Impossible de chargez la classe "+ this.path);
		}
	}

	public String getName() {
		return this.path;
	}

	public int getNum() {
		return this.num;
	}

	public Class<?> getAssociedClass() {
		return this.levelClass;
	}

	public void setNewAssociedClass(Class<?> obj) {
		this.levelClass = obj;
	}

}
