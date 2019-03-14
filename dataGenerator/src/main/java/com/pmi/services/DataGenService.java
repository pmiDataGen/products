package com.pmi.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.pmi.pojo.Cases;
import com.pmi.pojo.Coaches;
import com.pmi.pojo.Device;
import com.pmi.pojo.Identities;
import com.pmi.pojo.Interaction;
import com.pmi.pojo.OrderItems;
import com.pmi.pojo.Orders;
import com.pmi.pojo.Persona;
import com.pmi.pojo.Questions;
import com.pmi.pojo.Segments;
import com.pmi.pojo.Surveys;
import com.pmi.pojo.TermsAndConditions;
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
		List dataList = null;
		if (objName.equalsIgnoreCase("personas")) {
			dataList = createPersonaObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue());
		} else if (objName.equalsIgnoreCase("identities")) {
			dataList = createIdentitiesObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue());
		} else if (objName.equalsIgnoreCase("orders")) {
			dataList = createOrdersObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange);
		} else if (objName.equalsIgnoreCase("cases")) {
			dataList = createCasesObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange);
		} else if (objName.equalsIgnoreCase("devices")) {
			dataList = createDeviceObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange);
		} else if (objName.equalsIgnoreCase("segments")) {
			dataList = createSegmentsObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange);
		} else if (objName.equalsIgnoreCase("interaction")) {
			dataList = createInteractionObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange);
		} else if (objName.equalsIgnoreCase("vouchers")) {
			dataList = createVouchersObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange);
		} else if (objName.equalsIgnoreCase("ageVerification")) {
			dataList = createAgeVerificationObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange);
		} else if (objName.equalsIgnoreCase("surveys")) {
			dataList = createSurveysObject(operationType, primaryKeyStart.intValue(), primaryKeyEnd.intValue(),
					startRange, endRange);
		}
		// Write the generated data to CSV file
		String filePath = null;
		if (outputFileName.equalsIgnoreCase("NotAvailable")) {
			filePath = String.format(WRITE_API_BULK_REQUEST_CSV_FILE_PATH, objName);// default out file
		} else {
			if (outputFileName.indexOf(".csv") == -1) {
				outputFileName = outputFileName + ".csv";
			}
			filePath = WRITE_API_BULK_REQUEST_FILE_PATH + outputFileName;
		}
		readWriteCSV.writeToCsv(dataList, filePath);
		logger.info("Generated Data written into CSV file at Location : " + filePath);
		// return dataList;
		return "SUCCESS: Data is generated and written into CSV file at Location : " + filePath;
	}

	public List<Cases> createCasesObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Cases> casesObjectList = new ArrayList<Cases>();

		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Cases cases = new Cases();
			cases.setTd_c360_operation(operationType);

			cases.setCase_id(String.valueOf(i));// primary Key
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			cases.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			cases.setPersona_identifier(personaAndIdentityID);// should be between range
			// cases.setIdentity_unique_identifier(dataFactory.getNumberText(3));
			// cases.setPersona_identifier(dataFactory.getNumberText(3));
			cases.setSerial_numer(dataFactory.getNumberText(2));
			cases.setClosing_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			cases.setCreate_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			cases.setStatus(dataFactory.getRandomWord());
			cases.setSubject_code(dataFactory.getNumberBetween(0, 999));
			cases.setSubject(dataFactory.getNumberBetween(0, 999));
			cases.setResolution(dataFactory.getRandomText(10));
			cases.setCase_description(dataFactory.getRandomText(10));
			cases.setCustomer_comment(dataFactory.getRandomWord());

			casesObjectList.add(cases);
		}

		return casesObjectList;

	}

	public List<Orders> createOrdersObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;
		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Orders> ordersObjectList = new ArrayList<Orders>();

		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Orders orders = new Orders();
			orders.setTd_c360_operation(operationType);

			orders.setOrder_id(String.valueOf(i)); // Primary Key; change to "order_number"
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			orders.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			orders.setPersona_identifier(personaAndIdentityID);// should be between range
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
		}

		return ordersObjectList;

	}

	public List<Persona> createPersonaObject(String operationType, int primaryKeyStart, int primaryKeyEnd) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		// Set<Integer> randomUniqueNumberSet =
		// DataGenService.primaryKeyGenerator(numberOfObjects);
		// Iterator<Integer> iterator = randomUniqueNumberSet.iterator();
		List<Persona> personaObjectList = new ArrayList<Persona>();

		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Persona persona = new Persona();
			// persona.setOnline_access_flag(false);
			// persona.setPersona_id(String.valueOf(iterator.next()));// Unique Primary Key
			persona.setPersona_id(String.valueOf(i));// Unique Primary Key
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
		}

		return personaObjectList;

	}

	public List<Identities> createIdentitiesObject(String operationType, int primaryKeyStart, int primaryKeyEnd) {

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		// Set<Integer> randomUniqueNumberSet =
		// DataGenService.primaryKeyGenerator(numberOfObjects);
		// Iterator<Integer> iterator = randomUniqueNumberSet.iterator();
		List<Identities> identitiesObjectList = new ArrayList<Identities>();

		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {

			Identities identities = new Identities();
			identities.setTd_c360_operation(operationType);

			identities.setIdentity_id(String.valueOf(i));// later change to "identity_unique_identifier";
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

			List<Coaches> coachesList = new ArrayList<Coaches>();
			for (int k = 1; k <= 2; k++) {
				Coaches coaches = new Coaches();
				coaches.setCoach_id(dataFactory.getNumberText(3));
				coaches.setCoach_name(dataFactory.getRandomWord());
				coachesList.add(coaches);
			}
			identities.setCoaches(coachesList);

			List<TermsAndConditions> termsAndConditionsList = new ArrayList<TermsAndConditions>();
			TermsAndConditions termsAndConditions = new TermsAndConditions();
			termsAndConditions.setTerms_and_conditions_acceptance(dataFactory.getRandomText(10, 40));
			termsAndConditions.setTerms_and_conditions_version(dataFactory.getNumberText(2));
			termsAndConditionsList.add(termsAndConditions);
			identities.setTermsAndConditions(termsAndConditionsList);

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
		}

		return identitiesObjectList;

	}

	public List<Device> createDeviceObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;
		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Device> DeviceObjectList = new ArrayList<Device>();

		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Device device = new Device();
			device.setTd_c360_operation(operationType);

			device.setDevice_serial_number(String.valueOf(i)); // primary key - change to "device_codentify"
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			device.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			device.setPersona_identifier(personaAndIdentityID);// should be between range
			// device.setIdentity_unique_identifier(dataFactory.getNumberText(3));
			// device.setPersona_identifier(dataFactory.getNumberText(3));
			device.setBarcode(dataFactory.getRandomText(6));
			device.setDevice_type(dataFactory.getRandomText(8));
			device.setDevice_version(dataFactory.getRandomWord());
			device.setDevice_description(dataFactory.getRandomWord(10));
			device.setPurchase_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setRegistration_device_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setStatus(dataFactory.getRandomWord());
			device.setStatus_date_change(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setWarranty_starting_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setWarranty_end_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setReplacement_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setUrl_picture_link(dataFactory.getRandomWord(8));
			device.setCleaning_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			device.setCleaning_coach(dataFactory.getRandomChars(5));

			DeviceObjectList.add(device);
		}

		return DeviceObjectList;

	}

	public List<Segments> createSegmentsObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Segments> SegmentsObjectList = new ArrayList<Segments>();

		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Segments segments = new Segments();
			segments.setTd_c360_operation(operationType);

			segments.setSegment_id(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			segments.setPersona_identifier(personaAndIdentityID);// should be between range
			segments.setSegment(dataFactory.getRandomChars(5));

			SegmentsObjectList.add(segments);
		}

		return SegmentsObjectList;

	}

	public List<Interaction> createInteractionObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Interaction> InteractionObjectList = new ArrayList<Interaction>();

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
			interaction.setTrial_platform(dataFactory.getRandomChars(5));
			interaction.setTrial_purpose(dataFactory.getRandomChars(5));
			interaction.setTrial_type(dataFactory.getRandomChars(5));

			InteractionObjectList.add(interaction);
		}

		return InteractionObjectList;

	}

	public List<Vouchers> createVouchersObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Vouchers> VouchersObjectList = new ArrayList<Vouchers>();

		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			Vouchers vouchers = new Vouchers();
			vouchers.setTd_c360_operation(operationType);

			vouchers.setVoucher_code(String.valueOf(i));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			vouchers.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			vouchers.setPersona_identifier(personaAndIdentityID);// should be between range
			vouchers.setType(dataFactory.getRandomChars(5));
			vouchers.setName(dataFactory.getName());
			vouchers.setCountry_of_issuing(dataFactory.getCity());
			vouchers.setValid_from(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			vouchers.setValid_to(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			vouchers.setValue(dataFactory.getNumberUpTo(2));
			vouchers.setCorresponding_voucher_code(dataFactory.getNumberText(3));
			vouchers.setStatus(dataFactory.getRandomChars(5));

			VouchersObjectList.add(vouchers);
		}

		return VouchersObjectList;

	}

	public List<AgeVerification> createAgeVerificationObject(String operationType, int primaryKeyStart,
			int primaryKeyEnd, String startRange, String endRange) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<AgeVerification> AgeVerificationObjectList = new ArrayList<AgeVerification>();

		for (int i = primaryKeyStart; i <= primaryKeyEnd; i++) {
			AgeVerification ageVerification = new AgeVerification();
			ageVerification.setTd_c360_operation(operationType);

			ageVerification.setAgeverification_id(String.valueOf(i));
			ageVerification.setF2f_employee_id(dataFactory.getNumberText(3));
			String personaAndIdentityID = String.valueOf(dataFactory.getNumberBetween(startRangeInt, endRangeInt));
			ageVerification.setIdentity_unique_identifier(personaAndIdentityID);// should be between range
			ageVerification.setPersona_identifier(personaAndIdentityID);// should be between range
			ageVerification.setStatus(dataFactory.getRandomChars(5));
			ageVerification.setType(dataFactory.getRandomChars(5));
			ageVerification.setCountry(dataFactory.getCity());
			ageVerification.setRegion(dataFactory.getCity());
			ageVerification.setRequest_channel(dataFactory.getRandomChars(5));
			ageVerification.setRequest_country(dataFactory.getCity());
			ageVerification.setRequest_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			ageVerification.setRequest_region(dataFactory.getCity());
			ageVerification.setRequest_status(dataFactory.getRandomChars(5));
			ageVerification.setRequest_status_change_date(
					dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			ageVerification.setDocument_type(dataFactory.getRandomChars(5));
			ageVerification.setDocument_number(dataFactory.getNumberText(3));
			ageVerification.setDocument_image_link(dataFactory.getRandomChars(5));
			ageVerification
					.setDocument_expiration_date(dataFactory.getDateBetween(c.getTime(), new Date()).getTime() / 1000l);
			ageVerification.setDocument_country(dataFactory.getCity());

			AgeVerificationObjectList.add(ageVerification);
		}

		return AgeVerificationObjectList;

	}

	public List<Surveys> createSurveysObject(String operationType, int primaryKeyStart, int primaryKeyEnd,
			String startRange, String endRange) {

		int startRangeInt = Integer.parseInt(startRange) + 1;
		int endRangeInt = Integer.parseInt(endRange) + 1;

		// To create random Dates
		Calendar c = Calendar.getInstance();
		c.set(2000, Calendar.JANUARY, 1);
		c.getTime();

		List<Surveys> surveysObjectList = new ArrayList<Surveys>();

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
		}

		return surveysObjectList;

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
