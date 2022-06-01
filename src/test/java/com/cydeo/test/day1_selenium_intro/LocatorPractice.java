package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorPractice {
    public static void main(String[] args) {
        //set up driver
        WebDriverManager.chromedriver().setup();
        //to create an instance
        WebDriver driver = new ChromeDriver();
        //to max the screen
        driver.manage().window().maximize();
        //to navigate to the page
        driver.get("https://app.vytrack.com/user/login");

        //enter user name provided: "abcd"
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("abcd");

        //enter password provided: "abcd"
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("abcd");

        //click on login button
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        //verify the message "Invalid username or password"
        WebElement alert = driver.findElement(By.className("alert"));
        if(alert.getText().equals("Invalid user name or password.")) {
            System.out.println("Msg is passed");
        }else{
            System.out.println("Msg is failed");
        }

        //verify URL contains "vytrack"
        String actualURL = driver.getCurrentUrl();
        if(actualURL.contains("vytrack")){
            System.out.println("URL is passed");
        }else{
            System.out.println("URL is failed");
        }

        //click "forgot your password?" link
        driver.findElement(By.partialLinkText("Forgot")).click();

        //verify title is "Forgot Password"
        if(driver.getTitle().equals("Forgot Password")){
            System.out.println("title is correct");
        }else{
            System.out.println("title is incorrect");
        }
    }

}
