package com.cydeo.test.day08_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //    TC : Selecting date on dropdown and verifying
//    1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    2. Go to https://practice.cydeo.com/dropdown
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void confirmAlert() {

//        3. Click to “Click for JS Confirm” button
        WebElement jsButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsButton.click();
//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
//        5. Verify “You clicked: Ok” text is displayed.
        WebElement msg = driver.findElement(By.id("result"));

        Assert.assertTrue(msg.isDisplayed(),"res text did not appear");
        Assert.assertEquals(msg.getText(), "You clicked: Ok");

    }
    @Test
    public void confirmAlert1(){
        //        3. Click to “Click for JS Confirm” button
        WebElement jsPromtBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromtBtn.click();
//        4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
//        5. Verify “You clicked: Ok” text is displayed.
        WebElement msg1 = driver.findElement(By.id("result"));

        Assert.assertTrue(msg1.isDisplayed(),"res text did not appear");
        Assert.assertEquals(msg1.getText(), "You entered:");
    }


    @AfterMethod
    public void confirmAlertTest() {
        driver.quit();
    }
}
