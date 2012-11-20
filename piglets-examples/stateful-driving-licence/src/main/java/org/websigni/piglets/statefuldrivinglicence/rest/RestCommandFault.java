package org.websigni.piglets.statefuldrivinglicence.rest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class RestCommandFault {
	
	// FIELDS
	private String message;
	
	// GETTERS AND SETTERS
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	// UTIL
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
