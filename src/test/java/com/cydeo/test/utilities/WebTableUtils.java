package com.cydeo.test.utilities;
//Method #1 info:
//• Name: returnOrderDate ()
//• Return type: String
//• Arg1: WebDriver driver
//• Arg2: String costumerName
//This method should accept a costumerName and return the costumer order date
//as a String.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableUtils {
    public static String returnOrderDate(WebDriver driver, String customerName) {
        //1-
        String locator = "//td[.='" + customerName + "']//following-sibling::td[3]";
        //2-
        WebElement customerDataCell = driver.findElement(By.xpath(locator));
        return customerDataCell.getText();


    }
}
