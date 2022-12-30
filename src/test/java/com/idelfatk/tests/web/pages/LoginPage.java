package com.idelfatk.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.config.Project;
import com.idelfatk.tests.web.WebTestBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LoginPage extends WebTestBase {
    public static String username = Project.config.username(),
            lockedUsername = Project.config.lockedUsername(),
            password = Project.config.password(),
            wrongUsername = username + "1",
            wrongPassword = password + "1";

    public static SelenideElement
            loginFieldSelector = $("#user-name"),
            passwordFieldSelector = $("#password"),
            loginButtonSelector = $("#login-button"),
            errorMessageSelector = $("h3[data-test='error']");

    public static String
            emailErrorMessage = "Epic sadface: Username is required",
            passwordErrorMessage = "Epic sadface: Password is required",
            lockedUserErrorMessage = "Epic sadface: Sorry, this user has been locked out.",
            wrongPasswordOrUsernameErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    @Step("Авторизация на сайте")
    public LoginPage signInAsUser (String username, String password) {
        step("Вводим логин юзера", () -> loginFieldSelector.shouldBe(visible).setValue(username));
        step("Вводим пароль юзера", () -> passwordFieldSelector.shouldBe(visible).setValue(password));
        step("Кликаем на кнопку LOGIN", () -> loginButtonSelector.shouldNotBe(disabled).click());
        return this;
    }

    @Step("Страница авторизации должна быть видна")
    public LoginPage checkLoginPageIsVisible() {
        loginFieldSelector.shouldBe(visible);
        return this;
    }
}
