package org.websigni.piglets.statefuldrivinglicence.rest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class RestCommandResponse {

	// FIELDS
	private Object responseContent;
	
	// GETTERS AND SETTERS
	public Object getResponseContent() {
		return responseContent;
	}
	public void setResponseContent(Object responseContent) {
		this.responseContent = responseContent;
	}	
	
	// UTIL
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
