package org.nachc.f2o.examples.util.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.nachc.f2o.examples.util.props.F2OExamplesAppProps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConnectionFactory {

	public static Connection getConnection() {
		try {
			String url = F2OExamplesAppProps.getJdbcUrl();
			log.info("Getting connection for url: \n" + url);
			Connection conn = DriverManager.getConnection(url);
			log.info("Got connection: " + conn);
			return conn;
		} catch (Exception exp) {
			throw (new RuntimeException(exp));
		}
	}

}
