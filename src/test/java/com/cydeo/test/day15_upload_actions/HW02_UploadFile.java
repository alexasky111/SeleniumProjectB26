package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW02_UploadFile {

    @Test
    public void uploadTest() {
// TC #2 Upload Test
//1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get(ConfigurationReader.getProperty("practice.cydeo.url"));

//2. Find some small file from your computer, and get the path of it.
        String filePath = "C:\\Users\\AlexaSky\\Desktop\\some-file.txt";

//3. Upload the file.
        Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']")).sendKeys(filePath);
        Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']")).click();

//4. Assert:
//-File uploaded text is displayed on the page
        WebElement msg = Driver.getDriver().findElement(By.xpath("//h3"));
        Assert.assertTrue(msg.isDisplayed());


    }
}
