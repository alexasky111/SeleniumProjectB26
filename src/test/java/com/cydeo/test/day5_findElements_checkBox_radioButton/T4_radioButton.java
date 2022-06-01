package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T4_radioButton {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //providing extra time for our driver bf it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // 1. Open Chrome browser
       // 2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons ");
       // 3. Click to “Hockey” radio button
        WebElement hockeyRadioBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadioBtn.click();
       // 4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("hockeyRadioBtn.isSelected() = " + hockeyRadioBtn.isSelected());

        //Locate green button
        WebElement greenButton = driver.findElement(By.xpath("//input[@id='green']"));

        //verify if it is enabled
        //System.out.println("greenButton.isSelected() = " + greenButton.isSelected());
        System.out.println("greenButton.isEnabled() = " + greenButton.isEnabled());
    }
}
