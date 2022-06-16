package org.bongz.pages;

import org.bongz.enums.WaitStrategy;
import org.bongz.utils.FakerUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class AdminCampaignPage extends BasePage{
	
	private final By campaignManagement = By.xpath("(//a[contains(@class,'list-group-item list-group-item-success')])[3]");
	private final By campaignSubMenu = By.xpath("//div[@class='collapse in']//a[1]");
	private final By createButton = By.xpath("(//a[@class='ng-binding'])[2]");
	private final By campaignCodeTxt = By.xpath("(//div[@class='col-md-6']//input)[1]");
	private final By campaignNameTxt = By.xpath("(//div[@class='col-md-6']//input)[2]");
	private final By campaignDescTxt = By.xpath("//div[@class='col-md-6']//textarea[1]");
	private final By qualifyProduct = By.xpath("(//select[contains(@class,'dropdown-lg selectWidth')])[2]");
	private final By calender = By.xpath("(//button[@class='btn btn-primary']//i)[2]");
	private final By calenderForward = By.xpath("(//i[@class='glyphicon glyphicon-chevron-right'])[2]");
	private final By createCampaign = By.xpath("//button[@type='submit']//span[1]");
	
	
	Faker faker = new Faker();
	
	public AdminCampaignPage createCampaign() {
		
		click(campaignManagement, WaitStrategy.CLICKABLE, "Campaign Management");
		click(campaignSubMenu, WaitStrategy.CLICKABLE, "Campaign Sub Menu");
		click(createButton, WaitStrategy.CLICKABLE, "Create Button");
		sendKeys(campaignCodeTxt, FakerUtils.getFirstName(), WaitStrategy.VISIBLE, "Campaign Code");
		sendKeys(campaignNameTxt, faker.superhero().name(), WaitStrategy.VISIBLE, "Campaign Name");
		sendKeys(campaignDescTxt, faker.superhero().descriptor(), WaitStrategy.VISIBLE, "Campaign Description");
		select(qualifyProduct, WaitStrategy.CLICKABLE, "Qualify Product");
		Select select = new Select(element);
		select.selectByIndex(2);
		click(calender, WaitStrategy.CLICKABLE, "Calender");
		click(calenderForward, WaitStrategy.CLICKABLE, "Forward Calender");
		click(calenderForward, WaitStrategy.CLICKABLE, "Forward Calender");
		selectDate(WaitStrategy.CLICKABLE, "Day");
		scrollIntoView(createCampaign, WaitStrategy.VISIBLE);
		click(createCampaign, WaitStrategy.CLICKABLE, "Create Campaign");
		
		return this;
		
	}

}
