package com.cydeo.test.extra_practice_pdf;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.extra_practice_pdf.utilities.SmartBearUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBearContinue extends TestBase {

    @Test
    public void orderVerification() {

//    TC#3: Smartbear software order verification
//1. Open browser and login to Smartbear software
        SmartBearUtils.loginToSmartBear(driver);

//2. Click on View all orders
        driver.findElement(By.cssSelector("a[href='Default.aspx']")).click();

//3. Verify Susan McLaren has order on date “01/05/2010”
        String cellSusan = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Susan McLaren']")).getText();
        Assert.assertEquals(cellSusan, "Susan McLaren");

        String cellSusanOrderDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Susan McLaren']/following-sibling::td[.='01/05/2010']")).getText();
        Assert.assertEquals(cellSusanOrderDate, "01/05/2010");

    }
}
