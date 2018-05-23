package com.test.googlePay.screens.homeScreen;

import com.gargoylesoftware.htmlunit.javascript.host.Touch;
import com.test.googlePay.base.ScreenBase;
import com.test.googlePay.screens.CampaigningScreen.InviteFriendsScreen;
import com.test.googlePay.screens.CardsScreen;
import com.test.googlePay.screens.setupScreen.GooglePaySetItUpScreen;
import com.test.googlePay.utils.CommonUtils;
import com.test.googlePay.utils.ReUsableMethods;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class GooglePayHomeScreen extends ScreenBase{

    @AndroidFindBy(id = "RaisedButton")
    public MobileElement setItUpButton;

    @AndroidFindBy(id = "ReferrerMainButton")
    public MobileElement inviteFriendsButton;

    @AndroidFindBy(id = "WalletItem")
    public MobileElement cardsSection;

    public GooglePayHomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public GooglePaySetItUpScreen tapSetItUpButton(){
        setItUpButton.click();
        return new GooglePaySetItUpScreen(driver);
    }

    public GooglePayHomeScreen openMenuDrawer(){
        ReUsableMethods.swipeRight();
        return this;

    }


    public InviteFriendsScreen tapInviteFriendsButton() throws Exception {


        Boolean isFoundElement;
        By myElement = By.id("ReferrerMainButton");

        isFoundElement = driver.findElements(myElement).size() > 0;
        while (isFoundElement == false){
            ReUsableMethods.swipeDown();
            isFoundElement = driver.findElements(myElement).size() > 0;
        }
        driver.findElement(myElement).click();

        return new InviteFriendsScreen(driver);
    }

    public CardsScreen openCardsSection(){
        cardsSection.click();
        return new CardsScreen(driver);
    }

}
