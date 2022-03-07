package org.bongz.pages;

import org.bongz.driver.DriverManager;
import org.bongz.enums.WaitStrategy;
import org.bongz.factories.ExplicitWaitFactory;
import org.bongz.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class BasePage {
	
	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * @author Bongz
	 * @param by By Locator of the webelement
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link org.bongz.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	
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
	
	/**
	 * 
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * @author Bongz
	 * @param by By Locator of the webelement
	 * @param value value to be send the text box
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link org.bongz.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void sendKeys(By by, String keys, WaitStrategy wait, String elementname) {
		
		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		element.sendKeys(keys);
		try {
			ExtentLogger.pass(keys + " is entered successfully in " + elementname, true );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * @author Bongz
	 * @param by By Locator of the webelement
	 * @param value value to be send the text box
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.bongz.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void navigateTo(By by,  WaitStrategy wait, String elementname) {
		Actions actions = new Actions(DriverManager.getDriver());
		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		actions.moveToElement(element).perform();
		
	}
	
	/**
	 * Return page title of webpage in String
	 * @author Bongz
	 * @return Page title of the webpage where the selenium is currently interacting.
	 */
	public String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	

	
	
	
	

}
