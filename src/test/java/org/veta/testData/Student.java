package org.veta.testData;

import com.github.javafaker.Faker;
import org.veta.utils.Month;

import java.util.Locale;

public class Student {
    private static final Faker faker = new Faker(new Locale("en-US"));
    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phone = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(10, 28)),
            month = String.valueOf(Month.getRandomMonth()),
            year = String.valueOf(faker.number().numberBetween(1901, 2021)),
            subject = "Maths",
            hobby = "Reading",
            picture = "7.png",
            picturePath = "img/7.png",
            address = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi",
            birthDay = day + " " + month + "," + year;
}
