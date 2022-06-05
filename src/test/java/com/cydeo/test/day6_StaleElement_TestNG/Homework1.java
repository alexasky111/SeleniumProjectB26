package com.cydeo.test.day6_StaleElement_TestNG;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Homework1 {

    @Test
    public void testEtsy() throws InterruptedException {
//        TC: Etsy checkbox and radio button
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        1. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
//        2. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
//        3. Click on filters

        WebElement filtersBtn = driver.findElement(By.xpath("//span[.='All Filters']"));
        filtersBtn.click();
//        4. Select free shipping, on sale
        WebElement freeShippingCheckBtn = driver.findElement(By.xpath("(//label[@class='wt-checkbox__label wt-display-inline'])[1]"));
        freeShippingCheckBtn.click();

        WebElement onSaleBtn = driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSaleBtn.click();
//        5. Select under $25 Click on apply filters
        WebElement shippingUnder$25Btn = driver.findElement(By.xpath("//label[contains(.,'Under $25')]"));
        shippingUnder$25Btn.click();
        Thread.sleep(5000);
        System.out.println("shippingUnder$25Btn.isSelected() = " + shippingUnder$25Btn.isSelected());
        WebElement applyBtn = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
        applyBtn.click();
//        6. Print count of results
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Remove At Most $25 Filter']")));
        WebElement results = driver.findElement(By.xpath("//span[@class='wt-display-inline-flex-sm']/span[1]"));
        System.out.println(results.getText());
        driver.quit();
    }
}
