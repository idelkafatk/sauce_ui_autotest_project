package com.idelfatk.tests.web;

import com.idelfatk.config.Project;
import com.idelfatk.tests.web.pages.LoginPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Тестирование страницы авторизации")
public class LoginTests extends WebTestBase {
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    @Step("Открываем страницу авторизации")
    public void beforeEach() {
        open(baseUrl);
        loginPage.checkLoginPageIsVisible();
    }

    @Test
    @DisplayName("Консоль не должна содержать ошибок")
    void consoleLogShouldNotHasErrorMessage() {
        checkingBrowserConsoleErrors();
    }

    @Test
    @DisplayName("Ошибка логина при клике LOGIN")
    void shouldAppearAnLoginErrorTest() {
        loginPage.clickLoginButton()
                 .checkEmailErrorMessage();
    }

    @Test
    @DisplayName("Ошибка пароля при клике LOGIN")
    void shouldAppearAnPasswordErrorTest() {
        loginPage.setUsername(Project.config.username())
                 .clickLoginButton()
                 .checkPasswordErrorMessage();
    }

    @Test
    @DisplayName("Ошибка входа при попытке залогиниться за заблокированного пользователя")
    void lockedUserErrorTest() {
        loginPage.setUsername(Project.config.lockedUsername())
                 .setPassword(Project.config.password())
                 .clickLoginButton()
                 .checkLockedUserErrorMessage();
    }

    @Test
    @DisplayName("Успешная авторизация на сайте")
    void userSuccessAuthTest() {
        loginPage.login()
                 .checkMainPageIsVisible();
    }

    @Test
    @DisplayName("Ошибка авторизации при неверном логине или пароле")
    void userFailAuthTest() {
        loginPage.setUsername(Project.config.wrongUsername())
                 .setPassword(Project.config.wrongPassword())
                 .clickLoginButton()
                 .checkWrongUsernameOrPasswordErrorMessage();
    }
}
