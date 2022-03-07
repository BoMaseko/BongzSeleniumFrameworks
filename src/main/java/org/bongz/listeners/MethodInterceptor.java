package org.bongz.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bongz.constants.FrameworkConstants;
import org.bongz.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

/**
 * Implements {@link org.testng.IMethodInterceptor} to leverage the abstract methods
 * Mostly used to read the data from excel and decides on which tests needs to run.
 * 
 * <pre>Please make sure to add the listener details in the testng.xml file</pre>
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public class MethodInterceptor implements IMethodInterceptor{

	/**
	 * Intercepts the existing test methods and changes the annotation value at the run time<p>
	 * Values are fetched from the excel sheet.<p>
	 * User has to choose yes/No in the RunManager sheet.<p>
	 * Suppose if there are 3 tests named a,b,c needs to be run, <p>it reads the excel and understand user wants to 
	 * run only a and c,<p> then it will return the same after performing the comparisons.
	 * 
	 */
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		System.out.println("----------------METHOD INTERCEPTOR--------------------------");
		//System.out.println("methods: " + methods);

		List<Map<String,String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagersheet());
		List<IMethodInstance> result = new ArrayList<>();

		String testCategory = System.getProperty("testCategory");
		System.out.println("testCategory: " + testCategory);

		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) &&
						list.get(j).get("execute").equalsIgnoreCase("yes")) {
					methods.get(i).getMethod().setDescription((list.get(j).get("testdescription")));
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
					methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
					result.add(methods.get(i));
				}

			}
		}
		return result;
	}

}
