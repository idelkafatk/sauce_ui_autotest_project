package com.idelfatk.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.tests.web.WebTestBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement mainPageTitleSelector = $(".title"),
                                  basketPageSelector = $(".shopping_cart_link"),
                                  backpackAddToBasketSelector = $("#add-to-cart-sauce-labs-backpack"),
                                  tShirtAddToBasketSelector = $("#add-to-cart-sauce-labs-bolt-t-shirt");

    private final String mainPageTitleText = "Products";

    private final SelenideElement[] items= {
            backpackAddToBasketSelector,
            tShirtAddToBasketSelector
    };

    @Step("Открываем корзину")
    public BasketPage openBasketPage() {
        basketPageSelector.click();
        return new BasketPage();
    }

    @Step("Проверяем количество товаров в корзине")
    public MainPage checkBasketSize(String itemsCounty) {
        basketPageSelector.shouldHave(text(itemsCounty));
        return this;
    }

    @Step("Проверяем, что находимся на главной странице")
    public MainPage checkMainPageIsVisible () {
        mainPageTitleSelector.shouldHave(text(mainPageTitleText));
        return this;
    }

    @Step("Получаем количество добавленных товаров")
    public String getItemsCounty () {
        return Integer.toString(items.length);
    }

    @Step("Добавляем товары в корзину")
    public MainPage addItemsToBasket () {
        for (SelenideElement item : items) {
            item.click();
        }
        return this;
    }
}
