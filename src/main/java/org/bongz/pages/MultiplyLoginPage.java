package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class MultiplyLoginPage extends BasePage{

	private final By login = By.xpath("//header/div[1]/nav[1]/div[3]/li[2]/a[1]"); 
	private final By userNameTxt = By.id("username"); 
	private final By passwordTxt = By.xpath("//input[@id='passwordField' and @type='password']"); 
	private final By buttonLogin = By.xpath("//*[text()='LOG IN']"); 
	
	public MultiplyLoginPage clickLogin()  {
		//Thread.yield();
		click(login, WaitStrategy.NONE, "flogin");
		return this;
	}
	
	public MultiplyLoginPage enterUserName(String username) {
		//Thread.yield();
		sendKeys(userNameTxt, username, WaitStrategy.NONE, "Username");
		return this;
	}
	
	public MultiplyLoginPage enterPassword(String password) {
		//Thread.yield();
		sendKeys(passwordTxt, password, WaitStrategy.NONE, "password");
		return this;
	}
	
	public MultiplyHomePage login() {
		click(buttonLogin, WaitStrategy.NONE, "llogin button");
		return new MultiplyHomePage();
	}
	
	
	
}
