package eu.securibox.cloudagents.core.http;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import eu.securibox.cloudagents.core.Utils;
import eu.securibox.cloudagents.core.types.CountryCode;

public class UriParameters extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5698539679634758818L;

	public String getParameterString() {
		if (this.size() == 0)
			return "";

		List<String> params = new ArrayList<String>();
		for (Entry<String, String> entry : this.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			params.add(key + "=" + value);
		}
		return String.join("&", params);
	}

	public void put(String key, int value) {
		if (value > 0)
			super.put(key, Integer.toString(value));
	}
	
	@Override
	public String put(String key, String value) {
		if (!Utils.nullOrEmpty(value))
			return super.put(key, value);
		return "";
	}

	public void put(String key, Date value) {
		if(value != null)
			super.put(key, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'0000Z'").format(value));
	}

	public void put(String key, boolean value) {
		if(value)
			super.put(key, "true");
		else
			super.put(key,"false");
	}

	public void put(String key, CountryCode countryCode) {
		if(countryCode != null)
			this.put(key, countryCode.getCode());
		
	}

}

