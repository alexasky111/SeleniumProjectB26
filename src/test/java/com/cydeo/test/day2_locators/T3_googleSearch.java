package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_googleSearch {
    public static void main(String[] args) {

//    1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//2- Go to: https://google.com/
        driver.get("https://google.com/ ");

//3- Write “apple” in search box
     //4- Click google search button
        WebElement searchBox = driver.findElement(By.name("p"));
        searchBox.sendKeys("apple"+ Keys.ENTER); //Keys.ENTER -> it is a class, that gives an option to use the keyboard; whenever we need to send any text, we can also do Keyboard action

//5- Verify title:
//Expected: Title should start with “apple” word
        String expectedTitle = "apple";//coming from requirement
        String actualTitle = driver.getTitle(); //coming from browser, selenium

        if(actualTitle.startsWith("apple")){
            System.out.println("title verification test has passed");
        }else{
            System.out.println("title verification test has failed");
        }

        driver.quit();

    }
}
