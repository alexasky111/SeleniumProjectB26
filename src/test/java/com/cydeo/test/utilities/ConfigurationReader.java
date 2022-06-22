package com.cydeo.test.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1- Create properties obj
    //2- we make this private to be inaccessible from outside
    //3- make it static bc static runs 1st and
    //4- we will use this object under static method

    /*
    How do we read from configuration.properties?
#1- Create Properties class object
Properties properties = new Properties();
#2- We need to open the file in the Java memory
FileInputStream fileStream = new FileInputStream("pathOfTheFile");
#3- We need to load the "properties" object with the fileStream
properties.load(fileStream);
#4- Use properties object and getProperty method to pass "key" and read
"value"
properties.getProperty("key") --> value
browser -> chrome
username -> helpdesk1@cydeo.com
     */

    //don't want any other class to reach this properties object from outside class, because we are storing important data
    private static Properties properties = new Properties(); //comes from java Util

    // Create FileInputStream obj to open file as a stream in Java memory
    // static block bc we want to run 1st and one time only after we open the file
    static {
        //Create FileInputStream obj to open file as a stream in Java memory
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            //Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);
        } catch (IOException e) {
            System.out.println("file not found in ConfigurationReader class");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }

}
