package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_CheckBox {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //providing extra time for our driver bf it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//1. Go to http://practice.cydeo.com/checkboxes
        driver.get("http://practice.cydeo.com/checkboxes");
//2. Confirm checkbox #1 is NOT selected by default
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        if(!checkbox1.isSelected()){
            System.out.println("checkbox1 verification is " + checkbox1.isSelected());
        }else{
            System.out.println("checkbox1 verification is " + checkbox1.isSelected());
        }
//3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());
        Thread.sleep(3000);
//4. Click checkbox #1 to select it.
        checkbox1.click();
        Thread.sleep(3000);
//5. Click checkbox #2 to deselect it.
        checkbox2.click();
//6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
//7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());
    }
}
