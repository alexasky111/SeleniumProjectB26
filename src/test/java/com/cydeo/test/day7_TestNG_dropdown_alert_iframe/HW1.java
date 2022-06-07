package com.cydeo.test.day7_TestNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW1 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //    TC : Selecting date on dropdown and verifying
//    1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void testDropdown() {
        //    3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropDownPart = new Select(driver.findElement(By.id("year")));
        Select monthDropDownPart = new Select(driver.findElement(By.id("month")));
        Select dayDropDownPart = new Select(driver.findElement(By.id("day")));

//    Select year using : visible text
        yearDropDownPart.selectByVisibleText("1923");
//    Select month using : value attribute Select
        monthDropDownPart.selectByValue("11");
//    day using : index number
        dayDropDownPart.selectByIndex(0);
       String actualYear = yearDropDownPart.getFirstSelectedOption().getText();
       String expectedYear = "1923";
        Assert.assertEquals(actualYear,expectedYear);


    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

}
