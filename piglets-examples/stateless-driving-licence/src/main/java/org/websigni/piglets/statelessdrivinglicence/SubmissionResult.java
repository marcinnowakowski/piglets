package org.websigni.piglets.statelessdrivinglicence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class SubmissionResult {

	// FIELDS
	private Applicant applicant;
	private Application application;
	private boolean accepted = false;
	private List<String> decisionDescription = new ArrayList<String>();
	
    // GETTER AND SETTERS
    public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
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
