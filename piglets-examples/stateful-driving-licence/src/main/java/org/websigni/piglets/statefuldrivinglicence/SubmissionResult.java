package org.websigni.piglets.statefuldrivinglicence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class SubmissionResult {

	// FIELDS
	private Object submissionObject;
	private boolean accepted = false;
	private List<String> decisionDescription = new ArrayList<String>();

	// GETTER AND SETTERS
    public Object getSubmissionObject() {
		return submissionObject;
	}

	public void setSubmissionObject(Object submissionObject) {
		this.submissionObject = submissionObject;
	}
	
	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public List<String> getDecisionDescription() {
		return decisionDescription;
	}

	public void setDecisionDescription(List<String> decisionDescription) {
		this.decisionDescription = decisionDescription;
	}

	// UTIL
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
