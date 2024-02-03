package org.nachc.f2o.examples.util.map.code;

import java.sql.Connection;

import org.junit.Test;
import org.nachc.f2o.examples.util.connection.ConnectionFactory;
import org.yaorma.database.Database;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FhirCodingToOhdsiCodeIntegrationTest {

	@Test
	public void shouldGetCode() {
		log.info("Starting test...");
		Connection conn = ConnectionFactory.getConnection();
		log.info("Got connection.");
		try {
			log.info("Getting concept id...");
			String system = "http://loinc.org";
			String code = "51990-0";
			String conceptId = FhirCodingToOhdsiCode.getConceptId(system, code, conn);
			log.info("Got concept id: " + conceptId);
			log.info("Done.");
		} finally {
			Database.close(conn);
		}
	}
	
}

