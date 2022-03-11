package org.bongz.reports;


import static org.bongz.constants.FrameworkConstants.*;
import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import org.bongz.constants.FrameworkConstants;
import org.bongz.enums.CategoryType;
import org.bongz.utils.BrowserInfoUtils;
import org.bongz.utils.IconUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 *  Perform initialisation and termination of {@link com.aventstack.extentreports.ExtentReports}<p>
 * After creating an instance for {@link com.aventstack.extentreports.ExtentTest}, <p>it is delegated to ThreadLocal 
 * variable for providing thread safety.<p>
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 *@implNote public final -> We do not want any class to extend this class
 ** @see org.bongz.listeners.ListenerClass
 * @see org.bongz.annotations.FrameworkAnnotation
 */

public final class ExtentReport {

	//private -> We do not want anyone to create the object of this class
	private ExtentReport() {

	}

	private static ExtentReports extent;


	/**
	 * Set the initial configuration for the Extent Reports and decides the report generation path.
	 * 
	 * @author Bongz
	 * @throws Exception
	 */
	public static void initReport() throws Exception {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setReportName("Bongz Automation Labz - Training");
			spark.config().setDocumentTitle("Bongz Automation Learningz");


			extent.setSystemInfo("Organization", "Bongz Automation Labz");
			extent.setSystemInfo("Domain", "Engineering (IT - Software)" + "  " +
					ICON_LAPTOP); extent.setSystemInfo("Skill", "Test Automation Engineer");
					extent.setSystemInfo("Employee", "<a href=" + ICON_SOCIAL_GITHUB_PAGE_URL +
							"> <b> Bongani Maseko </b> </a>" + " " + ICON_SOCIAL_LINKEDIN + " " +
							ICON_SOCIAL_GITHUB);

		}
	}

	/**
	 * Flushing the reports ensures extent logs are reflected properly. 
	 * Opens the report in the default desktop browser.
	 * Sets the ThreadLocal variable to default value
	 * 
	 * @author Bongz
	 * @throws Exception
	 */
	public static void flushReports() throws Exception {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		//Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}

	/**
	 *  Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
	 * 
	 * @author Bongz
	 * @param testcasename
	 */
	public static void createTest(String testcasename) {
		//ExtentManager.setExtentTest(extent.createTest(testcasename));
		ExtentManager.setExtentTest(extent.createTest(IconUtils.getBrowserIcon() + " : " + testcasename));
	}

	/**
	 * Logs the authors details in the authors view in the extent report.
	 * Gives an clear idea of Authors Vs Percentage success metrics
	 * 
	 * @author Bongz
	 * @param authors Authors who created a particular test case
	 */
	public static void addAuthors(String[] authors) {

		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}

	/**
	 * Adds the category a particular test case belongs to.
	 * Gives an clear idea of Group Vs Percentage success metrics.
	 * 
	 * @author Bongz
	 * @param categories category a particular test case belongs to.
	 
	 */
	synchronized public static void addcategories(CategoryType[] categories) {
		for(CategoryType temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}
	
	synchronized public static void addDevice() {
		ExtentManager.getExtentTest().assignDevice(BrowserInfoUtils.getBrowserInfo());
		//ExtentManager.getExtentTest().assignDevice(BrowserIconUtils.getBrowserIcon() + " : " + BrowserInfoUtils.getBrowserInfo());
	}
	
	
}
