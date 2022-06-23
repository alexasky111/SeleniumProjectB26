package com.cydeo.test.day16_actions_jselector;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_JSExecutor_Scroll {

    @Test
    public void etsy_scroll_test() {
//* Goto Etsy homepage
        Driver.getDriver().get(ConfigurationReader.getProperty("etsyUrl"));

//* Scroll down(positive) / Scroll up(negative) --> works as y and x in geometry
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // window.scrollBy(x, y)  ; x(right or left) stands for horizontal line and y stands for vertical line(up or down)
        // js.executeScript("window.scrollBy(0, 5000)");

//* Generate random email and enter into subscribe box
        WebElement emailBox = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        js.executeScript("arguments[0].scrollIntoView(true)", emailBox);
        //you are passing an index num your emailBox is index 0, if you have more parameters you have change index number

//* Click on Subscribe
        Faker faker = new Faker();
        emailBox.sendKeys(faker.internet().emailAddress() + Keys.ENTER);

//*Verify "Great! We've sent you an email to confirm your subscription." is displayed
        WebElement msg = Driver.getDriver().findElement(By.xpath("//div[contains(@class,'wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01')]"));
        String actualMsgText = msg.getText();
        String expectedMsgText = "Great! We've sent you an email to confirm your subscription.";
        Assert.assertEquals(actualMsgText, expectedMsgText);

        Driver.closeDriver();
    }
}
