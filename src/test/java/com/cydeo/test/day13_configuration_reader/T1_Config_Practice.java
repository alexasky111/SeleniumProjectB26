package com.cydeo.test.day13_configuration_reader;

import com.cydeo.test.utilities.BrowserUtils;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T1_Config_Practice extends com.cydeo.test.base.TestBase {
    @Test
    public void login_crm_app() {
//        1. Create new test and make set ups
//        2. Go to : https://login1.nextbasecrm.com/
        //driver.get("https://login1.nextbasecrm.com/");
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

//        3. Enter valid username
        Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(ConfigurationReader.getProperty("username"));
        //inputUsername.sendKeys("helpdesk1@cybertekschool.com");

//        4. Enter valid password
        Driver.getDriver().findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(ConfigurationReader.getProperty("password"));;
        //inputPassword.sendKeys("UserUser");

//        5. Click to Log In button
        Driver.getDriver().findElement(By.xpath("//input[@value='Log In']")).click();

//        6. Verify title is as expected:
//        Expected: Portal
        BrowserUtils.verifyTitle(Driver.getDriver(), "Portal");
        Driver.closeDriver();
    }
}
