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

//final -> We do not want any class to extend this class
public final class ExtentReport {

	//private -> We do not want anyone to create the object of this class
	private ExtentReport() {

	}

	private static ExtentReports extent;


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

	public static void flushReports() throws Exception {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}

	public static void createTest(String testcasename) {
		//ExtentManager.setExtentTest(extent.createTest(testcasename));
		ExtentManager.setExtentTest(extent.createTest(IconUtils.getBrowserIcon() + " : " + testcasename));
	}

	public static void addAuthors(String[] authors) {

		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}

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
