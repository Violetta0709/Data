package org.veta.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.veta.tests.TestData.*;

public class RegistrationFormWithDataTest {
   // String firstName = "Veta";
   // String lastName = "Iuzykhovich";
   // String email = "veta@veta.com";
   // String phone = "1234567891";
   // String day = "10";
   // String month = "January";
   // String year = "2000";

    //String firstName;
    //String lastName;
    //String email;
    //String phone;
    //String day;
    //String month;
    //String year;


    //@BeforeEach
    //void prepareTestData() {
    //    firstName = "Veta";
    //    lastName = "Iuzykhovich";
    //    email = "veta@veta.com";
    //    phone = "1234567891";
    //    day = "10";
    //    month = "January";
    //    year = "2000";
    //}

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        //String firstName = "Veta";

        open("/automation-practice-form");
        zoom(0.7);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
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
        $(".table-responsive table").shouldHave(text(firstName+" "+lastName),
                text(email),
                text("Male"),
                text(phone),
                text(day+" "+month+","+year),
                text("Arts"),
                text("Sports"),
                text("7.png"),
                text("some address"),
                text("NCR Delhi"));
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text(firstName+" "+lastName));
        $(".table-responsive table").$(byText(email))
                .parent().shouldHave(text(email));
        $(".table-responsive table").$(byText("Gender"))
                .parent().shouldHave(text("Male"));
        $(".table-responsive table").$(byText("Mobile"))
                .parent().shouldHave(text(phone));
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text(day+" "+month+","+year));
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

