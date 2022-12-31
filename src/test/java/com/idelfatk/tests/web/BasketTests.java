package com.idelfatk.tests.web;

import com.idelfatk.tests.web.pages.LoginPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тестирования корзины")
public class BasketTests extends WebTestBase {
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    @Step("Открываем корзину")
    public void beforeEach() {
        open(baseUrl);
        loginPage.login()
                 .openBasketPage()
                 .checkBasketPageVisible();
    }

    @Test
    @DisplayName("Консоль не должна содержать ошибок")
    void consoleLogShouldNotHasErrorMessage() {
        checkingBrowserConsoleErrors();
    }
}
