package org.bongz.factories;

import org.bongz.constants.FrameworkConstants;
import org.bongz.driver.DriverManager;
import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Explicit wait factory produces different waits before operating on webelement<p>
 *Mar 7, 2022
 * @author Bongani Maseko
 *@version 1.0
 *@since 1.0
 */
public class ExplicitWaitFactory {
	
	/**
	 * Private constructor to avoid external instantiation
	 */
	private ExplicitWaitFactory() {}
	
	/**
	 * 
	 * @param waitstrategy
	 * @param by By locator of the webelement
	 * @param waitstrategy Strategy to be applied to find a webelement {@link org.bongz.enums.WaitStrategy}
	 * @return Locates and return the webelement
	 */
	public static WebElement PerformExplicitWait(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		if(waitstrategy == waitstrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitstrategy())
			.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(waitstrategy == waitstrategy.PRESENT){
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitstrategy())
			.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitstrategy == waitstrategy.VISIBLE){
			element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWaitstrategy())
			.until(ExpectedConditions.visibilityOfElementLocated(by));
		}else if(waitstrategy == waitstrategy.NONE){
			element = DriverManager.getDriver().findElement(by);
		}
		return element;	
		
		
		
	
	}
}
