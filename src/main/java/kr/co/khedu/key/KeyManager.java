package kr.co.khedu.key;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KeyManager {
	private static final Properties prop = new Properties();

	static {
		try (InputStream input = KeyManager.class.getClassLoader().getResourceAsStream("keys.properties")) {
			if (input != null) {
				prop.load(input);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}
}
