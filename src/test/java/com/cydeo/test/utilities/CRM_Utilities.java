package com.cydeo.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {
//
//Method #1 info:
//• Name: login_crm()
//• Return type: void
//• Arg1: WebDriver

    public static void crm_login(WebDriver driver){
        WebElement userName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userName.sendKeys("helpdesk1@cybertekschool.com");

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser");

        WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInBtn.click();
    }

    public static void crm_login(WebDriver driver, String userName, String password){
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys(userName);

        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys(password);

        WebElement logInBtn = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInBtn.click();
    }

}
