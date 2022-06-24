package com.cydeo.test.pages;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryLogInTest {

    @Test
    public void positiveLogInTest(){
        //1- To navigate to the page 1st
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage_POMPractice loginPage = new LibraryLoginPage_POMPractice();

        loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.student.email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.student.password"));
        loginPage.signInBtn.click();
    }

    @Test
    public void negativeLogingTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage_POMPractice loginPage = new LibraryLoginPage_POMPractice();

//        loginPage.email.sendKeys("abc@gmail.com");
//        loginPage.password.sendKeys("abcd");
//        loginPage.signInBtn.click();
        loginPage.login(ConfigurationReader.getProperty("library3.student.email"), ConfigurationReader.getProperty("library3.student.password"));

        String actualMsg = loginPage.errorMsg.getText();
        String expectedMsg = "Sorry, Wrong Email or Password";
        Assert.assertEquals(actualMsg, expectedMsg);

        Driver.closeDriver();
    }
}
