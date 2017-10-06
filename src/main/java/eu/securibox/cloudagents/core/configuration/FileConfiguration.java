package eu.securibox.cloudagents.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileConfiguration {
	static public Properties getProperties(String filename) {
		Properties properties = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("The configuration file " + filename + " can not be found.", e);
		}
		try {
			properties.load(input);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load the configuration file " + filename + ".", e);
		}
		return properties;
	}
}
