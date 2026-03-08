package org.bongz.pages;

import org.bongz.driver.DriverManager;
import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectProfilePage extends BasePage{

    private final By selectFNumberBtn = new By.ByCssSelector("body > section:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > form:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)");

    public String getTitle(){
        return getPageTitle();
    }

    public TwoFAAuthorizationPage selectMyWorkProfile() {
        click(selectFNumberBtn, WaitStrategy.VISIBLE, "My work profile");
        return new TwoFAAuthorizationPage();
    }
}
