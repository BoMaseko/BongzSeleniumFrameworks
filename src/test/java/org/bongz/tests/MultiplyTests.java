package org.bongz.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.bongz.annotations.FrameworkAnnotations;
import org.bongz.enums.CategoryType;
import org.bongz.listeners.RetryFailedTests;
import org.bongz.pages.MultiplyHomePage;
import org.bongz.pages.MultiplyLoginPage;
import org.bongz.pages.QuestionnairePage;
import org.bongz.utils.DataProviderUtils;
import org.bongz.utils.DecodeUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class MultiplyTests extends BaseTest{
	
	private MultiplyTests() {
		
	}
	
	@FrameworkAnnotations(author= {"Bongani"}, category= {CategoryType.REGRESSION, CategoryType.SANITY})
	@Test() 
	public void loginlogoutTest(Map<String, String> data) {
	
		  String title = new MultiplyLoginPage() .clickLogin()
		  .enterUserName(data.get("username")) .enterPassword(DecodeUtils.getDecodeString(data.get("password")))
		  .login() .getPageTitle();
	
		Assertions.assertThat(title).isEqualTo("Login");
	}
	
	@FrameworkAnnotations(author= {"KBTokzan"}, category= {CategoryType.SANITY})
	@Test() //Reading from excel --> AnnotationListener
	public void completeHealthQuestionnareTest(Map<String, String> data) {
	
		String title = new MultiplyLoginPage()
				.clickLogin()
				.enterUserName(data.get("username"))
				.enterPassword(DecodeUtils.getDecodeString(data.get("password")))
				.login().navigateToHealth(data.get("menutxt")).startQuestionnaire().getPageTitle();
		
		
		Assertions.assertThat(title).isEqualTo("Health and Activity Questionnaire");
	}
	
	@Test()
	public void myRewardsStatementTest(Map<String, String> data) {
		
		String title = new MultiplyLoginPage()
				.clickLogin()
				.enterUserName(data.get("username"))
				.enterPassword(DecodeUtils.getDecodeString(data.get("password")))
				.login().myRewardsStatement().getPageTitle();
		
		Assertions.assertThat(title).isEqualTo("My Rewards Statement");
		
	}
	
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
	
	@DataProvider(name="LoginTestDataProvider", parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
			{"bomaseko11","@KBTokzan2021"}
		};
	}
}
