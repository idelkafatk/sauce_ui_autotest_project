package com.idelfatk.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.tests.web.WebTestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends WebTestBase {
    public static final SelenideElement mainPageTitleSelector = $(".title"),
                                        basketPageSelector = $(".shopping_cart_link"),
                                        backpackAddToBasketSelector = $("#add-to-cart-sauce-labs-backpack"),
                                        tShirtAddToBasketSelector = $("#add-to-cart-sauce-labs-bolt-t-shirt");

    public static final String mainPageTitleText = "Products";

    public MainPage openBasketPage() {
        basketPageSelector.click();
        return this;
    }

    public MainPage checkBasketSize(String basketSize) {
        basketPageSelector.shouldHave(text(basketSize));
        return this;
    }

    public MainPage checkMainPageIsVisible () {
        mainPageTitleSelector.shouldHave(text(mainPageTitleText));
        return this;
    }

    public MainPage addItemsToBasket (SelenideElement[] items) {
        for (SelenideElement item : items) {
            item.click();
        }
        return this;
    }
}
