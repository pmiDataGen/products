package com.pmi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public Object lookUpById(@RequestParam(value = "objName", defaultValue = "personas") String objName) {
		logger.info("ID Lookup API: Object Name passesd: " + objName);
		Object apiResponse = invokeRestService.callADLLookupAPI(objName);

		// return "SUCCESS: Here is the response from Lookup API call, List of " +
		// objName + " object --> " + apiResponse;
		return apiResponse;
	}

	@RequestMapping("/writeAPI")
	public Object writeAPI(@RequestParam(value = "objName", defaultValue = "personas") String objName,
			@RequestParam(value = "source", defaultValue = "csv") String source) {

		logger.info("Write API: Object Name passesd: " + objName);
		logger.info("Write API: Source passesd: " + source);
		Object apiResponse = invokeRestService.callADLBulkWriteAPI(objName);
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

		return "searchAPI objName is " + objName;
	}
}