package com.cydeo.test.day16_actions_jselector;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HW02_Using_ExecuteScript {

    @Test
    public void useExecuteScript() {
//    TC #7: Scroll using JavascriptExecutor
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.large"));

//3- Scroll down to “Cydeo” link
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        //this method works by index, if only one element->it starts from 0 index
        js.executeScript("arguments[0].scrollIntoView(true)", cydeoLink);

//4- Scroll up to “Home” link
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));
        js.executeScript("arguments[0].scrollIntoView(true)",homeLink);

//5- Use below provided JS method only
//    JavaScript method to use : arguments[0].scrollIntoView(true)
//    Note: You need to locate the links as web elements and pass them as
//    arguments into executeScript() method
Driver.closeDriver();

    }
}
