package org.bongz.utils;

import org.bongz.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Utility to take base64 screenshot.<p>
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public final class ScreenshotUtils {

	private ScreenshotUtils() {}
	
	/**
	 * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.<p>
	 * There is no temporary screenshot image generated here. <p>
	 * If user needs separate screenshot image, they can construct
	 * a new method. It is advisable to use this method for many reasons.
	 * 
	 *@author Bongz
	 * @return Image in the form of Base64 String which can be appended directly to report
	 */
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
