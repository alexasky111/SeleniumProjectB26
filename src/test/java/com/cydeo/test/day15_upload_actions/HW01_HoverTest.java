package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW01_HoverTest {
    @Test
    public void hover_test(){
        //    TC #3: Hover Test
//1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo_hover_url"));

// 2. Hover over to first image
        Actions actions = new Actions(Driver.getDriver());
        WebElement firstImg = Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(firstImg).pause(1000).perform();

//3. Assert:
//    a. “name: user1” is displayed
        WebElement imgMsg = Driver.getDriver().findElement(By.xpath("//div[@class='figcaption']/h5[.='name: user1']"));
        Assert.assertTrue(imgMsg.isDisplayed());
//    b. “view profile” is displayed
        WebElement viewProf = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']/following-sibling::a"));
        Assert.assertTrue(viewProf.isDisplayed());
//4. Hover over to second image
        WebElement secondImg = Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
        actions.moveToElement(secondImg).pause(1000).perform();
//5. Assert:
//    a. “name: user2” is displayed
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//div[@class='figcaption']/h5[.='name: user2']"));
        Assert.assertTrue(user2.isDisplayed());
//    b. “view profile” is displayed
        WebElement viewProf2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']/following-sibling::a"));
        Assert.assertTrue(viewProf2.isDisplayed());
//6. Hover over to third image
        WebElement thirdImg = Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[3]"));
        actions.moveToElement(thirdImg).pause(1000).perform();
//7. Confirm:
//    a. “name: user3” is displayed
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//div[@class='figcaption']/h5[.='name: user3']"));
        Assert.assertTrue(user3.isDisplayed());
//    b. “view profile” is displayed
        WebElement viewProf3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']/following-sibling::a"));
        Assert.assertTrue(viewProf3.isDisplayed());

        Driver.closeDriver();
    }
}
