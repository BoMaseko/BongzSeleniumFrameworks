package org.bongz.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.bongz.utils.DataProviderUtils;
import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;

/**
 * Implements {@link org.testng.IAnnotationTransformer} to leverage certain functionality like updating the annotations of test
 * methods at runtime.
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 *@see org.bongz.utils.DataProviderUtils
 */
public class AnnotationTransformer implements IAnnotationTransformer{
	
	/**
	 * Helps in setting the dataprovider, dataprovider class and retry analyser annotation to all the test methods
	 * at run time. 
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");//Reading from excel
		annotation.setDataProviderClass(DataProviderUtils.class);//Reading from excel
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

}
