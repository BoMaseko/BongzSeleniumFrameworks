package org.bongz.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

/**
 * ExtentManager class helps to achieve thread safety for the {@link com.aventstack.extentreports.ExtentTest} instance.<p>
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public class ExtentManager {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	
	/**
	 *  @author Bongz
	 * @return Thread safe {@link com.aventstack.extentreports.ExtentTest} instance.
	 */
	static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	/**
	 * Set the {@link com.aventstack.extentreports.ExtentTest} instance to thread local variable
	 * 
	 * @author Bongz
	 * @param test {@link com.aventstack.extentreports.ExtentTest} instance that needs to saved from Thread safety issues.<p>
	 * TODO Disallow null assignment and call unload method instead.
	 */
	static void setExtentTest(ExtentTest test) {
		if(Objects.nonNull(test))
			extentTest.set(test);
	}

	/**
	 * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
	 * It is much safer than assigning null value to ThreadLocal variable.
	 * 
	 * @author Bongz
	 */
	static void unload() {
		extentTest.remove();
	}
}
