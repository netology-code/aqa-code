package ru.netology.web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldRegisterByAccountNumberDOMModification() {
        open("http://localhost:9999");
        $$(".tab-item").find(exactText("По номеру счёта")).click();
        $("[name='number']").setValue("4055 0100 0123 4613 8564");
        $("[name='phone']").setValue("+792000000000");
        $$("button").find(exactText("Продолжить")).click();
        $(withText("Успешная авторизация")).waitUntil(visible, 5000);
        $(byText("Личный кабинет")).waitUntil(visible, 5000);
    }

    @Test
    void shouldRegisterByAccountNumberVisibilityChange() {
        open("http://localhost:9999");
        $$(".tab-item").find(exactText("По номеру счёта")).click();
        $$("[name='number']").last().setValue("4055 0100 0123 4613 8564");
        $$("[name='phone']").last().setValue("+792000000000");
        $$("button").find(exactText("Продолжить")).click();
        $(withText("Успешная авторизация")).waitUntil(visible, 5000);
        $(byText("Личный кабинет")).waitUntil(visible, 5000);
    }
}

