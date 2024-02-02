package org.nachc.f2o.examples.util.props;

import java.io.File;
import java.util.Properties;

import javax.batch.operations.BatchRuntimeException;

import com.nach.core.util.file.FileUtil;
import com.nach.core.util.props.PropertiesUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class F2OExamplesAppProps {

	//
	// static variables
	//

	private static final String SRC = "app.properties";

	private static File PARAMS_FILE;

	private static Properties PROPS = null;

	static {
		File file = FileUtil.getFile(SRC);
		log.info("exists: " + file);
		log.info("Got properties file: " + FileUtil.getCanonicalPath(file));
		PARAMS_FILE = file;
		PROPS = PropertiesUtil.getAsProperties(file);
		log.info("Done with init.");
	}

	//
	// methods to get properties
	//

	private static Properties getProps() {
		return PROPS;
	}

	public static String get(String key) {
		try {
			return PROPS.getProperty(key);
		} catch (Throwable thr) {
			log.info("Could not load property: " + key);
			log.info("PROPS: " + PROPS);
			throw new BatchRuntimeException("Could not load property", thr);
		}
	}

	//
	// methods to get specific properties
	//

	public static String getJdbcUrl() {
		return get("JdbcUrl");
	}

}
