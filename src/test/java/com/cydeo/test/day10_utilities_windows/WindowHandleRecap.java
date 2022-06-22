package com.cydeo.test.day10_utilities_windows;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleRecap {
    @Test
    public void testWindowHandles(){
        Driver.getDriver().get("https://practice.cydeo.com/windows");

        //1- To store the value of the current window
        String currentWindow = Driver.getDriver().getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);

        //2- To store all of the windows in the Set
        Set<String> allWindows = Driver.getDriver().getWindowHandles();
        System.out.println("allWindows = " + allWindows);

        WebElement clickBtn = Driver.getDriver().findElement(By.linkText("Click Here"));
        clickBtn.click();

        System.out.println("after clicking btn "+Driver.getDriver().getWindowHandle());
        System.out.println("after clicking btn "+Driver.getDriver().getWindowHandles());

        //3- To get a title of each of the windows
        allWindows = Driver.getDriver().getWindowHandles();
        for(String eachHandle:allWindows){
            System.out.println("eachHandle = " + eachHandle);
            Driver.getDriver().switchTo().window(eachHandle);
            System.out.println("Driver.getDriver() = " + Driver.getDriver());
        }

    }
}
