package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class ChangeStatusPage extends BasePage{

    private final By onlineStatusBtn = By.xpath("//div[normalize-space()='Ready for interactions']");
    private final By continueBtn = By.xpath("//div[contains(text(),'Continue')]");
    private final By iframeLocator = By.id("mobiFrame");

    public String getTitle(){
        return getPageTitle();
    }

    public ChangeStatusPage selectOnlineStatus() throws InterruptedException {
        System.out.println("Before switching to iframe");
        Thread.sleep(5000);
        waitForElement(iframeLocator, WaitStrategy.PRESENT);
        switchToFrame(iframeLocator);
        click(onlineStatusBtn, WaitStrategy.NONE, "Online change status button");
        return this;
    }

    public PlatformChatInteractionScreen clickContinueButton() {
        click(continueBtn, WaitStrategy.PRESENT, "Continue button");
        switchToDefaultContent();
        return new PlatformChatInteractionScreen();
    }

}
