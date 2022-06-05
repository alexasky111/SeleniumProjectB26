package com.cydeo.test.day7_TestNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_StateDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
//        1. Open Chrome browser
//        2. Go to http://practice.cybertekschool.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }


    @Test
    public void stateDropdownTest() throws InterruptedException {
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        System.out.println("stateDropdown = " + stateDropdown);
//        3. Select Illinois (when <select> tag, we must handle w/ Select Class)
        stateDropdown.selectByValue("IL");
//        4. Select Virginia
        stateDropdown.selectByValue("Virginia");
//        5. Select California
        Thread.sleep(3000);
        stateDropdown.selectByIndex(5);
//        6. Verify
//        final selected option is California.
//        Use all Select options. (visible text, value, index)
        //getFirstSelectedOption() -> will return to current selected Option
        String actualStateOption = stateDropdown.getFirstSelectedOption().getText();//use getText() -> bc returns String
        String expectedOption = "California";
        Assert.assertEquals(actualStateOption, expectedOption);

    }

    @Test
    public void multipleSelectDropdownTest() throws InterruptedException {

        // Select all the options from multiple select dropdown.
        Select languages = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        //isMultiple() -> will return if there are multiple elements or no
        //System.out.println(languages.isMultiple());

//        languages.selectByValue("java");
//        languages.selectByVisibleText("C#");
//        languages.selectByIndex(3);

//        4. Print out all selected values.
        // .getOptions() method will return to all options in dropdown
        List<WebElement> allOptions = languages.getOptions();
        for (WebElement each : allOptions) {
            each.click();
            Thread.sleep(3000);
            System.out.println("each.getText() = " + each.getText());
        }
//        5. Deselect all values.
        languages.deselectAll();

    }
}
