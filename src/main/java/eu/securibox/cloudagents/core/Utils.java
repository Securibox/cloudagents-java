  /**
   * Copyright (C) 2021 Securibox
   */
package eu.securibox.cloudagents.core;

public class Utils {

	public static String clearPath(String path) {
		if (path == null)
			return "";
		if (path.length() > 0 && "/".equals(path.substring(0, 1)))
			return path.substring(1);
		return path;
	}

	public static boolean nullOrEmpty(String input) {
		return (input == null || input.isEmpty());
	}

}