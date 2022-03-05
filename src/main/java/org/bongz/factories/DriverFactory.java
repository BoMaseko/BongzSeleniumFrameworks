package org.bongz.factories;

import java.net.URL;

import org.bongz.enums.ConfigProperties;
import org.bongz.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {
	
	private DriverFactory() {}
	
	public static WebDriver getDriver(String browser, String version) throws Exception  {
		
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
			//WebDriverManager.chromedriver().setup(); //executables ?? why not needed when executing in remote
			if(PropertyUtils.getPropertyValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				cap.setVersion(version);
				cap.setCapability( "se:recordVideo", "true");
				System.out.println("Test started successfully with " + cap.getBrowserName());
				driver = new RemoteWebDriver(new URL(PropertyUtils.getPropertyValue(ConfigProperties.SELENIUMGRIDURL)), cap);
				System.out.println("Test executed successfully with " + cap.getBrowserName());
			}else if(PropertyUtils.getPropertyValue(ConfigProperties.RUNMODE).equalsIgnoreCase("selenoid")) {
				/*
				
				 * cap.setBrowserName(BrowserType.CHROME); 
				 * cap.setVersion(version);
				 */
				
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability("browserName", "chrome");
				cap.setCapability("browserVersion", "98.0");
				cap.setCapability("enableVNC", true);
				cap.setCapability("enableVideo", false);
				cap.setCapability("enableLog", true);
				cap.setCapability("videoName", "bongz_v1.mp4");
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				driver = new RemoteWebDriver(new URL(PropertyUtils.getPropertyValue(ConfigProperties.SELENIUMGRIDURL)), cap);
			
			}
			
			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		}else if (browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
			//WebDriverManager.firefoxdriver().setup();
			if(PropertyUtils.getPropertyValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);
				cap.setVersion(version);
				cap.setCapability( "se:recordVideo", "false");
				driver = new RemoteWebDriver(new URL(PropertyUtils.getPropertyValue(ConfigProperties.SELENIUMGRIDURL)), cap);
			}else
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				
			}
		}
		else if (browser.equalsIgnoreCase("edge")) {
			
			if(PropertyUtils.getPropertyValue(ConfigProperties.RUNMODE).equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.EDGE);
				cap.setVersion(version);
				cap.setCapability( "se:recordVideo", "false");
				driver = new RemoteWebDriver(new URL(PropertyUtils.getPropertyValue(ConfigProperties.SELENIUMGRIDURL)), cap);
			}else
			{
				WebDriverManager.edgedriver().setup();
				
				
			}
		}
		return driver;
	}

}
