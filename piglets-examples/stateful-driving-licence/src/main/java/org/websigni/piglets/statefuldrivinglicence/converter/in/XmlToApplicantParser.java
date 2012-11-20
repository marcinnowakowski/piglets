package org.websigni.piglets.statefuldrivinglicence.converter.in;

import org.apache.xmlbeans.XmlException;
import org.websigni.piglets.statefuldrivinglicence.Applicant;
import org.websigni.statefuldrivinglicence.xmlbeans.ApplicantDocument;
import org.websigni.statefuldrivinglicence.xmlbeans.ApplicantType;

/**
 * Class performing xml to object parsing for Applicant
 * 
 * @author Marcin_Nowakowski
 *
 */
public class XmlToApplicantParser {

	/**
	 * Create Applicant object parsing xml content
	 * 
	 * @param applicantXml - xml string
	 * @return
	 * @throws XmlException
	 */
	Applicant parse(String applicantXml) throws XmlException {
		
		// create xmlbeans object representing data read from xml
		ApplicantDocument applicantDocument 
			= ApplicantDocument.Factory.parse(applicantXml);
		ApplicantType xmlApplicant = applicantDocument.getApplicant();
		
		// create custom application object using xmlbeans object content
		Applicant applicant = new Applicant();
		try {
			applicant.setAge(Integer.parseInt(xmlApplicant.getAge()));
		} catch (NumberFormatException nfe) {
			// log it for debug purposes
		}
		applicant.setIdentificationNumber(xmlApplicant.getIdentificationNumber());
		
		return applicant;
	}
}