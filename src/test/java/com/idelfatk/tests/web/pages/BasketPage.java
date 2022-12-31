package com.idelfatk.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.tests.web.WebTestBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    private final SelenideElement checkoutSelector =$("#checkout"),
                                  basketPageTitleSelector = $(".title");

    private final String basketPageTitleText = "Your cart";

    @Step("Кликаем кнопку 'Checkout'")
    public CheckoutUserInformationPage clickCheckoutButton () {
        checkoutSelector.click();
        return new CheckoutUserInformationPage();
    }

    @Step("Проверяем, что находимся на странице корзины")
    public BasketPage checkBasketPageVisible () {
        basketPageTitleSelector.shouldHave(text(basketPageTitleText));
        return this;
    }
}
