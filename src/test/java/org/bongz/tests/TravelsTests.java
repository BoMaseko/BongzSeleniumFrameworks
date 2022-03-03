package org.bongz.tests;

import org.bongz.pages.TravelsLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class TravelsTests extends BaseTest{
	
	private TravelsTests() {}
	
	@Test(dataProvider = "LoginTestDataProvider")
	public void loginLogoutTest(String email, String password) {
		
		String title = new TravelsLoginPage().enterEmail(email)
				.enterPassword(password)
				.clicklogin().getPageTitle();
	}
	
	@DataProvider(name="LoginTestDataProvider", parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
		
			{"user@phptravels.com","demouser1"}
		};
	}

}
