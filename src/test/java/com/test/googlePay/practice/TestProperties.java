package com.test.googlePay.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    public static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/googlePayAppConfig.properties");
        prop.load(fis);

        System.out.println(prop.getProperty("device.name"));
    }

}
