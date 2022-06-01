package com.cydeo.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifyRadioButton {
    /*
    Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)

Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true
     */

    public static boolean clickAndVerifyRadioButton(WebDriver driver, String attributeName, String id) {

        List<WebElement> radioButtons = driver.findElements(By.name(attributeName));

        for (WebElement each : radioButtons) {
            if(each.getAttribute("id").equals(id)) {
                each.click();
                return each.isSelected();
            }
            //System.out.println(each.isSelected()? "true": "false");
        }


    return  false;
    }


}
