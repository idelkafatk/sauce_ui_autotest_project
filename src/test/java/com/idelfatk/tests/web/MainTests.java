package com.idelfatk.tests.web;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.tests.web.pages.LoginPage;
import com.idelfatk.tests.web.pages.MainPage;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.idelfatk.tests.web.pages.LoginPage.password;
import static com.idelfatk.tests.web.pages.LoginPage.username;
import static com.idelfatk.tests.web.pages.MainPage.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тестирование главной страницы")
public class MainTests extends WebTestBase {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @BeforeEach
    @DisplayName("Открываем главную страницу")
    public void beforeEach() {
        open(baseUrl);
        loginPage.signInAsUser(username, password);
        mainPage.checkMainPageIsVisible();
    }

    @Test
    @DisplayName("Товары добавляются в корзину")
    void successAddItemToBasketTest() {
        SelenideElement[] items= {
                backpackAddToBasketSelector,
                tShirtAddToBasketSelector
        };
        String basketSize = Integer.toString(items.length);
        mainPage.addItemsToBasket(items)
                .checkBasketSize(basketSize);
    }

    @Test
    @DisplayName("Упавший тест")
    void failTest() {
        assertTrue(false);
    }

    @Test
    @Disabled
    @DisplayName("Пропушенный тест")
    void skippedTest() {
        assertTrue(false);
    }
}
