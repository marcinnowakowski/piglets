package org.websigni.piglets.statefuldrivinglicence.rest;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class RestCommand {

	// FIELDS
	private HttpCommandTypeEnum httpCommandType;
	private CommandScopeEnum commandScope;
	private String context;
	private String id;
	private Object content;
	
	// CONSTRUCTORS
	public RestCommand(){}
	
	public RestCommand(String context, String method, String commandScope) {
		this(context, method, commandScope, null);
	}
	
	public RestCommand(String context, String method, String commandScope, String id) {
		this(context, method, commandScope, id, null);
	}
	
	public RestCommand(String context, String method, String commandScope, String id, Object content) {
		
		this.context = context;
		this.httpCommandType = HttpCommandTypeEnum.valueOf(method);
		this.commandScope = CommandScopeEnum.valueOf(commandScope);
		this.id = id;
		this.content = content;
	}
	
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
