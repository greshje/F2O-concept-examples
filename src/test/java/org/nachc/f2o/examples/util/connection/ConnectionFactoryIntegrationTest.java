package org.nachc.f2o.examples.util.connection;

import java.sql.Connection;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionFactoryIntegrationTest {

	@Test
	public void shouldGetConnection() {
		log.info("Starting test...");
		Connection conn = ConnectionFactory.getConnection();
		log.info("Got connection: " + conn);
		log.info("Done.");
	}

}
