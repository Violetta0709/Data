package org.veta.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.veta.pages.components.AddressComponent;
import org.veta.pages.components.CalendarComponent;
import org.veta.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();
    private AddressComponent addressComponent = new AddressComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            picInput = $("#uploadPicture"),
            submit = $("#submit");
    private final static String TITLE_TEXT = "Student Registration Form";

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        zoom(0.7);
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage uploadPic(String value) {
        picInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setAddress(String address, String state, String city) {
        addressComponent.setAddress(address, state, city);
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        submit.click();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultTableComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);
        return this;
    }
}
