package com.cydeo.test.extra_practice_pdf;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.extra_practice_pdf.utilities.SmartBearUtils;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBear extends TestBase {

    @Test
    public void linkVerification() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBear.url"));
        //3. Enter username: “Tester”
        WebElement userName = Driver.getDriver().findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys(ConfigurationReader.getProperty("smartBearUserName"));

        //4. Enter password: “test”
        WebElement password = Driver.getDriver().findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys(ConfigurationReader.getProperty("smartBearPassword"));

        //5. Click to Login button
        WebElement login = Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button"));
        login.click();

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println(allLinks.size());

        //7. Print out each link text on this page
        for (WebElement eachLink : allLinks) {
            System.out.println("eachLink.getText() = " + eachLink.getText());
        }

    }


    @Test
    public void softwareOrderPlacing() throws InterruptedException {


//    TC#2: Smartbear software order placing
//1. Open browser
//2. Go to website:
//    http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//            3. Enter username: “Tester”
//            4. Enter password: “test”
//            5. Click on Login button

        SmartBearUtils.loginToSmartBear(Driver.getDriver());
//6. Click on Order
        Driver.getDriver().findElement(By.cssSelector("a[href='Process.aspx']")).click();

//7. Select familyAlbum from product, set quantity to 2
        WebElement dropDownBtn = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select select = new Select(dropDownBtn);
        select.selectByValue("FamilyAlbum");

        WebElement quantityBtn = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantityBtn.clear();
        quantityBtn.sendKeys("2");

//            8. Click to “Calculate” button
        Driver.getDriver().findElement(By.cssSelector("input[value='Calculate']")).click();

//9. Fill address Info with JavaFaker
//• Generate: name, street, city, state, zip code
        Faker faker = new Faker();

        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetAddress());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());
        String zipCode = faker.address().zipCode().substring(0, 5);
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zipCode);
        //driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.address().zipCode());


//10. Click on “visa” radio button
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();


//11. Generate card number using JavaFaker
        String creditCard = faker.finance().creditCard().replaceAll("-", "");
        //driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.finance().creditCard());
        Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(creditCard);

//      driver.findElement(By.cssSelector("input[name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys(faker.business().creditCardExpiry());
        String expirationDate = faker.business().creditCardExpiry();
        Driver.getDriver().findElement(By.cssSelector("input[name='ctl00$MainContent$fmwOrder$TextBox1']")).sendKeys("12/13");


//12. Click on “Process”
        WebElement processBtn = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processBtn.click();
        Thread.sleep(12000);


//            13. Verify success message “New order has been successfully added.”

        WebElement verificationMsg = Driver.getDriver().findElement(By.xpath("//input[@onclick='UpdateFields()']/following-sibling::strong"));

        Assert.assertEquals(verificationMsg.getText(), "New order has been successfully added.");


    }
}
