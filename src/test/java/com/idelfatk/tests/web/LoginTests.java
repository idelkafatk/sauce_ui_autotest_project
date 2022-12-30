package com.idelfatk.tests.web;

import com.codeborne.selenide.Condition;
import com.idelfatk.tests.web.pages.LoginPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.idelfatk.helpers.Attachments.getConsoleLogs;
import static com.idelfatk.tests.web.pages.LoginPage.*;
import static com.idelfatk.tests.web.pages.MainPage.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Тестирование страницы авторизации")
public class LoginTests extends WebTestBase {
    private final LoginPage loginPage = new LoginPage();

    @BeforeEach
    @Step("Открываем страницу авторизации")
    public void beforeEach() {
        open(baseUrl);
        loginPage.checkLoginPageIsVisible();
    }

    @Test
    @DisplayName("Нет ошибок в консоле разработчика")
    void consoleShouldNotHaveErrorsTest() {
        step("Консоль не должна содержать текст 'SEVERE'", () -> {
            String consoleLogs = getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @DisplayName("Ошибка логина при клике LOGIN")
    void shouldAppearAnLoginErrorTest() {
        step("Кликаем на кнопку LOGIN", () -> loginButtonSelector.click());

        step(format("Появляется сообщение об ошибке: %s", emailErrorMessage), () -> {
            errorMessageSelector.shouldHave(Condition.text(emailErrorMessage));
        });
    }

    @Test
    @DisplayName("Ошибка пароля при клике LOGIN")
    void shouldAppearAnPasswordErrorTest() {
        step("Вводим логин юзера", () -> loginFieldSelector.setValue(username));
        step("Кликаем на кнопку LOGIN", () -> loginButtonSelector.click());

        step(format("Появляется сообщение об ошибке: %s", passwordErrorMessage), () -> {
            errorMessageSelector.shouldHave(Condition.text(passwordErrorMessage));
        });
    }

    @Test
    @DisplayName("Ошибка входа при попытке за залогиниться за заблокированного пользователя")
    void lockedUserErrorTest() {
        step("Вводим логин юзера", () -> loginFieldSelector.setValue(lockedUsername));
        step("Вводим пароль юзера", () -> passwordFieldSelector.setValue(password));
        step("Кликаем на кнопку LOGIN", () -> loginButtonSelector.click());

        step(format("Появляется сообщение об ошибке: %s", lockedUserErrorMessage), () -> {
            errorMessageSelector.shouldHave(Condition.text(lockedUserErrorMessage));
        });
    }

    @Test
    @DisplayName("Успешная авторизация на сайте")
    void userSuccessAuthTest() {
        loginPage.signInAsUser(username, password);
        step("Успешная авторизация", () -> mainPageTitleSelector.shouldHave(text(mainPageTitleText)));
    }

    @Test
    @DisplayName("Ошибка авторизации при неверном пароле или логине")
    void userFailAuthTest() {
        loginPage.signInAsUser(wrongUsername, wrongPassword);
        step("Сообщение об ошибке авторизации", () -> {
            errorMessageSelector.shouldHave(text(wrongPasswordOrUsernameErrorMessage));
        });
    }
}
