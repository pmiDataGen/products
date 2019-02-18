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
}
