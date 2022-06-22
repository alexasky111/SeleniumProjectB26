package com.cydeo.test.day13_configuration_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {
        //These 3 lines of code reaching for configuration properties file

        //Create properties class' object
        //We need properties class to use getProperty("key") method
        Properties properties = new Properties();

        //Create FileInputStream object to open file as a stream in Java memory
        //to decide which file I am going to use and upload
        FileInputStream file = new FileInputStream("configuration.properties");

        //Load "properties" obj w/ the "file" we opened using FileInputStream

        //We can use properties.getProperty method to read the file we loaded. (configuration.properties)
        properties.load(file);

        //We can use properties.getProperty method to read from the file we loaded. (configuration.properties)
        //bf you want to get the value from this property file, you have to write the ABOVE 3 lines of code
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"key\") = " + properties.getProperty("key"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

        //we use property object to use getProperty method and input the value from configuration class
    }
}
