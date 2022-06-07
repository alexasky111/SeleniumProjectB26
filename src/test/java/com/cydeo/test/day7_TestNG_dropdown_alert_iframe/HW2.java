package com.cydeo.test.day7_TestNG_dropdown_alert_iframe;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW2 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        //TC : Selecting value from non-select dropdown
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void nonSelectDropdown() throws InterruptedException {
        //3. Click to non-select dropdown
        WebElement nonSelectDropdown = driver.findElement(By.id("dropdownMenuLink"));
        nonSelectDropdown.click();
        Thread.sleep(3000);
        //4. Select Facebook from dropdown
        WebElement facebookChoice = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebookChoice.click();
        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - log in or sign up";
//            *Remember: If there is no <select> tag, it is called HTML
//    dropdown and We handle just as any other web element.
//    We locate. We click.
        Assert.assertEquals(actualTitle, expectedTitle, "Title Test didn't pass");
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}
