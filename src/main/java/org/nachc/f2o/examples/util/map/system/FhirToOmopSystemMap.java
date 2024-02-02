package org.nachc.f2o.examples.util.map.system;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import com.nach.core.util.file.FileUtil;
import com.opencsv.CSVReader;

public class FhirToOmopSystemMap {

	//
	// static variables
	//
	
	private static final File FILE = FileUtil.getFile("./map/omo-map.csv");

	private static final Properties MAP;
	
	static {
		try (CSVReader csvReader = new CSVReader(new FileReader(FILE))) {
			// skip the header row
			csvReader.readNext();
			// create the properties
			Properties properties = new Properties();
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				if (nextLine.length >= 7) {
					String key = nextLine[2];
					String value = nextLine[6];
					if(key != null && key.trim().length() > 0) {
						properties.setProperty(key, value);
					}
				}
			}
			MAP = properties;
		} catch (Exception exp) {
			throw (new RuntimeException(exp));
		}
	}

	//
	// method to get the keys
	//
	
    public static ArrayList<String> getKeys() {
        ArrayList<String> keysList = new ArrayList<>();
        Enumeration<Object> keys = MAP.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            keysList.add(key.toString());
        }
        return keysList;
    }
    
    //
    // method to get a value
    //
    
	public static String getValue(String key) {
		String rtn = null;
		try {
			rtn = MAP.getProperty(key);
			return rtn;
		} catch(Exception exp) {
			return null;
		}
	}
	
}
