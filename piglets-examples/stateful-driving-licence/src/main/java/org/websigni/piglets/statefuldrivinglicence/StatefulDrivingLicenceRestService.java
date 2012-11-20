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

package org.websigni.piglets.statefuldrivinglicence;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.websigni.piglets.statefuldrivinglicence.rest.CommandScopeEnum;
import org.websigni.piglets.statefuldrivinglicence.rest.HttpCommandTypeEnum;
import org.websigni.piglets.statefuldrivinglicence.rest.RestCommand;
import org.websigni.piglets.statefuldrivinglicence.rest.RestCommandResponse;

/**
 * Example presenting usage of staless knowledge session
 * 
 * @author Marcin_Nowakowski
 *
 */
public class StatefulDrivingLicenceRestService {
	
	StatefulKnowledgeSession ksession;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String [] args) {
		
		// create driving licence application processor
		StatefulDrivingLicenceRestService drivingLicenceRestService 
			= new StatefulDrivingLicenceRestService();
		drivingLicenceRestService.init(false);
		
		//--------------- CASE 1 ----------------//
		// create applicant
		Applicant applicant = new Applicant();
		applicant.setIdentificationNumber("000001");
		applicant.setAge(27);
		
		// create applicant REST request
		RestCommand request = new RestCommand();
		request.setContext("applicants");
		request.setHttpCommandType(HttpCommandTypeEnum.PUT);
		request.setCommandScope(CommandScopeEnum.ITEM);
		request.setId(applicant.getIdentificationNumber());
		request.setContent(applicant);
		
		System.out.println("Request: " + request);
		
		// perform submission
		RestCommandResponse response 
			= drivingLicenceRestService.executeRestCommand(request);
		
		// present result
		System.out.println("Response: " + response);
		
		//--------------- CASE 2 ----------------//
		// read applicant REST request
		request = new RestCommand();
		request.setContext("applicants");
		request.setHttpCommandType(HttpCommandTypeEnum.GET);
		request.setCommandScope(CommandScopeEnum.ITEM);
		request.setId("000001");
		request.setContent(null);
		
		System.out.println("Request: " + request);
		
		// perform submission
		response 
			= drivingLicenceRestService.executeRestCommand(request);
		
		// present result
		System.out.println("Response: " + response);
		
		//--------------- CASE 3 ----------------//
		// read applicant REST request
		request = new RestCommand();
		request.setContext("applicants");
		request.setHttpCommandType(HttpCommandTypeEnum.GET);
		request.setCommandScope(CommandScopeEnum.ITEM);
		request.setId("000002");
		request.setContent(null);
		
		System.out.println("Request: " + request);
		
		// perform submission
		response 
			= drivingLicenceRestService.executeRestCommand(request);
		
		// present result
		System.out.println("Response: " + response);
		
		//--------------- CASE 4 ----------------//
		// read applicant REST request
		request = new RestCommand();
		request.setContext("applicants");
		request.setHttpCommandType(HttpCommandTypeEnum.DELETE);
		request.setCommandScope(CommandScopeEnum.ITEM);
		request.setId("000002");
		request.setContent(null);
		
		System.out.println("Request: " + request);
		
		// perform submission
		response 
			= drivingLicenceRestService.executeRestCommand(request);
		
		// present result
		System.out.println("Response: " + response);
		
		//--------------- CASE 5 ----------------//
		// read applicant REST request
		request = new RestCommand();
		request.setContext("applicants");
		request.setHttpCommandType(HttpCommandTypeEnum.GET);
		request.setCommandScope(CommandScopeEnum.ITEM);
		request.setId("000001");
		request.setContent(null);
		
		System.out.println("Request: " + request);
		
		// perform submission
		response 
			= drivingLicenceRestService.executeRestCommand(request);
		
		// present result
		System.out.println("Response: " + response);
		
		//--------------- CASE 6 ----------------//
		// read applicant REST request
		request = new RestCommand();
		request.setContext("applicants");
		request.setHttpCommandType(HttpCommandTypeEnum.DELETE);
		request.setCommandScope(CommandScopeEnum.ITEM);
		request.setId("000001");
		request.setContent(null);
		
		System.out.println("Request: " + request);
		
		// perform submission
		response 
			= drivingLicenceRestService.executeRestCommand(request);
		
		// present result
		System.out.println("Response: " + response);

		//--------------- CASE 7 ----------------//
		// read applicant REST request
		request = new RestCommand();
		request.setContext("applicants");
		request.setHttpCommandType(HttpCommandTypeEnum.GET);
		request.setCommandScope(CommandScopeEnum.ITEM);
		request.setId("000001");
		request.setContent(null);
		
		System.out.println("Request: " + request);
		
		// perform submission
		response 
			= drivingLicenceRestService.executeRestCommand(request);
		
		// present result
		System.out.println("Response: " + response);
		
		//--------------- CASE 8 ----------------//
		// read applicant REST request
		request = new RestCommand();
		request.setContext("applicants");
		request.setHttpCommandType(HttpCommandTypeEnum.POST);
		request.setCommandScope(CommandScopeEnum.ITEM);
		request.setId("000001");
		request.setContent(null);
		
		System.out.println("Request: " + request);
		
		// perform submission
		response 
			= drivingLicenceRestService.executeRestCommand(request);
		
		// present result
		System.out.println("Response: " + response);

	}
	
	public void init(boolean debug) {
		
		// load rules definition
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		
		// rule definitions
		kbuilder.add( 
				ResourceFactory.newClassPathResource( 
						"applicant.drl", StatefulDrivingLicenceRestService.class ), 
				ResourceType.DRL );
		kbuilder.add( 
				ResourceFactory.newClassPathResource( 
						"application.drl", StatefulDrivingLicenceRestService.class ), 
				ResourceType.DRL );
		kbuilder.add( 
				ResourceFactory.newClassPathResource( 
						"drivingLicense.drl", StatefulDrivingLicenceRestService.class ), 
				ResourceType.DRL );
		kbuilder.add( 
				ResourceFactory.newClassPathResource( 
						"rest/applicant-rest-api.drl", StatefulDrivingLicenceRestService.class ), 
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
		ksession = kbase.newStatefulKnowledgeSession();
		
		// add debug options
		if (debug) {
			ksession.addEventListener( new DebugAgendaEventListener() );
			ksession.addEventListener( new DebugWorkingMemoryEventListener() );
		}
		
		ksession.insert(new ApplicantStore());
		ksession.insert(new ApplicationStore());
		ksession.insert(new DrivingLincenceStore());
		
	}
	
	/**
	 * Perform REST command
	 * 
	 * @param request
	 * @return response
	 */
	public RestCommandResponse executeRestCommand( RestCommand request ) {
		
		RestCommandResponse response = new RestCommandResponse();
		
		ksession.insert(response);
		ksession.insert(request);
		
		ksession.fireAllRules();
		
		return response;
		
	}
}

