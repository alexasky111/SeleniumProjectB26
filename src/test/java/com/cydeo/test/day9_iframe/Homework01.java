package com.cydeo.test.day9_iframe;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework01 extends TestBase {
    //    Test cases #1
//    Description:  Users send text messages successfully
//    Environment:  https://login2.nextbasecrm.com/
    @Test
    public void testMessageTab() throws InterruptedException {

        driver.get("https://login2.nextbasecrm.com/");
        //    Steps::
//1.  Users are on the homepage (Login with valid username and password)
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk1@cybertekschool.com");
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

//2.  Users click the MESSAGE tab
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']")));
        //driver.switchTo().frame("//iframe[@class='bx-editor-iframe']");

        //3.  Users write test message
        driver.findElement(By.xpath("//body[@style='min-height: 184px;']")).sendKeys("Verifying Message iFrame");
        driver.switchTo().parentFrame();

//4.  Users click the SEND button
        driver.findElement(By.id("blog-submit-button-save")).click();
        Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[.='Verifying Message iFrame']")));

//5.  Verify the message is displayed on the feed
        WebElement msg = driver.findElement(By.xpath("//div[.='Verifying Message iFrame']"));
        String actualMsg = msg.getText();
        String expectedMsg = "Verifying Message iFrame";

        Assert.assertEquals(actualMsg,expectedMsg, "test failed");

    }

}
