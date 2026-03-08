package org.bongz.pages;

import org.bongz.driver.DriverManager;
import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class UA_LoginPage extends BasePage{

    private final By userNameTxt = By.id("username");
    private final By passwordTxt = By.id("password");
    private final By buttonLogin = By.xpath("//button[@class='button flip-in-ver-right form-control']");

    public UA_LoginPage enterUserName(String username) {
        sendKeys(userNameTxt, username, WaitStrategy.NONE, "Username");
        return this;
    }

    public UA_LoginPage enterPassword(String password) {
        clear(passwordTxt, WaitStrategy.VISIBLE, "Clear");
        sendKeys(passwordTxt, password, WaitStrategy.NONE, "password");
        return this;
    }

    public UA_LandingPage loginToEF() {
        click(buttonLogin, WaitStrategy.VISIBLE, "login button");
        System.out.println("Navigated to: " + DriverManager.getDriver().getCurrentUrl());
        return new UA_LandingPage();
    }
}
