package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class TravelsLoginPage extends BasePage{
	
	private final By email = By.xpath("//input[@name='email']"); 
	private final By loginButton = By.xpath("//div[@id='cookie_disclaimer']"); 
	private final By password = By.xpath("//input[@name='password' and @type='password']"); 
	
	
	public TravelsLoginPage enterEmail(String emailField)  {
		//Thread.yield();
		sendKeys(email, emailField, WaitStrategy.VISIBLE, "Email");
		return this;
	}
	
	public TravelsLoginPage enterPassword(String pass)  {
		//Thread.yield();
		sendKeys(password, pass, WaitStrategy.VISIBLE, "Password");
		return this;
	}
	
	public TravelsLoginPage clicklogin() {
		//Thread.yield();
		click(loginButton, WaitStrategy.CLICKABLE, "Login");
		return this;
	}

}
