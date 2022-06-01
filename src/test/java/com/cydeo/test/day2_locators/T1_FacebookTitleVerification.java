package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_FacebookTitleVerification {

    public static void main(String[] args) {

//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        2. Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");
//        3. Verify title:
//        Expected: “Facebook - log in or sign up”
        //we must store 1st
          String expectedTitle = "Facebook - log in or sign up";
          String actualTitle = driver.getTitle();
        //then verify if they are matching or not
          if(actualTitle.equals(expectedTitle)){
              System.out.println("test passed");
          }else{
              System.out.println("test failed");
          }

          driver.quit();

    }
}
