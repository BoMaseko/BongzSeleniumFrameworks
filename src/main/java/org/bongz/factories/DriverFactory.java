package org.bongz.factories;

import java.net.URL;

import org.bongz.enums.ConfigProperties;
import org.bongz.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {}

	public static WebDriver getDriver(String browser, String version) throws Exception {

		WebDriver driver = null;
		String runMode = PropertyUtils.getPropertyValue(ConfigProperties.RUNMODE);
		String gridUrl = PropertyUtils.getPropertyValue(ConfigProperties.SELENIUMGRIDURL);
		// Ensure grid URL ends with /wd/hub for Selenium 4 compatibility
		if (!gridUrl.endsWith("/wd/hub")) {
			gridUrl = gridUrl.replaceAll("/$", "") + "/wd/hub";
		}

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (runMode.equalsIgnoreCase("remote")) {
				// Don't set browser version for remote - let the Grid assign available node
				System.out.println("Connecting to Grid: " + gridUrl);
				driver = new RemoteWebDriver(new URL(gridUrl), options);
				System.out.println("Test executed successfully with chrome");
			} else if (runMode.equalsIgnoreCase("selenoid")) {
				options.setBrowserVersion("98.0");
				options.setCapability("selenoid:options", java.util.Map.of(
					"enableVNC", true, "enableVideo", false, "enableLog", true
				));
				options.setAcceptInsecureCerts(true);
				driver = new RemoteWebDriver(new URL(gridUrl), options);
			} else {
				System.out.println("Test started via chrome locally!!");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if (runMode.equalsIgnoreCase("remote")) {
				System.out.println("Connecting to Grid: " + gridUrl);
				driver = new RemoteWebDriver(new URL(gridUrl), options);
				System.out.println("Test executed successfully with firefox");
			} else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(options);
			}
		} else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			if (runMode.equalsIgnoreCase("remote")) {
				System.out.println("Connecting to Grid: " + gridUrl);
				driver = new RemoteWebDriver(new URL(gridUrl), options);
				System.out.println("Test executed successfully with edge");
			} else {
				System.out.println("Test started via edge locally!!");
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver(options);
			}
		}
		return driver;
	}
}
