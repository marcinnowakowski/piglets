package org.websigni.piglets.statefuldrivinglicence;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class DrivingLincenceStore {

	// FIELDS
	private final Map<String, DrivingLicence> drivingLicenceMap = new HashMap<String, DrivingLicence> ();

    // GETTER AND SETTERS
	public Map<String, DrivingLicence> getDrivingLicenceMap() {
		return drivingLicenceMap;
	}

    // UTIL
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
