package org.veta.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.veta.pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class withPageObjects {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Veta")
                .setLastName("Iuzykhovich")
                .setEmail("veta@veta.com")
                .setGender("Male")
                .setNumber("1234567891")
                .setBirthDate("10", "January", "2000")
                .setSubject("Art")
                .setHobbies("Sports")
                .uploadPic("img/7.png")
                .setAddress("some address", "NCR", "Delhi")
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Veta Iuzykhovich")
                .checkResult("Student Email", "veta@veta.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567891")
                .checkResult("Date of Birth", "10 January,2000")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "7.png")
                .checkResult("Address", "some address")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName("Veta")
                .setLastName("Iuzykhovich")
                .setGender("Male")
                .setNumber("1234567891");
    }
}


