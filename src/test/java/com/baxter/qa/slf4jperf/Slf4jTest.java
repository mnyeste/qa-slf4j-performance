package com.baxter.qa.slf4jperf;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jTest {

	private static Logger logger = LoggerFactory.getLogger(Slf4jTest.class);
	private static final int LOG_ENTRIES = 100000;
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
				logger.info("Debug message no." + i + " UUID: " + logString);
		}
	}
	
	@Test
	public void testLogParametrized() {
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			logger.info("Info message no.{} UUID: {}", i, logString);
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

	@Test
	public void testNoLogParametrized() {
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			logger.debug("Info message no.{} UUID: {}", i, logString);
		}
	}
}
