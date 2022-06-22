package com.cydeo.test.extra_practice_pdf;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMilege extends TestBase {
    @Test
    public void gasMileageTest() throws InterruptedException {
        //2. Go to https://www.calculator.net
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator.url"));

        //3. Search for “gas mileage” using search box
        Driver.getDriver().findElement(By.cssSelector("input[id='calcSearchTerm']")).sendKeys("gas mileage");

        //4. Click on the “Gas Mileage Calculator” link
        Driver.getDriver().findElement(By.xpath("//a[text()='Gas Mileage Calculator']")).click();

        //5. On Next page verify:
        //    a. Title equals: “Gas Mileage Calculator”
        //    b. “Gas Mileage Calculator” label is displayed

        Assert.assertEquals(Driver.getDriver().getTitle(), "Gas Mileage Calculator");
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h1[text()='Gas Mileage Calculator']")).isDisplayed());

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement odometer = Driver.getDriver().findElement(By.cssSelector("input[name='mucodreading']"));
        odometer.clear();
        odometer.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer = Driver.getDriver().findElement(By.cssSelector("input[name='mupodreading']"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

        //8.Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = Driver.getDriver().findElement(By.cssSelector("input[value='50']"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = Driver.getDriver().findElement(By.xpath("//input[@type='text'][@name='mugasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        Driver.getDriver().findElement(By.xpath("(//tbody/tr[5]//td//input[@value='Calculate'])[2]")).click();

        //11. Verify mpg value is as expected: Expected value: “23.44 mpg”
        String actualMpg = Driver.getDriver().findElement(By.xpath("//font//b[contains(text(), '23.44 km/L')]")).getText();
        System.out.println("actualMpg = " + actualMpg);
        String expectedMpg = "23.44";
        Assert.assertTrue(actualMpg.contains(expectedMpg));

        Driver.closeDriver();

    }
}
