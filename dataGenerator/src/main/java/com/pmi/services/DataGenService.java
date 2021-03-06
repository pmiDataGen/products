package com.pmi.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pmi.pojo.Address;
import com.pmi.pojo.AgeVerification;
import com.pmi.pojo.Answers;
import com.pmi.pojo.CampaignEvents;
import com.pmi.pojo.Cases;
import com.pmi.pojo.Demographics;
import com.pmi.pojo.DerivedAttributes;
import com.pmi.pojo.Device;
import com.pmi.pojo.EventRegistrations;
import com.pmi.pojo.Identities;
import com.pmi.pojo.Interaction;
import com.pmi.pojo.OrderItems;
import com.pmi.pojo.Orders;
import com.pmi.pojo.Persona;
import com.pmi.pojo.Psychographics;
import com.pmi.pojo.Questions;
import com.pmi.pojo.Segmentations;
import com.pmi.pojo.Segments;
import com.pmi.pojo.Surveys;
import com.pmi.pojo.Terms;
import com.pmi.pojo.Vouchers;
import com.pmi.util.ReadWriteCSV;

/**
 * @author vikas.e.mishra
 *
 */
@Component
public class DataGenService {

	private static final Logger logger = LoggerFactory.getLogger(DataGenService.class);

	@Autowired
	private DataFactory dataFactory;

	@Autowired
	private ReadWriteCSV readWriteCSV;

	@Value("${WRITE_API_BULK_REQUEST_CSV_FILE_PATH}")
	private String WRITE_API_BULK_REQUEST_CSV_FILE_PATH;

	@Value("${WRITE_API_BULK_REQUEST_FILE_PATH}")
	private String WRITE_API_BULK_REQUEST_FILE_PATH;

	public void generateRandomData() {

		for (int i = 0; i < 10; i++) {
			Calendar c = Calendar.getInstance();
			c.set(2013, Calendar.JANUARY, 9);
			c.getTime();

//			System.out.println(dataFactory.getFirstName() + " " + dataFactory.getLastName());
//			System.out.println("getAddress :" + dataFactory.getAddress());
//			System.out.println("getAddressLine2 :" + dataFactory.getAddressLine2());
//			System.out.println("getBusinessName :" + dataFactory.getBusinessName());
//			System.out.println("getCity :" + dataFactory.getCity());
//			System.out.println("getEmailAddress :" + dataFactory.getEmailAddress());
//			System.out.println("getName :" + dataFactory.getName());
			System.out.println("getNumberBetween :" + dataFactory.getNumberBetween(1, 20));
//			System.out.println("getNumberText :" + dataFactory.getNumberText(20));
//			System.out.println("getRandomText :" + dataFactory.getRandomText(10));
//			System.out.println("getRandomWord :" + dataFactory.getRandomWord());
//			System.out.println("getStreetName :" + dataFactory.getStreetName());
//			System.out.println("getStreetSuffix :" + dataFactory.getStreetSuffix());
//			System.out.println("getBirthDate :" + dataFactory.getBirthDate());
//			System.out.println("getNameDataValues :" + dataFactory.getNameDataValues().toString());
//			System.out.println("getDateBetween: "
//					+ String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			System.out.println("===============================================");

		}
	}

