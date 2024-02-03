package org.nachc.f2o.examples.util.map.code;

import java.sql.Connection;

import org.nachc.f2o.examples.util.map.system.FhirToOmopSystemMap;
import org.yaorma.database.Data;
import org.yaorma.database.Database;
import org.yaorma.database.Row;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FhirCodingToOhdsiCode {

	public static String getConceptId(String system, String code, Connection conn) {
		try {
			// get the vocabulary_id from the system string
			log.info("looking for ohdsi concept for FHIR coding: ");
			log.info("\tsystem: " + system);
			log.info("\tcode: " + code);
			String vocabularyId = getVocabularyId(system);
			log.info("vocabularyId: " + vocabularyId);
			if(vocabularyId == null) {
				// return null for unknown vocabulary id
				return null;
			} else {
				// get the concept from the concept table
				String[] params = {vocabularyId, code};
				String sqlString = "select * from concept where vocabulary_id = ? and concept_code = ?";
				Data data = Database.query(sqlString, params, conn);
				if(data.size() > 0) {
					Row row = data.get(0);
					String rtn = row.get("conceptId");
					return rtn;
				} else {
					return null;
				}
			}
		} catch(Exception exp) {
			throw new RuntimeException (exp);
		}
	}
	
	private static String getVocabularyId(String system) {
		String rtn = FhirToOmopSystemMap.getValue(system);
		return rtn;
	}

}
