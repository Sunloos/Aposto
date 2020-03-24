package aposto.session;

import java.security.NoSuchAlgorithmException;
import aposto.math.Security;

public class Player {

	private String pseudo;
	private byte[] id;

	public Player(String name, String id) {
		this.pseudo = name;
		try {
			this.id = Security.getSHA(id);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return this.pseudo;
	}
	
	public String getID() {
		return this.id.toString()+"";
	}
	
	public void changeName(String newName) {
		this.pseudo = newName;
	}

}
