package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return date;
    }

    private static String generateCity(Faker faker) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью faker, либо используя массив валидных городов и класс Random
        return city;
    }

    private static String generateName(Faker faker) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать faker
        return name;
    }

    private static String generatePhone(Faker faker) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать faker
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            val faker = new Faker(new Locale(locale));
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(faker),
            // generateName(faker), generatePhone(faker)
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
