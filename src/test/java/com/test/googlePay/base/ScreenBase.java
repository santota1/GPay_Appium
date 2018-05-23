package com.test.googlePay.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenBase {

    public static AndroidDriver driver;

    public WebDriverWait wait;

    public ScreenBase(AndroidDriver driver){
        this.driver = driver;
        initializeElements();

        wait = new WebDriverWait(driver, 10);
    }

    public void initializeElements(){

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
