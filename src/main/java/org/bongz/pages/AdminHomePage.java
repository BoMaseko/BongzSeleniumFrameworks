package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class AdminHomePage extends BasePage{


	private final By menu = By.xpath("//button[@class='menu ng-scope']//img[1]");


	public AdminHomePage clickOnMenu() {

		click(menu, WaitStrategy.CLICKABLE, "Menu");
		return this;
	}
	
	public AdminCampaignPage createCampaignManagement() {
		
		clickOnMenu();
		return new AdminCampaignPage();
	}

}
