package com.cydeo.test.day3_Css_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01_locators_getText {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

//        WebElement username = driver.findElement(By.name("USER_LOGIN"));
//        username.sendKeys("incorrect");
        WebElement username = driver.findElement(By.className("login-inp"));
        username.sendKeys("incorrect");

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect"); //+ Keys.ENTER

        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();
        WebElement errorMsg = driver.findElement(By.className("errortext"));

        String expectedText = "Incorrect login or password";
        //getText() method; it will get the content(text) form in between the opening and closing tag
        String actualText = errorMsg.getText();
        System.out.println(actualText.equals(expectedText)? "Passed": "Failed");

                driver.quit();

    }

    /*
    TC #1: NextBaseCRM, locators and getText() practice 1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password

     */
}
