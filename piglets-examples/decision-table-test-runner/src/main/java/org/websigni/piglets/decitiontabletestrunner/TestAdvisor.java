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
 */

package org.websigni.piglets.decitiontabletestrunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.decisiontable.ExternalSpreadsheetCompiler;
import org.drools.io.ResourceFactory;
import org.drools.io.impl.ByteArrayResource;
import org.drools.runtime.StatefulKnowledgeSession;

public class TestAdvisor {

	final List<String> testCasesToRunList = new ArrayList<String>();
	StatefulKnowledgeSession ksession;
	
    public static void main(String[] args) {
        TestAdvisor launcher = new TestAdvisor();
        launcher.init();
    }

    public void init() {
    	
        // build knowledge base
        final KnowledgeBase kbase = this.buildKnowledgeBase();

        // build knowledge session
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
    	
        // initiale global variables
        ksession.setGlobal( "testCasesToRunList", testCasesToRunList );
    }
    
    public void submitResult(Object result) {
    	ksession.insert(result);
    }
    
    public void clearTestCaseList() {
    	testCasesToRunList.clear();
    }
    
    @SuppressWarnings("rawtypes")
	public List retrieveTestCaseList() {

    	return Collections.unmodifiableList(testCasesToRunList);
    }

     /**
     * Creates a new kbase containing the rules generated from the xls file and
     * the template.
     * @return
     * @throws IOException
     */
    private KnowledgeBase buildKnowledgeBase() {
        //first we compile the decision table into a whole lot of rules.
        final ExternalSpreadsheetCompiler converter = new ExternalSpreadsheetCompiler();

        //the data we are interested in starts at row 2, column 2 (e.g. B2)
        String drl = null;
        try {
            drl = converter.compile(getSpreadsheetStream(), getRulesStream(), 2, 2);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not read spreadsheet or rules stream." ,e);
        }

        //compile the drl
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(new ByteArrayResource(drl.getBytes()), ResourceType.DRL);

        //Uncomment to see the rules
        System.out.println(drl);
        
        //compilation errors?
        if (kbuilder.hasErrors()) {
            System.out.println("Error compiling resources:");
            Iterator<KnowledgeBuilderError> errors = kbuilder.getErrors().iterator();
            while (errors.hasNext()) {
                System.out.println("\t" + errors.next().getMessage());
            }
            throw new IllegalStateException("Error compiling resources");
        }

        //BUILD KBASE
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        return kbase;

    }

    private InputStream getSpreadsheetStream() throws IOException {
        return ResourceFactory.newClassPathResource("TestHierarchy.xls", getClass()).getInputStream();
    }

    private InputStream getRulesStream() throws IOException {
        return ResourceFactory.newClassPathResource("TestHierarchy.drt", getClass()).getInputStream();
    }

}
