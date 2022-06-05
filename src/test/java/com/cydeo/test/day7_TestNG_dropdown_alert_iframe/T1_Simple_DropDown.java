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

public class T1_Simple_DropDown {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //TC #1: Verifying “Simple dropdown” and “State selection” dropdown default values
        //1. Open Chrome browser
        System.out.println("bf m-thod is running");
        // set up chrome and create WebDriver instance
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void dropDownTest() {

//3. Verify “Simple dropdown” default selected value is correct
//    Expected: “Please select an option”
        Select simpleDropDown = new Select(driver.findElement(By.id("dropdown")));

        //getFirstSelectedOPtion() methos will return to default selected option. Return type is webelement so we have to use getText() to return a string
        String actualResult = simpleDropDown.getFirstSelectedOption().getText();
        String expectedResult = "Please select an option/";

        Assert.assertEquals(actualResult, expectedResult);


    }
    @Test
    public void stateDropdownTest(){
//4. Verify “State selection” default selected value is correct
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        String actualStateDefaultText = stateDropdown.getFirstSelectedOption().getText();
        String expectedStateDefaultText = "Select a State";

        Assert.assertEquals(actualStateDefaultText, expectedStateDefaultText);

//    Expected: “
//    Select a State”
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}