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

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class Applicant {

	// FIELDS
	private String identificationNumber;
    private int age;
    
    // GETTER AND SETTERS
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
    // UTIL
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

