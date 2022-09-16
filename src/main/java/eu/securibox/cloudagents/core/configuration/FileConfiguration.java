package eu.securibox.cloudagents.core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileConfiguration {
	public static Properties getProperties(String filename) {
		Properties properties = new Properties();
		try (InputStream input = new FileInputStream(filename)) {
			properties.load(input);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("The configuration file " + filename + " can not be found.", e);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load the configuration file " + filename + ".", e);
		}
		return properties;
	}
}
