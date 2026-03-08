package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class UA_LandingPage extends BasePage {

    private final By menu = By.xpath("//div[@class='cdk-overlay-backdrop mobile-menu-backdrop cdk-overlay-backdrop-showing']");

    public String getTitle(){
        return getPageTitle();
    }

    public TwoFAAuthorizationPage clickMenu() {
        click(menu, WaitStrategy.VISIBLE, "My work profile");
        return new TwoFAAuthorizationPage();
    }

}
