package org.bongz.utils;

import java.util.Base64;

/**
 * Helps to decode the base64 encoded string.<p>
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public final class DecodeUtils {
	
	private DecodeUtils() {}
	
	public static String getDecodeString(String encodedString) {
		 return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}

}
