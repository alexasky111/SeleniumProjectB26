package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_isDisplayedFalse {
    public static void main(String[] args) {

        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://www.tesla.com/
        driver.get("https://www.tesla.com/");
        //3- Locate Solar Panels header
        WebElement solarPanelHeader = driver.findElement(By.xpath("(//h1[contains(text(), 'Solar Panels')])[1]"));
        //4- Verify if it is dispayed on the page
        System.out.println("solarPanelHeader.isDisplayed() = " + solarPanelHeader.isDisplayed());

        driver.quit();
    }
}
