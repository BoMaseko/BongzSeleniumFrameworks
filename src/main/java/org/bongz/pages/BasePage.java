package org.bongz.pages;

import org.bongz.driver.DriverManager;
import org.bongz.enums.WaitStrategy;
import org.bongz.factories.ExplicitWaitFactory;
import org.bongz.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class BasePage {
	
	WebElement element;
	
	protected void click(By by, WaitStrategy wait, String elementname) {
		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		element.click();
		try {
			//Thread.yield();
			ExtentLogger.pass(elementname +" is Clicked", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void sendKeys(By by, String keys, WaitStrategy wait, String elementname) {
		
		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		element.sendKeys(keys);
		try {
			ExtentLogger.pass(keys + " is entered successfully in " + elementname, true );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void navigateTo(By by,  WaitStrategy wait, String elementname) {
		Actions actions = new Actions(DriverManager.getDriver());
		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		actions.moveToElement(element).perform();
		
	}
	
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	

	
	
	
	

}
