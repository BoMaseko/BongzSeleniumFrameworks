package org.bongz.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.bongz.annotations.FrameworkAnnotations;
import org.bongz.enums.CategoryType;
import org.bongz.pages.AdminHomePage;
import org.testng.annotations.Test;

public final class CoreAdminTests extends BaseTest{

	private CoreAdminTests() {}

	@FrameworkAnnotations(author = "Bongani", category = {CategoryType.REGRESSION})
	@Test
	public void campaignManagementTest(Map<String, String> data) {

		String title = new AdminHomePage().createCampaignManagement().createCampaign().getPageTitle();

		Assertions.assertThat(title).isEqualTo("Events UI");
	}

}
