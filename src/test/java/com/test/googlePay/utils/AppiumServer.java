package com.test.googlePay.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.net.MalformedURLException;

public class AppiumServer {

    static AppiumDriverLocalService service;
    public static String service_url;

    public static void startServer() throws InterruptedException, MalformedURLException {

        service = AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder()

                        .usingDriverExecutable(new File("/usr/local/bin/node"))
                        .withArgument(GeneralServerFlag.LOG_LEVEL, "warn")
                        .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))
                        .usingAnyFreePort());

        service_url = service.getUrl().toString();

        service.start();
    }

    public static void stop() {
        service.stop();
    }
}
