package org.bongz.pages;

import org.bongz.driver.DriverManager;
import org.bongz.reports.ExtentLogger;
import org.openqa.selenium.JavascriptExecutor;

public class HomeAssistantLoginPage extends BasePage {

    private final String usernameNativeInput =
            "var haInput = document.querySelector('ha-authorize ha-auth-flow ha-auth-form ha-auth-form-string ha-input[type=\"text\"]');" +
            "if (!haInput || !haInput.shadowRoot) return null;" +
            "var waInput = haInput.shadowRoot.querySelector('wa-input[name=\"username\"]');" +
            "if (!waInput || !waInput.shadowRoot) return null;" +
            "return waInput.shadowRoot.querySelector('div.text-field input') || waInput.shadowRoot.querySelector('input');";

    private final String passwordNativeInput =
            "var haInput = document.querySelector('ha-authorize ha-auth-flow ha-auth-form ha-auth-form-string ha-input[type=\"password\"]');" +
            "if (!haInput || !haInput.shadowRoot) return null;" +
            "var waInput = haInput.shadowRoot.querySelector('wa-input[name=\"password\"]');" +
            "if (!waInput || !waInput.shadowRoot) return null;" +
            "return waInput.shadowRoot.querySelector('div.text-field input') || waInput.shadowRoot.querySelector('input');";

    public HomeAssistantLoginPage enterUsername(String username) {
        element = waitForShadowElement(usernameNativeInput, 30);
        element.click();
        element.clear();
        element.sendKeys(username);
        try {
            ExtentLogger.pass(username + " is entered successfully in Username", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomeAssistantLoginPage enterPassword(String password) {
        element = waitForShadowElement(passwordNativeInput, 30);
        element.click();
        element.clear();
        element.sendKeys(password);
        try {
            ExtentLogger.pass("Password is entered successfully", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomeAssistantDashboardPage clickLogin() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(
            "var authFlow = document.querySelector('ha-authorize ha-auth-flow');" +
            "if (authFlow && authFlow._handleSubmit) {" +
            "  authFlow._handleSubmit({ preventDefault: function(){} });" +
            "}"
        );
        try {
            ExtentLogger.pass("Login button is Clicked", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HomeAssistantDashboardPage();
    }
}
