package com.cydeo.test.extra_practice_pdf;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T01_FindElements extends TestBase {

    @Test
    public void findLinksTest() {
//    TC #1: Checking the number of links on the page
//1. Open Chrome browser
//2. Go to https://www.openxcell.com
        driver.get("https://www.openxcell.com");

//3. Count the number of the links on the page and verify
//    Expected: 332
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        Assert.assertEquals(allLinks.size(), 337);
    }

    @Test
    public void printLinks() {
//        TC #2: Printing out the texts of the links on the page
//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com
//        3. Print out all of the texts of the links on the page
        driver.get("https://www.openxcell.com");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        try {
            for (WebElement eachLink : allLinks) {
                if (!eachLink.getText().isEmpty())
                    System.out.println("eachLink.getText() = " + eachLink.getText());
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException is thrown");
        }
    }

    @Test
    public void countLinksWithNoText() {
//        TC #3: Counting the number of links that does not have text
//        1. Open Chrome browser
//        2. Go to https://www.openxcell.com
//        3. Count the number of links that does not have text and verify
//        Expected: 109
        driver.get("https://www.openxcell.com");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int count = 0;
        try {
            for (WebElement each : allLinks) {

                if (each.getText().isEmpty()) {
                    count++;
                }
            }
            Assert.assertEquals(count, 109);

        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException is thrown");
        }
    }
}