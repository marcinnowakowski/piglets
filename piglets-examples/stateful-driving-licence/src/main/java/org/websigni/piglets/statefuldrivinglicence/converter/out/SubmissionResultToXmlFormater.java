package org.websigni.piglets.statefuldrivinglicence.converter.out;

import org.websigni.piglets.statefuldrivinglicence.Applicant;
import org.websigni.piglets.statefuldrivinglicence.SubmissionResult;
import org.websigni.statefuldrivinglicence.xmlbeans.ApplicantType;
import org.websigni.statefuldrivinglicence.xmlbeans.SubmissionResultDocument;
import org.websigni.statefuldrivinglicence.xmlbeans.SubmissionResultType;

/**
 * Formats submission result representation to be compliant with xsd.
 * 
 * @author Marcin_Nowakowski
 */
public class SubmissionResultToXmlFormater {

	/**
	 * Format submission result to xml
	 * 
	 * @param submissionResult
	 * @return xml string
	 */
	String format(SubmissionResult submissionResult) {
		
		// create xml document
		SubmissionResultDocument submissionResultDocument 
			= SubmissionResultDocument.Factory.newInstance();
		SubmissionResultType xmlSubmissionResult 
			= submissionResultDocument.addNewSubmissionResult();
		
		// if submission object was of type applicant, add it to result
		if(submissionResult.getSubmissionObject() instanceof Applicant) {
			
			Applicant applicant = (Applicant) submissionResult.getSubmissionObject();
			
			ApplicantType xmlApplicant = xmlSubmissionResult.addNewApplicant();
			xmlApplicant.setAge("" + applicant.getAge());
			xmlApplicant.setIdentificationNumber(applicant.getIdentificationNumber());
		}
		
		// fill other fields in submission result
		xmlSubmissionResult.setAccepted(submissionResult.isAccepted());
		
		// list of decision descriptions
		for(String decisionDescription: submissionResult.getDecisionDescription()) {
			xmlSubmissionResult.addDecissionDescription(decisionDescription);
		}
		
		return submissionResultDocument.xmlText();
	}
}
