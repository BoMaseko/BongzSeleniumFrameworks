package org.bongz.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.bongz.enums.ConfigProperties;
import org.testng.Assert;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

/**
 * 
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public class ELKUtils {

	private ELKUtils() {}
	
	public static void sendDataToELK(String testName, String status) throws Exception {
		
		if(PropertyUtils.getPropertyValue(ConfigProperties.SENDRESULTSTOELK).equalsIgnoreCase("yes")) {
		Map<String, String> map = new HashMap<>();
		map.put("testName", testName);
		map.put("status", status);
		map.put("executionTime", LocalDateTime.now().toString());
		
		Response response = given().header("Content-Type", "application/json")
				.log()
				.all()
				.body(map)
				.post(PropertyUtils.getPropertyValue(ConfigProperties.ELASTICURL));
		
		Assert.assertEquals(response.statusCode(), 201);
		
		response.prettyPrint();
		
		}
		
	}
}
