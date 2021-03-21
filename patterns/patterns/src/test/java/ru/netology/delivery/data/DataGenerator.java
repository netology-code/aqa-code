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
        // Вы можете использовать класс LocalDate
        return date;
    }

    public static String generateCity(String locale) {
        val faker = new Faker(new Locale(locale));
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        //  с помощью faker, либо используя массив валидных городов
        return city;
    }

    public static String generateName(String locale) {
        val faker = new Faker(new Locale(locale));
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать faker
        return name;
    }

    public static String generatePhone(String locale) {
        val faker = new Faker(new Locale(locale));
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать faker
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
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
