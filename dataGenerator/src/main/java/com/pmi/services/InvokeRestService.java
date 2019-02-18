package com.pmi.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.pmi.pojo.Persona;
import com.pmi.pojo.Quote;
import com.pmi.util.ReadWriteCSV;

/**
 * @author vikas.e.mishra
 *
 */

//@Component
@Configuration
@PropertySource("file:application.properties")
public class InvokeRestService {

	private static final Logger log = LoggerFactory.getLogger(InvokeRestService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HttpHeaders httpHeaders;

	@Autowired
	private ReadWriteCSV readWriteCSV;

	//private static String demoRestUri = "http://gturnquist-quoters.cfapps.io/api/random;";
	 @Value("${demoRestUri}")
	    private String demoRestUri;

	 @Bean
	    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }

	// private static String lookUpADLUri =
	// "https://c360-api-a8-dce20.eu01.treasuredata.com/v1/events/c360/personas/1";

	private static String lookUpADLUri = "https://c360-api-a8-dce20.eu01.treasuredata.com/v1/events/c360/%s/";
	
	private static String lookUpADLUri2 = null;

	public void callDemoService() {
		Quote quote = restTemplate.getForObject(demoRestUri, Quote.class);
		log.info(quote.toString());
		System.out.println(quote.toString());
	}

	public void callADLLookupAPI(String objName) {

		String[] arr = readWriteCSV.getLookUpIdsFromCSV(objName);
		lookUpADLUri = String.format(lookUpADLUri, objName);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", "TD1 8/384593dfaf84163505f1024f9f9825a64b0bba99");
		ResponseEntity<Persona> responseEntity = null;
		List<ResponseEntity<Persona>> personaObjList = new ArrayList<>();
		HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);

		for (String id : arr) {
			lookUpADLUri2 = lookUpADLUri + id;
			System.out.println(lookUpADLUri2);
			responseEntity = restTemplate.exchange(lookUpADLUri2, HttpMethod.GET, entity, Persona.class);
			personaObjList.add(responseEntity);
		}

		for (ResponseEntity<Persona> personaObj : personaObjList) {
			System.out.println("The response is --> " + personaObj.getBody());
		}
		
	}
}
