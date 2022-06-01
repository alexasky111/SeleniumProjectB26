package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementByXpath {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        //search for cydeo with Xpath --> //input[@name='q']
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("cydeo"+ Keys.ENTER);

        //verify cydeo link w/ Xpath
        WebElement cydeoText = driver.findElement(By.xpath("//h3[.='Cydeo']"));
        //other way:
        //    //div[@class='yuRUbf']//h3[.='Cydeo']

        if(cydeoText.getText().equals("Cydeo")){
            System.out.println("Cydeo Text is appeared");
        }else{
            System.out.println("Cydeo Text didn't appeared");
        }


        driver.quit();
    }

}
