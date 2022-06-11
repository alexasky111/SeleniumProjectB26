package com.cydeo.test.day08_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDate_DropDown {
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
    public void dateDropdownTest() {
        //   3. Select “December 1st, 1923” and verify it is selected.
        Select yearDropDown = new Select(driver.findElement(By.id("year")));
        Select monthDropDown = new Select(driver.findElement(By.id("month")));
        Select dayDropDown = new Select(driver.findElement(By.id("day")));
        for (WebElement eachYearOption : yearDropDown.getOptions()){
            System.out.println(eachYearOption.getText());
        }


//                Select year using   : visible text
        yearDropDown.selectByVisibleText("1923");
//        Select month using    : value attribute Select
        monthDropDown.selectByValue("11");
//        day using : index number
        dayDropDown.selectByIndex(0);

        String actualyearDropDown = yearDropDown.getFirstSelectedOption().getText();
        String expectedyearDropDown = "1923";

        String actualmonthDropDown = monthDropDown.getFirstSelectedOption().getText();
        String expectedmonthDropDown= "December";

        String actualdayDropDown = dayDropDown.getFirstSelectedOption().getText();
        String expecteddayDropDown= "1";

        Assert.assertEquals(actualyearDropDown,expectedyearDropDown);
        Assert.assertEquals(actualmonthDropDown,expectedmonthDropDown);
        Assert.assertEquals(actualdayDropDown,expecteddayDropDown);
//
//        Assert.assertTrue(actualyearDropDown.equals(expectedyearDropDown));
//        Assert.assertTrue(actualmonthDropDown.equals(expectedmonthDropDown));
//        Assert.assertTrue(actualdayDropDown.equals(expecteddayDropDown));



    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

