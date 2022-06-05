package com.cydeo.test.day6_StaleElement_TestNG;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_StaleElementRefException {
    public static void main(String[] args) {

//    TC #1: StaleElementReferenceException handling
//1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");
// 3. Click to “Add Element” button
        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementBtn.click();
// 4. Verify “Delete” button is displayed after clicking.
        WebElement deleteBtn = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
//5. Click to “Delete” button.
        deleteBtn.click();
//6. Verify “Delete” button is NOT displayed after clicking.

        try {
            System.out.println(deleteBtn.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("This means the WebElement is completely deleted from the page and html");
        }

    }
}