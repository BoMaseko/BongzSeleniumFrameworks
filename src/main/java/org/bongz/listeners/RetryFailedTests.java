package org.bongz.listeners;

import org.bongz.enums.ConfigProperties;
import org.bongz.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer{

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {

		try {
			if(PropertyUtils.getPropertyValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes") 
					&& count<retries) {
					count++;
					return true;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

}
