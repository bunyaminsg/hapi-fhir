package ca.uhn.fhir.rest.gclient;

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

import java.util.Date;

import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.primitive.DateTimeDt;

/**
 * Date parameter type for use in fluent client interfaces
 */
public class DateParam implements IParam {

	private String myParamName;

	@Override
	public String getParamName() {
		return myParamName;
	}

	public DateParam(String theParamName) {
		myParamName = theParamName;
	}

	public IDateSpecifier after() {
		return new DateWithPrefix(">");
	}

	public IDateSpecifier afterOrEquals() {
		return new DateWithPrefix(">=");
	}

	public IDateSpecifier before() {
		return new DateWithPrefix("<=");
	}

	public IDateSpecifier beforeOrEquals() {
		return new DateWithPrefix("<=");
	}

	public IDateSpecifier exactly() {
		return new DateWithPrefix("");
	}

	private class Criterion implements ICriterion, ICriterionInternal {

		private String myValue;

		public Criterion(String theValue) {
			myValue = theValue;
		}

		@Override
		public String getParameterName() {
			return myParamName;
		}

		@Override
		public String getParameterValue() {
			return myValue;
		}

	}

	private class DateWithPrefix implements IDateSpecifier {
		private String myPrefix;

		public DateWithPrefix(String thePrefix) {
			myPrefix = thePrefix;
		}

		@Override
		public ICriterion day(Date theValue) {
			DateTimeDt dt = new DateTimeDt(theValue);
			dt.setPrecision(TemporalPrecisionEnum.DAY);
			return new Criterion(myPrefix + dt.getValueAsString());
		}

		@Override
		public ICriterion day(String theValue) {
			DateTimeDt dt = new DateTimeDt(theValue);
			dt.setPrecision(TemporalPrecisionEnum.DAY);
			return new Criterion(myPrefix + dt.getValueAsString());
		}

		@Override
		public ICriterion now() {
			DateTimeDt dt = new DateTimeDt();
			dt.setPrecision(TemporalPrecisionEnum.DAY);
			return new Criterion(myPrefix + dt.getValueAsString());
		}

		@Override
		public ICriterion second(Date theValue) {
			DateTimeDt dt = new DateTimeDt(theValue);
			dt.setPrecision(TemporalPrecisionEnum.DAY);
			return new Criterion(myPrefix + dt.getValueAsString());
		}

		@Override
		public ICriterion second(String theValue) {
			DateTimeDt dt = new DateTimeDt(theValue);
			dt.setPrecision(TemporalPrecisionEnum.DAY);
			return new Criterion(myPrefix + dt.getValueAsString());
		}

	}

	public interface IDateSpecifier {

		ICriterion day(Date theValue);

		ICriterion day(String theValue);

		ICriterion now();

		ICriterion second(Date theValue);

		ICriterion second(String theValue);

	}

}
