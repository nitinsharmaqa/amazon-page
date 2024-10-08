package com.amazon.pages;

import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
    private WebDriver driver;

    // Constructor to initialize WebDriver
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to the Amazon homepage
    public void openAmazonHomePage() {
        driver.get("https://www.amazon.in");
    }

    // Get the title of the current page
    public String getHomePageTitle() {
        return driver.getTitle();
    }
}
