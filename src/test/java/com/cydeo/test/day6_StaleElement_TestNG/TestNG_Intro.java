package com.cydeo.test.day6_StaleElement_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {
    //BeforeClass will be running bf all tests
    @BeforeClass
    public void setUP() {
        System.out.println("Before class is running");
    }

    //AfterClass will be running bf all tests
    @AfterClass
    public void tearDown() {
        System.out.println("After class is running");
    }

    //BeforeMethod will be running bf each test method
    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Before m-thod is running");
    }

    //AfterMethod will be running bf each test method
    @AfterMethod
    public void tearDoneMethod() {
        System.out.println("After m-thod is running");
    }


    @Test
    public void test1() {
        System.out.println("Test1 is running...");
        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual, expected, "Test did not passed");
    }

    //@Test (priority = 1 dependsOnMethods = "test1") - if test1 fails -> test2 never runs
    @Test
    public void test2() {
        System.out.println("Test2 is running");
        Assert.assertEquals("orange", "orange", "it did not pass");
    }
}
