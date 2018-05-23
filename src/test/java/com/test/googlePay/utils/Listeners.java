package com.test.googlePay.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test execution is started " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Case is passed " + result.getName());

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test Case is failed " + result.getName());

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Case is skipped " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
