package com.test.googlePay.utils;

import com.test.googlePay.base.TestBase;
import org.openqa.selenium.Dimension;

public class ReUsableMethods extends TestBase{

    public static void swipeRight(){

        Dimension screenSize = driver.manage().window().getSize();

        int startX = (int) (screenSize.getWidth() * 0.01);
        int startY = screenSize.getHeight() / 2;
        int endX = (int) (screenSize.getWidth() * 0.5);;
        int endY = startY;

        driver.swipe(startX, startY, endX, endY, 2000);
    }


    public static void swipeDown(){

        Dimension screenSize = driver.manage().window().getSize();

        int startX = (int) (screenSize.width * 0.5);
        int startY = (int) (screenSize.height * 0.7);
        int endX = (int) (screenSize.width * 0.5);
        int endY = (int) (screenSize.height * 0.3);

        driver.swipe(startX, startY, endX, endY, 2000);
    }
}
