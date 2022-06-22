package com.cydeo.test.extra_practice_pdf.utilities;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    final static String URL = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    final static String USERNAME = "Tester";
    final static String PASSWORD = "test";

    //Mini-Task: CREATE A CLASS à SmartBearUtils
    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parameter

    public static void loginToSmartBear(WebDriver driver) {
        driver.get(URL);
        //3. Enter username: “Tester”
        WebElement userName1 = driver.findElement(By.id("ctl00_MainContent_username"));
        userName1.sendKeys(USERNAME);

        //4. Enter password: “test”
        WebElement password1 = driver.findElement(By.id("ctl00_MainContent_password"));
        password1.sendKeys(PASSWORD);

        //5. Click to Login button
        WebElement login = driver.findElement(By.id("ctl00_MainContent_login_button"));
        login.click();

        Driver.closeDriver();

    }
}
