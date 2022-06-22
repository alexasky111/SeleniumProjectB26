package com.cydeo.test.day14_driverUtil_javaFaker;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch_DriverPractice {

    @Test
    public void google_search_driver_practice(){

        // Go to "https://www.google.com/"
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));

        // Write “apple” in search box
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("apple"+ Keys.ENTER);

        // Verify title:
        //Expected: apple - Google Search
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple - Google Search";
        Assert.assertEquals(actualTitle, expectedTitle);

        Driver.closeDriver();

    }
}