	public Object generateRandomData(String objName, String operationType, String personaIdentityRange,
			Integer primaryKeyStart, Integer primaryKeyEnd, String outputFileName) {
		String[] rangeArr = personaIdentityRange.split("-");
		String startRange = rangeArr[0]; // default value:1
		String endRange = rangeArr[1];// default value:100
		logger.info("Number of records to generate : " + (primaryKeyEnd.intValue() - primaryKeyStart.intValue() + 1));
		List dataList = null;
		if (objName.equalsIgnoreCase("personas")) {
			dataList = createPersonaObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					outputFileName, objName);
		} else if (objName.equalsIgnoreCase("identities")) {
			dataList = createIdentitiesObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					outputFileName, objName);
		} else if (objName.equalsIgnoreCase("orders")) {
			dataList = createOrdersObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("cases")) {
			dataList = createCasesObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("devices")) {
			dataList = createDeviceObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("segments")) {
			dataList = createSegmentsObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("interactions")) {
			dataList = createInteractionObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("vouchers")) {
			dataList = createVouchersObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("ageverifications")) {
			dataList = createAgeVerificationObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("surveys")) {
			dataList = createSurveysObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("eventregistrations")) {
			dataList = createEventRegistrationsObject(operationType, primaryKeyStart.intValue(),
					primaryKeyEnd.intValue(), startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("demographics")) {
			dataList = createDemographicsObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("psychographics")) {
			dataList = createPsychographicsObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("campaignevents")) {
			dataList = createCampaignEventsObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("terms")) {
			dataList = createTermsObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("segmentations")) {
			dataList = createSegmentationsObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange, outputFileName, objName);
		} else if (objName.equalsIgnoreCase("derivedattributes")) {
			dataList = createDerivedAttributesObject(operationType, primaryKeyStart.intValue(),
					primaryKeyEnd.intValue(), startRange, endRange, outputFileName, objName);
		}

		// return dataList;
		return "SUCCESS: Data is generated and written into CSV file at Location : " + WRITE_API_BULK_REQUEST_FILE_PATH;
	}

	public String generateFiles(String outputFileName, String objName, List dataList, int count) {
		// Write the generated data to CSV file
		String filePath = null;
		if (outputFileName.equalsIgnoreCase("NotAvailable")) {
			filePath = String.format(WRITE_API_BULK_REQUEST_CSV_FILE_PATH, objName);// default out file
		} else {
			outputFileName = outputFileName + "_Part_" + count;
			if (outputFileName.indexOf(".csv") == -1) {
				outputFileName = outputFileName + ".csv";
			}
			filePath = WRITE_API_BULK_REQUEST_FILE_PATH + outputFileName;
		}
		readWriteCSV.writeToCsv(dataList, filePath);
		logger.info("Generated Data written into CSV file at Location : " + filePath);

		return filePath;
	}

	public List<Cases> createCasesObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Cases> casesObjectList = new ArrayList<Cases>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Cases cases = new Cases();
			cases.setTd_c360_operation(operationType);

			cases.setCase_number(String.valueOf(i));// primary Key
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			cases.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			cases.setClosing_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			cases.setCreate_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			cases.setUpdate_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			cases.setStatus_code(dataFactory.getNumberText(2));
			cases.setStatus_description(dataFactory.getRandomWord(8));
			cases.setSubject_code(dataFactory.getNumberText(2));
			cases.setSubject_description(dataFactory.getRandomWord(8));
			cases.setResolution(dataFactory.getNumberText(2));
			cases.setCase_description(dataFactory.getRandomWord(10));
			cases.setCase_consumable_complaint_reason(dataFactory.getRandomWord(6));
			cases.setCase_product_generation_code(dataFactory.getNumberText(2));
			cases.setCase_product_generation_description(dataFactory.getRandomWord(10));
			cases.setCase_subtype_code(dataFactory.getNumberText(2));
			cases.setCase_subtype_description(dataFactory.getRandomWord(10));
			cases.setCase_type_code(dataFactory.getNumberText(2));
			cases.setCase_type_description(dataFactory.getRandomWord(10));

			casesObjectList.add(cases);

			if (casesObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, casesObjectList, segmentNumber);
				segmentNumber++;
				casesObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || casesObjectList.size() < 100000) {
			logger.info("Writing Cases Objects to CSV");
			generateFiles(outputFileName, objName, casesObjectList, segmentNumber);
		}

		return casesObjectList;

	}

	public List<Orders> createOrdersObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;
		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Orders> ordersObjectList = new ArrayList<Orders>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Orders orders = new Orders();
			orders.setTd_c360_operation(operationType);

			orders.setOrder_number(String.valueOf(i)); // Primary Key;
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			orders.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			// orders.setPersona_identifier(personaAndIdentityID);// should be between range
			orders.setTotal_price(dataFactory.getNumberText(8));
			orders.setStatus(dataFactory.getRandomText(6));
			orders.setDate(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			orders.setLink_to_invoice_file(dataFactory.getRandomWord(8));
			// order_items
			List<OrderItems> orderItemsList = new ArrayList<OrderItems>();
			for (int j = 1; j <= 2; j++) {
				OrderItems orderItems = new OrderItems();
				orderItems.setItem_identifier(dataFactory.getRandomWord());
				orderItems.setProduct_variant(dataFactory.getRandomWord(8));
				orderItems.setItem_description(dataFactory.getRandomText(8, 12));
				orderItems.setItem_price(dataFactory.getNumberBetween(100, 1000));
				orderItems.setItem_quantity(dataFactory.getNumberBetween(100, 1000));
				orderItemsList.add(orderItems);
			}
			orders.setOrder_items(orderItemsList);

			ordersObjectList.add(orders);

			if (ordersObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, ordersObjectList, segmentNumber);
				segmentNumber++;
				ordersObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || ordersObjectList.size() < 100000) {
			logger.info("Writing Orders Objects to CSV");
			generateFiles(outputFileName, objName, ordersObjectList, segmentNumber);
		}

		return ordersObjectList;

	}

	public List<Persona> createPersonaObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String outputFileName, String objName) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		// Set<Integer> randomUniqueNumberSet =
		// DataGenService.primaryKeyGenerator(numberOfObjects);
		// Iterator<Integer> iterator = randomUniqueNumberSet.iterator();
		List<Persona> personaObjectList = new ArrayList<Persona>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Persona persona = new Persona();
			// persona.setOnline_access_flag(false);
			// persona.setPersona_id(String.valueOf(iterator.next()));// Unique Primary Key
			persona.setPersona_identifier(String.valueOf(i));// Unique Primary Key
			persona.setFirst_name(dataFactory.getFirstName());
			persona.setLast_name(dataFactory.getLastName());
			persona.setGender(dataFactory.getRandomWord(1, 1));
			persona.setHome_country(dataFactory.getCity());
			persona.setConsumer_type(dataFactory.getRandomWord());
			persona.setAge(dataFactory.getNumberBetween(18, 50));
			persona.setAge_group(dataFactory.getRandomWord());
			persona.setIs_deleted(String.valueOf(false));
			persona.setBlocked_flag(String.valueOf(true));
			persona.setDate_of_birth(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);

			persona.setTd_c360_operation(operationType);

			// persona.setFull_name(dataFactory.getName());
			// persona.setName(dataFactory.getBusinessName());
			// persona.setPhone(dataFactory.getNumberText(10));
			// persona.setEmail(dataFactory.getEmailAddress());
			// persona.setIs_deleted(false);
			// persona.setBlocked_flag(false);
