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
