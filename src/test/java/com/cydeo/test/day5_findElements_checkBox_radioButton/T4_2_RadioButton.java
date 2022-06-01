package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.VerifyRadioButton;
import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_2_RadioButton {
    public static void main(String[] args) throws InterruptedException {

    /*Create a utility method to handle above logic.
    Method name: clickAndVerifyRadioButton
    Return type: void or boolean
    Method args:
     */
        // 1. WebDriver
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //providing extra time for our driver bf it throws NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Name attribute as String (for providing which group of radio buttons)
        driver.get("https://practice.cydeo.com/radio_buttons ");
        List<WebElement> sportRadioButtons = driver.findElements(By.xpath("//input[@name='sport']"));

        for (WebElement each : sportRadioButtons) {
            System.out.println(each.getText());
            each.click();
            System.out.println(each.getAttribute("id"));
            System.out.println(each.isSelected());

            //Try the utility method clickAndVerifyRadioButton

            System.out.println(VerifyRadioButton.clickAndVerifyRadioButton(driver, "color", "red"));
            System.out.println(VerifyRadioButton.clickAndVerifyRadioButton(driver, "sport", "chess" ));

        }
        driver.quit();

        // 3. Id attribute as String (for providing which radio button to be clicked)

        //Method should loop through the given group of radio buttons. When it finds the
        //matching option, it should click and verify option is Selected.
        //Print out verification: true
    }
}