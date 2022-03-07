package org.bongz.utils;

/**
 * Constructs a dynamic xpath at run time.<p>
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public final class DynamicXpathUtils {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private DynamicXpathUtils() {}
	
	
	/**
	 * Receives a wildcard string, replace the wildcard with the value and return to the caller
	 * 
	 *  @author Bongz
	 * @param xpath Xpath with wildcard string
	 * @param value value to be replaced in place of wildcard
	 * @return dynamic xpath string
	 */
	public static String getXpath(String xpath, String value) {
		
		return String.format(xpath, value);
		//return xpath.replace("%replacable%", value);
	}
	
	/**
	 *  Receives a wildcard string, replace the wildcard with the value and return to the caller
	 * 
	 * @author Bongz
	 * @param xpath Xpath with wildcard string
	 * @param value1 value to be replaced in place of wildcard
	 * @param value2 value to be replaced in place of wildcard
	 * @return dynamic xpath string
	 */
	
	public static String getXpath(String xpath, String value1, String value2) {
		return String.format(xpath, value1,value2);
	}
}
