package aposto.math;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  

        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
	
}
