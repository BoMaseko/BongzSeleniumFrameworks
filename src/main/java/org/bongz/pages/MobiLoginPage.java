package org.bongz.pages;

import org.bongz.driver.DriverManager;
import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class MobiLoginPage extends BasePage{

    private final By userNameTxt = By.id("Username");
    private final By passwordTxt = By.id("Password");
    private final By buttonLogin = By.id("buttonAction");

    public MobiLoginPage enterUserName(String username) {
        clear(userNameTxt, WaitStrategy.VISIBLE, "Clear");
        click(userNameTxt, WaitStrategy.VISIBLE, "Username");
        sendKeys(userNameTxt, username, WaitStrategy.NONE, "Username");
        return this;
    }

    public MobiLoginPage enterPassword(String password) {
        clear(passwordTxt, WaitStrategy.VISIBLE, "Clear");
        click(passwordTxt, WaitStrategy.VISIBLE, "password");
        sendKeys(passwordTxt, password, WaitStrategy.PRESENT, "password");
        return this;
    }

    public SelectProfilePage loginToMobi() {
        click(buttonLogin, WaitStrategy.VISIBLE, "login button");
        System.out.println("Navigated to: " + DriverManager.getDriver().getCurrentUrl());
        return new SelectProfilePage();
    }



}