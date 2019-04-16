package com.pmi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.pmi.pojo.AgeVerification;
import com.pmi.pojo.CampaignEvents;
import com.pmi.pojo.Cases;
import com.pmi.pojo.Demographics;
import com.pmi.pojo.DerivedAttributes;
import com.pmi.pojo.Device;
import com.pmi.pojo.EventRegistrations;
import com.pmi.pojo.Identities;
import com.pmi.pojo.Interaction;
import com.pmi.pojo.Orders;
import com.pmi.pojo.Persona;
import com.pmi.pojo.Psychographics;
import com.pmi.pojo.Quote;
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

@Service
public class InvokeRestService {

	private static final Logger logger = LoggerFactory.getLogger(InvokeRestService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders httpHeaders;

	@Autowired
	private ReadWriteCSV readWriteCSV;

	@Value("${demoRestUri}")
	private String demoRestUri;

	@Value("${WRITE_API_BULK_REQUEST_FILE_PATH}")
	private String WRITE_API_BULK_REQUEST_FILE_PATH;

	@Value("${LOOKUP_API_REQUEST_FILE_PATH}")
	private String LOOKUP_API_REQUEST_FILE_PATH;

	@Value("${LOOKUP_API_REQUEST_CSV_FILE_PATH}")
	private String LOOKUP_API_REQUEST_CSV_FILE_PATH;

	@Value("${LOOKUP_API_RESPONSE_CSV_FILE_PATH}")
	private String LOOKUP_API_RESPONSE_CSV_FILE_PATH;

	@Value("${WRITE_API_REQUEST_CSV_FILE_PATH}")
	private String WRITE_API_REQUEST_CSV_FILE_PATH;

	@Value("${WRITE_API_RESPONSE_CSV_FILE_PATH}")
	private String WRITE_API_RESPONSE_CSV_FILE_PATH;

	@Value("${WRITE_API_BULK_REQUEST_CSV_FILE_PATH}")
	private String WRITE_API_BULK_REQUEST_CSV_FILE_PATH;

	@Value("${WRITE_API_BULK_RESPONSE_CSV_FILE_PATH}")
	private String WRITE_API_BULK_RESPONSE_CSV_FILE_PATH;

	@Value("${CHECK_CONSISTENCY_REQUEST_CSV_FILE_PATH}")
	private String CHECK_CONSISTENCY_REQUEST_CSV_FILE_PATH;

	@Value("${CHECK_CONSISTENCY_RESPONSE_CSV_FILE_PATH}")
	private String CHECK_CONSISTENCY_RESPONSE_CSV_FILE_PATH;

	@Value("${authToken}")
	private String authToken;

	@Value("${lookUpADLUri}")
	private String lookUpADLUriFromProperty;

	@Value("${writeAPIUri}")
	private String writeAPIUriFromProperty;

	public void callDemoService() {
		Quote quote = restTemplate.getForObject(demoRestUri, Quote.class);
		logger.info(quote.toString());
	}

	private final AsynADLService asynADLService;

	public InvokeRestService(AsynADLService asynADLService) {
		this.asynADLService = asynADLService;
	}

	/**
	 * Call ADL WriteAPI for bulk of Objects. Object list created by reading the CSV
	 * file. Object list is iterated and API call is made. Response is written in
	 * CSV file.
	 * 
	 * @param objName
	 * @param inputFileName
	 * @return
	 */
	public Object callADLBulkWriteAPI(String objName, String inputFileName) {
		Object writeAPIObj = null;
		if (objName.equalsIgnoreCase("personas")) {
			writeAPIObj = new Persona();
		} else if (objName.equalsIgnoreCase("identities")) {
			writeAPIObj = new Identities();
		} else if (objName.equalsIgnoreCase("orders")) {
			writeAPIObj = new Orders();
		} else if (objName.equalsIgnoreCase("cases")) {
			writeAPIObj = new Cases();
		} else if (objName.equalsIgnoreCase("devices")) {
			writeAPIObj = new Device();
		} else if (objName.equalsIgnoreCase("segments")) {
			writeAPIObj = new Segments();
		} else if (objName.equalsIgnoreCase("interactions")) {
			writeAPIObj = new Interaction();
		} else if (objName.equalsIgnoreCase("vouchers")) {
			writeAPIObj = new Vouchers();
		} else if (objName.equalsIgnoreCase("ageverifications")) {
			writeAPIObj = new AgeVerification();
		} else if (objName.equalsIgnoreCase("surveys")) {
			writeAPIObj = new Surveys();
		} else if (objName.equalsIgnoreCase("psychographics")) {
			writeAPIObj = new Psychographics();
		} else if (objName.equalsIgnoreCase("eventregistrations")) {
			writeAPIObj = new EventRegistrations();
		} else if (objName.equalsIgnoreCase("campaignevents")) {
			writeAPIObj = new CampaignEvents();
		} else if (objName.equalsIgnoreCase("demographics")) {
			writeAPIObj = new Demographics();
		} else if (objName.equalsIgnoreCase("terms")) {
			writeAPIObj = new Terms();
		} else if (objName.equalsIgnoreCase("derivedattributes")) {
			writeAPIObj = new DerivedAttributes();
		} else if (objName.equalsIgnoreCase("segmentations")) {
			writeAPIObj = new Segmentations();
		}
		String writeAPIUri = writeAPIUriFromProperty; // https://c360-ingest-api.eu01.treasuredata.com/v1/c360/%s
		writeAPIUri = String.format(writeAPIUri, objName);
		// create Request Header
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", authToken);

		// Read the CSV File and create list of
		// Object(Persona,Identites,Cases,Order,Devices)
		List<Object> requestObjlist = null;
		List<Object> responseObjlist = new ArrayList<>();
		try {
			String filePath;
			if (inputFileName.equalsIgnoreCase("notAvailable")) { // if user has not provided input file name;
				filePath = String.format(WRITE_API_BULK_REQUEST_CSV_FILE_PATH, objName);
			} else {
				if (inputFileName.indexOf(".csv") == -1) {
					inputFileName = inputFileName + ".csv";
				}
				filePath = WRITE_API_BULK_REQUEST_FILE_PATH + inputFileName;
			}
			requestObjlist = readWriteCSV.readCSVWithHeader(writeAPIObj, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ResponseEntity responseEntity = null;
		List<CompletableFuture<ResponseEntity>> futureResultList = new ArrayList<CompletableFuture<ResponseEntity>>();
		long startTime = System.currentTimeMillis();
		for (Object reqObject : requestObjlist) {
			HttpEntity<Object> entity = new HttpEntity<>(reqObject, httpHeaders);

//			ResponseEntity<? extends Object> responseEntity = restTemplate.exchange(writeAPIUri, HttpMethod.POST,
//					entity, reqObject.getClass());

			CompletableFuture<ResponseEntity> completableFutureResponseEntity = asynADLService
					.callWriteService(writeAPIUri, entity, reqObject);

			futureResultList.add(completableFutureResponseEntity);

		}
		CompletableFuture[] futureResultArray = futureResultList
				.toArray(new CompletableFuture[futureResultList.size()]);
		CompletableFuture.allOf(futureResultArray).join();// Wait until they are all done
		for (CompletableFuture<ResponseEntity> completableFuture : futureResultArray) {
			try {
				responseEntity = completableFuture.get();// Waits for this future to complete,then returns its result.
				responseObjlist.add(responseEntity.getBody());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

		}
		long endTime = System.currentTimeMillis();
		logger.info("Elapsed time: " + (endTime - startTime));
		// Write the response of Bulk Write API response to CSV
		// readWriteCSV.writeToCsv(responseObjlist,
		// String.format(WRITE_API_BULK_RESPONSE_CSV_FILE_PATH, objName));

//		logger.info("Write API Response Written to CSV available at location :"
//				+ String.format(WRITE_API_BULK_RESPONSE_CSV_FILE_PATH, objName));

		logger.info("Write API call is success. Please verify the records in database.");

		// return responseObjlist;
//		return "SUCCESS: Write API Response Written to CSV available at location : "
//				+ String.format(WRITE_API_BULK_RESPONSE_CSV_FILE_PATH, objName);
		return "SUCCESS: Write API call is completed. Please verify the records in database.";
	}

	// Call ADL WriteAPI for single Object
	public void callADLWriteAPI(String objName, Object writeAPIObj, String primaryKey) {
		String writeAPIUri = writeAPIUriFromProperty; // https://c360-ingest-api.eu01.treasuredata.com/v1/c360/%s
		writeAPIUri = String.format(writeAPIUri, objName);
		// create Request Header
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", authToken);
		HttpEntity entity = new HttpEntity<>(writeAPIObj, httpHeaders);

		System.out.println("Write API URI -> " + writeAPIUri);
		System.out.println("Write API Request Body -> " + entity.getBody());
		readWriteCSV.writeToCsv(writeAPIObj, String.format(WRITE_API_REQUEST_CSV_FILE_PATH, primaryKey, objName));
		long startTime = System.currentTimeMillis();
		ResponseEntity<? extends Object> responseEntity = restTemplate.exchange(writeAPIUri, HttpMethod.POST, entity,
				writeAPIObj.getClass());
		long endTime = System.currentTimeMillis();
		System.out.println("===== Time taken to make writeAPI call for " + objName + " object is "
				+ (endTime - startTime) + " milliseconds =====");
		readWriteCSV.writeToCsv(responseEntity.getBody(),
				String.format(WRITE_API_RESPONSE_CSV_FILE_PATH, primaryKey, objName));
		System.out.println("Write API Response Status Code -> " + responseEntity.getStatusCode());
		System.out.println("Write API Response Body -> " + responseEntity.getBody());
		System.out.println("--- Response Written to CSV available at location :"
				+ String.format(WRITE_API_RESPONSE_CSV_FILE_PATH, primaryKey, objName));
	}

	public Object testDataBaseConsistency(String objName) {
		Object writeAPIObj = null;
		if (objName.equalsIgnoreCase("personas")) {
			writeAPIObj = new Persona();
		} else if (objName.equalsIgnoreCase("identities")) {
			writeAPIObj = new Identities();
		} else if (objName.equalsIgnoreCase("orders")) {
			writeAPIObj = new Orders();
		} else if (objName.equalsIgnoreCase("cases")) {
			writeAPIObj = new Cases();
		} else if (objName.equalsIgnoreCase("devices")) {
			writeAPIObj = new Device();
		} else if (objName.equalsIgnoreCase("segments")) {
			writeAPIObj = new Segments();
		} else if (objName.equalsIgnoreCase("interactions")) {
			writeAPIObj = new Interaction();
		} else if (objName.equalsIgnoreCase("vouchers")) {
			writeAPIObj = new Vouchers();
		} else if (objName.equalsIgnoreCase("ageverifications")) {
			writeAPIObj = new AgeVerification();
		} else if (objName.equalsIgnoreCase("surveys")) {
			writeAPIObj = new Surveys();
		} else if (objName.equalsIgnoreCase("psychographics")) {
			writeAPIObj = new Psychographics();
		} else if (objName.equalsIgnoreCase("eventregistrations")) {
			writeAPIObj = new EventRegistrations();
		} else if (objName.equalsIgnoreCase("campaignevents")) {
			writeAPIObj = new CampaignEvents();
		} else if (objName.equalsIgnoreCase("demographics")) {
			writeAPIObj = new Demographics();
		} else if (objName.equalsIgnoreCase("terms")) {
			writeAPIObj = new Terms();
		} else if (objName.equalsIgnoreCase("derivedattributes")) {
			writeAPIObj = new DerivedAttributes();
		} else if (objName.equalsIgnoreCase("segmentations")) {
			writeAPIObj = new Segmentations();
		}
		String writeAPIUri = writeAPIUriFromProperty; // https://c360-ingest-api.eu01.treasuredata.com/v1/c360/%s
		String recordConsistencyTime = null;
		writeAPIUri = String.format(writeAPIUri, objName);
		// create Request Header
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", authToken);

		// Read the CSV File and create list of
		// Object(Persona,Identites,Cases,Order,Devices)
		List<Object> requestObjlist = null;
		List<Object> responseObjlist = new ArrayList<>();
		try {
			requestObjlist = readWriteCSV.readCSVWithHeader(writeAPIObj,
					String.format(CHECK_CONSISTENCY_REQUEST_CSV_FILE_PATH, objName));// Read CSV
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Object reqObject : requestObjlist) { // Single iteration as the CSV has only one record.
			HttpEntity<Object> entity = new HttpEntity<>(reqObject, httpHeaders);
			System.out.println("Write API URI -> " + writeAPIUri);
			System.out.println("Write API Request Body -> " + entity.getBody());
			long startTime = System.currentTimeMillis();
			ResponseEntity<? extends Object> responseEntity = restTemplate.exchange(writeAPIUri, HttpMethod.POST,
					entity, reqObject.getClass()); // Write to database.
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken to make writeAPI call for " + objName + " object is " + (endTime - startTime)
					+ " milliseconds");
			System.out.println("Write API Response Status Code -> " + responseEntity.getStatusCode());
			System.out.println("Write API Response Body -> " + responseEntity.getBody());
			HttpEntity<String> lookUpAPIentity = new HttpEntity<>("parameters", httpHeaders);
			if (responseEntity.getBody() instanceof Persona) {
				Persona persona = (Persona) responseEntity.getBody();
				persona.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ persona.getPersona_identifier();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, persona);
				persona.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(persona);
			} else if (responseEntity.getBody() instanceof Identities) {
				Identities identities = (Identities) responseEntity.getBody();
				identities.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ identities.getIdentity_unique_identifier();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, identities);
				identities.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(identities);
			} else if (responseEntity.getBody() instanceof Orders) {
				Orders orders = (Orders) responseEntity.getBody();
				orders.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + orders.getOrder_number();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, orders);
				orders.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(orders);
			} else if (responseEntity.getBody() instanceof Cases) {
				Cases cases = (Cases) responseEntity.getBody();
				cases.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + cases.getCase_number();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, cases);
				cases.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(cases);
			} else if (responseEntity.getBody() instanceof Device) {
				Device device = (Device) responseEntity.getBody();
				device.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + device.getDevice_codentify();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, device);
				device.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(device);
			} else if (responseEntity.getBody() instanceof Segments) {
				Segments segments = (Segments) responseEntity.getBody();
				segments.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + segments.getSegment_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, segments);
				segments.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(segments);
			} else if (responseEntity.getBody() instanceof Interaction) {
				Interaction interaction = (Interaction) responseEntity.getBody();
				interaction.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ interaction.getInteraction_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, interaction);
				interaction.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(interaction);
			} else if (responseEntity.getBody() instanceof Vouchers) {
				Vouchers vouchers = (Vouchers) responseEntity.getBody();
				vouchers.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + vouchers.getVoucher_code();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, vouchers);
				vouchers.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(vouchers);
			} else if (responseEntity.getBody() instanceof AgeVerification) {
				AgeVerification ageVerification = (AgeVerification) responseEntity.getBody();
				ageVerification.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + ageVerification.getAv_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, ageVerification);
				ageVerification.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(ageVerification);
			} else if (responseEntity.getBody() instanceof Surveys) {
				Surveys surveys = (Surveys) responseEntity.getBody();
				surveys.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + surveys.getSurvey_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, surveys);
				surveys.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(surveys);
			} else if (responseEntity.getBody() instanceof CampaignEvents) {
				CampaignEvents campaignevents = (CampaignEvents) responseEntity.getBody();
				campaignevents.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ campaignevents.getCampaign_event_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, campaignevents);
				campaignevents.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(campaignevents);
			} else if (responseEntity.getBody() instanceof Psychographics) {
				Psychographics psychographics = (Psychographics) responseEntity.getBody();
				psychographics.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ psychographics.getPyschographic_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, psychographics);
				psychographics.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(psychographics);
			} else if (responseEntity.getBody() instanceof EventRegistrations) {
				EventRegistrations eventregistrations = (EventRegistrations) responseEntity.getBody();
				eventregistrations.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ eventregistrations.getEvent_registration_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity,
						eventregistrations);
				eventregistrations.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(eventregistrations);
			} else if (responseEntity.getBody() instanceof Demographics) {
				Demographics demographics = (Demographics) responseEntity.getBody();
				demographics.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ demographics.getDemographic_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, demographics);
				demographics.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(demographics);
			} else if (responseEntity.getBody() instanceof DerivedAttributes) {
				DerivedAttributes derivedattributes = (DerivedAttributes) responseEntity.getBody();
				derivedattributes.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ derivedattributes.getDerived_attribute_record_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity,
						derivedattributes);
				derivedattributes.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(derivedattributes);
			} else if (responseEntity.getBody() instanceof Terms) {
				Terms terms = (Terms) responseEntity.getBody();
				terms.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + terms.getTerms_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, terms);
				terms.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(terms);
			} else if (responseEntity.getBody() instanceof Segmentations) {
				Segmentations segmentations = (Segmentations) responseEntity.getBody();
				segmentations.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ segmentations.getSegmentation_record_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, segmentations);
				segmentations.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(segmentations);
			}

			else {
				responseObjlist.add(responseEntity.getBody());
			}

		}
		// Write the response of Bulk Write API response to CSV
		readWriteCSV.writeToCsv(responseObjlist, String.format(CHECK_CONSISTENCY_RESPONSE_CSV_FILE_PATH, objName));

		System.out.println("Write API Response Written to CSV available at location :"
				+ String.format(CHECK_CONSISTENCY_RESPONSE_CSV_FILE_PATH, objName));

		return "SUCCESS: Time taken to read the record immediately after write operation is "
				+ recordConsistencyTime.split(" ")[0] + " milliseconds. Number of re-read attempts made is "
				+ recordConsistencyTime.split(" ")[1] + " . Response is written to CSV available at location : "
				+ String.format(CHECK_CONSISTENCY_RESPONSE_CSV_FILE_PATH, objName);
	}

	/**
	 * Perform id lookup API call to ADL
	 * 
	 * @param objName
	 * @param url
	 * @param lookUpAPIentity
	 * @param lookUpApiObj
	 * @return
	 */
	private String genericCallToLookUpAPI(String objName, String url, HttpEntity<String> lookUpAPIentity,
			Object lookUpApiObj) {
		ResponseEntity lookUpCallResponseEntity = null;
		System.out.println("ID lookup uri -> " + url);
		int count = 0;
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			try {
				// Immediately lookup the object inserted above
				lookUpCallResponseEntity = restTemplate.exchange(url, HttpMethod.GET, lookUpAPIentity,
						lookUpApiObj.getClass());
				if (lookUpCallResponseEntity != null)
					break;
			} catch (RestClientException e) {
				count++;
				System.out.println(e.getMessage()); // if 404 - Not Found; Retry to read until 100 times
				continue;
			}
		}
		long end = System.currentTimeMillis();

		return String.valueOf(end - start) + " " + count;

	}

	/**
	 * This is to make id lookup API call to ADL
	 * 
	 * @param objName
	 * @return
	 */
	// @Async
	public Object callADLLookupAPI(String objName, String inputFileName) {
		String lookUpADLUri = lookUpADLUriFromProperty; // https://c360-api-a8-dce20.eu01.treasuredata.com/v1/events/c360/%s/
		// Read the primary Key from CSV files.
		String filePath;
		if (inputFileName.equalsIgnoreCase("notAvailable")) { // if user has not provided input file name;
			filePath = String.format(LOOKUP_API_REQUEST_CSV_FILE_PATH, objName);
		} else {
			if (inputFileName.indexOf(".csv") == -1) {
				inputFileName = inputFileName + ".csv";
			}
			filePath = LOOKUP_API_REQUEST_FILE_PATH + inputFileName;
		}
		String[] arr = readWriteCSV.getLookUpIdsFromCSV(filePath);

		lookUpADLUri = String.format(lookUpADLUri, objName);

		// create Request Header
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", authToken);
		HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);

		Object readAPIObj = null;
		if (objName.equalsIgnoreCase("personas")) {
			readAPIObj = new Persona();
		} else if (objName.equalsIgnoreCase("identities")) {
			readAPIObj = new Identities();
		} else if (objName.equalsIgnoreCase("orders")) {
			readAPIObj = new Orders();
		} else if (objName.equalsIgnoreCase("cases")) {
			readAPIObj = new Cases();
		} else if (objName.equalsIgnoreCase("devices")) {
			readAPIObj = new Device();
		} else if (objName.equalsIgnoreCase("segments")) {
			readAPIObj = new Segments();
		} else if (objName.equalsIgnoreCase("interactions")) {
			readAPIObj = new Interaction();
		} else if (objName.equalsIgnoreCase("vouchers")) {
			readAPIObj = new Vouchers();
		} else if (objName.equalsIgnoreCase("ageverifications")) {
			readAPIObj = new AgeVerification();
		} else if (objName.equalsIgnoreCase("surveys")) {
			readAPIObj = new Surveys();
		} else if (objName.equalsIgnoreCase("psychographics")) {
			readAPIObj = new Psychographics();
		} else if (objName.equalsIgnoreCase("eventregistrations")) {
			readAPIObj = new EventRegistrations();
		} else if (objName.equalsIgnoreCase("campaignevents")) {
			readAPIObj = new CampaignEvents();
		} else if (objName.equalsIgnoreCase("demographics")) {
			readAPIObj = new Demographics();
		} else if (objName.equalsIgnoreCase("terms")) {
			readAPIObj = new Terms();
		} else if (objName.equalsIgnoreCase("segmentations")) {
			readAPIObj = new Segmentations();
		} else if (objName.equalsIgnoreCase("derivedattributes")) {
			readAPIObj = new DerivedAttributes();
		}

		ResponseEntity responseEntity = null;
		List<Object> responseObjlist = new ArrayList<>();
		List<CompletableFuture<ResponseEntity>> futureResultList = new ArrayList<CompletableFuture<ResponseEntity>>();
		long start = System.currentTimeMillis();
		for (String id : arr) {
			String lookUpADLUri2 = lookUpADLUri + id;
			// long startTime = System.currentTimeMillis();
			// responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity,
			// readAPIObj.getClass());

			// Kick of multiple, asynchronous lookups
			CompletableFuture<ResponseEntity> completableFutureResponseEntity = asynADLService
					.callReadService(lookUpADLUri2, entity, readAPIObj);

			futureResultList.add(completableFutureResponseEntity);

			// Wait until they are all done
			// CompletableFuture.allOf(completableFutureResponseEntity).join();

//			long endTime = System.currentTimeMillis();
//			logger.info("Time: Asynch lookup API call from Main Thread, for " + objName + " object ID " + id + " is "
//					+ (endTime - startTime) + " milliseconds");
		}

		CompletableFuture[] futureResultArray = futureResultList
				.toArray(new CompletableFuture[futureResultList.size()]);
		CompletableFuture.allOf(futureResultArray).join();// Wait until they are all done
		for (CompletableFuture<ResponseEntity> completableFuture : futureResultArray) {
			try {
				responseEntity = completableFuture.get();// Waits for this future to complete,then returns its result.
				responseObjlist.add(responseEntity.getBody());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

		}
		long end = System.currentTimeMillis();
		logger.info("Elapsed time: " + (end - start));

		// Write Response to CSV file
		readWriteCSV.writeToCsv(responseObjlist, String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));

		logger.info("Lookup ID API Response Written to CSV available at location :"
				+ String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));

		// return responseObjlist;
		return "SUCCESS: ID Lookup API Response Written to CSV file, available at location : "
				+ String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName);
	}

	/**
	 * This method is for testing purpose. Pass a object and make ADL Write API
	 * call. Response will be written on console. NO read or write to CSV
	 * 
	 * @param objName
	 * @param requestObjlist
	 */
	public void callWriteAPI(String objName, List<Object> requestObjlist) {
		String writeAPIUri = writeAPIUriFromProperty; // https://c360-ingest-api.eu01.treasuredata.com/v1/c360/%s
		writeAPIUri = String.format(writeAPIUri, objName);
		// create Request Header
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", authToken);
		List<Object> responseObjlist = new ArrayList<>();
		for (Object reqObject : requestObjlist) { // Single iteration as the CSV has only one record.
			HttpEntity<Object> entity = new HttpEntity<>(reqObject, httpHeaders);
			System.out.println("Write API URI -> " + writeAPIUri);
			System.out.println("Write API Request Body -> " + entity.getBody());
			long startTime = System.currentTimeMillis();
			ResponseEntity<? extends Object> responseEntity = restTemplate.exchange(writeAPIUri, HttpMethod.POST,
					entity, reqObject.getClass()); // Write to database.
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken to make writeAPI call for " + objName + " object is " + (endTime - startTime)
					+ " milliseconds");
			System.out.println("Write API Response Status Code -> " + responseEntity.getStatusCode());
			System.out.println("Write API Response Body -> " + responseEntity.getBody());
			if (responseEntity.getBody() instanceof Persona) {
				Persona persona = (Persona) responseEntity.getBody();
				persona.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(persona);
			} else if (responseEntity.getBody() instanceof Identities) {
				Identities identities = (Identities) responseEntity.getBody();
				identities.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(identities);
			} else if (responseEntity.getBody() instanceof Orders) {
				Orders orders = (Orders) responseEntity.getBody();
				orders.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(orders);
			} else if (responseEntity.getBody() instanceof Cases) {
				Cases cases = (Cases) responseEntity.getBody();
				cases.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(cases);
			} else if (responseEntity.getBody() instanceof Device) {
				Device device = (Device) responseEntity.getBody();
				device.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(device);
			} else if (responseEntity.getBody() instanceof Segments) {
				Segments segments = (Segments) responseEntity.getBody();
				segments.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(segments);
			} else if (responseEntity.getBody() instanceof Interaction) {
				Interaction interaction = (Interaction) responseEntity.getBody();
				interaction.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(interaction);
			} else if (responseEntity.getBody() instanceof Vouchers) {
				Vouchers vouchers = (Vouchers) responseEntity.getBody();
				vouchers.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(vouchers);
			} else if (responseEntity.getBody() instanceof AgeVerification) {
				AgeVerification ageVerification = (AgeVerification) responseEntity.getBody();
				ageVerification.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(ageVerification);
			} else if (responseEntity.getBody() instanceof Surveys) {
				Surveys surveys = (Surveys) responseEntity.getBody();
				surveys.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(surveys);
			} else if (responseEntity.getBody() instanceof EventRegistrations) {
				EventRegistrations eventregistrations = (EventRegistrations) responseEntity.getBody();
				eventregistrations.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(eventregistrations);
			} else if (responseEntity.getBody() instanceof Psychographics) {
				Psychographics psychographics = (Psychographics) responseEntity.getBody();
				psychographics.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(psychographics);
			} else if (responseEntity.getBody() instanceof CampaignEvents) {
				CampaignEvents campaignevents = (CampaignEvents) responseEntity.getBody();
				campaignevents.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(campaignevents);
			} else if (responseEntity.getBody() instanceof Demographics) {
				Demographics demographics = (Demographics) responseEntity.getBody();
				demographics.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(demographics);
			} else if (responseEntity.getBody() instanceof Segmentations) {
				Segmentations segmentations = (Segmentations) responseEntity.getBody();
				segmentations.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(segmentations);
			} else if (responseEntity.getBody() instanceof Terms) {
				Terms terms = (Terms) responseEntity.getBody();
				terms.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(terms);
			} else if (responseEntity.getBody() instanceof DerivedAttributes) {
				DerivedAttributes derivedattributes = (DerivedAttributes) responseEntity.getBody();
				derivedattributes.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				responseObjlist.add(derivedattributes);
			} else {
				responseObjlist.add(responseEntity.getBody());
			}
		}
		for (Object object : responseObjlist) {
			System.out.println("Response object -> " + object);
		}

	}

}
