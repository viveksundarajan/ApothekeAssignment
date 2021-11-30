package com.apotheke.test;

import com.apotheke.pages.HomePage;
import com.apotheke.pages.LoginPage;
import com.apotheke.utilities.BaseInit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseInit {

    public LoginTest() throws IOException {
        super();
    }

    @Test(priority = 1)
    public void verifyLogin()
    {
       HomePage homePage= page.getInstance(LoginPage.class).doLogin(emailId,password);
        homePage.waitForPageTitle(homePage.getPageTitle());

        Assert.assertTrue(homePage.getUserName().contains(userName) ,"Login is not success");
    }

    @Test(priority = 2)
    public void tryWrongLogin()
    {
        LoginPage loginPage = page.getInstance(LoginPage.class).doLoginWithInvalidCredentials();
        Assert.assertTrue(loginPage.getPageTitle().equals(loginPageTitle));
    }
}
