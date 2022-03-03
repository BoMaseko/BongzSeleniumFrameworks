package org.bongz.reports;

import org.bongz.enums.ConfigProperties;
import org.bongz.utils.PropertyUtils;
import org.bongz.utils.ScreenshotUtils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;





public final class ExtentLogger {

	private ExtentLogger(){}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}
	
	  public static void pass(Markup message) {
	        ExtentManager.getExtentTest().pass(message);
	    }

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}
	
	  public static void fail(Markup message) {
	        ExtentManager.getExtentTest().fail(message);
	    }

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}
	
    public static void skip(Markup message) {
        ExtentManager.getExtentTest().skip(message);
    }

	public static void info(Markup message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}


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

	public static void fail(String message, boolean isScreenShotNeeded) throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreenShotNeeded) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		}	else {
			fail(message);
		}
	}

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
		if(PropertyUtils.getPropertyValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreeshotNeeded) {
			
			 ExtentManager.getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	            ExtentManager.getExtentTest().fail(message);
		}
		else {
			fail(message);
		}
		
	}
	
	public static void skip(Markup message, boolean isScreeshotNeeded) throws Exception {
		if(PropertyUtils.getPropertyValue(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes") 
				&& isScreeshotNeeded) {
			
			 ExtentManager.getExtentTest().skip(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	            ExtentManager.getExtentTest().skip(message);
		}
		else {
			skip(message);
		}
		
	}


}
