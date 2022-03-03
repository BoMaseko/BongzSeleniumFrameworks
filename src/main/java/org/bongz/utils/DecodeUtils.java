package org.bongz.utils;

import java.util.Base64;

public final class DecodeUtils {
	
	private DecodeUtils() {}
	
	public static String getDecodeString(String encodedString) {
		 return new String(Base64.getDecoder().decode(encodedString.getBytes()));
	}

}
