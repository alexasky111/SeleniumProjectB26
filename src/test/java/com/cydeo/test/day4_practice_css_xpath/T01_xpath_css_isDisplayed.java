package com.cydeo.test.day4_practice_css_xpath;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T01_xpath_css_isDisplayed {
    public static void main(String[] args) {

        //TC #1: XPATH and cssSelector Practices
//1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

//2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

//3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link:
        //cssSelector
        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));
        //href value
        WebElement homeLink1 = driver.findElement(By.cssSelector("a[href='/']"));
        //X-path:  tagName[@attribute='value']
        //Locate homeLink using xpath with text of element
        WebElement homeLink4 = driver.findElement(By.xpath("//a[.='Home']")); // xpath(text()='Home')
        //Locate homeLink using xpath
        WebElement homeLink5 = driver.findElement(By.xpath("//a[@class='nav-link']"));

//b. “Forgot password” header using cssSelector(from parent to child w/ ">" ) --> div.example>h2
        WebElement forgotPasswordHeader = driver.findElement(By.cssSelector("div[class='example']>h2"));
        //Locate forgotPassword using xpath
        WebElement forgotPassword3 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

//c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));
        //Locate Email text using xpath
        WebElement emailText1 = driver.findElement(By.xpath("//label[@for='email']"));

//d. E-mail input box
        WebElement inputBox = driver.findElement(By.cssSelector("input[name='email']"));
        //Locate Email input box using xpath
        WebElement emailInputBox1 = driver.findElement(By.xpath("//input[@name='email']"));

//e. “Retrieve password” button w/ css button#form_submit or button[id='form_submit']>i
        WebElement retrievePassword = driver.findElement(By.cssSelector("button[id='form_submit']>i"));
        WebElement retrievePassword1 = driver.findElement(By.cssSelector("button.radius"));
// f. “Powered by Cydeo text
        WebElement poweredByCydeo = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
//4. Verify all web elements are displayed.
        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("inputBox.isDisplayed() = " + inputBox.isDisplayed());
        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());
        System.out.println("poweredByCydeo.isDisplayed() = " + poweredByCydeo.isDisplayed());

        driver.quit();


    }
}
