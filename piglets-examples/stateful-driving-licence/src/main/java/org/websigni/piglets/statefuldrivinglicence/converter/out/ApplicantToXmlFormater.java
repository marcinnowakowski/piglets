package org.websigni.piglets.statefuldrivinglicence.converter.out;

import org.websigni.piglets.statefuldrivinglicence.Applicant;
import org.websigni.piglets.statefuldrivinglicence.SubmissionResult;
import org.websigni.statefuldrivinglicence.xmlbeans.ApplicantDocument;
import org.websigni.statefuldrivinglicence.xmlbeans.ApplicantType;
import org.websigni.statefuldrivinglicence.xmlbeans.SubmissionResultDocument;
import org.websigni.statefuldrivinglicence.xmlbeans.SubmissionResultType;

/**
 * Formats applicant object representation to be compliant with xsd.
 * 
 * @author Marcin_Nowakowski
 */
public class ApplicantToXmlFormater {

	/**
	 * Format applicant to xml
	 * 
	 * @param applicant
	 * @return xml string
	 */
	String format(Applicant applicant) {
		
		// create xml document
		ApplicantDocument applicantDocument 
			= ApplicantDocument.Factory.newInstance();
		ApplicantType xmlApplicant 
			= applicantDocument.addNewApplicant();
		
		// set fields
		xmlApplicant.setAge("" + applicant.getAge());
		xmlApplicant.setIdentificationNumber(applicant.getIdentificationNumber());
		
		// create xml string
		return applicantDocument.xmlText();
	}
}
