package businesscomponent.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Algoritmo {
	public static String converti(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(password.getBytes(Charset.forName("UTF-8")));
			StringBuffer buffer = new StringBuffer();
			String salt = "Er93$£691Ter07p$a1!fd54";
			for (int i = 0; i < array.length; i++) {
				buffer.append(String.format("%x", array[i]) + salt);
			}
			return buffer.toString();
		} catch (NoSuchAlgorithmException exc) {
			return null;
		}
	}
}
