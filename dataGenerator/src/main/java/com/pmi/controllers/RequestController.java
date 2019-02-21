package com.pmi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmi.services.InvokeRestService;

/**
 * @author vikas.e.mishra
 *
 */
@RestController
public class RequestController {

	@Autowired
	private InvokeRestService invokeRestService;

	@RequestMapping("/lookUpIdAPI")
	public Object lookUpById(@RequestParam(value = "objName", defaultValue = "personas") String objName) {
		System.out.println("ID Lookup API: Object Name passesd: " + objName);
		// TODO here call ADL lookup API based on different object Name
		Object apiResponse = invokeRestService.callADLLookupAPI(objName);

		return "SUCCESS: Here is the response from Lookup API call, List of " + objName + " object --> " + apiResponse;
	}

	@RequestMapping("/writeAPI")
	public Object writeAPI(@RequestParam(value = "objName", defaultValue = "personas") String objName,
			@RequestParam(value = "source", defaultValue = "csv") String source) {

		// TODO here call ADL lookup API based on different object Name
		System.out.println("Write API: Object Name passesd: " + objName);
		System.out.println("Write API: Source passesd: " + source);
		List<Object> apiResponse = invokeRestService.callADLBulkWriteAPI(objName);
		return "SUCCESS: Here is the response from Write API call, List of "+objName+" object --> " + apiResponse;
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