package org.bongz.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.bongz.utils.DataProviderUtils;
import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;

public class AnnotationTransformer implements IAnnotationTransformer{
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");//Reading from excel
		annotation.setDataProviderClass(DataProviderUtils.class);//Reading from excel
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}

}