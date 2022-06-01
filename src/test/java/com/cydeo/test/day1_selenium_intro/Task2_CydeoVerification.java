package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_CydeoVerification {
    /*
    TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
Expected: Practice
     */

    public static void main(String[] args) {

        //to start any project do these 3 steps
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //You must do this, so Inteliji knows what we are comparing with
        driver.get("https://practice.cydeo.com");

        String expectedUrl = "cydeo"; //it comes from requirement
        String actualUrl = driver.getCurrentUrl(); //it comes from selenium


        if(actualUrl.contains(expectedUrl)){
            System.out.println("Url verification is passed!");
        }else{
            System.out.println("Url verification is failed!");
        }

        String expectedTitle = "Practice"; //it comes from requirement
        String actualTitle = driver.getTitle(); //it comes from selenium

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is passed!");
        }else{
            System.out.println("Title verification is failed!");
        }





        driver.quit();
    }
}
