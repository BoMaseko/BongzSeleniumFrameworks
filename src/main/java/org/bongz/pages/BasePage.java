package org.bongz.pages;

import java.util.List;

import org.bongz.driver.DriverManager;
import org.bongz.enums.WaitStrategy;
import org.bongz.factories.ExplicitWaitFactory;
import org.bongz.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertEquals;


public class BasePage {
	
	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * @author Bongz
	 * @param by By Locator of the webelement
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	
	WebElement element;


	protected void switchToFrame(By by) {
		element = DriverManager.getDriver().findElement(by);
		DriverManager.getDriver().switchTo().frame(element);
		try {
			ExtentLogger.pass("Switched to iframe with locator: " + by.toString(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switch back to the main content from an iframe.
	 */
	protected void switchToDefaultContent() {
		DriverManager.getDriver().switchTo().defaultContent();
		try {
			ExtentLogger.pass("Switched back to the default content", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void click(By by, WaitStrategy wait, String elementName) {
		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		element.click();
		try {
			ExtentLogger.pass(elementName +" is Clicked", true);
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
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link WaitStrategy}
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

	protected void clear(By by, WaitStrategy wait, String elementname) {

		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		element.clear();
		try {
			//ExtentLogger.pass(keys + " is entered successfully in " + elementname, true );
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
	 * @param wait value to be send the text box
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
	
	public void select(By by, WaitStrategy wait, String elementname) {
		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		try {
			ExtentLogger.pass(elementname +  " is selected successfully ", true );
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void selectDate(WaitStrategy wait, String elementname) {
		
		 List<WebElement> month =  DriverManager.getDriver().findElements(By.xpath("//table/tbody/tr/td"));
		 
		 for (int dayz = 0; dayz<month.size(); dayz++) {
	         //check date
	         String day = month.get(dayz).getText();
	        // System.out.println(day);
	         if (day.equals("25")) {
	            month.get(dayz).click();
	            break;
	         }
	      }
		 try {
			ExtentLogger.pass(  elementname+  " is selected successfully ", true );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void scrollIntoView(By by, WaitStrategy wait) {
		element = ExplicitWaitFactory.PerformExplicitWait(wait, by);
		element = DriverManager.getDriver().findElement(by);
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	protected WebElement waitForElement(By by, WaitStrategy waitStrategy) {
		return ExplicitWaitFactory.PerformExplicitWait(waitStrategy, by);
	}

}
