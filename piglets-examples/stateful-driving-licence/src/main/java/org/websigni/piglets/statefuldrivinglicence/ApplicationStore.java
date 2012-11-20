package org.websigni.piglets.statefuldrivinglicence;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ApplicationStore {

	// FIELDS
	private final Map<String, Application> applicationMap = new HashMap<String, Application> ();

    // GETTER AND SETTERS
	public Map<String, Application> getApplicationMap() {
		return applicationMap;
	}

    // UTIL
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
