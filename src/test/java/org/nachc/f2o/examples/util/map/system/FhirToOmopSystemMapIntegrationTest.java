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
		String msg = "vocabulary_id,vocabulary_code,system\n";
		for(String key : keys) {
			String[] value = FhirToOmopSystemMap.getCodeAndId(key);
			String code = StringUtils.rightPad(value[0], 15);
			String name = StringUtils.rightPad(value[1], 15);
			msg += code.trim() + "," + name.trim() + "," + key.trim() + "\n";
			log.info("\t" + code + name  + key);
		}
		log.info("Got " + keys.size() + " mappings.");
		log.info("Comma delimited: \n" + msg);
		log.info("Got " + keys.size() + " mappings.");
		log.info("Done.");
	}
	
}
