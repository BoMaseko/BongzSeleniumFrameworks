package org.bongz.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.bongz.constants.FrameworkConstants;
import org.bongz.enums.ConfigProperties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	
	private static Map<String, String> CONFIGMAP = new HashMap<>();
	
	private JsonUtils() {
		
	}
	
	static {
		
		try {
			 
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonfilepath()), 
					new TypeReference<HashMap<String, String>>(){});
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getPropertyValue(ConfigProperties value) throws Exception {
		
		if(Objects.isNull(value) || Objects.isNull(CONFIGMAP.get(value.name().toLowerCase()))) {
			throw new Exception("Property name " + value + " is not found, please check config.json");
		}
		return CONFIGMAP.get(value.name().toLowerCase());
	}
}
