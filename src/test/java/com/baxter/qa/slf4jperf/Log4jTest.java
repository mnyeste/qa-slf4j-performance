package com.baxter.qa.slf4jperf;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {

	private static Logger logger = Logger.getLogger(Log4jTest.class);
	private static final int LOG_ENTRIES = 10000;
	private static String logString = UUID.randomUUID().toString();

	@Test
	public void testBaseLogging() {
		logger.info("Info message");
		logger.debug("Debug message");
	}

	@Test
	public void testLogStringConcat() {
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			logger.info("Info message no." + i + " UUID: " + logString);
		}
	}

	@Test
	public void testLogExtraIfStringConcat() {
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			if (logger.isInfoEnabled())
				logger.info("Info message no." + i + " UUID: " + logString);
		}
	}
	
	@Test
	public void testNoLogStringConcat() {
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			logger.debug("Debug message no." + i + " UUID: " + logString);
		}
	}

	@Test
	public void testNoLogExtraIfStringConcat() {
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			if (logger.isDebugEnabled())
				logger.debug("Debug message no." + i + " UUID: " + logString);
		}
	}

}
