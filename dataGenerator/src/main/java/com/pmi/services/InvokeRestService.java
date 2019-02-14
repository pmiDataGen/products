package com.pmi.services;

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

import com.pmi.pojo.Persona;
import com.pmi.pojo.Quote;

/**
 * @author vikas.e.mishra
 *
 */

@Component
public class InvokeRestService {

	private static final Logger log = LoggerFactory.getLogger(InvokeRestService.class);

	private static String demoRestUri = "http://gturnquist-quoters.cfapps.io/api/random;";

	private static String lookUpADLUri = "https://c360-api-a8-dce20.eu01.treasuredata.com/v1/events/c360/personas/1";

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HttpHeaders httpHeaders;

	public void callDemoService() {
		log.info("From property File -> " + demoRestUri);
		Quote quote = restTemplate.getForObject(demoRestUri, Quote.class);
		log.info(quote.toString());
		System.out.println(quote.toString());
	}

	public void callADLLookupAPI() {

		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", "TD1 8/384593dfaf84163505f1024f9f9825a64b0bba99");

		HttpEntity<String> entity = new HttpEntity<>("parameters", httpHeaders);

		ResponseEntity<Persona> responseEntity = restTemplate.exchange(lookUpADLUri, HttpMethod.GET, entity,
				Persona.class);
		System.out.println("The response is --> "+responseEntity.getBody());
	}
}
