package com.test.googlePay.screens.setupScreen;

import com.test.googlePay.base.ScreenBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GooglePaySetItUpScreen extends ScreenBase{

    public GooglePaySetItUpScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add a new card']")
    public MobileElement addNewCardButton;

    @AndroidFindBy(id = "Navigate up")
    public MobileElement backButton;

    public void tapBackButton(){
        backButton.click();
    }
}
