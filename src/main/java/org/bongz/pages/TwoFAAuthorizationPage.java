package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class TwoFAAuthorizationPage extends BasePage{

    private final By skipBtn = By.xpath("//div[contains(text(),'Skip')]");

    public String getTitle(){
        return getPageTitle();
    }

    public PleaseNotePage skip2FA_Authorization() throws InterruptedException {
        waitForElement(skipBtn, WaitStrategy.CLICKABLE);
        click(skipBtn, WaitStrategy.CLICKABLE, "Skip button");
        return new PleaseNotePage();
    }

}
