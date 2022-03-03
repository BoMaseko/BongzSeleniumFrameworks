package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.bongz.utils.DynamicXpathUtils;
import org.openqa.selenium.By;



public final class MultiplyHomePage extends BasePage{

	private final By logoutBtn = By.xpath("//div[contains(text(),'LOG OUT')]"); 
	private final By myRewardsBtn = By.xpath("(//a[@class='btn btn-primary'])[1]"); 
	private final By healthQues = By.xpath("//span[text()[normalize-space()='Health and Activity Questionnaire']]");
	
	private String dashSubMenu = "(//a[text()[normalize-space()='%s']])[1]";
	private String healthSubMenu = "(//a[text()[normalize-space()='%s']])[1]";
	
	public MultiplyRewardsPage clickOnDashSubMenu(String menutxt) {
		String newxpath = DynamicXpathUtils.getXpath(dashSubMenu, menutxt);
		click(By.xpath(newxpath), WaitStrategy.CLICKABLE, menutxt);
		if(menutxt.contains("Rewards")) {
			return new MultiplyRewardsPage();
		}
		return null;
	}
	
	public QuestionnairePage navigateToHealth(String menutxt) {
		String healthxpath = DynamicXpathUtils.getXpath(healthSubMenu, menutxt);
		
		navigateTo(By.xpath(healthxpath), WaitStrategy.PRESENT, menutxt);
		if(menutxt.contains("Health")) {
			click(healthQues, WaitStrategy.CLICKABLE, "Health Questionnaire");
			return new QuestionnairePage();
		}
		return null;
		
	}

	public MultiplyLoginPage logout() {
		//Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		//Thread.yield();
		click(logoutBtn, WaitStrategy.PRESENT, "Logout button");
		return new MultiplyLoginPage();
	}

	public MultiplyRewardsStatementPage myRewardsStatement() {
		click(myRewardsBtn, WaitStrategy.PRESENT, "My Rewards Statement");
		return new MultiplyRewardsStatementPage();
	}
}
