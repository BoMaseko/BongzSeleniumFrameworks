package org.bongz.factories;

import org.bongz.constants.FrameworkConstants;
import org.bongz.driver.DriverManager;
import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory {
	
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
