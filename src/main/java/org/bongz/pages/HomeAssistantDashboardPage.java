package org.bongz.pages;

import java.time.Duration;

import org.bongz.driver.DriverManager;
import org.bongz.reports.ExtentLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeAssistantDashboardPage extends BasePage {

    // Sidebar menu item by text - traverses the shadow DOM to find the item by its label
    private String getSidebarItemScript(String href) {
        return "var ha = document.querySelector('home-assistant');" +
            "if (!ha || !ha.shadowRoot) return null;" +
            "var main = ha.shadowRoot.querySelector('home-assistant-main');" +
            "if (!main || !main.shadowRoot) return null;" +
            "var drawer = main.shadowRoot.querySelector('ha-drawer');" +
            "if (!drawer) return null;" +
            "var sidebar = drawer.querySelector('ha-sidebar');" +
            "if (!sidebar || !sidebar.shadowRoot) return null;" +
            // Find all ha-md-list-item elements and check their inner <a> href
            "var items = sidebar.shadowRoot.querySelectorAll('ha-md-list-item');" +
            "for (var i = 0; i < items.length; i++) {" +
            "  if (items[i].shadowRoot) {" +
            "    var link = items[i].shadowRoot.querySelector('a[href=\"" + href + "\"]');" +
            "    if (link) return items[i];" +
            "  }" +
            // Also check if href is a direct attribute
            "  if (items[i].getAttribute('href') === '" + href + "') return items[i];" +
            "}" +
            "return null;";
    }

    public HomeAssistantDashboardPage waitForDashboard() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
            .until(ExpectedConditions.urlContains("/home/overview"));
        // Wait for the HA SPA to fully initialize - sidebar must be rendered
        waitForShadowElement(
            "var ha = document.querySelector('home-assistant');" +
            "if (!ha || !ha.shadowRoot) return null;" +
            "var main = ha.shadowRoot.querySelector('home-assistant-main');" +
            "if (!main || !main.shadowRoot) return null;" +
            "var drawer = main.shadowRoot.querySelector('ha-drawer');" +
            "if (!drawer) return null;" +
            "var sidebar = drawer.querySelector('ha-sidebar');" +
            "if (!sidebar || !sidebar.shadowRoot) return null;" +
            "return sidebar.shadowRoot.querySelector('ha-md-list-item');",
            30
        );
        try {
            ExtentLogger.pass("Dashboard loaded successfully", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public HomeAssistantDashboardPage navigateToSidebarItem(String href, String itemName) {
        // Wait for sidebar item to appear then click it
        element = waitForShadowElement(getSidebarItemScript(href), 30);
        element.click();

        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
            .until(ExpectedConditions.urlContains(href));

        // Wait for the SPA panel content to fully render before taking screenshot
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15))
            .until(d -> ((JavascriptExecutor) d)
                .executeScript("return document.readyState").equals("complete"));
        try { Thread.sleep(5000); } catch (InterruptedException ignored) {}

        try {
            ExtentLogger.pass(itemName + " page loaded successfully", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getTitle() {
        return getPageTitle();
    }
}
