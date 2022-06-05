package com.cydeo.test.day7_TestNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    @Test
    public void googleTitle(){
        // set up chrome and create WebDriver instance
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Get "https://google.com/"
        driver.get("https://google.com/");
        // Assert: title is  "Google"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        //3rd argument is optional for failed msg
        Assert.assertEquals(actualTitle,expectedTitle,"Title ver is failed");

    }

}
