package org.veta.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTestsSample {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        zoom(0.7);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Veta");
        $("#lastName").setValue("Iuzykhovich");
        $("#userEmail").setValue("veta@veta.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567891");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--010:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Art").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/7.png");
        $("#currentAddress").setValue("some address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").shouldHave(text("Veta Iuzykhovich"),
                text("veta@veta.com"),
                text("Male"),
                text("1234567891"),
                text("10 January,2000"),
                text("Arts"),
                text("Sports"),
                text("7.png"),
                text("some address"),
                text("NCR Delhi"));
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text("Veta Iuzykhovich"));
        $(".table-responsive table").$(byText("Student Email"))
                .parent().shouldHave(text("veta@veta.com"));
        $(".table-responsive table").$(byText("Gender"))
                .parent().shouldHave(text("Male"));
        $(".table-responsive table").$(byText("Mobile"))
                .parent().shouldHave(text("1234567891"));
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text("10 January,2000"));
        $(".table-responsive table").$(byText("Subjects"))
                .parent().shouldHave(text("Arts"));
        $(".table-responsive table").$(byText("Hobbies"))
                .parent().shouldHave(text("Sports"));
        $(".table-responsive table").$(byText("Picture"))
                .parent().shouldHave(text("7.png"));
        $(".table-responsive table").$(byText("Address"))
                .parent().shouldHave(text("some address"));
        $(".table-responsive table").$(byText("State and City"))
                .parent().shouldHave(text("NCR Delhi"));
    }
}

