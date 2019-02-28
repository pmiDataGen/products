package com.pmi.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.pmi.pojo.Cases;
import com.pmi.pojo.Device;
import com.pmi.pojo.Identities;
import com.pmi.pojo.Orders;
import com.pmi.pojo.Persona;
import com.pmi.pojo.Quote;
import com.pmi.util.ReadWriteCSV;

/**
 * @author vikas.e.mishra
 *
 */

@Component
public class InvokeRestService {

	private static final Logger log = LoggerFactory.getLogger(InvokeRestService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders httpHeaders;

	@Autowired
	private ReadWriteCSV readWriteCSV;

	@Value("${demoRestUri}")
	private String demoRestUri;

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
		log.info(quote.toString());
		System.out.println(quote.toString());
	}

	// Call ADL WriteAPI for bulk of Objects. Object list created by reading the CSV
	// file. Object list is iterated and API call is made. Response is written in
	// CSV file.
	public Object callADLBulkWriteAPI(String objName) {
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
			requestObjlist = readWriteCSV.readCSVWithHeader(writeAPIObj,
					String.format(WRITE_API_BULK_REQUEST_CSV_FILE_PATH, objName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Object reqObject : requestObjlist) {
			HttpEntity<Object> entity = new HttpEntity<>(reqObject, httpHeaders);
			System.out.println("Write API URI -> " + writeAPIUri);
			System.out.println("Write API Request Body -> " + entity.getBody());
			long startTime = System.currentTimeMillis();
			ResponseEntity<? extends Object> responseEntity = restTemplate.exchange(writeAPIUri, HttpMethod.POST,
					entity, reqObject.getClass());
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
			} else {
				responseObjlist.add(responseEntity.getBody());
			}

			System.out.println("====================================================================================");
		}
		// Write the response of Bulk Write API response to CSV
		readWriteCSV.writeToCsv(responseObjlist, String.format(WRITE_API_BULK_RESPONSE_CSV_FILE_PATH, objName));

		System.out.println("Write API Response Written to CSV available at location :"
				+ String.format(WRITE_API_BULK_RESPONSE_CSV_FILE_PATH, objName));

		// return responseObjlist;
		return "SUCCESS: Write API Response Written to CSV available at location : "
				+ String.format(WRITE_API_BULK_RESPONSE_CSV_FILE_PATH, objName);
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
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + persona.getPersona_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, persona);
				persona.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(persona);
			} else if (responseEntity.getBody() instanceof Identities) {
				Identities identities = (Identities) responseEntity.getBody();
				identities.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + identities.getIdentity_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, identities);
				identities.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(identities);
			} else if (responseEntity.getBody() instanceof Orders) {
				Orders orders = (Orders) responseEntity.getBody();
				orders.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + orders.getOrder_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, orders);
				orders.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(orders);
			} else if (responseEntity.getBody() instanceof Cases) {
				Cases cases = (Cases) responseEntity.getBody();
				cases.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName) + cases.getCase_id();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, cases);
				cases.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(cases);
			} else if (responseEntity.getBody() instanceof Device) {
				Device device = (Device) responseEntity.getBody();
				device.setApiCallTimeTakenInMillis(String.valueOf(endTime - startTime));
				String lookUpADLUri = String.format(lookUpADLUriFromProperty, objName)
						+ device.getDevice_serial_number();
				recordConsistencyTime = genericCallToLookUpAPI(objName, lookUpADLUri, lookUpAPIentity, device);
				device.setRecordConsistencyTime(recordConsistencyTime.split(" ")[0]);
				responseObjlist.add(device);
			} else {
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
	public Object callADLLookupAPI(String objName) {
		String lookUpADLUri = lookUpADLUriFromProperty; // https://c360-api-a8-dce20.eu01.treasuredata.com/v1/events/c360/%s/
		// Read the primary Key from CSV files.
		String[] arr = readWriteCSV.getLookUpIdsFromCSV(String.format(LOOKUP_API_REQUEST_CSV_FILE_PATH, objName));

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
		}

		ResponseEntity responseEntity = null;
		List<Object> responseObjlist = new ArrayList<>();
		for (String id : arr) {
			String lookUpADLUri2 = lookUpADLUri + id;
			System.out.println("URI -> " + lookUpADLUri2);
			long startTime = System.currentTimeMillis();
			responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, readAPIObj.getClass());
			long endTime = System.currentTimeMillis();
			System.out.println("Time taken to make lookup API call for " + objName + " object ID " + id + " is "
					+ (endTime - startTime) + " milliseconds");
			System.out.println("The lookUp API Response Object --> " + responseEntity.getBody());

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
			} else {
				responseObjlist.add(responseEntity.getBody());
			}
			System.out.println("====================================================================================");
		}

		// Write Response to CSV file
		readWriteCSV.writeToCsv(responseObjlist, String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));

		System.out.println("Lookup ID API Response Written to CSV available at location :"
				+ String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));

		// return responseObjlist;
		return "SUCCESS: ID Lookup API Response Written to CSV file, available at location : "
				+ String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName);
	}

}
