  /**
   * Copyright (C) 2016 Securibox
   * 
   * This program is free software: you can redistribute it and/or modify 
   * it under the terms of the GNU General Public License as published by 
   * the Free Software Foundation, either version 3 of the License, or 
   * (at your option) any later version.
   * 
   * This program is distributed in the hope that it will be useful, 
   * but WITHOUT ANY WARRANTY; without even the implied warranty of 
   * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
   * GNU General Public License for more details.
   * 
   * You should have received a copy of the GNU General Public License 
   * along with this program.  If not, see <http://www.gnu.org/licenses/>.
   */

package core.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class Configuration {
	
	static Properties getProperties(String filename) {
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
