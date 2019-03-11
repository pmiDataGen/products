package com.pmi.util;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.pmi.pojo.OrderItems;

/**
 * @author vikas.e.mishra
 * 
 *         Custom Converter for collection based fields, This class will be used
 *         by openCSV library to read list of ORDER_ITEMS from a CSV file and
 *         map it to ORDERS object; One to Many relationship between ORDERS and
 *         ORDER_ITEMS
 *
 */
public class TextToOrderItems extends AbstractCsvConverter {

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {

		// SAMPLE value -> item_identifier=discovered, product_variant=interest,
		// item_description=jnddmhmmnco, item_price=312.0, item_quantity=793 |
		// item_identifier=they, product_variant=computer, item_description=qdgqgqryysg,
		// item_price=860.0, item_quantity=844 |

		OrderItems orderItems = new OrderItems();
		String[] strArray = value.split("\\,");

		for (String str : strArray) {
			String textValue = str.substring(str.indexOf("=") + 1);
			if (str.contains("item_identifier=")) {
				orderItems.setItem_identifier(textValue);
			} else if (str.contains("product_variant=")) {
				orderItems.setProduct_variant(textValue);
			} else if (str.contains("item_description=")) {
				orderItems.setItem_description(textValue);
			} else if (str.contains("item_price=")) {
				orderItems.setItem_price(Float.parseFloat(textValue));
			} else if (str.contains("item_quantity=")) {
				orderItems.setItem_quantity(Integer.parseInt(textValue.trim()));
			}
		}
		return orderItems;
	}

}
