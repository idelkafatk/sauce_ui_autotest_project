package com.idelfatk.tests.web;

import com.idelfatk.tests.web.pages.LoginPage;
import com.idelfatk.tests.web.pages.MainPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тестирование главной страницы")
public class MainTests extends WebTestBase {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @BeforeEach
    @Step("Открываем главную страницу")
    public void beforeEach() {
        open(baseUrl);
        loginPage.login()
                 .checkMainPageIsVisible();
    }

    @Test
    @DisplayName("Консоль не должна содержать ошибок")
    void consoleLogShouldNotHasErrorMessage() {
        checkingBrowserConsoleErrors();
    }

    @Test
    @DisplayName("Товары добавляются в корзину")
    void successAddItemToBasketTest() {
        mainPage.addItemsToBasket()
                .checkBasketSize(mainPage.getItemsCounty());
    }
}
