package com.test.googlePay.utils;

import org.testng.annotations.DataProvider;

public class TestData {


    @DataProvider(name = "CreditCards")
    public Object[][] creditCards(){
        Object[][] creditCards = new Object[2][1];

        creditCards[0][0] = "4111 1111 1111 1111";
        creditCards[1][0] = "51010 1010 1010 1010";

        return creditCards;

    }

    @DataProvider(name = "InvalidEmailPassword")
    public Object[][] invalidEmailPassword() {

        Object[][] invalidEmailPassword = new Object[2][2];

        invalidEmailPassword[0][0] = "notavailable1@mcclatchy.com";
        invalidEmailPassword[0][1] = "password1";

        invalidEmailPassword[1][0] = "notavailable2@mcclatchy.com";
        invalidEmailPassword[1][1] = "password2";

        return invalidEmailPassword;

    }

}

