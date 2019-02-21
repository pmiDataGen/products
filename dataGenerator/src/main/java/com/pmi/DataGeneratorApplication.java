package com.pmi;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.pmi.pojo.Persona;
import com.pmi.pojo.Identities;
import com.pmi.pojo.PersonaRequest;
import com.pmi.pojo.Cases;
import com.pmi.pojo.Orders;
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

		// Write API - Personas
		Persona persona = new Persona();
		persona.setOnline_access_flag(false);
		persona.setPersona_id("66");
		persona.setFirst_name("Test");
		persona.setLast_name("Test");
		persona.setFull_name("Test");
		persona.setName("Test");
		persona.setPhone("66");
		persona.setEmail("test@pmi.com");
		persona.setGender("M");
		persona.setHome_country("Test");
		persona.setIs_deleted(false);
		persona.setBlocked_flag(false);
		persona.setConsumer_type("Test");
		persona.setDate_of_birth("1548716400000.0");
		persona.setSegment("Smoker");
		persona.setRegistration_date(66);
		persona.setFirst_login_date("1548716400000.0");
		persona.setLast_update_date("1548716400000.0");
		persona.setLast_login_date("1548716400000.0");
		persona.setOnline_access_flag(false);
		persona.setPrimary_log_in("Test");
		persona.setSystem_last_update("1548716400000.0");
		persona.setLast_Activity_since_days(6);
		persona.setLast_Activity_since_months(9);
		persona.setAge(66);
		persona.setAge_group("test");
		persona.setRecency_score(66);
		persona.setFrequency_score(66);
		persona.setValue_score(66);
		persona.setLast_case_category_name("Test");
		persona.setLast_case_start_date("1548716400000.0");
		persona.setLast_case_status_code("Test");
		persona.setNb_cases_close(6);
		persona.setNb_cases_close_1m(66);
		persona.setNb_cases_close_2m(66);
		persona.setNb_cases_close_3m(66);
		persona.setNb_cases_close_6m(66);
		persona.setNb_cases_close_12m(66);
		persona.setNb_cases_open(66);
		persona.setNb_cases_open_1m(66);
		persona.setNb_cases_open_2m(66);
		persona.setNb_cases_open_3m(66);
		persona.setNb_cases_open_6m(66);
		persona.setNb_cases_open_12m(66);
		persona.setNb_active_chargers(66);
		persona.setLimited_edition("Test");
		persona.setNb_of_devices(66);
		persona.setNb_of_devices_replaced(66);
		persona.setNb_of_holders(66);
		persona.setLatest_version_of_device("Test");
		persona.setNumber_of_heet(66);
		persona.setLifetime_revenue(66);
		persona.setFirst_purchase_date(154871);
		persona.setLast_order_date(1234);
		persona.setNumber_of_accessories(66);
		persona.setNb_order(66);
		persona.setNb_order_average_per_month(66);
		persona.setRegistration_first_order_difference_day(66);
		persona.setSecond_order_difference_days(66);
		persona.setTotal_spending_per_month_in_average(66);
		persona.setCnt_orders(66);
		persona.setCnt_orders_l12m(66);
		persona.setCnt_orders_l3m(66);
		persona.setCnt_orders_l6m(66);
		persona.setRevenue_ytd(66);
		persona.setRevenue_l3m(66);
		persona.setRevenue_l6m(66);
		persona.setRevenue_l12m(66);
		
		invokeRestService.callADLWriteAPI("personas", persona);

		
		  // Write API - PersonasRequest
		 /* 
		  PersonaRequest persona = new PersonaRequest();
		  persona.setTd_c360_operation("put"); persona.setPersona_id("100");
		  persona.setLast_name("mishra"); persona.setFirst_name("vikas");
		  persona.setGender("male"); persona.setHome_country("india");
		  
		  invokeRestService.callADLWriteAPI("personas", persona);
		 */

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

		// Write API - Cases
		/*
		 * Cases cases = new Cases(); cases.setTd_c360_operation("put");
		 * cases.setPersona_id("66"); cases.setCase_id("66");
		 * cases.setSerial_numer("66"); cases.setOrder_id("66");
		 * cases.setClosing_date("1548716400000.0"); cases.setCase_Channel("Test");
		 * cases.setCreate_date("1548716400000.0"); cases.setCase_source("Test");
		 * cases.setCase_type("Test"); cases.setCase_Subtype("Test");
		 * cases.setStatus("Test"); cases.setDescription("Test");
		 * cases.setSubject_code(66); cases.setSubject_description(66);
		 * cases.setLatest_update_date("Test"); cases.setHome_country("Test");
		 * 
		 * invokeRestService.callADLWriteAPI("cases", cases);
		 */
		
		//Write API - Orders
		/*
		 * Orders orders = new Orders(); orders.setTd_c360_operation("put");
		 * orders.setPersona_id("66"); orders.setOrder_id("66");
		 * orders.setOrder_item_identifier("66"); orders.setOrder_items("66");
		 * orders.setCountry("Test"); orders.setOrder_amount(66);
		 * orders.setOrder_discount(66); orders.setOrder_type("test");
		 * orders.setOrder_status("test"); orders.setOrder_date("1548716400000.0");
		 * orders.setOrder_currency("Test"); orders.setItem_identifier("66");
		 * orders.setProduct_variant("test"); orders.setItem_description("test");
		 * orders.setItem_price(66); orders.setItem_quantity(66);
		 * orders.setHome_country("test"); orders.setStatus("test");
		 * 
		 * invokeRestService.callADLWriteAPI("orders", orders);
		 * 
		 */  
	}

}
