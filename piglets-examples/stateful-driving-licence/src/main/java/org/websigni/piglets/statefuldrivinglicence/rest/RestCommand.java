package org.websigni.piglets.statefuldrivinglicence.rest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class RestCommand {

	// FIELDS
	private HttpCommandTypeEnum httpCommandType;
	private CommandScopeEnum commandScope;
	private String context;
	private String id;
	private Object content;
	
	// GETTERS AND SETTERS
	public HttpCommandTypeEnum getHttpCommandType() {
		return httpCommandType;
	}
	public void setHttpCommandType(HttpCommandTypeEnum httpCommandType) {
		this.httpCommandType = httpCommandType;
	}
	public CommandScopeEnum getCommandScope() {
		return commandScope;
	}
	public void setCommandScope(CommandScopeEnum commandScope) {
		this.commandScope = commandScope;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	// UTIL
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
