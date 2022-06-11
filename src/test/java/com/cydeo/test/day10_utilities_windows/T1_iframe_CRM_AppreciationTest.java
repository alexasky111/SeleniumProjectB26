package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_iframe_CRM_AppreciationTest extends TestBase {

    @Test
    public void sendingAppreciationMsg() throws InterruptedException {
//        2- Go to: https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");
//        3- Login Homepage ( Login with valid username and
//                password)
        CRM_Utilities.crm_login(driver,"helpdesk1@cybertekschool.com", "UserUser" );
//        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
//        userName.sendKeys("helpdesk1@cybertekschool.com");
//
//        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
//        password.sendKeys("UserUser");
//
//        WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
//        logInBtn.click();

//        4- Click the MORE tab and select APPRECIATION
        WebElement moreBtn = driver.findElement(By.xpath("//span[contains(@id,'link-text')]"));
        moreBtn.click();
        Thread.sleep(3000);
        //cssSelector -> span[id*='link-text']

        WebElement appreciation = driver.findElement(By.xpath("//span[.='Appreciation']"));
        appreciation.click();

//        5- Write an Appreciation message
        //bc there is an iframe we have to switch to frame by id, any locator or Index Number-but it's not good
        driver.switchTo().frame(driver.findElement(By.cssSelector(".bx-editor-iframe")));
        driver.findElement(By.tagName("body")).sendKeys("Hello");
        //to proceed we have to go out of iframe and come back to default content -> main html part
        driver.switchTo().defaultContent();

//        6- Click the SEND button
        driver.findElement(By.id("blog-submit-button-save")).click();

//        7- Verify the Appreciation message is displayed on
//        the feed
        WebElement feedText = driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body')]"));
        Assert.assertEquals(feedText.getText(), "Hello!");

    }
}
