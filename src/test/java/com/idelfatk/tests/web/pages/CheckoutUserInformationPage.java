package com.idelfatk.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.helpers.RandomUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutUserInformationPage {

    private final SelenideElement firstnameSelector = $("#first-name"),
                                  lastnameSelector = $("#last-name"),
                                  postalCodeSelector = $("#postal-code"),
                                  continueButtonSelector = $("#continue"),
                                  checkoutFirstPageTitleSelector = $(".title");

    private final String checkoutFirstPageTitleText = "Checkout: Your Information";

    @Step("Вводим имя")
    public CheckoutUserInformationPage setFirstname (String firstname) {
        firstnameSelector.setValue(firstname);
        return this;
    }

    @Step("Вводим фамилию")
    public CheckoutUserInformationPage setLastname (String lastname) {
        lastnameSelector.setValue(lastname);
        return this;
    }

    @Step("Вводим почтовый индекс")
    public CheckoutUserInformationPage setPostalCode (String postalCode) {
        postalCodeSelector.setValue(postalCode);
        return this;
    }

    @Step("Кликаем кнопку 'Continue'")
    public CheckoutOverviewPage clickOnContinueButton() {
        continueButtonSelector.click();
        return new CheckoutOverviewPage();
    }

    @Step("Заполняем данные пользователя для покупки")
    public CheckoutUserInformationPage setUserInformation () {
        setFirstname(RandomUtils.getRandomFirstname());
        setLastname(RandomUtils.getRandomLastname());
        setPostalCode(RandomUtils.getRandomPostCode());
        return this;
    }

    @Step("Проверяем, что находимся на первом шаге страницы покупки")
    public CheckoutUserInformationPage checkoutFirstPageVisible() {
        checkoutFirstPageTitleSelector.shouldHave(text(checkoutFirstPageTitleText));
        return this;
    }
}
