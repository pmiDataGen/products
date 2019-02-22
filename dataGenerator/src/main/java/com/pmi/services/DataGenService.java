package com.pmi.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmi.pojo.Cases;
import com.pmi.pojo.Orders;

/**
 * @author vikas.e.mishra
 *
 */
@Component
public class DataGenService {

	@Autowired
	private DataFactory dataFactory;

	public void generateRandomData() {

		for (int i = 0; i < 10; i++) {
			Calendar c = Calendar.getInstance();
			c.set(2013, Calendar.JANUARY, 9);
			c.getTime();
//			Date d = dataFactory.getDateBetween(c.getTime(), new Date());
//			System.out.println(d.toString());
//			System.out.println(d.getTime());
//			System.out.println(d.getTime()/1000l);

			System.out.println(dataFactory.getFirstName() + " " + dataFactory.getLastName());
			System.out.println("getAddress :" + dataFactory.getAddress());
			System.out.println("getAddressLine2 :" + dataFactory.getAddressLine2());
			System.out.println("getBusinessName :" + dataFactory.getBusinessName());
			System.out.println("getCity :" + dataFactory.getCity());
			System.out.println("getEmailAddress :" + dataFactory.getEmailAddress());
			System.out.println("getName :" + dataFactory.getName());
			System.out.println("getNumberBetween :" + dataFactory.getNumberBetween(100, 110));
			System.out.println("getNumberText :" + dataFactory.getNumberText(20));
			System.out.println("getRandomText :" + dataFactory.getRandomText(10));
			System.out.println("getRandomWord :" + dataFactory.getRandomWord());
			System.out.println("getStreetName :" + dataFactory.getStreetName());
			System.out.println("getStreetSuffix :" + dataFactory.getStreetSuffix());
			System.out.println("getBirthDate :" + dataFactory.getBirthDate());
			System.out.println("getNameDataValues :" + dataFactory.getNameDataValues().toString());
			System.out.println("getDateBetween: "
					+ String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			System.out.println("===============================================");

		}
	}

	public List<Cases> createCasesObject(int numberOfObjects, String operationType) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Cases> casesObjectList = new ArrayList<Cases>();

		for (int i = 0; i < numberOfObjects; i++) {
			Cases cases = new Cases();
			cases.setTd_c360_operation(operationType);
			cases.setCase_Channel(dataFactory.getRandomText(10));
			cases.setCase_Subtype(dataFactory.getRandomText(10));
			cases.setCase_id(String.valueOf(dataFactory.getNumberBetween(0, 999)));
			cases.setCase_source(dataFactory.getRandomWord());
			cases.setCase_type(dataFactory.getRandomWord());
			cases.setClosing_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			cases.setCreate_date(String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			cases.setDescription(dataFactory.getRandomWord());
			cases.setHome_country(dataFactory.getCity());
			cases.setIdentity_id(dataFactory.getNumberText(3));
			cases.setLatest_update_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			cases.setOrder_id(dataFactory.getNumberText(3));
			cases.setPersona_id(dataFactory.getNumberText(3));
			cases.setSerial_numer(dataFactory.getNumberText(2));
			cases.setStatus(dataFactory.getRandomWord());
			cases.setSubject_code(dataFactory.getNumberBetween(0, 999));
			cases.setSubject_description(dataFactory.getRandomWord());

			casesObjectList.add(cases);
		}

		return casesObjectList;

	}
	
	public List<Orders> createDeviceObject(int numberOfObjects, String operationType) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Orders> ordersObjectList = new ArrayList<Orders>();

		for (int i = 0; i < numberOfObjects; i++) {
			Orders orders = new Orders();
//			orders.setCountry(dataFactory.getCity());	
//			orders.setHome_country(dataFactory.getCity());	
//			orders.setIdentity_id(dataFactory.getNumberText(3));	
//			orders.setItem_description(dataFactory.getRandomWord());	
//			orders.setItem_identifier(item_identifier);	
//			orders.setItem_price(item_price);	
//			orders.setItem_quantity(dataFactory.getNumberBetween(10, 100));	
//			orders.setOrder_amount(order_amount);	
//			orders.setOrder_currency(order_currency);	
//			orders.setOrder_date(String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));	
//			orders.setOrder_discount(order_discount);	
//			orders.setOrder_id(order_id);	
//			orders.setOrder_item_identifier(order_item_identifier);	
//			orders.setOrder_items(order_items);	
//			orders.setOrder_status(order_status);	
//			orders.setOrder_type(order_type);	
//			orders.setPersona_id(dataFactory.getNumberText(3));	
//			orders.setProduct_variant(product_variant);	
//			orders.setStatus(status);	
//			orders.setTd_c360_operation(operationType);

			ordersObjectList.add(orders);
		}

		return ordersObjectList;

	}
}
