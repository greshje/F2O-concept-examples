package org.nachc.f2o.examples.util.map.system;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.nach.core.util.file.FileUtil;
import com.opencsv.CSVReader;

public class FhirToOmopSystemMap {

	//
	// static variables
	//
	
	private static final File FILE = FileUtil.getFile("./map/omo-map.csv");

	private static final HashMap<String, String[]> MAP;
	
	static {
		try (CSVReader csvReader = new CSVReader(new FileReader(FILE))) {
			// skip the header row
			csvReader.readNext();
			// create the map
			MAP = new HashMap<String, String[]>();
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {
				if (nextLine.length >= 7) {
					String key = nextLine[2];
					String[] value = {nextLine[6], nextLine[0]};
					if(key != null && key.trim().length() > 0) {
						MAP.put(key, value);
					}
				}
			}
		} catch (Exception exp) {
			throw (new RuntimeException(exp));
		}
	}

	//
	// method to get the keys
	//
	
    public static ArrayList<String> getKeys() {
    	return new ArrayList<String>(MAP.keySet());
    }
    
    //
    // method to get a value and name
    //
    
	public static String[] getCodeAndId(String key) {
		String[] rtn = null;
		try {
			rtn = MAP.get(key);
			return rtn;
		} catch(Exception exp) {
			return null;
		}
	}
	
    //
    // method to get a value and name
    //
    
	public static String getValue(String key) {
		String[] rtn = null;
		try {
			rtn = MAP.get(key);
			if(rtn != null) {
				return rtn[1];
			} else {
				return null;
			}
		} catch(Exception exp) {
			return null;
		}
	}
	
}
