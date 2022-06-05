package com.cydeo.test.day7_TestNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        System.out.println("bf m-thod is running");
        // set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("after m-thod is running");
        driver.quit();
    }

    @Test
    public void googleTitle() {

        // Get "https://google.com/"
        driver.get("https://google.com/");
        // Assert: title is  "Google"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        //3rd argument is optional for failed msg
        Assert.assertEquals(actualTitle, expectedTitle, "Title ver is failed");

    }
    @Test
    public void yahooTitle(){
        driver.get("https://yahoo.com/");
    }

    @Test
    public void etsyTitle(){
        driver.get("https://etsy.com/");
    }

}
