package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task03_getAttribute_css {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");

        //Located using type attribute
        //WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

        //Located using value attribute
        //WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));

        //Located using class attribute
        WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

        String expectedButtonText = "Log In";
        //Text -->getTex() is btw opening and closing tags only
        //choosing value attribute bc it have the same text as expectedText
        String actualButtonText = loginButton.getAttribute("value");

        System.out.println("actualButtonText = " + actualButtonText);

        System.out.println(actualButtonText.equals(expectedButtonText)? "passed":"failed");

        driver.quit();

    }
    /*
    TC #3: NextBaseCRM, locators, getText(), getAttribute() practice 1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
     */
}
