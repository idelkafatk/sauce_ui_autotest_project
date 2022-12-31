package com.idelfatk.drivers;

import com.codeborne.selenide.Configuration;
import com.idelfatk.config.Project;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.idelfatk.config.Project.isRemoteDriver;

public class LocalAndRemoteWebDriver {
    public static void configure() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (isRemoteDriver()) {
            Configuration.remote = Project.config.remoteDriver();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }

        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = Project.config.baseUrl();
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
    }
}