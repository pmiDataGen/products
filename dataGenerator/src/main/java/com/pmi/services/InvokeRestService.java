package com.pmi.services;

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
import org.springframework.web.client.RestTemplate;

import com.pmi.pojo.Cases;
import com.pmi.pojo.DeviceResponseMapper;
import com.pmi.pojo.Identities;
import com.pmi.pojo.Orders;
import com.pmi.pojo.Persona;
import com.pmi.pojo.PersonaRequest;
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

	@Value("${authToken}")
	private String authToken;

	@Value("${lookUpADLUri}")
	private String lookUpADLUriFromProperty;

	@Value("${writeAPIUri}")
	private String writeAPIUriFromProperty;

	private String lookUpADLUri2;

	public void callDemoService() {
		System.out.println("demoRestUri --->> " + demoRestUri);
		Quote quote = restTemplate.getForObject(demoRestUri, Quote.class);
		log.info(quote.toString());
		System.out.println(quote.toString());
	}

	public void callADLWriteAPI(String objName, Object writeAPIObj, String primaryKey) {
		String writeAPIUri = writeAPIUriFromProperty; // https://c360-ingest-api.eu01.treasuredata.com/v1/c360/%s
		writeAPIUri = String.format(writeAPIUri, objName);
		// create Request Header
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", authToken);
		HttpEntity entity = new HttpEntity<>(writeAPIObj, httpHeaders);

		System.out.println("Write API URI -> " + writeAPIUri);
		System.out.println("Write API Request Body -> " + entity.getBody());
		readWriteCSV.writeToCsv(writeAPIObj, String.format(WRITE_API_REQUEST_CSV_FILE_PATH, primaryKey,objName));
		long startTime = System.currentTimeMillis();
		ResponseEntity responseEntity = restTemplate.exchange(writeAPIUri, HttpMethod.POST, entity,
				writeAPIObj.getClass());
		long endTime = System.currentTimeMillis();
		System.out.println("===== Time taken to make writeAPI call for " + objName + " object is "
				+ (endTime - startTime) + " milliseconds =====");
		readWriteCSV.writeToCsv(writeAPIObj, String.format(WRITE_API_RESPONSE_CSV_FILE_PATH, primaryKey,objName));
		System.out.println("Write API Response Status Code -> " + responseEntity.getStatusCode());
		System.out.println("Write API Response Body -> " + responseEntity.getBody());
	}

	public void callADLLookupAPI(String objName) {
		String lookUpADLUri = lookUpADLUriFromProperty; // https://c360-api-a8-dce20.eu01.treasuredata.com/v1/events/c360/%s/
		lookUpADLUri2 = null;
		// Read the primary Key from CSV files.
		String[] arr = readWriteCSV.getLookUpIdsFromCSV(String.format(LOOKUP_API_REQUEST_CSV_FILE_PATH, objName));

		lookUpADLUri = String.format(lookUpADLUri, objName);

		// create Request Header
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", authToken);
		HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);

		if (objName.equalsIgnoreCase("personas")) {
			ResponseEntity<Persona> responseEntity = null;
			List<ResponseEntity<Persona>> personaObjList = new ArrayList<>();
			List<Persona> personaObjList2 = new ArrayList<>();
			for (String id : arr) {
				lookUpADLUri2 = lookUpADLUri + id;
				System.out.println("URI -> " + lookUpADLUri2);
				long startTime = System.currentTimeMillis();
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Persona.class);
				long endTime = System.currentTimeMillis();
				System.out.println("===== Time taken to make lookup API call for " + objName + " object ID " + id
						+ " is " + (endTime - startTime) + " milliseconds =====");
				personaObjList.add(responseEntity);
			}
			for (ResponseEntity<Persona> personaObj : personaObjList) {
				personaObjList2.add(personaObj.getBody());
				System.out.println("The Persona Response Object --> " + personaObj.getBody());
			}
			// Write Response to CSV file
			readWriteCSV.writeToCsv(personaObjList2, String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));

		} else if (objName.equalsIgnoreCase("identities")) {
			ResponseEntity<Identities> responseEntity = null;
			List<ResponseEntity<Identities>> identitiesResponseMapperList = new ArrayList<>();
			List<Identities> identitiesResponseMapperList2 = new ArrayList<>();
			for (String id : arr) {
				lookUpADLUri2 = lookUpADLUri + id;
				System.out.println("URI -> " + lookUpADLUri2);
				long startTime = System.currentTimeMillis();
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Identities.class);
				long endTime = System.currentTimeMillis();
				System.out.println("===== Time taken to make lookup API call for " + objName + " object ID " + id
						+ " is " + (endTime - startTime) + " milliseconds =====");
				identitiesResponseMapperList.add(responseEntity);
			}
			for (ResponseEntity<Identities> identityObj : identitiesResponseMapperList) {
				identitiesResponseMapperList2.add(identityObj.getBody());
				System.out.println("The Identity Response Object --> " + identityObj.getBody());
			}
			// Write Response to CSV File
			readWriteCSV.writeToCsv(identitiesResponseMapperList2,
					String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));
		} else if (objName.equalsIgnoreCase("devices")) {
			ResponseEntity<DeviceResponseMapper> responseEntity = null;
			List<ResponseEntity<DeviceResponseMapper>> deviceResponseMapperList = new ArrayList<>();
			List<DeviceResponseMapper> deviceResponseMapperList2 = new ArrayList<>();
			for (String id : arr) {
				lookUpADLUri2 = lookUpADLUri + id;
				System.out.println("URI -> " + lookUpADLUri2);
				long startTime = System.currentTimeMillis();
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity,
						DeviceResponseMapper.class);
				long endTime = System.currentTimeMillis();
				System.out.println("===== Time taken to make lookup API call for " + objName + " object ID " + id
						+ " is " + (endTime - startTime) + " milliseconds =====");
				deviceResponseMapperList.add(responseEntity);
			}
			for (ResponseEntity<DeviceResponseMapper> deviceObj : deviceResponseMapperList) {
				deviceResponseMapperList2.add(deviceObj.getBody());
				System.out.println("The Device Response Object --> " + deviceObj.getBody());
			}
			// Write Response to CSV File
			readWriteCSV.writeToCsv(deviceResponseMapperList2,
					String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));
		} else if (objName.equalsIgnoreCase("cases")) {
			ResponseEntity<Cases> responseEntity = null;
			List<ResponseEntity<Cases>> casesResponseList = new ArrayList<>();
			List<Cases> casesResponseList2 = new ArrayList<>();
			for (String id : arr) {
				lookUpADLUri2 = lookUpADLUri + id;
				System.out.println("URI -> " + lookUpADLUri2);
				long startTime = System.currentTimeMillis();
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Cases.class);
				long endTime = System.currentTimeMillis();
				System.out.println("===== Time taken to make lookup API call for " + objName + " object ID " + id
						+ " is " + (endTime - startTime) + " milliseconds =====");
				casesResponseList.add(responseEntity);
			}
			for (ResponseEntity<Cases> casesObj : casesResponseList) {
				casesResponseList2.add(casesObj.getBody());
				System.out.println("The Cases Response Object --> " + casesObj.getBody());
			}
			// Write Response to CSV File
			readWriteCSV.writeToCsv(casesResponseList2, String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));
		} else if (objName.equalsIgnoreCase("orders")) {
			ResponseEntity<Orders> responseEntity = null;
			List<ResponseEntity<Orders>> ordersResponseList = new ArrayList<>();
			List<Orders> ordersResponseList2 = new ArrayList<>();
			for (String id : arr) {
				lookUpADLUri2 = lookUpADLUri + id;
				System.out.println("URI -> " + lookUpADLUri2);
				long startTime = System.currentTimeMillis();
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Orders.class);
				long endTime = System.currentTimeMillis();
				System.out.println("===== Time taken to make lookup API call for " + objName + " object ID " + id
						+ " is " + (endTime - startTime) + " milliseconds =====");
				ordersResponseList.add(responseEntity);
			}
			for (ResponseEntity<Orders> ordersObj : ordersResponseList) {
				ordersResponseList2.add(ordersObj.getBody());
				System.out.println("The Orders Response Object --> " + ordersObj.getBody());
			}
			// Write Response to CSV File
			readWriteCSV.writeToCsv(ordersResponseList2, String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));
		}

		System.out.println("--- Response Written to CSV available at location :"
				+ String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));
	}

}
