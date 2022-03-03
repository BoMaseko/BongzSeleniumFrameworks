package org.bongz.tests;

import org.bongz.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class HomepageTests extends BaseTest {
	
	private HomepageTests() {
		
	}
	
	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Proteas", Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		//Assert.assertTrue(title.toLowerCase().contains(title));
	}
}
