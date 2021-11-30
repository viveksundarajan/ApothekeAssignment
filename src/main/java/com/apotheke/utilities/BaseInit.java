package com.apotheke.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import com.apotheke.pages.BasePage;
import com.apotheke.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseInit {

    public WebDriver driver;
    public Page page;
    public String URL;
    public String emailId;
    public String password;
    public String userName;
    public String loginPageTitle;

    public BaseInit() throws IOException {

        Properties prop=new Properties();
        FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//config.properties");
        prop.load(file);
        URL=prop.getProperty("url");
        emailId = prop.getProperty("emailid");
        password = prop.getProperty("password");
        userName =prop.getProperty("username");
        loginPageTitle = prop.getProperty("loginpagetitle");
    }


    @BeforeMethod
    @Parameters(value ="browserName")
    public WebDriver invokeBrowser(String browserName)
    {
        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver");
            driver= new ChromeDriver();
        }
        else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//geckodriver");
            driver= new FirefoxDriver();
        }
        driver.get(URL);

        page = new BasePage(driver);
        return driver;
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
