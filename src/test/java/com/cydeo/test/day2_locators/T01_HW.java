package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_HW {
    /*
    TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google
     */

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://google.com");

        WebElement gmailButton = driver.findElement(By.linkText("Gmail"));
        gmailButton.click();
        Thread.sleep(3000);

        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle.contains(expectedTitle)? "Title test case is passed": "Title test case is failed");

        driver.navigate().back();
        String expectedTitle1 = "Google";
        String actualTitle1 = driver.getTitle();
        System.out.println(actualTitle1.contains(expectedTitle1)? "Title test case is passed": "Title test case is failed");


        driver.quit();

    }
}