//			persona.setDate_of_birth(
//					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
//			persona.setSegment(dataFactory.getRandomWord());
//			persona.setRegistration_date(dataFactory.getNumberUpTo(8));
//			persona.setFirst_login_date(
//					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
//			persona.setLast_update_date(
//					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
//			persona.setLast_login_date(
//					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
//			persona.setOnline_access_flag(false);
//			persona.setPrimary_log_in(dataFactory.getNumberText(3));
//			persona.setSystem_last_update(
//					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
//			persona.setLast_Activity_since_days(dataFactory.getNumberUpTo(100));
//			persona.setLast_Activity_since_months(dataFactory.getNumberUpTo(10));
//			persona.setRecency_score(dataFactory.getNumberBetween(100, 150));
//			persona.setFrequency_score(dataFactory.getNumberBetween(150, 151));
//			persona.setValue_score(dataFactory.getNumberUpTo(2));
//			persona.setLast_case_category_name(dataFactory.getRandomWord());
//			persona.setLast_case_start_date(
//					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
//			persona.setLast_case_status_code(dataFactory.getNumberText(3));
//			persona.setNb_cases_close(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_close_1m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_close_2m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_close_3m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_close_6m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_close_12m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_open(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_open_1m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_open_2m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_open_3m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_open_6m(dataFactory.getNumberUpTo(10));
//			persona.setNb_cases_open_12m(dataFactory.getNumberUpTo(10));
//			persona.setNb_active_chargers(dataFactory.getNumberUpTo(10));
//			persona.setLimited_edition(dataFactory.getNumberText(3));
//			persona.setNb_of_devices(dataFactory.getNumberUpTo(10));
//			persona.setNb_of_devices_replaced(dataFactory.getNumberUpTo(10));
//			persona.setNb_of_holders(dataFactory.getNumberUpTo(10));
//			persona.setLatest_version_of_device(dataFactory.getNumberText(3));
//			persona.setNumber_of_heet(dataFactory.getNumberUpTo(10));
//			persona.setLifetime_revenue(dataFactory.getNumberUpTo(10));
//			persona.setFirst_purchase_date(dataFactory.getNumberUpTo(8));
//			persona.setLast_order_date(dataFactory.getNumberUpTo(10));
//			persona.setNumber_of_accessories(dataFactory.getNumberUpTo(10));
//			persona.setNb_order(dataFactory.getNumberUpTo(10));
//			persona.setNb_order_average_per_month(dataFactory.getNumberUpTo(10));
//			persona.setRegistration_first_order_difference_day(dataFactory.getNumberUpTo(100));
//			persona.setSecond_order_difference_days(dataFactory.getNumberUpTo(100));
//			persona.setTotal_spending_per_month_in_average(dataFactory.getNumberUpTo(10));
//			persona.setCnt_orders(dataFactory.getNumberUpTo(10));
//			persona.setCnt_orders_l12m(dataFactory.getNumberUpTo(10));
//			persona.setCnt_orders_l3m(dataFactory.getNumberUpTo(10));
//			persona.setCnt_orders_l6m(dataFactory.getNumberUpTo(10));
//			persona.setRevenue_ytd(dataFactory.getNumberUpTo(10));
//			persona.setRevenue_l3m(dataFactory.getNumberUpTo(10));
//			persona.setRevenue_l6m(dataFactory.getNumberUpTo(10));
//			persona.setRevenue_l12m(dataFactory.getNumberUpTo(10));

			personaObjectList.add(persona);
			if (personaObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, personaObjectList, segmentNumber);
				segmentNumber++;
				personaObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || personaObjectList.size() < 100000) {
			logger.info("Writing Persona Objects to CSV");
			generateFiles(outputFileName, objName, personaObjectList, segmentNumber);
		}

		return personaObjectList;

	}

	public List<Identities> createIdentitiesObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String outputFileName, String objName) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		// Set<Integer> randomUniqueNumberSet =
		// DataGenService.primaryKeyGenerator(numberOfObjects);
		// Iterator<Integer> iterator = randomUniqueNumberSet.iterator();
		List<Identities> identitiesObjectList = new LinkedList<Identities>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {

			Identities identities = new Identities();
			identities.setTd_c360_operation(operationType);

			identities.setIdentity_unique_identifier(String.valueOf(i));
			identities.setPersona_identifier(String.valueOf(i)); // same as Identity ID
			identities.setLogin_name(dataFactory.getBusinessName());
			identities.setLast_name(dataFactory.getLastName());
			identities.setFirst_name(dataFactory.getFirstName());
			identities.setGender(dataFactory.getRandomWord(1, 1));
			identities.setHome_country(dataFactory.getCity());
			identities.setIs_deleted(dataFactory.getRandomWord());
			identities.setReason_of_deletion(dataFactory.getRandomText(20));
			identities.setReason_of_customer_lost(dataFactory.getRandomText(20));
			identities.setBlocked_flag(dataFactory.getRandomChars(4));
			identities.setConsumer_type(dataFactory.getRandomWord());
			identities.setDate_of_birth(
					String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l));
			identities.setAge(dataFactory.getNumberBetween(10, 100));
			identities.setAge_group("10-100");
			identities.setEmail_address(dataFactory.getEmailAddress());
			identities.setEmail_comunication_opt_in(dataFactory.getRandomText(20));
			identities.setPhone_country_code_number(dataFactory.getNumberText(2));
			identities.setPhone_number(dataFactory.getNumberText(2));
			identities.setPhone_comunication_opt_in(dataFactory.getRandomText(20));
			identities.setPrivacy_policy_acceptance(dataFactory.getRandomText(20));
			identities.setLoyalty_tier(dataFactory.getRandomText(10));
			identities.setLoyalty_points(dataFactory.getNumberUpTo(1000));
			identities.setLoyalty_erned_points(dataFactory.getNumberBetween(100, 200));

			List<Address> addressList = new ArrayList<Address>();
			for (int j = 1; j <= 2; j++) {
				Address address = new Address();
				address.setAdditional_address_line_1(dataFactory.getAddress());
				address.setAdditional_address_line_2(dataFactory.getAddressLine2());
				address.setAdditional_address_line_3(dataFactory.getAddressLine2());
				address.setAdditional_address_line_4(dataFactory.getAddressLine2());
				address.setAdditional_address_line_5(dataFactory.getAddressLine2());
				address.setCountry(dataFactory.getCity());
				address.setPostal_code(dataFactory.getNumberText(6));
				address.setAddress_type(dataFactory.getRandomText(10));
				address.setPreferred_shipping(true);
				address.setPreferred_billing(false);
				address.setCommunication_opt_in(dataFactory.getRandomWord());
				addressList.add(address);
			}
			identities.setAddresses(addressList);

			/*
			 * List<Coaches> coachesList = new ArrayList<Coaches>(); for (int k = 1; k <= 2;
			 * k++) { Coaches coaches = new Coaches();
			 * coaches.setCoach_id(dataFactory.getNumberText(3));
			 * coaches.setCoach_name(dataFactory.getRandomWord()); coachesList.add(coaches);
			 * } identities.setCoaches(coachesList);
			 * 
			 * List<TermsAndConditions> termsAndConditionsList = new
			 * ArrayList<TermsAndConditions>(); TermsAndConditions termsAndConditions = new
			 * TermsAndConditions();
			 * termsAndConditions.setTerms_and_conditions_acceptance(dataFactory.
			 * getRandomText(10, 40));
			 * termsAndConditions.setTerms_and_conditions_version(dataFactory.getNumberText(
			 * 2)); termsAndConditionsList.add(termsAndConditions);
			 * identities.setTermsAndConditions(termsAndConditionsList);
			 */

			/*
			 * identities.setIdentity_id(String.valueOf(i));// Unique Primary Key
			 * identities.setPersona_id(dataFactory.getNumberText(3));
			 * identities.setLast_name(dataFactory.getLastName());
			 * identities.setFirst_name(dataFactory.getFirstName());
			 * identities.setLogin_name(dataFactory.getBusinessName());
			 * identities.setFull_name(dataFactory.getName());
			 * identities.setNick_name(dataFactory.getName()); identities.setDate_of_birth(
			 * String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime()
			 * / 1000l)); identities.setPhone_number(dataFactory.getNumberText(10));
			 * identities.setEmail(dataFactory.getEmailAddress());
			 * identities.setGender(dataFactory.getRandomWord(1, 1));
			 * identities.setHome_country(dataFactory.getCity());
			 * identities.setBlocked_flag(false); identities.setIs_deleted(false);
			 * identities.setRegistration_date(
			 * String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime()
			 * / 1000l)); identities.setRegistration_source_app("Test66");
			 * identities.setRegistration_country(dataFactory.getCity());
			 * identities.setRegistration_referal_identifier(dataFactory.getNumberText(3));
			 * identities.setConsumer_type(dataFactory.getRandomWord());
			 * identities.setPreferred_language(dataFactory.getCity());
			 * identities.setSegment(dataFactory.getRandomWord());
			 * identities.setLast_login_date(
			 * String.valueOf(dataFactory.getDateBetween(c.getTime(), new Date()).getTime()
			 * / 1000l));
			 */

			identitiesObjectList.add(identities);

			if (identitiesObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, identitiesObjectList, segmentNumber);
				segmentNumber++;
				identitiesObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || identitiesObjectList.size() < 100000) {
			logger.info("Writing Identities Objects to CSV");
			generateFiles(outputFileName, objName, identitiesObjectList, segmentNumber);
		}
		return identitiesObjectList;

	}

	public List<Device> createDeviceObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;
		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Device> deviceObjectList = new ArrayList<Device>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Device device = new Device();
			device.setTd_c360_operation(operationType);

			device.setDevice_codentify(String.valueOf(i)); // primary key
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			device.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			device.setSerial_number(dataFactory.getNumberText(3));
			device.setDevice_type_code(dataFactory.getNumberText(2));
			device.setDevice_type_description(dataFactory.getRandomWord(8));
			device.setDevice_version_code(dataFactory.getNumberText(2));
			device.setDevice_version_description(dataFactory.getRandomWord(8));
			device.setPurchase_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setRegistration_device_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setStatus_code(dataFactory.getNumberText(2));
			device.setStatus_descritpion(dataFactory.getRandomWord(8));
			device.setStatus_date_change(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setWarranty_starting_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setWarranty_end_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setReplacement_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setAccidental_damage_coverage(dataFactory.getRandomWord(8));
			device.setAccidental_damage_coverage_status_code(dataFactory.getNumberText(2));
			device.setAccidental_damage_coverage_status_description(dataFactory.getRandomWord(8));

			deviceObjectList.add(device);

			if (deviceObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, deviceObjectList, segmentNumber);
				segmentNumber++;
				deviceObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || deviceObjectList.size() < 100000) {
			logger.info("Writing Devices Objects to CSV");
			generateFiles(outputFileName, objName, deviceObjectList, segmentNumber);
		}

		return deviceObjectList;

	}

	public List<Segments> createSegmentsObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Segments> segmentsObjectList = new ArrayList<Segments>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Segments segments = new Segments();
			segments.setTd_c360_operation(operationType);

			segments.setSegment_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			segments.setPersona_identifier(personaAndIdentityID);// should be between range
			segments.setSegment(dataFactory.getRandomWord());

			segmentsObjectList.add(segments);

			if (segmentsObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, segmentsObjectList, segmentNumber);
				segmentNumber++;
				segmentsObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || segmentsObjectList.size() < 100000) {
			logger.info("Writing Segments Objects to CSV");
			generateFiles(outputFileName, objName, segmentsObjectList, segmentNumber);
		}

		return segmentsObjectList;

	}

	public List<Interaction> createInteractionObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Interaction> interactionObjectList = new ArrayList<Interaction>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Interaction interaction = new Interaction();
			interaction.setTd_c360_operation(operationType);

			interaction.setInteraction_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			interaction.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			interaction.setPersona_identifier(personaAndIdentityID);// should be between range
			interaction.setInteraction_type(dataFactory.getRandomChars(5));
			interaction.setTrial_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			interaction.setTrial_duration(dataFactory.getNumberUpTo(2));
			interaction.setTrial_platform(dataFactory.getRandomWord(5));
			interaction.setTrial_purpose(dataFactory.getRandomWord(8));
			interaction.setTrial_type(dataFactory.getRandomWord(6));

			interactionObjectList.add(interaction);

			if (interactionObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, interactionObjectList, segmentNumber);
				segmentNumber++;
				interactionObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || interactionObjectList.size() < 100000) {
			logger.info("Writing Interaction Objects to CSV");
			generateFiles(outputFileName, objName, interactionObjectList, segmentNumber);
		}

		return interactionObjectList;

	}

	public List<Vouchers> createVouchersObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Vouchers> vouchersObjectList = new ArrayList<Vouchers>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Vouchers vouchers = new Vouchers();
			vouchers.setTd_c360_operation(operationType);

			vouchers.setVoucher_code(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			vouchers.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			vouchers.setCountry_of_issuing_code(dataFactory.getRandomWord(3));
			vouchers.setCountry_of_issuing_description(dataFactory.getRandomWord(8));
			vouchers.setValid_from(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			vouchers.setValid_to(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			vouchers.setStatus_code(dataFactory.getNumberText(3));
			vouchers.setStatus_description(dataFactory.getRandomWord(8));
			vouchers.setPromotion_identifier(dataFactory.getRandomWord(5));
			vouchers.setPromotion_name(dataFactory.getRandomWord(6));
			vouchers.setVoucher_description(dataFactory.getRandomWord(8));

			vouchersObjectList.add(vouchers);

			if (vouchersObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, vouchersObjectList, segmentNumber);
				segmentNumber++;
				vouchersObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || vouchersObjectList.size() < 100000) {
			logger.info("Writing Vouchers Objects to CSV");
			generateFiles(outputFileName, objName, vouchersObjectList, segmentNumber);
		}

		return vouchersObjectList;

	}

	public List<AgeVerification> createAgeVerificationObject(String operationType, int primaryKeyStart,
			int primaryKeyEnd, String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<AgeVerification> ageVerificationObjectList = new ArrayList<AgeVerification>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			AgeVerification ageVerification = new AgeVerification();
			ageVerification.setTd_c360_operation(operationType);

			ageVerification.setAv_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			ageVerification.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			ageVerification.setStatus_code(dataFactory.getNumberText(3));
			ageVerification.setStatus_description(dataFactory.getRandomWord(6));
			ageVerification.setAv_type_code(dataFactory.getNumberText(3));
			ageVerification.setAv_type_description(dataFactory.getRandomWord(6));
			ageVerification.setAv_subtype_code(dataFactory.getNumberText(3));
			ageVerification.setAv_subtype_description(dataFactory.getRandomWord(6));
			ageVerification.setCountry_code(dataFactory.getNumberText(3));
			ageVerification.setCountry_description(dataFactory.getRandomWord(6));
			ageVerification.setState(dataFactory.getCity());

			ageVerificationObjectList.add(ageVerification);

			if (ageVerificationObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, ageVerificationObjectList, segmentNumber);
				segmentNumber++;
				ageVerificationObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || ageVerificationObjectList.size() < 100000) {
			logger.info("Writing AgeVerification Objects to CSV");
			generateFiles(outputFileName, objName, ageVerificationObjectList, segmentNumber);
		}

		return ageVerificationObjectList;

	}

	public List<Surveys> createSurveysObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Surveys> surveysObjectList = new ArrayList<Surveys>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Surveys surveys = new Surveys();
			surveys.setTd_c360_operation(operationType);

			surveys.setSurvey_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			surveys.setPersona_identifier(personaAndIdentityID);// should be between range
			surveys.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			surveys.setSurvey_template_id(dataFactory.getRandomText(6));
			surveys.setDate(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);

			List<Questions> questionsList = new ArrayList<Questions>();
			for (int j = 1; j <= 2; j++) {
				Questions questions = new Questions();
				questions.setQuestion_asked("What is occupation " + j);
				questions.setQuestion_number(String.valueOf(j));

				List<Answers> answersList = new ArrayList<Answers>();
				for (int k = 1; k <= 1; k++) {
					Answers answers = new Answers();
					answers.setAnswer_number(String.valueOf(k));
					answers.setAnswer_label("mech " + dataFactory.getCity());
					answers.setAnswer_value("mechanical engineer " + dataFactory.getFirstName());
					answersList.add(answers);
				}
				questions.setAnswers(answersList);
				questionsList.add(questions);
			}
			surveys.setQuestions(questionsList);

			surveysObjectList.add(surveys);

			if (surveysObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, surveysObjectList, segmentNumber);
				segmentNumber++;
				surveysObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || surveysObjectList.size() < 100000) {
			logger.info("Writing Surveys Objects to CSV");
			generateFiles(outputFileName, objName, surveysObjectList, segmentNumber);
		}

		return surveysObjectList;

	}

	public List<EventRegistrations> createEventRegistrationsObject(String operationType, int primaryKeyStart,
			int primaryKeyEnd, String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;
		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<EventRegistrations> eventregistrationsObjectList = new ArrayList<EventRegistrations>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			EventRegistrations eventregistrations = new EventRegistrations();

			eventregistrations.setTd_c360_operation(operationType);

			eventregistrations.setEvent_registration_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			// eventregistrations.setPersona_identifier(personaAndIdentityID);// should be
			// between range
			eventregistrations.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			eventregistrations.setEvent_location(dataFactory.getCity());
			eventregistrations.setEvent_name(dataFactory.getName());
			eventregistrations
					.setEvent_start_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			eventregistrations.setEvent_status_code(dataFactory.getRandomWord(8));
			eventregistrations.setEvent_status_description(dataFactory.getRandomWord());
			eventregistrations
					.setPerson_registration_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			eventregistrations.setPerson_registration_attendance(true);

			eventregistrationsObjectList.add(eventregistrations);

			if (eventregistrationsObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, eventregistrationsObjectList, segmentNumber);
				segmentNumber++;
				eventregistrationsObjectList.clear(); // clear list to avoid OOM
			}

		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || eventregistrationsObjectList.size() < 100000) {
			logger.info("Writing EventRegistration Objects to CSV");
			generateFiles(outputFileName, objName, eventregistrationsObjectList, segmentNumber);
		}

		return eventregistrationsObjectList;

	}

	public List<Demographics> createDemographicsObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;
		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Demographics> demographicsObjectList = new ArrayList<Demographics>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Demographics demographics = new Demographics();
			demographics.setTd_c360_operation(operationType);

			demographics.setDemographic_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			// demographics.setPersona_identifier(personaAndIdentityID);// should be between
			// range
			demographics.setIdentity_unique_identifier(personaAndIdentityID);// should be between range

			demographicsObjectList.add(demographics);

			if (demographicsObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, demographicsObjectList, segmentNumber);
				segmentNumber++;
				demographicsObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || demographicsObjectList.size() < 100000) {
			logger.info("Writing Demographics Objects to CSV");
			generateFiles(outputFileName, objName, demographicsObjectList, segmentNumber);
		}

		return demographicsObjectList;

	}

	public List<Psychographics> createPsychographicsObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;
		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Psychographics> psychographicsObjectList = new ArrayList<Psychographics>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Psychographics psychographics = new Psychographics();
			psychographics.setTd_c360_operation(operationType);

			psychographics.setPyschographic_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			// psychographics.setPersona_identifier(personaAndIdentityID);// between range
			psychographics.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			psychographics.setDeclared_flag(true);

			psychographicsObjectList.add(psychographics);

			if (psychographicsObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, psychographicsObjectList, segmentNumber);
				segmentNumber++;
				psychographicsObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || psychographicsObjectList.size() < 100000) {
			logger.info("Writing Psychographics Objects to CSV");
			generateFiles(outputFileName, objName, psychographicsObjectList, segmentNumber);
		}

		return psychographicsObjectList;

	}

	public List<CampaignEvents> createCampaignEventsObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;
		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<CampaignEvents> campaigneventsObjectList = new ArrayList<CampaignEvents>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			CampaignEvents campaignevents = new CampaignEvents();
			campaignevents.setTd_c360_operation(operationType);

			campaignevents.setCampaign_event_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			// campaignevents.setPersona_identifier(personaAndIdentityID);// between range
			campaignevents.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			campaignevents.setCampaign_activity(dataFactory.getRandomWord(6));
			campaignevents
					.setCampaign_event_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			campaignevents.setCampaign_event_type_code(dataFactory.getRandomWord(1));
			campaignevents.setCampaign_event_type_description(dataFactory.getRandomWord(6));

			campaigneventsObjectList.add(campaignevents);

			if (campaigneventsObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, campaigneventsObjectList, segmentNumber);
				segmentNumber++;
				campaigneventsObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || campaigneventsObjectList.size() < 100000) {
			logger.info("Writing CampaignEvents Objects to CSV");
			generateFiles(outputFileName, objName, campaigneventsObjectList, segmentNumber);
		}

		return campaigneventsObjectList;

	}

	public List<DerivedAttributes> createDerivedAttributesObject(String operationType, int primaryKeyStart,
			int primaryKeyEnd, String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<DerivedAttributes> derivedattributesObjectList = new ArrayList<DerivedAttributes>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			DerivedAttributes derivedattributes = new DerivedAttributes();
			derivedattributes.setTd_c360_operation(operationType);

			derivedattributes.setDerived_attribute_record_id(String.valueOf(i));// primary Key
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			derivedattributes.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			derivedattributes
					.setDerived_attribute_time(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			derivedattributes.setDerived_attribute_category(dataFactory.getRandomWord(6));
			derivedattributes.setDerived_attribute_code(dataFactory.getRandomWord(6));
			derivedattributes.setDerived_attribute_value(dataFactory.getRandomWord(6));
			derivedattributes.setDerived_attribute_home_country_code(dataFactory.getCity());
			derivedattributes.setDerived_attribute_home_country_description(dataFactory.getCity());

			derivedattributesObjectList.add(derivedattributes);

			if (derivedattributesObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, derivedattributesObjectList, segmentNumber);
				segmentNumber++;
				derivedattributesObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || derivedattributesObjectList.size() < 100000) {
			logger.info("Writing DerivedAttributes Objects to CSV");
			generateFiles(outputFileName, objName, derivedattributesObjectList, segmentNumber);
		}

		return derivedattributesObjectList;

	}

	public List<Terms> createTermsObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Terms> termsObjectList = new ArrayList<Terms>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Terms terms = new Terms();
			terms.setTd_c360_operation(operationType);

			terms.setTerms_id(String.valueOf(i));// primary Key
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			terms.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			terms.setTerms_version(dataFactory.getRandomWord(6));
			terms.setTerms_acceptance(true);
			terms.setTerms_acceptance_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			terms.setTerms_code(dataFactory.getRandomWord(2));
			terms.setTerms_description(dataFactory.getRandomWord(6));
			terms.setTerms_type_code(dataFactory.getRandomWord(2));
			terms.setTerms_type_description(dataFactory.getRandomWord(6));
			terms.setCountry_code(dataFactory.getCity());
			terms.setCountry_description(dataFactory.getCity());

			termsObjectList.add(terms);

			if (termsObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, termsObjectList, segmentNumber);
				segmentNumber++;
				termsObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || termsObjectList.size() < 100000) {
			logger.info("Writing Terms Objects to CSV");
			generateFiles(outputFileName, objName, termsObjectList, segmentNumber);
		}

		return termsObjectList;

	}

	public List<Segmentations> createSegmentationsObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange, String outputFileName, String objName) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Segmentations> segmentationsObjectList = new ArrayList<Segmentations>();
		int segmentNumber = 1;
		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Segmentations segmentations = new Segmentations();
			segmentations.setTd_c360_operation(operationType);

			segmentations.setSegmentation_record_id(String.valueOf(i));// primary Key
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			segmentations.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			segmentations.setSegmentation_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			segmentations.setSegment_category_code(dataFactory.getRandomWord(2));
			segmentations.setSegment_category_description(dataFactory.getRandomWord(6));
			segmentations.setSegment_type_code(dataFactory.getRandomWord(2));
			segmentations.setSegment_type_description(dataFactory.getRandomWord(6));
			segmentations.setSegment_value_code(dataFactory.getRandomWord(2));
			segmentations.setSegment_value_description(dataFactory.getRandomWord(6));

			segmentationsObjectList.add(segmentations);
			if (segmentationsObjectList.size() >= 100000) {
				generateFiles(outputFileName, objName, segmentationsObjectList, segmentNumber);
				segmentNumber++;
				segmentationsObjectList.clear(); // clear list to avoid OOM
			}
		}
		// Write to CSV when data range is less than 100,000
		if (primaryKeyEnd < 100000 || segmentationsObjectList.size() < 100000) {
			logger.info("Writing Segmentations Objects to CSV");
			generateFiles(outputFileName, objName, segmentationsObjectList, segmentNumber);
		}
		return segmentationsObjectList;

	}

	/**
	 * Generate 2n random unique numbers, using TreeSet to make sure no duplicates
	 * and also to preserve the natural sorting order
	 * 
	 * @param n
	 * @return
	 */
	public static Set<Integer> primaryKeyGenerator(int n) { // method NOT used now
		Set<Integer> uniqueNumberSet = new TreeSet<Integer>();

		Random random = new Random();

		for (int i = 0; i <= 2 * n; i++) {
			int num = random.nextInt(Integer.MAX_VALUE);
			uniqueNumberSet.add(num);
		}

		return uniqueNumberSet;
	}
}
