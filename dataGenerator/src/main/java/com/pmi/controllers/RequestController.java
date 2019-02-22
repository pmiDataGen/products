package com.pmi.controllers;

import java.util.List;

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

	@Autowired
	private InvokeRestService invokeRestService;

	@Autowired
	private DataGenService dataGenService;

	@RequestMapping("/lookUpIdAPI")
	public Object lookUpById(@RequestParam(value = "objName", defaultValue = "personas") String objName) {
		System.out.println("ID Lookup API: Object Name passesd: " + objName);

		Object apiResponse = invokeRestService.callADLLookupAPI(objName);

		// return "SUCCESS: Here is the response from Lookup API call, List of " +
		// objName + " object --> " + apiResponse;
		return apiResponse;
	}

	@RequestMapping("/writeAPI")
	public Object writeAPI(@RequestParam(value = "objName", defaultValue = "personas") String objName,
			@RequestParam(value = "source", defaultValue = "csv") String source) {

		System.out.println("Write API: Object Name passesd: " + objName);
		System.out.println("Write API: Source passesd: " + source);
		List<Object> apiResponse = invokeRestService.callADLBulkWriteAPI(objName);
		// return "SUCCESS: Here is the response from Write API call, List of " +
		// objName + " object --> " + apiResponse;
		return apiResponse;
	}

	@RequestMapping(value = "/generateData", produces = { "application/json" })
	public Object generateData(@RequestParam(value = "objName", defaultValue = "personas") String objName,
			@RequestParam(value = "operationType", defaultValue = "merge") String operationType,
			@RequestParam(required = true, defaultValue = "1") Integer numberOfObjects) {

		System.out.println("Generating Data: Object Name passesd: " + objName);
		System.out.println("Generating Data: Operation Type passesd: " + operationType);
		List<Object> generatedDataList = dataGenService.generateRandomData(objName, operationType, numberOfObjects);
//		return "SUCCESS: Random Data is Generated for " + numberOfObjects + " " + objName + " object --> "
//				+ generatedDataList;
		return generatedDataList;
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