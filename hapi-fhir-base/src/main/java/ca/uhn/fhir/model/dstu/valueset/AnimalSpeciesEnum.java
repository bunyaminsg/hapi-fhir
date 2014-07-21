
package ca.uhn.fhir.model.dstu.valueset;

/*
 * #%L
 * HAPI FHIR - Core Library
 * %%
 * Copyright (C) 2014 University Health Network
 * %%
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
 * #L%
 */

import java.util.HashMap;
import java.util.Map;

import ca.uhn.fhir.model.api.IValueSetEnumBinder;

public enum AnimalSpeciesEnum {

	/**
	 * Display: <b>Dog</b><br/>
	 * Code Value: <b>canislf</b>
	 *
	 * Canis lupus familiaris
	 */
	DOG("canislf", "http://hl7.org/fhir/animal-species"),
	
	/**
	 * Display: <b>Sheep</b><br/>
	 * Code Value: <b>ovisa</b>
	 *
	 * Ovis aries
	 */
	SHEEP("ovisa", "http://hl7.org/fhir/animal-species"),
	
	/**
	 * Display: <b>Domestic Canary</b><br/>
	 * Code Value: <b>serinuscd</b>
	 *
	 * Serinus canaria domestica
	 */
	DOMESTIC_CANARY("serinuscd", "http://hl7.org/fhir/animal-species"),
	
	;
	
	/**
	 * Identifier for this Value Set:
	 * http://hl7.org/fhir/vs/animal-species
	 */
	public static final String VALUESET_IDENTIFIER = "http://hl7.org/fhir/vs/animal-species";

	/**
	 * Name for this Value Set:
	 * AnimalSpecies
	 */
	public static final String VALUESET_NAME = "AnimalSpecies";

	private static Map<String, AnimalSpeciesEnum> CODE_TO_ENUM = new HashMap<String, AnimalSpeciesEnum>();
	private static Map<String, Map<String, AnimalSpeciesEnum>> SYSTEM_TO_CODE_TO_ENUM = new HashMap<String, Map<String, AnimalSpeciesEnum>>();
	
	private final String myCode;
	private final String mySystem;
	
	static {
		for (AnimalSpeciesEnum next : AnimalSpeciesEnum.values()) {
			CODE_TO_ENUM.put(next.getCode(), next);
			
			if (!SYSTEM_TO_CODE_TO_ENUM.containsKey(next.getSystem())) {
				SYSTEM_TO_CODE_TO_ENUM.put(next.getSystem(), new HashMap<String, AnimalSpeciesEnum>());
			}
			SYSTEM_TO_CODE_TO_ENUM.get(next.getSystem()).put(next.getCode(), next);			
		}
	}
	
	/**
	 * Returns the code associated with this enumerated value
	 */
	public String getCode() {
		return myCode;
	}
	
	/**
	 * Returns the code system associated with this enumerated value
	 */
	public String getSystem() {
		return mySystem;
	}
	
	/**
	 * Returns the enumerated value associated with this code
	 */
	public AnimalSpeciesEnum forCode(String theCode) {
		AnimalSpeciesEnum retVal = CODE_TO_ENUM.get(theCode);
		return retVal;
	}

	/**
	 * Converts codes to their respective enumerated values
	 */
	public static final IValueSetEnumBinder<AnimalSpeciesEnum> VALUESET_BINDER = new IValueSetEnumBinder<AnimalSpeciesEnum>() {
		@Override
		public String toCodeString(AnimalSpeciesEnum theEnum) {
			return theEnum.getCode();
		}

		@Override
		public String toSystemString(AnimalSpeciesEnum theEnum) {
			return theEnum.getSystem();
		}
		
		@Override
		public AnimalSpeciesEnum fromCodeString(String theCodeString) {
			return CODE_TO_ENUM.get(theCodeString);
		}
		
		@Override
		public AnimalSpeciesEnum fromCodeString(String theCodeString, String theSystemString) {
			Map<String, AnimalSpeciesEnum> map = SYSTEM_TO_CODE_TO_ENUM.get(theSystemString);
			if (map == null) {
				return null;
			}
			return map.get(theCodeString);
		}
		
	};
	
	/** 
	 * Constructor
	 */
	AnimalSpeciesEnum(String theCode, String theSystem) {
		myCode = theCode;
		mySystem = theSystem;
	}

	
}
