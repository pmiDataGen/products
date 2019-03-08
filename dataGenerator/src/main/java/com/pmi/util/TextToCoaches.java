package com.pmi.util;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.pmi.pojo.Coaches;

/**
 * @author vikas.e.mishra
 * 
 *         Custom Converter for collection based fields, This class will be used
 *         by openCSV library to read list of COACHES from a CSV file and map it
 *         to IDENTITY object; One to Many relationship between IDENTITY and
 *         COACHES
 *
 */
public class TextToCoaches extends AbstractCsvConverter {

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		// SAMPLE value -> coach_id=965, coach_name=what

		Coaches coaches = new Coaches();
		String[] strArray = value.split("\\,");

		for (String str : strArray) {
			String textValue = str.substring(str.indexOf("=") + 1);
			if (str.contains("coach_id=")) {
				coaches.setCoach_id(textValue);
			} else if (str.contains("coach_name=")) {
				coaches.setCoach_name(textValue);
			}
		}
		return coaches;
	}

}
