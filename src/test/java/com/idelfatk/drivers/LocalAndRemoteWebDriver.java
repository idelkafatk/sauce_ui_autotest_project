package com.idelfatk.drivers;

import com.codeborne.selenide.Configuration;
import com.idelfatk.config.Project;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.idelfatk.config.Project.isRemoteDriver;

public class LocalAndRemoteWebDriver {
    public static void configure() {

        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = Project.config.baseUrl();
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();

        MutableCapabilities capabilities = new DesiredCapabilities();

        if (isRemoteDriver()) {
            Configuration.remote = Project.config.remoteDriver();
            setChromeOptions(capabilities);
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }

    public static void setChromeOptions(MutableCapabilities capabilities) {
        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--no-sandbox")
                .addArguments("--disable-infobars")
                .addArguments("--disable-popup-blocking")
                .addArguments("--disable-notifications")
                .addArguments("--lang=en-US")
                .setExperimentalOption("excludeSwitches", new String[]{"enable-automation"})
                .merge(capabilities);
    }
}