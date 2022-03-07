package org.bongz.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bongz.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;


/**
 * Holds the data provider for all the test cases in the framework.<p>
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public final class DataProviderUtils {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private DataProviderUtils() {}

	private static List<Map<String, String>> list = new ArrayList<>();
	
	/**
	 * 
	 * Acts as a data provider for all the test cases.<p>
	 * Parallel=true indicates that each of the iteration will be ran in parallel.
	 * 
	 * @author Bongz
	 * @param m {@link java.lang.reflect.Method} holds the information about the testcases at runtime
	 * @return Object[] containing the List. Each index of the list contains HashMap and each of them
	 * contains the test data needed to run the iterations.
	 * 
	 * @see org.bongz.tests.MultiplyTests 
	 * @see org.bongz.listeners.AnnotationTransformer
	 */
	
	@DataProvider(parallel=true)
	public static Object[] getData(Method m) {
		
		String testname = m.getName();
		/*
		 * Reading the excel only once for optimization
		 * 
		 */
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
		}
		
		//List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
		
		List<Map<String, String>> iterationList = new ArrayList<Map<String,String>>();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get("testname").equalsIgnoreCase(testname) 
					&& list.get(i).get("execute").equalsIgnoreCase("yes")){
				iterationList.add(list.get(i));
			}
		}
		
		//list.removeAll(iterationList); // Remove the already ran test from the list(optimization)
		return iterationList.toArray();
		
	}
}
