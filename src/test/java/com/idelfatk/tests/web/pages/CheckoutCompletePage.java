package com.idelfatk.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.tests.web.WebTestBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    private final SelenideElement checkoutCompletePageTitleSelector = $(".title");

    private final String checkoutCompletePageTitleText = "CHECKOUT: COMPLETE!";

    @Step("Проверяем, что находимся на странице успешного формления товара")
    public CheckoutCompletePage checkoutCompletePageTitleVisible () {
        checkoutCompletePageTitleSelector.shouldHave(text(checkoutCompletePageTitleText));
        return this;
    }

}
