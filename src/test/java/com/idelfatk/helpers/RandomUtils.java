package com.idelfatk.helpers;

import com.github.javafaker.Faker;

public class RandomUtils {
    private static final Faker faker = new Faker();

    public static String getRandomFirstname() {
        return faker.name().firstName();
    }

    public static String getRandomLastname() {
        return faker.name().lastName();
    }

    public static String getRandomPostCode() {
        return faker.address().zipCode();
    }
}