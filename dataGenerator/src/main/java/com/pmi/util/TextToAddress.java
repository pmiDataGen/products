package com.pmi.util;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.pmi.pojo.Address;

/**
 * @author vikas.e.mishra
 * 
 *         Custom Converter for collection based fields, This class will be used
 *         by openCSV library to read list of ADDRESS from a CSV file and map it
 *         to IDENTITY object; One to Many relationship between IDENTITY and
 *         ADDRESS
 *
 */
public class TextToAddress extends AbstractCsvConverter {

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		// SAMPLE value -> country=India1, postal_code=6001, address_type=address Type1,
		// additional_address_line_1=Additional_address_line_1Additional_address_line_1,
		// additional_address_line_2=Additional_address_line_2Additional_address_line_1,
		// additional_address_line_3=Additional_address_line_2Additional_address_line_1,
		// additional_address_line_4=Additional_address_line_2Additional_address_line_1,
		// additional_address_line_5=Additional_address_line_2Additional_address_line_1,
		// preferred_shipping=true, preferred_billing=false,
		// communication_opt_in=communication_opt_in 1

		Address address = new Address();
		String[] strArray = value.split("\\,");

		for (String str : strArray) {
			String textValue = str.substring(str.indexOf("=") + 1);
			if (str.contains("country=")) {
				address.setCountry(textValue);
			} else if (str.contains("postal_code=")) {
				address.setPostal_code(textValue);
			} else if (str.contains("postal_code=")) {
				address.setPostal_code(textValue);
			} else if (str.contains("additional_address_line_1=")) {
				address.setAdditional_address_line_1(textValue);
			} else if (str.contains("additional_address_line_2=")) {
				address.setAdditional_address_line_2(textValue);
			} else if (str.contains("additional_address_line_3=")) {
				address.setAdditional_address_line_3(textValue);
			} else if (str.contains("additional_address_line_4=")) {
				address.setAdditional_address_line_4(textValue);
			} else if (str.contains("additional_address_line_5=")) {
				address.setAdditional_address_line_5(textValue);
			} else if (str.contains("address_type=")) {
				address.setAddress_type(textValue);
			} else if (str.contains("preferred_shipping=")) {
				address.setPreferred_shipping(Boolean.valueOf(textValue));
			} else if (str.contains("preferred_billing=")) {
				address.setPreferred_billing(Boolean.valueOf(textValue));
			} else if (str.contains("communication_opt_in=")) {
				address.setCommunication_opt_in(textValue);
			}
		}
		return address;
	}

}
