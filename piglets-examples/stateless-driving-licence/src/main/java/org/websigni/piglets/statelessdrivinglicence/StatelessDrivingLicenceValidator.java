/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * updated by Marcin Nowakowski 11-2012
 */

package org.websigni.piglets.statelessdrivinglicence;

import java.util.Arrays;
import java.util.Date;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

/**
 * Example presenting usage of staless knowledge session
 * 
 * @modified by Marcin_Nowakowski
 *
 */
public class StatelessDrivingLicenceValidator {
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String [] args) {
		
		// create driving licence application processor
		StatelessDrivingLicenceValidator drivingLicence = new StatelessDrivingLicenceValidator();
		
		// create submission data
		Applicant applicant = new Applicant();
		applicant.setIdentificationNumber("000001");
		applicant.setAge(27);
		
		Application application = new Application();
		application.setSubmissionDate(new Date());
		
		// perform submission
		SubmissionResult submissionResult = drivingLicence.submitApplication(applicant, application);
		
		// present result
		System.out.println("Application was submited with result: " + submissionResult);
		
		
	}
	
	/**
	 * Perform aplication submission for:
	 * @param applicant,
	 * @param application
	 */	
	public SubmissionResult submitApplication(Applicant applicant, Application application) {
	
		// load rules definition
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add( 
				ResourceFactory.newClassPathResource( 
						"drivingLicense.drl", StatelessDrivingLicenceValidator.class ), 
				ResourceType.DRL );

		// check for errors
		if ( kbuilder.hasErrors() ) {
			String knowledgeBuilderErrors = kbuilder.getErrors().toString();
		    System.err.println( knowledgeBuilderErrors );
		    throw new RuntimeException(knowledgeBuilderErrors);
		}

		// create knowledge base
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );
		
		// create stateless knowledge session
		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();
		
		// prepare result
		SubmissionResult result = new SubmissionResult();
		ksession.execute( Arrays.asList( new Object[] { application, applicant, result } ) );
		
		return result;
		
	}

}

