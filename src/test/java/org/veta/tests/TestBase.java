package org.veta.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    String firstName = "Veta",
            lastName = "Iuzykhovich",
            email = "veta@veta.com",
            phone = "1234567891",
            day = "10",
            month = "January",
            year = "2000";

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

}
