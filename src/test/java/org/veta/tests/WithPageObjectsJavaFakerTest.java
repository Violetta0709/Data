package org.veta.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.veta.pages.RegistrationFormPage;
import org.veta.testData.Student;

public class WithPageObjectsJavaFakerTest extends TestBase{
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @DisplayName("Test of registration form")
    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(Student.firstName)
                .setLastName(Student.lastName)
                .setEmail(Student.email)
                .setGender(Student.gender)
                .setNumber(Student.phone)
                .setBirthDate(Student.day,Student.month,Student.year)
                .setSubject(Student.subject)
                .setHobbies(Student.hobby)
                .uploadPic(Student.picturePath)
                .setAddress(Student.address,Student.state, Student.city)
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", Student.firstName+" "+Student.lastName)
                .checkResult("Student Email", Student.email)
                .checkResult("Gender", Student.gender)
                .checkResult("Mobile", Student.phone)
                .checkResult("Date of Birth", Student.birthDay)
                .checkResult("Subjects", Student.subject)
                .checkResult("Hobbies", Student.hobby)
                .checkResult("Picture", Student.picture)
                .checkResult("Address", Student.address)
                .checkResult("State and City", Student.state+" "+Student.city);
    }

    @DisplayName("Test of minimum data")
    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstName(Student.firstName)
                .setLastName(Student.lastName)
                .setGender(Student.gender)
                .setNumber(Student.phone);
    }
}


