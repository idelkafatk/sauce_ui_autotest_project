package com.idelfatk.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.tests.web.WebTestBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {
    private final SelenideElement checkoutOverviewTitleSelector = $(".title"),
                                  finishButtonSelector = $("#finish");

    private final String checkoutOverviewTitleText = "Checkout: Overview";

    @Step("Проверяем, что находимся на странице проверки данных оформляемых товаров")
    public CheckoutOverviewPage checkoutOverviewPageVisible() {
        checkoutOverviewTitleSelector.shouldHave(text(checkoutOverviewTitleText));
        return this;
    }

    @Step("Кликаем кнопку 'Finish'")
    public CheckoutCompletePage clickOnFinishButton () {
        finishButtonSelector.click();
        return new CheckoutCompletePage();
    }
}
