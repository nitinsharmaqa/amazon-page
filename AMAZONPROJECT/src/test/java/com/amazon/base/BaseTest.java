package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "gridUrl"})
    public void setup(String browser, String gridUrl) {
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    // Add any necessary options for Chrome
                    driver = new RemoteWebDriver(new URL(gridUrl), chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    // Add any necessary options for Firefox
                    driver = new RemoteWebDriver(new URL(gridUrl), firefoxOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    // Add any necessary options for Edge
                    driver = new RemoteWebDriver(new URL(gridUrl), edgeOptions);
                    break;
                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid grid URL: " + gridUrl, e);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
