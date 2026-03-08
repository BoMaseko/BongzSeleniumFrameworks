package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class EmployeeDashBoardPage extends BasePage{

    private final By connectMeOcep = By.xpath("//img[@src='/banking/fstatic/images_flat/fnb/phone/mobi/mobile.arrows.icon.mdpi.png']");
    private final By iframeLocator = By.id("mobiFrame");

    public String getTitle(){
        return getPageTitle();
    }

    public MediumSelectPage selectConnectMeOcep() {
        System.out.println("Before switching to iframe");
        waitForElement(iframeLocator, WaitStrategy.PRESENT);
        switchToFrame(iframeLocator);
        scrollIntoView(connectMeOcep, WaitStrategy.VISIBLE);
        click(connectMeOcep, WaitStrategy.CLICKABLE, "ConnectMe OCEP");
        switchToDefaultContent();
        return new MediumSelectPage();
    }
}
