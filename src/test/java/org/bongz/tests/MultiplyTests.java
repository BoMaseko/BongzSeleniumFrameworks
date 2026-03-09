package org.bongz.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.bongz.annotations.FrameworkAnnotations;
import org.bongz.enums.CategoryType;
import org.bongz.listeners.RetryFailedTests;
import org.bongz.pages.*;
import org.bongz.utils.DataProviderUtils;
import org.bongz.utils.DecodeUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class MultiplyTests extends BaseTest{
	
	private MultiplyTests() {
		
	}
	
	@FrameworkAnnotations(author= {"Bongani Maseko"}, category= {CategoryType.REGRESSION, CategoryType.SANITY})
	@Test() 
	public void loginlogoutTest(Map<String, String> data) throws InterruptedException {

		  String title = new MobiLoginPage()
				  .enterUserName(data.get("username"))
				  .enterPassword(data.get("password"))
				  .loginToMobi()
				  .getTitle();

		  System.out.print(title);
		  //Assertions.assertThat(title).isEqualTo("FNB 2AF8A-P54");
		  Assertions.assertThat(title).isNotBlank();
	}
	
	@FrameworkAnnotations(author= {"Bongani Maseko"}, category= {CategoryType.SANITY})
	@Test() //Reading from excel --> AnnotationListener
	public void advisorLoginToPlatformChatTest(Map<String, String> data) throws Exception {

		String title = String.valueOf(new MobiLoginPage()
				.enterUserName(data.get("username"))
				.enterPassword(data.get("password"))
				.loginToMobi()
				.selectMyWorkProfile()
				.skip2FA_Authorization()
				.continuePleaseNote()
				.selectConnectMeOcep()
				.selectPlatformChatOcep()
				.selectOnlineStatus()
				.clickContinueButton()
				.customerSendChat()
				.viewCustomerChat()
				.wrapUpCustomerChat()
				.getPageTitle());



		System.out.print(title);
		//Assertions.assertThat(title).isEqualTo("FNB 2AF8A-P54");
		Assertions.assertThat(title).isNotBlank();
	}

	@FrameworkAnnotations(author= {"Bongani Maseko"}, category= {CategoryType.SANITY})
	@Test()
	public void unifiedAgentTest(Map<String, String> data) {
		
		String title = new UA_LoginPage()
				.enterUserName(data.get("username"))
				.enterPassword(data.get("password"))
				.loginToEF()
				.getTitle();


		
		Assertions.assertThat(title).isEqualTo("Agent Desk");
		
	}

	@FrameworkAnnotations(author= {"Bongani Maseko"}, category= {CategoryType.SANITY})
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
