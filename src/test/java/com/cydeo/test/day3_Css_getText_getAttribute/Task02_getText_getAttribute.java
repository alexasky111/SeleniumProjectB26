package com.cydeo.test.day3_Css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task02_getText_getAttribute {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/registration_form");
        /*
        3- Verify header text is as expected:
Expected: Registration form
        4- Locate “First name” input box
         */
        //locate headerText to get text btw opening and closing tag
        //   WebElement headerText = driver.findElement(By.sccSelector("div[class='page-header']>h2")); --> used css to go from parent to child
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String expectedText = "Registration form";

        //using getText() for getting the text from the tag name <h2>TEXT</h2>
        String actualText = headerText.getText();

        //verify if actual getText() equals Text from the requirements
        System.out.println(actualText.equals(expectedText)? "passed":"failed");

        //5- Verify placeholder attribute’s value is as expected: Expected: first name
        //WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement firstName = driver.findElement(By.className("form-control"));
        String expectedPlaceHolder = "first name";

        //getAttribute(attribute argument) method is for helping us to get value of attributes
        String actualPlaceHolder = firstName.getAttribute("placeholder");
        System.out.println(actualPlaceHolder.equals(expectedPlaceHolder)?"passed":"failed");

        driver.quit();
    }
    /*
    TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form 4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected: Expected: first name
     */
}
