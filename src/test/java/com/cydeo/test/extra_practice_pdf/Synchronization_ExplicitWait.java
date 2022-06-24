package com.cydeo.test.extra_practice_pdf;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.testng.Assert.assertTrue;

public class Synchronization_ExplicitWait {

    @Test
    public void test_WaitForExpectedTitle(){
        //1- Navigate to the page
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading");
        //2- find the element to click on
        Driver.getDriver().findElement(By.partialLinkText("Example 7:")).click();
        //3- create the object of the WebDriverWait and put how long is the wait in this case 10s
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        //4- state the conditions => we wait until the title of the page is "Dynamic title"
        wait.until(titleIs("Dynamic title"));

        //5- Locate the msg that appears after loaded to the new Page
        WebElement doneMsg = Driver.getDriver().findElement(By.id("alert"));

        //6- Assert if the located msg was displayed
        assertTrue(doneMsg.isDisplayed());

        Driver.closeDriver();
    }








}
