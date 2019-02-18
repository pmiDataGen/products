package com.pmi.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.pmi.pojo.Quote;
import com.pmi.util.ReadWriteCSV;

/**
 * @author vikas.e.mishra
 *
 */

@Component
//@Configuration
//@PropertySource("file:application.properties")
public class InvokeRestService {

	private static final Logger log = LoggerFactory.getLogger(InvokeRestService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders httpHeaders;

	@Autowired
	private ReadWriteCSV readWriteCSV;

	private static String demoRestUri = "http://gturnquist-quoters.cfapps.io/api/random;";
//	 @Value("${demoRestUri}")
//	    private String demoRestUri;

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}

	private static final String LOOKUP_API_REQUEST_CSV_FILE_PATH = "C:\\CSVFiles\\idLookUp\\request\\idLookUp_%s.csv";

	private static final String LOOKUP_API_RESPONSE_CSV_FILE_PATH = "C:\\CSVFiles\\idLookUp\\response\\idLookUp_response_%s.csv";

	private static String lookUpADLUri = "https://c360-api-a8-dce20.eu01.treasuredata.com/v1/events/c360/%s/";

	private static String lookUpADLUri2 = null;

	public void callDemoService() {
		Quote quote = restTemplate.getForObject(demoRestUri, Quote.class);
		log.info(quote.toString());
		System.out.println(quote.toString());
	}

	public void callADLLookupAPI(String objName) {

		// Read the primary Key from CSV files.
		String[] arr = readWriteCSV.getLookUpIdsFromCSV(String.format(LOOKUP_API_REQUEST_CSV_FILE_PATH, objName));

		lookUpADLUri = String.format(lookUpADLUri, objName);

		// create Request Header
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", "TD1 8/384593dfaf84163505f1024f9f9825a64b0bba99");
		HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);

		if (objName.equalsIgnoreCase("personas")) {
			ResponseEntity<Persona> responseEntity = null;
			List<ResponseEntity<Persona>> personaObjList = new ArrayList<>();
			List<Persona> personaObjList2 = new ArrayList<>();
			for (String id : arr) {
				lookUpADLUri2 = lookUpADLUri + id;
				System.out.println("URI -> " + lookUpADLUri2);
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Persona.class);
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
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Identities.class);
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
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity,
						DeviceResponseMapper.class);
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
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Cases.class);
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
				responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Orders.class);
				ordersResponseList.add(responseEntity);
			}
			for (ResponseEntity<Orders> ordersObj : ordersResponseList) {
				ordersResponseList2.add(ordersObj.getBody());
				System.out.println("The Orders Response Object --> " + ordersObj.getBody());
			}
			// Write Response to CSV File
			readWriteCSV.writeToCsv(ordersResponseList2, String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));
		}

		System.out.println(
				"--- Response Written to CSV available @ " + String.format(LOOKUP_API_RESPONSE_CSV_FILE_PATH, objName));
	}

}
