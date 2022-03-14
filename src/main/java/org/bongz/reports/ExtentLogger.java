package org.bongz.reports;

import org.bongz.enums.ConfigProperties;
import org.bongz.utils.PropertyUtils;
import org.bongz.utils.ScreenshotUtils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;

/**
 *  Used for logging the events in the extent report.
 * <p>
 * Encapsulates the unnecessary methods from users<p>
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */



public final class ExtentLogger {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentLogger(){}

	/**
	 * Logs pass event in the extent report
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 */
	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	
	  public static void pass(Markup message) {
	        ExtentManager.getExtentTest().pass(message);
	    }

	  /**
	   * ogs fail event in the extent report
	 * @author Bongz
	 * @param message custom message that needs to be logged
	   */
	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	
	  public static void fail(Markup message) {
	        ExtentManager.getExtentTest().fail(message);
	    }

	  /**
	   * 
	   *Logs skip event in the extent report
	 * @author Bongz
	 * @param message custom message that needs to be logged
	   */
	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
    public static void skip(Markup message) {
        ExtentManager.getExtentTest().skip(message);
    }

    /**
     * 
     * Logs info event in the extent report
	 * @author Bongz
	 * @param message custom info that needs to be logged
     */
	public static void info(Markup message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	/**
	 * Logs pass event in the extent report based on user input in property file
	 * 
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 * @param isScreenshotNeeded appends screenshot when true ,ignore otherwise
	 */
	
	public static void pass(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenShotNeeded) {
			Thread.yield();
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}

	/**
	 * Logs fail event in the extent report based on user input in property file
	 * 
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 * @param isScreenshotNeeded appends screenshot when true ,ignore otherwise
	 */
	public static void fail(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}	else {
			fail(message);
		}
	}

	/**
	 * Logs skip event in the extent report based on user input in property file
	 * 
	 * @author Bongz
	 * @param message custom message that needs to be logged
	 * @param isScreenshotNeeded appends screenshot when true ,ignore otherwise
	 * @param message
	 * @param isScreenShotNeeded
	 * @throws Exception
	 */
	public static void skip(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}	else {
			skip(message);
		}
	}

	public static void pass(Markup message, boolean isScreeshotNeeded) throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreeshotNeeded) {
			
			 ExtentManager.getExtentTest().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	            ExtentManager.getExtentTest().pass(message);
		}
		else {
			pass(message);
		}
		
	}
	
	public static void fail(Markup message, boolean isScreeshotNeeded) throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreeshotNeeded) {
			
			 ExtentManager.getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	            ExtentManager.getExtentTest().fail(message);
		}
		else {
			fail(message);
		}
		
	}
	
	public static void skip(Markup message, boolean isScreeshotNeeded) throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreeshotNeeded) {
			
			 ExtentManager.getExtentTest().skip(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	            ExtentManager.getExtentTest().skip(message);
		}
		else {
			skip(message);
		}
		
	}


}
