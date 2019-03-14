package com.pmi.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

/**
 * @author vikas.e.mishra
 *
 */
@Resource
public class ReadWriteCSV {

	public static void main(String[] args) {

		// String filePath = "C:/Users/vikas.e.mishra/Desktop/Temp/testWrite3.csv";
		// String filePath = "C:/CSVFiles/writeAPI/request/surveysOut.csv";
//		List<Identities> identitiesList = new ArrayList<Identities>();
//		List<Address> addressList = new ArrayList<Address>();
//		for (int i = 1; i <= 3; i++) {
//			Address address = new Address();
//			address.setAdditional_address_line_1("Additional_address_line_1" + i);
//			address.setAdditional_address_line_2("Additional_address_line_2" + i);
//			address.setAdditional_address_line_3("Additional_address_line_3" + i);
//			address.setAdditional_address_line_4("Additional_address_line_4" + i);
//			address.setAdditional_address_line_5("Additional_address_line_5" + i);
//			address.setCountry("India" + i);
//			address.setPostal_code("600" + i);
//			address.setAddress_type("address Type " + i);
//			address.setPreferred_shipping(true);
//			address.setPreferred_billing(false);
//			address.setCommunication_opt_in("communication_opt_in " + i);
//			addressList.add(address);
//		}
//
//		Identities identities = new Identities();
//		identities.setTd_c360_operation("merge");
//		identities.setLast_name("Test");
//		identities.setFirst_name("Test");
//		identities.setLogin_name("Test");
//		identities.setDate_of_birth("1978.10.09");
//		identities.setAddresses(addressList);
//		identities.setPhone_number("501502503.0");
//		identities.setEmail_address("Test66@pmi.com");
//		identities.setHome_country("Test66");
//		identities.setConsumer_type("Test66");
//
//		identitiesList.add(identities);
//		System.out.println("OBject List  --- " + identitiesList);
//		new ReadWriteCSV().writeToCsv(identitiesList, filePath);
//
//		System.out.println("Written " + filePath);

//		try {
//			//List list = new ReadWriteCSV().readCSVWithHeader(new Identities(), filePath);
//			List list = new ReadWriteCSV().readCSVWithHeader(new Surveys(), filePath);
//			int i = 0;
//			for (Object object : list) {
//				System.out.println(i);
//				System.out.println(object);
//				System.out.println("======");
//				i++;
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	// returning list of Object for CSVWriter
	public List<Object> readCSVWithHeader(Object obj, String filePath) throws IOException {
		Reader r = Files.newBufferedReader(Paths.get(filePath));
		CSVReader reader = new CSVReaderBuilder(r).build();

		HeaderColumnNameMappingStrategy beanStrategy = new HeaderColumnNameMappingStrategy();
		beanStrategy.setType(obj.getClass());

		CsvToBean csvToBean = new CsvToBean();
		List list1 = csvToBean.parse(beanStrategy, reader);

		reader.close();

		return list1;
	}

	public String[] getLookUpIdsFromCSV(String filePath) {
		List<String[]> records;
		String[] lookUpIds = null;
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(filePath));

			CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build(); // Skip header row

			records = csvReader.readAll();

			lookUpIds = new String[records.size()];
			int i = 0;
			for (String[] s : records) {
				lookUpIds[i] = s[0];
				i++;
			}

			csvReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lookUpIds;
	}

	// Write a List of Object to CSV file
	public void writeToCsv(List objList, String filePath) {

		try {
			File file = new File(filePath);
			file.createNewFile();
			FileWriter writer = new FileWriter(filePath);

			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

			beanToCsv.write(objList); // Write list to StatefulBeanToCsv object

			writer.close();// closing the writer object

		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			e.printStackTrace();
		}

	}

	// override method - Write Single Object
	public void writeToCsv(Object obj, String filePath) {

		try {
			File file = new File(filePath);
			file.createNewFile();
			FileWriter writer = new FileWriter(filePath);

			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

			beanToCsv.write(obj); // Write Single Object to StatefulBeanToCsv

			writer.close();// closing the writer object

		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			e.printStackTrace();
		}

	}
}
