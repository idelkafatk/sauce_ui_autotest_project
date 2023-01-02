package com.idelfatk.tests.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.idelfatk.config.Project;
import com.idelfatk.tests.web.WebTestBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends WebTestBase {
    private final String username = Project.config.username(),
            password = Project.config.password();

    private final SelenideElement
            loginFieldSelector = $("#user-name"),
            passwordFieldSelector = $("#password"),
            loginButtonSelector = $("#login-button"),
            errorMessageSelector = $("h3[data-test='error']");

    private final String
            emailErrorMessage = "Epic sadface: Username is required",
            passwordErrorMessage = "Epic sadface: Password is required",
            lockedUserErrorMessage = "Epic sadface: Sorry, this user has been locked out.",
            wrongUsernameOrPasswordErrorMessage = "Epic sad_face: Username and password do not match any user in this service";

    @Step("Страница авторизации должна быть видна")
    public LoginPage checkLoginPageIsVisible() {
        loginFieldSelector.shouldBe(visible);
        return this;
    }

    @Step("Вводим логин пользователя")
    public LoginPage setUsername (String username) {
        loginFieldSelector.setValue(username);
        return this;
    }

    @Step("Вводим пароль пользователя")
    public LoginPage setPassword (String password) {
        passwordFieldSelector.setValue(password);
        return this;
    }

    @Step("Кликаем кнопку LOGIN")
    public LoginPage clickLoginButton () {
        loginButtonSelector.click();
        return this;
    }

    @Step("Авторизация на сайте")
    public  MainPage login () {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
        return new MainPage();
    }

    @Step("Получаем сообщение об ошибке логина")
    public LoginPage checkEmailErrorMessage () {
        errorMessageSelector.shouldHave(text(emailErrorMessage));
        return this;
    }

    @Step("Получаем сообщение об ошибке пароля")
    public LoginPage checkPasswordErrorMessage () {
        errorMessageSelector.shouldHave(text(passwordErrorMessage));
        return this;
    }

    @Step("Получаем сообщение о заблокированном пользователе")
    public LoginPage checkLockedUserErrorMessage () {
        errorMessageSelector.shouldHave(text(lockedUserErrorMessage));
        return this;
    }

    @Step("Получаем сообщение о неправильном логине или пароле")
    public LoginPage checkWrongUsernameOrPasswordErrorMessage () {
        errorMessageSelector.shouldHave(text(wrongUsernameOrPasswordErrorMessage));
        return this;
    }
}
