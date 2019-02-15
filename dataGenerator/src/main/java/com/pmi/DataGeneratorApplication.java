package com.pmi;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

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
		
		System.out.println("Calling ADL Look-up Service");
		invokeRestService.callADLLookupAPI("personas");

	}

}
