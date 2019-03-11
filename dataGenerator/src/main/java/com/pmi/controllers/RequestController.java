package com.pmi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmi.pojo.Address;
import com.pmi.pojo.Identities;
import com.pmi.services.DataGenService;
import com.pmi.services.InvokeRestService;

/**
 * @author vikas.e.mishra
 *
 */
@RestController
public class RequestController {

	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

	@Autowired
	private InvokeRestService invokeRestService;

	@Autowired
	private DataGenService dataGenService;

	@RequestMapping("/lookUpIdAPI")
	public Object lookUpById(@RequestParam(value = "objName", defaultValue = "personas") String objName,
			@RequestParam(value = "inputFileName", defaultValue = "notAvailable") String inputFileName) {
		logger.info("ID Lookup API: Object Name passesd: " + objName);
		logger.info("ID Lookup API: inputFileName passesd: " + inputFileName);
		Object apiResponse = invokeRestService.callADLLookupAPI(objName, inputFileName);

		// return "SUCCESS: Here is the response from Lookup API call, List of " +
		// objName + " object --> " + apiResponse;
		return apiResponse;
	}

	@RequestMapping("/writeAPI")
	public Object writeAPI(@RequestParam(value = "objName", defaultValue = "personas") String objName,
			@RequestParam(value = "inputFileName", defaultValue = "notAvailable") String inputFileName) {

		logger.info("Write API: Object Name passesd: " + objName);
		logger.info("Write API: inputFileName passesd: " + inputFileName);
		Object apiResponse = invokeRestService.callADLBulkWriteAPI(objName, inputFileName);
		// return "SUCCESS: Here is the response from Write API call, List of " +
		// objName + " object --> " + apiResponse;
		return apiResponse;
	}

	@RequestMapping(value = "/generateData", produces = { "application/json" })
	public Object generateData(@RequestParam(value = "objName", defaultValue = "personas") String objName,
			@RequestParam(value = "operationType", defaultValue = "merge") String operationType,
			@RequestParam(value = "primaryKeyStart", defaultValue = "0") Integer primaryKeyStart,
			@RequestParam(value = "primaryKeyEnd", defaultValue = "10") Integer primaryKeyEnd,
			@RequestParam(value = "outFileName", defaultValue = "NotAvailable") String outFileName,
			@RequestParam(defaultValue = "1") Integer numberOfObjects) {

		Object generatedDataList = dataGenService.generateRandomData(objName, operationType, numberOfObjects,
				primaryKeyStart, primaryKeyEnd, outFileName);
//		return "SUCCESS: Random Data is Generated for " + numberOfObjects + " " + objName + " object --> "
//				+ generatedDataList;
		return generatedDataList;
	}

	@RequestMapping("/checkWriteAPIConsistency")
	public Object checkDBWriteConsistencyTime(
			@RequestParam(value = "objName", defaultValue = "personas") String objName) {

		logger.info("Write API: Object Name passesd: " + objName);
		Object apiResponse = invokeRestService.testDataBaseConsistency(objName);
		// return "SUCCESS: Here is the response from Write API call, List of " +
		// objName + " object --> " + apiResponse;
		return apiResponse;
	}

	@RequestMapping("/queryAPI")
	public Object queryAPI(@RequestParam(value = "objName", defaultValue = "personas") String objName) {

		// TODO here call ADL lookup API based on different object Name and primary Key

		return "queryAPI objName is " + objName;
	}

	@RequestMapping("/searchAPI")
	public Object searchAPI(@RequestParam(value = "objName", defaultValue = "personas") String objName) {

		// TODO here call ADL lookup API based on different object Name and primary Key
		/*
		 * List<Address> addressList = new ArrayList<Address>(); for (int i = 0; i <= 1;
		 * i++) { Address address = new Address();
		 * address.setAdditional_address_line_1("Additional_address_line_1" + i);
		 * address.setAdditional_address_line_2("Additional_address_line_2" + i);
		 * address.setAdditional_address_line_3("Additional_address_line_3" + i);
		 * address.setAdditional_address_line_4("Additional_address_line_4" + i);
		 * address.setAdditional_address_line_5("Additional_address_line_5" + i);
		 * address.setCountry("India" + i); address.setPostal_code("600" + i);
		 * address.setAddress_type("address Type " + i);
		 * address.setPreferred_shipping(true); address.setPreferred_billing(false);
		 * address.setCommunication_opt_in("communication_opt_in " + i);
		 * addressList.add(address); }
		 * 
		 * Identities identities = new Identities();
		 * identities.setTd_c360_operation("merge"); identities.setLast_name("Test");
		 * identities.setFirst_name("Test"); identities.setLogin_name("Test");
		 * identities.setDate_of_birth("1978.10.09");
		 * identities.setAddress(addressList);
		 * identities.setPhone_number("501502503.0");
		 * identities.setEmail_address("Test66@pmi.com");
		 * identities.setHome_country("Test66"); identities.setConsumer_type("Test66");
		 */
		if (objName.equalsIgnoreCase("Identities")) {
			return dataGenService.createIdentitiesObject("merge", 510, 510);
		} else if (objName.equalsIgnoreCase("personas")) {
			return dataGenService.createPersonaObject("merge", 510, 511);
		} else if (objName.equalsIgnoreCase("cases")) {
			return dataGenService.createCasesObject("merge", 510, 511);
		} else if (objName.equalsIgnoreCase("devices")) {
			return dataGenService.createDeviceObject("merge", 510, 511);
		} else if (objName.equalsIgnoreCase("orders")) {
			return dataGenService.createOrdersObject("merge", 510, 511);
		} else {
			return "Please pass object name";
		}

	}
}