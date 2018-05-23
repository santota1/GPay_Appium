package com.test.googlePay.base;

import com.test.googlePay.screens.CardsScreen;
import com.test.googlePay.screens.homeScreen.GooglePayHomeScreen;
import com.test.googlePay.screens.setupScreen.GooglePaySetItUpScreen;
import com.test.googlePay.utils.AppiumServer;
import com.test.googlePay.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

    public static AndroidDriver driver;
    public GooglePayHomeScreen googlePayHomeScreen;
    public GooglePaySetItUpScreen googlePaySetItUpScreen;
    public CardsScreen cardsScreen;

    public static String loadPropertyFile = "googlePayAppConfig.properties";

    public Logger log = Logger.getLogger("devpinoyLogger");

    //public WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeSuite
    public void setUp() throws IOException, InterruptedException {

        if(driver == null){
            AppiumServer.startServer();
            log.debug("Starting Appium Server");

            CommonUtils.loadConfigProperties(loadPropertyFile);
            CommonUtils.setCapabilities();

            driver = CommonUtils.getDriver();
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
        log.debug("Stopping Appium Server");
    }
}
