package com.test.googlePay.testcases;

import com.test.googlePay.base.TestBase;
import com.test.googlePay.screens.CardsScreen;
import com.test.googlePay.screens.homeScreen.GooglePayHomeScreen;
import com.test.googlePay.screens.setupScreen.GooglePaySetItUpScreen;
import com.test.googlePay.utils.CommonUtils;
import com.test.googlePay.utils.ReUsableMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GooglePayHomeScreenTest extends TestBase{

    @Test (priority = 1)
    public void verifyOpeningSetItUpScreen() throws InterruptedException {
        googlePayHomeScreen = new GooglePayHomeScreen(driver);
        //cardsScreen = new CardsScreen(driver);
        googlePaySetItUpScreen = new GooglePaySetItUpScreen(driver);

        Thread.sleep(5000);


        /*googlePayHomeScreen.tapSetItUpButton();
        log.debug("Tapping on Set it up button");

        googlePaySetItUpScreen.tapBackButton();
        log.debug("Tapping on Back button to close Choose card screen");*/
    }

    /*@Test (priority = 2)
    public void openMenuDrawer(){

        ReUsableMethods.swipeRight();
        log.debug("Opening menu drawer from home screen");
    }*/

    @Test (priority = 3)
    public void tapInviteFriends() throws Exception {
        googlePayHomeScreen.tapInviteFriendsButton();
    }

    /*@Test (priority = 4)
    public void openAddCardScreen() throws InterruptedException {

        System.out.println(driver.currentActivity() + "****************************************1");
        googlePayHomeScreen.openCardsSection();
        System.out.println(driver.currentActivity() + "****************************************2");
        cardsScreen.tapAddCardButton();
        System.out.println(driver.currentActivity() + "****************************************3");

        Thread.sleep(5000);

        driver.pressKeyCode(4);

        Thread.sleep(5000);

        System.out.println(driver.currentActivity() + "****************************************4");

        //driver.findElementById("ocrSkipScanButton").click();
        Thread.sleep(5000);


    }*/
}
