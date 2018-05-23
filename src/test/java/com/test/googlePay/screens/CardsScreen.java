package com.test.googlePay.screens;

import com.test.googlePay.base.ScreenBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CardsScreen extends ScreenBase {

    public CardsScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add a card']")
    public MobileElement add_A_Card_Button;

    public void tapAddCardButton() throws InterruptedException {
        add_A_Card_Button.click();
        Thread.sleep(5000);
    }

}
