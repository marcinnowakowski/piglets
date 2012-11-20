package org.websigni.piglets.statefuldrivinglicence;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ApplicantStore {

	// FIELDS
	private final Map<String, Applicant> applicantMap = new HashMap<String, Applicant> ();

    // GETTER AND SETTERS
	public Map<String, Applicant> getApplicantMap() {
		return applicantMap;
	}
    
    // UTIL
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
