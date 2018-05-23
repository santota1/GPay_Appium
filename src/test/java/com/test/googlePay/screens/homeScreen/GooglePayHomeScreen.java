package com.test.googlePay.screens.homeScreen;

import com.test.googlePay.base.ScreenBase;
import com.test.googlePay.screens.CampaigningScreen.InviteFriendsScreen;
import com.test.googlePay.screens.cardsScreen.CardsScreen;
import com.test.googlePay.screens.setupScreen.GooglePaySetItUpScreen;
import com.test.googlePay.utils.ReUsableMethods;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class GooglePayHomeScreen extends ScreenBase{

    @AndroidFindBy(id = "RaisedButton")
    public MobileElement setItUpButton;

    @AndroidFindBy(id = "ReferrerMainButton")
    public MobileElement inviteFriendsButton;

    @AndroidFindBy(id = "WalletItem")
    public MobileElement cardsSection;

    @AndroidFindBy(id = "referral_code")
    public MobileElement referralCode;

    @AndroidFindBy(id = "close_button")
    public MobileElement closeButton;

    @AndroidFindBy(xpath = "//*[@text='Enter promo code']")
    public MobileElement enterPromoCodeMenuOption;

    @AndroidFindBy(id = "Show Drawer")
    public MobileElement showDrawer;

    @AndroidFindBy(id = "EnterCodeEditText")
    public MobileElement enterCodeTextField;

    @AndroidFindBy(id = "ApplyButton")
    public MobileElement applyButtonOnEnterCodeScreen;

    @AndroidFindBy(id = "ErrorText")
    public MobileElement sameInviteCodeError;

    public String selfReferralCode;

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

    public void getReferralCode(){

        selfReferralCode = referralCode.getText();
        closeButton.click();
    }

    public void openAccessibilityMenu() throws InterruptedException {
        showDrawer.click();
        wait.until(ExpectedConditions.visibilityOf(enterPromoCodeMenuOption));
    }

    public void openEnterPromoCodeScreen() throws InterruptedException {

        enterPromoCodeMenuOption.click();
        wait.until(ExpectedConditions.visibilityOf(enterCodeTextField));
    }

    public CardsScreen openCardsSection(){
        cardsSection.click();
        return new CardsScreen(driver);
    }

    public void enterPromoCode() throws InterruptedException {
        enterCodeTextField.sendKeys(selfReferralCode);
        applyButtonOnEnterCodeScreen.click();
        wait.until(ExpectedConditions.visibilityOf(sameInviteCodeError));

        try{
            Assert.assertEquals("You can't apply your own invite code", sameInviteCodeError.getText());
        }catch (Exception e){
            Assert.fail("Incorrect error message when entering self promo code");
        }

    }

}
