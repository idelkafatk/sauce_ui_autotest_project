package com.idelfatk.tests.web;

import com.idelfatk.tests.web.pages.CheckoutUserInformationPage;
import com.idelfatk.tests.web.pages.LoginPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тестирование оформления товаров")
public class CheckoutTests extends WebTestBase {
    LoginPage loginPage = new LoginPage();
    CheckoutUserInformationPage checkoutPage = new CheckoutUserInformationPage();

    @BeforeEach
    @Step("Открываем страницу оформления заказа")
    public void beforeEach() {
        open(baseUrl);
        loginPage.login()
                 .addItemsToBasket()
                 .openBasketPage()
                 .clickCheckoutButton()
                 .checkoutFirstPageVisible();
    }

    @Disabled
    @Test
    @DisplayName("Консоль не должна содержать ошибок")
    void consoleLogShouldNotHasErrorMessage() {
        checkingBrowserConsoleErrors();
    }

    @Test
    @DisplayName("Возможно завершить этапы оформления товара")
    void possibleFinishCheckoutStepsTest() {
        checkoutPage.setUserInformation()
                .clickOnContinueButton()
                .checkoutOverviewPageVisible()
                .clickOnFinishButton()
                .checkoutCompletePageTitleVisible();
    }
}
