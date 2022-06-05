package com.cydeo.test.day6_StaleElement_TestNG;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Homework2SlateException {
    @Test
    public void catchException() {
//        1. Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//        2. Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest ");
//        3. Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLinkBtn = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLinkBtn.isDisplayed() = " + cydeoLinkBtn.isDisplayed());
//        4. Refresh the page.
        driver.navigate().refresh();
        WebElement cydeoLinkBtn1 = driver.findElement(By.xpath("//a[.='CYDEO']"));
//        5. Verify it is displayed, again.
        System.out.println("cydeoLinkBtn1.isDisplayed() = " + cydeoLinkBtn1.isDisplayed());



        /*This is a simple StaleElementReferenceException to
        understand what is this exception and how to handle it.

*** In this practice StaleElementReferenceException is
        coming because of navigation(refresh). When exception
        comes because of navigation, we should handle with
        reassigning (relocating) the web element after navigation
        happens.

         */

    }
}
