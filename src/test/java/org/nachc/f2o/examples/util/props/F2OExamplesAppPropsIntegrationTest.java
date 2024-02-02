package org.nachc.f2o.examples.util.props;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class F2OExamplesAppPropsIntegrationTest {

	@Test
	public void shouldGetProperties() {
		log.info("Starting test...");
		String url = F2OExamplesAppProps.getJdbcUrl();
		log.info("Got JdbcUrl: " + url);
		log.info("Done.");
	}

}
