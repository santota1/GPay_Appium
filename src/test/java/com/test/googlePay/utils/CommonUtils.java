package com.test.googlePay.utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonUtils {

    private static Properties prop = new Properties();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static AndroidDriver driver;
    private static String serverUrl;
    private static AppiumDriverLocalService service;
    private static int EXPLICIT_WAIT_TIME;
    private static String DEVICE_NAME;
    private static String PLATFORM_NAME;
    private static String PLATFORM_VERSION;
    private static String APPLICATION_PACKAGE;
    private static String APPLICATION_ACTIVITY;

    private static String BROWSER_NAME;


    public static void loadConfigProperties(String propertiesFileName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/" + propertiesFileName);
        prop.load(fis);

        EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));

        DEVICE_NAME = prop.getProperty("device.name");
        PLATFORM_NAME = prop.getProperty("platform.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");

        APPLICATION_PACKAGE = prop.getProperty("application.pkg");
        APPLICATION_ACTIVITY = prop.getProperty("application.activity");

        BROWSER_NAME = prop.getProperty("browser.name");
    }

    public static void setCapabilities(){
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CommonUtils.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CommonUtils.PLATFORM_NAME);
        //capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, CommonUtils.PLATFORM_VERSION);

        capabilities.setCapability("automationName", "appium");
        capabilities.setCapability("appPackage", CommonUtils.APPLICATION_PACKAGE);
        capabilities.setCapability("appActivity", CommonUtils.APPLICATION_ACTIVITY);

        capabilities.setCapability(MobileCapabilityType.UDID, "54da1e0c");

        //capabilities.setCapability("sensorInstrument", true);
        //capabilities.setCapability("cameraInstrument", true);

        //capabilities.setCapability(M, ".wallet.im.ImRootActivity");
        //capabilities.setCapability("appWaitPackage", "com.google.android.gms");

        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, CommonUtils.BROWSER_NAME);
    }

    public static AndroidDriver getDriver() throws MalformedURLException {

        serverUrl = AppiumServer.service_url;

        // driver = new AndroidDriver<MobileElement>(new URL(serverUrl), capabilities);

        driver = new AndroidDriver(new URL("https://us-mv.headspin.io:3007/v0/aec0252d8e44456098f8574e265aeb33/wd/hub"), capabilities);


        return driver;

    }





}
