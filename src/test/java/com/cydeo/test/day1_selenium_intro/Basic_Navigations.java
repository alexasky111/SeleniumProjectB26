package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Navigations {
    public static void main(String[] args) throws InterruptedException {

        // 1 -Setting up a webdriver manager
        WebDriverManager.chromedriver().setup();

        // 2 -Create an instance of webdriver
        WebDriver driver = new ChromeDriver();
        Thread.sleep(3000);

        // 3 -Make our page full screen
        driver.manage().window().maximize();


        //get() method navigates to page
        driver.get("https://www.etsy.com");

        // works as get() method, going back, going forward options are used w/ navigate()
        // driver.navigate().to("https://www.etsy.com");

        // gives time, stops an application and see what's happening; for 3 seconds we use 3000milliseconds
        Thread.sleep(3000);

        // going back to do empty one
        driver.navigate().back();

        //navigate().forward() method is for navigating to forward from web page
        driver.navigate().forward();

        //navigate().refresh() method for refreshing the page
        driver.navigate().refresh();

        //gives you a title of the page
        System.out.println("Etsy page: driver.getTitle() = " + driver.getTitle());
        //gives you a current url of the page
        System.out.println("Etsy Current URL: driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //to store it to a variable and then print a variable
        //String currentTitle = driver.getTitle();

        driver.get("https://www.tesla.com");
        System.out.println("Tesla page: driver.getTitle() = " + driver.getTitle());
        System.out.println("Tesla Current URL: driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //this will close the currently opened page
        driver.close();

        //quits all pages that are open
        driver.quit();

    }
}
