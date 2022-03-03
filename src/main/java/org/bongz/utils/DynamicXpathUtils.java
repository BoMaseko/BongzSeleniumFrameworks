package org.bongz.utils;

public final class DynamicXpathUtils {

	public static String getXpath(String xpath, String value) {
		
		return String.format(xpath, value);
		//return xpath.replace("%replacable%", value);
	}
}
