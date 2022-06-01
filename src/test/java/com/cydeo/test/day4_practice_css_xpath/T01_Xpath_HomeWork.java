package com.cydeo.test.day4_practice_css_xpath;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T01_Xpath_HomeWork {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cydeo.com/forgot_password");
        //1- To locate emailBox
        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
        emailBox.sendKeys("alexasky111@gmail.com");

        //2- To locate Retrieve Password button
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        /*
        tagName[.='text'] same as //tagName[text()='text’]
          . --> stands for text in xpath
         */
        retrievePasswordButton.click();

        String expectedUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();
        System.out.println((actualUrl.contains(expectedUrl) ? "Url test passed successfully" : "Url test failed"));
        //if no attributes, but only tagName & Text, then syntax is -> //h2[.='Your e-mail's been sent!']
        //3- To locate textBox
        WebElement textBox = driver.findElement(By.xpath("//h4[@name='confirmation_message']"));
        String expectedText = "Your e-mail's been sent!";
        String actualText = textBox.getText();

        System.out.println(actualText.contains(expectedText)? "Your verification has passed": "Your verification has failed");

        driver.quit();


    }
    /*
    TC #3: Practice Cydeo/ForgotPassword URL verification
1. Open Chrome browser
2. Go to http://practice.cydeo.com/forgot_password
3. Enter any email into input box
4. Click on Retrieve password
5. Verify URL contains:
Expected: “email_sent”
6. Verify textbox displayed the content as expected.
Expected: “Your e-mail’s been sent!”

Hint: You need to use getText method for this practice.
     */
}
