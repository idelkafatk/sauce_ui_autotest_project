package com.idelfatk.tests;

import com.idelfatk.drivers.LocalAndRemoteWebDriver;
import com.idelfatk.helpers.Attachments;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.idelfatk.config.Project.isRemoteDriver;
import static com.idelfatk.helpers.Attachments.*;

public class TestBase {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        LocalAndRemoteWebDriver.configure();

        Attachments.attachAsText("Browser: ", browser);
        Attachments.attachAsText("Version: ", browserVersion);
        Attachments.attachAsText("Remote Url: ", remote);
    }

    @AfterEach
    @Step("Сохраняем артефакты и закрываем WebDriver")
    public void tearDown() {
        screenshotAs("Last screenshot");
        pageSource();
        if (isRemoteDriver()) {
            addVideo();
        }
        getConsoleLogs();
        closeWebDriver();
    }
    }
