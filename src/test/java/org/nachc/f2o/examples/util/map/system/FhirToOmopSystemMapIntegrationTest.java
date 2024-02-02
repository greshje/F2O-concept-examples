package org.nachc.f2o.examples.util.map.system;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FhirToOmopSystemMapIntegrationTest {

	@Test
	public void shouldGetProperties() {
		log.info("Getting properties...");
		ArrayList<String> keys = FhirToOmopSystemMap.getKeys();
		log.info("Got " + keys.size() + " mappings.");
		for(String key : keys) {
			String value = FhirToOmopSystemMap.getValue(key);
			log.info("\t" + StringUtils.rightPad(value, 15) + key);
		}
		log.info("Got " + keys.size() + " mappings.");
		log.info("Done.");
	}
	
}
