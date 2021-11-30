package com.apotheke.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
