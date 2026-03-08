package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class MediumSelectPage extends BasePage{

    private final By platFormChatOcep = By.xpath("//div[@id='key.body.carousel.0.icon.button.chat']//img[@class='iconButtonImg']");
    private final By iframeLocator = By.id("mobiFrame");

    public String getTitle(){
        return getPageTitle();
    }

    public ChangeStatusPage selectPlatformChatOcep() {
        System.out.println("Before switching to iframe");
        waitForElement(iframeLocator, WaitStrategy.PRESENT);
        switchToFrame(iframeLocator);
        scrollIntoView(platFormChatOcep, WaitStrategy.VISIBLE);
        click(platFormChatOcep, WaitStrategy.CLICKABLE, "Platform Chat OCEP");
        switchToDefaultContent();
        return new ChangeStatusPage();
    }
}
