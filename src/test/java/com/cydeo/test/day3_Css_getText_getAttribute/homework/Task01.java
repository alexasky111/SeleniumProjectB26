package com.cydeo.test.day3_Css_getText_getAttribute.homework;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task01 {
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        //1- locate rememberMeButton
        WebElement rememberMeButton = driver.findElement(By.cssSelector("label.login-item-checkbox-label"));
        //2- verify "remember me" text
        String expectedText = "Remember me on this computer";
        String actualText = rememberMeButton.getText();

        System.out.println(actualText.equals(expectedText) ? "Remember Me label Text has passed the test" : "Remember Me label Text has failed the test");

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        //3- locate forgotPassword
        WebElement forgotPassword = driver.findElement(By.className("login-link-forgot-pass"));
        //4- verify forgotPassword text
        expectedText = "Forgot your password?";
        actualText= forgotPassword.getText();
        System.out.println(actualText.equalsIgnoreCase(expectedText) ? "Verify forgot your password is passed" : "Verify forgot your password is failed");

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("a[href='/?forgot_password=yes']"));
        expectedText = "forgot_password=yes";
        actualText = forgotPassword2.getAttribute("href");

        System.out.println(actualText.contains(expectedText)? "href attribute’s value test is passed": "href attribute’s value test is failed");



        driver.quit();

    }




}
