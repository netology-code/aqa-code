package ru.netology.delivery.test;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        val validUser = DataGenerator.Registration.generateUser("ru");
        val firstMeetingDate = DataGenerator.generateDate(4);
        val secondMeetingDate = DataGenerator.generateDate(7);
        // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи,
        //  для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
        //  firstMeetingDate и secondMeetingDate
    }
}
