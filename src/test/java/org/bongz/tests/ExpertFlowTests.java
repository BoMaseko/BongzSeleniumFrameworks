package org.bongz.tests;

import org.assertj.core.api.Assertions;
import org.bongz.annotations.FrameworkAnnotations;
import org.bongz.enums.CategoryType;
import org.bongz.pages.MobiLoginPage;
import org.bongz.pages.UA_LoginPage;
import org.bongz.utils.DecodeUtils;
import org.testng.annotations.Test;

import java.util.Map;

public class ExpertFlowTests extends BaseTest{

    @FrameworkAnnotations(author= {"Bongani"}, category= {CategoryType.REGRESSION, CategoryType.SANITY})
    @Test()
    public void efLoginLogoutTest(Map<String, String> data) throws InterruptedException {

        String title = new UA_LoginPage()
                .enterUserName(data.get("username"))
                        .enterPassword(DecodeUtils.getDecodeString(data.get("password")))
                .loginToEF()
                .getTitle();


        System.out.print(title);
        //Assertions.assertThat(title).isEqualTo("FNB 2AF8A-P54");
        Assertions.assertThat(title).isNotBlank();
    }
}
