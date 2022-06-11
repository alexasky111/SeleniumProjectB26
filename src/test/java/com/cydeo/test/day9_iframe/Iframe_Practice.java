package com.cydeo.test.day9_iframe;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Iframe_Practice extends TestBase {

    @Test
    public void iframeTest() {
//        2- Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");

// NoSuchElement exception comes w/ reasons: 1- Not locating correctly an element
//                                           2- There is an Iframe and you have ti switch                                                 to frame element
        //we can use frame(id) method w/ id arg
        driver.switchTo().frame("mce_0_ifr");

//        3- Clear text from comment body
        WebElement commentBody = driver.findElement(By.id("tinymce"));

        //we can use frame(locator)
        //driver.switchTo().frame("//iframe[@id='mce_0_ifr']");
        //we can use frame(index number); index starts from 0, we can find iframe tags from html w/ using xpath "//iframe"
        //driver.switchTo().frame(0);

        commentBody.clear();// .clear() -> deletes text from comment body
//        4- Type "Hello World" in comment body
        commentBody.sendKeys("Hello World");
//        5- Verify "Hello World" text is written in comment body
        Assert.assertEquals(commentBody.getText(), "Hello World");
        //if you have nested frame and if you want to switch 1 frame to direct frame parent of this frame
        driver.switchTo().parentFrame();
        //defaultContent() method will switch to main HTML(Parent of all HTML)
        // driver.switchTo().defaultContent();
//        6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
        WebElement headerText = driver.findElement(By.tagName("h3"));

        assertTrue(headerText.isDisplayed(), "Header text did not appear!");

        String actualHeader = headerText.getText();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";

        assertEquals(actualHeader, expectedHeader, "Header text did not appear!");
    }
}
