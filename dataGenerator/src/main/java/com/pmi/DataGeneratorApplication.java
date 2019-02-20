package com.pmi;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.pmi.pojo.Identities;
import com.pmi.pojo.PersonaRequest;
import com.pmi.services.DataGenService;
import com.pmi.services.InvokeRestService;
import com.pmi.util.ReadWriteCSV;

/**
 * @author vikas.e.mishra
 *
 */
@SpringBootApplication
public class DataGeneratorApplication {

	@Bean
	public DataFactory adlDataFactory() {
		return new DataFactory();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public HttpHeaders createHttpHeaders() {
		return new HttpHeaders();
	}

	@Bean
	public ReadWriteCSV readWriteCSV() {
		return new ReadWriteCSV();
	}

	public static void main(String[] args) {
		System.out.println("=================Starting Spring Container===============");
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DataGeneratorApplication.class, args);
		System.out.println("=================Spring Container Ready===============");

		DataGenService dataGenService = applicationContext.getBean(DataGenService.class);
		dataGenService.generateRandomData();

		System.out.println("Calling rest Service");
		InvokeRestService invokeRestService = applicationContext.getBean(InvokeRestService.class);
		invokeRestService.callDemoService();

		// Read API
		// System.out.println("Calling ADL Look-up Service");
		// invokeRestService.callADLLookupAPI("personas");
		// invokeRestService.callADLLookupAPI("identities");
		// invokeRestService.callADLLookupAPI("devices");
		// invokeRestService.callADLLookupAPI("cases");
		// invokeRestService.callADLLookupAPI("orders");

		// Write API - Persona
		PersonaRequest persona = new PersonaRequest();
		persona.setTd_c360_operation("put");
		persona.setPersona_id("100");
		persona.setLast_name("mishra");
		persona.setFirst_name("vikas");
		persona.setGender("male");
		persona.setHome_country("india");
		invokeRestService.callADLWriteAPI("personas", persona);

		// Write API - Identities
		/*
		 * Identities identities = new Identities();
		 * identities.setTd_c360_operation("merge"); identities.setIdentity_id("166");
		 * identities.setPersona_id("166"); identities.setLast_name("Test");
		 * identities.setFirst_name("Test"); identities.setLogin_name("Test");
		 * identities.setFull_name("Test66"); //identities.setNick_name("Test66"); //
		 * identities.setDate_of_birth("1978.10.09"); //
		 * identities.setAddress("US, Los Angeles, 1st Alley"); //
		 * identities.setPhone_number("501502503.0"); //
		 * identities.setEmail("Test66@pmi.com"); //identities.setGender("M"); //
		 * identities.setHome_country("Test66"); //identities.setBlocked_flag(false); //
		 * identities.setIs_deleted(false); //
		 * identities.setRegistration_date("1548716400000.0"); //
		 * identities.setRegistration_source_app("Test66"); //
		 * identities.setRegistration_country("Test66"); //
		 * identities.setRegistration_referal_identifier("Test66"); //
		 * identities.setConsumer_type("Test66"); //
		 * identities.setPreferred_language("Test66"); //
		 * identities.setSegment("Test66"); //
		 * identities.setLast_login_date("1548716400000.0");
		 * 
		 * invokeRestService.callADLWriteAPI("identities", identities);
		 */

	}

}
