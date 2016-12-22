package core.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import core.ApiError;

public class HttpApiError implements ApiError {

	private final int code;
	
	private final String message;
	
	private final String description;
	
	@JsonCreator
	public HttpApiError(@JsonProperty("code") int code, @JsonProperty("message") String message, @JsonProperty("description") String description){
		this.code = code;
		this.message = message;
		this.description = description;
	}
	
	public String getMessage() {
		return this.message;
	}

	public String getDescription() {
		return this.description;
	}

	public int getCode() {
		return this.code;
	}

}
