package com.pmi.services;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author vikas.e.mishra
 *
 */
@Component
public class DataGenService {

	@Autowired
	private DataFactory dataFactory;

	public void generateRandomData() {

		for (int i = 0; i < 10; i++) {
			System.out.println(dataFactory.getFirstName() + " " + dataFactory.getLastName());
		}
	}
}
