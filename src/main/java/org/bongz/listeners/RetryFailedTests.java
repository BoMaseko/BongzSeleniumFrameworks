package org.bongz.listeners;

import org.bongz.enums.ConfigProperties;
import org.bongz.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implements {@link IRetryAnalyzer}.<p>
 * Helps in rerunning the failed tests.<p>
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public class RetryFailedTests implements IRetryAnalyzer{

	private int count = 0;
	private int retries = 1;

	/**
	 * Return true when needs to be retried and false otherwise.<p>
	 * Maximum will retry for one time.<p>
	 * Retry will happen if user desires to and set the value in the property file
	 */
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
