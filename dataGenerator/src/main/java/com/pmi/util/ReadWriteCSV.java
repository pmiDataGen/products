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
import com.pmi.pojo.Orders;

/**
 * @author vikas.e.mishra
 *
 */
@Resource
public class ReadWriteCSV {

	public static void main(String[] args) {
		Orders order = new Orders();
		String filePath = "C:/CSVFiles/writeAPI/request/writeAPI_request_orders.csv";
		try {
			List list = ReadWriteCSV.parseCSVWithHeader(order, filePath);
			int i = 0;
			for (Object object : list) {
				System.out.println(i);
				System.out.println(object);
				System.out.println("======");
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// returning list of Object for CSVWriter example demo data
	public static List<Object> parseCSVWithHeader(Object obj, String filePath) throws IOException {
		Reader r = Files.newBufferedReader(Paths.get(filePath));
		CSVReader reader = new CSVReaderBuilder(r).build();

		HeaderColumnNameMappingStrategy beanStrategy = new HeaderColumnNameMappingStrategy();
		beanStrategy.setType(obj.getClass());

		CsvToBean csvToBean = new CsvToBean();
		List list1 = csvToBean.parse(beanStrategy, reader);

		System.out.println("List is --> " + list1);
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

	// override method
	public void writeToCsv(Object obj, String filePath) {

		try {
			File file = new File(filePath);
			file.createNewFile();
			FileWriter writer = new FileWriter(filePath);

			StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

			beanToCsv.write(obj); // Write list to StatefulBeanToCsv object

			writer.close();// closing the writer object

		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			e.printStackTrace();
		}

	}
}
