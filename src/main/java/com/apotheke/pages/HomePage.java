package com.apotheke.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//h3[contains(@class,'small--bottom')]")
    private WebElement userName;

    public String getUserName()
    {
        return userName.getText();
    }
}
