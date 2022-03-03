package org.bongz.driver;

import java.util.Objects;

import org.bongz.enums.ConfigProperties;
import org.bongz.factories.DriverFactory;
import org.bongz.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Driver {

	private Driver() {

	}


	public static void initDriver(String browser, String version) throws Exception {
		
		if(Objects.isNull(DriverManager.getDriver())) {
			
			DriverManager.setDriver(DriverFactory.getDriver(browser, version));
			DriverManager.getDriver().get(PropertyUtils.getPropertyValue(ConfigProperties.URL));
			//DriverManager.getDriver().get(JsonUtils.getPropertyValue(ConfigProperties.URL));
			
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().window().maximize();
			
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
