package org.bongz.listeners;


import static org.bongz.constants.FrameworkConstants.BOLD_END;
import static org.bongz.constants.FrameworkConstants.BOLD_START;
import static org.bongz.constants.FrameworkConstants.ICON_BUG;
import static org.bongz.constants.FrameworkConstants.ICON_Navigate_Right;
import static org.bongz.constants.FrameworkConstants.ICON_SMILEY_FAIL;
import static org.bongz.constants.FrameworkConstants.ICON_SMILEY_PASS;
import static org.bongz.constants.FrameworkConstants.ICON_SMILEY_SKIP;

import java.io.IOException;
import java.util.Arrays;

import org.bongz.annotations.FrameworkAnnotations;
import org.bongz.enums.ConfigProperties;
import org.bongz.reports.ExtentLogger;
import org.bongz.reports.ExtentReport;
import org.bongz.utils.BrowserInfoUtils;
import org.bongz.utils.ELKUtils;
import org.bongz.utils.IconUtils;
import org.bongz.utils.PropertyUtils;
import org.bongz.utils.SendEmailUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class ListenerClass implements ITestListener, ISuiteListener{

    static int count_passedTCs;
    static int count_skippedTCs;
    static int count_failedTCs;
    static int count_totalTCs;
	
	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReports();
			SendEmailUtils.sendMail(count_passedTCs, count_failedTCs, count_skippedTCs, count_totalTCs);
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		 count_totalTCs = count_totalTCs + 1;
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).author());
		ExtentReport.addcategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category());
		ExtentReport.addDevice();
		ExtentLogger.info(BOLD_START + IconUtils.getOSIcon() + " & " + IconUtils.getBrowserIcon() + " <--->" 
		+ BrowserInfoUtils.getOS_Browser_BrowserVersionInfo() + BOLD_END);
		
		try {
			ExtentLogger.info(ICON_Navigate_Right + "  Navigating to : " + BOLD_START +
			        PropertyUtils.getPropertyValue(ConfigProperties.URL) + BOLD_END);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		count_passedTCs = count_passedTCs + 1;
		//ExtentLogger.pass(result.getMethod().getMethodName() + " passed successfully");
		String logText = "<b>" + result.getMethod().getMethodName() + " passed.<b>" + " " + ICON_SMILEY_PASS;
		Markup markupmessage = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		ExtentLogger.pass(markupmessage);
		try {
			ELKUtils.sendDataToELK(result.getMethod().getMethodName(), "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		count_failedTCs = count_failedTCs + 1;
		ExtentLogger.fail(ICON_BUG + " " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
		 String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		   String message = "<details><summary><b><font color=red> Exception occured, click to see details: "
	                + ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
	                + "</details> \n";
		   ExtentLogger.fail(message);
		   String logText = "<b>" + result.getMethod().getMethodName() + " failed.<b>" + " " + ICON_SMILEY_FAIL;
		   Markup markupmessage = MarkupHelper.createLabel(logText, ExtentColor.RED);
			
		try {
			//ExtentLogger.fail(result.getMethod().getMethodName() + " failed", true);
			ExtentLogger.fail(markupmessage, true);
			//ExtentLogger.fail(result.getThrowable().toString());
			//ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
			ELKUtils.sendDataToELK(result.getMethod().getMethodName(), "fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		count_skippedTCs = count_skippedTCs + 1;
		ExtentLogger.fail(ICON_BUG + " " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
		String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.<b>" + " " + ICON_SMILEY_SKIP;
		 Markup markupmessage = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		try {
			ExtentLogger.skip(markupmessage, true);
			//ExtentLogger.fail(result.getThrowable().toString());
			//ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
			ELKUtils.sendDataToELK(result.getMethod().getMethodName(), "skip");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	
}
