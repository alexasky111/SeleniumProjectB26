package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerification {
    /*
    TC #1: Yahoo Title Verification
1. Open Chrome browser
2. Go to https://www.yahoo.com/
3. Verify title:
Expected: Yahoo
     */
    public static void main(String[] args) {
        //1st is always to set up  WebDriverManager
        WebDriverManager.chromedriver().setup();


        //2nd to create webdriver instance
        WebDriver driver = new ChromeDriver();

        //to maximize the screen
        driver.manage().window().maximize();

        driver.get("https://www.yahoo.com");

        //to find a title->getTitle() and store in the String
        //actual title comes from selenium
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        //expected title comes from requirements
        String expectedTitle = "Yahoo";

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title verification is passed!");
        } else {
            System.out.println("Title verification is failed!");
        }

        driver.quit();
        /*
        url is in the search bar w/ .com -> getCurrentUrl()
        title on the tab area -> getTitle() (it is in the <head> when looking in HTML)
         */
    }
}
