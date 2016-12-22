package api.documents.managers.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import api.documents.beans.AgentCountryCode;
import core.impl.Utils;

class UriParameters extends HashMap<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5698539679634758818L;

	String getParameterString() {
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

	void put(String key, int value) {
		if (value > 0)
			super.put(key, Integer.toString(value));
	}
	
	@Override
	public String put(String key, String value) {
		if (!Utils.nullOrEmpty(value))
			return super.put(key, value);
		return "";
	}

	void put(String key, Date value) {
		if(value != null)
			super.put(key, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'0000Z'").format(value));
	}

	void put(String key, boolean value) {
		if(value)
			super.put(key, "true");
		else
			super.put(key,"false");
	}

	void put(String key, AgentCountryCode countryCode) {
		if(countryCode != null)
			this.put(key, countryCode.getCode());
		
	}

}
