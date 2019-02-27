package com.pmi.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pmi.pojo.Cases;
import com.pmi.pojo.Device;
import com.pmi.pojo.Identities;
import com.pmi.pojo.Orders;
import com.pmi.pojo.Persona;
import com.pmi.util.ReadWriteCSV;

/**
 * @author vikas.e.mishra
 *
 */
@Component
public class DataGenService {

	@Autowired
	private DataFactory dataFactory;

	@Autowired
	private ReadWriteCSV readWriteCSV;

	@Value("${WRITE_API_BULK_REQUEST_CSV_FILE_PATH}")
	private String WRITE_API_BULK_REQUEST_CSV_FILE_PATH;

	public void generateRandomData() {

		for (int i = 0; i < 10; i++) {
			Calendar c = Calendar.getInstance();
			c.set(2013, Calendar.JANUARY, 9);
			c.getTime();

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

	public Object generateRandomData(String objName, String operationType, Integer numberOfObjects) {
		List dataList = null;
		if (objName.equalsIgnoreCase("personas")) {
			dataList = createPersonaObject(numberOfObjects.intValue(), operationType);
		} else if (objName.equalsIgnoreCase("identities")) {
			dataList = createIdentitiesObject(numberOfObjects.intValue(), operationType);
		} else if (objName.equalsIgnoreCase("orders")) {
			dataList = createOrdersObject(numberOfObjects.intValue(), operationType);
		} else if (objName.equalsIgnoreCase("cases")) {
			dataList = createCasesObject(numberOfObjects.intValue(), operationType);
		} else if (objName.equalsIgnoreCase("devices")) {
			dataList = createDeviceObject(numberOfObjects.intValue(), operationType);
		}
		// Write the generated data to CSV file
		readWriteCSV.writeToCsv(dataList, String.format(WRITE_API_BULK_REQUEST_CSV_FILE_PATH, objName));
		System.out.println("Generated Data written into CSV file at Location : "
				+ String.format(WRITE_API_BULK_REQUEST_CSV_FILE_PATH, objName));

		// return dataList;
		return "SUCCESS: Data is generated and written into CSV file at Location : "
				+ String.format(WRITE_API_BULK_REQUEST_CSV_FILE_PATH, objName);
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

	public List<Orders> createOrdersObject(int numberOfObjects, String operationType) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Orders> ordersObjectList = new ArrayList<Orders>();

		for (int i = 0; i < numberOfObjects; i++) {
			Orders orders = new Orders();
			orders.setCountry(dataFactory.getCity());
			orders.setHome_country(dataFactory.getCity());
			orders.setIdentity_id(dataFactory.getNumberText(3));
			orders.setItem_description(dataFactory.getRandomWord());
			orders.setItem_identifier(dataFactory.getNumberText(3));
			orders.setItem_price(dataFactory.getNumberUpTo(1000));
			orders.setItem_quantity(dataFactory.getNumberBetween(10, 100));
			orders.setOrder_amount(dataFactory.getNumberUpTo(500));
			orders.setOrder_currency(dataFactory.getNumberText(3));
			orders.setOrder_date(String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			orders.setOrder_discount(dataFactory.getNumberUpTo(50));
			orders.setOrder_id(dataFactory.getNumberText(3));
			orders.setOrder_item_identifier(dataFactory.getNumberText(3));
			orders.setOrder_items(dataFactory.getNumberText(3));
			orders.setOrder_status(dataFactory.getRandomWord());
			orders.setOrder_type(dataFactory.getRandomWord());
			orders.setPersona_id(dataFactory.getNumberText(3));
			orders.setProduct_variant(dataFactory.getRandomWord());
			orders.setStatus(dataFactory.getRandomWord());
			orders.setTd_c360_operation(operationType);

			ordersObjectList.add(orders);
		}

		return ordersObjectList;

	}

	public List<Persona> createPersonaObject(int numberOfObjects, String operationType) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Persona> personaObjectList = new ArrayList<Persona>();

		for (int i = 0; i < numberOfObjects; i++) {
			Persona persona = new Persona();
			persona.setOnline_access_flag(false);
			persona.setPersona_id(dataFactory.getNumberText(3));
			persona.setFirst_name(dataFactory.getFirstName());
			persona.setLast_name(dataFactory.getLastName());
			persona.setFull_name(dataFactory.getName());
			persona.setName(dataFactory.getBusinessName());
			persona.setPhone(dataFactory.getNumberText(10));
			persona.setEmail(dataFactory.getEmailAddress());
			persona.setGender(dataFactory.getRandomWord(1, 1));
			persona.setHome_country(dataFactory.getCity());
			persona.setIs_deleted(false);
			persona.setBlocked_flag(false);
			persona.setConsumer_type(dataFactory.getRandomWord());
			persona.setDate_of_birth(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			persona.setSegment(dataFactory.getRandomWord());
			persona.setRegistration_date(dataFactory.getNumberUpTo(8));
			persona.setFirst_login_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			persona.setLast_update_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			persona.setLast_login_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			persona.setOnline_access_flag(false);
			persona.setPrimary_log_in(dataFactory.getNumberText(3));
			persona.setSystem_last_update(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			persona.setLast_Activity_since_days(dataFactory.getNumberUpTo(100));
			persona.setLast_Activity_since_months(dataFactory.getNumberUpTo(10));
			persona.setAge(dataFactory.getNumberBetween(18, 50));
			persona.setAge_group(dataFactory.getRandomWord());
			persona.setRecency_score(dataFactory.getNumberBetween(100, 150));
			persona.setFrequency_score(dataFactory.getNumberBetween(150, 151));
			persona.setValue_score(dataFactory.getNumberUpTo(2));
			persona.setLast_case_category_name(dataFactory.getRandomWord());
			persona.setLast_case_start_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			persona.setLast_case_status_code(dataFactory.getNumberText(3));
			persona.setNb_cases_close(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_close_1m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_close_2m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_close_3m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_close_6m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_close_12m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_open(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_open_1m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_open_2m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_open_3m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_open_6m(dataFactory.getNumberUpTo(10));
			persona.setNb_cases_open_12m(dataFactory.getNumberUpTo(10));
			persona.setNb_active_chargers(dataFactory.getNumberUpTo(10));
			persona.setLimited_edition(dataFactory.getNumberText(3));
			persona.setNb_of_devices(dataFactory.getNumberUpTo(10));
			persona.setNb_of_devices_replaced(dataFactory.getNumberUpTo(10));
			persona.setNb_of_holders(dataFactory.getNumberUpTo(10));
			persona.setLatest_version_of_device(dataFactory.getNumberText(3));
			persona.setNumber_of_heet(dataFactory.getNumberUpTo(10));
			persona.setLifetime_revenue(dataFactory.getNumberUpTo(10));
			persona.setFirst_purchase_date(dataFactory.getNumberUpTo(8));
			persona.setLast_order_date(dataFactory.getNumberUpTo(10));
			persona.setNumber_of_accessories(dataFactory.getNumberUpTo(10));
			persona.setNb_order(dataFactory.getNumberUpTo(10));
			persona.setNb_order_average_per_month(dataFactory.getNumberUpTo(10));
			persona.setRegistration_first_order_difference_day(dataFactory.getNumberUpTo(100));
			persona.setSecond_order_difference_days(dataFactory.getNumberUpTo(100));
			persona.setTotal_spending_per_month_in_average(dataFactory.getNumberUpTo(10));
			persona.setCnt_orders(dataFactory.getNumberUpTo(10));
			persona.setCnt_orders_l12m(dataFactory.getNumberUpTo(10));
			persona.setCnt_orders_l3m(dataFactory.getNumberUpTo(10));
			persona.setCnt_orders_l6m(dataFactory.getNumberUpTo(10));
			persona.setRevenue_ytd(dataFactory.getNumberUpTo(10));
			persona.setRevenue_l3m(dataFactory.getNumberUpTo(10));
			persona.setRevenue_l6m(dataFactory.getNumberUpTo(10));
			persona.setRevenue_l12m(dataFactory.getNumberUpTo(10));
			persona.setTd_c360_operation(operationType);

			personaObjectList.add(persona);
		}

		return personaObjectList;

	}

	public List<Identities> createIdentitiesObject(int numberOfObjects, String operationType) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Identities> identitiesObjectList = new ArrayList<Identities>();

		for (int i = 0; i < numberOfObjects; i++) {
			Identities identities = new Identities();
			identities.setTd_c360_operation(operationType);
			identities.setIdentity_id(dataFactory.getNumberText(3));
			identities.setPersona_id(dataFactory.getNumberText(3));
			identities.setLast_name(dataFactory.getLastName());
			identities.setFirst_name(dataFactory.getFirstName());
			identities.setLogin_name(dataFactory.getBusinessName());
			identities.setFull_name(dataFactory.getName());
			identities.setNick_name(dataFactory.getName());
			identities.setDate_of_birth(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			identities.setAddress(dataFactory.getAddress());
			identities.setPhone_number(dataFactory.getNumberText(10));
			identities.setEmail(dataFactory.getEmailAddress());
			identities.setGender(dataFactory.getRandomWord(1, 1));
			identities.setHome_country(dataFactory.getCity());
			identities.setBlocked_flag(false);
			identities.setIs_deleted(false);
			identities.setRegistration_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			identities.setRegistration_source_app("Test66");
			identities.setRegistration_country(dataFactory.getCity());
			identities.setRegistration_referal_identifier(dataFactory.getNumberText(3));
			identities.setConsumer_type(dataFactory.getRandomWord());
			identities.setPreferred_language(dataFactory.getCity());
			identities.setSegment(dataFactory.getRandomWord());
			identities.setLast_login_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));

			identitiesObjectList.add(identities);
		}

		return identitiesObjectList;

	}

	public List<Device> createDeviceObject(int numberOfObjects, String operationType) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Device> DeviceObjectList = new ArrayList<Device>();

		for (int i = 0; i < numberOfObjects; i++) {
			Device device = new Device();
			device.setTd_c360_operation(operationType);
			device.setDevice_codentify(dataFactory.getNumberText(3));
			device.setIdentity_unique_identifier(dataFactory.getNumberText(3));
			device.setPersona_identifier(dataFactory.getNumberText(3));
			device.setDevice_type(dataFactory.getRandomWord());
			device.setDevice_version(dataFactory.getNumberText(3));
			device.setRegistration_device_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			device.setStatus(dataFactory.getRandomWord());
			device.setComponent_Code(dataFactory.getNumberText(3));
			device.setStatus_date_change(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			device.setEnd_of_warranty_date(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			device.setHome_country(dataFactory.getCity());
			device.setIdentity_id(dataFactory.getNumberText(3));
			device.setModel(dataFactory.getNumberText(3));
			device.setPersona_id(dataFactory.getNumberText(3));
			device.setDevice_serial_number(dataFactory.getNumberText(3));

			DeviceObjectList.add(device);
		}

		return DeviceObjectList;

	}
}
