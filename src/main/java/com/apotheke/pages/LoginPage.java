package com.apotheke.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//input[@id='login-email']")
    private WebElement emailID;

    @FindBy(xpath ="//input[@type='password']")
    private WebElement password;

    @FindBy(xpath ="//button[@type='submit']")
    private WebElement login;

    public WebElement getEmailID()
    {
        return emailID;
    }

    public WebElement getPasswrod()
    {
        return password;
    }

    public WebElement getLoginButton()
    {
        return login;
    }

    public HomePage doLogin(String username, String password)
    {
        getEmailID().sendKeys(username);
        getPasswrod().sendKeys(password);
        getLoginButton().click();

        return getInstance(HomePage.class);
    }

    public LoginPage doLoginWithInvalidCredentials()
    {
        getEmailID().sendKeys("");
        getPasswrod().sendKeys("");
        getLoginButton().click();

        return getInstance(LoginPage.class);
    }
}
