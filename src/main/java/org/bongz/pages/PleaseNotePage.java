package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public class PleaseNotePage extends BasePage{

    private final By continueBtn = new By.ByCssSelector(".ButtonsInFooterImageAndTextContainer.right_button_container_online.skinSpecificBorderRadiusForPill");
    private final By iframeLocator = By.id("mobiFrame");

    public String getTitle(){
        return getPageTitle();
    }

    public EmployeeDashBoardPage continuePleaseNote()  {
        System.out.print("Before switching to iframe");
        waitForElement(iframeLocator, WaitStrategy.PRESENT);
        switchToFrame(iframeLocator);
        click(continueBtn, WaitStrategy.VISIBLE, "Continue Button");

        System.out.print("After click");
        switchToDefaultContent();
        return new EmployeeDashBoardPage();
    }
}
