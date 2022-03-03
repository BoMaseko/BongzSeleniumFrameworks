package org.bongz.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



import org.bongz.driver.DriverManager;

public final class BrowserInfoUtils {

	private BrowserInfoUtils() {}
	
	public static String getBrowserInfo() {
		
		Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
		return cap.getBrowserName().toUpperCase();
	}
	
    public static String getOS_Browser_BrowserVersionInfo() {
    	Capabilities cap = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities();
        return OSInfoUtils.getOSInfo() + " & " + BrowserInfoUtils.getBrowserInfo() + " - "
                + cap.getVersion();

    }

}
