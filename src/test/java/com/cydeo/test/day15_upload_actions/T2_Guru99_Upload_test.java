package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_test {
    /*           First way: 
     #1- Right click on the file 
     #2- Go to "Properties" 
     #3- Go to "Security" tab from the top of the page 
     #4- Copy path from there and paste where needed
         Second way: 
    #1- Right click on the file 
    #2- Go to "Properties" 
    #3- Copy from the "Location" and paste in where ever needed
     */
    @Test
    public void upload_file_test() throws InterruptedException {
//    1. Go to “http://demo.guru99.com/test/upload”
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.upload.url"));

//    2. Upload file into Choose File
        WebElement chooseFileElem = Driver.getDriver().findElement(By.id("uploadfile_0"));
        String path = "C:\\Users\\AlexaSky\\Desktop\\some-file.txt";
        chooseFileElem.sendKeys(path);

//    3. Click terms of service checkbox
        WebElement termsOfService = Driver.getDriver().findElement(By.id("terms"));
        termsOfService.click();

//    4. Click Submit File button
        WebElement submitBtn = Driver.getDriver().findElement(By.id("submitbutton"));
        submitBtn.click();

//    5. Verify expected message appeared.
//    Expected: “1 file
//    has been successfully uploaded.”
        WebElement msg = Driver.getDriver().findElement(By.id("res"));
        String actualResultMsg = msg.getText();
        String expectedResultMsg = "1 file\nhas been successfully uploaded.";
        Thread.sleep(3000);

        Assert.assertEquals(actualResultMsg, expectedResultMsg);

        Driver.closeDriver();
    }

}
