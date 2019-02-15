package com.pmi.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * @author vikas.e.mishra
 *
 */
@Resource
public class ReadWriteCSV {
	private static final String SAMPLE_CSV_FILE_PATH = "src/main/resources/static/csv/idLookUp_%s.csv";

	public static void main(String[] args) {
		String[] arr = new ReadWriteCSV().getLookUpIdsFromCSV("cases");
		for (String string : arr) {
			System.out.println(string);
		}
	}

	public String[] getLookUpIdsFromCSV(String objName) {
		List<String[]> records;
		String[] lookUpIds = null;
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(String.format(SAMPLE_CSV_FILE_PATH, objName)));

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
}
