package com.pmi.util;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.pmi.pojo.TermsAndConditions;

/**
 * @author vikas.e.mishra
 * 
 *         Custom Converter for collection based fields, This class will be used
 *         by openCSV library to read list of TERMS&CONDITIONS from a CSV file
 *         and map it to IDENTITY object; One to Many relationship between
 *         IDENTITY and TERMSANDCONDITIONS
 *
 */
public class TextToTermsAndConditions extends AbstractCsvConverter {

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		// SAMPLE value -> terms_and_conditions_version=02,
		// terms_and_conditions_acceptance=automatically

		TermsAndConditions termsAndConditions = new TermsAndConditions();
		String[] strArray = value.split("\\,");

		for (String str : strArray) {
			String textValue = str.substring(str.indexOf("=") + 1);
			if (str.contains("terms_and_conditions_version=")) {
				termsAndConditions.setTerms_and_conditions_version(textValue);
			} else if (str.contains("terms_and_conditions_acceptance=")) {
				termsAndConditions.setTerms_and_conditions_acceptance(textValue);
			}
		}
		return termsAndConditions;
	}

}
