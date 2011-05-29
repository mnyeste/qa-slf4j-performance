package com.baxter.qa.slf4jperf;

import static org.junit.Assert.*;

import java.util.UUID;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class Log4jTest {

	private static Logger logger = Logger.getLogger(Log4jTest.class);
	private static final int LOG_ENTRIES = 10000;
	private static String logString = UUID.randomUUID().toString();

	@BeforeClass
	public static void setUp() {
		BasicConfigurator.configure();
	}

	@Test
	public void testBaseLogging() {
		logger.setLevel(Level.INFO);
		logger.info("Info message");
		logger.debug("Debug message");
	}

	@Test
	public void testLogStringConcat() {
		logger.setLevel(Level.INFO);
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			logger.info("Info message no." + i + " UUID: " + logString);
		}
	}

	@Test
	public void testNoLogStringConcat() {
		logger.setLevel(Level.INFO);
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			logger.debug("Debug message no." + i + " UUID: " + logString);
		}
	}

	@Test
	public void testNoLogExtraIfStringConcat() {
		logger.setLevel(Level.INFO);
		for (int i = 1; i <= LOG_ENTRIES; ++i) {
			if (logger.getLevel() == Level.DEBUG)
				logger.debug("Debug message no." + i + " UUID: " + logString);
		}
	}

}
