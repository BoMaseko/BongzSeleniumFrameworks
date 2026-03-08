package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.bongz.utils.SendCustomerChat;
import org.openqa.selenium.By;

import java.io.File;

public class PlatformChatInteractionScreen extends BasePage{

    private final By customerChat = By.xpath("//div[@id='ConversationBody']");
    private final By iframeLocator = By.id("mobiFrame");
    private final By wrapUpIcon = By.xpath("//img[@src='/banking/fstatic/images_flat/fnb/phone/mobi/telephony.tick.icon.mdpi.png']");

    public String getTitle(){
        return getPageTitle();
    }

    public PlatformChatInteractionScreen customerSendChat() throws Exception {
        SendCustomerChat.sendCustomerChat(new File("src/test/resources/json/customerMessage.json"));
        return this;
    }

    public PlatformChatInteractionScreen viewCustomerChat(){
        waitForElement(iframeLocator, WaitStrategy.PRESENT);
        switchToFrame(iframeLocator);
        click(customerChat, WaitStrategy.PRESENT, "Customer chat");
        switchToDefaultContent();
        return this;
    }

    public WrapUpCustomerChatPage wrapUpCustomerChat(){
        waitForElement(iframeLocator, WaitStrategy.PRESENT);
        switchToFrame(iframeLocator);
        click(wrapUpIcon, WaitStrategy.PRESENT, "Wrap-up Icon");
        switchToDefaultContent();
        return new WrapUpCustomerChatPage();
    }
}
