package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task04_cssSelector_getText {
    public static void main(String[] args) {
        /*
TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Verify “Reset password” button text is as expected:
Expected: Reset password
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //1. located an element by class w/ cssSelector -> extra syntax tagName.valueOfAttribute
        //WebElement resetPasswordButton = driver.findElement(By.cssSelector("button.login-btn"));//WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password'"));
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[class='login-btn'"));

        //2. verifying Reset button text
        String expectedResetButtonText = "Reset password";
        String actualResetButtonText = resetPasswordButton.getText();

        System.out.println(actualResetButtonText.equals(expectedResetButtonText)? "passed": "failed");

        driver.quit();

    }
}
