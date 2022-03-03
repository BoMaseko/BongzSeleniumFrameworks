package org.bongz.tests;

import java.util.Map;

import org.bongz.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected BaseTest() {
		
	}
	
	
	@BeforeMethod
	protected void setUp(Object[] data) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)data[0];
		Driver.initDriver(map.get("browser"), map.get("version"));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
