package com.cydeo.test.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage_POMPractice {

  //1- Create a Constructor to initialize elements with using page factory

    public LibraryLoginPage_POMPractice(){

        PageFactory.initElements(Driver.getDriver(),this); //to point to this elements
    }
  //2- Now we have to store elements w/ using FindBy annotation
  @FindBy(id="inputEmail")//the locator of the elements
    public WebElement email;

  @FindBy(id="inputPassword")
    public WebElement password;

  @FindBy(xpath="//button[.='Sign in']")
    public WebElement signInBtn;

  //3- if invalid data what will happen
    @FindBy(xpath="//div[.='Sorry, Wrong Email or Password']")
    public WebElement errorMsg;

    public void login(String userName, String password1){
        email.sendKeys(userName);
        password.sendKeys(password1);
        signInBtn.click();
    }
}
