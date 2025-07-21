package tests;

import static data.TestDataGen.*;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.SuitTestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithPageObjectTests extends TestBase {
    SuitTestData data = new SuitTestData();


    @Test
    void successfulFillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .closeAd()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.eMail)
                .setGender(data.gender)
                .setNumber(data.phoneNumber)
                .setBirthDate(data.day, data.month, data.year)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .uploadPicture(file)
                .setAddress(data.streetAddress)
                .selectStateAndCity(data.state, data.city)
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Student Email", data.eMail)
                .verifyResult("Gender", data.gender)
                .verifyResult("Mobile", data.phoneNumber)
                .verifyResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .verifyResult("Subjects", data.subjects)
                .verifyResult("Hobbies", data.hobbies)
                .verifyResult("Picture", file)
                .verifyResult("Address", data.streetAddress)
                .verifyResult("State and City", data.state + " " + data.city);
    }

    @Test
    void successfulMinFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setNumber(data.phoneNumber)
                .submitForm();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", data.firstName + " " + data.lastName)
                .verifyResult("Gender", data.gender)
                .verifyResult("Mobile", data.phoneNumber);
    }

    @Test
    void negativeMinFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setNumber("")
                .submitForm();

        registrationPage.verifyResultsModalAppearsNeg();
    }

    ;
}



