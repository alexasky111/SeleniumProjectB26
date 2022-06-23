package com.cydeo.test.day16_actions_jselector;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Guru99DragandaDrop_Test {

    @Test
    public void guru99_dragAndDrop_test() {
//    1- Open a chrome browser
//    2- Go to: https://demo.guru99.com/test/drag_drop.html
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.dropdown"));

//    3- Drag “BANK” and drop into Account area under Debit Side
        WebElement bank = Driver.getDriver().findElement(By.partialLinkText("BANK"));
        WebElement debitAcc = Driver.getDriver().findElement(By.id("bank"));

        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(bank, debitAcc).perform();

//    4- Drag “5000” and drop into Amount area under Debit Side
        WebElement fiveK = Driver.getDriver().findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement amountDrop = Driver.getDriver().findElement(By.xpath("//ol[@id='amt7']"));
        actions.dragAndDrop(fiveK, amountDrop).perform();

//    5- Drag “SALES” and drop into Account area under Credit Side
        WebElement sales = Driver.getDriver().findElement(By.xpath("//li[@id='credit1']//a"));
        WebElement accCreditSide = Driver.getDriver().findElement(By.xpath("//ol[@id='loan']"));
        actions.dragAndDrop(sales, accCreditSide).perform();

//    6- Drag “5000” and drop into Amount area under Credit Side
        WebElement amountCredit = Driver.getDriver().findElement(By.id("amt8"));
        actions.dragAndDrop(fiveK, amountCredit).perform();

//    7- Verify “Perfect!” text displayed.
        Assert.assertTrue(Driver.getDriver().findElement(By.partialLinkText("Perfect!")).isDisplayed());
        Driver.closeDriver();

    }
}
