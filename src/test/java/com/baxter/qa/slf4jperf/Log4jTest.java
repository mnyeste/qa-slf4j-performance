package com.baxter.qa.slf4jperf;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class Log4jTest {

	private static Logger logger = Logger.getLogger(Log4jTest.class);
	private static final int LOG_ENTRIES = 1000;

	@BeforeClass
	public static void setUp() {
		BasicConfigurator.configure();
	}

	@Test
	public void testBaseLogging() {
		logger.setLevel(Level.INFO);
		logger.info("Info log");
		logger.debug("Debug log");
		assertTrue(true);
	}

	@Test
	public void testLogStringConcat() {
		logger.setLevel(Level.INFO);
		for (int i=1; i<=LOG_ENTRIES; ++i){
			logger.info("Info message no." + i);
		}
	}
}
