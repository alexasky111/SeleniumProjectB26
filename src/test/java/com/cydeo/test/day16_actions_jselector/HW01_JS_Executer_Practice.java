package com.cydeo.test.day16_actions_jselector;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class HW01_JS_Executer_Practice {

    @Test
    public void practiceScrolling() {
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get(ConfigurationReader.getProperty("infiniteScroll"));
//3- Use below JavaScript method and scroll
        //1- Create an obj
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //2- Run a loop 10 times
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,750)");
            js.executeScript("window.scrollBy(0,-750)");
        }
//        a.750 pixels down 10 times.
//        b.750 pixels up 10 times
//JavaScript method to use : window.scrollBy(0,0)


    }
}
