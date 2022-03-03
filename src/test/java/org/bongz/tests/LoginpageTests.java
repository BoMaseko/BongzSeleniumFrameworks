package org.bongz.tests;

import org.bongz.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginpageTests extends BaseTest{
	
	private LoginpageTests(){
		
	}

	@Test
	public void test1() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Arsenal", Keys.ENTER);

	}

}
