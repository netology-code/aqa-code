package ru.netology.data;

import com.github.javafaker.Faker;

public class DataHelper {
    private static final Faker FAKER = new Faker();

    private DataHelper() {
    }

    public static String generateRandomLogin() {
        return FAKER.name().username();
    }

    public static String generateRandomPassword() {
        return FAKER.internet().password();
    }
}
