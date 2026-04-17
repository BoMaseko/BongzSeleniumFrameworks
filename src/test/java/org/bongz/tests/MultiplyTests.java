package org.bongz.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.bongz.annotations.FrameworkAnnotations;
import org.bongz.enums.CategoryType;
import org.bongz.pages.*;
import org.bongz.utils.DecodeUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class MultiplyTests extends BaseTest {

	private MultiplyTests() {
	}

	@FrameworkAnnotations(author = {"Bongani Maseko"}, category = {CategoryType.REGRESSION, CategoryType.SANITY})
	@Test()
	public void homeAssistantLoginTest(Map<String, String> data) throws Exception {

		HomeAssistantDashboardPage dashboard = new HomeAssistantLoginPage()
				.enterUsername(data.get("username"))
				.enterPassword(data.get("password"))
				.clickLogin()
				.waitForDashboard();

		String title = dashboard.getTitle();
		System.out.println("Title after login: " + title);
		Assertions.assertThat(title).contains("Home Assistant");

		// Navigate to Energy page via sidebar
		dashboard.navigateToSidebarItem("/energy", "Energy");

		String energyUrl = org.bongz.driver.DriverManager.getDriver().getCurrentUrl();
		System.out.println("URL after navigating to Energy: " + energyUrl);
		Assertions.assertThat(energyUrl).contains("/energy");
	}

	@FrameworkAnnotations(author = {"Bongani Maseko"}, category = {CategoryType.REGRESSION, CategoryType.SANITY})
	@Test()
	public void loginlogoutTest(Map<String, String> data) throws InterruptedException {

		String title = new MobiLoginPage()
				.enterUserName(data.get("username"))
				.enterPassword(data.get("password"))
				.loginToHomeAssistant()
				.getTitle();

		System.out.print(title);
		Assertions.assertThat(title).isNotBlank();
	}

	@FrameworkAnnotations(author = {"Bongani Maseko"}, category = {CategoryType.SANITY})
	@Test()
	public void unifiedAgentTest(Map<String, String> data) {

		String title = new UA_LoginPage()
				.enterUserName(data.get("username"))
				.enterPassword(data.get("password"))
				.loginToEF()
				.getTitle();

		Assertions.assertThat(title).isEqualTo("Agent Desk");
	}

	@FrameworkAnnotations(author = {"Bongani Maseko"}, category = {CategoryType.SANITY})
	@Test()
	public void rewardsSubMenuTest(Map<String, String> data) {
		String title = new MultiplyLoginPage()
				.clickLogin()
				.enterUserName(data.get("username"))
				.enterPassword(DecodeUtils.getDecodeString(data.get("password")))
				.login().clickOnDashSubMenu(data.get("menutxt")).getPageTitle();

		Assertions.assertThat(title).isNotNull().isNotBlank();
	}

	@Test(dataProvider = "LoginTestDataProvider")
	public void newTest(String username, String password) {

		String title = new MultiplyLoginPage()
				.clickLogin()
				.enterUserName(username)
				.enterPassword(password)
				.login().getPageTitle();

		Assertions.assertThat(title).isEqualTo("My Points");
	}

	@DataProvider(name = "LoginTestDataProvider", parallel = true)
	public Object[][] getData() {
		return new Object[][]{
				{"bomaseko11", "@KBTokzan2021"}
		};
	}
}
