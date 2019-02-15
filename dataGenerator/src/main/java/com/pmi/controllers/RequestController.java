package com.pmi.controllers;

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

		// TODO here call ADL lookup API based on different object Name and primary Key
		invokeRestService.callADLLookupAPI(objName);

		return "lookUpIdAPI objName is " + objName;
	}

	@RequestMapping("/writeAPI")
	public Object writeAPI(@RequestParam(value = "objName", defaultValue = "personas") String objName) {

		// TODO here call ADL lookup API based on different object Name and primary Key

		return "writeAPI objName is " + objName;
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